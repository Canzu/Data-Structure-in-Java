/**
* 双端队列接口
*/
package ds_java;

public interface Deque {
	//返回队列中元素的数目
	public int getSize();
	//判断队列是否为空
	public boolean isEmpty();
	//取首元素（不删除）
	public Object first() throws ExceptionQueueEmpty;
	//取末元素（不删除）
	public Object last() throws ExceptionQueueEmpty;
	//将新元素作为首元素插入
	public void insertFirst(Object obj);
	//将新元素作为末元素插入
	public void insertLast(Object obj);
	//删除首元素
	public Object removeFirst() throws ExceptionQueueEmpty;
	//删除末元素
	public Object removeLast() throws ExceptionQueueEmpty;
	//遍历
	public void Traversal();
}