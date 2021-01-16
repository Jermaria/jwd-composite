package by.jwd.task7.component;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent {
    
    private TextComponentName componentName;
    private List<TextComponent> components;
    
    private static final String NEW_LINE = "\n";
    private static final String INDENT = "    ";
    private static final char SPACE = ' ';

    public TextComposite(TextComponentName componentName) {
        this.componentName = componentName;
        components = new ArrayList<TextComponent>();
    }

    @Override
    public void add(TextComponent component) {
        components.add(component);
    }

    @Override
    public void remove(TextComponent component) {
        components.remove(component);
    }

    @Override
    public int size() {
        return components.size();
    }

    @Override
    public TextComponentName getComponentName() {
        return this.componentName;
    }
    
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder(); 
        sb = processFirstComponent();
        int i = 1;
        while(i < components.size()) {
            TextComponent component = components.get(i);
            TextComponentName name = component.getComponentName();
            if (name == TextComponentName.PARAGRAPH || name == TextComponentName.TEXT) {
                sb.append(NEW_LINE).append(INDENT);
                
                System.out.println("AFTER APENDING nL or indent " + sb);
            } else if (name != TextComponentName.CHARACTER) {
                sb.append(SPACE);
            }
            sb.append(component.toString());
            i++;
           // System.out.println("finished tostring for " + this.componentName );
        }
        return sb.toString();
    }
    
    private StringBuilder processFirstComponent() {     // never starts with a new line
        StringBuilder sb = new StringBuilder();
      //  System.out.println("before nullpointer components size " + components.size() + this.componentName);
        TextComponent first = components.get(0);
        TextComponentName name = first.getComponentName();
        sb = (name == TextComponentName.PARAGRAPH || name == TextComponentName.TEXT) ? sb.append(INDENT) : sb;
        sb.append(first.toString());
        return sb;
    }

}
