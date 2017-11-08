package thread.producerandconsumer;

/**
 * Created by admin on 2017/10/21.
 */
public class PublicResource {
    private int number = 0;
    private int size = 10;
    /*
    增加公共资源
     */
    public synchronized void produce(){
        while (number >= size){ //当前缓冲池满了则让生产者线程进入等待
            try{
                wait(); //释放锁进入等待；
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        number++;
        System.out.println("继续生产一个，现在共有"+number);
        notifyAll(); //唤醒进入等待状态的消费者线程去消费产品。
    }

    public synchronized void consume(){
        while(number <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
            number--;
            System.out.println("消费了一个，现在共有"+number);
            notifyAll();

    }
}
