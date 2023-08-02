package components;

import data.StudyAreasData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.List;

public class StudyAreasMenuComponent extends AbsComponents {
    public StudyAreasMenuComponent(WebDriver driver) {
        super(driver);
    }

    public String locatorClickAreasOfStudyTemplate = "//div[contains(text(),'%s')]";

    public void clickAreasOfStudy(StudyAreasData studyAreasData, int index){
        String locatorForAreasOfStudy = String.format(locatorClickAreasOfStudyTemplate, studyAreasData.getName());
        List<WebElement> elementsInAreasOfStudy = driver.findElements(By.xpath(locatorForAreasOfStudy));
        elementsInAreasOfStudy.get(--index).click();

    }
}
