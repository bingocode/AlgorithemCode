package list;


/**
 * Created by admin on 2017/9/19.
 */
public class SingleListTest {
    public static void main(String[] args){
        SingleList list = new SingleList();
        list.insert(new Node(1));
        list.insert(new Node(2));
        list.insert(new Node(3));
        list.insert(new Node(4));
        list.insert(new Node(5));
        try {
            list.insertByIndex(new Node(6),3);
            list.delete(4);
            System.out.println("访问下标4节点"+list.get(4).data);
            System.out.println("总长度"+list.lenght());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("正常排列");
        list.print();
        System.out.println("逆序输出");
        list.reverseprint();
        System.out.println("逆转序列");
        list.reverseList();
        list.print();
    }

}
