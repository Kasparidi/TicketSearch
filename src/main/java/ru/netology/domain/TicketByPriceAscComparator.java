package ru.netology.domain;

import ru.netology.domain.TicketInfoPost;

import java.util.Comparator;

public class TicketByPriceAscComparator implements Comparator<TicketInfoPost> {
    @Override
    public int compare(TicketInfoPost o1, TicketInfoPost o2) {
        return o1.getTravelTime() - o2.getTravelTime();
    }
}
