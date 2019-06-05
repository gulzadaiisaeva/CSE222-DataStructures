import part1.CourseData;
import part1.GTUCECourses;
import part2.ExtendedLinkedList;
import part3.CourseListStructure;

import java.security.InvalidParameterException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class Main {

    public static void main(String [] args)
    {
        GTUCECourses course = new GTUCECourses();
        try {
            System.out.println("/********************   PART I ***************************************************/");
            System.out.println(course.toString());

            System.out.println("/*******************  Test getByCode *****************/\n");
            LinkedList<CourseData> courseByCode = new LinkedList<>();
            courseByCode = course.getByCode("XXX XXX");
            System.out.println(courseByCode.toString());

            System.out.println("/*******************  Test listSemesterCourses *****************/\n");
            LinkedList<CourseData> courseBySemester = new LinkedList<>();
            courseBySemester = course.listSemesterCourses(1);
            System.out.println(courseBySemester.toString());

            System.out.println("/*******************  Test getByRange (8,14):*****************/\n");
            LinkedList<CourseData> courseByRange = new LinkedList<>();
            courseByRange = course.getByRange(8,14);
            System.out.println(courseByRange.toString());

            System.out.println("\n/********************   PART II ***************************************************/\n");
            ExtendedLinkedList<CourseData> extendedLinkedList= new ExtendedLinkedList<CourseData>(courseBySemester);
            System.out.println("/*******************  Test ExtendedList *****************/");
            System.out.println(extendedLinkedList.toString());

            extendedLinkedList.showDisabled();

            System.out.println("/*******************  Test DisableList (disable 5) *****************/");
            extendedLinkedList.disable(5);
            extendedLinkedList.showDisabled();

            System.out.println("'Test size()' : "+extendedLinkedList.size());

            System.out.println("'Test disable get(5)' : "+extendedLinkedList.get(5));
            System.out.println("'Test enable get(0)' : "+extendedLinkedList.get(0));

            System.out.println("/******* ToString method prints all list disable+enable ****/");
            System.out.println(extendedLinkedList.toString());

            System.out.println("***** Test remove 5 (this is disabled list) ****/");
            extendedLinkedList.remove(5);

            System.out.println("/*******************  Test enable remove(0) *****************/ ");
            extendedLinkedList.remove(0);
            System.out.println(extendedLinkedList.toString());

            System.out.println("/*******************  Testing list iterator *****************/");
            Iterator it  = extendedLinkedList.listIterator(0);
            for(int i=0; i<extendedLinkedList.size(); i++)
                System.out.print(extendedLinkedList.listIterator(i).next().toString());
            /*while(listIt.hasNext()){
                System.out.print(listIt.listIterator(0).next());
            }*/

            System.out.println("\n/*******************  Test Enable *****************/");
            extendedLinkedList.enable(4);
            System.out.println(extendedLinkedList.toString());
            System.out.println("/*******************  Test DisableList *****************/");
            extendedLinkedList.showDisabled();

            System.out.println("\n/********************   PART III ***************************************************/");

            CourseListStructure courseList=new CourseListStructure(course.getCourses().get(0));
            courseList.addAtTail(course.getCourses().get(9));
            courseList.addAtTail(course.getCourses().get(18));
            courseList.addAtTail(course.getCourses().get(2));
            /*for (int i = 1; i <5 ; i++) {
                courseList.addAtTail(course.getCourses().get(i));
            }*/

            System.out.println("\n/*** Testing iterator with next() ***/\n");
            CourseListStructure.CourseListStructureIterator it2 = courseList.iterator();
            while (it2.hasNext()) {
                System.out.print(it2.next());
            }
            System.out.println("\n/*** Testing iterator with nextInSemester(1) with for(i<8) ***/\n");
            CourseListStructure.CourseListStructureIterator it3 = courseList.iterator();
            for (int i = 0; i < 8; i++) {
                System.out.print(it3.nextInSemester(1));
            }
            System.out.println("\n/*** Testing iterator with nextInSemester(2) with for(i<8) ***/\n");
            CourseListStructure.CourseListStructureIterator it4 = courseList.iterator();
            for (int i = 0; i < 8; i++) {
                System.out.print(it4.nextInSemester(2));
            }
            System.out.println("\n/*** Testing iterator with nextInSemester(3) with for(i<8) ***/\n");
            CourseListStructure.CourseListStructureIterator it5 = courseList.iterator();
            for (int i = 0; i < 8; i++) {
                System.out.print(it5.nextInSemester(3));
            }



        } catch (Throwable throwable) {
            throw new InvalidParameterException(throwable.getMessage());
        }

    }
}
