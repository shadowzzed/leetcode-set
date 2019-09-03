package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Zeluo
 * @date 2019/9/3 10:56
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates.length < 1 || candidates == null) {
            return res;
        }
        Arrays.sort(candidates);
        this.helper(candidates,target,res,new ArrayList<>(),0);
        return res;
    }
    private void helper(int[] candidates, int target , List<List<Integer>> res, List<Integer> list, int start) {
        if (target == 0){
            res.add(list);
            return;
        }
        if(target < 0)
            return;
        for (int i = start; i<candidates.length && target >= candidates[i] ; i++) {
            list.add(candidates[i]);
            helper(candidates,target-candidates[i],res,new ArrayList<>(list),i);
            list.remove(list.size() -1);
        }
    }
}
