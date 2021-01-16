package by.jwd.task7.parser.impl;

import by.jwd.task7.component.TextComponent;
import by.jwd.task7.component.TextComponentName;
import by.jwd.task7.component.TextComposite;
import by.jwd.task7.component.CharacterComponent;
import by.jwd.task7.parser.TextParser;

public class CharacterParser implements TextParser {  

    public CharacterParser() {}

    @Override
    public TextComponent parse(String text) {
        TextComponent lexemeComponent = new TextComposite(TextComponentName.LEXEME);
        char[] lexemeCharacters = parseLexemeContent(text);
        for (char character : lexemeCharacters) {
            CharacterComponent component = new CharacterComponent(character);
            lexemeComponent.add(component);
        }
        return lexemeComponent;
    }
    
    private char[] parseLexemeContent(String lexeme) {
        char[] splitted = lexeme.toCharArray();
        return splitted;
    }

}
