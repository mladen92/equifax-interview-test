package equifax_amazon_test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.AmazonPage;
import utilities.Driver;

public class EquifaxTest {


    @Test
    public void amazonTest() {
        final String SEARCH_ITEM = "qa testing for beginners";
        AmazonPage amazonPage = new AmazonPage();
        WebDriverWait wait = new WebDriverWait(Driver.get(), 5);

        // step 1
        Driver.get().get("https://www.amazon.com/");

        // step 2
        amazonPage.enterInAmazonSearchBox(SEARCH_ITEM);
        amazonPage.amazonSearchBox.sendKeys(Keys.ENTER);

        // step 3
        wait.until(ExpectedConditions.visibilityOf(amazonPage.firstPriceInSearchResults));
        String expectedPrice = amazonPage.firstPriceInSearchResults.getText().replace("\n", ".");
        amazonPage.firstLinkInSearchResults.click();

        // step 4
        wait.until(ExpectedConditions.visibilityOf(amazonPage.byNewItemPrice));
        Assert.assertEquals("Price doesn't match", expectedPrice, amazonPage.byNewItemPrice.getText());

        // step 5
        amazonPage.addToCartButton.click();

        // step 6
        wait.until(ExpectedConditions.visibilityOf(amazonPage.proceedToCheckoutPrice));
        Assert.assertEquals("Price doesn't match", expectedPrice, amazonPage.proceedToCheckoutPrice.getText());

        // step 7
        amazonPage.proceedToCheckoutButton.click();
        wait.until(ExpectedConditions.visibilityOf(amazonPage.firstCheckoutItemPrice));
        Assert.assertEquals("Price doesn't match", expectedPrice, amazonPage.firstCheckoutItemPrice.getText());
    }
    @After
    public void tearDown(){
        Driver.get().quit();
    }
}
