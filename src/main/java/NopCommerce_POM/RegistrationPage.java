package NopCommerce_POM;

import org.openqa.selenium.By;
import org.testng.Assert;

public class RegistrationPage extends Utils {

    LoadProperties props = new LoadProperties();
    private By _firstname = By.id("FirstName");
    private By _lastname = By.xpath("//input[@name='LastName']");
    private By _email = By.name("Email");
    private By _password = By.id("Password");
    private By _confirmpassword=By.xpath("//input[@name=\'ConfirmPassword']");
    private By _submitButton=By.xpath("//input[@type='submit' and @name='register-button']");
    private By _actualConfirmMsg=By.className("result");
    private By _commerceIcon=By.xpath("//img");

    public void verifyurl(){
        validateUrl(props.getProperty("expected_registerPage_url"));

    }
    public void enterAndValidatingRegistrationDetails(){
        enterText(_firstname,props.getProperty("Firstname"));// entering firstname
        enterText(_lastname,props.getProperty("Lastname"));//entering last name

        //entering email
        enterText(_email,props.getProperty("email_start") + randomDate() + props.getProperty("email_end"));
        enterText(By.id("Password"), props.getProperty("password"));//entering password
        enterText(By.xpath("//input[@name=\'ConfirmPassword']"), props.getProperty("password"));//entering confirm password
        clickElement(_submitButton);//clicking on submit button
        String actual_msg=getTextFromElement(_actualConfirmMsg);//getting the text of confirmation msg
         //
        Assert.assertEquals(actual_msg,props.getProperty("expected_registration_confirm_msg"),"Not Registered Successfully");



    }
    public void navigateToHomePage(){
        clickElement(_commerceIcon);// navigating to HomePage by clicking on nopCommerce logo


    }

}
