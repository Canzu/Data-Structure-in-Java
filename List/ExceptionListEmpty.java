/**
* 当试图对空列表应用first或last方法时，本意外将被抛出
*/
package ds_java;

public class ExceptionListEmpty extends RuntimeException {
	public ExceptionListEmpty(String error) {
		super(error);
	}
}