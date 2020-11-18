package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocumentSuccessPage {

    private WebDriver driver;

    public DocumentSuccessPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='regSuccessPanel']")
    private WebElement successPopUp;

    @FindBy(css = "span[class='uiPanel-title']")
    private WebElement documentSuccessfulUploadMessage;

    @FindBy(css = "ul[id='regSuccess-messages']")
    private WebElement documentSuccessfulUploadIdMessage;

    @FindBy(css = "div.uiPanel-closeBox")
    private WebElement closePopUp;

    public WebElement getDocumentSuccessfulUploadMessage() {
        return documentSuccessfulUploadMessage;
    }

    public WebElement getDocumentSuccessfulUploadIdMessage() {
        return documentSuccessfulUploadIdMessage;
    }

    public WebElement getClosePopUp() {
        return closePopUp;
    }

    public WebElement getSuccessPopUp(){
        return successPopUp;
    }
}
