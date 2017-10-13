package stack;

import list.Node;

import java.util.NoSuchElementException;

/*
链式栈
链表实现的栈。top指针->栈顶元素 (0)->第二个元素（1）-> ....
 */
public class LinkedStack {
    private Node top; //栈顶元素指针
    private int n;

    public LinkedStack(){
        top=null;
        n=0;
    }

    public boolean isEmpty(){
        return top==null;
    }
    public int size(){
        return n;
    }

    /**
     * 入栈
     * @param t
     */
    public void push(int t){
        Node node=new Node(t);
        node.next=top;
        top=node;
        n++;
    }

    /**
     * 出栈：返回栈顶元素值并删除该元素
     * @return
     */
    public int pop(){
        if(isEmpty()) throw new NoSuchElementException("stackoverflow");
        else 
        {
        int t=top.data;
        top=top.next;
        n--;
        return t;
        }
       
    }

    /**
     * 返回栈顶元素，但不删除
     * @return
     */
    public int peek(){
        if(isEmpty()) throw new NoSuchElementException("stack over flow");
        return top.data;
    }

     public static void main(String[] args) {
        LinkedStack stack = new LinkedStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
         System.out.println(stack.peek());
        }
    }

