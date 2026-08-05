package edu.pe.cibertec.saucedemo.questions;

import edu.pe.cibertec.saucedemo.ui.CheckoutPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.playwright.Target;
import net.serenitybdd.screenplay.playwright.questions.Visibility;

public class TheCheckoutForm {

    public static Question<Boolean> isVisible() {
        return Visibility.of(
                Target.the("Checkout form")
                        .locatedBy(CheckoutPage.CHECKOUT_FORM)
        );
    }

}