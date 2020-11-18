package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailConfirmationPage {

    private WebDriver driver;

    public EmailConfirmationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div[data-automation-id='mailHeader-type-label'")
    private WebElement mailTypeLabel;

    @FindBy(css = "span[ng-if='hasMailType()']")
    private WebElement mailTypeValue;

    @FindBy(css = "div[data-automation-id='mailHeader-number-label']")
    private WebElement mailNumberLabel;

    @FindBy(css = "div[data-automation-id='mailHeader-number-value']")
    private WebElement mailNumberValue;

    @FindBy(css = "div[data-automation-id='mailHeader-refNumber-label']")
    private WebElement referenceNumberLabel;

    @FindBy(css = "div[data-automation-id='mailHeader-refNumber-value']")
    private WebElement referenceNumberValue;

    @FindBy(css = "span[ng-if='hasSubject()']")
    private WebElement subjectValue;

    @FindBy(css = "user-name[user='mail.sender']")
    private WebElement senderValue;

    @FindBy(css = "mail-recipients[recipients='mail.toRecipients']")
    private WebElement recipientsValue;




    public WebElement getMailTypeLabel() {
        return mailTypeLabel;
    }

    public WebElement getMailTypeValue() {
        return mailTypeValue;
    }

    public WebElement getMailNumberLabel() {
        return mailNumberLabel;
    }

    public WebElement getMailNumberValue() {
        return mailNumberValue;
    }

    public WebElement getReferenceNumberLabel() {
        return referenceNumberLabel;
    }

    public WebElement getReferenceNumberValue() {
        return referenceNumberValue;
    }

    public WebElement getSubjectValue() {
        return subjectValue;
    }

    public WebElement getSenderValue() {
        return senderValue;
    }

    public WebElement getRecipientsValue() {
        return recipientsValue;
    }



}
