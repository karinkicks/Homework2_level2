public class MyArraySizeException extends Throwable{
    public MyArraySizeException() {
        super();
    }

    public MyArraySizeException(String message) {
        System.out.println(message);
    }

    public MyArraySizeException(String message, Throwable cause) {
        super(message, cause);
    }
}
