package jianzhioffer;

/**
 * Created by admin on 2017/10/5.
 */
/*在O(1)的时间删除链表结点：
1）对于一般结点：若删除的结点为i，其后一节点j = i.next; 先将j的内容复制给i，然后i.next = j.next;
2) 若删除的是尾节点：i.next == null,则需要顺序遍历得到i的前一节点h,并将h.next = null
3) 若链表只有一个节点：head = null。
 */
public class Test13 {
    class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
        }
    }
    public void DeleteNode(ListNode head,ListNode pdelete){
        if(head == null || pdelete == null)
            return;
        if(pdelete.next != null) //不是尾节点
        {
            ListNode pnext = pdelete.next;
            pdelete.val = pnext.val;
            pdelete.next = pnext.next;
            pnext = null;
        }
        else if(pdelete == head) //链表只有一个节点，
        {
            head = null;
            pdelete = null;
        }
        else { //删除尾节点（有多个节点）
            ListNode pnode = head;
            while ((pnode.next)!= pdelete){
                pnode = pnode.next;
            }
            pnode.next = null;
            pdelete = null;
        }
    }
}
