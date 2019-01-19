import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.ReservationRequester;
import model.Response;
import pages.*;

import java.io.IOException;
import java.util.Map;

public class reservationTicketStepDefs {
    private String departure;
    private String arrival;
    private Integer seatNumber;
    private Integer price;
    private UserData userData = new UserData();
    private BaseFunc baseFunc = new BaseFunc();
    private final String HOME_PAGE = "http://www.qaguru.lv:8090/tickets";
    private HomePage homePage;
    private ReservationPage reservationPage;
    private SeatsPage seatsPage;
    private SuccessfulReservationPage successfulReservationPage;
    private ReservationRequester requester = new ReservationRequester();
    private Response response;


    @Given("departure airport (.*)")
    public void set_departure_airport() {
        this.departure = departure;
    }

    @Given("arrival airport (.*)")
    public void set_arrival_airport() {
        this.arrival = arrival;
    }

    @Given("user data is:")
    public void set_user_data(Map<String,String> params) {
        userData.setName(params.get("name"));
        userData.setSurname(params.get("surname"));
        userData.setDiscountCode(params.get("discountCode"));
        userData.setTravellerCount(Integer.valueOf(params.get("travelerCount")));
        userData.setChildrenCount(Integer.valueOf(params.get("children")));
        userData.setLuggugeCount(Integer.valueOf(params.get("luggage")));
        userData.setNextflight(params.get("nextFlight"));
    }

    @Given("seat number is (.*)")
        public void set_seat_number(Integer seatNumber) { this.seatNumber = seatNumber; }


    @Given("we are on home page")
    public void home_page() {
        baseFunc.goToPage(HOME_PAGE);
        homePage = new HomePage(baseFunc);
    }

    @When("we are selecting departure airport")
    public void select_departure_airport(String departure) {
        homePage.getDepartureAirport(departure);
    }

    @When("we are selecting arrival airport")
    public void select_arrival_airport(String arrival) {
        homePage.getArrivalAirport(arrival);
    }


    @When("we are pressing Go Go Go button")
    public void press_button() {
        homePage.clickGoBtn();
    }

    @Then("registration page appears")
    public void check_registration_page() {
        reservationPage = new ReservationPage(baseFunc);
    }

    @When("we are filling registration form")
    public void fill_registration_form() {
        reservationPage.enterName("Donald");
        reservationPage.enterSurname("Trump");
        reservationPage.enterDiscountCode("CCCCCC");
        reservationPage.enterAdultCount("1");
        reservationPage.enterChildrenCount("0");
        reservationPage.enterLuggageCount("1");
        reservationPage.selectNextFlight("17-05-2018");
    }

    @When("we are pressing Get Price button")
    public void press_getPrice_button() {
        reservationPage.getPrice();
    }

    @Then("our price will be (.*) euro")
    public void price_check(Integer price) { reservationPage.priceCalculation();
    }

    @When("we are pressing Book button")
    public void press_bookButton() {
        reservationPage.clickBookBtn();
    }

    @Then("we are on select seats page")
    public void seats_page() {
        seatsPage = new SeatsPage(baseFunc);
    }

    @When("we are selecting our seats number")
    public void select_seats_number() {
        seatsPage.selectSeat();
    }

    @When("we are clicking Book button")
    public void click_bookButton() {
        seatsPage.clickBookBtn();
    }

    @Then("successful reservation page appears")
    public void reg_page_appears() {
        successfulReservationPage = new SuccessfulReservationPage(baseFunc);
    }

    @When("we are requesting reservation list")
    public void request_reg_list() throws IOException {
        response = requester.getReservationList();
    }

    @Then("we see our reservation in the list")
    public void check_reservation_in_list() {

    }

    @When("we are deleting our reservation")
    public void delete_reserved_tickets() {
    }

    @When("we are requesting our reservation list again")
    public void request_registration_list_again() throws IOException {
        requester.getReservationList();
    }

    @Then("our reservation disappears from the list")
    public void reservation_disappears_from_list() {

    }

}
