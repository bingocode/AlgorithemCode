package designpattern;
public class Singleton {
    /**
     *     双重检验
     */
    private volatile static Singleton instance;
    private Singleton(){}
    public static Singleton getInstance() {
        if(instance == null) {
            synchronized(Singleton.class) {
                if(instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    /*
    



     */
}
