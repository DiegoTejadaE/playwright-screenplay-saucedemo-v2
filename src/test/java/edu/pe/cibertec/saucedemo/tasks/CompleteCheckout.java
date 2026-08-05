package edu.pe.cibertec.saucedemo.tasks;

import edu.pe.cibertec.saucedemo.ui.CheckoutPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.playwright.Target;
import net.serenitybdd.screenplay.playwright.interactions.Click;
import net.serenitybdd.screenplay.playwright.interactions.Enter;

public class CompleteCheckout {

    public static Performable withData(String firstName,
                                       String lastName,
                                       String postalCode) {

        return Task.where(
                "{0} completes checkout information",

                Click.on(Target.the("Cart")
                        .locatedBy(CheckoutPage.CART_LINK)),

                Click.on(Target.the("Checkout")
                        .locatedBy(CheckoutPage.CHECKOUT_BUTTON)),

                Enter.theValue(firstName)
                        .into(Target.the("First name")
                                .locatedBy(CheckoutPage.FIRST_NAME)),

                Enter.theValue(lastName)
                        .into(Target.the("Last name")
                                .locatedBy(CheckoutPage.LAST_NAME)),

                Enter.theValue(postalCode)
                        .into(Target.the("Postal code")
                                .locatedBy(CheckoutPage.POSTAL_CODE)),

                Click.on(Target.the("Continue")
                        .locatedBy(CheckoutPage.CONTINUE_BUTTON))
        );
    }

}