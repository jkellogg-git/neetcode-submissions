class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        HashSet<Integer> visited = new HashSet<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int count = 0;
        for (int i = 0; i < n; i++){
            if(!visited.contains(i)){
                count++;
                dfs(i, visited, adj);
            }
        }
        return count;
    }
    private void dfs(int node, HashSet<Integer> visited, List<List<Integer>> adj){
        visited.add(node);
        for (int neighbor : adj.get(node)) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, visited, adj);
            } 
        }
    }
}
