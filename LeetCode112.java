package LeetCode;

//������·���� 
/**
 * @author GODV
 *
 */
public class LeetCode112 {
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;// �ݹ���ֹ������
		}
		if (root.left == null && root.right == null) {
			return sum - root.val == 0;
		} // �Ƿ���ȷ�Ĺؼ�

		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);//�ݹ�ķ���ֵ
	}
}
