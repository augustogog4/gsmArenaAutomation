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


}
