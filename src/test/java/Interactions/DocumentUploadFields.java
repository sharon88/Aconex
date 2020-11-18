package Interactions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import pageObjects.DocumentPage;
import utils.Common;
import utils.OsHelper;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class DocumentUploadFields {

    private DocumentPage documentPage;
    private WebDriver driver;
    private Common common;

    private final static String BASE_PROJECT_PATH = System.getProperty("user.dir");
    private final static String DOCUMENT_UPLOAD_PATH = BASE_PROJECT_PATH +  File.separator + "uploadSection" +  File.separator+ "CodingAssignment.docx";

    public DocumentUploadFields(WebDriver driver) {
        this.driver = driver;
        documentPage = new DocumentPage(driver);
        common = new Common(driver);
    }

    public void enterTheRequiredDocumentFields(String documentName) throws AWTException {
        common.waitForTheLoadingProgressTobeDismissed();
        common.switchToIFrame();
        clickOnAutoDocumentNoCheckbox();
        enterTheRevisionNo();
        enterTitle(documentName);
        selectTypeOfDocument();
        selectStatus();
        selectDiscipline();
        uploadFile();
        setRevisionDate();
    }

    public void clickUploadButton() {
        documentPage.getUploadButtonId().click();
    }


    private void clickOnAutoDocumentNoCheckbox() {
        documentPage.getDocumentNoCheckbox().click();
    }

    private void enterTheRevisionNo() {
        documentPage.getRevisionId().sendKeys("1");
    }

    private void enterTitle(String documentName) {
        documentPage.getTitleId().sendKeys(documentName);
    }

    private void selectTypeOfDocument() {
        Select select = new Select(documentPage.getDocumentTypeId());
        select.selectByVisibleText("Sample");
    }

    private void selectStatus() {
        Select select = new Select(documentPage.getDocumentStatusId());
        select.selectByVisibleText("Draft");
    }

    private void selectDiscipline() {
        Select select = new Select(documentPage.getDiscipleId());
        select.selectByVisibleText("Environment");
    }

    private void uploadFile() throws AWTException {
        documentPage.getUploadId().click();
        uploadDoc(DOCUMENT_UPLOAD_PATH);
        
    }

    private void uploadDoc(String documentUploadPath) throws AWTException {
        if (OsHelper.getOperatingSystem().toString().contains("MAC")){
            uploadMediaByRobot(documentUploadPath);
        } else if (OsHelper.getOperatingSystem().toString().contains("WIN")){
            uploadFileInWindows(documentUploadPath);
        }
    }

    //Need to run as a admin in the windows system to upload the file.
    private void uploadFileInWindows(String documentUploadPath) throws AWTException {
        StringSelection strSelection = new StringSelection(documentUploadPath);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(strSelection, null);

        Robot robot = new Robot();

        robot.delay(300);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(200);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    private void setRevisionDate() {
        documentPage.getRevisionDate().click();
        documentPage.getRevisionTodayId().click();
    }


    //Note that in mac OS mojave, there is a issue with uploading document,
    //https://learn-automation.com/upload-file-in-selenium-in-mac/ ,manually intervention is required to enable accessibility for the IDE before running the tests. Please check
    //https://stackoverflow.com/questions/53901026/java-awt-robot-keypress-and-keyrelease-not-working-at-all/54965052#54965052
    private void uploadMediaByRobot(String fileName) {
        //File Need to be imported
        File file = new File(fileName);
        StringSelection stringSelection = new StringSelection(file.getAbsolutePath());
        //Copy to clipboard
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        // Cmd + Tab is needed since it launches a Java app and the browser looses focus
        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_META);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.delay(1000);

        //Open Goto window
        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_G);
        robot.keyRelease(KeyEvent.VK_META);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyRelease(KeyEvent.VK_G);

        //Paste the clipboard value
        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_META);
        robot.keyRelease(KeyEvent.VK_V);

        //Press Enter key to close the Goto window and Upload window
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(500);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }


}
