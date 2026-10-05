class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length > n-1) return false;
        
        // setup adj list, each index within length having its own
        // list to store neighbors
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        // set up visited hashset to keep track of cycles, as valid trees cannot have em
        HashSet<Integer> visited = new HashSet<>();

        // fill each list in adj with edges and their respective neighbor pairs
        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        // begin the recursive dfs call, passing in 0 as the starting node
        // -1 as the previous (parent) node, and the visited and adj list
        // if its not true, return false, not a valid tree
        if(!dfs(0, -1, visited, adj)) return false;

        // if we have all n nodes, we have a valid tree
        return visited.size() == n;
    }
    private boolean dfs(int node, int parent, 
        HashSet<Integer> visited, List<List<Integer>> adj) {
            // check if our visited set has the current node
            // if yes, we've detected a cycle and the three ain't valid
            if(visited.contains(node)) return false;

            // otherwise we need to add the node to visited
            visited.add(node);

            // now we need to loop through the neighbors of the node
            // within the loop we'll recursively call dfs passing the neighbor
            // and the parent node we came from to prevent double work
            for (int neighbor : adj.get(node)) {
                // we don't need work through the parent, we were just there
                if (neighbor == parent) continue;

                // call dfs again, if false return false back up
                if(!dfs(neighbor, node, visited, adj)) return false;
            }
            return true;
        }
}
