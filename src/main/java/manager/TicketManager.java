package manager;

import domain.TicketInfo;
import repository.InfoRepository;

import java.util.Arrays;

public class TicketManager {
    private InfoRepository repository;

    public TicketManager(InfoRepository repository) {
        this.repository = repository;
    }

    public void add(TicketInfo ticket) {
        repository.save(ticket);
    }

    public TicketInfo[] findAllFromTo(String from, String to) {
        TicketInfo[] result = new TicketInfo[0];
        for (TicketInfo ticket : repository.findAll()) {
            if (matches(ticket, from, to)) {
                TicketInfo[] tmp = new TicketInfo[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                result = tmp;
                Arrays.sort(result);
            }

        }
        return result;

    }

    public boolean matches(TicketInfo ticket, String searchFrom, String searchTo) {
        if (ticket.getFrom().contains(searchFrom) && (ticket.getTo().contains(searchTo))) {
            return true;
        }
        return false;
    }

}



