package edu.pe.cibertec.saucedemo.tasks;

import edu.pe.cibertec.saucedemo.ui.CartPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.playwright.Target;
import net.serenitybdd.screenplay.playwright.interactions.Click;

public class RemoveFromCart {

    public static Performable product(String productName) {

        return Task.where(
                "{0} removes product '" + productName + "' from the cart",

                Click.on(
                        Target.the("Remove button")
                                .locatedBy(CartPage.removeButton(productName))
                )
        );
    }
}