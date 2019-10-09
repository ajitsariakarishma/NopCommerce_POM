package NopCommerce_POM;

import org.openqa.selenium.By;
import org.testng.Assert;

public class CheckoutPage extends Utils {
    LoadProperties props = new LoadProperties();

    private By _secondContinueButton = By.xpath("//input[@class='button-1 shipping-method-next-step-button']");
    private By _choosingCreditCardOption= By.xpath("//input[@type='radio' and @id='paymentmethod_1']");
    private By _thirdContinueButton=By.xpath("//input[@onclick='PaymentMethod.save()']");
    private By _CardHolderName=By.xpath("//input[@id='CardholderName']");
    private By _CardNumber=By.xpath("//input[@id='CardNumber']");
    private By _cardType=By.xpath("//select[@id='CreditCardType']");
    private By _expirymonth=By.xpath("//select[@id='ExpireMonth']");
    private By  _expiryyear=By.xpath("//select[@id='ExpireYear']");
    private By _cvvNumber=By.xpath("//input[@id='CardCode']");
    private By _forthcontinuebutton=By.xpath("//input[@class='button-1 payment-info-next-step-button']");
    private By _confirmButton=By.xpath("//input[@class='button-1 confirm-order-next-step-button']");
    private By _orderConfirmationMsg=By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]");
    private By _selectCountry=By.xpath("//select[@id='BillingNewAddress_CountryId']");
    private By _shippingCity=By.xpath("//input[@id='BillingNewAddress_City']");
    private By _adressline1=By.xpath("//input[@id='BillingNewAddress_Address1']");
    private By _zipcode=By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']");
    private By _phoneNumber=By.xpath("//input[@id='BillingNewAddress_PhoneNumber']");
    private By _continueButtonOnBillingAddressPage=By.xpath("//div[@id='billing-buttons-container']//input[@class='button-1 new-address-next-step-button']");
    private By _guest=By.xpath("//input[@class='button-1 checkout-as-guest-button']");
    private By _billingname=By.xpath("//input[@id='BillingNewAddress_FirstName']");
    private By _billinglastname=By.xpath("//input[@id='BillingNewAddress_LastName']");
    private By _billingemail = By.xpath("//input[@id='BillingNewAddress_Email']");



    public void verifyUrl() {
        validateUrl(props.getProperty("expected_checkoutPage_url"));
    }
    public void clickingAllContinueLinksAndFillingBillingAddress(){
        gettingTextOfSelectedOptionFromDropdownByValue(_selectCountry,props.getProperty("checkoutPageCountry"));
        enterText(_shippingCity,props.getProperty("city"));
        enterText(_adressline1,props.getProperty("address"));
        enterText(_zipcode,props.getProperty("zipcode"));
        enterText(_phoneNumber,props.getProperty("phoneno"));
        clickElement(_continueButtonOnBillingAddressPage);
        clickElement(_secondContinueButton);
        clickElement(_choosingCreditCardOption);
        clickElement(_thirdContinueButton);
    }

    public void fillCrediCardDetailsAndheckingOrderisProcessedSuccesfully(){
       gettingTextOfSelectedOptionFromDropdownByValue(_cardType,props.getProperty("cardtype"));
       enterText(_CardHolderName,props.getProperty("cardHolderName"));
       enterText(_CardNumber,props.getProperty("masteCardNo"));
       gettingTextOfSelectedOptionFromDropdownByValue(_expirymonth,props.getProperty("expirymonth"));
       gettingTextOfSelectedOptionFromDropdownByValue(_expiryyear,props.getProperty("expityyear"));
       enterText(_cvvNumber,props.getProperty("masterCardCVVno"));
       clickElement(_forthcontinuebutton);
        clickElement(_confirmButton);
        String actual_confirm_msg=getTextFromElement(_orderConfirmationMsg);
        Assert.assertEquals(actual_confirm_msg,props.getProperty("expec_order_confirm_msg"),"Order is not processed");

    }
    public void checkingOutAsGuest(){
        clickElement(_guest);
    }
    public void fillGuestForm(){
        enterText(_billingname,props.getProperty("billingname"));
        enterText(_billinglastname,props.getProperty("billingLastName"));
        enterText(_billingemail,props.getProperty("billingEmail"));

    }


}
