package NopCommerce_POM;

import org.openqa.selenium.By;

public class MacProProductPage extends Utils {

    LoadProperties props = new LoadProperties();
    private By _emailAFriend = By.xpath("//input[@value='Email a friend']");


    public void verifyUrl() {
        validateUrl(props.getProperty("imacpro_url"));
    }
    public void clickOnEmailAfriendButton(){
        clickElement(_emailAFriend);


    }

}
