package jianzhioffer;

/**
 * Created by admin on 2017/10/5.
 */
/*
替换空格：先计算替换后的总长度，然后从后到前遍历替换。
 */
public class Test04 {
    public String replaceSpace(StringBuffer str) {
        int originalLength = str.length()-1;  //字符串str原长度
        int numberOfBlank = 0;   //空格的个数
        //int i = 0;
        for(char c : str.toString().toCharArray()){
            if (c == ' '){
                numberOfBlank++;
            }
        }
        int newLength = originalLength + numberOfBlank*2+1;
        str.setLength(newLength);
        newLength = newLength-1;
        while (originalLength >= 0 && newLength > originalLength){
            if (str.charAt(originalLength) == ' '){
                str.setCharAt(newLength--,'0');
                str.setCharAt(newLength--,'2');
                str.setCharAt(newLength--,'%');
            }else{
                str.setCharAt(newLength--,str.charAt(originalLength));
            }
            originalLength--;
        }
        return str.toString();
    }
}
