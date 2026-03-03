package io.lab2;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.lab2.util.CommonTask;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/// Необходимо сделать “GET” запрос на указанный адрес и обработать
/// ответ. Запрос выполняется на тестовый сервер по адресу
/// “https://httpbin.org/”
/// . Сервер возвращает ответ в формате JSON. Из ответа
/// необходимо извлечь и вывести в консоль информацию в соответствии со
/// своим вариантом. Вывести только значение хоста сервера (поле “Host”) из
/// заголовков (запрос выполняется по адресу “https://httpbin.org/get”).
public class Task4 implements CommonTask {

    @Override
    public void run() {

        System.out.println("\n=== Задание 4: HTTP Client и JSON ===");

        // 1. Создаем HTTP клиент
        try (HttpClient client = HttpClient.newHttpClient()) {

            // 2. Формируем GET-запрос
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://httpbin.org/get"))
                    .GET()
                    .build();

            // 3. Отправляем запрос
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // 4. Получаем JSON
            String responseBody = response.body();

            // 5. Парсим JSON
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(responseBody);

            // 6. Извлекаем поле Host из headers
            String host = root
                    .get("headers")
                    .get("Host")
                    .asText();

            // 7. Выводим результат
            System.out.println("Host: " + host);

        } catch (IOException | InterruptedException e) {
            System.out.println("Error during HTTP request: " + e.getMessage());
        }
    }
}