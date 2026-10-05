class Solution {
    Boolean[][] memo;
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // edge case. target needs to be even and 
        //we need to have two subset. can't have that with an odd numer
        if (sum % 2 != 0) return false;

        // sum is even, we have our target, set up the 2d bool array
        memo = new Boolean[n][sum/2 + 1];

        // begin recursive helper function
        return calculate(nums, 0, sum/2);
    }
    public boolean calculate(int[] nums, int i, int target) {
        // first base case, check if we found the winning combo
        if (i == nums.length) {
            // in the case of [1,2,3,4] if i = 4
            // AND target is 0, return true otherwise false 
            return target == 0;
        }
        // second base case, we decremented target below 0
        if (target < 0) return false;

        // memo: if the current element isn't null, we've seen it
        // just return its value
        if (memo[i][target] != null) return memo[i][target];

        // set memo to the short circuit of our recurive calls
        // 1: i + 1 and target || 2: i + 1 and target - nums[i]
        // target - nums[i] because we want to see if target is 0
        // if yes, we found the winning combo
        memo[i][target] = calculate(nums, i+1, target) || calculate(nums, i+1, target - nums[i]);
        return memo[i][target];
    }
}
