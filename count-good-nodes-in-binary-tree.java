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

    
    public int goodNodes(TreeNode root) {

        return dfs(root, Integer.MIN_VALUE);
    }

    private int dfs(TreeNode node, int maxVal) {
        // Base case -> if node is null, there are no good nodes to count
        if (node == null) return 0;

        // Update maxVal to the maximum between current node's value and maxVal so far
        maxVal = Math.max(maxVal, node.val);

        // Recursively count good nodes in the left and right subtrees
        int left = dfs(node.left, maxVal);
        int right = dfs(node.right, maxVal);

        // A node is "good" if its value is greater than or equal to all previous values in the path
        return left + right + (node.val >= maxVal ? 1 : 0);     // If it's a good node, count 1, otherwise count 0
    }
}
