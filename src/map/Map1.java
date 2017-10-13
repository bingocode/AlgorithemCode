package map;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by admin on 2017/9/25.
 */
/*
采用邻接表实现的图（对于节点数量很大的一般都是使用邻接表而不是邻接矩阵
 */
public class Map1 {
    ArrayList<MapNode> Adj[]; //邻接表
    int n;//顶点数
    boolean isvisited[]; //用于dfs标记节点是否被访问
    boolean isinqueue[]; //用于bfs标记节点是否入过队列。
    boolean isvis[]; //用于Dijskstra中的已访问节点集合
    ArrayList<Integer>[] pre; //用于Dijsktra中存放从起点到顶点v的最短路径上v的前一个顶点（最短路径上的驱节点）,之所以用ArrayList因为最短路径可能不止一条。
    int[] d; //用于存放Dijkstra算法中的起点s到其他点的最短距离
    int[][] dis; //用于Floyed算法存储i，j的最短距离。

    public Map1(int n) {
        this.n = n;
        Adj = new ArrayList[n];
        isvisited = new boolean[n];
        isinqueue = new boolean[n];
        isvis = new boolean[n];
        d = new int[n];
        pre = new ArrayList[n];
        dis = new int[n][n];
        for(int i = 0; i < n; i++ ){
            Adj[i] = new ArrayList<MapNode>();
            pre[i] = new ArrayList<Integer>();
            isvisited[i] = false;
            isinqueue[i] = false;
            isvis[i] = false;
        }
        for(int i = 0; i< n; i++){
            for(int j = 0; j< n;j++){
                if(i == j)
                    dis[i][j] = 0;
                else
                    dis[i][j] = Integer.MAX_VALUE;
            }
        }

    }

    //添加一条从start开始的边
    public void addAdj(int start,MapNode node){
        Adj[start].add(node);
        dis[start][node.v] = node.w;
    }

    /**
     * DFS:将经过的节点设置为已访问，下次递归碰到就不去处理这个节点。
     * 所以要遍历整个图也要考虑所有连通块进行遍历，若是个连通图，则只要一次就可以遍历完，否则就会要很多次。
     */
    public void dfsmap(){
        for(int u = 0; u<n; u++){
            if(isvisited[u] == false){
                dfs(u);
            }
        }
    }
    public  void dfs(int start){
        isvisited[start] = true;
        System.out.print(start +" ");
        for(int i = 0; i< Adj[start].size(); i++){
            int v = Adj[start].get(i).v;
            if(!isvisited[v]){
                dfs(v);
            }
        }
    }

    /**
     * BFS：利用队列，通过反复取出队首元素，将该顶点可到达的未曾加入过队列的顶点全部入队直到队列为空时遍历结束。
     * 同样若是连通图一次就可以，但若不是连通图则要对所有连通块进行遍历。
     */
    public void bfsmap(){
        for(int u = 0; u< n; u++){
            if(!isinqueue[u])
            bfs(u);
        }
    }

    public void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start); //入队
        isinqueue[start] = true;
        while (!q.isEmpty()){
            int u = q.poll(); //移除并取出队首元素
            System.out.print(u + " ");
            for(int i = 0; i< Adj[u].size(); i++){
                int v = Adj[u].get(i).v;
                if(!isinqueue[v]){
                    q.add(v);
                    isinqueue[v] = true;
                }
            }
        }
    }

    /**
     * 最短路径：求一条从起点到终点的路径，是的这条路径上经过的所有边的权重之和最小。
     */

    /**Dijkstra:解决单源最短路（给定起始点s,求s到其他每个顶点的最短距离）
     * 策略：设图G（V，E），集合S存放已经访问的顶点，然后执行n次以下两个步骤
     * 1）每次从V-S（未访问）顶点选择与起点s最短距离的一个顶点u，访问它并加入S
     * 2）另u为中介点优化s与所有从u能到达的顶点v之间的最短距离。
     * 具体实现：
     * 集合S： boolean vis[n],int d[]表示起点到指定点的最短距离（动态变化，初始化：d[s] =0,其他赋值很大的数Int.Max）
     * 扩展：有时候会遇到边有多个权重（距离，价格）点权重第二标尺等还有求最短路径数量，所以一般的解决方案是：
     * 1）利用pre数组，先在Dijkstra中记录所有最短路径（只考虑距离）。
     * 2）遍历所有最短路径对pre数组，找出一条使第二标尺最优的路径。（其实会形成一个遍历树，每条从根节点到叶子节点形成的一条链便是一条最短路，对这些链以第二标尺进行比较筛选出最优路径）
     * @param s
     */
    public void ShortestPath1(int s, int e){
        Dijkdtra(s);
        System.out.println("从起点"+s+"到d[i]（0~n)的最短路径长分别为：");
        for(int i =0 ;i< d.length; i++){
//            System.out.print(pre[i] + " ");
            System.out.print(d[i] + " ");
        }
        System.out.println("\n每个节点的前驱：");
        for(int i = 0; i< pre.length; i++){
            System.out.print(pre[i] + " ");
        }
        System.out.println("\n从起点"+s+"到点"+e+"的最短路径是：");
        DFSDijkstra(s,e);
    }
    private void Dijkdtra(int s) {
        //初始化s点到其他点的最短距离（自身为0）以及每个节点的前驱
        for (int i = 0; i < n; i++) {
            if (i == s)
                d[i] = 0;
            else
                d[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < n; i++) {
            int u = -1, min = Integer.MAX_VALUE; //u存放短路径下标，min存放最小的d[u]
            for (int j = 0; j < n; j++) {
                if (isvis[j] == false && d[j] < min) {  //找到未被访问的顶点中d[]最小的（即与s路径最短的顶点u）
                    u = j;
                    min = d[j];
                }
            }
            if (u == -1) return;
            ;
            isvis[u] = true; //标记u已经被访问
            for (int j = 0; j < Adj[u].size(); j++) {
                int v = Adj[u].get(j).v;
                if (isvis[v] == false) {
                    if (d[u] + Adj[u].get(j).w < d[v]) {    //若v顶点未访问且以u为中介点可以使d[v]更优，则更新
                        d[v] = d[u] + Adj[u].get(j).w;
                        pre[v].clear();
                        pre[v].add(u);
                    } else if (d[u] + Adj[u].get(j).w == d[v])
                        pre[v].add(u);
                }
            }
        }
    }
    //输出最短路径(待优化。。根据第二标尺遍历出所有最短路径）
    private void DFSDijkstra(int s, int v){
        if(s == v){
            System.out.print(s + " ");
            return;
        }
        DFSDijkstra(s,pre[v].get(0));
        System.out.print(v+" ");
    }

    /*
    若出现了负数权重的边，则不能用Dijkstra而应该用BF算法：
    BF算法：也是解决单源最短路问题，也能解决负权边问题。9
     */

    /*
    Floyd算法：全源最短路问题：求图中任意两点之间的最短路径长度。时间复杂度在O（n3）,因此n限制在了200？可以使用邻接矩阵实现比较方便。思想：
    以dis[i][j] 表示i ,j 的最短路径长度。若存在顶点k，使得以k为中间点可以使得i和j的当前最短距离缩短，则更新dis[i][j]= dis[i][k] + dis[k][j];
     */
    public  void Floyd(){
        for(int k = 0; k<n; k++ )
            for(int i =0; i <n; i++)
                for(int j=0; j<n; j++){
                if(dis[i][k]!= Integer.MAX_VALUE && dis[k][j] != Integer.MAX_VALUE && dis[i][k] + dis[k][j] < dis[i][j])
                    dis[i][j] = dis[i][k] + dis[k][j];
                }
                for(int i =0; i< n; i++)
                    for(int j =0; j<n; j++){
                    System.out.print(dis[i][j] + " ");
                    }
    }
    /*
    最小生成树：无向图中的一颗拥有所有图节点且整个树边权和最小的树（可以不唯一但边权和唯一），一般会考察给定根节点的最小生成树。
    性质：边的数量 = 定点数 -1
    prim方法：适合稀疏图 （边少）O（n2）
    kruskal算法：适合稠密图，点，边多（O（longn）
   (边贪心）
     */

    /*
    有向无环图的拓扑排序；
    应用：判断给定图是否是有向无环图。
     */

    /*
    关键路径
     */

    public static void main(String[] args){
        Map1 map = new Map1(6);
        map.addAdj(0,new MapNode(1,1));
        map.addAdj(0,new MapNode(3,4));
        map.addAdj(0,new MapNode(4,4));
        map.addAdj(1,new MapNode(3,2));
        map.addAdj(2,new MapNode(5,1));
        map.addAdj(3,new MapNode(2,2));
        map.addAdj(3,new MapNode(4,3));
        map.addAdj(4,new MapNode(5,3));
        map.Floyd();
    }
}
