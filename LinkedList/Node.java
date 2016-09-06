/**
* 基于位置接口实现的单链表节点类
*/
package ds_java;
public class Node implements Position {
	//数据对象
	private Object element;
	//指向后继节点
	private Node next;

	/******构造函数******/
	public Node() {
		//指向数据对象、后继节点的引用都置为空
		this(null, null);
	}

	public Node(Object e, Node n) {
		//指定数据对象及后继节点
		element = e;
		next = n;
	}

	/******Position接口方法******/
	//返回存放于该位置的元素
	public Object getElem() {
		return element;
	}

	//将给定元素存放至该位置，返回此前存放的元素
	public Object setElem(Object e) {
		Object oldElem = element;
		element = e;
		return oldElem;
	}

	/******单链表节点方法********/
	//取当前节点的后继节点
	public Node getNext() {
		return next;
	}

	//修改当前节点的后继节点
	public void setNext(Node newNext) {
		next = newNext;
	}
}