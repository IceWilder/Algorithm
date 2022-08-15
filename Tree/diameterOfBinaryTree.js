// leetcode 543 
// 链接：https://leetcode.cn/problems/diameter-of-binary-tree
// 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
//  
// 示例 :
// 给定二叉树
//           1
//          / \
//         2   3
//        / \     
//       4   5    
// 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。

var maxDiameter = 0;
function diameterOfBinaryTree(root) {
    reverse(root);
    return maxDiameter;
}
//后序遍历
function reverse(root) {
    if(!root) {
        return 0;
    }
    var leftMax = reverse(root.left);
    var rightMax = reverse(root.right);
    var maxDepth = Math.max(leftMax,rightMax);
    maxDiameter = Math.max((leftMax + rightMax), maxDiameter);
    return maxDepth + 1;
}