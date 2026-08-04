package edu.pe.cibertec.saucedemo.questions;

import edu.pe.cibertec.saucedemo.ui.CartPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.playwright.abilities.BrowseTheWebWithPlaywright;

import java.util.List;

public class TheCartContents implements Question<List<String>> {

    public static Question<List<String>> items() {
        return new TheCartContents();
    }

    @Override
    public List<String> answeredBy(Actor actor) {

        return BrowseTheWebWithPlaywright.as(actor)
                .getCurrentPage()
                .locator(CartPage.CART_ITEMS)
                .allTextContents();
    }

}