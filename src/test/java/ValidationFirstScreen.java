import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.firstScreen.FirstScreenInitAccounts;
import utilites.GenerateCodePage;
import utilites.ParserJson;

import static com.codeborne.selenide.Selenide.*;


public class ValidationFirstScreen {
    private FirstScreenInitAccounts firstScreenInitAccounts;
    @BeforeMethod
    public void init(){
        firstScreenInitAccounts = new FirstScreenInitAccounts();
        open(ParserJson.value("URL"));
        try {
            switchTo().alert().accept();
        }
        catch (Exception e){
        e.getMessage();
        }

    }
    @Test
    protected void verifyMaxSizePhoneInput() {

        firstScreenInitAccounts
                .inputDataPhoneField(ParserJson.value("phoneValid"))
                .getCodeButton();
        Assert.assertEquals(firstScreenInitAccounts.getDataPhoneField(), ParserJson.value("phoneExpected"));
    }
    @Test
    protected void verifyNoMoreMaxSizePhoneInput() {
        firstScreenInitAccounts
                .inputDataPhoneField(ParserJson.value("phoneMoreThan9Digit"))
                .getCodeButton();
        Assert.assertEquals(firstScreenInitAccounts.getDataPhoneField(), ParserJson.value("phoneExpected"));
    }
    @Test
    protected void verifyMaxSizeUNPInput() {
        firstScreenInitAccounts
                .inputDataUNPField(ParserJson.value("UNP"))
                .getCodeButton();
        Assert.assertEquals(firstScreenInitAccounts.getDataUNPField(), ParserJson.value("UNP"));
    }
    @Test
    protected void verifyNoMoreMaxSizeUNPInput() {
        firstScreenInitAccounts
                .inputDataUNPField(ParserJson.value("UNPMoreThan9Digit"))
                .getCodeButton();
        Assert.assertEquals(firstScreenInitAccounts.getDataUNPField(), ParserJson.value("UNP"));
    }
    @Test
    protected void verifyErrorMessageEmptyUNPInput() {
        firstScreenInitAccounts
                .inputDataUNPField(ParserJson.value("UNPEmpty"))
                .getCodeButton();
        Assert.assertEquals(firstScreenInitAccounts.getErrorUNP(), ParserJson.value("textErrorEmptyUNP"));
    }
    @Test
    protected void verifyErrorMessageIncorrectMaskUNPInput() {
        firstScreenInitAccounts
                .inputDataUNPField(ParserJson.value("UNPIncorrectMask"))
                .getCodeButton();
        Assert.assertEquals(firstScreenInitAccounts.getErrorUNP(), ParserJson.value("textErrorInvalidMaskUNP"));
    }
    @Test
    protected void verifyErrorMessageLessThanValidCountDigitsUNPInput() {
        firstScreenInitAccounts
                .inputDataUNPField(ParserJson.value("UNPLessThan9Digit"))
                .getCodeButton();
        Assert.assertEquals(firstScreenInitAccounts.getErrorUNP(), ParserJson.value("textErrorEmptyUNP"));
    }
    @Test
    protected void verifyErrorMessageLessThanValidCountDigitsPhoneInput() {
        firstScreenInitAccounts
                .inputDataPhoneField(ParserJson.value("phoneLessThan9Digit"))
                .getCodeButton();
        Assert.assertEquals(firstScreenInitAccounts.getErrorPhone(), ParserJson.value("textErrorEmptyPhone"));
    }
    @Test
    protected void verifyErrorMessageEmptyPhoneInput() {
        firstScreenInitAccounts
                .inputDataPhoneField(ParserJson.value("phoneEmpty"))
                .getCodeButton();
        Assert.assertEquals(firstScreenInitAccounts.getErrorPhone(), ParserJson.value("textErrorEmptyPhone"));
    }
    @Test
    protected void verifyErrorMessageEmptyAgreeCheckBox() {
        firstScreenInitAccounts
                .getCodeButton();
        Assert.assertEquals(firstScreenInitAccounts.getErrorCheckBoxValidation(), ParserJson.value("textErrorEmptyCheckBox"));
    }

    @Test
    protected void verifyErrorMessageEmptySMSCode() {
       // firstScreenInitAccounts
             //   .enterAndSendValidDataToSMSCode(ParserJson.value("UNP"),ParserJson.value("phoneValid"));
        firstScreenInitAccounts.inputDataUNPField(new GenerateCodePage().getSMSCode("324324234"));
        Assert.assertEquals(firstScreenInitAccounts.getErrorCheckBoxValidation(), ParserJson.value("textErrorEmptyCheckBox"));
    }

    @AfterMethod
    public void finalized(){
        clearBrowserCookies();
    }
}
