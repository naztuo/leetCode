package com.naztuo.str;

/**
 * @Package com.naztuo.str
 * @Description: url化
 * @Author zhaoxiao x5445
 * @Date 2021-03-29 10:49
 * @Version 1.0
 */
public class MianShi0103 {
    public String replaceSpaces(String s, int length) {
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < length; i++) {
            char c = s.charAt(i);
            sb.append(c == ' ' ? "%20" : c);
        }
        return sb.toString();
    }
    public String replaceSpaces1(String s, int length) {
        return s.substring(0,length).replace(" ","%20");
    }
    public static void main(String[] args) {
        String s = "Mr John Smith ";
        System.out.println(new MianShi0103().replaceSpaces1(s,13));
    }
}
