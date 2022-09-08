package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoriesPage {

    protected  AppiumDriver driverAppium;
    @FindBy(xpath = "//android.widget.ImageView[@content-desc=\"More options\"]")
    public MobileElement categories;



    public void isLoaded(AppiumDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
        driverAppium =driver;
    }

    public String getUrl(){
        return  driverAppium.getCurrentUrl();
    }

    public void scrollAndClick(String visibleText) {
        driverAppium.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+visibleText+"\").instance(0))")).click();
    }
}

