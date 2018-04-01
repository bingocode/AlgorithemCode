package array;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * 常用数组相关函数
 */
public class ArrayUtil {
    /**
     * 判断是否为素数
     */
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i*i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    /**
     * 计算平方根（牛顿迭代法）
     */
    public static double sqrt(double n) {
        if (n < 0) return Double.NaN;
        double err = 1e-15;
        double t = n;
        while(Math.abs(t- n/t) > err * t) {
            t = (n/t + t) / 2.0;
        }
        return t;
    }
    /**
     * 矩阵乘方 a[N][N] * b[N][N]
     */
    public static int[][] matrixPower(int[][] a, int[][] b, int N) {
        int[][] c = new int[N][N];
        for (int i = 0; i< N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }

    /**
     * 二分法查找
     * @param a
     * @param n
     * @return
     */
    public static int BinarySearch(int[] a, int n) {
        return BinarySearch(a, n, 0, a.length - 1);
    }

    public static int BinarySearch(int[] a, int n, int left, int right){
        if(left > right) return -1;
        int mid = left + (right - left) /2;
        if(n < a[mid]) {
            return BinarySearch(a, n, left, mid);
        } else if (n > a[mid]) {
            return BinarySearch(a, n, mid, right);
        } else {
            return mid;
        }
    }


    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            double n = sc.nextDouble();
            System.out.println("Math: "+sqrt(n));
            System.out.println(Math.sqrt(n));
        }
        System.out.println("finish");
    }
    public static ArrayList<Integer> printMatrix(int [][] ma) {
        if(ma == null || ma[0].length == 0) return null;
        ArrayList<Integer> rst = new ArrayList<>();
        int i = 0;
        int j = 0;
        int k = 1;
        int m = ma.length;
        int n = ma[0].length;
        while(rst.size() < m*n) {
            while(j < n - k) {
                rst.add(ma[i][j]);
                j++;
            }
            while(i< m - k) {
                rst.add(ma[i][j]);
                i++;
            }
            while(j >= k) {
                if(rst.size() >= m*n) {
                    break;
                }
                rst.add(ma[i][j]);
                j--;
            }
            while(i >= k) {
                if(rst.size() >= m*n) {
                    break;
                }
                rst.add(ma[i][j]);
                i--;
            }
            i++;
            j++;
            k++;
        }
        return rst;
    }



}
