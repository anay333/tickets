package domain;

import manager.TicketManager;
import org.junit.jupiter.api.Test;
import repository.InfoRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicketInfoTest {
    InfoRepository infoRepository = new InfoRepository();
    TicketInfo ticket1 = new TicketInfo(53453,"ABA","LAC",500,120);
    TicketInfo ticket2 = new TicketInfo(96743,"ODA","KAZ",129,521);
    TicketInfo ticket3 = new TicketInfo(45678,"SAA","UAE",321,150);
    TicketInfo ticket4 = new TicketInfo(62920,"SAA","UAE",442,150);


    @Test
    void shouldSortByPrice() {
         TicketInfo[] expected = new TicketInfo[]{ticket2,ticket3,ticket4,ticket1};
         TicketInfo[] actual = new TicketInfo[]{ticket1,ticket2,ticket3,ticket4};

         Arrays.sort(actual);

         assertArrayEquals(expected,actual);
    }


}