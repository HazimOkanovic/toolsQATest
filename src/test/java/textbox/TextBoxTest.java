package textbox;

import base.BaseTests;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.*;
public class TextBoxTest extends BaseTests {

    @Test
    public void clickElementsTest(){
        var elementsPage = homePage.clickElements();
        var textPage = elementsPage.clickText();

        String name = "Hazim Okanovic";
        String email = "hazimokanovic@gmail.com";
        String currentAddress = "Sahmani bb";
        String permanentAddress = "Bosnia and Herzegovina";

        textPage.enterUserName(name);
        textPage.enterEmail(email);
        textPage.enterCurrentAddress(currentAddress);
        textPage.enterPermanentAddress(permanentAddress);
        textPage.clickSubmit();

        assertEquals("Still not good enough", "Name:"+name, textPage.checkName());
        assertEquals("Email is not right", "Email:"+email, textPage.checkEmail());
        assertEquals("Current address is not right", "Current Address :"+currentAddress, textPage.checkAddressNow());
        assertEquals("Permanent address is not right", "Permananet Address :"+permanentAddress, textPage.checkPermanentAddress());
        }
    @Test
    public void invalidEmailTest() {
        var elementsPage = homePage.clickElements();
        var textPage = elementsPage.clickText();
        String email = "hazim";

        textPage.enterEmail(email);
        textPage.clickSubmit();
        assertEquals("rgba(73, 80, 87, 1)", driver.findElement(By.id("userEmail")).getCssValue("color"));
    }
    @Test
    public void testOneByOneInput(){
        var elementsPage = homePage.clickElements();
        var textPage = elementsPage.clickText();
        String name = "Hazim";
        String email = "hazimokanovic@yahoo.com";
        String currentAddress = "Sahmani bb";
        String permanentAddress = "Bosnia and Herzegovina";
        textPage.enterUserName(name);
        textPage.clickSubmit();
        assertEquals("Name is not right","Name:"+name,textPage.checkName());
        textPage.enterEmail(email);
        textPage.clickSubmit();
        assertEquals("Email is not right", "Email:"+email,textPage.checkEmail());
        textPage.enterCurrentAddress(currentAddress);
        textPage.clickSubmit();
        assertEquals("Current Address is not right", "Current Address :"+currentAddress, textPage.checkAddressNow());
        textPage.enterPermanentAddress(permanentAddress);
        textPage.clickSubmit();
        assertEquals("Permanent Address is not right", "Permananet Address :"+permanentAddress, textPage.checkPermanentAddress());
    }
}

