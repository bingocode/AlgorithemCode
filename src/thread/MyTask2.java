package thread;

/**
 * Created by admin on 2017/10/21.
 */
public class MyTask2 implements Runnable{
private int topnumber;
public MyTask2(int topnumber){
        this.topnumber = topnumber;
        }
@Override
public void run() {
        for (int i = 0; i<topnumber; i++)
        System.out.println(i);
        }
}
/*
使用方法：
Thread t = new Thread(new MyTask2(10));
t.start();
 */
