package designpattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 */
public class DyTest {
    /**
     * 抽象主题
     */
    public interface Subject {
        void buy();
    }

    /**
     * 具体主题1，米粉
     */
    public class XiaoMiFun implements Subject {
        @Override
        public void buy() {
            System.out.println("买小米");
        }
    }

    /**
     * 苹果粉
     */
    public class IphoneFun implements Subject {
        @Override
        public void buy() {
            System.out.println("买苹果");
        }
    }

    /**
     * 调用处理器
     * 1 生成动态代理对象
     * 2 指定动态代理对象运行目标对象需要完成的任务
     */
    public class DynamicProxy implements InvocationHandler {
        // 声明代被理对象
        // 作用：绑定关系，即关联到哪个接口（与具体的实现类绑定）的哪些方法将被调用时，执行invoke（）
        private Object proxyObject;
        public Object newProxyInstance(Object proxyObject) {
            this.proxyObject = proxyObject;
            return Proxy.newProxyInstance(proxyObject.getClass().getClassLoader(),
                    proxyObject.getClass().getInterfaces(), this);
            // Proxy.newProxyInstance（）作用：根据指定的类装载器、一组接口 & 调用处理器 生成动态代理类实例，并最终返回
            // 参数1：指定产生代理对象的类加载器，需要将其指定为和目标对象同一个类加载器
            // 参数2：指定目标对象的实现接口
            // 即要给目标对象提供一组什么接口。若提供了一组接口给它，那么该代理对象就默认实现了该接口，这样就能调用这组接口中的方法
            // 参数3：指定InvocationHandler对象。即动态代理对象在调用方法时，会关联到哪个InvocationHandler对象
        }

        //  复写InvocationHandler接口的invoke（）
        //  动态代理对象调用目标对象的任何方法前，都会调用调用处理器类的invoke（）
        // 参数1：动态代理对象（即哪个动态代理对象调用了method（）
        // 参数2：目标对象被调用的方法
        // 参数3：指定被调用方法的参数
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("代购出门了, proxy name = " + proxy.getClass().getName());
            Object result = null;
            // 通过Java反射机制调用目标对象方法
            result = method.invoke(proxyObject, args);
            return result;
        }
    }

    public void test() {
        // 创建调度器对象
        DynamicProxy dynamicProxy = new DynamicProxy();
        // 创建目标对象
        XiaoMiFun miFun = new XiaoMiFun();
        // 创建代理类对象
        Subject phoneProxy = (Subject) dynamicProxy.newProxyInstance(miFun);
        // 代购
        phoneProxy.buy();

        // 代购苹果
        IphoneFun iphoneFun = new IphoneFun();
        dynamicProxy.newProxyInstance(iphoneFun);
        phoneProxy.buy();
    }

    public static void main(String[] args) {
        DyTest dyTest = new DyTest();
        dyTest.test();
    }
}
