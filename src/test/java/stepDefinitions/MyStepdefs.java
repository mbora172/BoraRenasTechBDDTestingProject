package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.PurchasePage;
import utils.ConfigurationReader;
import utils.Driver;

import java.util.Map;

public class MyStepdefs {
    HomePage homePage=new HomePage();
    PurchasePage purchasePage=new PurchasePage();
    @Given("user wants to be on Getaway home page")
    public void userWantsToBeOnGetawayHomePage() {
        Driver.getDriver().get(ConfigurationReader.getProperties("url"));
    }

    @Given("Verify that header match with expected text  {string}")
    public void verifyThatHeaderMatchWithExpectedText(String header) {
        homePage.verifyHeaderEqual(header);

    }

    @Given("Verify that toy price match with expected price  {string}")
    public void verifyThatToyPriceMatchWithExpectedPrice(String price) {
        homePage.verifyPriceEqual(price);

    }

    @Given("Verify that Url contains {string}")
    public void verifyThatUrlContains(String urlText) {
        homePage.verifyUrlContains(urlText);
    }

    @Given("user wants select quantity as {string} and click buy now")
    public void userWantsSelectQuantityAs(String quantity) {
        homePage.quantitySelect(quantity);
        homePage.buyNow();

    }

    @When("user wants to enter cc info as following and order")
    public void userWantsToEnterDigit( Map<String, String> dataTable) {
        purchasePage.setCardInfo(dataTable.get("card number"),dataTable.get("month"),dataTable.get("year"),dataTable.get("cvv"));

    }

    @Then("Verify that {string} text matches")
    public void verifyThatTextMatches(String purchaseSucces) {
        purchasePage.verifyPurchaseSucces(purchaseSucces);
    }


}
