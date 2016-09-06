/**
* 当试图对满队应用enqueue方法时，本意外将被抛出
*/
package ds_java;

public class ExceptionQueueFull extends RuntimeException {
	public ExceptionQueueFull(String error) {
		super(error);
	}
}