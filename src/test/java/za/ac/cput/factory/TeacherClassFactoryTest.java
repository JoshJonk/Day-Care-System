package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.lookup.ParentChild;
import za.ac.cput.domain.lookup.TeacherClass;
import za.ac.cput.factory.lookup.ParentChildFactory;
import za.ac.cput.factory.lookup.TeacherClassFactory;

import static org.junit.jupiter.api.Assertions.*;

class TeacherClassFactoryTest {
    private TeacherClass teacherClass;

    @BeforeEach
    void setUp() {
        teacherClass = new TeacherClassFactory().build("14", "15");
    }

    @Test
    void testTeacherClassWithSuccess() {
        assertAll(
                () -> assertNotNull(teacherClass),
                () -> assertNotNull(teacherClass.getTeacherID()),
                () -> assertNotNull(teacherClass.getRoomID()),
                () -> assertEquals("14", teacherClass.getTeacherID()),
                () -> assertEquals("15", teacherClass.getRoomID())
        );
    }

    @Test
    void testTeacherClassWithErrors() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            TeacherClassFactory.build(null, null);
        });

        String expectedMessage = "Error: Invalid value(s)";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

}