class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for (String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String sorted = new String(c);
            res.putIfAbsent(sorted, new ArrayList<>());
            res.get(sorted).add(s);
        }
        return new ArrayList<>(res.values());
    }
}
