package stack;

import list.Node;

/**
 * Created by admin on 2017/9/20.
 */
/*
顺序栈
数组实现栈，栈顶元素top为
 */
public class SeqStack {
    private int DEFAULT_SIZE = 16;//栈的初始默认长度
    private int capacity;//栈的自定义长度
    private int size; //栈中元素个数
    private Node[] nodes; //用数组存储节点

    public SeqStack() {
        capacity = DEFAULT_SIZE;
        nodes = new Node[capacity];
    }

    public SeqStack(int capacity) {
        this.capacity = capacity;
        nodes = new Node[capacity];
    }

    /**
     * 入栈
     * @param item
     */
    public void push(Node item){
        if(size+1 > capacity) {
            System.out.println("栈满了");
            return;
        }
        nodes[size++] = item;
    }

    /**
     * 出栈
     * @return
     */
    public Node pop(){
        if(isEmpty())
        {
            System.out.println("队空，不能出栈");
            return null;
        }
        Node oldnode = nodes[size - 1];
        nodes[--size] = null;
        return oldnode;
    }

    /**
     * 返回展大哥你元素
     * @return
     */
    public Node peek(){
        if(isEmpty())
        {
            System.out.println("队空");
            return null;
        }
        return nodes[size-1];
    }

    public int lenght(){
        return size;
    }

    public boolean isEmpty(){
        return size ==0;
    }

    public void clear(){
        for(int i =0; i< size; i++){
            nodes[i] = null;
        }
        size = 0;
    }

}
