/**
* 基于向量秩实现的完全二叉树节点类
*/
package ds_java;

public class CompleteBinTreeNode_Rank extends BinTreeNode implements BinTreePosition {
	//所属的树
	private Vector T;
	//在所属的树中的秩
	private int rank;
	//存放的对象
	private Object element;

	//构造函数
	public CompleteBinTreeNode_Rank(Vector t, Object obj) {
		element = obj;
		T = t;
		rank = T.getSize();
		T.insertAtRank(rank, this);
	}

	//返回当前节点中存放的对象
	public Object getElem() {
		return element;
	}

	//将对象obj存入当前节点，并返回此前的内容
	public Object setElem(Object obj) {
		Object tmp = element;
		element = obj;
		return tmp;
	}

	//判断是否有父亲（为使代码描述简洁）
	public boolean hasParent() {
		return (0 != rank) ? true : false;
	}

	//返回当前节点的父节点
	public BinTreePosition getParent() {
		return hasParent() ? (BinTreePosition) T.getAtRank((rank-1)/2) : null;
	}

	//判断是否有左孩子（为使代码描述简洁）
	public boolean hasLChild() {
		return (1+rank*2 < T.getSize()) ? true : false;
	}

	//返回当前节点的左孩子
	public BinTreePosition getLChild() {
		return hasLChild() ? (BinTreePosition) (T.getAtRank(1+rank*2)) : null;
	}



	//判断是否右孩子（为使代码描述简洁）
	public boolean hasRChild() {
		return (2+rank*2 < T.getSize()) ? true : false;
	}

	//返回当前节点的右孩子
	public BinTreePosition getRChild() {
		return hasRChild() ? (BinTreePosition) (T.getAtRank(2+rank*2)) : null;
	}

	//返回当前节点后代元素的数目
	public int getSize() {
		int size = 1;
		if (hasLChild()) {
			size += getLChild().getSize();
		}
		if (hasRChild()) {
			size += getRChild().getSize();
		}

		return size;
	}

	//返回当前节点的高度
	public int getHeight() {
		int hL = hasLChild() ? getLChild().getHeight() : -1;
		int hR = hasRChild() ? getRChild().getHeight() : -1;
		return 1+Math.max(hL, hR);
	}

	//返回当前节点的深度
	public int getDepth() {
		return hasParent() ? 1+getParent().getDepth() : 0;
	}
}