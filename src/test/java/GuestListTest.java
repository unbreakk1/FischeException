import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GuestListTest
{
    private final Path filePath = Path.of("guests.txt");

    @AfterEach
    public void cleanUp() throws IOException
    {
        Files.deleteIfExists(filePath);
    }

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

        List<String> inputGuests = List.of("Karl", "Ute");
        guestList.setGuests(inputGuests);

        List<String> guests = guestList.getGuests();

        assertEquals(inputGuests, guests, "The guest list returned is not the same as the one set.");
    }

    @Test
    public void shouldWriteToFileSystem() throws IOException
    {
        GuestList guestList = new GuestList();

        List<String> guests = List.of("Theodor", "Anette");
        guestList.setGuests(guests);

        assertTrue(Files.exists(filePath), "The file guests.txt should be created.");

        List<String> fileContent = Files.readAllLines(filePath);

        assertEquals(guests, fileContent, "The content of guests.txt does not match the list of guests.");
    }

}