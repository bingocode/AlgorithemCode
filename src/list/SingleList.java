package list;

/**
 * Created by admin on 2017/9/19.
 * 部分参考：https://github.com/selfconzrr/Single-List/blob/master/LinkedList.java
 */
public class SingleList {
    private Node head; //头指针
    private int size; //节点个数
    private Node current; //当前结点对象
    /*
    头指针（head）->头节点（可以认为下标-1)->首节点（下标0）->第二节点（下标1）-<第三节点......
    看：
    https://www.zhihu.com/question/48726176/answer/115392941
    http://blog.csdn.net/mcgrady_tracy/article/details/32130421
     */
    public SingleList(){
        this.head = current = new Node();
        size =0;
    }
    /**
     * 定位操作：这个函数则可以将current移动到下标为index的位置（实际上我们要移动到index之前的index-1位置进行插入）。
     * @param index
     */
    private void index(int index) throws Exception{
        if(index < -1 || index > size -1)
        {
            throw new Exception("参数错误");
        }
        if(index == -1) {
            current = head;
            return;
        }
        current = head.next; //定位到下标0
        for(int j =0; j < index && current != null; j++){
            current = current.next;
        }
    }

    /**
     *c插入新节点
     * @param item
     */
    public void insert(Node item){
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = item;
        size++;
    }

    /**
     * 插入新节点到指定下标处
     * @param item
     * @param index
     */
    public void insertByIndex(Node item,int index)throws Exception{
        if(index < 0 || index > size){
            System.out.println("参数越界错误");
            return;
        }
        index(index-1);//将当前结点指针移动到要插入的节点（下标）的前一个节点。current(index-1) -> item(index) ->olditem.(oldindex)..
        item.next = current.next;
        current.next = item;
        size++;
    }

    /**
     * 删除指定下标节点
     * @param index
     * @throws Exception
     */
    public void delete(int index) throws Exception{
        if(isEmpty())
            throw new Exception("链表为空");
        if(index < 0 || index > size-1)
            throw new Exception("参数错误");
        index(index - 1);
        current.next = current.next.next;
        size --;
    }

    /**
     * 访问指定下标节点
     * @param index
     * @return
     * @throws Exception
     */
    public Node get(int index) throws Exception{
        if(isEmpty())
            throw new Exception("链表为空");
        if(index < 0 || index > size-1)
            throw new Exception("参数错误");
        index(index);
        return current;
    }

    /**
     * 链表长度
     * @return
     */
    public int lenght(){
        int len =0;
        Node temp = head;
        while (temp.next!=null){
            len++;
            temp = temp.next;
        }
        return len;
    }

    /**
     * 打印
     */
    public void print(){
        if(!isEmpty()){
            current = head;
            while (current.next != null){
                current = current.next;
                System.out.print(current.data+"-->");
            }
        }
    }

    /**
     * 逆序输出（三种方法，栈特性，动态数组（ArrayList)，递归）这里用递归
     */
    public void reverseprint(){
        reverseprint(head.next);
    }
    private void reverseprint(Node head){
        if(head == null)
            return;
        else
            reverseprint(head.next);
        System.out.print(head.data+"->");
    }

    /**
     * 反转链表
     */
    public void  reverseList(){
        if(head == null)
            return;
        current = head.next;
        Node pre = null;
        Node nex = null;
        while(current != null){
            nex = current.next;
            current.next = pre;
            pre = current;
            current = nex;
        }
        head.next = pre;
    }

    /**
     * 反转链表中第m
     * 到n个节点
     */
    public void reverseListBetween(int m, int n){

    }

    public void clear(){
        head.next = null;
        current = head;
        size = 0;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }




}
