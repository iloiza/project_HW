import exceptions.DriverNotSupported;
import factory.DriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pageobjects.EventsPage;
import pageobjects.MainPage;

public class EventsType_Test {
    private static DriverFactory driverFactory;

    @BeforeAll
    public static void init() {
        driverFactory = new DriverFactory();
    }

    private WebDriver driver;

    @BeforeEach
    public void initDriver() throws DriverNotSupported {
        driver = new DriverFactory().create();
    }

    @AfterEach
    public void after() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

    @Test
    public void checkDODEvents() throws InterruptedException{
        String buttonName = "Мероприятия";
        String title = "Календарь мероприятий";
        String eventsFilterButtonName = "ДОД";
        String filteredEventsCardText = "День открытых дверей";
        String noEventsTextMassage = "К сожалению, подходящих мероприятий не найдено.";

        new MainPage(driver).open();
        new MainPage(driver).clickButtonByName(buttonName);
        new EventsPage(driver).checkOpenedEventsPage(title);
        //Thread.sleep(10000);
        //new EventsPage(driver).$("//header//div[2]/div/following-sibling::div[@class='dod_new-events-dropdown__list js-dod_new_events-dropdown']").click();//header//div[2]//span/parent::div[@class = 'dod_new-events-dropdown__input']").click();
        new EventsPage(driver).choseAndCheckEventsFilterByName(eventsFilterButtonName);
        new EventsPage(driver).checkFilteredEventsCards(filteredEventsCardText, noEventsTextMassage);
        //header//div[2]/div/following-sibling::div[@class='dod_new-events-dropdown__list js-dod_new_events-dropdown']

    }
}
