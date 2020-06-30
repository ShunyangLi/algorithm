import java.util.LinkedList;
import java.util.List;

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();

        traversal(root, res);
        return res;

    }

    public void traversal(TreeNode root, List<Integer> res) {
        if (root == null) return;

        res.add(root.val);
        traversal(root.left, res);
        traversal(root.right, res);
    }
}
