package solution;

import java.util.*;

/**
 * @author Zeluo
 * @date 2019/9/10 16:00
 */
public class Solution {
    /**
     * set去重
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        if (candidates.length < 1)
            return res;
        Arrays.sort(candidates);
        this.helper(candidates, target, set, new ArrayList<>(), 0);
        res = new ArrayList<>(set);
        return res;
    }
    private void helper(int[] candidates, int target , Set<List<Integer>> res, List<Integer> list, int start) {
        if (target == 0){
            res.add(list);
            return;
        }
        if(target < 0)
            return;
        for (int i = start; i<candidates.length && target >= candidates[i] ; i++) {
            list.add(candidates[i]);
            helper(candidates,target-candidates[i],res,new ArrayList<>(list),i+1);
            list.remove(list.size() -1);
        }
    }

}
