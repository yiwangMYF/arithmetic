package arithmetic.lockup;

import arithmetic.sorting.QuickSorting;

/**
 * @Description 查找统一父类
 * @Author myf
 * @CreateDate 2021/12/14 16:06
 * @Version 1.0
 **/
public abstract class Search {

    protected int[] eles=new int[20];
    {
        for (int i = 0; i < this.eles.length; i++) {
            this.eles[i]= (int) (Math.random()*10000);
        }
        //排序
        QuickSorting quickSorting = new QuickSorting(this.eles);
        quickSorting.sort();
        this.eles=quickSorting.getEles();
    }
    /**
    * @Author myf
    * @Description //TODO 
    * @Date 2021/12/14 16:19
    * @Param 
    * @return 
    */
    public abstract int search(int findValue);
    /**
    * @Author myf
    * @Description //TODO 打印序列
    * @Date 2021/12/14 16:15
    * @Param
    * @return
    */
    public void printEles(){
        System.out.println("=========================================");
        for (int i = 0; i < this.eles.length; i++) {
            System.out.print("index:"+i+" ,value:"+this.eles[i]+"   ");
        }
        System.out.println("=========================================");
    }
}
