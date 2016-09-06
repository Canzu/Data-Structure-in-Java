/**
* 栈接口
*/
package ds_java;

public interface Stack {
	//返回栈中元素数目
	public int getSize();

	//判断栈是否为空
	public boolean isEmpty();

	//取栈顶元素（不删除）
	public Object top() throws ExceptionStackEmpty;

	//入栈
	public void push(Object ele);

	//出栈
	public Object pop() throws ExceptionStackEmpty;
}