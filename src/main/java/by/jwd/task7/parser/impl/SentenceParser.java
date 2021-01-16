package by.jwd.task7.parser.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.jwd.task7.component.TextComponent;
import by.jwd.task7.component.TextComponentName;
import by.jwd.task7.component.TextComposite;
import by.jwd.task7.parser.TextParser;

public class SentenceParser implements TextParser {
    
    private static final Pattern sentenceStartPattern = Pattern.compile("([.?!…]\\n)+|([.?!…]\\n\\s{4})+|([.?!…]\\s)+|([.?!…]\\s{4})+");
    private TextParser nextParser;
    
    public SentenceParser() {
        this.nextParser = new LexemeParser();
    }

    @Override
    public TextComponent parse(String text) {
        TextComponent paragraphComposite = new TextComposite(TextComponentName.PARAGRAPH);
        List<String> sentences = parseSentences(text);
        for (String sentence : sentences) {
            TextComponent sentenceComponent = nextParser.parse(sentence);
            paragraphComposite.add(sentenceComponent);
        }
        System.out.println("parsed sentences size " + sentences.size());
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
