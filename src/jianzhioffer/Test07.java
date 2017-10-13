package jianzhioffer;

/**
 * Created by admin on 2017/10/5.
 */
public class Test07 {

    public int minNumberInRotateArray(int[] a) {
        if (a == null || a.length == 0)
            return 0;
        if (a[0] <= a[a.length - 1]) //未旋转
            return a[0];
        int p1 = 0;
        int p2 = a.length - 1;
        int mid = p1;
        while (p1 < p2) {
            mid = (p1 + p2) / 2;
            if (a[mid] >= a[p1])
                p1 = mid;
            else if (a[mid] <= a[p2])
                p2 = mid;
        }

        return a[p2];
    }
}
