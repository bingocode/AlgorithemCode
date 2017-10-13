package array;

/**
 * Created by admin on 2017/10/4.
 */
/**
 * 对于数组这种数据结构，
 * 线性查找的话，时间复杂度为O(N)，
 * 二分查找的话时间为O(longN)，
 * 无序数组插入的时间复杂度为O(1)，
 * 有序数组插入的时间复杂度为O(N)，
 * 删除操作的时间复杂度均为O(N)。
 * @author dream
 *
 */
public class OrderedArray {

    private long[] a;
    private int size;   //数组的大小
    private int nElem;  //数组中有多少项

    public OrderedArray(int max){   //初始化数组
        this.a = new long[max];
        this.size = max;
        this.nElem = 0;
    }

    public int size(){   //返回数组实际有多少值
        return this.nElem;
    }

    /**
     * 二分查找
     * @param searchNum
     * @return
     */
    public int find(long searchNum){
        int lower = 0;
        int upper = nElem - 1;
        int curr;
        while (true) {
            curr = (lower + upper) / 2;
            if(a[curr] == searchNum){
                return curr;
            }else if(lower > upper){
                return -1;
            }else {
                if(a[curr] < searchNum){
                    lower = curr + 1;
                }else {
                    upper = curr - 1;
                }
            }
        }
    }


    public boolean insert(long value){   //插入某个值
        if(nElem == size){
            System.out.println("数组已满!");
            return false;
        }
        int j;
        for(j = 0; j < nElem; j++){
            if(a[j] > value){
                break;
            }
        }

        for(int k = nElem; k > j; k++){
            a[k] = a[k-1];
        }
        a[j] = value;
        nElem++;
        return true;
    }



    public boolean delete(long value){   //删除某个值
        int j = find(value);
        if(j == -1){
            System.out.println("没有该元素!");
            return false;
        }

        if(nElem == size){
            for(int k = j; k < nElem - 1; k++){
                a[k] = a[k+1];
            }
            a[nElem-1] = 0;
        }else {
            for(int k = j; k < nElem; k++){
                a[k] = a[k+1];
            }
        }
        nElem--;
        return true;
    }


    public void display(){   //打印整个数组
        for(int i = 0; i < nElem; i++){
            System.out.println(a[i] + " ");
        }
        System.out.println("");
    }
}
