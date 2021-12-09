package arithmetic.sorting;

import java.util.Arrays;

/**
 * @Description 插入排序:使用一个新的数组存储排好序的元素，然后从无序列表中一个一个地根据顺序插入到新数组中
 *                      新的有序数组中开始时有第一个元素
 *
 * @Author myf
 * @CreateDate 2021/12/7 14:10
 * @Version 1.0
 **/
public class InsertSorting extends Sort {

    public InsertSorting(int[] eles) {
        super(eles);
    }

    @Override
    public void sort() {
        //有序数组
        int[] newEles=new int[this.eles.length];
        newEles[0]=this.eles[0];
        for (int i = 1; i < this.eles.length; i++) {
            //新插入元素没有比已插入元素都大
            //有序数组中已添加的元素数量为i,即有效长度为i
            boolean flag=true;//标记要插入的元素是否比已存在元素都大
            for (int j = 0; j < i; j++) {
                //找到插入位置
                if (this.eles[i]<newEles[j]) {
                    //this.eles[i]元素要插入的位置就是j,j和j之后的位置都要后移一位
                    for (int k = i; k >= j+1; k--) {

                        newEles[k]=newEles[k-1];
                    }
                    //在j位置插入新元素
                    newEles[j]=this.eles[i];
                    flag=false;
                    break;
                }
            }
            //新插入元素比已插入元素都大时
            if (flag) {
                newEles[i]=this.eles[i];
            }
        }
        this.eles=newEles;
    }

    public static void main(String[] args) {
        int[] a=new int[]{2,20,4,1,4,9,15,7,23,56,44};
        InsertSorting insertSorting = new InsertSorting(a);
        System.out.println("before:"+ Arrays.toString(insertSorting.eles));
        insertSorting.sort();
        System.out.println("after:"+ Arrays.toString(insertSorting.eles));

    }
}
