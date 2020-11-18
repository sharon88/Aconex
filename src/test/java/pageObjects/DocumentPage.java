package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocumentPage {

    private WebDriver driver;

    public DocumentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "docno_auto_0_chk")
    private WebElement documentNoCheckbox;

    @FindBy(css = "input[name='revision_0']")
    private WebElement revisionId;

    @FindBy(css = "input[name='title_0']")
    private WebElement titleId;

    @FindBy(id = "doctype_0")
    private WebElement documentTypeId;

    @FindBy(id = "docstatus_0")
    private WebElement documentStatusId;

    @FindBy(id = "discipline_0")
    private WebElement discipleId;

    @FindBy(id = "clickToUpload")
    private WebElement uploadId;

    @FindBy(xpath = "//*[@id='revisiondate_0-dateField']/div")
    private WebElement revisionDate;

    @FindBy(id = "btnUploadDocument")
    private WebElement uploadButtonId;

    @FindBy(css = "div[dyc-btn='today']")
    private WebElement revisionTodayId;

    @FindBy(id = "frameLoader")
    private WebElement loadingProgress;


    public WebElement getDocumentNoCheckbox() {
        return documentNoCheckbox;
    }

    public WebElement getRevisionId() {
        return revisionId;
    }

    public WebElement getTitleId() {
        return titleId;
    }

    public WebElement getDocumentTypeId() {
        return documentTypeId;
    }

    public WebElement getDocumentStatusId() {
        return documentStatusId;
    }

    public WebElement getDiscipleId() {
        return discipleId;
    }

    public WebElement getUploadId() {
        return uploadId;
    }

    public WebElement getRevisionDate() {
        return revisionDate;
    }

    public WebElement getRevisionTodayId() {
        return revisionTodayId;
    }

    public WebElement getUploadButtonId() {
        return uploadButtonId;
    }


    public WebElement getLoadingProgress() {
        return loadingProgress;
    }
}
