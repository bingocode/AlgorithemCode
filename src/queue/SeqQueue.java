package queue;

import list.Node;

/**
 * Created by admin on 2017/9/20.
 */
/*
顺序队列
数组实现
front(对首元素下标）-第二个元素-...-队尾元素（rear）
参考：
http://blog.csdn.net/javazejian/article/details/53375004
队空：front = rear = 0;
入队后：front = 0,rear = （该入队后队尾元素的下标+1）% length。也就是指向下一个入队元素的数组下标。
 */
public class SeqQueue {
    private Node[] nodes;
    private int front,rear;
    private int capacity; //容量，即数组长度

    public SeqQueue(int capacity) {
        this.capacity = capacity;
        nodes = new Node[capacity];
        front = rear = 0;
    }

    public SeqQueue() {
        this(64);
    }

    /**
     * 入队：正常情况下改变rear的下标
     * @param t
     */
    public void enqueue(Node t){
        if(t == null) //空对象不能入队
            return;
        if(front == (rear + 1)% capacity){//队满：.需要重新申请一个更大数组（实际上这时数组还是留了一个空位，也就是说就算不扩容最多可以再加入一个元素，这个设定主要是为了与队空判断区别开）
            Node[] temp = nodes;
            capacity = 2*capacity;
            nodes = new Node[capacity];
            int j =0;
            for(int i = front; i < rear; j++){
                nodes[j] = temp[i];
                i = (i+1)% temp.length;
            }
            front = 0;
            rear = j;
        }
        nodes[rear] = t;
        rear = (rear + 1)%nodes.length;
    }

    /**
     * 出队 :改变front下标指向
     * @return
     */
    public Node dequeue(){
        if(isEmpty())
            return null;
        Node temp = nodes[front];
        front = (front + 1) % nodes.length;
        return temp;
    }

    /**
     * 队空
     * @return
     */
    public boolean isEmpty(){
        return  front == rear;
    }

    public static void main(String[] args){
        SeqQueue queue = new SeqQueue(16);
        queue.enqueue(new Node(1));
        queue.enqueue(new Node(2));
        queue.enqueue(new Node(3));
        queue.enqueue(new Node(4));
        queue.enqueue(new Node(5));
        queue.enqueue(new Node(6));
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue.dequeue().data);
    }
}
