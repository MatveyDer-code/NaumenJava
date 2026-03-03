package io.lab2;

import io.lab2.util.Task;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/// Необходимо реализовать интерфейс Task (см. Приложение Г) в
/// соответствии с своим вариантом задания.Реализуйте интерфейс “Task” для сканирования сети на открытые
/// порты в заданном диапазоне. При нахождении открытого порта,
/// информация о нем печатается в консоль. Методы start() начинает
/// сканирование, а stop() прерывает его. Для выполнения задания
/// рекомендуется использовать класс “java.net.Socket”
/// .
public class Task5 implements Task {

    private final String host;
    private final int startPort;
    private final int endPort;

    private volatile boolean running = false;

    public Task5(String host, int startPort, int endPort) {
        this.host = host;
        this.startPort = startPort;
        this.endPort = endPort;
    }

    @Override
    public void start() {
        System.out.println("\n=== Задание 5: Реализация интерфейса “Task” ===");

        running = true;

        System.out.println("Начато сканирование хоста: " + host);
        System.out.println("Диапазон портов: " + startPort + " - " + endPort);

        for (int port = startPort; port <= endPort && running; port++) {

            try (Socket socket = new Socket()) {

                // Таймаут соединения (чтобы не зависало)
                socket.connect(new InetSocketAddress(host, port), 200);

                System.out.println("Найден открытый порт: " + port);

            } catch (IOException ignored) {
                // Порт закрыт — ничего не выводим
            }
        }
    }

    @Override
    public void stop() {
        running = false;
        System.out.println("Сканирование остановлено.");
    }
}