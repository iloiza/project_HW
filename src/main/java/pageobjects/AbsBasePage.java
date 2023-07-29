package pageobjects;

import commons.AbsPageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbsBasePage extends AbsPageObject {
    private static final String BASE_URL = System.getProperty("base.url", "https://otus.ru");//, "https://otus.ru");
    protected WebDriver driver;
    private String path;

    public AbsBasePage(WebDriver driver, String path) {
        super(driver);
        this.driver = driver;
        if (!path.startsWith("/")){
            path = "/" + path;
        }
        this.path = path;


    }

    public void open() {

        driver.get(BASE_URL + path);
        WebDriverWait waiting = new WebDriverWait(driver, Duration.ofSeconds(10));
        waiting.until(driver -> true);
    }
    public void clickButton (By by){

        driver.findElement(by).click();
    }

}
