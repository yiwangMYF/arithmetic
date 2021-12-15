package arithmetic.lockup;

/**
 * @Description 插值查找:是对二分查找的优化，通过修改mid的值减少递归的次数
 *                      二分查找中mid=(left+right)/2=left+(right-left)/2,在插值查找中
 *                      mid=left+((findValue-arr[left])/(arr[right]-arr[left]))*((right-left)/2)
 * @Author myf
 * @CreateDate 2021/12/15 10:08
 * @Version 1.0
 **/
public class InsertSearch extends Search {
    @Override
    public int search(int findValue) {
        return insertSearch(0,this.eles.length-1,findValue);
    }
    /**
    * @Author myf
    * @Description //TODO 插值查找实现
    * @Date 2021/12/15 10:17
    * @Param
    * @return
    */
    private int insertSearch(int left, int right, int findValue) {
        if (right<left) {
            return -1;
        }
        //取自适应mid
        int mid=left+((findValue-this.eles[left])/(this.eles[right]-this.eles[left]))*((right-left)/2);
        if (this.eles[mid] == findValue) {
            return mid;
        }else if (this.eles[mid] > findValue) {
            return insertSearch(left,mid-1,findValue);
        }else {
            return insertSearch(mid+1,right,findValue);
        }
    }

    public static void main(String[] args) {
        Search search = new InsertSearch();
        search.printEles();
        int index = search.search(search.eles[8]);
        if (index==-1) {
            System.out.println("未找到对应的值");
        }else {
            System.out.println("值所在index为："+index);
        }
    }
}
