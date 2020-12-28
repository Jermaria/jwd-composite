package by.jwd.task7.parser.impl;

import by.jwd.task7.component.Component;
import by.jwd.task7.component.ComponentName;
import by.jwd.task7.component.Composite;
import by.jwd.task7.component.IndivisibleComponent;
import by.jwd.task7.parser.AbstractParser;
import by.jwd.task7.parser.Parser;

public class CharacterParser extends AbstractParser {  

    public CharacterParser() {
        super(null);     
    }

    @Override
    public Component parse(String text) {
        Component lexemeComponent = new Composite(ComponentName.LEXEME);
        char[] lexemeCharacters = parseLexemeContent(text);
        for (char character : lexemeCharacters) {
            IndivisibleComponent component = new IndivisibleComponent(character);
            lexemeComponent.add(component);
        }
        return lexemeComponent;
    }
    
    private char[] parseLexemeContent(String lexeme) {
        char[] splitted = lexeme.toCharArray();
        return splitted;
    }

}
