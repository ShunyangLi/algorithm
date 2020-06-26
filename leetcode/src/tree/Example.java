package tree;
import tree.Node;

public class Example {

    /**
     * 平衡二叉树，左字树和右子树高度相同
     *
     * @param root
     * @param x
     * @return
     */
    public boolean search(Node root, int x) {
        if (root == null) return false;
        if (root.val == x) return true;

        if (x < root.val) return search(root.left, x);
        else return search(root.right, x);
    }

    public void preorder(Node root) {
        if (root == null) return;
        System.out.print(root.val);
        preorder(root.left);
        preorder(root.right);
    }

    /**
     * 在BST里面使用inorder是输出排序过的结果
     * @param root node
     */
    public void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val);
        inorder(root.right);
    }

    public void postorder(Node root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val);
    }


    public Node create(int[] nums) {
        Node root = null;

        for (int x : nums) root = insert(root, x);

        return root;
    }

    public Node insert(Node root, int val) {
        if (root == null) return new Node(val);

        if (val <= root.val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    /**
     * 104
     * 求最大深度的算法
     * @param root Node
     * @return
     */
    public int tree_max(Node root) {
        if (root == null) return Integer.MIN_VALUE;

        int max_left = tree_max(root.left);
        int max_right = tree_max(root.right);

        return Math.max(root.val, Math.max(max_left, max_right));
    }

    /**
     * 求最小深度的算法 111
     * @param root Node
     * @return min depth
     */
    public int MinDepth(Node root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;

        int left = MinDepth(root.left);
        int right = MinDepth(root.right);

        if (root.left == null) return right + 1;
        if (root.right == null) return left + 1;

        return Math.min(left, right) + 1;
    }

    /**
     * 查看该tree是否有加和等于该sum的数据  112
     * @param root
     * @param sum
     * @return
     */
    public boolean PathSum(Node root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return root.val == sum;

        boolean left = PathSum(root.left, sum - root.val);
        boolean right = PathSum(root.right, sum - root.val);

        return left | right;
    }

    // 下面是关于两个node的解决方法

    /**
     * func solve(p, q):
     *  if not q and not p return ...
     *  if f(p,q) return ....
     *  c1 = solve(p.child, q.child)
     *  c2 = solve(p.child, q.child)
     *  return g(p, q, c1, c2)
     */

    /**
     * 100
     * 判断两个树是不是相等
     * @param t1 Node
     * @param t2 Node
     * @return boolean
     */
    public boolean SameTree(Node t1, Node t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;

        boolean left = SameTree(t1.left, t2.left);
        boolean right = SameTree(t1.right, t2.right);

        return t1.val == t2.val && (left && right);
    }

    /**
     * 101
     * 判断两个树是不是镜像，和上面的问题刚好相反
     * @param t1　Node
     * @param t2 Node
     * @return boolean
     */
    public boolean mirror(Node t1, Node t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;

        boolean left = mirror(t1.left, t2.right);
        boolean right = mirror(t1.right, t2.left);

        return t1.val == t2.val && (left && right);
    }


    public static void main(String[] args) {
        Example e = new Example();
        int[] nums = new int[] {5,3,1,4,7,6};
        Node root = e.create(nums);
//        Node root = new Node(5);
//        Node left = new Node(3);
//        Node right = new Node(7);
//        root.left = left;
//        root.right = right;
//
//        left.left = new Node(1);
//        left.right = new Node(4);
//
//        right.left = new Node(6);
        e.preorder(root);
        System.out.println();

        e.inorder(root);
        System.out.println();

        e.postorder(root);
        System.out.println();

        System.out.println(e.MinDepth(root));
    }

}
