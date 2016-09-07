/**
* 基于可扩充数组的向量实现
* Java 中功能与向量类似的两个类：java.util.ArrayList和java.util.Vector.
* (两个类均采用动态扩充数组的容量的策略)
*/
package ds_java;

public class Vector_ExtendableArray implements Vector {
	//数组的容量，可不断增加
	private int N = 8;
	//向量的实际规模
	private int n;
	//对象数组
	private Object[] A;

	//构造函数
	public Vector_ExtendableArray() {
		A = new Object[N];
		n = 0;
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
			/***数组空间溢出的处理***/
			N *= 2;
			//开辟一个容量为2*N的数组
			Object B[] = new Object[N];
			//将A[]中的内容复制至B[]中
			for (int i=0; i<n; i++) {
				B[i] = A[i];
			}
			//用B[]替换A[],原A[]将被自动回收
			A = B;
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