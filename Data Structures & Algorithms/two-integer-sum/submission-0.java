class Solution {
    public int[] twoSum(int[] nums, int target) {
        return findNums(nums, target);
    } 

    public int[] findNums(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int j = 0; j < nums.length; j++) {
            int difference = target - nums[j];
            if (map.containsKey(difference)){
                return new int[] {map.get(difference), j};
            }
            map.put(nums[j], j);
        }
        return new int[] {};
    }   
}
