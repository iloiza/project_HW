package pageobjects;

import data.StudyAreasData;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waiters.Waiters;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class ChoosingCoursePage extends AbsBasePage {
    private static final String PATH = "/";

    public ChoosingCoursePage(WebDriver driver) {
        super(driver, PATH);
    }

    public String locatorCheckOpenedPageOfCourseTemplate = "//label[contains(text(),'%s')]/ancestor::div[@value='true']";

    public void checkOpenedPageOfCourse(StudyAreasData studyAreasData) {
        new Waiters(driver).waitForCondition(presenceOfElementLocated(By
                        .xpath("//div[contains(text(), 'Каталог')]/ancestor::section")));
        String locatorCheckOpenedPageOfCourse = String
                .format(locatorCheckOpenedPageOfCourseTemplate, studyAreasData.getName());
        Assertions.assertEquals("true", $(By.xpath(locatorCheckOpenedPageOfCourse)).getAttribute("value"));
    }

    @FindBy(xpath = "//main/descendant::section/descendant::a[@href]")
    private List<WebElement> coursesNames;

    public Integer checkCountOfCourses(int count) {
        int countOfCourses = coursesNames.size();
        Assertions.assertEquals(count, countOfCourses);
        return countOfCourses;
    }

}
