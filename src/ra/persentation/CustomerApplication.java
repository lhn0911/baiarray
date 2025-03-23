package ra.persentation;

import java.util.Scanner;
import ra.entity.Customer;
import ra.validate.validator;
import ra.bussiness.CustomerBusiness;

public class CustomerApplication {
    public static Customer[] arrCustomers = new Customer[100];
    public static int currentCustomerIndex = 0;
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        displayMenu();
    }

    public static void displayMenu() {
        do {
            System.out.println("----------------Customer Menu----------------");
            System.out.println("1. Hiển thị danh sách các khách hàng ");
            System.out.println("2. Thêm mới khách hàng ");
            System.out.println("3. Chỉnh sửa thông tin khách hàng");
            System.out.println("4. Xóa khách hàng ");
            System.out.println("5. Tìm kiếm khách hàng");
            System.out.println("6. Sắp xếp khách hàng");
            System.out.println("0. Thoát chương trình ");
            System.out.println("----------------------------------------------");
            int choice = validator.validateInputInt(sc, "Nhập lựa chọn:");
            switch (choice) {
                case 1:
                    CustomerBusiness.displayLisCustomer();
                    break;
                case 2:
                    CustomerBusiness.addCustomer(sc);
                    break;
                case 3:
                    CustomerBusiness.editCustomer(sc);
                    break;
                case 4:
                    CustomerBusiness.deleteCustomer(sc);
                    break;
                case 5:
                    CustomerBusiness.searchCustomer(sc);
                    break;
                case 6:
                    CustomerBusiness.sortCustomers(sc);
                    break;
                case 0:
                    System.exit(0);
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại!");
            }
        } while (true);
    }
}
