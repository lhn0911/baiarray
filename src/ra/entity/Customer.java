package ra.entity;

import ra.persentation.CustomerApplication;
import ra.validate.StringRule;
import ra.validate.validator;
import ra.validate.CustomerValidator;

import java.util.Scanner;

public class Customer implements IApp {
    private String CustomerId;
    private String FirstName;
    private String LastName;
    private String dateOfBirth;
    private boolean gender;
    private String address;
    private String phoneNumber;
    private String Email;
    private String customerType;

    public Customer() {
    }

    public Customer(String customerId, String firstName, String lastName, String dateOfBirth, boolean gender, String address, String phoneNumber, String email, String customerType) {
        this.CustomerId = customerId;
        this.FirstName = firstName;
        this.LastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.Email = email;
        this.customerType = customerType;
    }

    public String getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(String customerId) {
        CustomerId = customerId;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    @Override
    public void inputData(Scanner sc) {
        this.CustomerId = inputCustomerId(sc);
        this.FirstName = inputFirstName(sc);
        this.LastName = inputLastName(sc);
        this.address = inputAddress(sc);
        this.phoneNumber = inputPhoneNumber(sc);
        this.Email = inputEmail(sc);
        this.dateOfBirth = inputDateOfBirth(sc);
        this.gender = validator.validateInputBoolean(sc,"Nhập giới tính");
        this.customerType = validator.validateInputString(sc,"Nhập loại khách hàng",new StringRule(0,255));
    }

    public String inputCustomerId(Scanner sc) {
        String CustomerId = CustomerValidator.validateCustomerId(sc, "Nhập mã khách hàng", "C\\d{4}");
        return CustomerValidator.isCustomerExit(sc, CustomerId, "CustomerId");
    }
    public String inputFirstName(Scanner sc) {
        String FirstName = validator.validateInputString(sc, "Nhập vào tên khách hàng", new StringRule(1,50));
        return CustomerValidator.isCustomerExit(sc, FirstName, "FirstName");
    }
    public String inputLastName(Scanner sc) {
        String LastName = validator.validateInputString(sc,"Nhập vào họ khách hàng", new StringRule(1,30));
        return CustomerValidator.isCustomerExit(sc, LastName, "LastName");
    }
    public String inputDateOfBirth(Scanner sc) {
        String DateOfBirth = CustomerValidator.validateCustomerId(sc,"Nhập vào ngày sinh","\\d{2}\\d{2}\\d{4}");
        return  CustomerValidator.isCustomerExit(sc, DateOfBirth, "DateOfBirth");
    }
    public String  inputAddress(Scanner sc) {
        String Address = validator.validateInputString(sc,"Nhập địa chỉ",new StringRule(1,255));
        return CustomerValidator.isCustomerExit(sc, Address, "Address");
    }
    public  String inputPhoneNumber(Scanner sc) {
        String PhoneNumber = CustomerValidator.validateCustomerId(sc,"Nhập số điện thoại", "(((\\+|)84)|0)(3|5|7|8|9)+([0-9]{8})");
        return CustomerValidator.isCustomerExit(sc, PhoneNumber, "PhoneNumber");
    }
    public  String inputEmail(Scanner sc) {
        String Emaill = CustomerValidator.validateCustomerId(sc,"Nhập email","^[a-zA-Z0-9._%+-]+@gmail\\.com$");
        return CustomerValidator.isCustomerExit(sc, Emaill, "Email");
    }

    @Override
    public void displayData() {
        System.out.println("Mã khách hàng: "+CustomerId);
        System.out.println("Họ tên: "+LastName+" "+FirstName);
        System.out.println("Ngày sinh: "+dateOfBirth);
        System.out.println("Giới tính: "+ gender);
        System.out.printf("Thông tin: Số điện thoại: %s - Email: %s",phoneNumber, Email);
        System.out.println("Loại khách hàng: "+customerType);
    }
}
