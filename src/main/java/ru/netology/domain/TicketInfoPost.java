package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TicketInfoPost implements Comparable <TicketInfoPost> {
    int id;
    int cost;
    String departureAirport;
    String arrivalAirport;
    int travelTime;

    @Override
    public int compareTo(TicketInfoPost o) {
        return cost - o.cost;
    }
}


