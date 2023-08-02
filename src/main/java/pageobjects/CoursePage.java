package pageobjects;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.*;

public class CoursePage extends AbsBasePage {

    public CoursePage (WebDriver driver) {
        super(driver, "");
    }

    public CoursePage (WebDriver driver, String courseName) {
        super(driver, String.format("%s", courseName));
    }

    private String courseNameHeaderLocatorTemplate = "//section//h1[text()= '%s']";

    private String courseInformationLocator = "//section/div[3]";

    private String courseDescriptionLocator = "//main/div/div[1]/div";

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
