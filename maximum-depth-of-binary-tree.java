//My sol

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
    int con = 0;
    public int maxDepth(TreeNode root) {

        if(root==null) return 0;
        
        count(root, 0);
        return con+1;
        
    }

    void count(TreeNode node, int len){
        
        if(node == null){
            len = 0;
            return;
        }

        con = Math.max(con, len++);

        count(node.left, len);
        count(node.right, len);
    } 
}

// Intended sol
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        // Recursively compute the depth of left and right subtrees
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        // Max of left and right depth + 1 (for current node)
        return Math.max(left, right) + 1;
    }
}
