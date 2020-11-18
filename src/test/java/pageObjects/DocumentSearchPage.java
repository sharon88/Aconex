package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocumentSearchPage {
    private WebDriver driver;

    public DocumentSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "mainHeading")
    private WebElement header;

    @FindBy(id = "search-keywords-id")
    private WebElement searchBox;

    @FindBy(css = "button.auiButton.primary.ng-binding")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id='searchCriteriaContainer']/div[1]/div[3]/div/button")
    private WebElement saveSearchButton;

    @FindBy(css = "div[class='auiModal-content']")
    private WebElement modal;

    @FindBy(css = "input[ng-model='details.title']")
    private WebElement nameField;

    @FindBy(id = "ok")
    private WebElement saveButton;

    @FindBy(id = "savedSearchButton")
    private WebElement savedSearchButton;

    @FindBy(css = "input[ng-model='savedSearchListItem.name']")
    private WebElement savedSearchEditText;

    @FindBy(css = "span[ng-bind='savedSearchListItem.name']")
    private WebElement savedSearchList;

    @FindBy(xpath = "//*[@id='searchResultsWrapperAngular']/div/div[3]/div[1]/acx-search-ag-grid/div/div/div[1]/div/div[3]/div[1]/div/div[3]/div")
    private WebElement documentId;

    @FindBy(xpath = "//*[@id='searchResultsWrapperAngular']/div/div[3]/div[1]/acx-search-ag-grid/div/div/div[1]/div/div[3]/div[2]/div/div/div/div[1]/div/a")
    private WebElement documentName;


    public WebElement getHeader() {
        return header;
    }

    public WebElement getSearchBox() {
        return searchBox;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getModal() {
        return modal;
    }

    public WebElement getNameField() {
        return nameField;
    }

    public WebElement getSaveButton() {
        return saveButton;
    }

    public WebElement getSaveSearchButton() {
        return saveSearchButton;
    }

    public WebElement getSavedSearchButton() {
        return savedSearchButton;
    }

    public WebElement getSavedSearchEditText() {
        return savedSearchEditText;
    }

    public WebElement getSavedSearchList() {
        return savedSearchList;
    }

    public WebElement getDocumentId() {
        return documentId;
    }

    public WebElement getDocumentName() {
        return documentName;
    }
}
