package com.zed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Zed
 * @date 2020/3/6 下午2:24
 * @contact shadowl91@163.com
 */
public class Wind {


    public static List<Integer[]> wind11(int[] nums, int target) {
        List<Integer[]> list = new ArrayList<Integer[]>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                Integer[] result = new Integer[2];
                result[0] = target - nums[i];
                result[1] = nums[i];
                list.add(result);

            } else {
                map.put(nums[i], i);
            }
        }
        if (list.size() < 1)
            list.add(new Integer[]{-1, -1});
        return list;
    }


    public static void main(String[] args) {
//        List<Integer[]> list = new ArrayList<Integer[]>();
//        int[] nums = new int[]{5,7,9,10,13};
//        list = wind11(nums, 23);
//        for (Integer[] i: list)
//            System.out.println(i[0] + "" +i[1]);

        for (int i = 1; i < 15; i++) {
            List<Integer> integers = wind12(i, 15, new ArrayList<Integer>());
            for (Integer ii:integers)
                System.out.println(ii);
        }
    }
    public static List<Integer> wind12(int temp, int target, List<Integer> list) {
        Thread thread = new Thread();
        target = target - temp;
        if (target > 0)
            list.add(temp);
        if (target == 0) {
            list.add(temp);
            return list;
        }
        if (target <0) {
            list.clear();
            return null;
        }
        wind12(temp + 1, target, list);
        return list;
    }
}
