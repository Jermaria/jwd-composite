package by.jwd.task7.component;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class IndivisibleComponent implements Component {
    
    private ComponentName componentName = ComponentName.CHARACTER;
    private char character;
    private static final Logger logger = LogManager.getLogger();
    
    public IndivisibleComponent(char character) {
        this.character = character;
    }

    @Override
    public void add(Component component) {
        logger.log(Level.ERROR, "cannot add component to character as it's not a composite");
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(Component component) {
        logger.log(Level.ERROR, "cannot remove component from character");
        throw new UnsupportedOperationException();
    }

    @Override
    public int calculateInnerElements() {
        logger.log(Level.ERROR, "character doesn't have inner elements");
        throw new UnsupportedOperationException();
    }

    @Override
    public ComponentName getComponentName() {
        return this.componentName;
    }
}
