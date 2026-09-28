class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int current = 0;

        for (int num : nums) {
            System.out.println("Num = " + num);
            if (num == 1) {
                current++;
            } else {
                current = 0;
            }
            max = Math.max(max, current);
        }
        return max;
    }
}