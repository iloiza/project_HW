package components;

import commons.AbsPageObject;
import org.openqa.selenium.WebDriver;

public abstract class AbsComponents extends AbsPageObject {
    public AbsComponents(WebDriver driver){

        super(driver);
    }
}
