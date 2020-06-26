public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return mirror(root.left, root.right);
    }
    // 判断左右是否一样
    public boolean mirror(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        boolean left = mirror(p.left, q.right);
        boolean right = mirror(p.right, q.left);

        return p.val == q.val && (left && right);
    }
}
