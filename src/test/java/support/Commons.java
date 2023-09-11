package support;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Commons extends Base {

    private By ackCheckBox = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.CheckBox");
    private By changeLogOkBtn = By.id("com.touchboarder.android.api.demos:id/buttonDefaultPositive");

    Utilities utils = new Utilities();

    public void closeChangeLogBanner(){

        utils.waitForElement(ackCheckBox, 5);

        WebElement checkBox = null;

        try {
            checkBox = utils.getElement(ackCheckBox);
        } catch (Exception e) {
            System.out.println("[!] Error parsing checkBox element.");
        }

        if (checkBox.isDisplayed()){
            checkBox.click();
            driver.findElement(changeLogOkBtn).click();
        }

    }
}
