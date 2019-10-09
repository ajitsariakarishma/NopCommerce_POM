package NopCommerce_POM;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSuit extends BaseTest {
    HomePage homePage = new HomePage();
    RegistrationPage registrationPage = new RegistrationPage();
    MacProProductPage macProProductPage = new MacProProductPage();
    EmailAfriendPage emailAfriendPage = new EmailAfriendPage();
    HtcOneM8PhonePage htcOneM8PhonePage = new HtcOneM8PhonePage();
    AddToCartPage addToCartPage = new AddToCartPage();
    CheckoutPage checkoutPage = new CheckoutPage();

    @Test
    public void userShouldBeAbleToRegisterSuccesfully() {
        homePage.validateTitle();// gives homepage page title

        homePage.clickOnRegisterButton();// clicking register button on homepage
        registrationPage.verifyurl(); // verifying tthat user is navigated to registration page
        registrationPage.enterAndValidatingRegistrationDetails();//entering details in all compulsory fields
    }

    @Test
    public void registredUserShouldBeAbleToReferAProductToFriend() {
        userShouldBeAbleToRegisterSuccesfully();//registering the user
        registrationPage.navigateToHomePage();//navigating to homepage
        homePage.clickOnImacPro();//clicking on imac to refer it to a friend
        macProProductPage.verifyUrl();//confirming that user is navigated to  relevant product page
        macProProductPage.clickOnEmailAfriendButton();//clicking on email a friend
        emailAfriendPage.verifyUrl();//confirming the navigation to email a friend page
        emailAfriendPage.fillEmailDetails();// filling details and clicking on send email button
        emailAfriendPage.clickingOnSendEmailButton();//clicking on send email button
        emailAfriendPage.validatingConfirmationMsg();// confirming that email is successfully sent

    }

    @Test
    public void nonRegisteredUserShouldNotBeAbleToReferAProductToAFriendViaEmail(){

        homePage.clickOnImacPro();//clicking on imac pro
        macProProductPage.verifyUrl();//verifying that user is navigated to product page
        macProProductPage.clickOnEmailAfriendButton();//clicking on email button
        emailAfriendPage.verifyUrl();//confirming that user is navigated to email a friend page
        emailAfriendPage.fillEmailDetails();// filling friends email id and writing message
        emailAfriendPage.clickingOnSendEmailButton();//clicking send email button
        emailAfriendPage.validatingErrorMsg();//verifying error msg
    }

     @Test
    public void resgisteredUserShouldBeAbleToBuyTheProductSuccesfully(){

       userShouldBeAbleToRegisterSuccesfully();//registering user
         registrationPage.navigateToHomePage();//navigating to homepage
         homePage.clickOnHtcOneMobilePhone();//clicking on product to open product page
         htcOneM8PhonePage.verifyUrl();//verifying that user is navigated to product page
         htcOneM8PhonePage.clickAddToCartButton();//clicking on add to cart button
         htcOneM8PhonePage.clickShoppingCartLink();//clicking on shopping cart link
         addToCartPage.clickonTermsAndConditionsCheckboxAndCheckoutButton();
         checkoutPage.clickingAllContinueLinksAndFillingBillingAddress();
         checkoutPage.fillCrediCardDetailsAndheckingOrderisProcessedSuccesfully();

     }
      @Test
     public void guestUserShouldBeAbleToBuyAProduct(){
         homePage.clickOnHtcOneMobilePhone();//clicking on product to open product page
         htcOneM8PhonePage.verifyUrl();//verifying that user is navigated to product page
         htcOneM8PhonePage.clickAddToCartButton();//clicking on add to cart button
         htcOneM8PhonePage.clickShoppingCartLink();//clicking on shopping cart link
         addToCartPage.clickonTermsAndConditionsCheckboxAndCheckoutButton();
         checkoutPage.checkingOutAsGuest();
         checkoutPage.fillGuestForm();
         checkoutPage.clickingAllContinueLinksAndFillingBillingAddress();
         checkoutPage.fillCrediCardDetailsAndheckingOrderisProcessedSuccesfully();
      }
}



