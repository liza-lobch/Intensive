package ru.aston.lobchevskaya_eyu.task3;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import ru.aston.lobchevskaya_eyu.task1.classes.User;

public class StreamAPITaskTest {

    @Test
    // 1. Вывести все четные числа в диапазоне от 1 до 100
    public void displayEvenNumbersFrom1To100() {
        IntStream.rangeClosed(1, 100).
                filter(n -> n % 2 == 0).
                forEach(System.out::println);
    }

    @Test
    // 2. Умножить каждое число в массиве [1, 2, 3, 4, 5] на 2
    public void multiplyByTwoEachElement() {
        int[] array = {1, 2, 3, 4, 5};
        Arrays.stream(array).map(n -> n * 2).forEach(System.out::println);
    }

    @Test
    // 3. Пропустить первые 10 элементов списка [0, 1, 2,.., 99] и начать выводить с 11-го элемента, выводя каждый 10-й элемент
    public void skipFirstTenPrintEvery10thElement() {
        IntStream.rangeClosed(0, 99).
                skip(10).
                filter(n -> n % 10 == 0).
                forEach(System.out::println);
    }

    @Test
    // 4. Выведите на экран строки, которые начинаются с заданной подстроки
    public void displayLinesWithGivenSubstring() {
        List<String> list = Arrays.asList("mother", "father", "sister", "brother", "motion");
        list.stream().filter(s -> s.startsWith("m")).forEach(System.out::println);
    }

    @Test
    // 5. Отфильтруйте объекты по определенному свойству, например, выведите все записи из базы данных, у которых значение поля равно 1
    public void filterObjectsByProperty() {
        List<User> users = Arrays.asList(
                new User("Иванов", "Пётр", 20),
                new User("Андреев", "Кирилл", 16),
                new User("Николаев", "Андрей", 40),
                new User("Петров", "Виктор", 12),
                new User("Ильин", "Владислав", 27)
        );
        users.stream().
                filter(user -> user.getAge() >= 18).
                forEach(System.out::println);
    }

    @Test
    // 6. Собрать числа в Stream в список сумм цифр каждого числа
    public void collectNumbersIntoDigitsSumList() {
        var stream = Stream.of(112, 224, 336).
                map(num -> num.toString().
                        chars().
                        map(Character::getNumericValue).
                        sum()
                ).collect(Collectors.toList());
        System.out.println(stream);
    }

    @Test
    // 7. Создайте Stream-у чисел от 1 до 20. Создайте новый Stream, который будет выводить на экран только четные числа и числа, кратные 3. Затем объедините эти два Stream-a в один и выведите результирующий Stream
    public void mergeStreams() {
        var stream1 = IntStream.rangeClosed(1, 20);
        var stream2 = IntStream.rangeClosed(1, 20).filter(n -> n % 2 == 0 || n % 3 == 0);
        IntStream.concat(stream1, stream2).forEach(System.out::println);
    }

    @Test
    // 8. Создать стрим, который выводит числа от 1 до 10. Найти среднее арифметическое этих чисел и вывести его на экран.
    public void findAverage() {
        var avg = IntStream.rangeClosed(1, 10).average().getAsDouble();
        System.out.println(avg);
    }

    @Test
    // 9. Разделить файлы в Stream на два списка: с расширением .txt и с расширением .doc, посчитать количество файлов в каждом списке
    public void splitFiles() {
        List<String> files = Arrays.asList("test1.txt", "test2.doc", "test3.txt", "test4.txt", "test5.doc");
        var map = files.stream().collect(Collectors.groupingBy(f -> f.substring(f.indexOf(".")), Collectors.counting()));
        System.out.println(map);
    }

    @Test
    // 10. Создание Stream целых чисел и поиск всех чисел, у которых сумма цифр равна заданному числу
    public void digitsSumListEqualToGivenNumber() {
        int givenNumber = 4;
        var stream = Stream.of(112, 224, 336, 301).
                filter(num -> num.toString().chars().map(Character::getNumericValue).sum() == givenNumber).collect(Collectors.toList());
        System.out.println(stream);
    }
}
