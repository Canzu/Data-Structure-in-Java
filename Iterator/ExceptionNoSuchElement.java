/**
* 当hasNext()为false，且试图调用getNext()时，本意外将被抛出
*/
package ds_java;

public class ExceptionNoSuchElement extends RuntimeException {
	public ExceptionNoSuchElement(String error) {
		super(error);
	}
}