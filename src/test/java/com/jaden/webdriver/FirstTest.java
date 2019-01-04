package com.jaden.webdriver;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstTest {

    private WebDriver driver = new FirefoxDriver();
    private String testURL = "http://seleniumtest.gear.host/#pgRegister";

    @Test
    public void QualityCarSalesSearchPage_H2TitleSaysRegisteredUsedCars(){
        driver.navigate().to("http://seleniumtest.gear.host/#pgSearch");
        String title = driver.findElement(By.id("searchTitle")).getText();
        Assert.assertEquals("Registered used cars", title);
        driver.close();
    }

    @Test
    public void QualityCarSales_InputDodgeJourney2013_DodgeJourney2013AppearsInJDCPageTitle(){
        ExpectedCondition <Boolean> expectation = new ExpectedCondition <Boolean>() {
                    public Boolean apply (WebDriver driver) {
                        return driver.getTitle().contains("2013 Dodge Journey");
                    }
                };

        driver.navigate().to(testURL);
        driver.findElement(By.id("txtName")).clear();
        driver.findElement(By.id("txtName")).sendKeys("Jaden Ahn");
        driver.findElement(By.id("txtAddress")).clear();
        driver.findElement(By.id("txtAddress")).sendKeys("123 Brookfield Drive");
        driver.findElement(By.id("txtCity")).clear();
        driver.findElement(By.id("txtCity")).sendKeys("Kitchener");
        driver.findElement(By.id("txtPhone")).clear();
        driver.findElement(By.id("txtPhone")).sendKeys("236-879-2457");
        driver.findElement(By.id("txtEmail")).clear();
        driver.findElement(By.id("txtEmail")).sendKeys("jahn2488@conestogac.on.ca");
        driver.findElement(By.id("txtMake")).clear();
        driver.findElement(By.id("txtMake")).sendKeys("Dodge");
        driver.findElement(By.id("txtModel")).clear();
        driver.findElement(By.id("txtModel")).sendKeys("Journey");
        driver.findElement(By.id("txtYear")).clear();
        driver.findElement(By.id("txtYear")).sendKeys("2013");
        driver.findElement(By.id("btnRegister")).click();
        driver.findElement(By.id("linkToJDC")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(expectation);
        driver.close();
    }
    @Test
    public void QualityCarSales_InputWrongPhoneFormat_txtPhoneErrorSaysWrongFormat()
    {
        driver.navigate().to(testURL);
        driver.findElement(By.id("txtName")).clear();
        driver.findElement(By.id("txtName")).sendKeys("Aubrey");
        driver.findElement(By.id("txtAddress")).clear();
        driver.findElement(By.id("txtAddress")).sendKeys("456 Kingway Drive");
        driver.findElement(By.id("txtCity")).clear();
        driver.findElement(By.id("txtCity")).sendKeys("Guelph");
        driver.findElement(By.id("txtPhone")).clear();
        driver.findElement(By.id("txtPhone")).sendKeys("1234567890");
        driver.findElement(By.id("txtEmail")).clear();
        driver.findElement(By.id("txtEmail")).sendKeys("aub@gmail.com");
        driver.findElement(By.id("txtMake")).clear();
        driver.findElement(By.id("txtMake")).sendKeys("Lamborghini");
        driver.findElement(By.id("txtModel")).clear();
        driver.findElement(By.id("txtModel")).sendKeys("Murcielago");
        driver.findElement(By.id("txtYear")).clear();
        driver.findElement(By.id("txtYear")).sendKeys("2010");
        driver.findElement(By.id("btnRegister")).click();

        String error = driver.findElement(By.id("txtPhone-error")).getText();
        Assert.assertEquals("Wrong format", error);
        driver.close();
    }

    @Test
    public void QualityCarSales_NotInputName_txtNameErrorSaysSellerNameRequired()
    {
        driver.navigate().to(testURL);
        driver.findElement(By.id("txtName")).clear();
        driver.findElement(By.id("txtAddress")).clear();
        driver.findElement(By.id("txtAddress")).sendKeys("456 Kingway Drive");
        driver.findElement(By.id("txtCity")).clear();
        driver.findElement(By.id("txtCity")).sendKeys("Waterloo");
        driver.findElement(By.id("txtPhone")).clear();
        driver.findElement(By.id("txtPhone")).sendKeys("(236)879-2458");
        driver.findElement(By.id("txtEmail")).clear();
        driver.findElement(By.id("txtEmail")).sendKeys("aub@gmail.com");
        driver.findElement(By.id("txtMake")).clear();
        driver.findElement(By.id("txtMake")).sendKeys("Lamborghini");
        driver.findElement(By.id("txtModel")).clear();
        driver.findElement(By.id("txtModel")).sendKeys("Murcielago");
        driver.findElement(By.id("txtYear")).clear();
        driver.findElement(By.id("txtYear")).sendKeys("2010");
        driver.findElement(By.id("btnRegister")).click();

        String error = driver.findElement(By.id("txtName-error")).getText();
        driver.close();

        Assert.assertEquals("Seller Name required", error);
    }

    @Test
    public void QualityCarSales_NotInputAddress_txtAddressErrorSaysAddressRequired()
    {
        driver.navigate().to(testURL);
        driver.findElement(By.id("txtName")).clear();
        driver.findElement(By.id("txtName")).sendKeys("Chevy");
        driver.findElement(By.id("txtAddress")).clear();
        driver.findElement(By.id("txtCity")).clear();
        driver.findElement(By.id("txtCity")).sendKeys("Waterloo");
        driver.findElement(By.id("txtPhone")).clear();
        driver.findElement(By.id("txtPhone")).sendKeys("236-879-2458");
        driver.findElement(By.id("txtEmail")).clear();
        driver.findElement(By.id("txtEmail")).sendKeys("aub@gmail.com");
        driver.findElement(By.id("txtMake")).clear();
        driver.findElement(By.id("txtMake")).sendKeys("Lamborghini");
        driver.findElement(By.id("txtModel")).clear();
        driver.findElement(By.id("txtModel")).sendKeys("Murcielago");
        driver.findElement(By.id("txtYear")).clear();
        driver.findElement(By.id("txtYear")).sendKeys("2010");
        driver.findElement(By.id("btnRegister")).click();

        String error = driver.findElement(By.id("txtAddress-error")).getText();
        driver.close();

        Assert.assertEquals("Address required", error);
    }

    @Test
    public void QualityCarSales_NotInputCity_txtCityErrorSaysCityRequired()
    {
        driver.navigate().to(testURL);
        driver.findElement(By.id("txtName")).clear();
        driver.findElement(By.id("txtName")).sendKeys("Chevy");
        driver.findElement(By.id("txtAddress")).clear();
        driver.findElement(By.id("txtAddress")).sendKeys("456 Kingway Drive");
        driver.findElement(By.id("txtCity")).clear();
        driver.findElement(By.id("txtPhone")).clear();
        driver.findElement(By.id("txtPhone")).sendKeys("236-879-2458");
        driver.findElement(By.id("txtEmail")).clear();
        driver.findElement(By.id("txtEmail")).sendKeys("aub@gmail.com");
        driver.findElement(By.id("txtMake")).clear();
        driver.findElement(By.id("txtMake")).sendKeys("Lamborghini");
        driver.findElement(By.id("txtModel")).clear();
        driver.findElement(By.id("txtModel")).sendKeys("Murcielago");
        driver.findElement(By.id("txtYear")).clear();
        driver.findElement(By.id("txtYear")).sendKeys("2010");
        driver.findElement(By.id("btnRegister")).click();

        String error = driver.findElement(By.id("txtCity-error")).getText();
        driver.close();

        Assert.assertEquals("City required", error);
    }

    @Test
    public void QualityCarSales_InputWrongEmailFormat_txtEmailErrorSaysWrongFormat()
    {
        driver.navigate().to(testURL);
        driver.findElement(By.id("txtName")).clear();
        driver.findElement(By.id("txtName")).sendKeys("Brad");
        driver.findElement(By.id("txtAddress")).clear();
        driver.findElement(By.id("txtAddress")).sendKeys("789 Somewhere Street");
        driver.findElement(By.id("txtCity")).clear();
        driver.findElement(By.id("txtCity")).sendKeys("Cambridge");
        driver.findElement(By.id("txtPhone")).clear();
        driver.findElement(By.id("txtPhone")).sendKeys("245-121-2451");
        driver.findElement(By.id("txtEmail")).clear();
        driver.findElement(By.id("txtEmail")).sendKeys("brad.gmail.com");
        driver.findElement(By.id("txtMake")).clear();
        driver.findElement(By.id("txtMake")).sendKeys("Porsche");
        driver.findElement(By.id("txtModel")).clear();
        driver.findElement(By.id("txtModel")).sendKeys("Cayman");
        driver.findElement(By.id("txtYear")).clear();
        driver.findElement(By.id("txtYear")).sendKeys("2012");
        driver.findElement(By.id("btnRegister")).click();

        String error = driver.findElement(By.id("txtEmail-error")).getText();
        driver.close();

        Assert.assertEquals("Please enter a valid email address.", error);
    }
}
