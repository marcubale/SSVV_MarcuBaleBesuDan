package ssvv.example;

import com.sun.jmx.mbeanserver.Repository;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import ssvv.example.domain.Student;
import ssvv.example.repository.NotaXMLRepo;
import ssvv.example.repository.StudentFileRepository;
import ssvv.example.repository.StudentXMLRepo;
import ssvv.example.repository.TemaXMLRepo;
import ssvv.example.service.Service;
import ssvv.example.validation.NotaValidator;
import ssvv.example.validation.StudentValidator;
import ssvv.example.validation.TemaValidator;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    StudentValidator studentValidator = new StudentValidator();
    TemaValidator temaValidator = new TemaValidator();
    String filenameStudent = "ssvv.example/fisiere/Studenti.xml";
    String filenameTema = "ssvv.example/fisiere/Teme.xml";
    String filenameNota = "ssvv.example/fisiere/Note.xml";

    @org.junit.Test
    public void add_student_success() {

//        StudentFileRepository rep = new StudentFileRepository("ssvv.example/fisiere/Studenti.xml");

        StudentXMLRepo studentXMLRepository = new StudentXMLRepo(filenameStudent);
        TemaXMLRepo temaXMLRepository = new TemaXMLRepo(filenameTema);
        NotaValidator notaValidator = new NotaValidator(studentXMLRepository, temaXMLRepository);
        NotaXMLRepo notaXMLRepository = new NotaXMLRepo(filenameNota);
        Service service = new Service(studentXMLRepository, studentValidator, temaXMLRepository, temaValidator, notaXMLRepository, notaValidator);

        Student stud1 = new Student("1", "Marcu", 931, "mail1");
        Student result = service.addStudent(stud1);

        assertEquals(stud1, result);

        Student result2 = service.addStudent(new Student("2", "nume", 111, "mail"));
        //assertEquals(result2, 1);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
