package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
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

    @Then("^A search result should be displayed in search panel$")
    public void aSearchResultShouldBeDisplayedInSearchPanel() {
    }
}