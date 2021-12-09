package arithmetic.sorting;

import java.util.Arrays;

/**
 * @Description 选择排序：从无序序列中找到最小的值与当前轮的值进行交换，
 *                       如第一轮中找到arr[1]~arr[n]中的最小值与arr[0]值进行交换。
 *                       需要进行的轮数为n-1，n为序列的长度
 * @Author myf
 * @CreateDate 2021/12/7 11:28
 * @Version 1.0
 **/
public class SelectSorting extends Sort{

    public SelectSorting(int[] eles) {
        super(eles);
    }

    @Override
    public void sort() {
        long start=System.currentTimeMillis();
        //需要进行n-1次选择
        for (int i = 0; i < this.eles.length-1; i++) {
            //存储本轮最小值的下标
            int minIndex=i;
            for (int j = i+1; j < this.eles.length; j++) {
                if (this.eles[minIndex]>this.eles[j]) {
                    minIndex=j;
                }
            }
            //找到最小值的下标
            if (minIndex!=i) {
                //进行交换,i与minIndex
                int temp=this.eles[minIndex];
                this.eles[minIndex]=this.eles[i];
                this.eles[i]=temp;
            }
        }
        long end=System.currentTimeMillis();
        System.out.println("》》》》》耗时："+String.valueOf(end-start));

    }


    public static void main(String[] args) {
        int[] a=new int[]{2,20,4,1,4,9,15,7,23,56,44};
        Sort selectSorting = new SelectSorting(a);
        System.out.println("before:"+ Arrays.toString(a));
        selectSorting.sort();
        System.out.println("after:"+ Arrays.toString(a));
    }
}
