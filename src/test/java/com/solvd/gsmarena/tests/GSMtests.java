package com.solvd.gsmarena.tests;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.gsmarena.SignUpPage;
import com.solvd.gsmarena.services.IUseGSM;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class GSMtests implements IAbstractTest, IUseGSM {

    @Test
    public void verifyHomePageWorkflow() {
        SignUpPage signUpPage = goToSignUp(getDriver());
        assertEquals(signUpPage.getCreateAccountText(), "Create account", "FATAL!, Not same");
    }

    @Test
    public void signUpUser() {
        SignUpPage signUpPage = goToCreateAccount(getDriver());
        assertEquals(signUpPage.getWelcomeText(), "Your account was created.", "FATAL!, Not same");
    }

    @Test
    public void signUpUserInvalidEmail() {
        SignUpPage signUpPage = goToCreateAccountInvalidEmail(getDriver());
        assertFalse(signUpPage.isSubmitButtonClickable());
    }

    @Test
    public void signUpUserEmptyName() {
        SignUpPage signUpPage = goToCreateAccountEmptyName(getDriver());
        assertEquals(signUpPage.getEmptyNameText(), "Reason: Your nickname should have between 2 and 20 symbols.", "FATAL!, Not same");
    }

    @Test
    public void signUpUserEmptyEmail() {
        SignUpPage signUpPage = goToCreateAccountEmptyEmail(getDriver());
        assertFalse(signUpPage.isSubmitButtonClickable());
    }

    @Test
    public void signUpUserConditionsRequired() {
        SignUpPage signUpPage = goToCreateAccountConditionsRequired(getDriver());
        assertFalse(signUpPage.isSubmitButtonClickable());
    }

    @Test
    public void logInUserVerifySuccessfulLogIn() {
        SignUpPage signUpPage = goToLoginVerify(getDriver());
        assertTrue(signUpPage.isLogOutButtonPresent());
    }

    @Test
    public void logInUserInvalidEmailPasswordCombination() {
        SignUpPage signUpPage = goToLoginInvalidEmailPasswordCombination(getDriver());
        assertEquals(signUpPage.getLoginFailedText(), "Reason: User record not found.", "FATAL!, Not same.");
    }

    @Test
    public void logInUserEmptyEmail() {
        SignUpPage signUpPage = goToLoginEmptyEmail(getDriver());
        assertFalse(signUpPage.isLogOutButtonPresent());
    }

    @Test
    public void logInUserEmptyPassword() {
        SignUpPage signUpPage = goToLoginEmptyPassword(getDriver());
        assertFalse(signUpPage.isLogOutButtonPresent());
    }

    @Test
    public void goToSearchIndefinite() {
        SignUpPage signUpPage = goToSearch(getDriver());
        assertEquals(signUpPage.getSearchResultText(), "Search results for \"samsung\"", "FATAL!, Not same.");
    }

    @Test
    public void goToSpecificSearch() {
     SignUpPage signUpPage = goToSpecificSearch(getDriver());
     assertEquals(signUpPage.getSpecificSearchResultText(), "Samsung Galaxy A72", "FATAL!, Not same.");
    }
}
