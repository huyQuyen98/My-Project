import java.util.Scanner;

public class Employee extends Staff implements ICalculator{
    private int hoursOver; //Tạo thuộc tính giờ làm thêm

    public Employee(int id, String name, int age, double coefficientSalary, String dayBegin, String workingPart, int dayOff, int hoursOver) {
        super(id, name, age, coefficientSalary, dayBegin, workingPart, dayOff);
        this.hoursOver = hoursOver;
    }

    public int getHoursOver() {
        return hoursOver;
    }

    public void setHoursOver(int hoursOver) {
        this.hoursOver = hoursOver;
    }

    @Override
    //Phương thức trả về lương của nhân viên
    public double calculateSalary() {
        double salaryEmployee;
        salaryEmployee = getCoefficientSalary()*3000000 + hoursOver*200000;
        return salaryEmployee;
    }

    @Override
    public void displayInformation() {
        System.out.println("Mã nhân viên: " + getId() + "; Tên nhân viên: " + getName() + "; Tuổi: " + getAge() + "; Hệ số lương: " + getCoefficientSalary() + "; Ngày vào làm: " + getDayBegin() + "; Bộ phận làm việc: " + getWorkingPart() + "; Số ngày nghỉ phép: " + getDayOff() + "; Số giờ làm thêm: " + getHoursOver() + "; Lương của nhân viên: " + calculateSalary());
    }
}
