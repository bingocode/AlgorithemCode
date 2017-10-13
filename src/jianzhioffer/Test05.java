package jianzhioffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by admin on 2017/10/5.
 */
/*
从尾到头打印链表
 */
public class Test05 {
     class ListNode {
        int val;
      ListNode next = null;

                ListNode(int val) {
            this.val = val;
        }
    }
    public class Solution {
        public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
            Stack<Integer> stack = new Stack<>();
            while (listNode != null) {
                stack.push(listNode.val);
                listNode = listNode.next;
            }

            ArrayList<Integer> list = new ArrayList<>();
            while (!stack.isEmpty()) {
                list.add(stack.pop());
            }
            return list;

        }
    }
}
