package ra.validate;

import java.util.Scanner;

public class validator {
    public static String validateInputString(Scanner sc, String message, StringRule stringRule) {
        System.out.println(message);
        do {
            String inputString = sc.nextLine();
            if (stringRule.isValidString(inputString)) {
                return inputString;
            }
            System.err.println("Dữ liệu không hợp lệ, vui lòng nhập lại");
        } while (true);
    }

    public static int validateInputInt(Scanner scanner, String message) {
        System.out.println(message);
        do {
            if (!scanner.hasNextInt()) {
                //Không phải số nguyên
                System.err.println("Dữ liệu không phải số nguyên, vui lòng nhập lại");
                scanner.nextLine();
                continue;
            }
            //Là số nguyên
            return Integer.parseInt(scanner.nextLine());
        } while (true);
    }

    public static boolean validateInputBoolean(Scanner scanner, String message) {
        System.out.println(message);
        do {
            String inputString = scanner.nextLine();
            if (inputString.equalsIgnoreCase("true") || inputString.equalsIgnoreCase("false")) {
                return Boolean.parseBoolean(inputString);
            }
            System.err.println("Kiểu dữ liệu không hợp lệ, vui lòng nhập lại");
        } while (true);
    }
}
