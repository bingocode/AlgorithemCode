package thread;

/**
 * Created by admin on 2017/10/21.
 */
public class MyTask1 extends Thread{
    private int topnumber;
    public MyTask1(int topnumber){
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
Thread t = new MyTask1(10);
t.start();
 */