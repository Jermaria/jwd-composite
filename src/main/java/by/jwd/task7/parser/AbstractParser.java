package by.jwd.task7.parser;

public abstract class AbstractParser implements Parser {   // helps to invoke chain of parsers via its field
    
    protected Parser nextParser;
    
    protected AbstractParser(Parser nextParser) {
        this.nextParser = nextParser;
    }

}
