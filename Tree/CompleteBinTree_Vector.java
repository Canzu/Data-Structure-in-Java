/**
* 基于向量实现的完全二叉树
*/
package ds_java;

public class CompleteBinTree_Vector extends BinTree_LinkedList implements CompleteBinTree {
	//向量
	private Vector T;
	

	//构造方法：默认的空树
	public CompleteBinTree_Vector() {
		T = new Vector_ExtArray();
		root = null;
	}

	//构造方法：按照给定的节点序列，批量式建立完全二叉树
	public CompleteBinTree_Vector(Sequence s) {
		this();
		if (null != s) {
			while (!s.isEmpty()) {
				addLast(s.removeFirst());
			}
		}
	}

	/************BinTree接口中各方法的实现******************/
	//返回树根（重写）
	public BinTreePosition getRoot() {
		return T.isEmpty() ? null : posOfNode(0);
	}

	//判断是否树空（重写）
	public boolean isEmpty() {
		return T.isEmpty();
	}

	//返回树的规模（重写）
	public int getSize() {
		return T.getSize();
	}

	//返回树（根）的高度（重写）
	public int getHeight() {
		return isEmpty() ? -1 : getRoot().getHeight();
	}

	/**************CompleteBinTree接口中各方法的实现*******/
	//生成并返回一个存放e的外部节点，该节点成为新的末节点
	public BinTreePosition addLast(Object e) {
		BinTreePosition node = new CompleteBinTree_Rank(T, e);
		root = (BinTreePosition) T.getAtRank(0);
		return node;
	}

	//删除末节点，并返回其中存放的内容
	public Object delLast() {
		if (isEmpty()) {
			return null; //若树（堆）已空，无法删除
		}
		if (1 == getSize()) {
			root = null; //若删除最后一个节点，则树空
		}

		return T.removeAtRank(T.getSize() - 1);
	}

	//返回按照层次遍历编号为i的节点的位置，0 <= i < size()
	public BinTreePosition posOfNode(int i) {
		return (BinTreePosition) T.getAtRank(i);
	}
}