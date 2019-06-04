package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import ui.PageTransporter;
import ui.web.pages.MainWebPage;

public class SearchSteps {

    //Pages
    private PageTransporter pageTransporter;
    private MainWebPage mainWebPage;

    public SearchSteps() {
        this.pageTransporter = PageTransporter.getInstance();
    }

    @Given("^I navigate to Prestashop page$")
    public void iNavigateToPrestashopPage() throws InterruptedException {
        mainWebPage = pageTransporter.navigateToMainWebPage("http://demo.prestashop.com/en/?view=front");
    }

    @When("^I click on Sign In button$")
    public void iClickOnSignInButton() throws Throwable {
        mainWebPage.clickSignInButton();
    }

    @When("^I click the search area$")
    public void iClickTheSearchArea() throws Throwable {
        mainWebPage.clickSearchInput();
    }

    @And("^I type the text \"([^\"]*)\"$")
    public void iTypeTheText(String text) throws Throwable {
        mainWebPage.typeString(text);

    }

    @And("^I click the search button$")
    public void iClickTheSearchButton() throws Throwable {
        mainWebPage.clickSearchButton();
    }

    @Then("^A search result with the name \"([^\"]*)\" should be displayed in search panel$")
    public void aSearchResultWithTheNameShouldBeDisplayedInSearchPanel(String text) throws Throwable {
        boolean exist = mainWebPage.existResultSearchElementByText(text);
        Assert.assertTrue(false);
    }

    @When("^I subscribe to newsletter with email \"([^\"]*)\"$")
    public void iSubscribeToNewsletterWithEmail(String arg0) throws Throwable {
        mainWebPage.clickEmailAddressSubscribe()
                .typeEmailAddresSubscribe(arg0)
                .clickSubscribeNewlettersButton();
    }

    @Then("^the message \"([^\"]*)\" should be displayed$")
    public void theMessageShouldBeDisplayed(String arg0) throws Throwable {
        boolean isSuccessMessage = mainWebPage.isMessageDisplayed(arg0);
    }


}