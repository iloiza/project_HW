package components;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
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
//@FindBy (xpath = "//main//section//h6/following-sibling::div")
//List<WebElement> courseInfo;
//        public String getCoursesInfoByIndex(int index){
//            return courseInfo.get(--index).getText();
//        }

    public CoursePage clickCourseByName(String name){
        String locator = String
                .format("//main//section//h6/child::div[contains(text(),'%s')]", name);
        $(locator).click();
        return new CoursePage(driver);
    }
}
