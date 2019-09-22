package Heap;

import java.util.Arrays;

/**
 * @ClassName TestHeap
 * @Description TODO
 * @Auther danni
 * @Date 2019/9/22 11:15]
 * @Version 1.0
 **/

public class TestHeap {
    //大堆
    public static void shiftDownBig(int[] array,int index,int size){
        int left=index*2+1;
        while(left<size){
            int right=left+1;
            if(right<size){
                int max=right;
                if(array[left]>array[right]){
                    max=left;
                }
                if(array[index]<array[max]){
                    swamp(array,index,max);
                    index=max;
                    left=index*2+1;
                }else{
                    break;
                }
            }
        }
    }
    //小堆
    public static void shiftDownSmall(int[] array,int index,int size){
        int left=index*2+1;
        while(left<size){
            int right=left+1;
            if(right<size){
                int min=left;
                if(array[left]>array[right]){
                    min=right;
                }
                if(array[index]>array[min]){
                   swamp(array,index,min);
                    index=min;
                    left=index*2+1;
                }else{
                    break;
                }
            }
        }
    }
    //构建小堆
    public static void createHeapSmall(int[] array,int size){
        for(int i=(size-1)/2;i>0;i--){
            shiftDownSmall(array,i,size);
        }
    }
    //构建大堆
    public static void createHeapBig(int[] array,int size){
        for (int i = (size-1)/2; i >0 ; i--) {
            shiftDownBig(array,i,size);
        }
    }
    private static void swamp(int[] array, int index, int m) {
        int temp=array[index];
        array[index]=array[m];
        array[m]=temp;
    }
    //优先级队列应用-优先选择排序(升序）
    public void  heapSort(int[] array){
        createHeapBig(array,array.length);
        for (int i = 0; i <array.length-1 ; i++) {
            swamp(array,0,array.length-i-1);
            TestHeap.shiftDownBig(array,0,array.length-i-1);
        }
    }

    public static void main(String[] args) {
        TestHeap heap=new TestHeap();
        int[] array={39,15,3,18,40,5,6,51,52,70};
        int size=array.length;
        shiftDownSmall(array,0,size);
        System.out.println(Arrays.toString(array));

    }
}
