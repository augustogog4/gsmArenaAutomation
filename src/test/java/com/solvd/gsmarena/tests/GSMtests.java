package com.solvd.gsmarena.tests;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.gsmarena.SignUpPage;
import com.solvd.gsmarena.services.IUseGSM;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GSMtests implements IAbstractTest, IUseGSM {

    @Test
    public void verifyHomePageWorkflow(){
        SignUpPage signUpPage = goToSignUp(getDriver());
        assertEquals(signUpPage.getCreateAccountText(), "Create account", "FATAL!, Not same");
    }


}
