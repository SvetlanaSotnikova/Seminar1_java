
import java.util.Scanner;

public class Seminar1_homework {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input number: ");
        int number = scanner.nextInt();
        System.out.println("Result: " + task1(number));

        System.out.println();

        System.out.print("Input start interval: ");
        int startInterval = scanner.nextInt();

        System.out.print("Input end interval: ");
        int endInterval = scanner.nextInt();

        System.out.println("Prime numbers in the range from " + startInterval + " to" + endInterval + ":");

        for (int i = startInterval; i <= endInterval; i++) {
            if (task2(i)) {
                System.out.print(i + " ");
            }
        }

        System.out.println();

        boolean isValid = false;
        while (!isValid) {
            try {
                System.out.print("Input number 1: ");
                double number1 = scanner.nextDouble();

                System.out.print("Input operator (+, -, *, /): ");
                char operator = scanner.next().charAt(0);

                System.out.print("Input number 2: ");
                double number2 = scanner.nextDouble();

                double result = task3(operator, number1, number2);
                System.out.print(number1 + " " + operator + " " + number2 + " = " + result);

                isValid = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Ошибка ввода. Пожалуйста, введите корректные числа.");
                scanner.nextLine(); // Очистка буфера ввода
            } catch (ArithmeticException e) {
                System.out.println("Ошибка арифметической операции: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Произошла ошибка: " + e.getMessage());
            }
        }

        System.out.println();

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

        equation = equation.replace(" ", "");

        // if (isValidEquationFormat(equation)) {
        if (true) {
            System.out.println("Equation format is valid.");

            int eqlength = equation.length();

            int plus = equation.indexOf("+");
            int eq = equation.indexOf("=");

            int length1 = plus;
            int length2 = eq - plus - 1;
            int length3 = eqlength - eq - 1;

            int i = 1;
            int perehod = 0;
            int firstch, secondch, thirdch, result;

            char[] first = new char[length1];
            char[] second = new char[length2];
            char[] third = new char[length3];

            equation.getChars(0, plus, first, 0);
            equation.getChars(plus + 1, eq, second, 0);
            equation.getChars(eq + 1, eqlength, third, 0);

            // System.out.println(plus);
            // System.out.println(eq);
            // System.out.println(length1);
            // System.out.println(length2);
            // System.out.println(length3);
            // System.out.println(first[0]);
            // System.out.println(second[0]);
            // System.out.println(third[0]);

            if (length1 > length3 || length2 > length3) {
                System.out.println("Equation is not satisfied.");
                scanner.close();
                return;
            }

            if (length1 == length2 && length2 == length3 - 1) {
                if (third[0] == '?')
                    third[0] = '1';
                if (first[0] == '?' && second[0] == '?' && (third[1] == '8' || third[1] == '9')) {
                    first[0] = '9';
                    second[0] = '9';
                } else if (first[0] == '1' && second[0] == '?' && third[1] == '?') {
                    second[0] = '9';
                    third[1] = '0';
                } else if (first[0] == '?' && second[0] == '1' && third[1] == '?') {
                    first[0] = '9';
                    third[1] = '0';
                }
            } else if (length1 == length3 - 1) {
                if (third[0] == '?')
                    third[0] = '1';
                if (first[0] == '?' && third[1] == '?') {
                    first[0] = '9';
                    third[1] = '0';
                }
            } else if (length2 == length3 - 1) {
                if (third[0] == '?')
                    third[0] = '1';
                if (second[0] == '?' && third[1] == '?') {
                    second[0] = '9';
                    third[1] = '0';
                }
            }

            while (i <= length3) {
                firstch = i <= length1 ? (int) first[length1 - i] - 48 : 0;
                secondch = i <= length2 ? (int) second[length2 - i] - 48 : 0;
                thirdch = (int) third[length3 - i] - 48;
                if (firstch > 9) {
                    if (secondch > 9 || thirdch > 9) {
                        System.out.println("Equation is not satisfied.");
                        scanner.close();
                        return;
                    } else {
                        result = thirdch - secondch - perehod;
                        if (result < 0) {
                            result += 10;
                            perehod = 1;
                        } else
                            perehod = 0;
                        first[length1 - i] = (char) (result + 48);
                    }
                } else if (secondch > 9) {
                    if (thirdch > 9) {
                        System.out.println("Equation is not satisfied.");
                        scanner.close();
                        return;
                    } else {
                        result = thirdch - firstch - perehod;
                        if (result < 0) {
                            result += 10;
                            perehod = 1;
                        } else
                            perehod = 0;
                        second[length2 - i] = (char) (result + 48);
                    }
                } else if (thirdch > 9) {
                    result = firstch + secondch + perehod;
                    if (result > 9) {
                        result -= 10;
                        perehod = 1;
                    } else
                        perehod = 0;
                    third[length3 - i] = (char) (result + 48);
                } else {
                    result = firstch + secondch + perehod;
                    if (result > 9) {
                        result -= 10;
                        perehod = 1;
                    } else
                        perehod = 0;
                    if (result != thirdch) {
                        System.out.println("Equation is not satisfied.");
                        scanner.close();
                        return;
                    }
                }
                i++;
            }
            if (first[0] == '0' || second[0] == '0' || third[0] == '0' || perehod == 1) {
                System.out.println("Equation is not satisfied.");
                scanner.close();
                return;
            } else
                System.out.println("Equation is satisfied: " + String.valueOf(first) + " + " + String.valueOf(second)
                        + " = " + String.valueOf(third));
        }
        // else {
        // System.out.println("Invalid equation format. Please use '?' for unknown
        // digits.");

        // scanner.close();
        // return;
        // }
    }

    static boolean isValidEquationFormat(String equation) {
        // Просто проверяем, что строка содержит 3 цифры, разделенные знаками '?', '+',
        // '='
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
