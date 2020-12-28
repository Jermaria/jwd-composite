package by.jwd.task7.parser.impl;

import java.util.ArrayList;
import java.util.List;

import by.jwd.task7.component.Component;
import by.jwd.task7.component.ComponentName;
import by.jwd.task7.component.Composite;
import by.jwd.task7.parser.AbstractParser;
import by.jwd.task7.parser.Parser;

public class LexemeParser extends AbstractParser {
    
    private static final String LEXEME_DELIMETER_REGEX = "\\s+";

    public LexemeParser(Parser nextParser) {
        super(nextParser);
    }

    @Override
    public Component parse(String text) {
        Component sentence = new Composite(ComponentName.SENTENCE);
        List<String> lexemes = parseLexemes(text);
        for (String lexeme : lexemes) {
            Component lexemeComponent = nextParser.parse(lexeme);
            sentence.add(lexemeComponent);
        }
        return sentence;
    }
    
    private List<String> parseLexemes(String sentence) {
        String[] splitted = sentence.split(LEXEME_DELIMETER_REGEX);
        List<String> lexemes = new ArrayList<>();
        for (String lexeme : splitted) {
            if (lexeme.isEmpty() || lexeme.isBlank()) {
                continue;
            }
            lexemes.add(lexeme);
        }
        return lexemes;
    }

}
