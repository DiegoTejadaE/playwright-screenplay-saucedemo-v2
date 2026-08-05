package edu.pe.cibertec.saucedemo.questions;

import edu.pe.cibertec.saucedemo.ui.CheckoutPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.playwright.Target;
import net.serenitybdd.screenplay.playwright.questions.Text;

public class TheCheckoutSummary {

    public static Question<String> itemTotal() {
        return Text.of(
                Target.the("Item total")
                        .locatedBy(CheckoutPage.ITEM_TOTAL)
        );
    }

}