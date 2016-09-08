/**
* 基于列表实现的树迭代器
*/
package ds_java;

public class IteratorTree implements Iterator {
	//列表
	private List list;
	//当前（下一个）元素的位置
	private Position nextPosition;

	//默认构造方法
	public IteratorTree() {
		list = null;
	}

	//前序遍历
	public void elementsPreorderIterator(TreeLinkedList T) {
		if (null == T) {
			return; //递归基
		}
        //首先输出当前节点，插入至列表末处，即输出在首位(递归)
		list.insertLast(T);
		//从当前节点的长子开始
		TreeLinkedList subtree = T.getFirstChild();
		//依次对当前节点的各个孩子做前序遍历
		while (null != subtree) {
			this.elementsPreorderIterator(subtree);
			subtree = subtree.getNextSibling();
		}
	}

	//后序遍历
	public void elementsPostorderIterator(TreeLinkedList T) {
		if (null == T) {
			return; //递归基
		}
        
		//从当前节点的长子开始
		TreeLinkedList subtree = T.getFirstChild();
		//依次对当前节点的各个孩子做后序遍历
		while (null != subtree) {
			this.elementsPostorderIterator(subtree);
			subtree = subtree.getNextSibling();
		}
		//当所有后代都访问过后，最后才访问当前节点
		list.insertLast(T);
	}

	//层次遍历
	public void LevelTraversalIterator(TreeLinkedList T) {
		if (null == T) {
			return; //递归基
		}
		//空队
		Queue_List Q = new Queue_List();
		//根节点入队
		Q.enqueue(T);
        
        //在队列重新变空之前
		while (!Q.isEmpty()) {
			//取出队列首节点
			TreeLinkedList tree = (TreeLinkedList) (Q.dequeue());
			//将新出队的节点接入迭代器中
			list.insertLast(tree);
			//从tree的第一个孩子起
			TreeLinkedList subtree = tree.getFirstChild();
			while (null != subtree) { //依次找出所有孩子，并
				Q.enqueue(subtree); //将其加至队列中
				subtree = subtree.getNextSibling();
			}
		}
	}

	//检查迭代器中是否还有剩余的元素
	public boolean hasNext() {
		return (null != nextPosition);
	}

	//返回迭代器中下一个元素
	public Object getNext() throws ExceptionNoSuchElemnet {
		if (!hasNext()) {
			throw new ExceptionNoSuchElemnet("Exception: No next element!");
		}
		Position currentPosition = nextPosition;
		if (currentPosition == list.last()) { //若已到达尾元素，则
			nextPosition = null; //不再有下一个元素
		} else { //否则
			nextPosition = list.getNext(currentPosition); //转向下一个元素
		}

		return currentPosition.getElem();
	}
}