package ra.validate;

import java.util.Scanner;
import ra.persentation.CustomerApplication;
import java.util.regex.Pattern;
public class CustomerValidator {
    public static String validateCustomerId(Scanner sc, String message, String regex){
        System.out.println(message);
        do{
            String inputString =  sc.nextLine();
            if(Pattern.matches(regex, inputString)){
                return inputString;
            }
            System.err.println("Dữ liệu không hợp lệ, vui lòng nhập lại");
        }while(true);
    }
    public static String isCustomerExit(Scanner sc, String value, String type){
        do{
            boolean isExit = false;
            switch (type){
                case "CustomerId":
                    for(int i = 0; i < CustomerApplication.currentCustomerIndex; i++){
                        if(CustomerApplication.arrCustomers[i].getCustomerId().equals(value)){
                            isExit = true;
                            break;
                        }
                    }
                    break;
                case "FirstName":
                    for(int i = 0; i < CustomerApplication.currentCustomerIndex; i++){
                        if(CustomerApplication.arrCustomers[i].getFirstName().equals(value)){
                            isExit = true;
                            break;
                        }
                    }
                break;
                case "LastName":
                    for(int i = 0; i < CustomerApplication.currentCustomerIndex; i++){
                        if(CustomerApplication.arrCustomers[i].getLastName().equals(value)){
                            isExit = true;
                            break;
                        }
                    }
                break;
                case "dateOfBirth":
                    for(int i = 0; i < CustomerApplication.currentCustomerIndex; i++){
                        if(CustomerApplication.arrCustomers[i].getDateOfBirth().equals(value)){
                            isExit = true;
                            break;
                        }
                    }
                break;
                case "address":
                    for(int i = 0; i < CustomerApplication.currentCustomerIndex; i++){
                        if(CustomerApplication.arrCustomers[i].getAddress().equals(value)){
                            isExit = true;
                            break;
                        }
                    }
                break;
                case "phoneNumber":
                    for(int i = 0; i < CustomerApplication.currentCustomerIndex; i++){
                        if(CustomerApplication.arrCustomers[i].getPhoneNumber().equals(value)){
                            isExit = true;
                            break;
                        }
                    }
                break;
                case "email":
                    for(int i = 0; i < CustomerApplication.currentCustomerIndex; i++){
                        if(CustomerApplication.arrCustomers[i].getEmail().equals(value)){
                            isExit = true;
                            break;
                        }
                    }
                break;
            }
            if(!isExit){
                return value;
            }
            System.err.println("Dữ liệu bị trùng lặp.Vui lòng nhập lại");
            value = sc.nextLine();

        }while(true);
    }
}
