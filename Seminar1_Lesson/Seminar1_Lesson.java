import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
// import java.io.Writer;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Scanner;

public class Seminar1_Lesson {
    public static void main(String[] args) {
        System.out.println("Input your name: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + ", welcome to the seminar!");

        task0(scanner);
        task1();
        task2();

        String[] str = { "apple", "app", "appricot" };
        System.out.println(task3(str));

        task4("Добро пожаловать на курс по Java");
        System.out.println(task5(3, 2));
        task6(1, 7, 1, 3, "");

        int[] nums = { -7, 1, 5, 2, -4, 3, 0 };
        System.out.println(task7(nums));

        String data = "Name Surname Age\n" +
                "Kate Smith 20\n" +
                "Paul Green 25\n" +
                "Mike Black 23";
        String fileName = "task8.txt";
        task8(fileName, data);

        scanner.close();

    }

    static void task0(Scanner scanner) {
        // В консоли запросить имя пользователя. В зависимости от
        // текущего времени, вывести приветствие вида
        // "Доброе утро, <Имя>!", если время от 05:00 до 11:59
        // "Добрый день, <Имя>!", если время от 12:00 до 17:59;
        // "Добрый вечер, <Имя>!", если время от 18:00 до 22:59;
        // "Доброй ночи, <Имя>!", если время от 23:00 до 4:59

        System.out.println("Input your name: ");
        // Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        LocalTime localTime = LocalTime.now();
        int hour = localTime.getHour();

        if (hour >= 5 && hour < 12)
            System.out.println("Good morning " + name);
        else if (hour >= 12 && hour < 18)
            System.out.println("Good afternoon " + name);
        else if (hour >= 18 && hour <= 23)
            System.out.println("Good evening " + name);
        else
            System.out.println("Good night " + name);

    }

    static void task1() {
        // Дан массив двоичных чисел, например [1,1,0,1,1,1], вывести
        // максимальное количество подряд идущих 1.
        int[] arr = { 1, 1, 0, 1, 1, 1 };
        int count = 0;
        int maxOnes = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1)
                count++;
            else {
                if (count > maxOnes)
                    maxOnes = count;
                count = 0;
            }
        }
        if (maxOnes < count)
            maxOnes = count;
        System.out.println(maxOnes);
    }

    static void task2() {
        // Дан массив nums = [3,2,2,3] и число val = 3.
        // Если в массиве есть числа, равные заданному, нужно перенести
        // эти элементы в конец массива.
        // Таким образом, первые несколько (или все) элементов массива
        // должны быть отличны от заданного, а остальные - равны ему.
        int[] nums = { 3, 2, 2, 3, 2, 4, 3, 3, 5, 6, 7 };
        int val = 3;
        int[] tempArr = new int[nums.length];
        Arrays.fill(tempArr, val);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                tempArr[count++] = nums[i];
            }
        }
        System.out.println(Arrays.toString(tempArr));
    }

    static String task3(String[] strings) {
        // Напишите метод, который находит самую длинную строку общего
        // префикса среди массива строк.
        // Если общего префикса нет, вернуть пустую строку ""

        if (strings == null || strings.length == 0) {
            return "";
        }

        String prefix = strings[0];
        for (int i = 1; i < strings.length; i++) {
            int j = 0;
            while (j < prefix.length() && j < strings[i].length() && prefix.charAt(j) == strings[i].charAt(j)) {
                j++;
            }
            prefix = prefix.substring(0, j);
            if (prefix.isEmpty()) {
                return "";
            }

        }
        return prefix;
    }

    static void task4(String str) {
        // Во фразе "Добро пожаловать на курс по Java" переставить слова
        // в обратном порядке.
        String[] arr = str.split(" ");
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }

    }

    static double task5(int a, int b) {
        // Реализовать функцию возведения числа а в степень b. a, b из Z.
        // Сводя количество выполняемых действий к минимуму.
        // Пример 1: а = 3, b = 2, ответ: 9
        // Пример 2: а = 2, b = -2, ответ: 0.25
        // Пример 3: а = 3, b = 0, ответ: 1

        double result = 1;
        int c = (b < 0) ? -b : b;
        for (int i = 0; i < c; i++) {
            result *= a;
        }
        return b > 0 ? result : 1 / result;

        // return Math.pow(a, b);
    }

    static void task6(int source, int target, int c, int d, String path) {
        // На вход некоторому исполнителю подаётся два числа (a, b). У исполнителя есть
        // две команды
        // - команда 1 (к1): увеличить в с раза, а умножается на c
        // - команда 2 (к2): увеличить на d ( +2 ), к a прибавляется d
        // Написать программу, которая выдаёт набор команд, позволяющий число a
        // превратить в число b или сообщить, что это невозможно
        // Пример 1: а = 1, b = 7, c = 1, d = 3
        // ответ: к1, к1, к1, к1, к1, к1 или к1, к2, к1, к1, к1 или к1, к1, к2, к1.
        // Пример 2: а = 11, b = 7, c = 2, d = 1
        // ответ: “”

        if (source > target)
            return;
        if (source == target) {
            System.out.println(path);
            return;
        }

        task6(source + c, target, c, d, path + " k1");
        task6(source * d, target, c, d, path + " k2");

    }

    static int task7(int[] nums) {
        // Задан массив, например, nums = [1,7,3,6,5,6].
        // Написать программу, которая найдет индекс i для этого массива
        // такой, что сумма элементов с индексами < i равна сумме
        // элементов с индексами > i.
        int totalSum = 0;
        int leftSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
            if (totalSum == leftSum)
                return i;
            leftSum += nums[i];
        }
        return -1;
    }

    static void task8(String fileName, String data) {
        // Записать в файл следующие данные:
        // Name Surname Age
        // Kate Smith 20
        // Paul Green 25
        // Mike Black 23
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(data);
            System.out.println("Data was sucseccful writed " + fileName);
        } catch (IOException e) {
            System.err.println("Error " + e.getMessage());
        }

    }
}