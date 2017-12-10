package ru.ivmiit;

import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 10.11.2017
 * Main
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        // завели пул потоков
        ExecutorService service = Executors.newCachedThreadPool();
        // класс, который умеет посылать запросы в Java-приложении
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        List<HttpMessageConverter<?>> converters = new ArrayList<>();
        converters.add(converter);
        final RestTemplate template = new RestTemplate(converters);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Пожалуйста, зарегистрируйтесь");
        final String name = scanner.nextLine();

        template.getForObject("http://localhost:8080/register?user=" + name, String.class);

        // мы отправили задачу по получению сообщений в побочный поток
        service.submit(() -> {
            while (true) {
                Message result[] = template.getForObject("http://localhost:8080/messages?user=" + name,
                        Message[].class);
                for (Message message : result) {
                    System.out.println(message.getUser() + ": " + message.getText());
                }
            }
        });

        service.submit(() -> {
            while (true) {
                String text = scanner.nextLine();
                Message message = new Message(text, name);
                template.postForEntity("http://localhost:8080/messages", message, String.class);
            }
        });
    }
}
