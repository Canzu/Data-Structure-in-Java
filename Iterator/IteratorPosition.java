/**
* 基于列表实现的位置迭代器（attention: 位置而非元素）
*/
package ds_java;

public class IteratorPosition implements Iterator {
	//列表
	private List list;
	//当前（下一个）位置
	private Position nextPosition;

	//默认构造方法
	public IteratorPosition() {
		list = null;
	}

	//构造方法
	public IteratorPosition(List L) {
		list = L;

		if (list.isEmpty()) {
			//若列表为空，则当前位置置空
			nextPosition = null;
		} else {
			//否则从第一个位置开始
			nextPosition = list.first();
		}
	}

	//检查迭代器中是否还有剩余的位置
	public boolean hasNext() {
		return (nextPosition != null);
	}

	//返回迭代器中的下一个位置
	public Object getNext() throws ExceptionNoSuchElement {
		if (!hasNext()) {
			throw new ExceptionNoSuchElement("Exception: No next position!")
		}
		Position currentPosition = nextPosition;
		if (currentPosition == list.last()) {
			//若已经到达尾位置，则不再有下一个位置
			nextPosition = null;
		} else {
			//否则转向下一个位置
			nextPosition = list.getNext(currentPosition);
		}
		/*从第一个位置开始返回，若是return nextPosition则不能返回第一个位置,
		所以此处return currentPosition。*/
		return currentPosition;
	}
}