public class Manager extends Staff implements ICalculator {
    private String position; //Tạo thuộc tính chức danh

    public Manager(int id, String name, int age, double coefficientSalary, String dayBegin, String workingPart, int dayOff, String position) {
        super(id, name, age, coefficientSalary, dayBegin, workingPart, dayOff);
        this.position = position;
    }

    public String getPosition(){
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    //Phương thức trả về lương của quản lý
    public double calculateSalary() {
        double salaryRespon;
        if (position == "Business Leader") {
            salaryRespon = 8000000;
        } else if (position == "Project Leader") {
            salaryRespon = 5000000;
        } else {
            salaryRespon = 6000000;
        }
        double salaryManager;
        salaryManager = getCoefficientSalary()*5000000 + salaryRespon;
        return salaryManager;
    }

    @Override
    public void displayInformation() {
        System.out.println("Mã nhân viên: " + getId() + "; Tên nhân viên: " + getName() + "; Tuổi: " + getAge() + "; Hệ số lương: " + getCoefficientSalary() + "; Ngày vào làm: " + getDayBegin() + "; Bộ phận làm việc: " + getWorkingPart() + "; Số ngày nghỉ phép: " + getDayOff() + " ngày; Lương của nhân viên: " + calculateSalary());
    }
}

