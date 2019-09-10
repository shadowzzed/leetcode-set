package solution;

/**
 * @author Zeluo
 * @date 2019/9/10 17:45
 */
public class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums.length < 1)
            return 1;
        for (int i = 0; i < nums.length; i++) {
            while(nums[i] > 0 && nums[i] <= nums.length && nums[nums[i]-1] != nums[i]) {
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;

                /**
                 * 以下写法可能导致数组越界
                 * 因为原先位置上的数是经过检查的
                 * 但是换过来的没有
                 */
//                int temp = nums[i];
//                nums[i] = nums[nums[i]-1];
//                nums[nums[i]-1] = temp;

            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1)
                return i+1;
        }
        return nums[nums.length-1]+1;
    }
}
