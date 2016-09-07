/**
* 迭代器ADT接口
*
* 与位置（Position）ADT相比，迭代器是对前者的扩展与推广
* 所谓迭代器，就是对一组对象之间的位置、直接后继等关系的集成。
*/
package ds_java;

public interface Iterator {
	//检查迭代器中是否还有剩余的元素
	boolean hasNext();
	//返回迭代器中的下一个元素
	Object getNext();
}