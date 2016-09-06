/**
* 基于单链表实现队列结构
*/
package ds_java;

public class Queue_List implements Queue {
	//指向表首元素
	protected Node head;
	//指向表末元素
	protected Node tail;
	//队列中元素的数目
	protected int size;

	//构造方法（空队列）
	public Queue_List() {
		head = null;
		tail = null;
		size = 0;
	}

	//查询当前队列的规模
	public int getSize() {
		return size;
	}

	//判断队列是否为空
	public boolean isEmpty() {
		return (0 == size) ? true : false;
	}

	//入队
	public void enqueue(Object obj) {
		Node node = new Node();
		node.setElem(obj);
		//新节点作为末节点插入
		node.setNext(null);

		if (0 == size) {
			//若此前队列为空，则直接插入
			head = node;
		} else {
			//否则，将新节点接至队列末端
			tail.setNext(node);
		}
		//更新指向末节点引用
		tail = node;
		//更新规模
		size++;
	}

	//出队
	public Object dequeue() throws ExceptionQueueEmpty {
		if (0 == size) {
			throw new ExceptionQueueEmpty("Exception: Queue Empty!");
		}
		Object obj = head.getElem();
		head = head.getNext();
		size--;
		if (0 == size) {
			//若队列已空，须将末节点引用置空
			tail = null;
		}
		return obj;
	}

	//取队首元素（不删除）
	public Object front() throws ExceptionQueueEmpty {
		if (isEmpty()) {
			throw new ExceptionQueueEmpty("Exception: Queue Empty!");
		}
		return head.getElem();
	}

	//遍历
	public void Traversal() {
		Node p = head;
		while (bull != p) {
			System.out.print(p.getElem()+" ");
			p = p.getNext();
		}
	}
}