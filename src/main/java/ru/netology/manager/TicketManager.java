package ru.netology.manager;

import ru.netology.domain.TicketInfoPost;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

public class TicketManager {
    private TicketRepository repository;
    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    private TicketInfoPost[] items = new TicketInfoPost[0];

    public void add(TicketInfoPost item) {
        repository.save(item);
    }

    public TicketInfoPost[] searchBy(String from, String to) {
        TicketInfoPost[] result = new TicketInfoPost[0];
        for (TicketInfoPost item: repository.findAll()) {
            if (item.getDepartureAirport() == from) {
                TicketInfoPost[] tmp = new TicketInfoPost[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = item;
                result = tmp;
            }
            if (item.getArrivalAirport() == to) {
                TicketInfoPost[] tmp = new TicketInfoPost[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = item;
                result = tmp;
            }
        }
        Arrays.sort(items);
        return result;
    }

    public void removeById(int id) {
        repository.removeById(id);
    }
}
