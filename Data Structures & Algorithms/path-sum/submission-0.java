/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false; 
        }
        int runningSum = 0;
        return calculate(root, runningSum, targetSum);

    }

    public boolean calculate(TreeNode root, int runningSum, int targetSum) {

        if (root == null) return false;
        runningSum += root.val;

        if (isLeaf(root) && runningSum == targetSum) {
            return true;
        } else if (isLeaf(root) && runningSum != targetSum) {
            return false;
        }

        return calculate(root.left, runningSum, targetSum) 
        || calculate(root.right, runningSum, targetSum);
    }

    public boolean isLeaf(TreeNode root) {
        if (root.left == null && root.right == null) {
            return true;
        } else {
            return false;
        }
    }
}