package LeetCode;

/**
 * 
 * @author GODV
 * @date 2019��5��20������12:49:32
 * @description:ɾ�������������еĽڵ� ˼�룺�����Ҷ�ӽڵ㣬ֱ��ɾ��������Ҷ�ӽڵ㣬ɾ��֮���������ӽڵ��ֵ����ȥ
 */
public class LeetCode450 {
	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null)
			return null;
		//1.�ҵ�ɾ���ڵ����ڵ�λ��
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
		//���ҽڵ㶼���ڵ����
		TreeNode successor = findMin(root.right);//�ҵ���������С
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
