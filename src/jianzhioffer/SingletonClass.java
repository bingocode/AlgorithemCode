package jianzhioffer;

/**
 * Created by admin on 2017/10/4.
 */

/**
 * 饿汉式:线程安全，类加载时创建好了，以空间换时间
 */
public class SingletonClass {
    private static final SingletonClass instance = new SingletonClass();
    private SingletonClass(){}
    public static SingletonClass getInstance(){
        return instance;
    }
}
/*
懒汉式：延时加载，只有在需要时创建对象，比如配置文件对象Application。下面也实现了同步
public class SingletonClass{
    private static final SingletonClass instance = null;
    public synchronized static SingletonClass getInstance(){
        if(instance == null){
            instance = new SingletonClass();
        }
        return instance;
    }
}
 */
