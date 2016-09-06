/**
* 借助定长循环数组实现Queue接口
*/
package ds_java;

public class Queue_Array implements Queue {
	//数组的默认容量
	public static final int CAPACITY = 1000;
	//数组的实际容量
	public int capacity;
	//对象数组
	protected Object[] Q;
	//队首元素的位置
	protected int f = 0;
	//队尾元素的位置
	protected int r = 0;


	//构造方法（空队列）
	public Queue_Array() {
		this(CAPACITY);
	}

	//按照指定容量创建对象
	public Queue_Array(int cap) {
		capacity = cap;
		Q = new Object[capacity];
	}

	//查询当前队列的规模
	public int getSize() {
		return (capacity-f+r) % capacity;
	}

	//判断队列是否为空
	public boolean isEmpty() {
		return (f==r);
	}

	//入队
	public void enqueue(Object obj) throws ExceptionQueueFull {
		//禁止队列实际规模超过capacity-1,否则利用f==r判断队列是否为空不成立，因为也有可能为满队情况
		if (getSize() == capacity - 1) {
			throw new ExceptionQueueFull("Exception: Queue Overflow!");
		}
		Q[r] = obj;
		r = (r+1) % capacity;
	}

	//出队
	public Object dequeue() throws ExceptionQueueEmpty {
		if (isEmpty()) {
			throw new ExceptionQueueEmpty("Exception: Queue Empty!");
		}
		Object ele;
		ele = Q[f];
		Q[f] = null;
		f = (f+1) % capacity;
		return ele;
	}

	//取队首元素（不删除）
	public Object front() throws ExceptionQueueEmpty {
		if (isEmpty()) {
			throw new ExceptionQueueEmpty("Exception: Queue Empty!");
		}
		return Q[f];
	}

	//遍历
	public void Traversal() {
		for (int i=f; i<r; i++) {
			System.out.print(Q[i]+" ");
		}
		System.out.println();
	}
}