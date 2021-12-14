package arithmetic.sorting;

import java.util.Arrays;

/**
 * @Description 基数排序：对桶排序的优化，只适用于正整数的排序
 *                      1.找出序列位数最大的（找到最大数取字符长度）;
 *                      2.创建一个二维数组，rows=10,cols=序列元素的个数，行表示的是index为0-9的桶，列表示的是每个桶中用于存放数据的数组长度。
 *                        同时创建一个一维数组用于记录每个桶中放入的元素个数，长度为10
 *                      3.遍历元素，从低位开始（个位开始）取位上的值，位上的值与桶所对应的下标相同时元素放入该桶中，然后遍历二维数组输出序列放入原序列对应位置。
 *
 *
 * @Author myf
 * @CreateDate 2021/12/14 14:37
 * @Version 1.0
 **/
public class RadixSorting extends Sort {
    public RadixSorting(int[] eles) {
        super(eles);
    }

    @Override
    public void sort() {
        //找到序列的最大值
        int max=this.eles[0];
        for (int i = 1; i < this.eles.length; i++) {
            if (max<this.eles[i]) {
                max=this.eles[i];
            }
        }
        //序列最大位数
        int maxDigits = String.valueOf(max).length();

        //创建二维数组辅助排序
        int[][] tenBuckets= new int[10][this.eles.length];
        //用于记录每个桶中放入元素的个数
        int[] count= new int[10];


        for (int i = 0,n=1; i < maxDigits; i++,n=n*10) {
            //取值放桶里
            for (int j = 0; j < this.eles.length; j++) {
                //取位上的值
                int value=this.eles[j]/n%10;
                tenBuckets[value][count[value]++] = this.eles[j];
            }
            //将桶里元素输出到原数组
            int index=0;
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < count[j]; k++) {
                    this.eles[index++]=tenBuckets[j][k];
                }
            }
            //将记录桶清空
            count=new int[10];
        }
    }

    public static void main(String[] args) {
        int[] a=new int[]{29,20,74,1,4,10,15,7,23,56,44,28,77,5,20};
        RadixSorting radixSorting = new RadixSorting(a);
        System.out.println("before:"+ Arrays.toString(radixSorting.eles));
        radixSorting.sort();
        System.out.println("after:"+ Arrays.toString(radixSorting.eles));

    }
}
