package thread.interrupt;

/**
 * Created by admin on 2017/10/22.
 */
public class SleepInterrupt implements Runnable {

    @Override
    public void run() {

        try {
            System.out.println("in run() - about to sleep for 20 seconds");
            Thread.sleep(20000);
            System.out.println("in run() - woke up");
        } catch (InterruptedException e) {
            System.out.println("in run() - interrupted while sleeping");
            //处理完中断异常后，返回到run()方法入口
            //如果没有return,线程不会实际被中断，它会继续打印下面的信息
            return;
        }
        System.out.println("in run() - leaving normally");
    }

    public static void main(String[] args) {
        SleepInterrupt si = new SleepInterrupt();
        Thread t = new Thread(si);
        t.start();
        //住线程休眠2秒，从而确保刚才启动的线程有机会执行一段时间
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("in main() - interrupting other thread");
        //中断线程t
        t.interrupt();
        System.out.println("in main() - leaving");
    }

}
/*
主线程启动新线程后，自身休眠2秒钟，允许新线程获得运行时间。新线程打印信息“about to sleep for 20 seconds”后，继而休眠20秒钟，
大约2秒钟后，main线程通知新线程中断，那么新线程的20秒的休眠将被打断，从而抛出InterruptException异常，执行跳转到catch块，打印出“interrupted while sleeping”信息，并立即从run（）方法返回，然后消亡，而不会打印出catch块后面的“leaving normally”信息。
请注意：由于不确定的线程规划，上图运行结果的后两行可能顺序相反，这取决于主线程和新线程哪个先消亡。但前两行信息的顺序必定如上图所示。
另外，如果将catch块中的return语句注释掉，则线程在抛出异常后，会继续往下执行，而不会被中断，从而会打印出”leaving normally“信息。
 */