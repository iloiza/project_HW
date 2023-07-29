import exceptions.DriverNotSupported;
import factory.DriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pageobjects.EventsPage;
import pageobjects.MainPage;

public class Date_Test {
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
    public void checkEventDate () {
        String buttonName = "Мероприятия";
        String title = "Календарь мероприятий";

        new MainPage(driver).open();
        new MainPage(driver).clickButtonByName(buttonName);
        new EventsPage(driver).checkOpenedEventsPage(title);
        new EventsPage(driver).checkEventsDateByIndex(2);
    }
}
