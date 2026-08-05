package edu.pe.cibertec.saucedemo.tasks;

import edu.pe.cibertec.saucedemo.ui.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.playwright.Target;

public class VerifySummary {

    public static Performable showsItemTotal(String expectedTotal) {

        return Task.where(
                "{0} verifies the checkout summary",

                Ensure.that(
                        Target.the("Item total")
                                .locatedBy(CheckoutPage.ITEM_TOTAL)
                ).text().contains(expectedTotal)
        );
    }

}