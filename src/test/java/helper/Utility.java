package helper;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Utility {
    public static WebDriver driver;
    public static void startDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    public static void quitDriver() {
        driver.quit();
    }
    public static String shuffleTitle() {
        List<String> titleList = Arrays.asList("mr", "ms", "mrs", "miss", "dr");
        Collections.shuffle(titleList);

        Random rand = new Random();
        int randomIndex = rand.nextInt(titleList.size());
        return titleList.get(randomIndex);
    }

    public static String generateRandomPictureLink() {
        String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "1234567890";
        String pictureLink = "";
        String temp = RandomStringUtils.randomAlphanumeric(10);
        pictureLink = "https://" + temp + ".jpeg";
        return pictureLink;
    }


}