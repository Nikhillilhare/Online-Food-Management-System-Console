package util;

public class Validation {

    //Validating Name
    public static boolean isValidName(String name){
        if (name == null || name.trim().isEmpty() || name == "") return  false;
        return true;
    }

    //Validating Email
    public static boolean isValidEmail(String email ){
        if (email == null || email.trim().isEmpty() || email == "") return false;
        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }

    //Validating Mobile
    public static boolean isValidMobile(String mobile){
        if (mobile == null || mobile == "") return false;
        return mobile.matches("[6-9][0-9]{9}");
    }

    //validating Password
    public static boolean isValidPassword(String password){
        if (password==null || password.length() < 4 || password == "") return false;
        return true;
    }

}
