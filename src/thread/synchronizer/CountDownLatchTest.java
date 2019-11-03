package thread.synchronizer;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    private static final int THREAD_COUNT = 2;
    public static void main(String[] args) {
        CountDownLatch gate = new CountDownLatch(THREAD_COUNT);
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    System.out.println("自线程1 执行");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                gate.countDown();
            }
        });
        thread1.start();
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    System.out.println("自线程2 执行");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                gate.countDown();
            }
        });
        thread2.start();
        System.out.println("主线程 等待中");
        try {
            gate.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("所有子线程执行完毕，主线程开始执行");
    }
}
