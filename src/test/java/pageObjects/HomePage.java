package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "span[class='nav-userDetails']")
    private WebElement userDetails;

    @FindBy(css = "span[class='nav-orgDetails']")
    private WebElement orgDetails;

    @FindBy(css = "span[class='nav-userAvatar']")
    private WebElement userAvatar;


    @FindBy(id = "nav-bar-CORRESPONDENCE")
    private WebElement emailNavbar;

    @FindBy(id = "nav-bar-CORRESPONDENCE-CORRESPONDENCE-CREATEMAIL")
    private WebElement blankEmail;

    @FindBy(id = "nav-bar-DOC")
    private WebElement documentNavbar;

    @FindBy(id = "nav-bar-DOC-DOC-NEW")
    private WebElement uploadDocument;

    @FindBy(id = "nav-bar-DOC-DOC-SEARCH")
    private WebElement documentRegister;

    @FindBy(css = "div.uiButton-label")
    private WebElement document;


    public WebElement getUserDetailsLocator() {
        return userDetails;
    }

    public WebElement getOrgDetailsLocator() {
        return orgDetails;
    }

    public WebElement getUserAvatarLocator() {
        return userAvatar;
    }

    public WebElement getEmailNavbar() {
        return emailNavbar;
    }

    public WebElement getBlankEmail() {
        return blankEmail;
    }

    public WebElement getDocumentNavbar() {
        return documentNavbar;
    }

    public WebElement getUploadDocument() {
        return uploadDocument;
    }

    public WebElement getDocumentRegister() {
        return documentRegister;
    }

    public WebElement getDocument(){
        return document;
    }


}
