package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.TicketByPriceAscComparator;
import ru.netology.domain.TicketInfoPost;
import ru.netology.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);
    TicketByPriceAscComparator comparator = new TicketByPriceAscComparator();
    TicketInfoPost first = new TicketInfoPost(1, 444, "DME", "SHJ", 300);
    TicketInfoPost second = new TicketInfoPost(2, 222, "DME", "SHJ", 270);
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
    void searchByFromTo() {
        String from = "DME";
        String to = "SHJ";
        manager.searchBy(from, to);
        TicketInfoPost[] actual = manager.searchBy("DME", "SHJ");
        TicketInfoPost[] expected = new TicketInfoPost[] {forth, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByFromToAnotherData() {
        String from = "SVO";
        String to = "VCE";
        manager.searchBy(from, to);
        TicketInfoPost[] actual = manager.searchBy("SVO", "VCE");
        TicketInfoPost[] expected = new TicketInfoPost[] {third};
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchIfNotExist() {
        String from = "SHJ";
        String to = "DME";
        manager.searchBy(from, to);
        TicketInfoPost[] actual = manager.searchBy("SHJ", "DME");
        TicketInfoPost[] expected = new TicketInfoPost[] {};
        assertArrayEquals(expected, actual);
    }

    @Test
    void sortTravelTime() {
        String from = "DME";
        String to = "SHJ";
        manager.findAll(from, to, comparator);
        TicketInfoPost[] actual = manager.findAll("DME", "SHJ", comparator);
        TicketInfoPost[] expected = new TicketInfoPost[] {second, forth, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    void sortTravelTimeAnotherData() {
        String from = "SVO";
        String to = "VCE";
        manager.findAll(from, to, comparator);
        TicketInfoPost[] actual = manager.findAll("SVO", "VCE", comparator);
        TicketInfoPost[] expected = new TicketInfoPost[] {third};
        assertArrayEquals(expected, actual);
    }

    @Test
    void sortIfNotExist() {
        String from = "SHJ";
        String to = "DME";
        manager.findAll(from, to, comparator);
        TicketInfoPost[] actual = manager.findAll("SHJ", "DME", comparator);
        TicketInfoPost[] expected = new TicketInfoPost[] {};
        assertArrayEquals(expected, actual);
    }
}