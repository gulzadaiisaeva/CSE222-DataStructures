package part2;

import org.junit.jupiter.api.Test;
import part1.CourseData;
import part2.ExtendedLinkedList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ExtendedLinkedListTest {

    private ExtendedLinkedList<CourseData> list = new ExtendedLinkedList();

    public void readCourse() {

        String csvFile = "courseData.csv";
        String line = "";

        String cvsSplitBy = ";";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine();

            for (int i = 0; i < 5; i++) {
                line = br.readLine();
                String[] temp = line.split(cvsSplitBy);
                CourseData courseData=new CourseData(Integer.parseInt(temp[0]),temp[1],temp[2],Integer.parseInt(temp[3]),Integer.parseInt(temp[4]),temp[5]);
                list.add(courseData);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    void disable() {
        readCourse();
        list.disable(0);
        assertEquals(1,list.showDisabled().size());
        list.clear();
    }

    @Test
    void enable() {
        readCourse();
        list.disable(0);
        list.enable(0);
        assertEquals(0,list.showDisabled().size());
        list.clear();
    }

    @Test
    void remove() {
        readCourse();
        assertEquals(list.get(0),list.remove(0));
        list.clear();
    }

    @Test
    void size() {
        readCourse();
        assertEquals(5,list.size());
        list.clear();
    }
}