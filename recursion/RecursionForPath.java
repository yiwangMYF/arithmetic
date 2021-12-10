package arithmetic.recursion;

/**
 * @Description 递归解决迷宫相关问题
 * @Author myf
 * @CreateDate 2021/12/3 10:00
 * @Version 1.0
 **/
public class RecursionForPath {
    //定义迷宫,使用二维数组表示，0-未走过，1-墙，2-可走，3-不可到达
    private int[][] map;
    //迷宫的长度
    private int rows;
    //迷宫的宽度
    private int cols;
    //目的地位置的i索引
    private int reachI;
    //目的地位置的j索引
    private int reachJ;

    public RecursionForPath(int rows, int cols, int reachI, int reachJ) {
        this.rows = rows;
        this.cols = cols;
        this.reachI = reachI;
        this.reachJ = reachJ;
        //初始化迷宫
        this.init();
    }
    /**
    * @Author myf
    * @Description //TODO 初始化迷宫
    * @Date 2021/12/3 10:08
    * @Param
    * @return
    */
    private void init() {
        this.map=new int[this.rows][this.cols];

        if (this.reachI<0||this.reachI>this.rows-1) {
            throw new RuntimeException("初始化异常,要到达的地址越界！");
        }
        if (this.reachJ<0||this.reachJ>this.cols-1) {
            throw new RuntimeException("初始化异常,要到达的地址越界！");
        }
        //创建围墙，这里只创建最外层一圈墙
        for (int i = 0; i < this.cols; i++) {
            this.map[0][i]=1;
            this.map[this.rows-1][i]=1;
        }

        for (int i = 0; i < this.cols; i++) {
            this.map[i][0]=1;
            this.map[i][this.cols-1]=1;
        }
    }
    /**
    * @Author myf
    * @Description //TODO 遍历地图
    * @Date 2021/12/3 10:16
    * @Param
    * @return
    */
    public void showMap(){
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                System.out.print(this.map[i][j]+" ");
            }
            System.out.println();
        }
    }

    /**
    * @Author myf
    * @Description //TODO 判断从指定位置是否能够到达目的地,右下左上
    * @Date 2021/12/3 10:22
    * @Param 
    * @return 
    */
    public boolean canReach(int i,int j){
        //校验参数
        if (i<0||i>this.rows-1||j<0||j>this.cols-1) {
            throw new RuntimeException("参数错误");
        }
        if (i==this.reachI&&j==this.reachJ) {
            //到达目的地
            return true;
        }
        if (this.map[i][j]==1) {
            //起点为墙
            return false;
        }else if (this.map[i][j]==2) {
            //为2时表示以前走过，不重复
            return false;
        }else if (this.map[i][j]==3){
            //为3时表示该点不可到达目的地
            return false;
        }else {
            //为0，表示未走过
            this.map[i][j]=2;
            if (canReach(i,j+1)) {
                return true;
            }else if (canReach(i+1,j)){
                return true;
            }else if (canReach(i,j-1)) {
                return true;
            }else if (canReach(i-1,j)) {
                return true;
            }else{
                this.map[i][j]=3;
                return false;
            }
        }
    }

    public static void main(String[] args) {
        RecursionForPath recursionForPath = new RecursionForPath(10, 10, 6, 6);
        recursionForPath.showMap();
        recursionForPath.canReach(1,1);
        System.out.println("----------------------------------");
        recursionForPath.showMap();
    }
}
