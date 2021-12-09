package arithmetic.sorting;

/**
 * @Description
 * @Author myf
 * @CreateDate 2021/12/7 11:33
 * @Version 1.0
 **/
public abstract class  Sort {
    //存储排序的序列
    protected int[] eles;

    public  Sort(int[] eles) {
        this.eles = eles;
    }

    /**
    * @Author myf
    * @Description //TODO 排序
    * @Date 2021/12/7 11:34
    * @Param
    * @return
    */
    public abstract void sort();
}
