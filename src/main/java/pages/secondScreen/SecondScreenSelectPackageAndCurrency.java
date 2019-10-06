package pages.secondScreen;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SecondScreenSelectPackageAndCurrency {
    private SelenideElement textUNP = $("[name='Unp'][type='text']");
    private SelenideElement textOwnerUNP = $(By.id("Unp"));
    private List<SelenideElement> listBankPackage = $$("[name='Phone'][type='text']");
    private SelenideElement radioButtonRepresent = $(By.id("Phone"));
    private SelenideElement radioButtonOwner = $("[data-bind='events:{click: btnGetSmsCodeClicked}']");
    private SelenideElement switcherUSA = $(By.id("Unp-error"));
    private SelenideElement buttonSubmit = $(By.id("todo"));

    public String getTextUNP() {
        return textUNP.shouldBe(Condition.visible).text();
    }
    public String getTextOwnerUNP() {
        return textOwnerUNP.shouldBe(Condition.visible).text();
    }
    public SecondScreenSelectPackageAndCurrency listPackage(int num) {
         listBankPackage.get(num).click();
         return this;
    }
}
