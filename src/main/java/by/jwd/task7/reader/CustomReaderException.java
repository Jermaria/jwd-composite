package by.jwd.task7.reader;

public class CustomReaderException extends Exception {

    private static final long serialVersionUID = 1L;
    
    public CustomReaderException() {}
    
    public CustomReaderException(Exception e) {       
        super(e);
    }
    
    public CustomReaderException(String message, Exception e) {
        super(message, e);
    }
    
    public CustomReaderException(String message) {
        super(message);
    }

}
