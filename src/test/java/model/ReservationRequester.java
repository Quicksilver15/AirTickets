package model;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.client.RestTemplate;
import java.io.IOException;

public class ReservationRequester {
    private final String url = "http://qaguru.lv:8090/tickets/getReservations.php";

    public Response getReservationList() throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        String responseToParse = restTemplate.getForEntity(url, String.class).getBody();

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(responseToParse, Response.class);
    }

}
