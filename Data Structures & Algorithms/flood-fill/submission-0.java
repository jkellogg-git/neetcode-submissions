class Solution {
    public int[][] floodFill(int[][] image, 
    int sr, int sc, int color) {

        // original is important here because we can only paint a cell with the same color
        // i.e: if the cell's starting value is 3 and we need to paint 4, we can't paint on 0, or 1
        // this helps us check without needing a hashmap
        int original = image[sr][sc];
        // first guard against stack overflow
        if (original == color) return image;
        // m and n are necssary for the bounds checks on line 26
        int m = image.length;
        int n = image[0].length;

        // start the recursive helper function
        helper(image, sr, sc, original, color, m, n);
        // return the grid
        return image;
    }
    

    void helper(int[][] grid, int r, int c, int original, int paint,
                int m, int n) {
        // guards: check for out of bounds, can't look at cells outside of the gride
        // r can't be less than 0 and cannot be equal to or greater than the length of the row
        // additionally if the cell doesn't have the original color (value) return
        if ((r < 0 || r >= m) || (c < 0 || c>= n) || 
            grid[r][c] != original) {
                return;
        }

        // simply paint the cell sense the above checks are taken care of
        grid[r][c] = paint;
        
        // recurse the helper function by checking all neighbors and all directions
        helper(grid, r, c + 1, original, paint, m, n);
        helper(grid, r, c - 1, original, paint, m, n);
        helper(grid, r + 1, c, original, paint, m, n);
        helper(grid, r - 1, c, original, paint, m, n);

    }
}