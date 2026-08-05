package edu.pe.cibertec.saucedemo.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.playwright.Target;
import net.serenitybdd.screenplay.playwright.interactions.Click;

public class VerifySession {

    public static Performable navigateCartAndBack() {

        return Task.where(
                "{0} navigates to cart and returns",

                Click.on(
                        Target.the("Shopping cart")
                                .locatedBy("[data-test='shopping-cart-link']")
                ),

                Click.on(
                        Target.the("Continue shopping")
                                .locatedBy("[data-test='continue-shopping']")
                )
        );
    }
}