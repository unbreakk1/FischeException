import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class StudentService
{
    private final StudentRepo repo = new StudentRepo();

    public Student addNewStudent(Student newStudent)
    {
        Student studentToSave = newStudent.withId(UUID.randomUUID().toString()); // very funny :(
        return repo.save(studentToSave);
    }

    public List<Student> getAllStudents()
    {
        return repo.getAllStudents();
    }
}
