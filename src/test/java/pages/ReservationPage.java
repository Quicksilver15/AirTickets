package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ReservationPage {
    BaseFunc baseFunc;
    private final By REGISTRATION_FORM = By.xpath(".//div[@id = 'fullForm']");
    private final By NAME = By.xpath(".//input[@id = 'name']");
    private final By SURNAME = By.xpath(".//input[@id = 'surname']");
    private final By DISCOUNT = By.xpath(".//input[@id = 'discount']");
    private final By ADULT_COUNT = By.xpath(".//input[@id = 'adults']");
    private final By CHILDREN_COUNT = By.xpath(".//input[@id = 'children']");
    private final By LUGGAGE_COUNT = By.xpath(".//input[@id = 'bugs']");
    private final By NEXT_FLIGHT = By.xpath(".//input[@id = 'flight']");
    private final By GET_PRICE = By.xpath(".//span[@onclick = 'setLang();']");
    private final By BOOK_BTN = By.xpath(".//span[@id = 'book2']");
    private final By TOTAL_PRICE = By.xpath(".//div[@class = 'responsePrice']");


    public ReservationPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void enterName(String text) {
        WebElement field = baseFunc.getElement(REGISTRATION_FORM).findElement(NAME);
        baseFunc.writeInTextField(field, text);
    }

    public void enterSurname(String text) {
        WebElement field = baseFunc.getElement(REGISTRATION_FORM).findElement(SURNAME);
        baseFunc.writeInTextField(field, text);
    }

    public void enterDiscountCode(String value) {
        WebElement field = baseFunc.getElement(REGISTRATION_FORM).findElement(DISCOUNT);
        baseFunc.writeInTextField(field, value);
    }

    public void enterAdultCount(String value) {
        WebElement field = baseFunc.getElement(REGISTRATION_FORM).findElement(ADULT_COUNT);
        baseFunc.writeInTextField(field, value);
    }

    public void enterChildrenCount(String value) {
        WebElement field = baseFunc.getElement(REGISTRATION_FORM).findElement(CHILDREN_COUNT);
        baseFunc.writeInTextField(field, value);
    }

    public void enterLuggageCount(String value) {
        WebElement field = baseFunc.getElement(REGISTRATION_FORM).findElement(LUGGAGE_COUNT);
        baseFunc.writeInTextField(field, value);
    }

    public void selectNextFlight(String value) {
        baseFunc.selectFromDropDown(NEXT_FLIGHT, value);
    }

    public void getPrice() {
        baseFunc.getElement(REGISTRATION_FORM).findElement(GET_PRICE).click();
    }

    public void clickBookBtn() {
        baseFunc.getElement(BOOK_BTN).click();
    }

    public void priceCalculation() {
        Integer adultPrice = 700;
        Integer luggagePrice = 20;
        Integer discountAmount = 55;
        Integer sumOfPrice = adultPrice + luggagePrice - discountAmount;

        String messageWithPrice = baseFunc.getElement(TOTAL_PRICE).getText();
        Integer totalPrice = Integer.valueOf(messageWithPrice.substring(55, messageWithPrice.length() -40));

        Assertions.assertEquals(totalPrice, sumOfPrice, "Incorrect price calculation");
    }

}
