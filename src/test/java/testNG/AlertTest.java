package testNG;

import Driver.BaseClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AlertTest extends BaseClass {

    @Test(priority = 1)
    public void handleAlerts(){
        WebDriverWait wait = new WebDriverWait(driver, 60);
        //CalendarPage calendarPage = new CalendarPage();
        //calendarPage.isAlertPresent();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert();
        alert.dismiss();
    }
}
