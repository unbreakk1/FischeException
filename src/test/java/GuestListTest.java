import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GuestListTest
{

    @Test
    public void shouldBeEmptyInitially()
    {
        GuestList guestList = new GuestList();

        guestList.setGuests(Collections.emptyList());

        List<String> guests = guestList.getGuests();

        assertTrue(guests.isEmpty(), "Guest list should be empty initially.");
    }

    @Test
    public void shouldReadSameGuestsAsWrittenBefore()
    {
        GuestList guestList = new GuestList();

        List<String> inputGuests = Arrays.asList("Karl", "Ute");
        guestList.setGuests(inputGuests);

        List<String> guests = guestList.getGuests();

        assertEquals(inputGuests, guests, "The guest list returned is not the same as the one set.");
    }

}