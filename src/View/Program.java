package View;

import Behaviors.LoginAndRegister;
import Behaviors.ProductManagement;
import Behaviors.StaffManagement;
import Entities.products.Laptop;
import Entities.products.Phone;
import Entities.products.Product;
import Entities.staffs.*;

import java.util.Scanner;

public class Program {
    static Scanner sc = new Scanner(System.in);
    static StaffManagement<Staff> sm = new StaffManagement<>();
    static ProductManagement<Product> pm = new ProductManagement<>();

    public static void main(String[] args) {
        login:
        do {
            System.out.print(">>>>>>>>>>><<<<<<<<<<" +
                    "\n1. Login" +
                    "\n2. Register" +
                    "\n3. Delete user" +
                    "\nEnter choice: ");
            try {
                int choices = Integer.parseInt(sc.nextLine());
                if (choices == 1) {
                    Menus.login();
                    startMenu:
                    do {
                        System.out.print("-----Store Management-----" +
                                "\n1: Staff Management" +
                                "\n2: Product Management" +
                                "\n3: Log out" +
                                "\nEnter choice: ");
                        try {
                            int choice = Integer.parseInt(sc.nextLine());
                            if (choice == 1) {
                                start1:
                                do {
                                    System.out.print("-----Staff Management-----" +
                                            "\n1: Add Staff" +
                                            "\n2: Update Staff" +
                                            "\n3: Delete Staff" +
                                            "\n4: Display a staff by id" +
                                            "\n5: Show all Staff" +
                                            "\n6: Calculate salary" +
                                            "\n0: Back" +
                                            "\nEnter choice: ");
                                    try {
                                        int choice1 = Integer.parseInt(sc.nextLine());
                                        switch (choice1) {
                                            case 1:
                                                do {
                                                    System.out.print("----Add Staff----" +
                                                            "\n1: Add Manager" +
                                                            "\n2: Add Salesman" +
                                                            "\n3: Add Technical Staff" +
                                                            "\n4: Add Guard" +
                                                            "\n0: Back" +
                                                            "\nEnter choice: ");
                                                    try {
                                                        int choice3 = Integer.parseInt(sc.nextLine());
                                                        switch (choice3) {
                                                            case 1:
                                                                Manager manager = (Manager) Menus.getInfoStaff("Manager");
                                                                sm.addStaff(manager);
                                                                break;
                                                            case 2:
                                                                Salesman salesman = (Salesman) Menus.getInfoStaff("Salesman");
                                                                sm.addStaff(salesman);
                                                                break;
                                                            case 3:
                                                                TechnicalStaff technicalStaff = (TechnicalStaff) Menus.getInfoStaff("Technical");
                                                                sm.addStaff(technicalStaff);
                                                                break;
                                                            case 4:
                                                                Guard guard = (Guard) Menus.getInfoStaff("Guard");
                                                                sm.addStaff(guard);
                                                                break;
                                                            case 0:
                                                                continue start1;
                                                            default:
                                                                System.err.println("Try Again");
                                                        }
                                                    } catch (Exception e) {
                                                        e.printStackTrace();
                                                    }
                                                } while (true);
                                            case 2:
                                                System.out.print("Enter id: ");
                                                int id = Integer.parseInt(sc.nextLine());
                                                sm.check(id);
                                                System.out.print("Enter name: ");
                                                String name = sc.nextLine();
                                                sm.updateStaff(id, name);

                                                break;
                                            case 3:
                                                System.out.print("Enter id: ");
                                                int id1 = Integer.parseInt(sc.nextLine());
                                                sm.delete(id1);
                                                break;
                                            case 4:
                                                System.out.print("Enter id: ");
                                                int id2 = Integer.parseInt(sc.nextLine());
                                                System.out.println(sm.displayStaffById(id2));
                                                break;
                                            case 5:
                                                sm.show();
                                                break;
                                            case 6:
                                                System.out.print("Enter id: ");
                                                int id3 = Integer.parseInt(sc.nextLine());
                                                Staff st = sm.displayStaffById(id3);
                                                System.out.println(sm.displayStaffById(id3));
                                                System.out.print("Enter bonus: ");
                                                st.setBonus(Double.parseDouble(sc.nextLine()));
                                                System.out.print("Enter penalty: ");
                                                st.setPenalty(Double.parseDouble(sc.nextLine()));
                                                System.out.println(st.calculateSalary());
                                                break;
                                            case 0:
                                                continue startMenu;
                                            default:
                                                System.err.println("Try Again!");
                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                } while (true);
                            } else if (choice == 2) {
                                start2:
                                do {
                                    System.out.print("-----Product Management-----" +
                                            "\n1: Add Product" +
                                            "\n2: Update Product" +
                                            "\n3: Delete Product" +
                                            "\n4: Display a product by id" +
                                            "\n5: Show all product" +
                                            "\n0: Back" +
                                            "\nEnter choice: ");
                                    try {
                                        int choice1 = Integer.parseInt(sc.nextLine());
                                        switch (choice1) {
                                            case 1:
                                                do {
                                                    System.out.print("-------Add Product--------" +
                                                            "\n1: Add Phone" +
                                                            "\n2: Add Laptop" +
                                                            "\n0: Back" +
                                                            "\nEnter choice: ");
                                                    int choice3 = Integer.parseInt(sc.nextLine());
                                                    switch (choice3) {
                                                        case 1:
                                                            Phone phone = (Phone) Menus.getInfoProduct("Phone");
                                                            pm.addProduct(phone);
                                                            break;
                                                        case 2:
                                                            Laptop laptop = (Laptop) Menus.getInfoProduct("Laptop");
                                                            pm.addProduct(laptop);
                                                            break;
                                                        case 0:
                                                            continue start2;
                                                        default:
                                                            System.err.println("Try Again");
                                                    }
                                                } while (true);
                                            case 2:
                                                System.out.print("Enter id: ");
                                                int id = Integer.parseInt(sc.nextLine());
                                                pm.searchProductById(id);
                                                System.out.print("Enter price: ");
                                                long price = Long.parseLong(sc.nextLine());
                                                pm.updateProduct(id, price);
                                                break;
                                            case 3:
                                                System.out.print("Enter code: ");
                                                int code = Integer.parseInt(sc.nextLine());
                                                pm.deleteProduct(code);
                                                break;
                                            case 4:
                                                System.out.print("Enter code: ");
                                                int code1 = Integer.parseInt(sc.nextLine());
                                                Product t = pm.displayProductByCode(code1);
                                                if (t instanceof Phone) {
                                                    System.out.printf("%-10s|  %-10s|  %-10s|  %-10s|  %-10s|  %-10s|  %-10s|  %-10s|  %-10s|  %-10s|  %-10s|\n",
                                                            "Product", "id", "name", "code", "brand", "weight", "size", "color", "price", "type phone", "type keyboard");
                                                    System.out.printf("%-10s|  %-10s|  %-10s|  %-10s|  %-10s|  %-10s|  %-10s|  %-10s|  %-10s|  %-10s|  %-10s|\n", t.getClass().getSimpleName(), t.getId(), t.getName(), t.getCode(), t.getBrand(),
                                                            t.getWeight(), t.getSize(), t.getColor(), t.getPrice(), ((Phone) t).getTypePhone(), ((Phone) t).getTypeKeyboard());
                                                }
                                                if (t instanceof Laptop) {
                                                    System.out.printf("%-10s|  %-10s|  %-10s|  %-10s|  %-10s|  %-10s|  %-10s|  %-10s|  %-10s|  %-10s|  %-10s|\n",
                                                            "Product", "id", "name", "code", "brand", "weight", "size", "color", "price", "gate HDMI", "led keyboard");
                                                    System.out.printf("%-10s|  %-10s|  %-10s|  %-10s|  %-10s|  %-10s|  %-10s|  %-10s|  %-10s|  %-10s|  %-10s|\n", t.getClass().getSimpleName(), t.getId(), t.getName(), t.getCode(), t.getBrand(),
                                                            t.getWeight(), t.getSize(), t.getColor(), t.getPrice(), ((Laptop) t).getGateHDMI(), ((Laptop) t).getLedKeyboard());
                                                }
                                                break;
                                            case 5:
                                                pm.show();
                                                break;
                                            case 0:
                                                continue startMenu;
                                            default:
                                                System.err.println("Try Again");
                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                } while (true);
                            } else if (choice == 3) {
                                continue login;
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } while (true);
                } else if (choices == 2) {
                    Menus.register();
                } else if (choices == 3) {
                    System.out.print("Enter username: ");
                    String user = sc.nextLine();
                    LoginAndRegister.delete(user);
                } else if (choices == 130297) {
                    LoginAndRegister.show();
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (true);

    }
}
