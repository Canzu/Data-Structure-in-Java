/**
* 当试图对空栈应用front或dequeue方法时，本意外将被抛出
*/
package ds_java;

public class ExceptionQueueEmpty extends RuntimeException {
	public ExceptionQueueEmpty(String error) {
		super(error);
	}
}