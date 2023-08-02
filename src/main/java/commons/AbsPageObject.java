package commons;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public abstract class AbsPageObject {
    protected WebDriver driver;

    public AbsPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement $(By locator) {
        return driver.findElement(locator);
    }

    public WebElement $(String xpathCssSelector) {
        if (xpathCssSelector.startsWith("/")) {
            return $(By.xpath(xpathCssSelector));
        } else {
            return $(By.cssSelector(xpathCssSelector));
        }
    }
}
