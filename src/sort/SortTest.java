package sort;

/**
 * Created by admin on 2017/9/12.
 */
public class SortTest {
    public static void main(String[] args) {
        int len = 10;
        int[] a = new int[len];

        //Scanner sc = new Scanner(System.in);
        a[0] = 1878;
        a[1] = 31;
        a[2] = 100;
        a[3] = 79;
        a[4] = 15;
        a[5] = 39080;
        a[6] = 20;
        a[7] = 965;
        a[8] = 34;
        a[9] = 126;
        for(int i =0;i<len;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
        heapSort(a);
        for(int i =0;i<len;i++){
            System.out.print(a[i]+" ");
        }
    }

    public static void heapSort(int[] a) {
        //构造最大堆
        for(int i = a.length/2 - 1; i >=0; i--) {
            adjustHeap(a,i,a.length);
        }
        //依次取出第一个元素与无序区最后一个元素交换，并重新调整成最大堆
        for(int j = a.length-1; j>0; j--) {
            int temp = a[j];
            a[j] = a[0];
            a[0] = temp;
            adjustHeap(a,0,j);
        }
    }

    public static void adjustHeap(int[] a, int i, int len){
        int largest = i;
        int left = 2*i+1;
        int right = 2*i+2;
        if(left < len && a[left] > a[largest]) {
            largest = left;
        }
        if(right < len && a[right] > a[largest]) {
            largest = right;
        }
        if(largest != i) {
            int temp = a[largest];
            a[largest] = a[i];
            a[i] = temp;
            adjustHeap(a,largest,len);
        }
        SortUtils.print(a);

    }

}