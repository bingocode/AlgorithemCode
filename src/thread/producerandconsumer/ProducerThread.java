package thread.producerandconsumer;

/**
 * Created by admin on 2017/10/21.
 */
public class ProducerThread implements Runnable{

    private PublicResource resource;


    public ProducerThread(PublicResource resource) {
        this.resource = resource;
    }


    @Override
    public void run() {
        while (true) {
            try { //模拟生产时间
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            resource.produce();
        }
    }


}