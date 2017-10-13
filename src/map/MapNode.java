package map;

/**用于邻接表的边的节点
 * Created by admin on 2017/9/25.
 */
public class MapNode {
    int v; //边的终点节点编号
    int w; //边权

    public MapNode(int v, int w) {
        this.v = v;
        this.w = w;
    }
}
