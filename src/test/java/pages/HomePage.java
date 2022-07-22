package pages;


import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.ConfigurationReader;
import utils.Driver;

// page_url = http://demo.guru99.com/payment-gateway/index.php
public class HomePage {
    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "h3")
    public WebElement elementH;

    @FindBy(css = "h2")
    private WebElement header;

    @FindBy(name = "quantity")
    public WebElement quantitySelect;

    @FindBy(css = "input.button.special")
    public WebElement buttonInput;

    public void verifyPriceEqual(String str) {
      Assert.assertTrue(elementH.getText().trim().endsWith(str));
    }

    public void verifyHeaderEqual(String str) {
       Assert.assertEquals(header.getText(),str);
        System.out.println(str);
    }
// No page elements added
    public void buyNow(){
        buttonInput.click();
    }

 public void verifyUrlContains(String str){
       Assert.assertTrue( Driver.getDriver().getCurrentUrl().contains(str));

 }
 public void quantitySelect(String str){
     Select dropdown=new Select(quantitySelect);
     dropdown.selectByVisibleText(str);
 }



}

