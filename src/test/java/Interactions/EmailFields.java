package Interactions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import pageObjects.BlankEmailPage;
import utils.Common;

import static org.testng.Assert.assertEquals;

public class EmailFields {
    private BlankEmailPage emailPage;
    private WebDriver driver;
    private Common common;
    private String firstAttributeSelected;
    private String secondAttributeSelected;

    private static final String GIVEN_NAME = "Kenton";
    private static final String FAMILY_NAME = "Tillman";

    public EmailFields(WebDriver driver) {
        this.driver = driver;
        emailPage = new BlankEmailPage(driver);
        common = new Common(driver);
    }

    public void selectEmailType(String emailTypeValue) {
        waitForToLoaderToBeDismissed();
        common.switchToIFrame();
        Select type = new Select(emailPage.getDropDown());
        type.selectByVisibleText(emailTypeValue);
    }

    public String selectToField() throws InterruptedException {
        selectDirectoryToField();
        selectGlobal();
        enterGivenFamilyName();
        selectCheckBox();
        addToField();
        String toAddressActual = emailPage.getRecipientsAddressDirectory().getText();
        selectOk();
        assertEquals(toAddressActual, emailPage.getRecipientsToAddress().getText());
        return toAddressActual;
    }

    public void setSubject(String subject) {
        common.waitForTheElementTobeClickable(emailPage.getSubject());
        emailPage.getSubject().sendKeys(subject);
    }

    public void sendEmail() {
        emailPage.getSendEmailButton().click();
    }

    public void selectAttributes() {
        if (common.checkIfElementDisplayed(emailPage.getAttributeFirstMultiSelect())) {
            emailPage.getAttributeFirstMultiSelect().click();
            common.waitForTheElementTobeDisplayed(emailPage.getAttributeOkButton());
            selectPrimaryAttribute();
            selectSecondaryAttribute();
            emailPage.getAttributeOkButton().click();
            assertEquals(emailPage.getAttributeFirstMultiSelect().getText(), firstAttributeSelected);
            assertEquals(emailPage.getAttributeSecondMultiSelect().getText(), secondAttributeSelected);
        }
    }

    private String selectPrimaryAttribute() {
        Select selectP = new Select(emailPage.getPrimaryAttributeSelectOption());
        selectP.selectByIndex(0);
        firstAttributeSelected = selectP.getFirstSelectedOption().getText();
        emailPage.getPrimaryAttributeAdd().click();
        String expected = emailPage.getPrimaryAttributeSelected().getText();
        assertEquals(firstAttributeSelected, expected);
        return expected;
    }

    private String selectSecondaryAttribute() {
        Select selectP = new Select(emailPage.getSecondaryAttributeSelectOption());
        selectP.selectByIndex(1);
        secondAttributeSelected = selectP.getFirstSelectedOption().getText();
        emailPage.getSecondaryAttributeAdd().click();
        String expected = emailPage.getSecondaryAttributeSelected().getText();
        assertEquals(secondAttributeSelected, expected);
        return secondAttributeSelected;
    }


    private void selectDirectoryToField() throws InterruptedException {
        common.waitForTheElementTobeClickable(emailPage.getDirectoryToField());
        Thread.sleep(2000);
        emailPage.getDirectoryToField().click();
        common.waitForTheElementTobeDisplayed(emailPage.getGlobalId());
    }

    private void selectGlobal() {
        emailPage.getGlobalId().click();
        emailPage.getGlobalId().isSelected();
    }

    private void enterGivenFamilyName() {
        emailPage.getGivenName().sendKeys(GIVEN_NAME);
        emailPage.getFamilyName().sendKeys(FAMILY_NAME);
        emailPage.getSearchButton().click();
    }

    private void selectCheckBox() {
        emailPage.getCheckBox().click();
    }

    private void addToField() {
        emailPage.getAddToField().click();
    }

    private void selectOk() {
        emailPage.getClickOnOk().click();
    }

    private void waitForToLoaderToBeDismissed() {
        try {
            common.waitForTheLoadingProgressTobeDismissed();
        } catch (UnhandledAlertException e) {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        }
    }


}
