package refrect;

import refrect.Person;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestReflect {

    public static void main(String[] args) {
        Person student = new Person();
        try {
            /**
             * getMethod的方法签名如下：
             * getMethod(String name, Class<?>... parameterTypes)，
             * 第一个参数是方法名，接下来的参数是要调用的方法的参数列表各类型
             * 对应的Class对象
             */
            // 访问私有方法需要用getDeclaredMethod获得Method对象
            Method m2 = student.getClass().getMethod("getA");
            m2.setAccessible(true);
            String rst = (String) m2.invoke(student);
            System.out.println(rst);
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}