/**
* 队列接口
*/
package ds_java;

public interface Queue {
	//返回队列中元素数目
	public int getSize();

	//判断队列是否为空
	public boolean isEmpty();

	//取队首元素（不删除）
	public Object front() throws ExceptionQueueEmpty;

	//入队
	public void enqueue(Object obj) throws ExceptionQueueFull;

	//出队
	public Object dequeue() throws ExceptionQueueEmpty;

	//遍历
	public void Traversal();
}