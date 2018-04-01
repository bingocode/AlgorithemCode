package tree;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by admin on 2017/9/20.
 */
/*
二叉树
参考：https://github.com/githubofrico/DataStructure/blob/master/src/cn/edu/tju/rico/tree/BinaryTree.java
 */
public class BinaryTree {
    private TreeNode root;

    public BinaryTree() {
        root = null;
    }
    /*
    根据一个树的根节点复制来构造树
     */

    private static ArrayList<ArrayList<Integer>> listall = new ArrayList<ArrayList<Integer>>();
    private static ArrayList<Integer> list = new ArrayList<>();

    /**
     * 查找和为target的所有路径
     * @param root
     * @param target
     * @return
     */
    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target){
        if(root == null)
            return  listall;
        list.add(root.val);
        target = target - root.val;
        if(target == 0 && root.left == null && root.right == null)
            listall.add(new ArrayList<Integer>(list));
        FindPath(root.left,target);
        FindPath(root.right,target);
        list.remove(list.size() - 1);
        return listall;
    }
    public BinaryTree(TreeNode root) {
        this.root = copy(root);
    }

    /**
     *根据一个树的前序遍历（Pre）+中序遍历（In）或中序遍历+后序遍历复制构造
     * @param s1 比如若是Pre遍历结果为字符串"12439"(没有空格)
     * @param s2
     * @param isPreIn （是否是前序遍历+中序遍历）
     */
    public BinaryTree(String s1, String s2,boolean isPreIn){
        if(isPreIn){
            root = createBinaryTreeByPreAndIn(s1, s2);
        }
        else{
            root = createBinaryTreeByInAndPost(s1, s2);
        }
    }

    /**
     * 根据前序遍历，中序遍历结果重建二叉树
     * @param pre
     * @param in
     * @return
     */
    public TreeNode createBinaryTreeByPreAndIn(String pre,String in){
        if(pre.length() > 0){
            TreeNode root = new TreeNode(pre.charAt(0));
            int index = in.indexOf(pre.charAt(0));//找到左右子树的分界点
            root.left = createBinaryTreeByPreAndIn(pre.substring(1, index + 1),
                    in.substring(0, index));
            root.right = createBinaryTreeByPreAndIn(
                    pre.substring(index + 1, pre.length()),
                    in.substring(index + 1, in.length()));
            return root;
        }
        return null;
    }

    /**
     * 根据中序遍历，后序遍历结果重新构建树
     * @param in
     * @param post
     * @return
     *
     */
    public TreeNode createBinaryTreeByInAndPost(String in, String post){
        if(post.length() > 0){
            TreeNode root = new TreeNode(post.charAt(post.length() - 1));
            int index = in.indexOf(post.charAt(post.length() - 1));
            root.left = createBinaryTreeByInAndPost(in.substring(0, index),
                    post.substring(0, index));
            root.right = createBinaryTreeByInAndPost(
                    in.substring(index + 1, in.length()),
                    post.substring(index, post.length() - 1));
        }
        return null;

    }
    /**
     * @description 根据广义表表达式创建树
     * @param exp 广义表
     */
    public void createBinaryTree(String exp) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>(); // 辅助栈
        TreeNode node = null; // 新结点
        TreeNode temp = null; // 用于入栈
        TreeNode parent = null; // 父亲结点
        boolean flag = false; // true 表示链入到父结点的左孩子位置，false表示链入父结点的右孩子位置

        for (int i = 0; i < exp.length(); i++) { // 逐个读入表达式的各个字符
            char c = exp.charAt(i);
            switch (c) {
                case '(': // 当前节点有孩子节点，入栈以便设置其孩子
                    stack.push(temp);
                    flag = true;
                    break;
                case ')': // 设置好了栈顶节点的孩子，出栈
                    stack.pop();
                    break;
                case ',': // 当前节点无孩子，不需要设置其孩子节点，因此不需要入栈
                    flag = false;
                    break;
                default: // 创建根据内容创建节点
                    node = new TreeNode(c);
                    break;
            }

            // 若树不存在，则创建树的根结点
            if (root == null) {
                root = node;
            }

            // 为栈顶节点链入子女
            if (!stack.isEmpty()) {
                if (node != null) { // 当读入的是'('、')'、','字符时，略过
                    parent = stack.peek();
                    if (flag) {
                        parent.left = node;
                    } else {
                        parent.right = node;
                    }
                }
            }

            temp = node; // 用于入栈
            node = null; // node链入后，置空
        }
    }

    /**
     * @description 根据广义表表达式创建树
     * @param exp 广义表
     */
    public static TreeNode createBinaryTree(String exp, TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>(); // 辅助栈
        TreeNode node = null; // 新结点
        TreeNode temp = null; // 用于入栈
        TreeNode parent = null; // 父亲结点
        boolean flag = false; // true 表示链入到父结点的左孩子位置，false表示链入父结点的右孩子位置

        for (int i = 0; i < exp.length(); i++) { // 逐个读入表达式的各个字符
            char c = exp.charAt(i);
            switch (c) {
                case '(': // 当前节点有孩子节点，入栈以便设置其孩子
                    stack.push(temp);
                    flag = true;
                    break;
                case ')': // 设置好了栈顶节点的孩子，出栈
                    stack.pop();
                    break;
                case ',': // 当前节点无孩子，不需要设置其孩子节点，因此不需要入栈
                    flag = false;
                    break;
                default: // 创建根据内容创建节点
                    node = new TreeNode(c);
                    break;
            }

            // 若树不存在，则创建树的根结点
            if (root == null) {
                root = node;
            }

            // 为栈顶节点链入子女
            if (!stack.isEmpty()) {
                if (node != null) { // 当读入的是'('、')'、','字符时，略过
                    parent = stack.peek();
                    if (flag) {
                        parent.left = node;
                    } else {
                        parent.right = node;
                    }
                }
            }

            temp = node; // 用于入栈
            node = null; // node链入后，置空
        }
        return root;
    }

    /**
     * 层次遍历（广序遍历，工作队列）
     * @return
     */
    public String levelOrder(){
        StringBuilder sb = new StringBuilder();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>(); //辅助队列
        if(root != null){
            queue.add(root);
            while (!queue.isEmpty()){
                TreeNode temp = queue.pop();
                sb.append(temp.data).append(" ");
                //将该节点的左右孩子节点入队
                if(temp.left != null)
                    queue.add(temp.left);
                if(temp.right != null)
                    queue.add(temp.right);
            }
        }
        return sb.toString().trim();
    }

    /**
     * 前序遍历(递归）
     * @param root
     * @return
     */
    public String preOrder(TreeNode root){
        StringBuilder sb = new StringBuilder();
        if(root != null){
            sb.append(root.data + " ");
            sb.append(preOrder(root.left));
            sb.append(preOrder(root.right));
        }
        return sb.toString();
    }

    /**
     * 前序遍历（迭代)：非线性结构（树），工作栈，当前节点入栈
     * @return
     */
    public String preOrder(){
        StringBuilder sb = new StringBuilder();
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode node =root;
        while(node != null || !stack.isEmpty()){
            if (node != null) {
                sb.append(node.data + " "); // 访问当前节点
                stack.push(node); // 当前节点入栈
                node = node.left; // 遍历其左子树
            } else {
                node = stack.pop(); // 弹出其父节点
                node = node.right; // 遍历其右子树
            }
        }
        return sb.toString();
    }

    /**
     * 中序遍历（递归）
     * @param root
     * @return
     */
    public String inOrder(TreeNode root){
        StringBuilder sb = new StringBuilder();
        if(root != null){
            sb.append(inOrder(root.left));
            sb.append(root.data + " ");
            sb.append(inOrder(root.right));
        }
        return sb.toString();
    }

    /**
     * 中序遍历（迭代）
     * @return
     */
    public String inOrder(){
        StringBuilder sb = new StringBuilder();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()){
            if(node != null){
                stack.push(node);
                node = node.left;
            }
            else {
                node = stack.pop();
                sb.append(node.data + " ");
                node = node.right;
            }
        }
        return  sb.toString();
    }

    /**
     * 后序遍历（递归）
     * @param root
     * @return
     */
    public String postOrder(TreeNode root){
        StringBuilder sb =new StringBuilder();
        if(root != null){
            sb.append(postOrder(root.left));
            sb.append(postOrder(root.right));
            sb.append(root.data + " ");
        }
        return  sb.toString();
    }

    /**
     * 后序遍历（迭代）
     * @return
     */
    public String postOrder(){
        StringBuilder sb =new StringBuilder();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()){
            if(node != null ){
                node.isFirst = true;
                stack.push(node);
                node = node.left;
            }
            else{
                node = stack.pop();
                if(node.isFirst){
                    node.isFirst = false;
                    stack.push(node);
                    node = node.right;
                }
                else{
                    sb.append(node.data + " ");
                    node = null;
                }
            }
        }
        return sb.toString();
    }

    /**
     * 根据原树的根节点复制出一颗一样的树，并返回根节点。
     * @param root
     * @return
     */
    public TreeNode copy(TreeNode root){
        if(root == null)
            return null;
        TreeNode node = new TreeNode();
        node.data = root.data;
        node.left = copy(root.left);
        node.right = copy(root.right);
        return node;
    }

    public int height(TreeNode root){
        if(root != null){
            int h1 = height(root.left);
            int h2 = height(root.right);
            return h1 > h2 ? h1 + 1 : h2 + 1;
        }
        return 0;
    }

    public TreeNode getRoot(){
        return root;
    }

    /**
     * 用广义表的形式打印二叉树（前序遍历）
     * @param root
     * @return
     */
    public String printBinaryTree(TreeNode root){
        StringBuilder sb = new StringBuilder();
        if(root != null) {
            sb.append(root.data);
            if (root.left != null || root.right != null) {
                sb.append('(');
                sb.append(printBinaryTree(root.left));
                sb.append(',');
                sb.append(printBinaryTree(root.right));
                sb.append(')');
            }
        }
    return  sb.toString();
    }

    /**
     * 求树的深度
     * @param root
     * @return
     */
    public int TreeDepth(TreeNode root) {
        if(root == null)
            return 0;
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        return Math.max(left,right) + 1;
    }

    /**
     * 判断是否平衡二叉树
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        int[] h = new int[1];
        return IsBalanced_Solution(root,h);
    }
    public boolean IsBalanced_Solution(TreeNode root, int[] h){
        if(root == null){
            h[0] = 0;
            return true;
        }
        int[] left = new int[1];
        int[] right = new int[1];
        boolean bleft = IsBalanced_Solution(root.left,left);
        boolean bright = IsBalanced_Solution(root.right,right);
        if(bleft && bright){
            int dif = left[0] - right[0];
            if(dif <=1 && dif >=-1){
                h[0] = left[0] > right[0] ? left[0] + 1: right[0] +1;
                return true;
            }
        }
        return false;
    }



}
