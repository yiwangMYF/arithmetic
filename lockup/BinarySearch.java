package arithmetic.lockup;

import arithmetic.sorting.QuickSorting;

/**
 * @Description 二分查找：针对于有序序列
 *                       1.找到序列中间下标mid，将其值与要查找的值进行比对，相等则直接返回,
 *                          不相等时若小于mid位置对应的值则从left~mid-1区间进行查找，否则从mid+1~right区间查找
 *                          当left<right时说明找不到元素
 *
 * @Author myf
 * @CreateDate 2021/12/14 15:57
 * @Version 1.0
 **/
public class BinarySearch extends Search {

    @Override
    public int search(int findValue) {
        return binarySearch(0,this.eles.length-1,findValue);
    }
    /**
    * @Author myf
    * @Description //TODO 二分查找实现
    * @Date 2021/12/14 16:19
    * @Param 
    * @return 
    */
    private int binarySearch(int left, int right, int findValue) {
        if (left>right) {
            return -1;
        }
        int mid=(left+right)/2;
        if (this.eles[mid]==findValue) {
            return mid;
        }else if (this.eles[mid]>findValue) {
            //要查找的值小于中间值则递归查找左边
            return binarySearch(left,mid-1,findValue);
        }else {
            return binarySearch(mid+1,right,findValue);
        }
    }

    public static void main(String[] args) {
        Search search = new BinarySearch();
        search.printEles();
        int index = search.search(search.eles[8]);
        if (index==-1) {
            System.out.println("未找到对应的值");
        }else {
            System.out.println("值所在index为："+index);
        }
    }
}
