package stack;

public class StackTest {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int[] b = {4,5,3,2,1};
        System.out.println(StackUtil.IsPopOrder(a,b));
    }
}
