package tree;

/**
 * Created by admin on 2017/9/20.
 */
/*
树节点（二叉树）
 */
public class TreeNode {
    public int val;
    public int data;
    public TreeNode left;
    public TreeNode right;
    boolean isFirst; //是否首次访问节点（用于非递归的后序遍历）

    public TreeNode(int data) {
        this.data = data;
    }

    public TreeNode() {
    }
}
