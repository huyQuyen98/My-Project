//Tạo file Staff là class abstract chứa các thông tin cơ bản của nhân viên
public abstract class Staff implements ICalculator {
    private int id;
    private String name;
    private int age;
    private double coefficientSalary;
    private String dayBegin;
    private String workingPart;
    private int dayOff;

    public Staff (int id, String name, int age, double coefficientSalary, String dayBegin, String workingPart, int dayOff) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.coefficientSalary = coefficientSalary;
        this.dayBegin = dayBegin;
        this.workingPart = workingPart;
        this.dayOff = dayOff;
    }

    //Hàm displayInformation() là hàm abstract hiển thị thông tin phù hơp
    public abstract void displayInformation();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getCoefficientSalary() {
        return coefficientSalary;
    }

    public void setCoefficientSalary(double coefficientSalary) {
        this.coefficientSalary = coefficientSalary;
    }

    public String getDayBegin() {
        return dayBegin;
    }

    public void setDayBegin(String dayBegin) {
        this.dayBegin = dayBegin;
    }

    public String getWorkingPart() {
        return workingPart;
    }

    public void setWorkingPart(String workingPart) {
        this.workingPart = workingPart;
    }

    public int getDayOff() {
        return dayOff;
    }

    public void setDayOff(int dayOff) {
        this.dayOff = dayOff;
    }
}
