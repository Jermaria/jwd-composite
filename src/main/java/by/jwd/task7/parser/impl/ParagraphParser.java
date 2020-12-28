package by.jwd.task7.parser.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import by.jwd.task7.component.Component;
import by.jwd.task7.component.ComponentName;
import by.jwd.task7.component.Composite;
import by.jwd.task7.parser.AbstractParser;
import by.jwd.task7.parser.Parser;

public class ParagraphParser extends AbstractParser {
    
    public ParagraphParser(Parser nextParser) {
        super(nextParser);
    }

    private static final String PARAGRAPH_REGEX = "\\n(\\s){4}|\\s{4}|[\\t]+";

    @Override
    public Component parse(String text) {
        Component textComposite = new Composite(ComponentName.TEXT);
        List<String> paragraphs = parseParagraphs(text);
        for (String paragraph : paragraphs) {
            Component paragraphComponent = nextParser.parse(paragraph);
            textComposite.add(paragraphComponent);
        }
        return textComposite;
    }
    
    private List<String> parseParagraphs(String text) {
        String[] splitted = text.split(PARAGRAPH_REGEX);
        List<String> result = Arrays.stream(splitted).collect(Collectors.toList());
        return result;
    }
    
    

}
