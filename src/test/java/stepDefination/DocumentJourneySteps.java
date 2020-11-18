package stepDefination;

import Interactions.DocumentUploadFields;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.DocumentSearchPage;
import pageObjects.DocumentSuccessPage;
import pageObjects.HomePage;
import utils.Base;
import utils.Common;
import utils.Helper;

import java.awt.*;

import static org.testng.Assert.assertEquals;
import static utils.WebStrings.*;

public class DocumentJourneySteps {
    private WebDriver driver;
    private HomePage homePage;
    private Common common;
    private DocumentSuccessPage documentSuccessPage;
    private DocumentSearchPage documentSearchPage;
    private Base base;

    private String documentId;
    private String documentName;
    private String searchFileName;

    public DocumentJourneySteps() {
        base = new Base();
        driver = base.getDriver();
        common = new Common(driver);
    }


    @And("^I navigate to upload Document option from Document bar$")
    public void iNavigateToUploadDocumentOptionFromDocumentBar() {
        homePage = new HomePage(driver);
        homePage.getDocumentNavbar().click();
        homePage.getUploadDocument().click();
    }

    @When("^I enter all the necessary fields and upload the document$")
    public void iEnterAllTheNecessaryFieldsAndUploadTheDocument() throws InterruptedException, AWTException {
        DocumentUploadFields documentUploadFields = new DocumentUploadFields(driver);
        documentName = DOCUMENT_NAME + Helper.generateRandomNumber();
        documentUploadFields.enterTheRequiredDocumentFields(documentName);
        documentUploadFields.clickUploadButton();
    }

    @Then("I verify the document is uploaded")
    public void iVerifyTheDocumentIsUploaded() {
        documentSuccessPage = new DocumentSuccessPage(driver);
        common.waitForTheElementTobeDisplayed(documentSuccessPage.getSuccessPopUp());
        assertEquals(documentSuccessPage.getDocumentSuccessfulUploadMessage().getText(), DOCUMENT_UPLOAD_SUCCESSFUL_MESSAGE);
        String successString = documentSuccessPage.getDocumentSuccessfulUploadIdMessage().getText();
        String successMessage = successString.split(":")[0].trim();
        assertEquals(successMessage, DOCUMENT_ID_UPLOAD_SUCCESSFUL_MESSAGE);
        documentId = successString.split(":")[1].trim();
        documentSuccessPage.getClosePopUp().click();
    }

    @When("I search the document from document register")
    public void iSearchTheDocumentFromDocumentRegister() {
        driver.switchTo().defaultContent();
        homePage.getDocumentNavbar().click();
        homePage.getDocumentRegister().click();
        common.waitForTheLoadingProgressTobeDismissed();
        documentSearchPage = new DocumentSearchPage(driver);
        common.switchToIFrame();
        common.waitForTheElementTobeDisplayed(documentSearchPage.getSearchBox());
        assertEquals(documentSearchPage.getHeader().getText(), DOCUMENT_REGISTER_HEADER);
        documentSearchPage.getSearchBox().clear();
        documentSearchPage.getSearchBox().sendKeys(documentName);
        documentSearchPage.getSearchButton().click();
    }

    @Then("^I save the search$")
    public void iSaveTheSearch() {
        documentSearchPage.getSaveSearchButton().click();
        common.waitForTheElementTobeDisplayed(documentSearchPage.getModal());
        searchFileName = DOCUMENT_SAVE_TEXT + Helper.generateRandomNumber();
        documentSearchPage.getNameField().sendKeys(searchFileName);
        documentSearchPage.getSaveButton().click();
    }

    @Then("I display the search text and document id")
    public void iDisplayTheSearchTextAndDocumentId() {
        documentSearchPage.getSavedSearchButton().click();
        documentSearchPage.getSavedSearchEditText().sendKeys(searchFileName);
        documentSearchPage.getSavedSearchList().click();
        common.waitForTheElementTobeDisplayed(documentSearchPage.getSearchBox());
        common.waitForTheElementTobeDisplayed(documentSearchPage.getDocumentId());
        assertEquals(documentSearchPage.getDocumentName().getText(), documentName);
        assertEquals(documentSearchPage.getDocumentId().getText(), documentId);
    }
}
