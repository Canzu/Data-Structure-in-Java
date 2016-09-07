/**
* 基于数组的向量实现
*/
package ds_java;

public class Vector_Array implements Vector {
	//数组的容量
	private final int N = 1024;
	//向量的实际规模
	private int n = 0;
	//对象数组
	private Object[] A;

	//构造函数
	public Vector_Array() {
		A = new Object[N];
		n = 0;
	}

	//返回向量中元素的数目
	public int getSize() {
		return n;
	}

	//判断向量是否为空
	public boolean isEmpty() {
		return (0 == n) ? true : false;
	}

	//取秩为r的元素
	public Object getAtRank(int r) throws ExceptionBoundaryViolation {
		if (0 > r || r >= n) {
			throw new ExceptionBoundaryViolation("Exception: Rank out of boundary");
		}
		return A[r];
	}

	//将秩为r的元素替换为obj
	public Object replaceAtRank(int r, Object obj) throws ExceptionBoundaryViolation {
		if (0 > r || r >= n) {
			throw new ExceptionBoundaryViolation("Exception: Rank out of boundary!");
		}
		Object tmp = A[r];
		A[r] = obj;
		return tmp;
	}

	//插入obj，作为秩为r的元素；返回该元素
	public Object insertAtRank(int r, Object obj) throws ExceptionBoundaryViolation {
		if (0 > r || r >= n) {
			throw new ExceptionBoundaryViolation("Exception: Rank out of boundary!");
		}
		if (n >= N) {
			throw new ExceptionBoundaryViolation("Exception: The Array Overflow!");
		}
		for (int i=n; i>r; i--) {
			//后续元素顺次后移
			A[i] = A[i-1];
		}
		//插入
		A[r] = obj;
		//更新规模
		n++;
		return obj;
	}

	//删除秩为r的元素
	public Object removeAtRank(int r) throws ExceptionBoundaryViolation {
		if (0 > r || r >= n) {
			throw new ExceptionBoundaryViolation("Exception: Rank out of boundary!");
		}
		Object tmp = A[r];
		for (int i=r; i<n; i++) {
			//后续元素顺次前移
			A[i] = A[i+1];
		}
		//更新当前规模
		n--;
		return tmp;
	}
}