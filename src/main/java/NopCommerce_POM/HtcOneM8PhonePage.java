package NopCommerce_POM;

import org.openqa.selenium.By;

public class HtcOneM8PhonePage extends Utils {

    LoadProperties props = new LoadProperties();


    private By _addToCartButton=By.xpath("//input[@id='add-to-cart-button-18']");
    private By _shoppingCartLink=By.xpath("//span[@class='cart-label']");

    public void verifyUrl() {
        validateUrl(props.getProperty("expected_htc_one_phone_url"));
    }
     public void clickAddToCartButton(){
        clickElement(_addToCartButton);
     }

     public void clickShoppingCartLink(){


        clickElement(_shoppingCartLink);


     }


}
