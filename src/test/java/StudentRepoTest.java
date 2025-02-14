import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StudentRepoTest
{
    @Test
    void testFindByIdReturnsStudentIfFound()
    {
        StudentRepo repo = new StudentRepo();
        Student student = new Student("1", "John Doe", "john.doe@example.com");
        repo.save(student);

        Student foundStudent = repo.findById("1");

        assertEquals(student, foundStudent);
    }

    @Test
    void testFindByIdThrowsExceptionIfNotFound()
    {
        StudentRepo repo = new StudentRepo();

        StudentNotFoundException exception = assertThrows(StudentNotFoundException.class,
                () -> repo.findById("non-existing-id"));

        assertEquals("Student with ID non-existing-id not found", exception.getMessage());
    }

}
