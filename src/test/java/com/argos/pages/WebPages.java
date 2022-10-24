package com.argos.pages;

import org.openqa.selenium.By;

public class WebPages { //Page Object Model (POM)

    public By cookie = By.xpath("//button[@id='consent_prompt_submit']");
    public By search = By.xpath("//input[@role='combobox']");

    public By showMore = By.xpath("//button[@data-test='price-facet-button-show-more']");
    public By link_all_product_titles = By.xpath("//a[@data-test='component-product-card-title']");
    public By link_all_product_Prices = By.xpath("//div[@data-test='component-product-card-price']/strong");

    public By add_to_trolley = By.xpath("//button[@class='Buttonstyles__Button-sc-42scm2-2 cSktxC']");

    public By go_to_trolley = By.xpath("//a[@class='Buttonstyles__Button-sc-42scm2-2 cSktxC']");

}
