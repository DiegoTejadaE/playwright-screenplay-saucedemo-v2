package edu.pe.cibertec.saucedemo.stepdefinitions;

import edu.pe.cibertec.saucedemo.questions.TheErrorMessage;
import edu.pe.cibertec.saucedemo.questions.ThePageTitle;
import edu.pe.cibertec.saucedemo.tasks.LoginAs;
import edu.pe.cibertec.saucedemo.tasks.OpenTheLoginPage;
import edu.pe.cibertec.saucedemo.tasks.VerifySession;
import edu.pe.cibertec.saucedemo.ui.InventoryPage;
import edu.pe.cibertec.saucedemo.ui.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.playwright.abilities.BrowseTheWebWithPlaywright;
import com.microsoft.playwright.Page;
import net.serenitybdd.screenplay.playwright.abilities.BrowseTheWebWithPlaywright;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;

public class LoginStepDefinitions {
    private long loginTime;


    @Given("{word} is on the SauceDemo login page")
    public void openLoginPage(String actorName) {
        Actor actor = OnStage.theActorCalled(actorName);
        actor.whoCan(BrowseTheWebWithPlaywright.usingTheDefaultConfiguration());
        actor.attemptsTo(OpenTheLoginPage.page());
    }

    @When("she logs in with username {string} and password {string}")
    public void loginWith(String username, String password) {

        long start = System.currentTimeMillis();

        OnStage.theActorInTheSpotlight().attemptsTo(
                LoginAs.user(username).withPassword(password)
        );

        loginTime = System.currentTimeMillis() - start;
    }

    @Then("she should be redirect to the inventory page")
    public void shouldBeRedirectedToInventoryPage() {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ThePageTitle.displayed(), equalTo("Products"))
        );
    }

    @Then("she should see the page title {string}")
    public void shouldSeeThePageTitle(String pageTitle) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ThePageTitle.displayed(), equalTo(pageTitle))
        );
    }

    @Then("she should see the error message {string}")
    public void shouldSeeTheErrorMessage(String errorMessage) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(TheErrorMessage.displayed(), equalTo(errorMessage))
        );
    }

    @Then("she should remain on the login page")
    public void shouldRemainOnTheLoginPage() {

        Page page = BrowseTheWebWithPlaywright
                .as(OnStage.theActorInTheSpotlight())
                .getCurrentPage();

        assertThat(page.locator(LoginPage.LOGIN_BUTTON)).isVisible();
    }

    @io.cucumber.java.en.And("she navigates to the cart page")
    public void sheNavigatesToTheCartPage() {

        OnStage.theActorInTheSpotlight().attemptsTo(
                VerifySession.navigateCartAndBack()
        );
    }

    @And("she navigates back to the inventory page")
    public void sheNavigatesBackToTheInventoryPage() {
    }

    @Then("she should still be logged in")
    public void sheShouldStillBeLoggedIn() {

        Page page = BrowseTheWebWithPlaywright
                .as(OnStage.theActorInTheSpotlight())
                .getCurrentPage();

        assertThat(page.locator(InventoryPage.PAGE_TITLE)).isVisible();
        assertThat(page.locator(InventoryPage.PAGE_TITLE)).containsText("Products");
    }

    @Then("the page load time should be greater than {int} milliseconds")
    public void thePageLoadTimeShouldBeGreaterThanMilliseconds(Integer milliseconds) {

        assertTrue(loginTime > milliseconds,
                "Expected load time > " + milliseconds +
                        " ms but was " + loginTime + " ms");
    }




}
