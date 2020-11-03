package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.TicketInfoPost;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);
    TicketInfoPost first = new TicketInfoPost(1, 444, "DME", "SHJ", 300);
    TicketInfoPost second = new TicketInfoPost(2, 222, "DME", "SHJ", 280);
    TicketInfoPost third = new TicketInfoPost(3, 333, "SVO", "VCE", 200);
    TicketInfoPost forth = new TicketInfoPost(4, 111, "DME", "SHJ", 280);
    TicketInfoPost fifth = new TicketInfoPost(5, 555, "DME", "VCE", 210);

    @BeforeEach
    public void SetUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);
        manager.add(fifth);
    }

    @Test
    void searchBy() {
        String from = "DME";
        String to = "SHJ";
        manager.searchBy(from, to);
        TicketInfoPost[] expected = new TicketInfoPost[] {forth, second, first};
        TicketInfoPost[] actual = new TicketInfoPost[] {first, second, forth};
        assertArrayEquals(expected, actual);
    }
}