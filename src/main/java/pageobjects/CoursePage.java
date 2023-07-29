package pageobjects;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CoursePage extends AbsBasePage {

    public CoursePage (WebDriver driver) {
        super(driver, "");
    }

    public CoursePage (WebDriver driver, String courseName) {
        super(driver, String.format("%s", courseName));
    }

    private String courseNameHeaderLocatorTemplate = "//section//h1[text()= '%s']";

    private String courseInformationLocator = "//section/div[3]"; //section/div[3]//p

    private String courseDescriptionLocator = "//main/div/div[1]/div";
    //private String courseDescriptionLocator2 = "//main/div/div[2]/div";
    public CoursePage checkCoursePageHeader(String name){
        String locator = String.format(courseNameHeaderLocatorTemplate, name);
        assertThat($(locator).getText())
                .as("Course page header should be {}", name)
                .isEqualTo(name);
        return this;
    }
    public CoursePage checkCourseInformation (){
        String info = $(courseInformationLocator).getAttribute("InnerText");
        if (info != "");
        return this;
    }
    public CoursePage checkCourseDescription (String [] titlesText){
      assertThat($(courseDescriptionLocator).getText())
              .as("Course description should be contains the headers: {}")
              .contains(titlesText);
      return this;
    }
}
