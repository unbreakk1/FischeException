public class Main
{
    public static void main(String[] args)
    {
        StudentService studentService = new StudentService();
        StudentRepo studentRepo = new StudentRepo();

        Student newStudent1 = Student.builder()
                .id("001")
                .name("Florian")
                .subject("History")
                .build();

        Student newStudent2 = Student.builder()
                .id("002")
                .name("Sophia")
                .subject("Math")
                .build();

        studentService.addNewStudent(newStudent1);
        studentService.addNewStudent(newStudent2);

        System.out.println("=== Retrieve Student by ID '001' or not? ===");
        try
        {
            Student retrievedStudent = studentRepo.findById("001");
            System.out.println("Student found: " + retrievedStudent);
        }
        catch (StudentNotFoundException e)
        {
            System.err.println(e.getMessage());
        }

        System.out.println("\n=== Attempt to Retrieve Non-Existing Student by ID '999' ===");
        try
        {
            Student missingStudent = studentRepo.findById("999");
            System.out.println("Student found: " + missingStudent);
        }
        catch (StudentNotFoundException e)
        {
            System.err.println(e.getMessage());
        }
    }
}
