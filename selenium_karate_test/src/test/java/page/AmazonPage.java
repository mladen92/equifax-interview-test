package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonPage {

    public AmazonPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "twotabsearchtextbox")
    public WebElement amazonSearchBox;

    @FindBy(xpath = "(//span[@class='a-price'])[1]")
    public WebElement firstPriceInSearchResults;

    @FindBy(xpath = "//*[@data-component-id='1']/a")
    public WebElement firstLinkInSearchResults;

    @FindBy(id = "newBuyBoxPrice")
    public WebElement byNewItemPrice;

    @FindBy(id = "add-to-cart-button")
    public WebElement addToCartButton;

    @FindBy(xpath = "//*[contains(text(),'Proceed to checkout')]")
    public WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//*[contains(@class,'huc-subtotal')]/span[2]")
    public WebElement proceedToCheckoutPrice;

    @FindBy(xpath = "//*[contains(@class,'huc-subtotal')]/span[2]")
    public WebElement firstCheckoutItemPrice;


    public void enterInAmazonSearchBox(String inputText) {
        amazonSearchBox.sendKeys(inputText);
    }


}
