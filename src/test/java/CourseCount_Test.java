import components.StudyAreasMenuComponent;
import data.StudyAreasData;
import exceptions.DriverNotSupported;
import factory.DriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
    public void checkCourseCount() {
        new MainPage(driver).open();
        new StudyAreasMenuComponent(driver).clickAreasOfStudy(StudyAreasData.TESTING, 1);
        ChoosingCoursePage choosingCoursePage = new ChoosingCoursePage(driver);
        choosingCoursePage.checkOpenedPageOfCourse(StudyAreasData.TESTING);
        choosingCoursePage.clickButton(By
                .xpath("//button[contains(text(),'Показать еще')]"));
        new ChoosingCoursePage(driver).checkCountOfCourses(11);
    }

}
