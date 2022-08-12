public class NombreNegatifException extends Exception {

    private int exceptionValue;

    public NombreNegatifException( String message){
        super( message);
    }

    public NombreNegatifException( String message, int exceptionValue){
        super( message);
        this.exceptionValue = exceptionValue;
    }

    public int getExceptionValue() {
        return exceptionValue;
    }
}
