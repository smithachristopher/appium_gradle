package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SportsPage {



    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat/android.widget.ImageButton")
    public MobileElement hamburger;
    protected AppiumDriver driverAppium;

    public void isLoaded(AppiumDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
        driverAppium =driver;
    }

    public String getUrl(){
        return  driverAppium.getCurrentUrl();
    }


    public boolean isAlertPresent() {
        try {
            WebDriverWait wait = new WebDriverWait(driverAppium, 60);
            wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("ALERT IS PRESENT !! ");
            return true;
        } catch (Exception e) {
            System.out.println("ALERT IS NOT PRESENT !! ");
            return false;
        }
    }

    public void mobileAlertHandle() {
        WebDriverWait wait = new WebDriverWait(driverAppium, 60);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driverAppium.switchTo().alert();
        alert.dismiss();
    }
}
