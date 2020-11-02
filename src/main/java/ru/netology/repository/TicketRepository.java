package ru.netology.repository;

import ru.netology.domain.TicketInfoPost;

public class TicketRepository {
    private TicketInfoPost[] items = new TicketInfoPost[0];

    public void save(TicketInfoPost item) {
        int length = items.length + 1;
        TicketInfoPost[] tmp = new TicketInfoPost[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public TicketInfoPost[] findAll() {
        return items;
    }

    public void removeById (int id) {
        int length = items.length - 1;
        TicketInfoPost[] tmp = new TicketInfoPost[items.length];
        int index = 0;
        for (TicketInfoPost item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }
}
