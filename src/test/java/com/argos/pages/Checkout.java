package com.argos.pages;

import org.openqa.selenium.By;

public class Checkout {

    public By postcode = By.xpath("//input[@data-test='fulfilment-localisation-edit']");

    public By available = By.xpath("//button[@id='basket-FulfilmentSelectorForm-deliverButton']");
    public By delivery = By.xpath("//button[@data-e2e='continue-with-delivery-button']");

    public By collection = By.xpath("//button[@data-e2e='continue-with-collection-button']");

}
