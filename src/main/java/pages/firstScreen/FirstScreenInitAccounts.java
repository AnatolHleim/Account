package pages.firstScreen;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.Keys.HOME;

public class FirstScreenInitAccounts {
    private SelenideElement setValueInputUNP = $("[name='Unp'][type='text']");
    private SelenideElement getValueInputUNP = $(By.id("Unp"));
    private SelenideElement setValueInputPhone = $("[name='Phone'][type='text']");
    private SelenideElement getValueInputPhone = $(By.id("Phone"));
    private SelenideElement buttonGetCode = $("[data-bind='events:{click: btnGetSmsCodeClicked}']");
    private SelenideElement errorUnpValidation = $(By.id("Unp-error"));
    private SelenideElement errorPhoneValidation = $(By.id("Phone-error"));
    private SelenideElement inputCheckBoxAgree = $(By.id("ConditionAgree"));
    private SelenideElement errorCheckBoxValidation = $(By.id("ConditionAgree-error"));
    private SelenideElement setValueSMSCode = $(By.id("todo"));
    private SelenideElement buttonSubmit = $(By.id("todo"));
    private SelenideElement ku = $(By.className("content-container__title"));

    public FirstScreenInitAccounts inputDataUNPField(String text) {
        setValueInputUNP.val(text);
        return this;
    }

    public FirstScreenInitAccounts inputDataPhoneField(String text) {
        ku.waitUntil(Condition.text("счета"),10000);
        setValueInputPhone.sendKeys(HOME);
        setValueInputPhone.sendKeys(text);
        return this;
    }

    public String getDataPhoneField() {
        return getValueInputPhone.getValue();
    }

    public String getDataUNPField() {
        return getValueInputUNP.getValue();
    }

    public void getCodeButton() {
        buttonGetCode.click();
    }

    public String getErrorUNP() {
        return errorUnpValidation.shouldBe(Condition.visible).text();
    }

    public String getErrorPhone() {
        return errorPhoneValidation.shouldBe(Condition.visible).text();
    }

    public FirstScreenInitAccounts clickCheckBoxAgree() {
        inputCheckBoxAgree.shouldNot(Condition.checked).click();

        return this;
    }

    public String getErrorCheckBoxValidation() {
        return errorCheckBoxValidation.shouldBe(Condition.visible).text();
    }
    public void enterAndSendValidDataToSMSCode(String phone, String UNP){
        inputDataUNPField(UNP)
                .inputDataPhoneField(phone)
                .clickCheckBoxAgree()
                .getCodeButton();
    }

}

