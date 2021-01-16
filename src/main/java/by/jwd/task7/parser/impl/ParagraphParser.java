package by.jwd.task7.parser.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import by.jwd.task7.component.TextComponent;
import by.jwd.task7.component.TextComponentName;
import by.jwd.task7.component.TextComposite;
import by.jwd.task7.parser.TextParser;

public class ParagraphParser implements TextParser {
    
    private TextParser nextParser;
    
    public ParagraphParser() {
        this.nextParser = new SentenceParser();
    }

    private static final String PARAGRAPH_DELIMETER_REGEX = "\\r\\n\\s";

    @Override
    public TextComponent parse(String text) {
        TextComponent textComposite = new TextComposite(TextComponentName.TEXT);
        List<String> paragraphs = parseParagraphs(text);
        for (String paragraph : paragraphs) {
            TextComponent paragraphComponent = nextParser.parse(paragraph);
            textComposite.add(paragraphComponent);
        }
        
        return textComposite;
    }
    
    private List<String> parseParagraphs(String text) {
        String[] splitted = text.split(PARAGRAPH_DELIMETER_REGEX);
        List<String> result = Arrays.stream(splitted).collect(Collectors.toList());
        return result;
    }
    
    

}
