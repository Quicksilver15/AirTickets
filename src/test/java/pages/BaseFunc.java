package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class BaseFunc {
    private WebDriver browser;

    public BaseFunc() {
        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        browser = new ChromeDriver();
        browser.manage().window().maximize();
    }

    public void goToPage(String url) {
        if (!url.contains("http://") && !url.contains("https://")) {
            url = "http://" + url;
        }
        browser.get(url);
    }

    public void selectFromDropDown(By locator, String value) {
        Select dropdown = new Select(browser.findElement(locator));
        dropdown.selectByVisibleText(value);
    }

    public WebElement getElement(By locator) {
        return browser.findElement(locator);
    }

    public void writeInTextField(WebElement element, String text) {
        element.sendKeys(text);
    }

}
