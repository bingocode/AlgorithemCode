package thread.producerandconsumer;

import java.util.Vector;

/**
 * Created by admin on 2017/10/21.
 */
public class ConsumerThread implements Runnable{
    private PublicResource resource;

    public ConsumerThread(PublicResource resource){
        this.resource = resource;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            resource.consume();
        }
    }
}
