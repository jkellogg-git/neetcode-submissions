class Solution {
    public int maxProfit(int[] prices) {
        int left = 0, res = 0;
        for (int right = 0; right < prices.length; right++) {
            if (prices[left] > prices[right]) {
                left = right;
            } else {
                res = Math.max(res, prices[right] - prices[left]);
            } 
        }
        return res;
    }
}
