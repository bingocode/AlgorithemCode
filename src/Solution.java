import java.util.Arrays;

public class Solution {
    public boolean isContinuous(int [] numbers) {
        if(numbers == null || numbers.length <5)
            return false;
        int n = numbers.length;
        Arrays.sort(numbers);
        int count0 = 0;
        int dif = 0;
        for(int i = 0; i< n-1; i++){
            if(numbers[i] == 0){
                count0++;
                continue;
            }
            else if(numbers[i] == numbers[i+1]){
                return false;
            }
            else{
                dif += numbers[i+1] - numbers[i] -1;
            }
        }
        if(dif <= count0)
            return true;
        else
            return false;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        int[] a =  { 1 ,3 ,4,2,5};
        System.out.print(s.isContinuous(a));
    }
}