package com.solvd.gsmarena;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage extends AbstractPage {

    @FindBy(xpath = "//i[@class='head-icon icon-user-plus']")
    private ExtendedWebElement signUpButton;

    @FindBy(xpath = "//h3[text() = 'Create account']")
    private ExtendedWebElement createAccountText;

    @FindBy(xpath = "//*[@id=\"uname\"]")
    private ExtendedWebElement nickNameField;

    @FindBy(xpath = "//*[@id=\"email\"][2]")
    private ExtendedWebElement emailField;

    @FindBy(xpath = "(//input[@name = 'sPassword'])[2]")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "//label[@for = 'iagree1']")
    private ExtendedWebElement agreeCheckbox1;

    @FindBy(xpath = "//label[@for = 'iagree2']")
    private ExtendedWebElement agreeCheckbox2;

    public SignUpPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getCreateAccountText() {
        return createAccountText.getText();
    }

}
