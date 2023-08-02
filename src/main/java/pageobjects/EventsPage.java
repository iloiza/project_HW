package pageobjects;
import static org.assertj.core.api.Assertions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

public class EventsPage extends AbsBasePage {
    public EventsPage(WebDriver driver) {
        super(driver, "");
    }

    @FindBy(css = ".dod_new-event")
    List<WebElement> listOfEvents;
    private String eventsPageHeaderLocator = "//div[@class='dod_new-header__title']";//div[contains(text(),'Календарь мероприятий')]";

    public boolean checkOpenedEventsPage(String title) {
        String headerName = $(eventsPageHeaderLocator).getText();
        assertThat(headerName).
                as("The header should be {}")
                .isEqualTo(title);
        int countOfVisibleEvents = listOfEvents.size();
        if (countOfVisibleEvents != 0) ;
        return false;
    }

    public void choseAndCheckEventsFilterByName(String name) {
        WebElement button = driver.findElement(By.xpath("//div[@class='dod_new-events__header-left']/div"));
        Actions actions = new Actions(driver);
        actions.moveToElement(button).click(button).perform();
        String eventsFilterButtonLocatorTemplate = "//div[@class='dod_new-events__header-left']/div//div/following-sibling::div/a[@title='%s']";
        String eventsFilterButtonName = $(String.format(eventsFilterButtonLocatorTemplate, name)).getText();
        $(String.format(eventsFilterButtonLocatorTemplate, name)).click();
        assertThat(eventsFilterButtonName)
                .as("The filter Should be {}")
                .isEqualTo(name);
    }

    @FindBy(css = ".dod_new-event")
    List<WebElement> filteredEventsList;

    @FindBy(css = ".dod_new-type__text")
    List<WebElement> filteredEventsTypeList;

    public boolean checkFilteredEventsCards(String filterName, String noEventsMassage) {
        if (!filteredEventsList.isEmpty()) {
            boolean expectedText = true;

            for (WebElement element : filteredEventsTypeList) {
                String elementText = element.getText();
                if (!elementText.equals(filterName)) {
                    System.out.println("Элемент содержит другой текст: " + elementText);
                    expectedText = false;
                }
            }

            return expectedText;
        } else {
            WebElement emptyEventsMessage = $(".dod_new-events__empty-message");

            if (emptyEventsMessage != null && emptyEventsMessage.getText().equals(noEventsMassage)) {
                return true;
            } else {
                return false;
            }
        }
    }


    @FindBy(xpath = "//span[contains(@class, 'dod_new-event__calendar-icon')]/following-sibling::span")
    List<WebElement> eventsDatesList;

    public boolean checkEventsDateByIndex(int index) {
        String eventsDate = eventsDatesList.get(--index).getText();
        int currentYear = LocalDate.now().getYear();
        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("d MMMM yyyy", new Locale("ru"));
        LocalDate date = LocalDate.parse(eventsDate + " " + currentYear, formatter);
        LocalDate currentDate = LocalDate.now();
        return date.compareTo(currentDate) >= 0;
    }
}
