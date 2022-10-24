package com.argos.selenium;

import com.argos.pages.Checkout;
import com.argos.pages.LoginDetails;
import com.argos.pages.WebPages;
import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.selenium.argos.Argos;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class IphoneTest extends Setup{


    @Test
    void LaunchArgos() {
        driver.get("https://www.argos.co.uk/?&_$ja=tsid:11705%7cacid:224-060-0086%7ccid:94668565%7cagid:4507124965%7ctid:kwd-18880610%7ccrid:535779513013%7cnw:g%7crnd:10756228396553342366%7cdvc:c%7cadp:%7cmt:e%7cloc:9046086&utm_source=Google&utm_medium=cpc&utm_campaign=94668565&utm_term=argos&utm_content=text&utm_custom1=4507124965&utm_custom2=224-060-0086&cmpid=GG05X&GPDP=true&gclid=CjwKCAjwwL6aBhBlEiwADycBIMFYxGnz42sQPcEesKjB9BWs3N4b0_ayQL1cF6DuhzRCIbUtGy0q8BoC4KsQAvD_BwE&gclsrc=aw.ds");
    Assert.assertEquals(driver.getTitle(), "Argos | Order online today for fast home delivery");
    }

    @Test
    void test() {

        WebPages pages = new WebPages();
        LoginDetails user = new LoginDetails();
        Checkout check = new Checkout();
        String iphone = "iphone 14 pro";

        driver.findElement(pages.cookie).click();
        driver.findElement(pages.search).sendKeys(iphone);
        driver.findElement(pages.search).submit();


        driver.findElement(pages.showMore).click();
        driver.findElement(By.xpath("//span[text()='£1000 - £2000']")).click();


        Argos.wait(4000);
        List<WebElement> allProductPrices = driver.findElements(pages.link_all_product_Prices);
        String product_price = "";
        List<WebElement> allProductTitles = driver.findElements(pages.link_all_product_titles);
        for (int i = 0; i < allProductPrices.size(); i++) {
            driver.findElements(pages.link_all_product_titles);
            String title = allProductTitles.get(i).getText();
            if (title.contains("iPhone 14 Pro") && title.contains("256GB") && title.contains("Gold")) {
                driver.findElements(pages.link_all_product_Prices);
                product_price = allProductPrices.get(i).getText();
                allProductTitles.get(i).click();
                break;
            }
        }
        Argos.wait(2000);
        driver.findElement(pages.add_to_trolley).click();
        Argos.wait(2000);
        driver.findElement(pages.go_to_trolley).click();
        WebElement text = driver.findElements(check.postcode).get(1); //2 differ versions of the element
        text.click();
        text.sendKeys("UB32NJ");
        driver.findElements(check.available).get(1).click();
        Argos.wait(2000);

        WebElement deliveryAvailable = driver.findElement(check.delivery);
        WebElement collectionAvailable = driver.findElement(check.collection);

        if (deliveryAvailable.isEnabled()) {
            deliveryAvailable.click();
            driver.findElement(user.loginUser).sendKeys("thers3001@gmail.com");
            driver.findElement(user.loginPass).sendKeys("Wizardzx31!");
            driver.findElement(user.loginPass).submit();
        } else if (collectionAvailable.isEnabled()) {
            collectionAvailable.click();
        } else {
            driver.quit();
            System.out.println("product is not available");
        }
    }
    }


