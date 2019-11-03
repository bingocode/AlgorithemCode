package thread.synchronizer;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                //执行
                try {
                    semaphore.acquire();
                    System.out.println("线程1,获取到许可，开始执行: ");
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //释放
                semaphore.release();
                System.out.println("线程1执行完释放许可");
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    semaphore.acquire();
                    System.out.println("线程2,获取到许可，开始执行: ");
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //释放
                semaphore.release();
                System.out.println("线程2执行完释放许可");
            }
        });
        thread1.start();
        thread2.start();
        try {
            semaphore.acquire();
            System.out.println("主线程, 获取到许可，开始执行: ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //释放
        semaphore.release();
        System.out.println("主线程执行完释放许可");
    }
}
