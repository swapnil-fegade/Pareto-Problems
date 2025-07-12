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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> levelOrder = new LinkedList<>();    //Level wise traversal
        List<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        levelOrder.add(root);       // First root will always included in right view
        levelOrder.add(null);      // Add level delimiter (null marks the end of the current level)

        while (!levelOrder.isEmpty()) {
            TreeNode curr = levelOrder.remove();        // Current node
          
            // If current node is null and the queue is empty, we've processed all levels
            if (curr == null && levelOrder.isEmpty()) {     // if curr node is null and there is no node on that level
                break;                                      // then break
            }

            // End of current level; add a null marker for the next level
            if(curr == null){   // if curr is null but there are more node in that level 
                levelOrder.add(null);   // add null
            }

            // Add left and right children of the current node to the queue (if they exist)          
            if(curr!=null){
                if(curr.left!=null) levelOrder.add(curr.left);    
                if(curr.right!=null) levelOrder.add(curr.right);    
            }

            if(levelOrder.peek()==null && curr!=null){      // If the next node is null, current node is the last node of this level yani rightmost node
                ans.add(curr.val);                          // So, add its value to the answer list
            }

        }
        return ans;
    }

}

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();           // Stores the final right side view
        Queue<TreeNode> q = new LinkedList<>();          // Queue for level-order (BFS) traversal

        if (root != null) q.offer(root);                 // Start BFS with the root node

        while (!q.isEmpty()) {
            TreeNode rightSide = null;                   // To track the rightmost node at this level
            int size = q.size();                         // Number of nodes at the current level

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();                // Dequeue the current node

                if (node != null) {
                    rightSide = node;                    // Update rightSide to the latest node at this level

                    if (node.left != null) q.offer(node.left);   // Enqueue left child if it exists
                    if (node.right != null) q.offer(node.right); // Enqueue right child if it exists
                }
            }

            if (rightSide != null) {
                ans.add(rightSide.val);                  // Add the rightmost node's value to the result
            }
        }

        return ans;                                      // Return the complete right side view
    }
}
