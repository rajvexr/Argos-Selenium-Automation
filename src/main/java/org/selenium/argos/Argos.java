package org.selenium.argos;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Argos {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://www.argos.co.uk/?&_$ja=tsid:11705%7cacid:224-060-0086%7ccid:94668565%7cagid:4507124965%7ctid:kwd-18880610%7ccrid:535779513013%7cnw:g%7crnd:10756228396553342366%7cdvc:c%7cadp:%7cmt:e%7cloc:9046086&utm_source=Google&utm_medium=cpc&utm_campaign=94668565&utm_term=argos&utm_content=text&utm_custom1=4507124965&utm_custom2=224-060-0086&cmpid=GG05X&GPDP=true&gclid=CjwKCAjwwL6aBhBlEiwADycBIMFYxGnz42sQPcEesKjB9BWs3N4b0_ayQL1cF6DuhzRCIbUtGy0q8BoC4KsQAvD_BwE&gclsrc=aw.ds");

        String iphone = "iphone 14 pro";

        driver.findElement(By.xpath("//button[@id='consent_prompt_submit']")).click();
        Argos.wait(2000);
        driver.findElement(By.xpath("//input[@role='combobox']")).sendKeys(iphone);
        driver.findElement(By.xpath("//input[@role='combobox']")).submit();


        Argos.wait(2000);
        driver.findElement(By.xpath("//button[@data-test='price-facet-button-show-more']")).click();
        driver.findElement(By.xpath("//span[text()='£1000 - £2000']")).click();


        wait(4000);
        List<WebElement> allProductPrices = driver.findElements(By.xpath("//div[@data-test='component-product-card-price']/strong"));
        String product_price = "";
        List<WebElement> allProductTitles = driver.findElements(By.xpath("//a[@data-test='component-product-card-title']"));
        for (int i = 0; i < allProductPrices.size(); i++) {
            driver.findElements(By.xpath("//a[@data-test='component-product-card-title']"));
            String title = allProductTitles.get(i).getText();
            if (title.contains("iPhone 14 Pro") && title.contains("256GB") && title.contains("Gold")) {
                driver.findElements(By.xpath("//div[@data-test='component-product-card-price']/strong"));
                product_price = allProductPrices.get(i).getText();
                allProductTitles.get(i).click();
                break;
            }
        }
        wait(2000);
        driver.findElement(By.xpath("//button[@class='Buttonstyles__Button-sc-42scm2-2 cSktxC']")).click();
        Argos.wait(4000);
        driver.findElement(By.xpath("//a[@class='Buttonstyles__Button-sc-42scm2-2 cSktxC' and @data-test='component-att-button-basket']")).click();
        Argos.wait(3000);
        WebElement text = driver.findElements(By.xpath("//input[@data-test='fulfilment-localisation-edit']")).get(1); //2 differ versions of the element
        text.click();
        text.sendKeys("UB32NJ");
        Argos.wait(2000);
        driver.findElements(By.xpath("//button[@id='basket-FulfilmentSelectorForm-deliverButton']")).get(1).click();
        Argos.wait(2000);

        WebElement deliveryAvailable = driver.findElement(By.xpath("//button[@data-e2e='continue-with-delivery-button']"));
        WebElement collectionAvailable = driver.findElement(By.xpath("//button[@data-e2e='continue-with-collection-button']"));

            if (deliveryAvailable.isEnabled()) {
                deliveryAvailable.click();
                wait(2000);
                driver.findElement(By.xpath("//input[@class='form-group__input']")).sendKeys("thers3001@gmail.com");
                wait(2000);
                driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Wizardzx31!");
                driver.findElement(By.xpath("//input[@id='password']")).submit();
            } else if (collectionAvailable.isEnabled()) {
                collectionAvailable.click();
            } else {
                driver.quit();
                System.out.println("product is not available");
            }

    }


    public static void wait(int milliseconds){
        try {
            Thread.sleep(milliseconds); //this a type of waiting command
        }
        catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
