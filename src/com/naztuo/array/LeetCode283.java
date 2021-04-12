package com.naztuo.array;

/**
 * @Package com.naztuo.array
 * @Description: 移动零
 * @Author zhaoxiao x5445
 * @Date 2021-03-23 9:12
 * @Version 1.0
 */
public class LeetCode283 {

    /**
     * 用一个新的指针，当遇到不为0的数时，就将当前下标的值设为对应值，当移动到最后时，新的指针后的值都设为0即可
     * @param nums
     */
    public void moveZeros1(int[] nums) {
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }
        for(; j < nums.length; j++) {
            nums[j] = 0;
        }

    }

    /**
     * 本质上和第一种方式是一样的，只不过这个方法是加了个临时变量去交换两个指针下的值，交换完毕后就为得到的数组
     * @param nums
     */
    public void moveZeros2(int[] nums) {
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] num = new int[]{1,0,5,0,8};
        new LeetCode283().moveZeros1(num);
    }
}
