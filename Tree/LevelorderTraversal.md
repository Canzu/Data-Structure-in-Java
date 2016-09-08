/**
* 层次遍历的算法描述
*/
算法：LevelorderTraversal(v)
输入：树节点 v
输出：v 所有后代的层次遍历序列

{
	if (null != v) {
	    创建一个队列 Q;
	    Q.enqueue(v); //根节点入队
		while (!Q.isEmpty()) {
		//在队列重新变空之前
		u = Q.dequeue(); //取出队列的首节点 u
		访问并输出 u;
		for (w = u.getFirstChild(); null != w; w = w.getNextSibling()) //依次将u的
		    Q.enqueue(w); //每个孩子 w 加至队列中
	    } //while
	} //if
}