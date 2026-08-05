package edu.pe.cibertec.saucedemo.stepdefinitions;

import edu.pe.cibertec.saucedemo.questions.TheCheckoutForm;
import edu.pe.cibertec.saucedemo.questions.TheCheckoutSummary;
import edu.pe.cibertec.saucedemo.questions.TheConfirmationMessage;
import edu.pe.cibertec.saucedemo.questions.TheErrorMessage;
import edu.pe.cibertec.saucedemo.tasks.AddToCart;
import edu.pe.cibertec.saucedemo.tasks.CompleteCheckout;
import edu.pe.cibertec.saucedemo.tasks.CompleteOrder;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;

public class CheckoutStepDefinitions {

    @And("she proceeds to checkout with first name {string}, last name {string} and postal code {string}")
    public void sheProceedsToCheckout(String firstName,
                                      String lastName,
                                      String postalCode) {

        OnStage.theActorInTheSpotlight().attemptsTo(
                CompleteCheckout.withData(
                        firstName,
                        lastName,
                        postalCode
                )
        );
    }

    @And("she verifies the order summary shows item total {string}")
    public void sheVerifiesTheOrderSummaryShowsItemTotal(String total) {

        OnStage.theActorInTheSpotlight().should(
                seeThat(
                        TheCheckoutSummary.itemTotal(),
                        containsString(total)
                )
        );
    }

    @And("she completes the order")
    public void sheCompletesTheOrder() {

        OnStage.theActorInTheSpotlight().attemptsTo(
                CompleteOrder.now()
        );
    }

    @Then("she should see the confirmation message {string}")
    public void sheShouldSeeTheConfirmationMessage(String message) {

        OnStage.theActorInTheSpotlight().should(
                seeThat(
                        TheConfirmationMessage.text(),
                        equalTo(message)
                )
        );
    }

    @And("the checkout form should remain visible")
    public void theCheckoutFormShouldRemainVisible() {

        OnStage.theActorInTheSpotlight().should(
                seeThat(
                        TheCheckoutForm.isVisible(),
                        is(true)
                )
        );
    }

}