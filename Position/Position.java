/**
* 位置ADT接口
* 抽象出位置这个概念，既能够保持链表结构高效性，而又不违背面向对象的设计原则
*/
package ds_java;

public interface Position {
	//返回存放于该位置的元素
	public Object getElem();
	//将给定元素存放至该位置，返回此前存放的元素
	public Object setElem();
}