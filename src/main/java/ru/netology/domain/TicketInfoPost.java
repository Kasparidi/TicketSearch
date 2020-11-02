package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TicketInfoPost {
    int id;
    double coast;
    String departureAirport;
    String arrivalAirport;
    int travelTime;
}
