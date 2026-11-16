class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> count = new HashMap<>();
        int left = 0, maxFreq = 0, res = 0;
        for (int right = 0; right < s.length(); right++) {
            count.put(s.charAt(right), count.getOrDefault(s.charAt(right), 0) + 1);
            maxFreq = Math.max(maxFreq, count.get(s.charAt(right)));
            // window size - maxFreq > k
            while ((right - left + 1) - maxFreq > k) {
                count.put(s.charAt(left), count.get(s.charAt(left)) - 1);
                left++;
            }
            res = Math.max(res, (right - left) + 1);
        }
        return res;
    }
}
