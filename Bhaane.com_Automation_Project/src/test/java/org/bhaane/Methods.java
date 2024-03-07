package org.bhaane;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

import static org.bhaane.BaseWorkspace.FIRST_NAMES;
import static org.bhaane.BaseWorkspace.LAST_NAMES;

public class Methods {

    static final Logger logger = Logger.getLogger("Reports");

    static {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy_hhmm");
            String timestamp = dateFormat.format(new Date());

            FileHandler reg = new FileHandler("Reports" + "_" + timestamp + ".log");
            reg.setFormatter(new XMLFormatter());
            logger.addHandler(reg);
            logger.setLevel(Level.ALL);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void captureScreenshot(WebDriver driver) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        byte[] screenshotBytes = ts.getScreenshotAs(OutputType.BYTES);
        String fileName = generateFileName();
        String filePath = "screenshots/" + fileName + ".png";
        try {
            Files.write(new File(filePath).toPath(), screenshotBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String generateFileName() {
        return "screenshot_" + System.currentTimeMillis();
    }
    static String generateRandomEmail() {
        String[] domains = {"gmail.com", "yahoo.com", "hotmail.com", "example.com"};
        Random random = new Random();
        String randomDomain = domains[random.nextInt(domains.length)];
        return "user" + System.currentTimeMillis() + "@" + randomDomain;
    }

    public static String generateRandomFirstName() {
        Random random = new Random();
        String firstName = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
        return firstName;
    }

    public static String generateRandomLastName() {
        Random random = new Random();
        String lastName = LAST_NAMES[random.nextInt(LAST_NAMES.length)];
        return lastName;
    }

    public static String generateRandomPassword() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_-+=<>?";

        StringBuilder password = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(characters.length());
            password.append(characters.charAt(index));
        }
        return password.toString();
    }

    public static String generateRandomMobileNumber() {
        Random rand = new Random();
        StringBuilder mobileNumber = new StringBuilder();
        mobileNumber.append(rand.nextInt(3) + 7); // Start with 7, 8, or 9

        for (int i = 0; i < 9; i++) {
            mobileNumber.append(rand.nextInt(10)); // Append 9 more random digits
        }
        return mobileNumber.toString();
    }
}
