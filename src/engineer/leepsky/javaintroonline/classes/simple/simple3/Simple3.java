package engineer.leepsky.javaintroonline.classes.simple.simple3;

public class Simple3 {

    /* Создайте класс с именем Student, содержащий поля: фамилия и инициалы, номер группы, успеваемость (массив
       из пяти элементов). Создайте массив из десяти элементов такого типа. Добавьте возможность вывода фамилий и
       номеров групп студентов, имеющих оценки, равные только 9 или 10. */

    public static void main(String[] args) {

        Student[] students = {
            new Student("Firstman A.", 100000, new int[] {10, 10, 10, 10, 9}),
            new Student("Firstman B.", 100000, new int[] {5, 10, 10, 10, 10}),
            new Student("Firstman C.", 100001, new int[] {10, 10, 10, 9, 10}),
            new Student("Firstman D.", 100001, new int[] {10, 5, 10, 10, 10}),
            new Student("Firstman E.", 100002, new int[] {10, 10, 9, 10, 10}),
            new Student("Firstman F.", 100003, new int[] {10, 10, 5, 10, 10}),
            new Student("Firstman G.", 100003, new int[] {10, 9, 10, 10, 10}),
            new Student("Firstman H.", 100004, new int[] {10, 10, 10, 5, 10}),
            new Student("Firstman I.", 100004, new int[] {9, 10, 10, 10, 10}),
            new Student("Firstman I.", 100004, new int[] {10, 10, 10, 10, 5})
        };

        Student.printGood(students);

    }
    
}
