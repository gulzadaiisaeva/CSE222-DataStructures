package part1;

/**
 * The class which keeps course info
 */
public class CourseData {
    /**
     * Semester of course
     */
    private int semester;
    /**
     * Code of course
     */
    private String code;
    /**
     * Title of course
     */
    private String title;
    /**
     * Ects Credits of course
     */
    private int ectsCredits;
    /**
     * Gtu Credits of course
     */
    private int gtuCredits;
    /**
     * H+T+L of course
     */
    private String htl;

    /**
     * Default constructor
     */
    public CourseData() {
    }
    /**
     * Constructor which takes all data of course
     *
     * @param semester to be assigned
     * @param code to be assigned
     * @param title to be assigned
     * @param ectsCredits to be assigned
     * @param gtuCredits to be assigned
     * @param htl to be assigned
     */
    public CourseData(int semester, String code, String title, int ectsCredits, int gtuCredits, String htl) {
        this.semester = semester;
        this.code = code;
        this.title = title;
        this.ectsCredits = ectsCredits;
        this.gtuCredits = gtuCredits;
        this.htl = htl;
    }
    /**
     * Get Semester of Course
     * @return Semester
     */
    public int getSemester() {
        return semester;
    }

    /**
     * Set the semester
     * @param semester to be set
     */
    public void setSemester(int semester) {
        this.semester = semester;
    }
    /**
     * Get Code of Course
     * @return Code
     */
    public String getCode() {
        return code;
    }
    /**
     * Set the code
     * @param code to be set
     */
    public void setCode(String code) {
        this.code = code;
    }
    /**
     * Get Title of Course
     * @return Title
     */
    public String getTitle() {
        return title;
    }
    /**
     * Set the Title
     * @param title to be set
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * Get ECTS Credist of Course
     * @return ECTS Credist
     */
    public int getEctsCredits() {
        return ectsCredits;
    }
    /**
     * Set the ECTS Credits
     * @param ectsCredits to be set
     */
    public void setEctsCredits(int ectsCredits) {
        this.ectsCredits = ectsCredits;
    }
    /**
     * Get GTU Credist of Course
     * @return GTU Credist
     */
    public int getGtuCredits() {
        return gtuCredits;
    }
    /**
     * Set the GTU Credits
     * @param gtuCredits to be set
     */
    public void setGtuCredits(int gtuCredits) {
        this.gtuCredits = gtuCredits;
    }
    /**
     * Get H+T+L of Course
     * @return H+T+L Credist
     */
    public String getHtl() {
        return htl;
    }
    /**
     * Set the H+T+L
     * @param htl to be set
     */
    public void setHtl(String htl) {
        this.htl = htl;
    }

    /**
     * ToString method
     * @return String of data
     */
    @Override
    public String toString() {
        return  semester + " " +
                code +" " +
                title +" " +
                ectsCredits + " "+
                gtuCredits +" " +
                htl +
                '\n';
    }

}

