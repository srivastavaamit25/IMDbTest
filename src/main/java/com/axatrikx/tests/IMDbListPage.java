package com.axatrikx.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.axatrikx.WebDriverHelper;

public class IMDbListPage {
    private static final String URL = "http://www.imdb.com/chart/top";
    private WebDriver driver;

    @BeforeClass
    @Parameters("browser")
    public void beforeClass(String browser) {
        driver = new WebDriverHelper().initDriver(browser);
    }

    @Test
    @Parameters("title")
    public void verifyIMDbList(String actualTitle) throws InterruptedException {
        driver.get(URL);
        String title = driver.getTitle();
        // Verify title
        System.out.println(title);
        Assert.assertEquals(actualTitle, title, "Incorrect Title");
        // perform search for movie list on Sort By filter.
        {
        	Assert.assertTrue(driver.findElement(By.name("sort")).isDisplayed(),
                    "Sort By is not shown");
        	Select MovieSortBy=new Select(driver.findElement(By.name("sort")));
        	     	
        	List<WebElement> elementCount = MovieSortBy.getOptions();
        	System.out.println("Number of items: " + elementCount.size());
        	for(int i=0; i<elementCount.size(); i++){
        		String optionsValue = elementCount.get(i).getText().trim();
                System.out.println(optionsValue);
                //Select the Sort By filter option.
                driver.findElement(By.name("sort")).sendKeys(optionsValue);
                Thread.sleep(10000);       	
               
            //Get the first movie name on sort by filter option. 
        	String moviename = driver.findElement(By.xpath(".//*[@id='main']/div/span/div/div/div[3]/table/tbody/tr[1]/td[2]/a")).getText();
        	System.out.println(moviename);             
	  }
        	
        }}
    @AfterClass
    public void afterClass() {
        driver.quit();
    }    
}