package service;

import CRUDuser.CRUDUsers;
import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class userService implements CRUDUsers {
    public static List<User> userList = new ArrayList<>();
    static int id = 0;
    static boolean checkMenu = true;
    static boolean checkMenuLogin = true;

    static userService userService = new userService();
    static String regexEmail = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

    static String regexPassword = "^(?=.*\\d)(?=.*[a-z])(?=.*[.,-_;])(?=.*[A-Z])(?=.*[a-zA-Z]).{7,15}$";

    @Override
    public void editUser(User user, int checkNumber) {
        Scanner sc = new Scanner(System.in);
        if (checkNumber != 1 && checkNumber != 2 && checkNumber != 3) {
            System.out.println("Hãy nhập lại");
            editUser(user, checkNumber);
        }
        while (checkNumber == 1) {
            boolean checkUsername = true;
            System.out.println("Nhập tài khoản mới :");
            String username = sc.nextLine();
            for (User users : userList) {
                if (users.getUserName().equals(username)) {
                    System.out.println("Tài khoản đã tồn tại, hãy nhập lại");
                    checkUsername = false;
                }
            }
            if (checkUsername) {
                user.setUserName(username);
                System.out.println("Đổi thành công.");
                checkNumber = 0;
            }
        }
        while (checkNumber == 2) {
            System.out.println("Nhập password mới :");
            String password = sc.nextLine();
            boolean checkPassword = password.matches(regexPassword);
            if (!checkPassword) {
                System.out.println("Mật khẩu không đúng định dạng. Hãy nhập lại");
                continue;
            }
            user.setPassword(password);
            System.out.println("Đổi mật khẩu thành công.");
            checkNumber = 0;
        }
        while (checkNumber == 3) {
            boolean checkEmail = true;
            System.out.println("Nhập email mới :");
            String email = sc.nextLine();
            boolean checkEmailRegex = email.matches(regexEmail);
            if (!checkEmailRegex) {
                System.out.println("Email không đúng định dạng. Hãy nhập lại");
                continue;
            }
            for (User users : userList) {
                if (users.getEmail().equals(email)) {
                    System.out.println("Email đã tồn tại, hãy nhập lại");
                    checkEmail = false;
                }
            }
            if (checkEmail) {
                user.setEmail(email);
                System.out.println("Đổi thành công.");
                checkNumber = 0;
            }
        }

    }

    public static void forgetPass() {
        String emailRegister;
        boolean checkPass = true;
        System.out.println("Nhập Email đăng ký: ");
        emailRegister = new Scanner(System.in).nextLine();
        boolean checkEmail = emailRegister.matches(regexEmail);
        if (!checkEmail) {
            System.out.println("Email không đúng định dạng. Hãy nhập lại");
            forgetPass();
        }
        for (User user : userList) {
            if (user.getEmail().equals(emailRegister)) {
                checkPass = false;
                System.out.println("Hãy nhập mật khẩu mới");
                userService.editUser(user, 2);

            }
        }
        if (checkPass) {
            System.out.println("Email không đúng. Hãy nhập lại");
            forgetPass();
        }
    }

    public static void menu_Login(User user) {

        System.out.println("===Mời Bạn Chọn===");
        System.out.println("1. Thay đổi username");
        System.out.println("2. Thay đổi mật khẩu");
        System.out.println("3. Thay đổi email");
        System.out.println("4. Đăng xuất");
        System.out.println("0. Thoát");
        int key = new Scanner(System.in).nextInt();
        switch (key) {
            case 1:
                userService.editUser(user, 1);
                break;
            case 2:
                userService.editUser(user, 2);
                break;
            case 3:
                userService.editUser(user, 3);
                break;
            case 4:
                checkMenu = true;
                while (checkMenu) menu();
                break;
            case 0:
                System.exit(0);
                break;
        }
    }

    public static void Login() {

        String userNameInput;
        String passWordInput;
        System.out.println("Nhập vào tài khoản");
        userNameInput = new Scanner(System.in).nextLine();
        System.out.println("Nhập vào mật khẩu");
        passWordInput = new Scanner(System.in).nextLine();
        if (userList.isEmpty()) {
            System.out.println("Tài khoản không tồn tại.Hãy đăng ký tài khoản mới hoặc đăng nhập lại");
            menu();
        } else {
            for (User user : userList) {
                if (user.getUserName().equals(userNameInput) && user.getPassword().equals(passWordInput)) {
                    System.out.println("Đăng nhập thành công");
                    checkMenu = false;
                    System.out.println("Chào mừng " + user.getUserName() + " đã đăng nhập");
                    while (checkMenuLogin) menu_Login(user);
                } else {
                    System.out.println("Tài khoản hoặc mật khẩu không đúng. Hãy nhập lại");
                    menu();
                }
            }
        }

    }

    public static void menu() {
        System.out.println("===Mời Bạn Chọn===");
        System.out.println("1. ĐĂNG KÝ");
        System.out.println("2. ĐĂNG NHẬP");
        System.out.println("3. Quên mật khẩu");
        System.out.println("0. Thoát");
        int key = new Scanner(System.in).nextInt();
        switch (key) {
            case 1:
                Register();
                break;
            case 2:
                Login();
                break;
            case 3:
                forgetPass();
                break;
            case 0:
                System.exit(0);
                break;
        }
    }

    public static void Register() {

        String nameRegister;
        String emailRegister;
        String passwordRegister;
        System.out.println("Nhập Email cần đăng ký: ");
        emailRegister = new Scanner(System.in).nextLine();
        boolean checkEmail = emailRegister.matches(regexEmail);
        if (!checkEmail) {
            System.out.println("Email không đúng định dạng. Hãy nhập lại");
            Register();
        }
        System.out.println("Nhập Tên Tài Khoản: ");
        nameRegister = new Scanner(System.in).nextLine();
        for (User user : userList) {
            if (user.getUserName().equals(nameRegister)) {
                System.out.println("Tài khoản đã tồn tại. Hãy nhập lại");
                Register();
            }
        }
        while (true) {
            System.out.println("Nhập Mật khẩu");
            passwordRegister = new Scanner(System.in).nextLine();
            boolean checkPassword = passwordRegister.matches(regexPassword);
            if (!checkPassword) {
                System.out.println("Mật khẩu không đúng định dạng. Hãy nhập lại");
                continue;
            }
            break;
        }

        userList.add(new User(id, nameRegister, passwordRegister, emailRegister));
        System.out.println("Tạo tài khoản thành công");
        id++;
        menu();
    }


}
