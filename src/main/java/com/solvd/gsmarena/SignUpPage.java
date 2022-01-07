package com.solvd.gsmarena;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SignUpPage extends AbstractPage {

    @FindBy(xpath = "//i[@class='head-icon icon-user-plus']")
    private ExtendedWebElement signUpButton;

    @FindBy(xpath = "//h3[text() = 'Create account']")
    private ExtendedWebElement createAccountText;

    @FindBy(xpath = "//*[@id=\"uname\"]")
    private ExtendedWebElement nickNameField;

    @FindBy(xpath = "(//input[@name = 'sEmail'])[2]")
    private ExtendedWebElement emailField;

    @FindBy(xpath = "(//input[@name = 'sPassword'])[2]")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "//label[@for = 'iagree1']")
    private ExtendedWebElement agreeCheckbox1;

    @FindBy(xpath = "//label[@for = 'iagree2']")
    private ExtendedWebElement agreeCheckbox2;

    @FindBy(xpath = "//h3[contains(text(),'Your account was created.')]")
    private ExtendedWebElement welcomeText;

    @FindBy(xpath = "(//*[@id=\"nick-submit\"])[2]")
    private ExtendedWebElement submitButton;

    @FindBy(xpath = "//div[@class='normal-text res-error']//*[text()=\"Reason: Your nickname should have between 2 and 20 symbols.\"]")
    private ExtendedWebElement emptyNickNameText;

    @FindBy(xpath = "//i[@class='head-icon icon-login']")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//input[@class=\"button\" and @id=\"nick-submit\"]")
    private ExtendedWebElement confirmLoginButton;

    @FindBy(xpath = "(//input[@name = 'sEmail'])[1]")
    private ExtendedWebElement loginEmailField;

    @FindBy(xpath = "(//input[@name = 'sPassword'])[1]")
    private ExtendedWebElement loginPasswordField;

    @FindBy(xpath = "//i[@class=\"head-icon icon-signout\"]")
    private ExtendedWebElement logoutButton;

    @FindBy(xpath = "//div[@class=\"normal-text res-error\"]//*[text()=\"Reason: User record not found.\"]")
    private ExtendedWebElement logInFailedText;

    @FindBy(xpath = "//h1[@class='article-info-name' and contains (text() , 'Search results for')]")
    private ExtendedWebElement searchResultText;

    @FindBy(xpath = "//input[@type= \"text\" and @name= \"sSearch\"]")
    private ExtendedWebElement searchField;

    @FindBy(xpath = "(//span[ contains(text(), 'A72')])[2]")
    private ExtendedWebElement searchMenuResults;

    @FindBy(xpath = "//h1[@class=\"specs-phone-name-title\"]")
    private ExtendedWebElement specificSearchResult;

    public SignUpPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getCreateAccountText() {
        return createAccountText.getText();
    }

    public void setNickNameField(String nickName) {
        nickNameField.type(nickName);
    }

    public void setEmailField(String email) {
        emailField.type(email);
    }

    public void setPasswordField(String password) {
        passwordField.type(password);
    }

    public String getWelcomeText() {
        return welcomeText.getText();
    }

    public void clickAgreeButton1() {
        agreeCheckbox1.click();
    }

    public void clickAgreeButton2() {
        agreeCheckbox2.click();
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public boolean isSubmitButtonClickable() {
        return submitButton.isClickable();
    }

    public String getEmptyNameText() {
        return emptyNickNameText.getText();
    }

    public SignUpPage clickLogInButton() {
        loginButton.click();
        return new SignUpPage(driver);
    }

    public void setLoginEmailField(String email) {
        loginEmailField.type(email);
    }

    public void setLoginPasswordField(String password) {
        loginPasswordField.type(password);
    }

    public void clickConfirmLoginButton() {
        confirmLoginButton.click();
    }

    public boolean isLogOutButtonPresent() {
        return logoutButton.isElementPresent();
    }

    public String getLoginFailedText() {
        return logInFailedText.getText();
    }

    public String getSearchResultText() {
        return searchResultText.getText();
    }

    public String getSpecificSearchResultText() {
        return specificSearchResult.getText();
    }

    public void searchVague(String searchText) {
        searchField.type(searchText);
        searchField.sendKeys(Keys.ENTER);
    }

    public void searchSpecific(String searchText) {
        searchField.type(searchText);
        WebDriverWait w = new WebDriverWait(driver, 10);
        w.until(ExpectedConditions.visibilityOf(searchMenuResults.getElement()));
        searchMenuResults.click();
    }
}
