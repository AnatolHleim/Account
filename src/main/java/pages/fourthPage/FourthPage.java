package pages.fourthPage;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class FourthPage {
    private SelenideElement addressUserInput = $("[name='Unp'][type='text']");
    private SelenideElement addressUserPickUpInput = $(By.id("Address"));
    private SelenideElement switcherIsUSAResident = $(By.name("IsUsaResident"));
    private SelenideElement addressUserInputOffice = $(By.className("content-container__title"));
}
