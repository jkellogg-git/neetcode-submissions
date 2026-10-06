class Solution {
    public int countComponents(int n, int[][] edges) {
    
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        /*
            0 --> 1
            1 --> 0, 2
            2 --> 1, 3
            3 --> 2, 4
            4 --> 3
        */
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        HashSet<Integer> seen = new HashSet<>();

        int count = 0;
        for (int i = 0; i < n; i++) {
            if(!seen.contains(i)){
                count++;
                dfs(i, seen, adj);
            }  
        }
        return count;
    }
    private void dfs(int node, HashSet<Integer> seen, List<List<Integer>> adj) {
        /*
            0 --> 1
            1 --> 0, 2
            2 --> 1, 3
            3 --> 2, 4
            4 --> 3
        */
        seen.add(node);
        for(int neighbor : adj.get(node)){
            if(!seen.contains(neighbor)) {
                dfs(neighbor, seen, adj);
            }
        }
    }
}
