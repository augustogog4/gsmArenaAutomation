package com.solvd.gsmarena;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    public HomePage(WebDriver driver) {
        super(driver);
        open();
    }


    @FindBy(xpath = "//i[@class='head-icon icon-user-plus']")
    private ExtendedWebElement signUpButton;

    @FindBy(xpath = "//i[@class='head-icon icon-login']")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//input[@type= \"text\" and @name= \"sSearch\"]")
    private ExtendedWebElement searchField;

    public SignUpPage clickSignUpButton(){
        signUpButton.click();
        return new SignUpPage(driver);
    }

    public SignUpPage clickLogInButton() {
        loginButton.click();
        return new SignUpPage(driver);
    }

    public SignUpPage clickSearchButton() {
        searchField.click();
        return new SignUpPage(driver);
    }

}
