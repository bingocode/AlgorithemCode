package queue;
import list.Node;
import java.util.NoSuchElementException;
/*
采用链表实现的队列。
front指针->队首元素->第二个元素->...->队尾元素（rear指针）
 */
public class LinkedQueue {
    private Node front; //队首节点指针
    private Node rear; //队尾节点指针
    private int n;

    public LinkedQueue() {
        front = null;
        rear = null;
        n = 0;
    }

    /**
     * 队空判断
     * @return
     */
    public boolean isEmpty() {
        return front == null && rear == null;
    }

    public int size() {
        return n;
    }

    /**
     * 返回队首元素，但不出队
     * @return
     */
    public int peek() {
        if (isEmpty())
            throw new NoSuchElementException("LinkedQueue underflow");
        return front.data;
    }

    /**
     * 入队
     * @param item
     */
    public void enqueue(int item) {
        Node oldnode=rear;
        rear=new Node();
        rear.data=item;
        rear.next=null;
        if(isEmpty()) front=rear;
        else
        oldnode.next=rear;
        n++;
    }

    /**
     * 出队
     * @return
     */
    public int dequeue() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
       int t=front.data;
       front=front.next;
       n--;
       if(isEmpty()) rear=null;
       return t;
    }

    public static void main(String[] args) {
        LinkedQueue queue = new LinkedQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        System.out.println(queue.dequeue() + " ");
        System.out.println(queue.peek() + " ");

    }
}
