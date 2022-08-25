// 层序遍历得到的节点值（即逐层地，从右到左访问所有节点）
// 示例： 二叉树：[3,9,20,7,null,15,7]
// 输出：[[3],[9,20],[7,15,7]]

//递归方式
// function levelTraverse(root, level, arr) {

// }
//迭代方式
/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */

function levelTraverse(root) {
    var result = [];
    if (!root) {
        return result;
    }
    var stack = [];
    stack.push(root);
    while (stack.length !== 0) {
        var currentNodeSize = stack.length;
        result.push([]);
        for(var i= 1; i<=currentNodeSize; i++) {
            var node = stack.shift();
            result[result.length-1].push(node.val);
            if(node.left) stack.push(node.left);
            if(node.right) stack.push(node.right);
        }

    }
    return result;
}
