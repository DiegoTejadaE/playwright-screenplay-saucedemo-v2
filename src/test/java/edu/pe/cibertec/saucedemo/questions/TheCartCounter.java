package edu.pe.cibertec.saucedemo.questions;

import edu.pe.cibertec.saucedemo.ui.CartPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.playwright.abilities.BrowseTheWebWithPlaywright;

public class TheCartCounter implements Question<String> {

    public static Question<String> value() {
        return new TheCartCounter();
    }

    @Override
    public String answeredBy(Actor actor) {

        return BrowseTheWebWithPlaywright.as(actor)
                .getCurrentPage()
                .locator(CartPage.CART_BADGE)
                .textContent();
    }
}