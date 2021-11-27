package manager;

import domain.TicketInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.InfoRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    InfoRepository infoRepository = new InfoRepository();
    TicketManager ticketManager = new TicketManager(infoRepository);
    TicketInfo ticket1 = new TicketInfo(53453, "ABA", "LAC", 500, 120);
    TicketInfo ticket2 = new TicketInfo(96743, "ODA", "KAZ", 129, 521);
    TicketInfo ticket3 = new TicketInfo(45678, "SAA", "UAE", 621, 150);
    TicketInfo ticket4 = new TicketInfo(62920, "SAA", "UAE", 442, 150);
    TicketInfo ticket5 = new TicketInfo(62920, "SAA", "UAE", 742, 775);
    TicketInfo ticket6 = new TicketInfo(62920, "SAA", "UAE", 343, 640);
    TicketInfo ticket7 = new TicketInfo(62920, "SAA", "UAE", 552, 65);
    TicketInfo ticket8 = new TicketInfo(62920, "SAA", "UAE", 890, 134);

    @BeforeEach
    public void SetUp() {

        ticketManager.add(ticket1);
        ticketManager.add(ticket2);
        ticketManager.add(ticket3);
        ticketManager.add(ticket4);
        ticketManager.add(ticket5);
        ticketManager.add(ticket6);
        ticketManager.add(ticket7);
        ticketManager.add(ticket8);
    }

    @Test
    void findAllFromToWithSort() {

        TicketInfo[] expected = new TicketInfo[]{ticket6, ticket4, ticket7, ticket3, ticket5, ticket8};
        TicketInfo[] actual = ticketManager.findAllFromTo("UAE", "SAA");

        assertArrayEquals(expected, actual);
    }

    @Test
    void findAllFromToWhenResultEmpty() {

        TicketInfo[] expected = new TicketInfo[]{};
        TicketInfo[] actual = ticketManager.findAllFromTo("URD", "CAS");

        assertArrayEquals(expected, actual);
    }

    @Test
    void findAllFromToWhenOneResult() {

        TicketInfo[] expected = new TicketInfo[]{ticket1};
        TicketInfo[] actual = ticketManager.findAllFromTo("LAC", "ABA");

        assertArrayEquals(expected, actual);
    }
}