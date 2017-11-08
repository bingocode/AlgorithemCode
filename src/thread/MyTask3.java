package thread;

import java.util.concurrent.Callable;

/**
 * Created by admin on 2017/10/21.
 */
public  class MyTask3 implements Callable<Integer> {
    private int topnumber;
    public MyTask3(int topnumber){
        this.topnumber = topnumber;
    }
    @Override
    public Integer call() throws Exception {
        int rst =0;
        for (int i = 0; i<=topnumber; i++)
            rst +=i;
        return rst;
    }
}