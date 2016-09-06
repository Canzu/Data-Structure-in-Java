/**
* 基于单链表实现栈结构
*/
package ds_java;

public class Stack_List implements Stack {
    //指向栈顶元素
	protected Node top;
	//栈中元素的数目
	protected int size;

	//构造方法（空栈）
	public Stack_List() {
		top = null;
		size = 0;
	}

	//查询当前栈的规模
	public int getSize() {
		return size;
	}

	//判断栈是否为空
	public boolean isEmpty() {
		return (top==null) ? true : false;
	}

	//压栈(只有在JRE没有剩余空间时才会出现栈溢出的现象--Error:OutOfMemoryError),另外注意Error与Exception不同
	public void push (Object elem) {
		//创建一个新节点，将其作为首节点插入（在栈顶插入）
		Node v = new Node(elem, top);
		//更新首节点引用
		top = v;
		//更新规模记录
		size++;
	}

	//读取栈顶（不删除）
	public Object top() throws ExceptionStackEmpty {
		if (isEmpty()) {
			throw new ExceptionStackEmpty("Exception: Stack Empty!");
		}
		return top.getElem();
	}

	//弹出栈顶(删除栈顶)
	public Object pop() throws ExceptionStackEmpty {
		if (isEmpty()) {
			throw new ExceptionStackEmpty("Exception: Stack Empty!");
		}
		Object tmp = top.getElem();
		//更新首节点引用
		top = top.getNext();
		//更新规模记录
		size--;
		return tmp;
	}
}