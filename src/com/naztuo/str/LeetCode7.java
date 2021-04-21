package com.naztuo.str;

/**
 * todo
 */
public class LeetCode7 {

    public int reverseNumber(int num) {
        String numStr = Integer.toString(num);
        System.out.println(numStr);
        String newStr = "";
        for(int i = numStr.length() -1 ; i >= 0 ; i--) {
            if(i == 0 && numStr.charAt(i) == '-') {
                newStr = '-' + newStr;
            } else {
                newStr  += numStr.charAt(i);

            }
        }
        System.out.println(Integer.parseInt(newStr));
        return Integer.parseInt(newStr);
    }

    public static void main(String[] args) {
        new LeetCode7().reverseNumber(1147483649);
    }
}
