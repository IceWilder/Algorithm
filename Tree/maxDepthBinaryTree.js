//求一颗二叉树最大深度
//先序遍历
// var maxDepth = 0;
// function getMaxDepth(root) {
//     dfs(root, 0);
//     return maxDepth;
// }
// function dfs(root, depth) {
//     if (!root) {
//         maxDepth = Math.max(maxDepth, depth);
//         return;
//     }
//     dfs(root.left, depth + 1);
//     dfs(root.right, depth + 1);
// }
//后序遍历
function dfs(root) {
    if(!root) {
        return 0;
    }
    var leftMaxDepth = dfs(root.left);
    var rightMaxDepth = dfs(root.right);
    return Math.max(leftMaxDepth, rightMaxDepth) + 1;
}
var tree = {
    left: {
        left: {
            left: {
                left: {},
            }
        },
        right:{}
    },
    right: {
        left: {},
        right: {},
    }
}
console.log(dfs(tree));