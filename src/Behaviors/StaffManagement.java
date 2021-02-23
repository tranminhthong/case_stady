package Behaviors;

import Entities.staffs.Staff;

import java.util.List;
import java.util.regex.Pattern;

public class StaffManagement<T extends Staff> {
    List<T> staffs;
    final String PATH_FILE = "C:\\Users\\thait\\OneDrive\\Desktop\\Case_Module_2\\case_stady\\src\\Staff.dat";

    public void addStaff(T t) {
        staffs = (List<T>) ReadWrite.readFromFile(PATH_FILE);
        staffs.add(t);
        ReadWrite.writeObjectToFile(staffs, PATH_FILE);
    }

    public void updateStaff(int id, String name) {
        staffs = (List<T>) ReadWrite.readFromFile(PATH_FILE);
        for (T t : staffs) {
            if (t.getId() == id) {
                t.setName(name);
                System.out.println("Done!!!");
            }
        }
        ReadWrite.writeObjectToFile(staffs, PATH_FILE);
    }

    public void delete(int id) {
        staffs = (List<T>) ReadWrite.readFromFile(PATH_FILE);
        staffs.removeIf(t -> t.getId() == id);
        ReadWrite.writeObjectToFile(staffs, PATH_FILE);
    }

    public T displayStaffById(int id) {
        staffs = (List<T>) ReadWrite.readFromFile(PATH_FILE);
        for (T t : staffs) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    public void show() {
        staffs = (List<T>) ReadWrite.readFromFile(PATH_FILE);
        for (int i = 0; i < 101; i++) {
            System.out.print("_");
        }
        System.out.printf("\n%-15s| %-15s| %-15s| %-15s| %-15s| %-15s|\n","Staff","Identity","Name","Date of birth","Address","Gender");
        for (int i = 0; i < 101; i++) {
            System.out.print("-");
        }
        System.out.println();
        for (T t : staffs) {
            System.out.printf("%-15s| %-15s| %-15s| %-15s| %-15s| %-15s|\n",t.getClass().getSimpleName(),t.getId(),t.getName(),t.getDateOfBirth(),t.getAddress(),t.getGender());
        }
        for (int i = 0; i < 101; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void check(int id) throws Exception {
        staffs = (List<T>) ReadWrite.readFromFile(PATH_FILE);
        for (T t : staffs) {
            if (t.getId() == id) {
                System.out.println(t);
                return;
            }
        }
        throw new Exception("Not exist");
    }

    public static void checkInputDateOfBirth(String str) throws Exception {
        Pattern pattern = Pattern.compile("\\d{1,2}[-|/]\\d{1,2}[-|/]\\d{4}");
        boolean matcher = pattern.matcher(str).matches();
        if (!matcher) throw new Exception("Note: dd/mm/yyyy or dd-mm-yyyy. Please try again");
    }
}
