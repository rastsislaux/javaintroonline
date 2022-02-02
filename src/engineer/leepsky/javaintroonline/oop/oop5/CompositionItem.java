package engineer.leepsky.javaintroonline.oop.oop5;

import java.util.Objects;

public class CompositionItem {

    private String name;

    CompositionItem(String name) {

        for (char c : name.toCharArray()) {
            if (c < 'A' || c > 'z') {
                throw new IllegalArgumentException("Name must contain only latin letters.");
            }
            this.name = name;
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CompositionItem{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompositionItem compositionItem = (CompositionItem) o;
        return Objects.equals(name, compositionItem.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
