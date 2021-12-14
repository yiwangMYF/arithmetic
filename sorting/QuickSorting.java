package arithmetic.sorting;

import java.util.Arrays;

/**
 * @Description 快速排序：是对冒泡排序的改进。
 *                      基本思想：在序列中找一个数作为标志把序列中的数分为两部分，一部分大于等于该值，一部分小于该值
 *                              然后在这两部分重复该操作直到只有一个元素，此时序列就是有序的。
 *
 * @Author myf
 * @CreateDate 2021/12/8 10:53
 * @Version 1.0
 **/
public class QuickSorting extends Sort{

    public QuickSorting(int[] eles) {
        super(eles);
    }

    @Override
    public void sort() {
        realSort(0,this.eles.length-1);

    }
    /**
    * @Author myf
    * @Description //TODO 快速排序实际
    * @Date 2021/12/8 15:02
    * @Param
    * @return
    */
    private void realSort(int start, int end) {

        if (start>=end) {
            return;
        }
        int left=start;
        int right=end;
        int privot=this.eles[(left+right)/2];
        System.out.println("left:"+left+" right:"+right);
        System.out.println("a:"+Arrays.toString(this.eles));
        while (left<right){
            //找到左边大于等于参考值的位置
            while (this.eles[left]<privot) {
                left++;
            }
            while(this.eles[right]>privot) {
                right--;
            }
            //当左右指针相等时说明参考值两边已经区分好了，注：left<=(left+right)/2,right>=(left+right)/2
            if (left>=right) {
                break;
            }
            //进行值的交换
            int temp = this.eles[right];
            this.eles[right]=this.eles[left];
            this.eles[left]=temp;

            //避免出现left<right且arr[left]=arr[right]=privot时死循环
            if (this.eles[left]==privot) {
                right--;
            }
            if (this.eles[right]==privot) {
                left++;
            }

        }
        System.out.println(">>"+Arrays.toString(this.eles));
        if (left==right) {
            left++;
            right--;
        }

        //递归处理左右两边的排序
        realSort(left,end);
        realSort(start,right);



    }

    public static void main(String[] args) {
//        int[] a=new int[10];
//        for (int i = 0; i < a.length; i++) {
//            a[i]= (int) (Math.random()*100);
//        }
        int[] a=new int[]{45, 97, 92, 80, 74, 64, 72, 72, 31, 67};
        QuickSorting insertSorting = new QuickSorting(a);
        System.out.println("before:"+ Arrays.toString(insertSorting.eles));
        insertSorting.sort();
        System.out.println("after:"+ Arrays.toString(insertSorting.eles));

    }
}
