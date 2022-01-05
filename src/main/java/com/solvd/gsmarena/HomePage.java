package com.solvd.gsmarena;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends AbstractPage {

    public HomePage(WebDriver driver) {
        super(driver);
        open();
    }


    @FindBy(xpath = "//i[@class='head-icon icon-user-plus']")
    private ExtendedWebElement signUpButton;

    @FindBy(xpath = "//i[@class='head-icon icon-login']")
    private ExtendedWebElement loginButton;

    public SignUpPage clickSignUpButton(){
        WebDriverWait w = new WebDriverWait(driver, 4);
        w.until(ExpectedConditions.elementToBeClickable(signUpButton.getElement()));
        signUpButton.click();
        return new SignUpPage(driver);
    }

}
