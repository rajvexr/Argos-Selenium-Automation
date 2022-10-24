package com.argos.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Setup {

    public static WebDriver driver;

    @BeforeSuite
    public static void setUpDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.argos.co.uk/?&_$ja=tsid:11705%7cacid:224-060-0086%7ccid:94668565%7cagid:4507124965%7ctid:kwd-18880610%7ccrid:535779513013%7cnw:g%7crnd:10756228396553342366%7cdvc:c%7cadp:%7cmt:e%7cloc:9046086&utm_source=Google&utm_medium=cpc&utm_campaign=94668565&utm_term=argos&utm_content=text&utm_custom1=4507124965&utm_custom2=224-060-0086&cmpid=GG05X&GPDP=true&gclid=CjwKCAjwwL6aBhBlEiwADycBIMFYxGnz42sQPcEesKjB9BWs3N4b0_ayQL1cF6DuhzRCIbUtGy0q8BoC4KsQAvD_BwE&gclsrc=aw.ds");
    }


//    @AfterSuite
//    public static void tearDownDriver() {
//        driver.quit();
//    }

}