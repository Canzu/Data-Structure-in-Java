/**
* 向量的接口
*
* 假定集合 S 由 n 个元素组成，它们按照线性次序存放，于是我们就可以直接访问其中的第一个
* 元素、第二个元素、第三个元素……。也就是说，通过[0, n-1]之间的每一个整数，都可以直接访问
* 到唯一的元素 e，而这个整数就等于 S 中位于 e 之前的元素个数--在此，我们称之为该元素的秩
*（Rank）。不难看出，若元素 e 的秩为 r，则只要 e 的直接前驱（或直接后继）存在，其秩就是 r-1
*（或 r+1）。
*
*/
package ds_java;

public interface Vector {
	//返回向量中元素的数目
	public int getSize();

	//判断向量是否为空
	public boolean isEmpty();

	//取秩为r的元素
	public Object getAtRank(int r) throws ExceptionBoundaryViolation;

	//取秩为r的元素替换为obj
	public Object replaceAtRank(int r, Object obj) throws ExceptionBoundaryViolation;

	//插入obj，作为秩为r的元素；返回该元素
	public Object insertAtRank(int r, Object obj) throws ExceptionBoundaryViolation;

	//删除秩为r的元素
	public Object removeAtRank(int r) throws ExceptionBoundaryViolation;
}