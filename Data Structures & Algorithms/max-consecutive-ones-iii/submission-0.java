public class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0, res = 0;
        for (int r = 0; r < nums.length; r++) {
            // we found a zero, subtracting from k by 1 is equivalent to changing the zero to one
            k -= (nums[r] == 0 ? 1 : 0);
            // we've made k negative exhausting our flips, need to make sure its no longer negative
            while (k < 0) {
                // if the num at index l is a 0, increment k by 1 and slide l to move the window
                k += (nums[l] == 0 ? 1 : 0);
                l++;
            }
            // take the max of what result is now and right subtracted by left + 1
            // this is our running longest consecutive ones
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}