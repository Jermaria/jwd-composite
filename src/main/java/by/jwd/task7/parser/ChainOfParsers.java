package by.jwd.task7.parser;

import by.jwd.task7.component.Component;
import by.jwd.task7.parser.impl.CharacterParser;
import by.jwd.task7.parser.impl.LexemeParser;
import by.jwd.task7.parser.impl.ParagraphParser;
import by.jwd.task7.parser.impl.SentenceParser;

public class ChainOfParsers {
    
    private Parser characterParser = new CharacterParser();
    private Parser lexemeParser = new LexemeParser(characterParser);
    private Parser sentenceParser = new SentenceParser(lexemeParser);
    private Parser paragraphParser = new ParagraphParser(sentenceParser);

    public Component parse(String text) {
        Component parsedResult = paragraphParser.parse(text);
        return parsedResult;
    }

}
