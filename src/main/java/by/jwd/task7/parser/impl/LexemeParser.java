package by.jwd.task7.parser.impl;

import java.util.ArrayList;
import java.util.List;

import by.jwd.task7.component.TextComponent;
import by.jwd.task7.component.TextComponentName;
import by.jwd.task7.component.TextComposite;
import by.jwd.task7.parser.TextParser;

public class LexemeParser implements TextParser {
    
    private static final String LEXEME_DELIMETER_REGEX = "\\s+";
    private TextParser nextParser;
    
    public LexemeParser() {
        nextParser = new CharacterParser();
    }

    @Override
    public TextComponent parse(String text) {
        TextComponent sentence = new TextComposite(TextComponentName.SENTENCE);
        List<String> lexemes = parseLexemes(text);
        for (String lexeme : lexemes) {
            TextComponent lexemeComponent = nextParser.parse(lexeme);
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
