package jianzhioffer;

import java.util.Scanner;

/**
 * Created by admin on 2017/10/4.
 */
//二维有序数组查找： 每次从右上角开始找
public class Test03 {
    private static final int[][] array = {
            {1,2,8,9},
            {2,4,9,12},
            {4,7,10,13},
            {6,8,11,15}
    };
    private static boolean contain(int key, int[][] a){
        if(a == null || a.length <0 || a[0].length <1)
            return false;
        int x = 0; //行
        int y = a[0].length -1; //列
        int v = a[x][y];
        while (v!=key){
            if(v < key)
                x++;
            if(v> key)
                y--;
            if(x >= a.length || y <0){
                return false;
            }
            v = a[x][y];
        }
        return true;
    }
    public static void main(String[] a){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            System.out.println(contain(sc.nextInt(), array));
        }
    }
}
