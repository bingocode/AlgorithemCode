package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by admin on 2017/9/12.
 */
public class SortUtils {
    /**
     * 冒泡排序(每次交换相邻两元素将最大者沉入最后，总共n-1次,每次有n-1-i次比较)
     * @param a
     */
    public static void bubbleSort(int[] a){
        int len = a.length;
        for(int i = 0;i < len-1;i++)
            for(int j =0 ;j < len-1- i;j++ ){
            if(a[j]>a[j+1]){
                int temp = a[j+1];
                a[j+1] = a[j];
                a[j] = temp;
            }
            }
    }



    /**
     * 选择排序（每次选出最小元素，记录其下标，与前面第i个元素交换）
     * @param a
     */
    public static void selectionSort(int[] a){
        int len = a.length;
        int minIndex;
        for(int i=0;i<len -1;i++ ){
            minIndex = i;
            for(int j = i+1;j<len;j++){
                if(a[j]< a[minIndex])
                    minIndex = j;
            }
            int temp = a[minIndex];
            a[minIndex] = a[i];
            a[i] = temp;
        }
    }



    public static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] =  a[j];
        a[j] = temp;
    }
    /**
     * 插入排序(从第i（i>=1,即第二项）开始，依次将该项插入到前面已经排好序的i项之中。
     * 初始假设第一个元素a[0]有序
     * 将a[1]插入到a[0]中后a[0] ,a[1] 有序
     * 将a[2]插入到a[0],a[1],后，a[0],a[1],a[2]有序
     * 依次类推，每次插入都是交换相邻元素得到。
     * 1
     */
    public  static  void  insertionSort(int a[]){
        int len = a.length;
        for(int i = 1;i<len;i++){
            for(int j = i;j>=1;j--){
                if(a[j]<a[j-1]){
                    int temp = a[j];
                    a[j] = a[j-1];
                    a[j-1]= temp;
                }
            }
        }
    }

    /*
        public void sort(int[] a ){
            int n = a.length;
            for(int i = 1; i<n; i++)
                for(int j = i; j>=1;j--)
                    if(a[j] < a[j-1])
                    swap(a,,j,j-1)
        }

     */

    /**
     * 希尔排序
     * `1 选定步长： int h =1; while(h<n/3)h = h*3+1;
     * 2 步长从大到小循环插入排序。(每次递减h = h/3.
     */
    public static void shellSort(int[] a){
        int len=a.length;
        int h=1;
        while(h<len/3) h=3*h+1;//计算首次步长
        System.out.println("步长"+h);
        while(h>0){
            //将数组变为h步长有序
            for(int i=h;i<len;i++){
                //将a[i]插入到a[i-h],a[i-2h]...中（给定步长的插入排序）
                for(int j=i;j>=h;j-=h)
                    if(a[j]<a[j-h])
                    {
                        int temp = a[j-h];
                        a[j-h] = a[j];
                        a[j] = temp;
                    }
            }
            h=h/3;//计算下一轮的步长
        }
    }


    public static void print(int[] a){
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    /**
     * 归并排序:将排好序的两个数组合并（最原始的是两个只有一个元素的数组合并）
     */

    //自顶向下（递归法）
    public static void MergeUPSort(int[] a){
        int[] temp = new int[a.length];//重复利用一个临时数组避免递归时频繁创建
        MergeUPSort(a,temp,0,a.length-1);
    }
    public static void MergeUPSort(int[] a,int[] temp,int left, int right){
        if(left >= right) return;
        int mid = (left + right)/2;
        MergeUPSort(a,temp,left,mid);
        MergeUPSort(a,temp,mid+1,right);
        merge(a,temp,left,mid,right);
    }

    //自底向上（迭代法）：先两个两个元素合并（一个元素的数组），再四个（两个元素的数组）
    //i = 1 : 即一个元素的数组两两合并，先 a[0] 和a[1] ,然后 a[2]和a[3] ,a[4]和a[5]，依次直到最后两组
    public static void MergeBUSort(int[] a){
        int len = a.length;
        int[] temp = new int[len];
        for(int i = 1; i < len; i*=2){
            for(int left = 0; left < len - i; left += i*2 ){
                int mid = left + i -1;
                int right = Math.min(left + 2*i -1, len - 1);
                merge(a, temp, left, mid, right);
            }
            System.out.println("每"+i+"组");
            print(a);
        }
    }

    public static void MergeSortBU(int[] a){
        int n = a.length;
        int[] temp = new int[n];
        for(int i = 1; i<n; i = i*2){
            for(int left = i; left < n-i; left = left + i*2){
                int mid = left +i -1;
                int right = Math.min(left + 2*i -1,n-1);
                merge(a,temp,left,mid,right);
            }
        }
    }

    //合并两个排好序的数组a[left..mid] a[mid+1..right],aus[]为临时存放数组
    public static void merge(int a[], int temp[], int left, int mid, int right){
        int len = right - left + 1;
        int i = left, j = mid + 1, k = 0;

        while(i<=mid && j<=right){
            if(a[i] < a[j])
                temp[k++] = a[i++];
            else
                temp[k++] = a[j++];
        }

        while(i<=mid){
            temp[k++] = a[i++];
        }

        while (j<=right){
            temp[k++] = a[j++];
        }

        for(k=0;k<len;k++)
            a[k+left] = temp[k];
    }


    /**
     * 快速排序
     * 递归地分区：（初始状态下a[left,right]即a[0..length-1]
     * 挑选a[left,right]里的一个元素pivot（通常为a[left])，
     * 让所有大于它的元素在右边，小于它的在其左边。这样a[left,right]被分成了
     * a[left,mid] a[mid+1,right]两块区。然后对这两块区域递归地进行上述分区步骤直到所有区只有一个元素退出。
     *
     */
    public static void quickSort(int[] a){
        quickSort(a,0,a.length-1);
    }

    public static void quickSort(int[] a,int left, int right){
        if(left >= right) return; //只有一个元素了
        int pivot = partition(a,left,right);
        quickSort(a,left,pivot);
        quickSort(a,pivot + 1, right);
    }
    public static int partition(int[] a, int left, int right){
        int pivot = a[left]; //第一个数作为基准
        while (left < right){ //左右指针相遇之前
            while(left < right && a[right] >= pivot) //从后半部分向前扫描找比基准数小的（注意这个循环一定要先，
                // 因为我们需要用a[left]储存第一个比基数大的数a[right]，然后再用这个a[right]储存第一个比基数小的a[left]，依次类推）
                --right;
            a[left] = a[right]; //比基准数小的移动到低端（这时第一个a[left]的值被覆盖（原值保留在pivot中）)
            while(left < right && a[left] <= pivot) //从前半部分向后扫描找比基准数大的
                ++left;
            a[right] = a[left]; //比基准数大的移动到高端
        }
        a[left] = pivot; //将之前的基准（第一个）数放在分好区的中间的left（left==right)位置（小于left都比a[left]小，大于的都大）。
        return left;
    }
    /**
     * 堆排序
     * http://www.cnblogs.com/chengxiao/p/6129630.html
     */
    public static void heapSort(int[] a){
        for(int i = a.length/2 -1; i>=0;i--) //构造初始最大堆：从最后一个非叶子结点（也就是最后一个含有子节点的节点）开始，遍历从右到左，从下岛上（逻辑上也就是该数组元素之前的）,让这些节点依次变得满足堆的性质就构成了堆。
            adjustHeap(a,i,a.length);
        for(int j = a.length-1; j>0; j--){ //依次取出第一个元素和最后一个元素交换，然后重新调整构造最大堆（要调整的堆的大小递减）。
            int temp = a[0];
            a[0] = a[j];
            a[j] = temp;
            adjustHeap(a, 0, j);
        }
    }

    /**
     * @param a 存储堆的数组
     * @param i 堆的开始下标
     * @param len 堆的结束下标
     */
    public static void adjustHeap(int[] a, int i, int len){ //调整结点i，使得以i为开始到len的节点满足堆的性质。
        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;
        if(left < len && a[left] > a[largest])
            largest = left;
        if(right < len && a[right] > a[largest])
            largest = right;
        if(largest != i){
            int temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;
            adjustHeap(a,largest,len);//因为前面的交换可能导致交换后的父节点结构混乱。
        }
    }

    /**
     * 计数排序
     * @param a
     */
    public static void countSort(int[]a){
        int maxValue = 0;
        for(int i = 0; i<a.length; i++){
            if(a[i] > maxValue)
                maxValue = a[i];
        }
        countSort(a,maxValue);
    }
    /**
     * @param a 待排序数组
     * @param maxValue 数组元素最大值
     */
    public static void countSort(int[] a, int maxValue){
        int alen = a.length;
        int blen = maxValue + 1;
        int[] bucket = new int[blen];//元素i（0~maxValue所以有maxValue+1种可能）的值表示数组a中的i值出现的次数。
        int sortedindex = 0;

        for(int i = 0; i<alen; i++){
            bucket[a[i]] ++;
        }

        for(int j = 0; j<blen; j++){
            while (bucket[j] > 0){
                a[sortedindex++] = j;
                bucket[j]--;
            }
        }
    }

    /**
     * 桶排序
     * 桶排序可用于最大最小值相差较大的数据情况，比如[9012,19702,39867,68957,83556,102456]。
     但桶排序要求数据的分布必须均匀，否则可能导致数据都集中到一个桶中
     桶排序的基本思想是：把数组 arr 划分为n个大小相同子区间（桶），每个子区间各自排序，最后合并。
     计数排序是桶排序的一种特殊情况，可以把计数排序当成每个桶里只有一个元素的情况
     http://www.cnblogs.com/zer0Black/p/6169858.html
     */
    public static void bucketSort(int[] a){
        int max = a[0];
        int min = a[0];
        int len = a.length;

        //获取最大，最小值
        for(int i = 0; i < len; i++){
            min = Math.min(min, a[i]);
            max = Math.max(max, a[i]);
        }

        //创建桶
        int bucketCouont = (max - min)/len + 1; //桶数
        ArrayList<ArrayList<Integer>> buckets= new ArrayList<>(bucketCouont);
        for(int i = 0; i<bucketCouont; i++)
            buckets.add(new ArrayList<Integer>());

        //将每个元素放入桶
        for(int i = 0; i < len; i++){
            int num = (a[i] - min)/len;
            buckets.get(num).add(a[i]);
        }

        //对每个桶进行排序
        for(int i = 0; i < buckets.size(); i++)
            Collections.sort(buckets.get(i));
        System.out.println(buckets.toString());

        //回写
        for(int i = 0,k=0; i < buckets.size(); i++){
            for(int j = 0; j < buckets.get(i).size(); j++){
                a[k++] = buckets.get(i).get(j);
            }
        }
    }

    /**
     * 基数排序
     * 是桶排序的扩展，它的基本思想是：将整数按位数切割成不同的数字，然后按每个位数分别比较,
     * 有待比较数值统一为同样的数位长度，数位较短的数前面补零。然后，从最低位开始，依次进行一次排序。这样从最低位排序一直到最高位排序完成以后, 数列就变成一个有序序列。
     */
    public static void radixSort(int[] a){
        int len = a.length;
        // 1 确定位数（排序趟数）
        int pos = getMaxPos(a);
        LinkedList<Integer> queue[] = new LinkedList[10];
        // 2 建立10个队列
        for(int i = 0; i < 10; i++){
            queue[i] = new LinkedList<>();
        }
        // 3 进行pos次（分割位）分配和收集
        for(int i = 0; i < pos; i++){
            //3.1 分配数组元素
            for(int j = 0; j < len; j++){
                queue[a[j]/(int)Math.pow(10,i)%10].add(a[j]);
            }

            //3.2 收集队列元素
            int count = 0;
            for(int j = 0; j < 10; j++){
                while(!queue[j].isEmpty()){
                    a[count++] = queue[j].remove();
                }
            }
        }

    }

    public static int getMaxPos(int[] a){//获取数组元素中最大元素的位数
        int max = a[0];
        for(int i = 0;i < a.length; i++)
            if(a[i] > max)
                max = a[i];
        int d = 1;
        while( (max/=10) > 0){
            d++;
        }
        return d;
    }






}

