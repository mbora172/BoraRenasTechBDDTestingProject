package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.Base;
import utils.Driver;

import java.util.List;

// page_url = https://demo.guru99.com/payment-gateway/process_purchasetoy.php
public class PurchasePage extends Base {
    @FindBy(id = "card_nmuber")
    public WebElement cardNmuberInput;

    @FindBy(id = "month")
    public WebElement monthSelect;

    @FindBy(id = "year")
    public WebElement yearSelect;

    @FindBy(id = "cvv_code")
    public WebElement cvvCodeInput;

    @FindBy(name = "submit")
    public WebElement submitInput;

    @FindBy(css = "h2")
    public WebElement elementH;

    // No page elements added

    public PurchasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    public void setCardInfo(String cn,String month,String year,String cvv){
        cardNmuberInput.sendKeys(cn);
        Select dropMonth=new Select(monthSelect);
        dropMonth.selectByVisibleText(month);
        Select dropyearSelect=new Select(yearSelect);
        dropyearSelect.selectByVisibleText(year);
        cvvCodeInput.sendKeys(cvv);
        submitInput.click();
        
        
    }
    public void verifyPurchaseSucces(String str){
        Assert.assertTrue(elementH.getText().contains(str));
    }
    
    
}