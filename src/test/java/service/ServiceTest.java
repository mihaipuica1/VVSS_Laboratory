package service;

import domain.Tema;
import junit.framework.TestCase;
import org.junit.Test;
import repository.NotaXMLRepo;
import repository.StudentXMLRepo;
import repository.TemaXMLRepo;
import validation.NotaValidator;
import validation.StudentValidator;
import validation.TemaValidator;
import validation.ValidationException;

import static org.junit.Assert.*;

public class ServiceTest {
    private StudentXMLRepo studentRepository;
    private NotaXMLRepo notaRepository;
    private TemaXMLRepo temaRepository;
    private Service service;
    private StudentValidator studentValidator;
    private NotaValidator notaValidator;
    private TemaValidator temaValidator;

    @Test
    public void tc_1_testAddTemaValid() {
        String filenameStudent = "fisiere/Studenti.xml";
        String filenameTema = "fisiere/Teme.xml";
        String filenameNota = "fisiere/Note.xml";
        temaValidator = new TemaValidator();
        studentValidator = new StudentValidator();

        studentRepository = new StudentXMLRepo(filenameStudent);
        temaRepository = new TemaXMLRepo(filenameTema);
        notaRepository = new NotaXMLRepo(filenameNota);
        notaValidator = new NotaValidator(studentRepository, temaRepository);

        service = new Service(studentRepository,
                              studentValidator,
                              temaRepository,
                              temaValidator,
                              notaRepository,
                              notaValidator);

        Tema temaValida = new Tema("1", "descriere", 4, 3);
        assertEquals(service.addTema(temaValida), temaValida);
    }

    @Test(expected = ValidationException.class)
    public void tc_2_testAddTemaInvalid() {
        String filenameStudent = "fisiere/Studenti.xml";
        String filenameTema = "fisiere/Teme.xml";
        String filenameNota = "fisiere/Note.xml";
        temaValidator = new TemaValidator();
        studentValidator = new StudentValidator();

        studentRepository = new StudentXMLRepo(filenameStudent);
        temaRepository = new TemaXMLRepo(filenameTema);
        notaRepository = new NotaXMLRepo(filenameNota);
        notaValidator = new NotaValidator(studentRepository, temaRepository);

        service = new Service(studentRepository,
                studentValidator,
                temaRepository,
                temaValidator,
                notaRepository,
                notaValidator);

        Tema temaInvalida = new Tema("1", "", 4, 3);
        service.addTema(temaInvalida);
    }
}