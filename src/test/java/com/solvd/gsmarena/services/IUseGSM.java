package com.solvd.gsmarena.services;

import com.solvd.gsmarena.SignUpPage;
import com.solvd.gsmarena.HomePage;
import org.openqa.selenium.WebDriver;

public interface IUseGSM {

    default SignUpPage goToSignUp(WebDriver driver) {
        HomePage homePage = new HomePage(driver);
        SignUpPage signUpPage = homePage.clickSignUpButton();
        return new SignUpPage(driver);
    }

    default SignUpPage goToLogIn(WebDriver driver) {
        HomePage homePage = new HomePage(driver);
        SignUpPage signUpPage = homePage.clickLogInButton();
        return new SignUpPage(driver);
    }

    default SignUpPage goToSearch(WebDriver driver) {
        HomePage homePage = new HomePage(driver);
        SignUpPage signUpPage = homePage.clickSearchButton();
        signUpPage.searchVague("samsung");
        return new SignUpPage(driver);
    }

    default SignUpPage goToSpecificSearch(WebDriver driver) {
        HomePage homePage = new HomePage(driver);
        SignUpPage signUpPage = homePage.clickSearchButton();
        signUpPage.searchSpecific("samsung a72");
        return new SignUpPage(driver);
    }

    default SignUpPage goToCreateAccount(WebDriver driver) {
        SignUpPage signUpPage = goToSignUp(driver);
        signUpPage.setNickNameField("testing404123");
        signUpPage.setEmailField("agoncalves@solvd.com");
        signUpPage.setPasswordField("sospechoso9449");
        signUpPage.clickAgreeButton1();
        signUpPage.clickAgreeButton2();
        signUpPage.clickSubmitButton();
        return new SignUpPage(driver);
    }

    default SignUpPage goToCreateAccountInvalidEmail(WebDriver driver) {
        SignUpPage signUpPage = goToSignUp(driver);
        signUpPage.setNickNameField("testing4041234");
        signUpPage.setEmailField("bipelbopel");
        signUpPage.setPasswordField("sospechoso9339");
        signUpPage.clickAgreeButton1();
        signUpPage.clickAgreeButton2();
        return new SignUpPage(driver);
    }

    default SignUpPage goToCreateAccountEmptyName(WebDriver driver) {
        SignUpPage signUpPage = goToSignUp(driver);
        signUpPage.setEmailField("bipelbopel@hotmail.com");
        signUpPage.setPasswordField("sospechoso9449");
        signUpPage.clickAgreeButton1();
        signUpPage.clickAgreeButton2();
        signUpPage.clickSubmitButton();
        return new SignUpPage(driver);
    }

    default SignUpPage goToCreateAccountEmptyEmail(WebDriver driver) {
        SignUpPage signUpPage = goToSignUp(driver);
        signUpPage.setNickNameField("testing4041234");
        signUpPage.setPasswordField("sospechoso9449");
        signUpPage.clickAgreeButton1();
        signUpPage.clickAgreeButton2();
        return new SignUpPage(driver);
    }

    default SignUpPage goToCreateAccountConditionsRequired(WebDriver driver) {
        SignUpPage signUpPage = goToSignUp(driver);
        signUpPage.setNickNameField("testing4041234");
        signUpPage.setEmailField("bipelbopel@gmail.com");
        signUpPage.setPasswordField("sospechoso9339");
        return new SignUpPage(driver);
    }

    default SignUpPage goToLoginVerify(WebDriver driver) {
        SignUpPage signUpPage = goToLogIn(driver);
        signUpPage.setLoginEmailField("agoncalves@solvd.com");
        signUpPage.setLoginPasswordField("sospechoso9449");
        signUpPage.clickConfirmLoginButton();
        return new SignUpPage(driver);
    }

    default  SignUpPage goToLoginInvalidEmailPasswordCombination(WebDriver driver) {
        SignUpPage signUpPage = goToLogIn(driver);
        signUpPage.setLoginEmailField("bipelbopel@hotmail.com");
        signUpPage.setLoginPasswordField("slipknotunamasa444");
        signUpPage.clickConfirmLoginButton();
        return new SignUpPage(driver);
    }

    default SignUpPage goToLoginEmptyEmail(WebDriver driver) {
        SignUpPage signUpPage = goToLogIn(driver);
        signUpPage.setLoginPasswordField("slipknotunamasa444");
        signUpPage.clickConfirmLoginButton();
        return new SignUpPage(driver);
    }

    default SignUpPage goToLoginEmptyPassword(WebDriver driver) {
        SignUpPage signUpPage = goToLogIn(driver);
        signUpPage.setLoginEmailField("bipelbopel@hotmail.com");
        signUpPage.clickConfirmLoginButton();
        return new SignUpPage(driver);
    }





}
