package engineer.leepsky.javaintroonline.oop.oop5;

import java.util.ArrayList;
import java.util.Objects;

public class Composition<T> {

    enum Wrapping {
        PAPER,
        PLASTIC,
        CLOTH,
        BOX,
        NO
    }

    private Wrapping wrapping;
    private ArrayList<T> arrayList = new ArrayList<>();

    Composition(Wrapping wrapping, ArrayList<T> arrayList) {
        this.wrapping = wrapping;
        this.arrayList = arrayList;
    }

    public Wrapping getWrapping() {
        return wrapping;
    }

    public T get(int index) {
        return arrayList.get(index);
    }

    @Override
    public String toString() {
        return "Composition{" +
                "wrapping=" + wrapping +
                ", arrayList=" + arrayList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Composition<?> that = (Composition<?>) o;
        return wrapping == that.wrapping && Objects.equals(arrayList, that.arrayList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wrapping, arrayList);
    }

}
