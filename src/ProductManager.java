import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class ProductManager {
    static ArrayList<Product> list = new ArrayList<>();

    public static void addProduct() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhap ten sam pham");
        String name = scanner.nextLine();

        System.out.println("Nhap id san pham");
        int id = scanner.nextInt();

        System.out.println("Nhap gia san pham");
        double cost = scanner.nextDouble();

        Product sp = new Product(name, id, cost);

        list.add(sp);
    }

    public static void editProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap id san pham can sua");
        int id = scanner.nextInt();
        boolean findId = false;
        for (int i = 0; i < list.size(); i++) {
            if (id == list.get(i).getId()) {

                System.out.println("Nhap ten sam pham can sua");
                String name = scanner.nextLine();

                System.out.println("Nhap gia san pham can sua");
                double cost = scanner.nextDouble();

                list.get(i).setName(name);
                list.get(i).setId(id);
                list.get(i).setCost(cost);

                findId = true;
                break;
            }
        }
        if (findId == false) System.out.println("Khong tim thay id");
    }


    public static void deleteProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap id san pham can xoa");
        int id = scanner.nextInt();
        int index = -1;

        boolean findId = false;
        for (int i = 0; i < list.size(); i++) {
            if (id == list.get(i).getId()) {
                findId = true;
                index = i;
                break;
            }
            if (findId == false) {
                System.out.println("Khong tim thay id");
            } else {
                list.remove(index);
            }
        }
    }

    public static void sortByCost() {
        list.sort(Comparator.comparing(Product::getCost));
    }

    public static void showListProduct() {
        for (Product show : list
        ) {
            System.out.println(show);
        }
    }

    public static void exitMenu() {
        System.out.println("Exit");
        System.exit(0);
    }

    public static void Menu() {
        System.out.println("1: Add Product");
        System.out.println("2: Edit Product");
        System.out.println("3: Delete Product");
        System.out.println("4: Sort By Cost");
        System.out.println("5: Show ListProduct");
        System.out.println("0: Exit Menu");
        int choice;
        System.out.println("Nhap lua chon: ");
        Scanner scanner = new Scanner(System.in);
        choice = scanner.nextInt();
        switch (choice) {
            case 1:
                addProduct();
                break;
            case 2:
                editProduct();
                break;
            case 3:
                deleteProduct();
                break;
            case 4:
                sortByCost();
                break;
            case 5:
                showListProduct();
                break;
            case 0:
                exitMenu();
                break;
        }
    }

    public static void main(String[] args) {
        while (true){
            Menu();
        }
    }
}