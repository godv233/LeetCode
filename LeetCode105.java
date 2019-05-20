package LeetCode;

/**
 * ǰ�������ع�������
 * ֻҪ����ȷ�����ڵ㣬�ҳ��Ĳ��֡��Ϳ�����
 * @author GODV
 *
 */
public class LeetCode105 {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
			return null;
		}
		//�ҵ��ĸ����ֵݹ�
		//gen�ڵ�
		int mid = preorder[0];
		TreeNode root=new TreeNode(mid);
		int i = 0;
		//�ҵ����ڵ��������е�λ��
		for (i = 0; i < inorder.length; i++) {
			if (inorder[i] == mid) {
				break;
			}
		}
		int[] leftPre=new int[i];
		int[] leftIn=new int[i];
		int[] rightPre=new int[inorder.length-i-1];
		int[] rightIn=new int[inorder.length-i-1];
		for (int j = 0; j < inorder.length; j++) {
			if (j<i) {
				leftIn[j]=inorder[j];
			}
			if (j>i) {
				rightIn[j-i-1]=inorder[j];
			}
		}
		for (int j = 1; j < preorder.length; j++) {
			if (j<=i) {
				leftPre[j-1]=preorder[j];
			}else {
				rightPre[j-1-i]=preorder[j];
			}
		}
		
		//�ؽ�
		root.left=buildTree(leftPre,leftIn);
		root.right=buildTree(rightPre, rightIn);
		return root;

	}
}
