package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 *������ĸ���
 * @author GODV
 * @date 2019��7��7������5:22:12
 * @description:
 */
public class LeetCode17 {
	//�ݹ麯����curΪ��ǰ�Ѿ����������ַ���digitsΪ��Ŀ�������ַ�����
    //�򵥵�ԭ��������һ�δ�ÿһ�����ֶ�Ӧ���ַ�����ȡ������Ȼ�����ײ㿪ʼ�������������ϡ�������list.
	List<String> res=new ArrayList<>();
	String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"}; //����绰����
	
	public List<String> letterCombinations(String digits) { 
		if (digits.length()==0||digits==null) {
			return res;
		}
		getString("",digits);
		return res;
	}

	private void getString(String curStr, String digits) {
		if (curStr.length()==digits.length()) {
			res.add(curStr);
			return;
		}
		int curIndex=digits.charAt(curStr.length())-'0';//�õ���ǰ�ı���λ��
		for (int i = 0; i < map[curIndex].length(); i++) {
			getString(curStr+map[curIndex].charAt(i), digits);//������������ȱ���
		}
	}
}
