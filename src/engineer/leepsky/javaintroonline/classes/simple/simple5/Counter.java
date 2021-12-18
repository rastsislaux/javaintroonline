package engineer.leepsky.javaintroonline.classes.simple.simple5;

public class Counter {

    /* Опишите класс, реализующий десятичный счетчик, который может увеличивать или уменьшать свое значение
       на единицу в заданном диапазоне. Предусмотрите инициализацию счетчика значениями по умолчанию и
       произвольными значениями. Счетчик имеет методы увеличения и уменьшения состояния, и метод
       позволяющее получить его текущее состояние. Написать код, демонстрирующий все возможности класса. */

    private static final int DEFAULT_LOWER_FACE =   0,
                             DEFAULT_UPPER_FACE =   100,
                             DEFAULT_VALUE      =   0;
        
    private int lowerFace, upperFace, value;

    Counter() {

        lowerFace   =   DEFAULT_LOWER_FACE;
        upperFace   =   DEFAULT_UPPER_FACE;
        value       =   DEFAULT_VALUE;

    }

    Counter(int value) {

        lowerFace   =   DEFAULT_LOWER_FACE;
        upperFace   =   DEFAULT_UPPER_FACE;

        if (value > upperFace)
            throw new IllegalArgumentException("Value must be lesser than upper face.");

        if (value < lowerFace)
            throw new IllegalArgumentException("Value must be greater than lower face.");

        this.value  =   value;

    }

    Counter(int value, int lowerFace, int upperFace) {

        if (lowerFace >= upperFace)
            throw new IllegalArgumentException("Lower face must be lesser than upper face.");

        if (value > upperFace)
            throw new IllegalArgumentException("Value must be lesser than upper face.");

        if (value < lowerFace)
            throw new IllegalArgumentException("Value must be greater than lower face.");

        this.lowerFace  =   lowerFace;
        this.upperFace  =   upperFace;
        this.value      =   value;

    }

    public int get() { return value; }

    public int getLowerFace() { return lowerFace; }

    public int getUpperFace() { return upperFace; }

    public boolean increase(int n) {
        if (value + n <= upperFace) {
            value += n;
            return true;
        }
        else return false;
    }

    public boolean increase() { return increase(1); }

    public boolean decrease(int n) {
        if (value - n >= lowerFace) {
            value -= n;
            return true;
        }
        else return false;
    }

    public boolean decrease() { return decrease(1); }


}
