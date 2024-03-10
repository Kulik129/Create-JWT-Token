package org.example;

public class Main {
    public static void main(String[] args) {
        // Генерация токена
        String createdToken = Token.generateToken("Dmitrii", User.builder().id(123L).name("Dmitrii").userRole("ADMIN").build(), 30);
        System.out.println(createdToken);

        // Проверка валидности токена
        String jwtToken = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJEbWl0cmlpIiwidXNlcklEIjoxMjMsInVzZXJSb2xlIjoiQURNSU4iLCJ1c2VyTmFtZSI6IkRtaXRyaWkiLCJpYXQiOjE3MTAwOTI4NjAsImV4cCI6MTcxMjY4NDg2MH0.JSBvUcKUnwJvjdDaQsWYWuBQNTtYZpj-xBP-gp3wzsU\n";
        long remainingTimeMillis = Token.getRemainingTime(jwtToken);

        if (remainingTimeMillis > 0) {
            long remainingTime = remainingTimeMillis / 60000; // делим на к-ва милисекунд в минуте
            System.out.println("Токен все еще действителен. Оставшееся время:" + remainingTime + " минут");
        } else {
            System.out.println("Срок действия токена истек.");
        }
    }
}