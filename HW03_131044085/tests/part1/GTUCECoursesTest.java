package part1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GTUCECoursesTest {

    private GTUCECourses course=new GTUCECourses();
    @Test
    void getByCode() { assertEquals(9,course.getByCode("XXX XXX").size()); }

    @Test
    void listSemesterCourses() {
        assertEquals(8,course.listSemesterCourses(1).size());
    }

    @Test
    void getByRange() {
        assertEquals(3,course.getByRange(1,3).size());
    }
}