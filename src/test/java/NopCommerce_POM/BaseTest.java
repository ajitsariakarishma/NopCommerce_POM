package NopCommerce_POM;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BaseTest extends BasePage {

    BrowserSelector browserSelector = new BrowserSelector();
    LoadProperties props = new LoadProperties();
   // String timeStamp = new SimpleDateFormat("dd.MM.yy.HH.mm.ss").format(new Date());

    @BeforeMethod
    public void setUpBrowser(){

      browserSelector.setUpBrowser();

        //maximise the browser window screen
        driver.manage().window().fullscreen();

        //set implicity wait for driver object
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(props.getProperty("url"));
    }
    @AfterMethod
    public void teatDown(){

        driver.close();


    }

}
