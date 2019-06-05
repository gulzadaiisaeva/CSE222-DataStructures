package part1;

import part1.CourseData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.LinkedList;

/**
 * The class which keeps list hold courses
 */
public class GTUCECourses {

    /**
     * The list which keep courses
     */
    private LinkedList<CourseData> courses= new LinkedList<>();

    /**
     * Constructor
     *
     * This constructor will read all data about course from
     * csv file "courseData.csv" to list
     */
    public GTUCECourses() {
        CSVReaderCourse();
    }

    /**
     * Get the list of course
     * @return course list
     */
    public LinkedList<CourseData> getCourses() {
        return courses;
    }
    /**
     * Read the course data from csv file to courses variable
     * Read the semester, code, title, akts, h+t+l
     * @throws IOException
     */
    private void CSVReaderCourse()
    {
        String csvFile = "courseData.csv";
        String line = "";

        String cvsSplitBy = ";";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine();

            while ((line = br.readLine()) != null) {

                // use ; as separator
                String[] temp = line.split(cvsSplitBy);
                CourseData courseData=new CourseData(Integer.parseInt(temp[0]),temp[1],temp[2],Integer.parseInt(temp[3]),Integer.parseInt(temp[4]),temp[5]);
                courses.add(courseData);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * First it finds the course with given code and adds to list which will be returned
     * @param code Code of course
     * @return  all courses which have given course code
     * @throws InvalidParameterException if code is not in the list
     */
    public LinkedList<CourseData> getByCode(String code) throws InvalidParameterException
    {
        LinkedList<CourseData> c = new LinkedList<>();
        int found=-1;

        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCode().equals(code)) {
                c.add(courses.get(i));
                found=0;
            }
        }
        if(found==-1)
        {
            throw new InvalidParameterException("There is no courses with such a code\n");
        }
        return c;
    }

    /**
     * First it finds the course with given semester and adds to list which will be returned
     * @param semester of course
     * @return all courses on given semester.
     * @throws InvalidParameterException if semester is not in the list
     */
    public LinkedList<CourseData> listSemesterCourses(int semester) throws InvalidParameterException
    {
        LinkedList<CourseData> c = new LinkedList<>();
        int found=-1;

        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getSemester()==semester) {
                c.add(courses.get(i));
                found=0;
            }
        }
        if(found==-1)
        {
            throw new InvalidParameterException("There is no courses with such a semester\n");
        }
        return c;
    }

    /**
     *
     * @param start_index of list
     * @param last_index of list
     * @return all courses from given start index to last index.
     * @throws InvalidParameterException if indexs are invalid
     */
    public LinkedList<CourseData> getByRange(int start_index, int last_index ) throws InvalidParameterException
    {
        if(start_index<0 || start_index>=courses.size()-1 || last_index<=0 || last_index>courses.size()-1 )
            throw new InvalidParameterException("Invalid index\n");

        LinkedList<CourseData> c = new LinkedList<>();
        int found=-1;

        for (int i = start_index; i <= last_index; i++) {
            c.add(courses.get(i));
        }

        return c;
    }

    /**
     * To String method
     * @return
     */
    @Override
    public String toString() {
        String str="GTUCECourses:\n" +  "semester" +
                ", code" +
                ", title" +
                ", ectsCredits" +
                ", gtuCredits" +
                ", h+t+l\n";
        for (int i = 0; i < courses.size(); i++) {
            str+=courses.get(i).toString();
        }
        return str;
    }
}
