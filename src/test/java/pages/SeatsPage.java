package pages;

import org.openqa.selenium.By;

public class SeatsPage {
    BaseFunc baseFunc;
    private final By SEAT_NR = By.xpath(".//div[@onclick = 'seat(15)']");
    private final By BOOK_BTN = By.xpath(".//span[@id = 'book3']");

    public SeatsPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void selectSeat() {
        baseFunc.getElement(SEAT_NR).click();
    }

    public void clickBookBtn() {
        baseFunc.getElement(BOOK_BTN).click();
    }

}
