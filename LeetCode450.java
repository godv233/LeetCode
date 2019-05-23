package LeetCode;

/**
 * 
 * @author GODV
 * @date 2019年5月20日下午12:49:32
 * @description:删除二叉搜索树中的节点 思想：如果是叶子节点，直接删除。不是叶子节点，删除之后考虑左右子节点的值顶上去
 */
public class LeetCode450 {
	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null)
			return null;
		//1.找到删除节点所在的位置
		if (key < root.val) {
			root.left = deleteNode(root.left, key);
			return root;
		}
		if (key > root.val) {
			root.right = deleteNode(root.right, key);
			return root;
		}
		
		// root.val==key
		if (root.left == null)
			return root.right;
		if (root.right == null)
			return root.left;
		//左右节点都存在的情况
		TreeNode successor = findMin(root.right);//找到右树的最小
		successor.right = deleteMin(root.right);
		successor.left = root.left;
		return successor;
	}

	private TreeNode findMin(TreeNode node) {
		if (node == null || node.left == null)
			return node;
		return findMin(node.left);
	}

	private TreeNode deleteMin(TreeNode node) {
		if (node == null)
			return null;
		if (node.left == null)
			return node.right;
		node.left = deleteMin(node.left);
		return node;
	}
}
