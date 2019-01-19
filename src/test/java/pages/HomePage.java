package pages;

import org.openqa.selenium.By;

public class HomePage {
    BaseFunc baseFunc;
    private final By DEPARTURE_DROPDOWN = By.xpath(".//select[@id = 'afrom']");
    private final By ARRIVAL_DROPDOWN = By.xpath(".//select[@id = 'bfrom']");
    private final By GO_BTN = By.xpath(".//span[@class = 'gogogo']");

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void getDepartureAirport(String departure) {
        baseFunc.selectFromDropDown(DEPARTURE_DROPDOWN, departure);
    }

    public void getArrivalAirport(String arrival) {
        baseFunc.selectFromDropDown(ARRIVAL_DROPDOWN, arrival);
    }

    public ReservationPage clickGoBtn() {
        baseFunc.getElement(GO_BTN);
        return new ReservationPage(baseFunc);
    }

}
