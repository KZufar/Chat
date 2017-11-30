import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите текст: ");
        String login = "kayumov.zufar@gmail.com";
        String MD5 = "8e67d01dfd851d4f0ef21da9348db4df";
        String to = "79520437414";
        String from = "biznes";
        String type = "7";
        String text = scanner.nextLine();
        String request = "https://gate.smsaero.ru/send/" + "?user="
                + login + "&password="
                +  MD5+ "&to="
                +  to
                + "&text=" + text
                + "&from="
                + from + "&type="
                + type;
        System.out.println(request);

        RestTemplate template = new RestTemplate();
        ResponseEntity<String> responseEntity = template.getForEntity(request,String.class);

        System.out.println(responseEntity.getBody());

    }
}
