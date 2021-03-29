package com.example.demo.validation;

import com.example.demo.object.User;

public class registerValidator {
    public static Boolean isNoLegit(User user){
        System.out.println(user.getEmail().length());
        if (user.getEmail().length()<40){
            String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
            java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
            java.util.regex.Matcher m = p.matcher(user.getEmail());
            System.out.println(m.matches());
            return !(m.matches());
        }else{
            return true;
        }
    }
}
