package solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zeluo
 * @date 2019/9/11 17:41
 */
public class Solution2 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, res, 0);
        return res;
    }
    private void helper(int[] nums, List<List<Integer>> res, int start) {
        if (nums.length == start) {
            List<Integer> list = new ArrayList<>();
            for (int i: nums)
                list.add(i);
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            helper(nums, res, start+1);
            swap(nums, start, i);
        }

    }
    private void swap(int[]nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
