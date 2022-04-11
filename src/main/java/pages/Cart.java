package pages;

import extensions.Element;
import io.qameta.allure.Step;
import org.openqa.selenium.support.How;



public class Cart extends BasePage {

    private Element item_name = new Element(How.XPATH, "//*[@id=\"item_5_title_link\"]/div");
    private Element item_add_button = new Element(How.XPATH, "//*[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]");
    private Element shopping_cart = new Element(How.XPATH, "//*[@id=\"shopping_cart_container\"]/a");
    private Element check_text = new Element(How.XPATH, "//*[@id=\"item_5_title_link\"]/div");
    private Element remove_order = new Element(How.XPATH, "//*[@class=\"btn btn_secondary btn_small cart_button\"] ");




    @Step("Add to cart")
    public Cart clickButton1() {
        item_name.click();
        return Pages.checkButton;
    }

    public Cart clickAddButton(){
        item_add_button.click();
        return Pages.checkButton;
    }

    public Cart clickCart() {
        shopping_cart.click();
        return  Pages.checkButton;
    }

   public Cart checkOrder(String order){
       check_text.equals(order);
       return this;
   }


    @Step("Delete from cart")

    public Cart removeClick(){
        remove_order.click();
        return  Pages.checkButton;
    }


}
