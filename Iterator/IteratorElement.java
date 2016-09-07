/**
* 基于列表实现的元素迭代器（attention: 元素而非位置）
*/
package ds_java;

public class IteratorElement implements Iterator {
	//列表
	private List list;
	//当前（下一个）元素的位置
	private Position nextPosition;

	//默认构造方法
	public IteratorElement() {
		list = null;
	}

	//构造方法
	public IteratorElement(List L) {
		list = L;

		if (list.isEmpty()) {
			//若列表为空，则当前元素置空
			nextPosition = null;
		} else {
			//否则从第一个元素开始
			nextPosition = list.first();
		}
	}

	//检查迭代器中是否还有剩余的元素
	public boolean hasNext() {
		return (nextPosition != null);
	}

	//返回迭代器中的下一个元素
	public Object getNext() throws ExceptionNoSuchElement {
		if (!hasNext()) {
			throw new ExceptionNoSuchElement("Exception: No next element!")
		}
		Position currentPosition = nextPosition;
		if (currentPosition == list.last()) {
			//若已经到达尾元素，则不再有下一个元素
			nextPosition = null;
		} else {
			//否则转向下一个元素
			nextPosition = list.getNext(currentPosition);
		}
		/*从第一个元素开始返回，若是return nextPosition.getElem()则不能返回第一个元素,
		所以此处return currentPosition.getElem()。*/
		return currentPosition.getElem();
	}
}