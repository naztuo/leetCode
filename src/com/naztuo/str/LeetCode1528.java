package com.naztuo.str;

/**
 * @Package com.naztuo.str
 * @Description:
 * @Author zhaoxiao x5445
 * @Date 2021-03-29 11:05
 * @Version 1.0
 */
public class LeetCode1528 {

    public String restoreString(String s, int[] indices) {
        char chars[] = new char[indices.length];
        for(int i = 0; i < indices.length; i++) {
            chars[indices[i]] = s.charAt(i);
        }
        StringBuffer sb = new StringBuffer();
        for(char c : chars) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "aaiougrt";
        int[] indices = new int[]{4,0,2,6,7,3,1,5};
        System.out.println(new LeetCode1528().restoreString(s,indices));
    }
}
