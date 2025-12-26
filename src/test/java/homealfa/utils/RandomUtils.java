package homealfa.utils;

import com.github.javafaker.Faker;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    Faker faker = new Faker();

    public static String getRandomFullName() {
        return new Faker().name().fullName();
    }

    public static String getRandomBirthday() {
        int day = getRandomInt(1, 28);
        int month = getRandomInt(1, 12);
        int year = getRandomInt(1900, 2024);

        // Форматируем с ведущими нулями: дд.мм.гггг
        return String.format("%02d.%02d.%04d", day, month, year);
    }

    public static String getRandomTelephone() {
        return "9" + getRandomInt(11,99) + getRandomInt(111,999) + getRandomInt(11,99) + getRandomInt(11,99);
        //return new Faker().phoneNumber().phoneNumber();
    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomMailAdress() {
        return new Faker().internet().emailAddress();
    }

}
