package by.jwd.task7.parser.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.jwd.task7.component.Component;
import by.jwd.task7.component.ComponentName;
import by.jwd.task7.component.Composite;
import by.jwd.task7.parser.AbstractParser;
import by.jwd.task7.parser.Parser;

public class SentenceParser extends AbstractParser {
    
    private static final Pattern sentenceStartPattern = Pattern.compile("([.?!…]\\n)+|([.?!…]\\n\\s{4})+|([.?!…]\\s)+|([.?!…]\\s{4})+");

    public SentenceParser(Parser nextParser) {
        super(nextParser);
    }

    @Override
    public Component parse(String text) {
        Component paragraphComposite = new Composite(ComponentName.PARAGRAPH);
        List<String> sentences = parseSentences(text);
        for (String sentence : sentences) {
            Component sentenceComponent = nextParser.parse(sentence);
            paragraphComposite.add(sentenceComponent);
        }
        return paragraphComposite;
    }
    
    private List<String> parseSentences(String paragraphText) {
        List<String> result = new ArrayList<>();
        Matcher matcher = sentenceStartPattern.matcher(paragraphText);
        int index = 0;
        String sentence;
        while (matcher.find(index)) {
            sentence = paragraphText.substring(index, matcher.start() + 1);
            result.add(sentence);
            index = matcher.end();    // to collect the last match after loop
        }
        sentence = paragraphText.substring(index);
        result.add(sentence);
        return result;
    }
    

}
