package edu.pe.cibertec.saucedemo.tasks;

import edu.pe.cibertec.saucedemo.ui.CheckoutPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.playwright.Target;
import net.serenitybdd.screenplay.playwright.interactions.Click;

public class CompleteOrder {

    public static Performable now() {

        return Task.where(
                "{0} completes the order",

                Click.on(
                        Target.the("Finish button")
                                .locatedBy(CheckoutPage.FINISH_BUTTON)
                )
        );
    }

}