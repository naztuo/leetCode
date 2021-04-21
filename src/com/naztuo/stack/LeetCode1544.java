package com.naztuo.stack;

/**
 * @Package com.naztuo.stack
 * @Description: TODO
 * @Author zhaoxiao x5445
 * @Date 2021-03-15 17:22
 * @Version 1.0
 */
public class LeetCode1544 {

    public String zhengliStr(String str) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (sb.length() == 0) {
                sb.append(str.charAt(i));
            } else {
                String a = String.valueOf(sb.charAt(sb.length() - 1));
                String b = String.valueOf(str.charAt(i));
                if (a.equalsIgnoreCase(b) && !a.equals(b)) {
                    sb.deleteCharAt(sb.length() - 1);
                } else {
                    sb.append(str.charAt(i));
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode1544().zhengliStr("abBAcC"));
    }
}
