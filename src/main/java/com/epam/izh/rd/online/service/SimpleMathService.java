package com.epam.izh.rd.online.service;

public class SimpleMathService implements MathService {

    /**
     * Метод возвращает 0, если value1 = value2.
     * Метод возвращает -1, если value1 < value2.
     * Метод возвращает 1, если value1 > value2.
     *
     * Например для (-1, -1) метод должен вернуть 0;
     * Например для (-3, -1) метод должен вернуть -1;
     * Например для (3, 1) метод должен вернуть 1;
     */
    @Override
    public int compare(int value1, int value2) {
        if (value1 == value2) {
            return 0;
        } else if (value1 < value2) {
            return -1;
        } else {
            return 1;
        }
    }

    /**
     * Метод возвращает максимальное число из пары.
     * Например для списка (-1, 2) метод должен вернуть 2
     */
    @Override
    public int maxFrom(int value1, int value2) {
        if (value1 >= value2) {
            return value1;
        } else {
            return value2;
        }
    }

    /**
     * Метод возвращает максимальное число из переданного массива.
     * Например для списка {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть 22
     */
    @Override
    public int maxFrom(int[] values) {
        int max = values[0];
        for (int element: values) {
            if (max < element) {
                max = element;
            }
        }
        return max;
    }

    /**
     * Метод возвращает сумму чисел массива.
     * Например для списка {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть 30
     */
    @Override
    public int sum(int[] values) {
        int sumElement = 0;
        for (int element: values) {
            sumElement += element;
        }
        return sumElement;
    }

    /**
     * Метод фильтрует массив, оставляя только четные числа.
     * Например для списка {-1, -3, 4, 8, 5, 22, 17} метод должен вернуть {4, 8, 22}
     */
    @Override
    public int[] getEvenDigits(int[] values) {
        int[] resultValues = new int[values.length];
        int j = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] % 2 == 0 ) {
                resultValues[j] = values[i];
                j++;
            }
        }
        int[] result = new int[j];
        for (int i = 0; i < j; i++) {
            result[i] = resultValues[i];
        }
        return result;
    }

    /**
     * Метод считает факториал из заданного числа.
     * Например для числа 5 метод должен вернуть 120.
     * Факториал 0 должен быть равен 1.
     */
    @Override
    public long calcFactorial(int initialVal) {
        int factorial = 1;
        if (initialVal == 0) {
            return 1;
        } else if (initialVal < 0) {
            throw new IllegalArgumentException("Exception: negative number cannot be converted!");
        } else {
            for (int i = 1; i <= initialVal; i++) {
                factorial *= i;
        }
            return factorial;
        }
    }

    /**
     * Метод возвращает число, которое находится на заданной позиции (счет начинается с нуля) в ряду фибоначчи.
     *
     * Ряд фибоначчи - ряд, следующие элементы которого состоят из суммы двух предыдущих.
     * Ряд начинается 0 и 1.
     * Пример 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 ...
     *
     * Для числа 9 метод должен вернуть 34
     * Для числа 0 метод должен вернуть 0
     */
    @Override
    public long calcFibonacci(int number) {
        if (number == 0) {
            return 0;
        } else if (number == 1) {
            return 1;
        } else if (number < 0) {
            throw new IllegalArgumentException("Exception: negative number cannot be converted!");
        } else {
            long firstNumber = 0;
            long secondNumber = 1;
            long fibonacci = 0;
            for (int i = 2; i <= number; i++) {
                fibonacci = firstNumber + secondNumber;
                firstNumber = secondNumber;
                secondNumber = fibonacci;
            }
            return fibonacci;
        }
    }

    /**
     * Метод возвращает отсортированный по возрастанию массив.
     * Например для массива {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть {-5, -3, -1, 4, 5, 8, 22}
     */
    @Override
    public int[] sort(int[] values) {
        for (int i = 0; i < values.length; i++) {
            int v;
            for (int j = 0; j < values.length; j++) {
                if (values[i] < values[j]) {
                    v = values[i];
                    values[i] = values[j];
                    values[j] = v;
                }
            }
        }
        return values;
    }

    /**
     * Метод определяет, является ли заданное число простым.
     * Простое число - число, которое делится только на 1 и на само себя.
     *
     * Например для числа 22 вернется false, а для числа 23 true.
     */
    @Override
    public boolean isPrimary(int number) {
        int k = 0;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                k++;
            }
        }
        if (k == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Метод возвращает массив, в котором элементы расположены в обратном порядке.
     *
     * Например для массива {-1, -3, 4, 8, 5, 22, -5} метод вернет {-5, 22, 5, 8, 4, -3, -1}
     */
    @Override
    public int[] reverseArray(int[] values) {
        int reverseArr[] = new int[values.length];
        int j = values.length - 1;
        for (int i = 0; i < values.length; i++) {
            reverseArr[i] = values[j];
            j--;
        }
        return reverseArr;
    }
}
