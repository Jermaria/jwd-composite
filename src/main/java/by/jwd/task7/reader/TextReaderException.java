package by.jwd.task7.reader;

public class TextReaderException extends Exception {

    private static final long serialVersionUID = 1L;
    
    public TextReaderException() {}
    
    public TextReaderException(Exception e) {       
        super(e);
    }
    
    public TextReaderException(String message, Exception e) {
        super(message, e);
    }
    
    public TextReaderException(String message) {
        super(message);
    }

}
