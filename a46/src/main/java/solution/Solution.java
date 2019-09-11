package solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zeluo
 * @date 2019/9/11 17:08
 */
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, new ArrayList<>(), res);
        return res;
    }
    private void helper(int[] nums, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == nums.length) {
            res.add(list);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i]))
                continue;
            list.add(nums[i]);
            helper(nums, new ArrayList<>(list), res);
            list.remove(list.size()-1);
        }
    }
}
