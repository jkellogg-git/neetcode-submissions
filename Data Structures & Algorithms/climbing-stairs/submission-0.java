class Solution {
    HashMap<Integer, Integer> cache = new HashMap<>();
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        int result = climbStairs(n - 1) + climbStairs(n - 2);
        cache.put(n, result);
        return result;
    }
}
