package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DashboardPage {

    @FindBy(id="Categories")
    public MobileElement categories;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ImageView")
    public MobileElement stratergy;



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
            System.out.println("ALERT IS PRESENT ");
            return true;
        } catch (Exception e) {
            System.out.println("ALERT IS NOT PRESENT  ");
            return false;
        }
    }

    public void mobileAlertHandle() {
        while (isAlertPresent()){
            Alert alert = driverAppium.switchTo().alert();
            alert.dismiss();
        }

    }
}
