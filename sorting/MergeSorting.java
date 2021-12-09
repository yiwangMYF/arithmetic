package arithmetic.sorting;

import java.util.Arrays;

/**
 * @Description 归并排序：归并排序是基于分治思想将长序列分成更小的序列进行排序然后再合并。
 *                      将序列不断分成左右两个序列(left,mid)和(mid+1,right)，其中mid=(left+right)/2,递归进行直到序列只有一个不再进行切割，
 *                      接着开始合并操作。
 *                      合并的过程：合并的两个序列各自都是有序的（一开始只有一个元素肯定是有序的，然后多个元素时由于序列经过前面的合并
 *                      也是有序的），定义i,j,i=left,j=mid+1,即两个序列的各自开始索引，比较arr[i]和arr[j]，将更小的一个放入临时数组然后更小的对应
 *                      的index++,知道i==mid或j==right结束，此时两个序列还有未放入临时数组的将其全部放入临时数组。最后将
 *                      临时数组的数据按顺序拷贝到原数组（由于分割时是按照原数组从index小到大的左右分割，合并后还是index从小到大，位置是对应的）
 *
 * @Author myf
 * @CreateDate 2021/12/9 10:44
 * @Version 1.0
 **/
public class MergeSorting extends Sort{

    public MergeSorting(int[] eles) {
        super(eles);
    }

    @Override
    public void sort() {
        mergeSort(0,this.eles.length-1);

    }
    /**
    * @Author myf
    * @Description //TODO 归并排序实现
    * @Date 2021/12/9 11:07
    * @Param
    * @return
    */
    private void mergeSort(int left, int right) {
        //当left==right时序列只有一个元素，不再进行分割而是要开始进行合并
        if (left<right) {
            int mid=(left+right)/2;
            //递归分割
            mergeSort(left,mid);
            mergeSort(mid+1,right);
            //左右两个序列开始进行合并
            merging(left,mid,right);

        }
    }
    /**
    * @Author myf
    * @Description //TODO 合并操作
    * @Date 2021/12/9 11:21
    * @Param
    * @return
    */
    private void merging(int left, int mid, int right) {
        System.out.println("left:"+left+"right:"+right);
        //创建临时数组
        int[] temp= new int[right-left+1];
        int i=left;
        int j=mid+1;
        int k=0;
        while(i<=mid && j<=right) {
            while(this.eles[i]<=this.eles[j]) {
                //左边序列元素值小于右边序列的值
                temp[k++]=this.eles[i];
                i++;
                if (i>mid) {
                    break;
                }
            }
            //当i>mid时左边已经全部加入临时数组了，即左边全部小于右边的第一个元素两个序列组在一起直接有序
            if (i>mid) {
                break;
            }
            while (this.eles[i]>this.eles[j]) {
                temp[k++]=this.eles[j];
                j++;
                if (j>right) {
                    break;
                }
            }
        }
        //将还未放入临时数组的数据加入临时数组，此时肯定有一边已经全部加入了临时数组
        if (i>mid) {
            while(j<=right){
                temp[k++]=this.eles[j++];
            }
        }
        if (j>right) {
            while(i<=mid){
                temp[k++]=this.eles[i++];
            }
        }
        //将临时数组的数据复制到原数组
        System.out.println(Arrays.toString(temp));
        int m=0;
        for (int l = left; l <=right ; l++) {
            this.eles[l]=temp[m++];
        }
    }

    public static void main(String[] args) {
        int[] a=new int[]{29,20,74,1,4,10,15,7,23,56,44};
        MergeSorting mergeSorting = new MergeSorting(a);
        System.out.println("before:"+ Arrays.toString(mergeSorting.eles));
        mergeSorting.sort();
        System.out.println("after:"+ Arrays.toString(mergeSorting.eles));

    }

}
