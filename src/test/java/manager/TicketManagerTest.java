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
    TicketInfo ticket1 = new TicketInfo(53453,"ABA","LAC",500,120);
    TicketInfo ticket2 = new TicketInfo(96743,"ODA","KAZ",129,521);
    TicketInfo ticket3 = new TicketInfo(45678,"SAA","UAE",321,150);
    TicketInfo ticket4 = new TicketInfo(62920,"SAA","UAE",442,150);

    @BeforeEach
    public void SetUp() {
        ticketManager.add(ticket1);
        ticketManager.add(ticket2);
        ticketManager.add(ticket3);
        ticketManager.add(ticket4);
    }
    @Test
    void findAllFromToWithSort() {


        TicketInfo[] expected = new TicketInfo[]{ticket3,ticket4};
        TicketInfo[] actual = ticketManager.findAllFromTo("UAE","SAA");
        Arrays.sort(actual);


        assertArrayEquals(expected,actual);
    }
}