package engineer.leepsky.javaintroonline.classes.simple.simple3;

public class Student {

    /* Создайте класс с именем Student, содержащий поля: фамилия и инициалы, номер группы, успеваемость (массив
       из пяти элементов). Создайте массив из десяти элементов такого типа. Добавьте возможность вывода фамилий и
       номеров групп студентов, имеющих оценки, равные только 9 или 10. */

    private String name;
    private int group;
    private int[] grades;

    Student(String name, int group, int[] grades) {

        if ( grades.length != 5 )
            throw new IllegalArgumentException("Grades array must be of length 5.");

        this.grades = grades;
        this.name = name;
        this.group = group;

    }

    boolean isGood(int grade) {

        for (var g : grades)
            if (g < 9) return false;
        
        return true;

    }

    public String toString() {

        var buff = new StringBuilder();

        buff.append(name)
            .append("; gr.: ")
            .append(group);

        return buff.toString();

    }

    public static void printGood(Student[] students) {

        for (var student : students)
            if ( student.isGood(9) )
                System.out.println(student.toString());

    }

}