import components.CourseCardComponent;
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
import pageobjects.CoursePage;
import pageobjects.MainPage;
import pageobjects.ChoosingCoursePage;

import java.util.List;


public class PageHeaders_Test {
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
    public void checkHeadersOnCoursePage() throws InterruptedException{
        String [] titlesText = {"Для кого этот курс?", "Необходимые знания"};
        new MainPage(driver).open();
        new StudyAreasMenuComponent(driver).clickAreasOfStudy(StudyAreasData.TESTING, 1);
        Thread.sleep(5000);
        new ChoosingCoursePage(driver).checkOpenedPageOfCourse(StudyAreasData.TESTING);
        CourseCardComponent courseCardComponent = new CourseCardComponent(driver);
        String courseName = courseCardComponent.getCoursesNamesByIndex(2);
        courseCardComponent.clickCourseByName(courseName);
        new CoursePage(driver).checkCoursePageHeader(courseName);
        new CoursePage(driver).checkCourseInformation();
        new CoursePage(driver).checkCourseDescription(titlesText);
    }
}
