/**
* 基于双向链表实现列表结构
*/
package ds_java;

public class List_DLNode implements List {
	//列表的实际规模
	protected int numElem;
	//哨兵：首节点+末节点
	protected DLNode header, trailer;

	//构造函数
	public List_DLNode() {
		//空表
		numElem = 0;
		//首节点
		header = new DLNode(null, null, null);
		//末节点
		trailer = new DLNode(null, null, null);
		//首、末节点相互链接
		header.setNext(trailer);
	}

	/*******辅助方法*******/
	//检查给定位置在列表是否合法，若是，则将其转换为*DLNode
	protected DLNode checkPosition(Position p) throws ExceptionPositionInvalid {
		if (null == p) {
			throw new ExceptionPositionInvalid("Exception: The Position passed to List_DLNode is null!");
		}
		if (header == p) {
			throw new ExceptionPositionInvalid("Exception: The head node(the guard) position invalid!");
		}
		if (header == p) {
			throw new ExceptionPositionInvalid("Exception: The tail node(the guard) position invalid!");
		}
		DLNode temp = (DLNode) p;
		return temp;
	}

	/******ADT方法*******/
	//查询列表当前的规模
	public int getSize() {
		return numElem;
	}

	//判断列表是否为空
	public boolean isEmpty() {
		return (numElem == 0);
	}

	//返回第一个元素的位置
	public Position first() throws ExceptionListEmpty {
		if (isEmpty()) {
			throw new ExceptionListEmpty("Exception: List empty!")
		}
		return header.getNext();
	}

	//返回最后一个元素的位置
	public Position last() throws ExceptionListEmpty {
		if (isEmpty()) {
			throw new ExceptionListEmpty("Exception: List empty!")
		}
		return trailer.getPrev();
	}

	//返回紧靠给定位置之前的元素的位置
	public Position getPrev(Position p) throws ExceptionPositionInvalid, ExceptionBoundaryViolation {
		DLNode v = checkPosition(p);
		DLNode prev = v.getPrev();
		if (prev == header) {
			throw new ExceptionBoundaryViolation("Exception: Attempt to cross over the List nose!");
		}
		return prev;
	}

	//返回紧接给定位置之后的元素的位置
	public Position getNext(Position p) throws ExceptionPositionInvalid, ExceptionBoundaryViolation {
		DLNode v = checkPosition(p);
		DLNode next = v.getNext();
		if (next == trailer) {
			throw new ExceptionBoundaryViolation("Exception: Attempt to cross over the List end!");
		}
		return next;
	}

	//将e插入至紧靠给定位置之前的位置
	public Position insertBefore(Position p, Object e) throws ExceptionPositionInvalid {
		DLNode v = checkPosition(p);
		numElem++;
		DLNode newNode = new DLNode(e, v.getPrev(), v);
		v.getPrev().setNext(newNode);
		v.setPrev(newNode);
		return newNode;
	}

	//将e插入至紧接给定位置之后的位置
	public Position insertAfter(Position p, Object e) throws ExceptionPositionInvalid {
		DLNode v = checkPosition(p);
		numElem++;
		DLNode newNode = new DLNode(e, v, v.getNext());
		v.getNext().setPrev(newNode);
		v.setNext(newNode);
		return newNode;
	}

	//将e作为第一个元素插入列表
	public Position insertFirst(Object e) {
		numElem++;
		DLNode newNode = new DLNode(e, header, header.getNext());
		header.getNext.setPrev(newNode);
		header.setNext(newNode);
		return newNode;
	}

	//将e作为最后一个元素插入列表
	public Position insertLast(Object e) {
		numElem++;
		DLNode newNode = new DLNode(e, trailer.getPrev(), trailer);
		trailer.getPrev.setNext(newNode);
		trailer.setPrev(newNode);
		return newNode;
	}

	//删除给定位置处的元素，并返回之
	public Object remove(Position p) throws ExceptionPositionInvalid {
		DLNode v = checkPosition(p);
		numElem--;
		DLNode vPrev = v.getPrev();
		DLNode vNext = v.getNext();
		vPrev.setNext(vNext);
		vNext.setPrev(vPrev);
		Object vElem = v.getElem();

		//将该位置（节点）从列表中摘出，以便系统回收其占用的空间
		v.setNext(null);
		v.setPrev(null);

		return vElem;
	}

	//删除首元素，并返回之
	public Object removeFirst() {
		return remove(header.getNext());
	}

	//删除末元素，并返回之
	public Object removeLast() {
		return remove(trailer.getPrev());
	}

	//将处于给定位置的元素替换为新元素，并返回替换的元素
	public Object replace(Position p, Object e) throws ExceptionPositionInvalid {
		DLNode v = checkPosition(p);
		Object oldElem = v.getElem();
		v.setElem(e);
		return oldElem;
	}

	//位置迭代器
	public Iterator positions() {
		return new IteratorPosition(this);
	}
	//元素迭代器
	public Iterator elements() {
		return new IteratorElement(this);
	}
}