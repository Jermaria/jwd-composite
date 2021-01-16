package by.jwd.task7.parser.impl;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.jwd.task7.component.TextComponent;
import by.jwd.task7.reader.TextReader;
import by.jwd.task7.reader.TextReaderException;

public class ParagraphParserTest {
    private static final String FILE_PATH = "resources/data/text.txt";
    private TextReader reader = new TextReader();
    private ParagraphParser parser = new ParagraphParser();
    private String text;
    
    @BeforeMethod
    public void initText() {
        try {
            text = reader.readStringsFromFile(FILE_PATH);
        } catch (TextReaderException e) {
            fail();
        }
    }

  @Test
  public void parseTest() {
    TextComponent component = parser.parse(text);
    String actual = component.toString();
    String expected = text;
    assertEquals(actual, expected);
  }
}
