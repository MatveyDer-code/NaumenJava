package io.lab2;

/// Отсюда запускаются все задания (Вариант 5)
public class Main {
    public static void main(String[] args) {
        // Задание 1
        Task1 task1 = new Task1();
        task1.run();

        // Задание 2
        Task2 task2 = new Task2();
        task2.run();

        // Задание 3
        Task3 task3 = new Task3();
        task3.run();

        // Задание 4
        Task4 task4 = new Task4();
        task4.run();

        // Задание 5
        Task5 scanner = new Task5("ya.ru", 0, 90);

        new Thread(scanner::start).start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        scanner.stop();
    }
}