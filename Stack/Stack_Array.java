/**
* 借助定长数组实现Stack接口
*/
package ds_java;

public class Stack_Array implements Stack {
	//数组的默认容量
	public static final int CAPACITY = 1024;
	//数组的实际容量
	protected int capacity;
	//对象数组
	protected Object[] S;
	//栈顶元素的位置
	protected int top = -1;


	//按照默认容量创建栈对象
	public Stack_Array() {
		this(CAPACITY);
	}

	//按照指定容量创建栈对象
	public Stack_Array(int cap) {
		capacity = cap;
		S = new Object[capacity];
	}

	//获取栈当前的规模
	public int getSize() {
		return (top+1);
	}

	//测试栈是否为空
	public boolean isEmpty() {
		return (top<0);
	}

	//入栈
	public void push(Object obj) throws ExceptionStackFull {
		if (getSize() == capacity) {
			throw new ExceptionStackFull("Exception: Stack Overflow!");
		}
		S[++top] = obj;
	}

	//取栈顶元素
	publci Object top() throws ExceptionStackEmpty {
		if (isEmpty()) {
			throw new ExceptionStackEmpty("Exception: Stack Empty!");
		}
		return S[top];
	}
	
	//出栈
	public Object pop() throws ExceptionStackEmpty {
		if (isEmpty()) {
			throw new ExceptionStackEmpty("Exception: Stack Empty!");
		}
		Object ele;
		ele = S[top];
		S[top--] = null;
		return ele;
	}
}