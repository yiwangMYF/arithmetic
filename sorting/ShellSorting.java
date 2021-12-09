package arithmetic.sorting;

import java.util.Arrays;

/**
 * @Description 希尔排序：将序列分成gap组，gap也是每组内元素间隔距离（步长），
 *                         gap=n/2^x(x>=1&&x<=log2^n)向下取整,gap=1时变成插入排序。
 *                         分组后对每组内的元素使用插入排序进行排序。接着重新计算gap和分组，再
 *                         进行组内插入排序，知道gap=0时结束。
 *
 * @Author myf
 * @CreateDate 2021/12/7 15:31
 * @Version 1.0
 **/
public class ShellSorting extends Sort {

    public ShellSorting(int[] eles) {
        super(eles);
    }

    @Override
    public void sort() {
        for (int gap = this.eles.length/2; gap >0 ; gap=gap/2) {
            //分组后进行组内插入排序
            /**
             * 分组后，对于内个组内元素的个数为this.eles/gap.
             * 将前面gap个元素当做各组内已经插入的有序数组中的第一个元素，从index为gap（即第gap+1个元素开始进行插入）
             * index为i的元素（要插入元素）的前一个组内元素下标为i-gap,组内每个元素间隔gap
             * 因为组内有序数组从小达到排序，则从后往前开始进行比较，若当前要插入元素大于最后一个元素则不变动，
             * 否则往前遍历组内元素直到找到第一个大于的有序元素，该有序元素的index+gap开始往后的元素往后移动，index+gap位置
             * 值为要插入元素值,若组内有序序列每个元素都小于要插入元素则将有序序列全部后移，要插入元素插入组内第一个位置
             * 注：总共组数为gap,则有序序列第一个元素index<gap
             *
             */
            for (int i = gap; i < this.eles.length; i++) {
                //从要插入元素的组内有序元素的末尾开始查找可插入位置，
                for (int j = i-gap; j >=0 ; j=j-gap) {
                    if (this.eles[i]>this.eles[j]) {
                        //要插入元素大于有序序列中的元素，则在本组有序队列中从j+gap到i-gap的元素都要往后移动一位，
                        //要插入元素放入j+gap的位置
                        int temp= this.eles[i];
                        for (int k = i-gap; k>=j+gap ; k=k-gap) {
                            this.eles[k+gap]=this.eles[k];
                        }
                        this.eles[j+gap]=temp;
                        break;
                    }
                    //组内有序序列都比要插入元素大，这在找到组内有序第一个元素时组内有序元素全部后移
                    if (j<gap) {
                        //组内有序序列的第一个
                        int temp= this.eles[i];
                        for (int k = i-gap; k >=j; k=k-gap) {
                            this.eles[k+gap]=this.eles[k];
                        }
                        this.eles[j]=temp;
                        break;
                    }
                }


            }

        }
    }
    public static void main(String[] args) {
        int[] a=new int[]{2,20,4,1,4,9,15,7,23,56,44};
        ShellSorting shellSorting = new ShellSorting(a);
        System.out.println("before:"+ Arrays.toString(shellSorting.eles));
        shellSorting.sort();
        System.out.println("after:"+ Arrays.toString(shellSorting.eles));

    }
}
