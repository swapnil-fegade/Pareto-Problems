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
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    void invert(TreeNode node) {
        if (node == null) return;

        // Swap left and right child
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

        // Recurse on children
        invert(node.left);
        invert(node.right);
    }
}
