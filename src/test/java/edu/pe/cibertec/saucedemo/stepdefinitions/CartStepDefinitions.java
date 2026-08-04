package edu.pe.cibertec.saucedemo.stepdefinitions;

import edu.pe.cibertec.saucedemo.questions.TheCartContents;
import edu.pe.cibertec.saucedemo.questions.TheCartCounter;
import edu.pe.cibertec.saucedemo.tasks.AddToCart;
import edu.pe.cibertec.saucedemo.tasks.RemoveFromCart;
import edu.pe.cibertec.saucedemo.ui.CartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.playwright.interactions.Click;
import net.serenitybdd.screenplay.playwright.Target;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;

public class CartStepDefinitions {

    @And("she adds the product {string} to the cart")
    public void sheAddsTheProductToTheCart(String productName) {

        OnStage.theActorInTheSpotlight().attemptsTo(
                AddToCart.product(productName)
        );
    }

    @And("she removes the product {string} from the cart")
    public void sheRemovesTheProductFromTheCart(String productName) {

        OnStage.theActorInTheSpotlight().attemptsTo(
                RemoveFromCart.product(productName)
        );
    }

    @Then("the cart icon should display {string}")
    public void theCartIconShouldDisplay(String amount) {

        OnStage.theActorInTheSpotlight().should(
                seeThat(TheCartCounter.value(), equalTo(amount))
        );
    }

    @And("the cart should contain {string} and {string}")
    public void theCartShouldContain(String first, String second) {

        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(Target.the("Cart")
                        .locatedBy(CartPage.CART_LINK))
        );

        OnStage.theActorInTheSpotlight().should(
                seeThat(
                        TheCartContents.items(),
                        contains(first, second)
                )
        );
    }

    @And("the cart should only contain {string}")
    public void theCartShouldOnlyContain(String product) {

        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(Target.the("Cart")
                        .locatedBy(CartPage.CART_LINK))
        );

        OnStage.theActorInTheSpotlight().should(
                seeThat(
                        TheCartContents.items(),
                        contains(product)
                )
        );
    }

}