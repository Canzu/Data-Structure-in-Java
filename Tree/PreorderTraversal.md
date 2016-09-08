/**
* 前序遍历的算法描述
*/
算法：PreorderTraversal(v)
输入：树节点 v
输出：v 所有后代的前序遍历序列

{
	if (null != v) {
		首先访问并输出 v;
		
		for (u = v.getFirstChild(); null != u; u=u.getNextSibling())//依次
			PreorderTraversal(u);//前序遍历v的各棵子树
	}
}