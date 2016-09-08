/**
* 基于链表实现树结构
*/
package ds_java;

public class TreeLinkedList implements Tree {
	//树根节点
	private Object element;
	//父亲节点、长子节点以及最大弟弟节点
	private TreeLinkedList parent, firstChild, nextSibling;

	//(单节点树)构造方法
	public TreeLinkedList() {
		this(null, null, null);
	}

	//构造方法
	public TreeLinkedList(Object e, TreeLinkedList p, TreeLinkedList c, TreeLinkedList s) {
		element =e;
		parent = p;
		firstChild = c;
		nextSibling = s;
	}

	/***Tree接口中各方法的实现***/
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

	//返回当前节点的父亲节点；对于根节点，则返回null
	public TreeLinkedList getParent() {
		return parent;
	}

	//返回当前节点的长子节点；若没有孩子，则返回null
	public TreeLinkedList getFirstChild() {
		return firstChild;
	}

	//返回当前节点的最大弟弟节点；若没有弟弟，则返回null
	public TreeLinkedList getNextSibling() {
		return nextSibling;
	}

	//返回当前节点后代元素的数目，即以当前节点为根的子树的规模
	public int getSize() {
		//当前节点也是自己的后代
		int size = 1;
		//从长子开始,依次累加所有孩子的后代数目
		TreeLinkedList subtree = firstChild;
		while (null != subtree) {
			size += subtree.getSize();
			subtree = subtree.getNextSibling();
		}

		return size;
	}

	//返回当前节点的高度
	public int getHeight() {
		int height = -1;
		//从长子开始依次在所有孩子中取最大高度
		TreeLinkedList subtree = firstChild;
		while (null != subtree) {
			height = Math.max(height, subtree.getHeight());
			subtree = subtree.getNextSibling();
		}

		return height+1;
	}

	//返回当前节点的深度
	public int getDepth() {
		int depth = 0;
		//从父亲开始，依次访问各个真祖先
		TreeLinkedList p = parent;
		while (null != p) {
			depth++;
			p = p.getParent();
		}

		return depth;
	}
}