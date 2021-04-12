package com.naztuo.diguifenzhi;

import java.util.LinkedList;
import java.util.List;

/**
 * @Package com.naztuo.diguifenzhi
 * @Description: 汉诺塔问题
 * @Author zhaoxiao x5445
 * @Date 2021-03-19 16:31
 * @Version 1.0
 */
public class MianShi10 {

    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        move(A.size(), A, B, C);
    }

    private void move(int num, List<Integer> A, List<Integer> B, List<Integer> C) {
        if (num == 0) {
            return;
        }
        //利用A和C,移动N-1个元素到B上
        move(num - 1, A, C, B);
        //把A上最后一个元素移动到C
        C.add(A.remove(A.size() - 1));
        //利用A和B,移动N-1个元素到C上
        move(num - 1, B, A, C);
    }


    private void move1(int num, List<Integer> from, List<Integer> to, List<Integer> temp) {
        if (num == 0) { //都移完
            return;
        }
        move1(num - 1, from, temp, to);
        temp.add(from.remove(from.size() - 1));
        move1(num - 1, to, from, temp);
    }
}
