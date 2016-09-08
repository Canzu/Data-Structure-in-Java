/**
* 后序遍历的算法描述
*/
算法：PostorderTraversal(v)
输入：树节点 v
输出：v 所有后代的后序遍历序列

{
	if (null != v) {
		for (u = v.getFirstChild(); null != u; u=u.getNextSibling())//依次
			PreorderTraversal(u);//后序遍历v的各棵子树
		
		当所有后代都访问过后，最后才输出节点 v;
	}
}