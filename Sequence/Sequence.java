/**
* 序列接口
* 向量和列表是特殊序列，此处定义一个通用序列ADT接口
*/
package ds_java;

public interface Sequence extends Vector, List {
	//若0<=r<getSize(),则返回秩为r的元素所在的位置；否则，报错
	public Position rank2Pos(int r) throws ExceptionBoundaryViolation;

	//若p是序列中的合法位置，则返回存放于p处的元素的秩；否则，报错
	public int pos2Rank(Position p) throws ExceptionBoundaryViolation;
}