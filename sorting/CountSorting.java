package arithmetic.sorting;

import java.util.Arrays;

/**
 * @Description 计数排序：首先找出序列中最大的元素max，然后创建一个长度为max+1的数组temp,
 *                      遍历原序列，将原序列中元素的值作为temp中的index,value为该值在原序列中出现的次数，
 *                      即每出现一个元素value时temp[value]++。遍历完后开始输出，将temp数组中的值输出到新的结果数组中，
 *                      当temp[value]>0时，循环将value放入结果数组知道temp[value]=0。最后的结果数组就是排好序的序列。
 *                      注：计数排序只能排序非负整数
 * @Author myf
 * @CreateDate 2021/12/9 15:43
 * @Version 1.0
 **/
public class CountSorting extends Sort {

    public CountSorting(int[] eles) {
        super(eles);
        if (!check(eles)) {
            throw new RuntimeException("非法参数，计数排序只支持非负整数序列的排序");
        }
    }
    /**
    * @Author myf
    * @Description //TODO 校验是否支持该序列的排序
    * @Date 2021/12/9 16:03
    * @Param
    * @return
    */
    private boolean check(int[] eles) {
        for (int i = 0; i < eles.length; i++) {
            if (eles[i]<0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void sort() {
        //找到序列中的最大值
        int max=0;
        for (int i = 0; i < this.eles.length; i++) {
            if (this.eles[i]>max) {
                max=this.eles[i];
            }
        }
        //创建临时数组
        int[] temp=new int[max+1];
        for (int i = 0; i < this.eles.length; i++) {
            temp[this.eles[i]]++;
        }
        int k=0;
        for (int i = 0; i < temp.length; i++) {
            while(temp[i]>0){
                this.eles[k++]=i;
                temp[i]--;
            }
        }
    }
    public static void main(String[] args) {
        int[] a=new int[]{29,20,74,1,4,10,15,7,23,56,4};
        CountSorting countSorting = new CountSorting(a);
        System.out.println("before:"+ Arrays.toString(countSorting.eles));
        countSorting.sort();
        System.out.println("after:"+ Arrays.toString(countSorting.eles));

    }
}
