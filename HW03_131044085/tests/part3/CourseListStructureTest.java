package part3;

import org.junit.jupiter.api.Test;
import part1.CourseData;

import static org.junit.jupiter.api.Assertions.*;

class CourseListStructureTest {

    private CourseListStructure course = new CourseListStructure();
    private CourseData data= new CourseData(1, "CSE 101","Introduction To Computer Engineering",8,3,"3+0+0");



    @Test
    void addAndRemove() {
        course.addAtHead(data);
        course.addAtTail(data);
        course.removeAtIndex(1);
        assertEquals(1,course.size());
    }


}