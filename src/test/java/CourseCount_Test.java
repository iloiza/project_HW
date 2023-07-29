import components.StudyAreasMenuComponent;
import data.StudyAreasData;
import exceptions.DriverNotSupported;
import factory.DriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageobjects.MainPage;
import pageobjects.ChoosingCoursePage;


public class CourseCount_Test {
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
    public void checkCourseCount() throws InterruptedException {
        new MainPage(driver).open();
        new StudyAreasMenuComponent(driver).clickAreasOfStudy(StudyAreasData.TESTING, 1);
        Thread.sleep(5000);
        new ChoosingCoursePage(driver).checkOpenedPageOfCourse(StudyAreasData.TESTING);
        new ChoosingCoursePage(driver).clickButton(By
                .xpath("//button[contains(text(),'Показать еще')]"));
        Thread.sleep(10000);
        new ChoosingCoursePage(driver).checkCountOfCourses(11);
    }

}
