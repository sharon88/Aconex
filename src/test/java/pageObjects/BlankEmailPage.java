package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlankEmailPage {

    private WebDriver driver;

    public BlankEmailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "frameMain")
    private WebElement emailFrame;

    @FindBy(id = "Correspondence_correspondenceTypeID")
    private WebElement typeDropDown;

    @FindBy(xpath = "//*[@id='heroSection']/tbody/tr[1]/td[3]/button/div/div")
    private WebElement directoryToField;

    @FindBy(id = "ACONEX_list")
    private WebElement globalId;

    @FindBy(id = "FIRST_NAME")
    private WebElement givenName;

    @FindBy(id = "LAST_NAME")
    private WebElement familyName;

    @FindBy(id = "btnSearch_page")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id='resultTable']/tbody/tr/td[2]/preceding-sibling::td/input[@type='checkbox']")
    private WebElement checkBox;

    @FindBy(id = "btnAddTo_page")
    private WebElement addToField;

    @FindBy(id = "btnOk")
    private WebElement clickOnOk;

    @FindBy(id = "Correspondence_subject")
    private WebElement subject;

    @FindBy(id = "btnSend")
    private WebElement sendEmailBtn;

    @FindBy(id = "multiselect0")
    private WebElement attributeFirstMultiSelect;

    @FindBy(xpath = "//*[@id='attributeBidi_PRIMARY_ATTRIBUTE']/div[1]/select")
    private WebElement primaryAttributeSelectOption;

    @FindBy(id = "attributeBidi_PRIMARY_ATTRIBUTE_add")
    private WebElement primaryAttributeAdd;

    @FindBy(xpath = "//*[@id='attributeBidi_PRIMARY_ATTRIBUTE']/div[2]/select/option")
    private WebElement primaryAttributeSelected;

    @FindBy(xpath = "//*[@id='attributeBidi_SECONDARY_ATTRIBUTE']/div[1]/select")
    private WebElement secondaryAttributeSelectOption;

    @FindBy(id = "attributeBidi_SECONDARY_ATTRIBUTE_add")
    private WebElement secondaryAttributeAdd;

    @FindBy(xpath = "//*[@id='attributeBidi_SECONDARY_ATTRIBUTE']/div[2]/select/option")
    private WebElement secondaryAttributeSelected;

    @FindBy(id = "attributePanel-commit")
    private WebElement attributeOkButton;

    @FindBy(id = "multiselect1")
    private WebElement attributeSecondMultiSelect;

    @FindBy(xpath = "//*[@id='recipients']/table/tbody/tr[2]/td[2]")
    private WebElement recipientsAddressDirectory;

    @FindBy(xpath = "//*[@id='recipientList_TO']/tbody/tr[4]")
    private WebElement recipientsToAddress;

    @FindBy(css = "body.cke_editable.cke_editable_themed.cke_contents_ltr.cke_show_borders")
    private WebElement body;

    public WebElement getEmailFrame() {
        return emailFrame;
    }

    public WebElement getDropDown() {
        return typeDropDown;
    }

    public WebElement getDirectoryToField() {
        return directoryToField;
    }

    public WebElement getGlobalId() {
        return globalId;
    }

    public WebElement getGivenName() {
        return givenName;
    }

    public WebElement getFamilyName() {
        return familyName;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getCheckBox() {
        return checkBox;
    }

    public WebElement getAddToField() {
        return addToField;
    }

    public WebElement getClickOnOk() {
        return clickOnOk;
    }

    public WebElement getSubject() {
        return subject;
    }

    public WebElement getSendEmailButton() {
        return sendEmailBtn;
    }

    public WebElement getAttributeFirstMultiSelect() {
        return attributeFirstMultiSelect;
    }

    public WebElement getPrimaryAttributeSelectOption() {
        return primaryAttributeSelectOption;
    }

    public WebElement getPrimaryAttributeAdd() {
        return primaryAttributeAdd;
    }

    public WebElement getPrimaryAttributeSelected() {
        return primaryAttributeSelected;
    }

    public WebElement getSecondaryAttributeSelectOption() {
        return secondaryAttributeSelectOption;
    }

    public WebElement getSecondaryAttributeAdd() {
        return secondaryAttributeAdd;
    }

    public WebElement getSecondaryAttributeSelected() {
        return secondaryAttributeSelected;
    }

    public WebElement getAttributeOkButton() {
        return attributeOkButton;
    }

    public WebElement getAttributeSecondMultiSelect() {
        return attributeSecondMultiSelect;
    }

    public WebElement getRecipientsAddressDirectory() {
        return recipientsAddressDirectory;
    }

    public WebElement getRecipientsToAddress() {
        return recipientsToAddress;
    }

    public WebElement getBody() {
        return body;
    }
}
