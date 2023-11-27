import java.sql.Struct;
import java.util.Scanner;

public class Seminar1_homework {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // System.out.print("Input number: ");
        // int number = scanner.nextInt();
        // System.out.println("Result: " + task1(number));

        // System.out.println();

        // System.out.print("Input start interval: ");
        // int startInterval = scanner.nextInt();

        // System.out.print("Input end interval: ");
        // int endInterval = scanner.nextInt();

        // System.out.println("Prime numbers in the range from " + startInterval + " to
        // " + endInterval + ":");

        // for (int i = startInterval; i <= endInterval; i++) {
        // if (task2(i)) {
        // System.out.print(i + " ");
        // }
        // }

        // System.out.println();

        // boolean isValid = false;
        // while (!isValid) {
        // try {
        // System.out.print("Input number 1: ");
        // double number1 = scanner.nextDouble();

        // System.out.print("Input operator (+, -, *, /): ");
        // char operator = scanner.next().charAt(0);

        // System.out.print("Input number 2: ");
        // double number2 = scanner.nextDouble();

        // double result = task3(operator, number1, number2);
        // System.out.print(number1 + " " + operator + " " + number2 + " = " + result);

        // isValid = true;
        // } catch (java.util.InputMismatchException e) {
        // System.out.println("Ошибка ввода. Пожалуйста, введите корректные числа.");
        // scanner.nextLine(); // Очистка буфера ввода
        // } catch (ArithmeticException e) {
        // System.out.println("Ошибка арифметической операции: " + e.getMessage());
        // } catch (Exception e) {
        // System.out.println("Произошла ошибка: " + e.getMessage());
        // }
        // }

        task4();

        scanner.close();
    }

    static int task1(int num) {
        // Вычислить n-ое треугольного число(сумма чисел от 1 до n), n!
        // (произведение чисел от 1 до n)

        if (num <= 1) {
            return 1;
        } else {
            return num + task1(num - 1);
        }

    }

    static boolean task2(int num) {
        // Вывести все простые числа от 1 до 1000
        if (num < 2)
            return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    static double task3(char operator, double number1, double number2) {
        // Реализовать простой калькулятор

        switch (operator) {
            case '+':
                return number1 + number2;
            case '-':
                return number1 - number2;
            case '/':
                if (number2 != 0)
                    return number1 / number2;
                else {
                    throw new ArithmeticException("На ноль делить нельзя!");
                }
            case '*':
                return number1 * number2;
            default:
                throw new IllegalArgumentException("Некорректный оператор: " + operator);
        }

    }

    static void task4() {
        // *+Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры
        // могут быть заменены знаком вопроса, например 2? + ?5 = 69. Требуется
        // восстановить выражение до верного равенства. Предложить хотя бы
        // одно решение или сообщить, что его нет.
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the equation (use '?' for unknown digits, e.g., 2? + ?5 = 69): ");
        String equation = scanner.nextLine();

        if (isValidEquationFormat(equation)) {
            System.out.println("Equation format is valid.");

            // Извлекаем значения q, w, e из уравнения
            int q = Character.getNumericValue(equation.charAt(0));
            int w = Character.getNumericValue(equation.charAt(4));
            int e = Character.getNumericValue(equation.charAt(8));

            // Проверяем условие уравнения
            if (q + w == e) {
                System.out.println("Equation is satisfied: " + q + " + " + w + " = " + e);
            } else {
                System.out.println("Equation is not satisfied.");
            }
        } else {
            System.out.println("Invalid equation format. Please use '?' for unknown digits.");
        }

        scanner.close();
    }

    static boolean isValidEquationFormat(String equation) {
        // Просто проверяем, что строка содержит 3 цифры, разделенные знаками '?', '+', '='
        return equation.matches("\\d[?]\\s?\\+\\s?[?]\\s?=\\s?\\d");
    }

    static void findSolution(int q, int w) {

        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                int sum = q + w + i * 10 + j;
                if (sum >= 0 && sum < 10) {
                    System.out.println("Solution found: " + q + " + " + w + " = " + i + " + " + j);
                    return;
                }
            }
        }
        System.out.println("No solution found.");
    }

}
