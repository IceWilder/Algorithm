var maxDepth = 0;
function getMaxDepth(root) {
    dfs(root, 0);
    return maxDepth;
}
function dfs(root, depth) {
    if (!root) {
        maxDepth = Math.max(maxDepth, depth);
        return;
    }
    dfs(root.left, depth + 1);
    dfs(root.right, depth + 1);
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
console.log(getMaxDepth(tree));