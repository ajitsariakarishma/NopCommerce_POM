package NopCommerce_POM;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserSelector extends Utils{
    LoadProperties props = new LoadProperties();

    public void setUpBrowser(){
        //Storing the value of browser from config file in a String Variable
        String browser = props.getProperty("browser");
        if(browser.equalsIgnoreCase("chrome")){

            //setting system properties to launch chrome browser
            System.setProperty("webdriver.chrome.driver", "src\\test\\java\\Resources\\WebBrowsers\\chromedriver.exe");

            //open the browser

            ChromeOptions options = new ChromeOptions();
           // options.addArguments("disable-infobars");
           // options.addArguments("--disable-extensions");
            //options.addArguments("--disable-setUpBrowser-side-navigation");
            //options.addArguments("--incognito");
           // options.addArguments("--disable-blink-features=BlockCredentialedSubresources");
           // driver = new ChromeDriver(options);
            driver = new ChromeDriver();



        }else if(browser.equalsIgnoreCase("firefox")){
             System.setProperty("webdriver.gecko.driver", "src\\test\\java\\Resources\\WebBrowsers\\geckodriver.exe");
             driver=new FirefoxDriver();

        }else{

            System.out.println("Browser name is either empty or typed wrong :"+browser);

        }



    }













}