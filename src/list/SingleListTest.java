package list;


import java.util.List;

/**
 * Created by admin on 2017/9/19.
 */
public class SingleListTest {

public static class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
    public static void main(String[] args){
        ListNode p1 = new ListNode(0);
        ListNode p2;
        ListNode p0 = p1;
        for (int i = 1; i< 6; i++) {
             p2 = new ListNode(i);
             p1.next = p2;
             p1 = p2;
        }
        printList(p0);
        ReverseList(p0);
        printList(p0);
    }

    public static ListNode ReverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode pre = head.next;
        ListNode post = null;
        while(pre != null) {
            pre.next = post;

        }
        return pre;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

}
