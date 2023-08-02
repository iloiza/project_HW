package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.CoursePage;

import java.util.List;

public class CourseCardComponent extends AbsComponents{
    public CourseCardComponent (WebDriver driver) {
        super(driver);
    }
@FindBy (xpath = "//main//section//h6/child::div")
    List<WebElement> coursesNames;
    public String getCoursesNamesByIndex(int index){
    return coursesNames.get(--index).getText();
    }


    public CoursePage clickCourseByName(String name){
        String locator = String
                .format("//main//section//h6/child::div[contains(text(),'%s')]", name);
        $(locator).click();
        return new CoursePage(driver);
    }
}
