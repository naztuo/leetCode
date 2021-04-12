package com.naztuo.diguifenzhi;

/**
 * @Package com.naztuo.diguifenzhi
 * @Description: 二分查找
 * @Author zhaoxiao x5445
 * @Date 2021-04-07 16:14
 * @Version 1.0
 */
public class ErfenSearch {
    /**
     * @param a     数组
     * @param n     数组元素个数
     * @param value 要查找的元素
     * @return
     */
    public int bsearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int middle = low + ((high - low) >> 1);
            if (a[middle] == value) {
                return middle;
            } else if (a[middle] > value) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }

    public int bsearch1(int[] a, int n, int value) {
        return bsearchInternally(a,0,a.length - 1,value);
    }

    private int bsearchInternally(int[] a, int low, int high, int value) {
        if (low > high) return -1;
        int middle = low + ((high - low) >> 1);
        if (a[middle] == value) {
            return middle;
        } else if (a[middle] < value) {
            return bsearchInternally(a, middle + 1, high, value);
        } else {
            return bsearchInternally(a, low, middle - 1, value);
        }
    }
}
