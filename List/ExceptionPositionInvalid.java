/**
* 当作为参数的数组下标、向量的秩或列表的位置非法时，本意外将被抛出
*/
package ds_java;

public class ExceptionPositionInvalid extends RuntimeException {
	public ExceptionPositionInvalid(String error) {
		super(error);
	}
}