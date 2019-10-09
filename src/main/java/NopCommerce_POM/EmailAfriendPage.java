package NopCommerce_POM;

import org.openqa.selenium.By;
import org.testng.Assert;

public class EmailAfriendPage extends Utils {

    LoadProperties props = new LoadProperties();
    private By _friendsEmail = By.xpath("//input[@class='friend-email']");
    private By _messageBox = By.id("PersonalMessage");
    private By _sendEmailButton = By.xpath("//input[@value='Send email']");
    private By _confimationMsg= By.xpath("//div[@class='result']");
    private By _errorMsg=By.xpath("//span[@id='YourEmailAddress-error']");
    public void verifyUrl() {
        validateUrl(props.getProperty("email_a_friend"));
    }


    public void fillEmailDetails() {
     enterText(_friendsEmail,props.getProperty("friend_email"));//entering friend's email
     enterText(_messageBox,props.getProperty("email_msg"));// entering message

    }

    public void validatingConfirmationMsg(){
       String actual_msg= getTextFromElement(_confimationMsg);
        Assert.assertEquals(actual_msg,props.getProperty("email_confirm_msg"),"Email not sent");

    }
    public void clickingOnSendEmailButton(){
        clickElement(_sendEmailButton);// clicking on send email button

    }
    public void validatingErrorMsg(){
        String actual_error_msg=getTextFromElement(_errorMsg);
        Assert.assertEquals(actual_error_msg,props.getProperty("expected_error_msg"),"Non Registered is able to refer product to a friend via  email");
    }
}
