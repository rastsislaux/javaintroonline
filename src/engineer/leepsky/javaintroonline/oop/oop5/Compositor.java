package engineer.leepsky.javaintroonline.oop.oop5;

import java.util.ArrayList;
import java.util.Objects;

public class Compositor<T> {

    private Composition.Wrapping wrapping;
    private final ArrayList<T> arrayList = new ArrayList<>();

    Compositor() { }

    public void add(T obj) {
        arrayList.add(obj);
    }

    public void setWrapping(Composition.Wrapping wrapping) {
        this.wrapping = wrapping;
    }

    public Composition<T> getResult() {
        return new Composition<T>(wrapping, arrayList);
    }

    @Override
    public String toString() {
        return "Compositor{" +
                "wrapping=" + wrapping +
                ", arrayList=" + arrayList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Compositor<?> that = (Compositor<?>) o;
        return wrapping == that.wrapping && Objects.equals(arrayList, that.arrayList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wrapping, arrayList);
    }

}
