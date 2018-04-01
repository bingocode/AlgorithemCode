package binary;

/**
 * 二进制
 */
public class BinaryUtil {

    /**
     * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示
     * @param n
     * @return
     */
    public static int NumberOf1(int n) {
        int res =  0;
        while(n != 0) {
            n =  n & (n - 1);
            res ++;
        }
        return res;
    }

    /**
     * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方
     * @param base
     * @param exponent
     * @return
     */
    public double Power(double base, int exponent) {
        boolean isfushu = false;
        if(exponent == 0)
            return 1;
        if(exponent == 1)
            return base;
        if (exponent < 0) {
            isfushu = true;
            exponent = -exponent;
        }
        double rst = Power(base,exponent >> 1); //右移一位除以2
        rst *= rst;
        if((exponent & 1) == 1) //判断奇数
            rst *= base;
        if(isfushu)
            rst = 1/rst;
        return rst;
    }

    /**
     * 位运算实现加法
     */

    public int Add(int num1,int num2) {
        while(num2 != 0){ //当进位为0时就直接返回temp即不进位的值。否则计算进位
            int temp = num1 ^ num2;  //计算不进位的值
            num2 = (num1 & num2) << 1; //计算进位
            num1 = temp;
        }
        return num1;
    }
}
