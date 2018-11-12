package PageObjectsImplementation;

import Config.ConfigReader;
import Config.MobileDriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.List;

public class HelperMethods {
    public AppiumDriver driver;
    //Logger logger = Logger.getLogger(CommonAppiumTest.class);

    public HelperMethods(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }
    public HelperMethods(){ }


    public void waitForPageToLoad(WebElement id) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(id));
    }

    public void waitForElementToDisAppear(String id) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(id)));
    }

    public void waitForElementToAppear(WebElement id) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(id));
    }

    public void waitForElementsToAppear(List<WebElement> id) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfAllElements(id));
    }

    public WebElement waitForElement(WebElement arg) {
        waitForPageToLoad(arg);
        WebElement el = arg;
        return el;
    }

    public void navigateBack(){
        MobileDriverContext.driver.navigate().back();
    }

    public static String takeScreenShot(String screenShotName) throws Exception {
        File file  = ((TakesScreenshot)MobileDriverContext.driver).getScreenshotAs(OutputType.FILE);
        String filePath = String.format("%s/target/output/%s.png", ConfigReader.workingDirectory,screenShotName);

        FileUtils.copyFile(file, new File(filePath));
        return filePath;
    }



    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }

    }
}
