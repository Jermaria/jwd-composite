package by.jwd.task7.component;

public interface Component {
    
    void add(Component component);
    void remove(Component component);
    String toString();
    int calculateInnerElements();  // считает только первый слой вложенности/ First child
    ComponentName getComponentName();
}
