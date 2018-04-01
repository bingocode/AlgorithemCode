import array.ArrayUtil;
import sort.SortUtils;

import java.util.ArrayList;
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
            int[][] a = {
                    {1},
            };
        ArrayList<Integer> rst = ArrayUtil.printMatrix(a);
        for(int i = 0; i< rst.size(); i++) {
            System.out.print(rst.get(i) +" ");
        }
    }


}
