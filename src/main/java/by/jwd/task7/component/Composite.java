package by.jwd.task7.component;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {
    
    private ComponentName componentName;
    private List<Component> components;
    
    private static final String NEW_LINE = "\n";
    private static final String INDENT = "    ";
    private static final char SPACE = ' ';

    public Composite(ComponentName componentName) {
        this.componentName = componentName;
        components = new ArrayList<Component>();
    }

    @Override
    public void add(Component component) {
        components.add(component);
    }

    @Override
    public void remove(Component component) {
        components.remove(component);
    }

    @Override
    public int calculateInnerElements() {
        return components.size();
    }

    @Override
    public ComponentName getComponentName() {
        return this.componentName;
    }
    
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder(); 
        sb = processFirstComponent();
        int i = 1;
        while(i < components.size()) {
            Component component = components.get(i);
            ComponentName name = component.getComponentName();
            if (name == ComponentName.PARAGRAPH || name == ComponentName.TEXT) {
                sb.append(NEW_LINE).append(INDENT);
            } else if (name != ComponentName.CHARACTER) {
                sb.append(SPACE);
            }
            sb.append(component.toString());
        }
        return sb.toString();
    }
    
    private StringBuilder processFirstComponent() {     // never starts with a new line
        StringBuilder sb = new StringBuilder();       
        Component first = components.get(0);
        ComponentName name = first.getComponentName();
        sb = (name == ComponentName.PARAGRAPH || name == ComponentName.TEXT) ? sb.append(INDENT) : sb;
        sb.append(first.toString());
        return sb;
    }

}
