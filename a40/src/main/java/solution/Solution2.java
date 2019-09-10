package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Zeluo
 * @date 2019/9/10 17:37
 */
public class Solution2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length < 1)
            return res;
        Arrays.sort(candidates);
        this.helper(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void helper(int[] nums, int target, int start, List<Integer> list, List<List<Integer>> res) {
        if (target == 0) {
            res.add(list);
            return;
        }
        if (target < 0)
            return;
        for (int i = start; i < nums.length && nums[i] <= target; i++) {
            if (i>start && nums[i] == nums[i-1])
                continue;
            list.add(nums[i]);
            helper(nums, target - nums[i], i + 1, new ArrayList<>(list), res);
            list.remove(list.size() - 1);
        }
    }
}
