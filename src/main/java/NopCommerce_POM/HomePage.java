package NopCommerce_POM;

import org.openqa.selenium.By;

public class HomePage extends Utils {

    LoadProperties props = new LoadProperties();

    private By _registerbutton= By.xpath("//a[@class='ico-register']");
    private By _imacProImage=By.xpath("//img[@title='Show details for Apple MacBook Pro 13-inch']");
    private By _htcOneM8Phone=By.xpath("//a[contains(text(),'HTC One M8 Android L 5.0 Lollipop')]");

   public void clickOnRegisterButton(){
       //
       clickElement(_registerbutton);
   }
   public void verifyUrl(){
       validateUrl(props.getProperty("expectedUrl"));

   }
   public void validateTitle(){
       verifytittle(props.getProperty("expected_tittle"));
   }

   public void clickOnImacPro(){
       clickElement(_imacProImage);

   }
   public void clickOnHtcOneMobilePhone(){

       clickElement(_htcOneM8Phone);
   }


}
