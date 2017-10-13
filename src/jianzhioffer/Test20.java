package jianzhioffer;

/**
 * Created by admin on 2017/10/5.
 */
public class Test20 {
    public void printMatrixClockWisely(int[][] numbers) {
        if (numbers == null || numbers.length <= 0 || numbers[0].length <= 0)
            return;
        ;
        int x = 0; //记录一圈的开始位置的行
        int y = 0; // 记录一圈开始位置的列
        int maxrow = (numbers.length - 1) / 2; //圈开始的行号的最大值
        int maxcol = (numbers[0].length - 1) / 2; //圈开始的列号的最大值
        while (x <= maxrow && y <= maxcol) {
            printMatrixInCircle(numbers, x, y);
            x++;
            y++;
        }
    }

    public void printMatrixInCircle(int[][] numbers, int x, int y) {
        int row = numbers.length;
        int col = numbers[0].length;
        //输出环的上一行
        for (int i = y; i <= col - y - 1; i++) {
            System.out.print(numbers[x][i] + " ");
        }
        //环的高度至少为2才输出右边一列
        // rows-x-1：表示的是环最下的那一行的行号
        if (row - x - 1 > x) {
            for (int i = x + 1; i <= row - x - 1; i++) {
                System.out.print(numbers[i][col - y - 1] + " ");
            }
        }
        // 环的高度至少是2并且环的宽度至少是2才会输出下面那一行
        // cols-1-y：表示的是环最右那一列的列号
        if (row - x - 1 > x && col - 1 - y > y) {
            for (int i = col - y - 2; i >= y; i--) {
                System.out.print(numbers[row - 1 - x][i] + " ");
            }
        }

        // 环的宽度至少是2并且环的高度至少是3才会输出最左边那一列
        // rows-x-1：表示的是环最下的那一行的行号

        if (col - 1 - y > y && row - 1 - x > x + 1) {
            // 因为最左边那一列的第一个和最后一个已经被输出了
            for (int i = row - 1 - x - 1; i >= x + 1; i--) {
                System.out.print(numbers[i][y] + " ");
            }
        }
    }
}
