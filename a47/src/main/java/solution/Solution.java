//package solution;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
///**
// * @author Zeluo
// * @date 2019/9/12 9:46
// */
//public class Solution {
//    public List<List<Integer>> permuteUnique(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        Arrays.sort(nums);
//    }
//    private void helper(int[] nums, List<List<Integer>> res, List<Integer> list, int depth) {
//        if (depth == nums.length) {
//            for (int i: nums)
//                list.add(i);
//            res.add(list);
//        }
//        for (int i = depth; i < nums.length; i++) {
//
//        }
//    }
//    private void swap(int[] nums, int left, int right) {
//        int temp = nums[left];
//        nums[left] = nums[right];
//        nums[right] = temp;
//    }
//}
