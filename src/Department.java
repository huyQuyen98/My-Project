public class Department {
    //Tạo thuộc tính mã bộ phận, tên bộ phận, số lượng nhân viên hiện tại
    private int idDepartment;
    private String nameDepartment;
    private int numberEmplyee;

    public Department(int idDepartment, String nameDepartment, int numberEmplyee) {
        this.idDepartment = idDepartment;
        this.nameDepartment = nameDepartment;
        this.numberEmplyee = numberEmplyee;
    }

    public String toString() {
        return idDepartment + " " + nameDepartment + " " + numberEmplyee;
    }

    public int getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(int idDepartment) {
        this.idDepartment = idDepartment;
    }

    public String getNameDepartment() {
        return nameDepartment;
    }

    public void setNameDepartment(String nameDepartment) {
        this.nameDepartment = nameDepartment;
    }

    public int getNumberEmplyee() {
        return numberEmplyee;
    }

    public void setNumberEmplyee(int numberEmplyee) {
        this.numberEmplyee = numberEmplyee;
    }
}