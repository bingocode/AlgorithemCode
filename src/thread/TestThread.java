package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by admin on 2017/10/21.
 */
public class TestThread {
    public static void main(String[] args) {
        int sum = 0;
//        List<Future<Integer>> list = new ArrayList<>();
//        ExecutorService service = Executors.newFixedThreadPool(10);
//        for(int i = 0; i<10; i++){
//            list.add(service.submit(new MyTask3((int) (Math.random()*100))));
//        }
//
//
//        for(Future<Integer> future: list){
//            while (!future.isDone());//阻塞直到一个任务已经完成
//            sum += future.get();
//        }
        Callable callable = new MyTask3(6);
        try {
            sum = (int)callable.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.print(sum);

    }
}
