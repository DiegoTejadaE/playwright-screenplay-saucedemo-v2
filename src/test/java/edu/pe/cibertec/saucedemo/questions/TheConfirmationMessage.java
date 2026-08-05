package edu.pe.cibertec.saucedemo.questions;

import edu.pe.cibertec.saucedemo.ui.CheckoutPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.playwright.Target;
import net.serenitybdd.screenplay.playwright.questions.Text;

public class TheConfirmationMessage {

    public static Question<String> text() {
        return Text.of(
                Target.the("Confirmation message")
                        .locatedBy(CheckoutPage.COMPLETE_HEADER)
        );
    }

}