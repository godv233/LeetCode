package LeetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * @author GODV
 * @date 2019年5月19日下午11:41:40 description:N叉树的最大深度
 *       第一种想法是DFS递归写法求N叉树的深度。第二种想法是层序遍历N叉树求N叉树深度。
 */
class Node {
	public int val;
	public List<Node> children;

	public Node() {
	}

	public Node(int _val, List<Node> _children) {
		val = _val;
		children = _children;
	}
};

public class LeetCode559 {
	public int maxDepth(Node root) { // DFS递归写法
		if (root == null)
			return 0;
		int depth = 0;
		for (int i = 0; i < root.children.size(); i++) {
			depth = Math.max(depth, maxDepth(root.children.get(i)));
		}
		return depth + 1;
	}
	public int maxDepth2(Node root) {  //BFS遍历解法
        if(root == null)
            return 0;
        if(root.children.size() == 0)
            return 1;
        int depth = 0;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while(!queue.isEmpty()){
            int count = queue.size();
            depth++;
            while(count > 0){
                Node node = queue.poll();
                if(node.children.size() != 0)
                    queue.addAll(node.children);              
                count--;                
            }
        }
        return depth;        
    }
}
