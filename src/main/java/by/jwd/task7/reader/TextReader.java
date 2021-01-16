package by.jwd.task7.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task7.component.TextComponent;
import by.jwd.task7.parser.impl.ParagraphParser;
import by.jwd.task7.reader.TextReaderException;
import by.jwd.task7.validation.FileValidator;

public class TextReader {
    
    public static void main(String[] args) {
        TextReader reader = new TextReader();
        String s;
        
        try {
            s = reader.readStringsFromFile("resources/data/text.txt");
            ParagraphParser parser = new ParagraphParser();
            TextComponent comp = parser.parse(s);
          //  System.out.println("pp \n" + "khkjh");
            System.out.println(comp.toString());
        } catch (TextReaderException e) {
            e.printStackTrace();
        }
        
    }
    
    private static final String DEFAULT_FILE_PATH = "resources/data/text";
    private static final Logger logger = LogManager.getLogger();
    
    public String readStringsFromFile(String path) throws TextReaderException {
        if (!FileValidator.isSourceValid(path)) {
            logger.log(Level.ERROR, "invalid path input", path);
            path = DEFAULT_FILE_PATH;
        }
        List<String> strings;
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            strings = stream.collect(Collectors.toList());
            String fileAsString = String.join("\n", strings); // или вернуть лист...
            return fileAsString;
        } catch (IOException e) {
            logger.log(Level.ERROR, "error occurs while opening the file", path);
            throw new TextReaderException(e);
        }     
    }
}
