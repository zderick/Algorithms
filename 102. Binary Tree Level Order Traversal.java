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

//Breadth First Search
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


//Depth First Search
public List<List<Integer>> levelOrder(TreeNode root){
	List<List<Integer>> result = new ArrayList<>();
	if(root == null) return result;
	helper(result, root, 0);
	return result;
}

public void helper(List<List<Integer>> result, TreeNode root, int cur){
	if(root == null) return;
	if(result.size() == cur){
		result.add(new ArrayList<>());
	}

	result.get(cur).add(root.val);
	helper(result, root.left, cur + 1);
	helper(result, root.right, cur + 1);
}