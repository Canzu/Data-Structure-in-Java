/**
* 基于双向链表实现序列
*/
package ds_java;

public class Sequence_DLNode extends List_DLNode implements Sequence {
	//检查r是否在[0,n)之间
	protected void checkRank(int r, int n) throws ExceptionBoundaryViolation {
		if (r < 0 || r >= n) {
			throw new ExceptionBoundaryViolation("Exception: Illegal rank"+r+", supposed to be in [0, "+n+")");
		}
	}

	//若0<=r<getSize(),则返回秩为r的元素所在的位置；否则，报错--O(n)
	public Position rank2Pos(int r) throws ExceptionBoundaryViolation {
		DLNode node;
		checkRank(r, getSize());
		if (r <= getSize()/2) {
			//若秩比较小，则从前端开始逐一扫描
			node = header.getNext();
			for (int i=0; i<r; i++) {
				node = node.getNext();
			}
		} else {
			//若秩比较大，则从后端开始逐一扫描
			node = trailer.getPrev();
			for (int i=1; i<getSize()-r; i++) {
				node = node.getPrev();
			}
		}
		return node;
	}

	//若p是序列中的合法位置，则返回存放于p处的元素的秩；否则，报错--O(n)
	public int pos2Rank(Position p) throws ExceptionBoundaryViolation {
		DLNode node = header.getNext();
		int r = 0;
		while (node != trailer) {
			if (node == p) {
				return (r);
			}
			node = node.getNext();
			r++;
		}
		throw new ExceptionBoundaryViolation("Exception: The Position p doesn't belong to the Sequence!")
	}

	//取秩为r的元素--O(n)
	public Object getAtRank(int r) throws ExceptionBoundaryViolation {
		checkRank(r, getSize());
		return rank2Pos(r).getElem();
	}

	//将秩为r的元素替换为obj--O(n)
	public Object replaceAtRank(int r, Object obj) throws ExceptionBoundaryViolation {
		checkRank(r, getSize());
		return replace(rank2Pos(r), obj);
	}

	//插入obj，作为秩为r的元素--O(n)；返回该元素
	public Object insertAtRank(int r, Object obj) throws ExceptionBoundaryViolation {
		checkRank(r, getSize()+1);
		if (getSize() == r) {
			insertLast(obj);
		} else {
			insertBefore(rank2Pos(r), obj);
		}
		return obj;
	}

	//删除秩为r的元素--O(n)
	public Object removeAtRank(int r) throws ExceptionBoundaryViolation {
		checkRank(r, getSize());
		return remove(rank2Pos(r));
	}
}