import java.util.*;

public class HumanResources {
    ArrayList<Staff> employeeList = new ArrayList<>();
    ArrayList<Department> departmentArrayList = new ArrayList<>();

    //Thêm nhân viên có sẵn trong công ty
    private void innitStaff() {
        employeeList.add(new Employee(101,"Quyen",24,5,"1/1/2022","Salesman",0,5));
        employeeList.add(new Employee(202,"Minh",22,5,"1/1/2022","HR",2,2));
        employeeList.add(new Employee(303,"Đạt",23,5,"1/1/2022","Marketing",5,4));
        employeeList.add(new Manager(404,"Chiến",33,5,"1/1/2022","Salesman",6,"Business Leader"));
        employeeList.add(new Manager(505,"Quyen",35,5,"1/1/2022","HR",2,"Project Leader"));
        employeeList.add(new Manager(606,"Trang",36,5,"1/1/2022","Marketing",4,"Technical Leader"));
    }

    //Thêm bộ phận trong công ty
    private void innitDepartment() {
        departmentArrayList.add(new Department(201,"Salesman",2));
        departmentArrayList.add(new Department(202,"HR",2));
        departmentArrayList.add(new Department(203,"Marketing",2));
    }

    public HumanResources() {
        innitStaff();
        innitDepartment();
    }

    //Hiển thị toàn bộ nhân viên trong công ty
    public void showStaff() {
        System.out.println("Danh sách các nhân viên trong công ty: ");
        for (int i = 0; i < employeeList.size(); i++) {
            employeeList.get(i).displayInformation();
        }
    }

    //Hiển thị các bộ phận trong công ty
    public void showDepartment() {
        System.out.println("Các bộ phận trong công ty gồm: ");
        for (int i = 0; i < departmentArrayList.size(); i++) {
            System.out.println(departmentArrayList.get(i).toString());
        }
    }

    //Hiển thị các nhân viên trong từng bộ phận
    public void showStaffByDepartment() {
        System.out.println("Nhân viên thuộc bộ phận này gồm: ");
        for (int i = 0; i < departmentArrayList.size(); i++) {
            System.out.println(departmentArrayList.get(i).getNameDepartment() + ":");
            for (int j = 0; j < employeeList.size(); j++) {
                if(employeeList.get(j).getWorkingPart().compareTo(departmentArrayList.get(i).getNameDepartment()) == 0) {
                    employeeList.get(j).displayInformation();
                }
            }
        }
    }

    //Thêm nhân viên hoặc quản lý
    public void addStaff() {
        Staff staff;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên nhân viên: ");
        String addName = sc.nextLine();
        System.out.println("Nhập mã nhân viên: ");
        int addID = sc.nextInt();
        System.out.println("Nhập tuổi: ");
        int addAge = sc.nextInt();
        System.out.println("Nhập ngày bắt đầu: ");
        String addDayBegin = sc.next();
        System.out.println("Nhập hệ số lương: ");
        double addPayRate = sc.nextDouble();
        System.out.println("Nhập bộ phận làm việc: ");
        String addWorkingPart = sc.next();
        System.out.println("Nhập ngày nghỉ: ");
        int addDayOff = sc.nextInt();
        System.out.println("Bạn muốn nhập nhân viên thông thường (Nhập 1) hay quản lý (Nhập 2)?");
        int postionChose = sc.nextInt();
        if(postionChose == 1) {
            System.out.println("Nhập số giờ làm thêm: ");
            int addHoursOver = sc.nextInt();
            staff = new Employee(addID, addName, addAge, addPayRate, addDayBegin, addWorkingPart, addDayOff, addHoursOver);
        } else {
            System.out.println("Nhập loại quản lý: ");
            String addPosition = sc.next();
            staff = new Manager(addID, addName, addAge, addPayRate, addDayBegin, addWorkingPart, addDayOff, addPosition);
        }
        employeeList.add(staff);
        increaseStaff(addWorkingPart);
        System.out.println("Nhân viên đã được thêm vào công ty!");
    }

    //Tăng số lượng nhân viên lên sau khi thêm
    private void increaseStaff(String departmentName) {
        for(int i = 0; i < departmentArrayList.size(); i++) {
            if(departmentArrayList.get(i).getNameDepartment().compareTo(departmentName) == 0) {
                int staff = departmentArrayList.get(i).getNumberEmplyee();
                staff += 1;
                Department d = departmentArrayList.get(i);
                d.setNumberEmplyee(staff);
                departmentArrayList.set(i,d);
            }
        }
    }

    //Tìm nhân viên theo tên
    private void findStaffName() {
        System.out.println("Nhập vào tên nhân viên cần tìm: ");
        Scanner sc = new Scanner(System.in);
        String findEmployeeName = sc.nextLine();
        for(int i = 0; i < employeeList.size(); i++) {
           if(employeeList.get(i).getName().contains(findEmployeeName)) {
               employeeList.get(i).displayInformation();
           }
        }
    }

    //Tìm nhân viên theo mã Id
    private void findStaffId() {
        System.out.println("Nhập vào mã nhân viên cần tìm: ");
        Scanner sc = new Scanner(System.in);
        int findEmployeeId = sc.nextInt();
        for(int i = 0; i < employeeList.size(); i++) {
            if(employeeList.get(i).getId() == findEmployeeId) {
                employeeList.get(i).displayInformation();
            }
        }
    }

    //Hiện bảng lương của toàn bộ nhân viên trong công ty
    private void showSalary() {
        System.out.println("Bảng lương của nhân viên toàn công ty: ");
        for (int i = 0; i < employeeList.size(); i++) {
            System.out.printf("Tên nhân viên: " + employeeList.get(i).getName() + " ; Lương: %f\n", employeeList.get(i).calculateSalary());
        }
    }

    //Hiển thị bảng lương theo thứ tự tăng dần
    public void sortAscendingSalary() {
        System.out.println("Bảng lương của nhân viên theo thứ tự tăng dần:");
        Collections.sort(employeeList, (a, b) -> (int) (a.calculateSalary() - b.calculateSalary()));
        for(Staff st : employeeList) {
            System.out.printf("Tên nhân viên: " + st.getName() + "; Lương: %f\n", st.calculateSalary());
        }
    }

    //Hiển thị bảng lương theo thứ tự giảm dần
    public void sortDescendingSalary() {
        System.out.println("Bảng lương của nhân viên theo thứ tự tăng dần:");
        Collections.sort(employeeList, (a, b) -> (int) (b.calculateSalary() - a.calculateSalary()));
        for(Staff st : employeeList) {
            System.out.printf("Tên nhân viên: " + st.getName() + "; Lương: %f\n", st.calculateSalary());
        }
    }

    //main chính chạy chương trình
    public static void main(String[] args) {
        choseNumber();
    }
        public static void choseNumber () {
            HumanResources HR = new HumanResources();
            int choose;
            do {
                showMenu();
                Scanner sc = new Scanner(System.in);
                System.out.print("Chọn chức năng: ");
                choose = Integer.parseInt(sc.nextLine());
                switch (choose) {
                    case 1:
                        HR.showStaff();
                        break;
                    case 2:
                        HR.showDepartment();
                        break;
                    case 3:
                        HR.showStaffByDepartment();
                        break;
                    case 4:
                        HR.addStaff();
                        break;
                    case 5:
                        HR.findStaffName();
                        break;
                    case 6:
                        HR.findStaffId();
                        break;
                    case 7:
                        HR.showSalary();
                        break;
                    case 8:
                        HR.sortAscendingSalary();
                        break;
                    case 9:
                        HR.sortDescendingSalary();
                        break;
                }
            } while (choose > 0 && choose <10);
        }

        //Hiển thị menu cho người dùng chọn
    public static void showMenu() {
        System.out.println("1. Hiển thị danh sách nhân viên hiện có trong công ty");
        System.out.println("2. Hiển thị các bộ phận trong công ty");
        System.out.println("3. Hiển thị các nhân viên theo từng bộ phận");
        System.out.println("4. Thêm nhân viên mới vào công ty: ");
        System.out.println("5. Tìm kiếm thông tin nhân viên theo tên nhân viên: ");
        System.out.println("6. Tìm kiếm thông tin nhân viên theo mã nhân viên: ");
        System.out.println("7. Hiển thị bảng lương của nhân viên toàn công ty");
        System.out.println("8. Hiển thị bảng lương của nhân viên theo thứ tự tăng dần");
        System.out.println("9. Hiển thị bảng lương của nhân viên theo thứ tự giảm dần");
    }
}