package utilites;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;

public class GenerateCodePage {
    private SelenideElement code = $(By.className("tel_top"));
    public static final String URL_GENERATOR = "https://www.vtour.by/?utm_source=";

    public String getSMSCode(String phone){
        executeJavaScript("window.open('"+URL_GENERATOR+phone+"', '_blank');");
        switchTo().window(1);
       String sms  = code.getText();
       switchTo().window(1).close();
       switchTo().window(0);
       return sms;
    }
}
