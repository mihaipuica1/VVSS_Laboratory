import domain.Nota;
import domain.Tema;
import repository.NotaXMLRepo;
import repository.StudentXMLRepo;
import repository.TemaXMLRepo;
import service.Service;
import org.junit.Test;
import repository.StudentFileRepository;
import domain.Student;
import validation.NotaValidator;
import validation.StudentValidator;
import validation.TemaValidator;
import validation.Validator;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class AppTest {
    private StudentXMLRepo studentRepository;
    private NotaXMLRepo notaRepository;
    private TemaXMLRepo temaRepository;
    private Service service;
    private StudentValidator studentValidator;
    private NotaValidator noteValidator;
    private TemaValidator temaValidator;

    @Test
    public void tc_1_AddStudent() {

        studentValidator = new StudentValidator();
        temaValidator = new TemaValidator();

        String filenameStudent = "fisiere/Studenti.xml";
        String filenameTema = "fisiere/Teme.xml";
        String filenameNota = "fisiere/Note.xml";

        studentRepository = new StudentXMLRepo(filenameStudent);
        notaRepository = new NotaXMLRepo(filenameNota);
        temaRepository = new TemaXMLRepo(filenameTema);
        noteValidator = new NotaValidator(studentRepository, temaRepository);
        service = new Service(studentRepository, studentValidator,
                              temaRepository, temaValidator,
                                notaRepository, noteValidator);

        Student studentValid = new Student("1", "Florin", 10, "florin@yahoo.com");

        try {
            service.addStudent(studentValid);
            assert(true);
        }
        catch (Exception e){
            assert(false);
        }
    }

    @Test
    public void tc_2_AddAssignment() {
        studentValidator = new StudentValidator();
        temaValidator = new TemaValidator();

        String filenameStudent = "fisiere/Studenti.xml";
        String filenameTema = "fisiere/Teme.xml";
        String filenameNota = "fisiere/Note.xml";

        studentRepository = new StudentXMLRepo(filenameStudent);
        notaRepository = new NotaXMLRepo(filenameNota);
        temaRepository = new TemaXMLRepo(filenameTema);
        noteValidator = new NotaValidator(studentRepository, temaRepository);
        service = new Service(studentRepository, studentValidator,
                temaRepository, temaValidator,
                notaRepository, noteValidator);

        Tema tema = new Tema("1", "tema", 12, 1);
        service.addTema(tema);

        try {
            service.addTema(tema);
            assert(true);
        }
        catch (Exception e){
            e.printStackTrace();
            assert(false);
        }
    }

    @Test
    public void tc_3_AddGrade() {
        studentValidator = new StudentValidator();
        temaValidator = new TemaValidator();

        String filenameStudent = "fisiere/Studenti.xml";
        String filenameTema = "fisiere/Teme.xml";
        String filenameNota = "fisiere/Note.xml";

        studentRepository = new StudentXMLRepo(filenameStudent);
        notaRepository = new NotaXMLRepo(filenameNota);
        temaRepository = new TemaXMLRepo(filenameTema);
        noteValidator = new NotaValidator(studentRepository, temaRepository);
        service = new Service(studentRepository, studentValidator,
                temaRepository, temaValidator,
                notaRepository, noteValidator);

        Student studentValid = new Student("1", "Florin", 10, "florin@yahoo.com");
        Tema tema = new Tema("1", "tema", 12, 1);
        service.addTema(tema);
        service.addStudent(studentValid);
        Nota nota = new Nota("1", "1", "1", 10, LocalDate.of(2018,10,17));

        try {
            service.addNota(nota, "all good");
            assert(true);
        }
        catch (Exception e){
            e.printStackTrace();
            assert(false);
        }

    }

    @Test
    public void tc_4_BigBangGrade() {
        studentValidator = new StudentValidator();
        temaValidator = new TemaValidator();

        String filenameStudent = "fisiere/Studenti.xml";
        String filenameTema = "fisiere/Teme.xml";
        String filenameNota = "fisiere/Note.xml";

        studentRepository = new StudentXMLRepo(filenameStudent);
        notaRepository = new NotaXMLRepo(filenameNota);
        temaRepository = new TemaXMLRepo(filenameTema);
        noteValidator = new NotaValidator(studentRepository, temaRepository);
        service = new Service(studentRepository, studentValidator,
                temaRepository, temaValidator,
                notaRepository, noteValidator);

        Student studentValid = new Student("1", "Florin", 10, "florin@yahoo.com");
        Tema tema = new Tema("1", "tema", 12, 1);

        Nota nota = new Nota("1", "1", "1", 10, LocalDate.of(2018,10,17));

        try {
            service.addTema(tema);
            service.addStudent(studentValid);
            service.addNota(nota, "all good");
            assert(true);
        }
        catch (Exception e){
            e.printStackTrace();
            assert(false);
        }

    }

//    @Test
//    public void tc_1_StudentGroupInvalid() {
//
//        studentValidator = new StudentValidator();
//        temaValidator = new TemaValidator();
//
//        studentRepository = new StudentXMLRepo("Studenti.xml");
//        notaRepository = new NotaXMLRepo("Note.xml");
//        temaRepository = new TemaXMLRepo("Teme.xml");
//        noteValidator = new NotaValidator(studentRepository, temaRepository);
//        service = new Service(studentRepository, studentValidator,
//                temaRepository, temaValidator,
//                notaRepository, noteValidator);
//
//        Student studentInvalid = new Student("2", "Florinache", -2, "florin@yahoo.com");
//
//        try {
//            service.addStudent(studentInvalid);
//            assert(false);
//        }
//        catch (Exception e){
//            assert(true);
//        }
//    }

}
