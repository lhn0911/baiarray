package ra.bussiness;

import ra.persentation.CustomerApplication;
import ra.entity.Customer;
import ra.validate.validator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class CustomerBusiness {
    public static void displayLisCustomer() {
        if (CustomerApplication.currentCustomerIndex == 0) {
            System.out.println("Danh sách trống");
            return;
        }
        for (int i = 0; i < CustomerApplication.currentCustomerIndex; i++) {
            CustomerApplication.arrCustomers[i].displayData();
        }
    }

    public static void addCustomer(Scanner sc) {
        if (CustomerApplication.currentCustomerIndex >= CustomerApplication.arrCustomers.length) {
            System.out.println("Danh sách khách hàng đã đầy!");
            return;
        }
        System.out.println("Nhập số lượng khách hàng cần thêm:");
        int count;
        do {
            count = validator.validateInputInt(sc, "Nhập số lượng:");
            if (count <= 0 || count > (CustomerApplication.arrCustomers.length - CustomerApplication.currentCustomerIndex)) {
                System.out.println("Số lượng không hợp lệ, vui lòng nhập lại!");
            }
        } while (count <= 0 || count > (CustomerApplication.arrCustomers.length - CustomerApplication.currentCustomerIndex));

        for (int i = 0; i < count; i++) {
            System.out.println("Nhập thông tin khách hàng " + (i + 1) + ":");
            Customer newCustomer = new Customer();
            newCustomer.inputData(sc);
            CustomerApplication.arrCustomers[CustomerApplication.currentCustomerIndex++] = newCustomer;
        }
        System.out.println("Thêm khách hàng thành công!");
    }

    public static void editCustomer(Scanner sc) {
        System.out.println("Nhập ID khách hàng cần chỉnh sửa: ");
        String id = sc.nextLine();
        for (int i = 0; i < CustomerApplication.currentCustomerIndex; i++) {
            if (CustomerApplication.arrCustomers[i].getCustomerId().equals(id)) {
                Customer customer = CustomerApplication.arrCustomers[i];
                System.out.println("Thông tin cũ:");
                customer.displayData();

                boolean isEditing = true;
                while (isEditing) {
                    System.out.println("Chọn thông tin cần sửa:");
                    System.out.println("1. Tên");
                    System.out.println("2. Họ");
                    System.out.println("3. Năm sinh");
                    System.out.println("4. Loại khách hàng");
                    System.out.println("5. Số điện thoại");
                    System.out.println("6. Thoát");
                    int choice = validator.validateInputInt(sc, "Nhập lựa chọn:");

                    switch (choice) {
                        case 1:
                            System.out.println("Nhập tên mới:");
                            customer.setFirstName(sc.next());
                            break;
                        case 2:
                            System.out.println("Nhập họ mới:");
                            customer.setLastName(sc.next());
                            break;
                        case 3:
                            System.out.println("Nhập năm sinh mới:");
                            customer.setDateOfBirth(sc.next());
                            break;
                        case 4:
                            System.out.println("Nhập loại khách hàng mới:");
                            customer.setCustomerType(sc.next());
                            break;
                        case 5:
                            System.out.println("Nhập số điện thoại mới:");
                            customer.setPhoneNumber(sc.next());
                            break;
                        case 6:
                            isEditing = false;
                            break;
                        default:
                            System.out.println("Lựa chọn không hợp lệ!");
                    }
                }
                System.out.println("Cập nhật thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy khách hàng!");
    }
    public static void deleteCustomer(Scanner sc) {
        System.out.println("Nhập ID khách hàng cần xóa: ");
        String id = sc.nextLine();
        for (int i = 0; i < CustomerApplication.currentCustomerIndex; i++) {
            if (CustomerApplication.arrCustomers[i].getCustomerId() == id) {
                System.out.println("Bạn có chắc chắn muốn xóa khách hàng này? (Y/N)");
                String confirm = sc.next().trim().toLowerCase();
                if (confirm.equals("y")) {
                    for (int j = i; j < CustomerApplication.currentCustomerIndex - 1; j++) {
                        CustomerApplication.arrCustomers[j] = CustomerApplication.arrCustomers[j + 1];
                    }
                    CustomerApplication.currentCustomerIndex--;
                    System.out.println("Xóa thành công!");
                } else {
                    System.out.println("Hủy thao tác!");
                }
                return;
            }
        }
        System.out.println("Không tìm thấy khách hàng!");
    }
    public static void searchCustomer(Scanner sc) {
        System.out.println("Chọn tiêu chí tìm kiếm:");
        System.out.println("1. Tìm theo tên");
        System.out.println("2. Tìm theo loại khách hàng");
        System.out.println("3. Tìm theo số điện thoại");
        int choice = validator.validateInputInt(sc, "Nhập lựa chọn:");
        boolean found = false;

        switch (choice) {
            case 1:
                System.out.println("Nhập tên khách hàng:");
                String name = sc.next().toLowerCase();
                for (Customer c : CustomerApplication.arrCustomers) {
                    if (c != null && c.getFirstName().toLowerCase().contains(name)) {
                        c.displayData();
                        found = true;
                    }
                }
                break;
            case 2:
                System.out.println("Nhập loại khách hàng:");
                String type = sc.next();
                for (Customer c : CustomerApplication.arrCustomers) {
                    if (c != null && c.getCustomerType().equalsIgnoreCase(type)) {
                        c.displayData();
                        found = true;
                    }
                }
                break;
            case 3:
                System.out.println("Nhập số điện thoại:");
                String phone = sc.next();
                for (Customer c : CustomerApplication.arrCustomers) {
                    if (c != null && c.getPhoneNumber().equals(phone)) {
                        c.displayData();
                        found = true;
                    }
                }
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ!");
                return;
        }
        if (!found) {
            System.out.println("Không tìm thấy kết quả phù hợp!");
        }
    }



    public static void sortCustomers(Scanner sc) {
        if (CustomerApplication.currentCustomerIndex == 0) {
            System.out.println("Không có khách hàng để sắp xếp");
            return;
        }
        System.out.println("Chọn tiêu chí sắp xếp:");
        System.out.println("1. Theo tên (A-Z)");
        System.out.println("2. Theo tên (Z-A)");
        System.out.println("3. Theo năm sinh (Tăng dần)");
        System.out.println("4. Theo năm sinh (Giảm dần)");
        int choice = validator.validateInputInt(sc, "Nhập lựa chọn:");

        switch (choice) {
            case 1:
                Arrays.sort(CustomerApplication.arrCustomers, 0, CustomerApplication.currentCustomerIndex,
                        Comparator.comparing(Customer::getFirstName, String::compareToIgnoreCase));
                break;
            case 2:
                Arrays.sort(CustomerApplication.arrCustomers, 0, CustomerApplication.currentCustomerIndex,
                        (c1, c2) -> c2.getFirstName().compareToIgnoreCase(c1.getFirstName()));
                break;
            case 3:
                Arrays.sort(CustomerApplication.arrCustomers, 0, CustomerApplication.currentCustomerIndex,
                        Comparator.comparingInt(c -> Integer.parseInt(c.getDateOfBirth())));
                break;
            case 4:
                Arrays.sort(CustomerApplication.arrCustomers, 0, CustomerApplication.currentCustomerIndex,
                        (c1, c2) -> Integer.parseInt(c2.getDateOfBirth()) - Integer.parseInt(c1.getDateOfBirth()));
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ!");
                return;
        }
        System.out.println("Sắp xếp thành công!");
    }
}
