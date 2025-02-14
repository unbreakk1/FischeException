import lombok.Data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
@Data
public class GuestList
{
    List<String> guests;

    public void setGuests(List<String> guests)
    {
        this.guests = guests;

        Path filePath = Path.of("guests.txt");
        try
        {
            Files.write(filePath, guests);
        }
        catch (IOException e)
        {
            throw new RuntimeException("Failed to write to file", e);
        }

    }
}