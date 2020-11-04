package ru.netology.manager;

import ru.netology.domain.TicketInfoPost;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;
import java.util.Comparator;

public class TicketManager {
    private TicketRepository repository;
    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public void add(TicketInfoPost item) {
        repository.save(item);
    }

    public TicketInfoPost[] searchBy(String from, String to) {
        TicketInfoPost[] items = new TicketInfoPost[0];
        for (TicketInfoPost item: repository.findAll()) {
            if (item.getDepartureAirport().equals(from) && item.getArrivalAirport().equals(to)) {
                TicketInfoPost[] tmp = new TicketInfoPost[items.length + 1];
                System.arraycopy(items, 0, tmp, 0, items.length);
                tmp[tmp.length - 1] = item;
                items = tmp;
            }
        }
        Arrays.sort(items);
        return items;
    }

    public TicketInfoPost[] findAll(String from, String to, Comparator<TicketInfoPost> comparator) {
        TicketInfoPost[] items = new TicketInfoPost[0];
        for (TicketInfoPost item: repository.findAll()) {
            if (item.getDepartureAirport().equals(from) && item.getArrivalAirport().equals(to)) {
                TicketInfoPost[] tmp = new TicketInfoPost[items.length + 1];
                System.arraycopy(items, 0, tmp, 0, items.length);
                tmp[tmp.length - 1] = item;
                items = tmp;
            }
        }
        Arrays.sort(items, comparator);
        return items;
    }
}
