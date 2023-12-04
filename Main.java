package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Student\\Desktop\\pts-2023-2024-master\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        driver.get("https://ais2.ukf.sk/ais/start.do");


        Thread.sleep(1000);

        WebElement cookiesButton = driver.findElement(By.xpath("//*[@id=\"accept-cookies\"]"));
        cookiesButton.click();

        driver.findElement(By.id("login")).click();
        driver.findElement(By.id("login")).sendKeys("login_halenar");
        driver.findElement(By.id("heslo")).sendKeys("heslo_halenar");
        driver.findElement(By.id("login-form-submit-btn")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".card-header > .ais-color")).click();
        {
            WebElement element = driver.findElement(By.cssSelector(".btn-group:nth-child(1) > .mat-mdc-tooltip-trigger:nth-child(3)"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        Thread.sleep(1000);
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Uloženie súboru
        FileUtils.copyFile(screenshot, new File("screenshot.png"));
        {
            WebElement element = driver.findElement(By.tagName("body"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element, 0, 0).perform();
        }
        driver.findElement(By.cssSelector(".ms-2")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".app-dropdown-menu > .app-dropdown-item > .action")).click();
        Thread.sleep(3000);
        driver.close();

        driver.quit();
    }
}