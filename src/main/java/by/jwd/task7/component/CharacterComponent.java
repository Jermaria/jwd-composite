package by.jwd.task7.component;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CharacterComponent implements TextComponent {
    
    private TextComponentName componentName = TextComponentName.CHARACTER;
    private char character;
    private static final Logger logger = LogManager.getLogger();
    
    public CharacterComponent(char character) {
        this.character = character;
    }

    @Override
    public void add(TextComponent component) {
        logger.log(Level.ERROR, "cannot add component to character as it's not a composite");
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(TextComponent component) {
        logger.log(Level.ERROR, "cannot remove component from character");
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        logger.log(Level.ERROR, "character doesn't have inner elements");
        throw new UnsupportedOperationException();
    }

    @Override
    public TextComponentName getComponentName() {
        return this.componentName;
    }
    
    public String toString() {
        return String.valueOf(character);
        
    }
}
