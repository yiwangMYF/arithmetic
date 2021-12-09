package arithmetic.sorting;

import java.util.Arrays;

/**
 * @Description 冒泡排序：两两相邻的元素进行比较若前面的比后面的更大就进行交换，
 *                      这样没经过一次遍历交换就会把未完成排序的部分中最大的
 *                      元素放到了最后的位置。这样一趟需要比较的次数为n-i(n为要排序的序列长度，i为第几趟排序)，
 *                      总共要排序的趟数为n-1(最后一个元素在其他元素排好序后已经是最小的了)
 *                      优化：当一趟冒泡中没有发生过交换则说明当前序列已经有序则退出比较
 *                      
 *                     
 * @Author myf
 * @CreateDate 2021/12/7 10:22
 * @Version 1.0
 **/
public class BubbleSorting {
    
    private int[] eles;

    public BubbleSorting(int[] eles) {
        this.eles = eles;
    }
    /**
    * @Author myf
    * @Description //TODO 排序
    * @Date 2021/12/7 10:42
    * @Param 
    * @return 
    */
    public void sort(){
        long start=System.currentTimeMillis();
        //记录比较次数
        int c=0;
        for (int i = 0; i < eles.length-1; i++) {
            //若一趟排序中没有发生过交换则说明已经有序则不再进行遍历比较
            int count=0;
            for (int j = 0; j < eles.length-1-i; j++) {
                c++;
                if (eles[j]>eles[j+1]) {
                    int temp=eles[j+1];
                    eles[j+1]=eles[j];
                    eles[j]=temp;
                    count++;
                }
            }
            if (count==0) {
                break;
            }
        }
        long end=System.currentTimeMillis();
        System.out.println("》》》》》耗时："+String.valueOf(end-start));
        System.out.println("c:"+c);
    }


    public static void main(String[] args) {
        int[] a=new int[]{2,20,4,1,4,9,15,7,23,56,44};
        BubbleSorting bubbleSorting = new BubbleSorting(a);
        System.out.println("before:"+ Arrays.toString(a));
        bubbleSorting.sort();
        System.out.println("after:"+ Arrays.toString(a));

    }
}
