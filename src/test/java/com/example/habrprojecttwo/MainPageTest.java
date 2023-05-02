package com.example.habrprojecttwo;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class MainPageTest {
    private WebDriver driver;


    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        // Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.habr.com/");

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void sortCompanyName() {

        WebElement company = driver.findElement(By.xpath("//*[contains(text(), 'Компании')]"));
        company.click();

        WebElement nameUP = driver.findElement(By.xpath("//*[contains(text(), 'Название')]"));
        nameUP.click();

        WebElement nameDown = driver.findElement(By.xpath("//*[contains(text(), 'Название')]"));
        nameDown.click();

        assertTrue(driver.findElement(By.xpath("//*[contains(text(), 'Acer')]")).isDisplayed(), "Результат не найден");

    }


}
