package by.jwd.task7.component;

public interface TextComponent {
    
    void add(TextComponent component);
    void remove(TextComponent component);
    String toString();
    int size();  // считает только первый слой вложенности/ First child
    TextComponentName getComponentName();
}
