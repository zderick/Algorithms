/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
*/

public List<List<Integer>> levelOrder(TreeNode root) {

	List<List<Integer>> result = new ArrayList<>();
	if(root == null) return result;

	Queue<TreeNode> q = new LinkedList<>();
	q.offer(root);

	while(!q.isEmpty()){
		int size = q.size();
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < size; i++){
			TreeNode cur = q.poll();
			if(cur.left != null) q.offer(cur.left);
			if(cur.right != null) q.offer(cur.right);

			list.add(cur.val);
		}
		result.add(list);
	}

	return result;
}