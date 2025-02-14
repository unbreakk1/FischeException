import lombok.Data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
@Data
public class GuestList
{
    private List<String> guests;
    private static final Path FILE_PATH = Path.of("guests.txt");

    public GuestList()
    {
        try
        {
            if (Files.exists(FILE_PATH))
                guests = Files.readAllLines(FILE_PATH);
            else
                guests = Collections.emptyList();
        }
        catch (IOException e)
        {
            throw new RuntimeException("Failed to read from file", e);
        }
    }

    public void setGuests(List<String> guests)
    {
        this.guests = guests;
        try
        {
            Files.write(FILE_PATH, guests);
        }
        catch (IOException e)
        {
            throw new RuntimeException("Failed to write to file", e);
        }
    }

    public List<String> getGuests()
    {
        return guests;
    }

}