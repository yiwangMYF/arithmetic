package arithmetic.recursion;

import java.util.Arrays;

/**
 * @Description 八皇后问题解决
 * @Author myf
 * @CreateDate 2021/12/6 15:33
 * @Version 1.0
 **/
public class EightQueen {
    /**
     * 棋盘
     */
    int[] queenArrangement = new int[8];
    /**
     * 记录有多少种排列方法
     */
    private int count;
    /**
    * @Author myf
    * @Description //TODO 排列组合
    * @Date 2021/12/6 15:36
    * @Param
    * @return
    */
    public void pcQueen(){
        arrange(0);
        System.out.println(">>>count:"+this.count);
    }
    /**
    * @Author myf
    * @Description //TODO 递归进行排列组合
    * @Date 2021/12/6 22:34
    * @Param
    * @return
    */
    public void arrange(int n) {
        if (n>7) {
            System.out.println("---------------------------------");
            System.out.println(Arrays.toString(queenArrangement));
            System.out.println("---------------------------------");
            this.count++;
            return;
        }
        //找到第n+1个皇后(即第n+1行)的合适位置，n对应数组的下标
        for (int i = 0; i < 8; i++) {
            queenArrangement[n]=i;
            //第一行怎么放都可以
            if (n==0) {
                arrange(n+1);
            }else {
                //不是第一行的放上去后要判断是否合理
                if (checkOK(queenArrangement,n,i)) {
                    arrange(n+1);
                }
            }

        }

    }

    /** 校验第i+1行，j+1列上是否可以放棋子
     *
     * @param queenArrangement 已存在的排列情况，数组下标为行，值为列
     * @param i 第i+1行，0<=i<=7
     * @param j 第j+1列,0<=j<=7
     * @return
     */
    public boolean checkOK(int[] queenArrangement,int i,int j){

        for (int k = 0; k < i; k++) {
            /**
             * 同行、同列及同斜线上都不可
             */
            if (k==i||queenArrangement[k]==j || Math.abs(i-k)==Math.abs(j-queenArrangement[k])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        EightQueen eightQueen = new EightQueen();
        eightQueen.pcQueen();
    }
}
