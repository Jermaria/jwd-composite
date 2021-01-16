package by.jwd.task7.service;

import java.util.Map;

public interface TextService {
    
    String sortParagraphsBySentenceNumber(String text);
    String findLongestWordSentence(String text);
    String removeSentencesWhereWordsNumLessThan(String text, int wordsNumber);
    Map<String, Integer> findRepeating(String text);

}
