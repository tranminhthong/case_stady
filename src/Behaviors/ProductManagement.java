package Behaviors;

import Entities.products.Laptop;
import Entities.products.Phone;
import Entities.products.Product;

import java.util.ArrayList;

public class ProductManagement<T extends Product> {
    private static final String PATH_FILE = "C:\\Users\\thait\\OneDrive\\Desktop\\Case_Module_2\\src\\Product.dat";
    ArrayList<T> products = (ArrayList<T>) ReadWrite.readFromFile(PATH_FILE);
    public void addProduct(T t) {
        products.add(t);
        ReadWrite.writeObjectToFile(products, PATH_FILE);
    }

    public void updateProduct(int id, long price) {
        for (T t : products) {
            if (t.getId() == id) {
                t.setPrice(price);
            }
        }
        ReadWrite.writeObjectToFile(products, PATH_FILE);
    }

    public void deleteProduct(int code) {
        for (T t : products) {
            if (t.getCode() == code) {
                products.remove(t);
                break;
            }
        }
        ReadWrite.writeObjectToFile(products, PATH_FILE);
    }

    public T displayProductByCode(int code) {
        for (T t : products) {
            if (t.getCode() == code) {
                return t;
            }
        }
        return null;
    }

    public void show() {
        for (int i = 0; i < 284; i++) {
            System.out.print("_");
        }
        System.out.printf("\n%-20s| %-20s| %-20s| %-20s| %-20s| %-20s| %-20s| %-20s| %-20s| %-20s| %-20s| %-20s| %-20s|\n",
                "Product","id","name","code","brand","weight","size","color","price","type phone","type keyboard","gate HDMI","led keyboard");
        for (T t : products) {
            if (t instanceof Phone)
                System.out.printf("%-20s| %-20s| %-20s| %-20s| %-20s| %-20s| %-20s| %-20s| %-20s| %-20s| %-20s| %-20s| %-20s|\n",
                        t.getClass().getSimpleName(),t.getId(),t.getName(),t.getCode(),t.getBrand(),
                        t.getWeight(),t.getSize(),t.getColor(),t.getPrice(),((Phone) t).getTypePhone(),((Phone) t).getTypeKeyboard(),"NO","NO");
            if (t instanceof Laptop)
                System.out.printf("%-20s| %-20s| %-20s| %-20s| %-20s| %-20s| %-20s| %-20s| %-20s| %-20s| %-20s| %-20s| %-20s|\n",
                        t.getClass().getSimpleName(),t.getId(),t.getName(),t.getCode(),t.getBrand(),
                        t.getWeight(),t.getSize(),t.getColor(),t.getPrice(),"NO","NO",((Laptop) t).getGateHDMI(),((Laptop) t).getLedKeyboard());

        }
        for (int i = 0; i < 284; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void searchProductById(int id) throws Exception {
        for (T t : products) {
            if (t.getId() == id) {
                System.out.println(t);
                return;
            }
        }
        throw new Exception("Not exist");
    }

}
