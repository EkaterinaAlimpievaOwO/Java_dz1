import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class JavaDZ1 {
    public static void main(String[] args) {
        Exercise1();
        // Exercise2();
        // Exercise3();
        // Exercise4();
    }

    // ------------------------------------------------------------------
    // 1 Вычислить n-ое треугольное число (сумма чисел от 1 до n)

    static void Exercise1() {
        Scanner check = new Scanner(System.in);
        System.out.println("Введите число n: ");
        int n = check.nextInt();
        check.close();
        int sum = 0;
        if (n < 0) {
            System.out.println("Число не должно быть отрицательным");
        } else if (n == 0 || n == 1) {
            System.out.printf("Cумма равна: %d", n);
        } else {
            for (int i = 1; i <= n; i++) {
                sum += i;
            }
            System.out.printf("Cумма чисел от 1 до n равна: %d", sum);
        }
    }

    // ------------------------------------------------------------------
    // 2 Вычислить n! (произведение чисел от 1 до n)

    static void Exercise2() {
        Scanner check = new Scanner(System.in);
        System.out.println("Введите число n: ");
        int n = check.nextInt();
        check.close();
        int factorial = 1;
        if (n < 0) {
            System.out.println("Число не должно быть отрицательным");
        } else if (n == 0 || n == 1) {
            System.out.printf("%d! равен 1", n);
        } else {
            for (int i = 2; i <= n; i++) {
                factorial *= i;
            }
            System.out.printf("%d! равен %d", n, factorial);
        }
    }

    // ------------------------------------------------------------------
    // 3 Вывести все простые числа от 1 до 1000 (числа, которые делятся только на 1
    // и на себя без остатка)

    static void Exercise3() {
        int numbers = 1000;
        int[] arr = IntStream.rangeClosed(0, numbers).toArray();
        arr[1] = 0;
        double sqrt = Math.sqrt(numbers);
        for (int i = 2; i <= sqrt; i++) {
            for (int j = i * i; j < arr.length; j = j + i) {
                arr[j] = 0;
            }
        }
        int count = 0;
        for (int i = 0; i <= numbers; i++) {
            if (arr[i] != 0) {
                count++;
            }
        }
        int[] newArr = new int[count];
        int j = 0;
        for (int i = 0; i <= numbers; i++) {
            if (arr[i] != 0) {
                newArr[j] = arr[i];
                j++;
            }
        }

        String res = Arrays.toString(newArr);
        System.out.printf(res);
    }

    // ------------------------------------------------------------------
    // 4 Реализовать простой калькулятор (введите первое число, введите второе
    // число, введите требуемую операцию, ответ)

    static void Exercise4() {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите первое число:  ");
        double a = in.nextDouble();

        System.out.println("Выберите действие: + / - / * / : ");
        String value = in.next();

        System.out.println("Введите второе число:  ");
        double b = in.nextDouble();
        in.close();

        double result = 0;
        switch (value) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case ":":
                result = a / b;
                break;

            default:
                result = 0;
                break;
        }

        System.out.printf("Результат вычисления: %s", result);
    }

}
