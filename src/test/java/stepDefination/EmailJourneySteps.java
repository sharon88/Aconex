package stepDefination;

import Interactions.EmailFields;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.EmailConfirmationPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import utils.Base;
import utils.Common;

import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static utils.WebStrings.*;

public class EmailJourneySteps {

    private WebDriver driver;
    private HomePage homePage;
    private Common common;
    private Base base;

    private String toField;
    private String userdetails;

    public EmailJourneySteps() {
        base = new Base();
        driver = base.getDriver();
        common = new Common(driver);
    }


    @Given("^I launch the url in the browser$")
    public void i_launch_the_url_in_the_browser() throws IOException {
        driver.get(base.getPropertyValue("url"));
    }

    @When("^I login to the url with (.*) and (.*)$")
    public void i_login_to_the_url_with_and(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getEmailId().sendKeys(username);
        loginPage.getPassword().sendKeys(password);
        loginPage.getLoginButton().click();
        homePage = new HomePage(driver);
        common.waitForTheElementTobeDisplayed(homePage.getOrgDetailsLocator());
        homePage.getOrgDetailsLocator().isDisplayed();
        homePage.getUserAvatarLocator().isDisplayed();
        homePage.getUserDetailsLocator().isDisplayed();
        userdetails = homePage.getUserDetailsLocator().getText() + " - " + homePage.getOrgDetailsLocator().getText();
    }

    @And("^I navigate to blank mail option from mail nav bar$")
    public void iNavigateToBlankMailOptionFromMailNavBar() {
        homePage.getEmailNavbar().click();
        homePage.getBlankEmail().click();
    }


    @When("^I enter the necessary fields and send the mail$")
    public void iEnterTheNecessaryFieldsAndSendTheMail() throws InterruptedException {
        EmailFields emailFields = new EmailFields(driver);
        emailFields.selectEmailType(EMAIL_TYPE);
        toField = emailFields.selectToField();
        emailFields.setSubject(EMAIL_TYPE);
        emailFields.selectAttributes();
        emailFields.sendEmail();
    }

    @Then("^I verify the email is sent successfully$")
    public void iVerifyTheEmailIsSentSuccessfully() {
        EmailConfirmationPage emailConfirmationPage = new EmailConfirmationPage(driver);
        common.waitForTheElementTobeDisplayed(emailConfirmationPage.getMailTypeLabel());
        assertEquals(emailConfirmationPage.getMailTypeLabel().getText(), MAIL_TYPE_LABEL);
        assertEquals(emailConfirmationPage.getMailNumberLabel().getText(), MAIL_NUMBER_LABEL);
        assertEquals(emailConfirmationPage.getReferenceNumberLabel().getText(), REFERENCE_NUMBER_LABEL);
        assertTrue(emailConfirmationPage.getMailTypeValue().isDisplayed());
        assertEquals(emailConfirmationPage.getMailTypeValue().getText(), EMAIL_TYPE);
        assertTrue(emailConfirmationPage.getMailNumberValue().isDisplayed());
        assertTrue(emailConfirmationPage.getReferenceNumberValue().isDisplayed());
        assertTrue(emailConfirmationPage.getSenderValue().isDisplayed());
        assertEquals(emailConfirmationPage.getSenderValue().getText(), userdetails);
        assertTrue(emailConfirmationPage.getRecipientsValue().isDisplayed());
        assertEquals(emailConfirmationPage.getRecipientsValue().getText(), toField);
        assertTrue(emailConfirmationPage.getSubjectValue().isDisplayed());
        assertEquals(emailConfirmationPage.getSubjectValue().getText(), EMAIL_TYPE);
    }
}
