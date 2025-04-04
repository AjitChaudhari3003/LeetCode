// 257. Binary Tree Paths
// Given the root of a binary tree, return all root-to-leaf paths in any order.
// A leaf is a node with no children.
// Example 2:
// Input: root = [1]
// Output: ["1"]

// CODE

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        dfs(root, "", result);
        return result;
    }

    private void dfs(TreeNode node, String path, List<String> result) {
        if (node == null) return;
        path += node.val;

        if (node.left == null && node.right == null) {
            result.add(path);
        } else {
            path += "->";
            dfs(node.left, path, result);
            dfs(node.right, path, result);
        }
    }
}
