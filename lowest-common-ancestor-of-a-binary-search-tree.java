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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return LCA(root, p, q);
    }

    private TreeNode LCA(TreeNode node, TreeNode p, TreeNode q) {
        if(node == null) return null;

        if((p.val <= node.val && q.val >= node.val) || (p.val >= node.val && q.val <= node.val)) {
            return node;
        }

        if(p.val < node.val && q.val < node.val) return LCA(node.left, p, q);
        else return LCA(node.right, p, q);
    }
}
