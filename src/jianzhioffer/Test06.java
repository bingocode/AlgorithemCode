package jianzhioffer;


/**
 * Created by admin on 2017/10/5.
 */
public class Test06 {
    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

        public TreeNode reConstructBinaryTree(int [] pre, int [] in) {

            return reConstructBinaryTree(pre,0,pre.length -1,in,0,in.length - 1);

        }
        public TreeNode reConstructBinaryTree(int[] pre, int s1, int e1,int[] in,int s2,int e2){
            if(e1-s1<0 || e2 - s2<0)
                return null;
            int cur = pre[s1];
            TreeNode root = new TreeNode(cur);
            int pos = findpos(in,cur,s2,e2);
            int leftl = pos - s2; //左子树长度
            int rightl = e2 - pos; //右子树长度
            root.left = reConstructBinaryTree(pre,s1+1,s1+leftl,in,s2,pos-1);//递归构建左子树
            root.right = reConstructBinaryTree(pre,s1+leftl+1, s1+leftl+rightl,in,pos+1,pos+rightl);//递归构建右子树
            return root;
        }

        public int findpos(int[] a, int b,int s,int e){
            for(int i =s; i<=e;i++){
                if(a[i] == b)
                    return i;
            }
            return -1;

    }
}
