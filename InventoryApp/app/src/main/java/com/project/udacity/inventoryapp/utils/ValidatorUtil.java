package com.project.udacity.inventoryapp.utils;

import android.text.TextUtils;
import android.util.Patterns;

public class ValidatorUtil {

    private ValidatorUtil(){}

    public static boolean isValidPhoneNumber(CharSequence phoneNumber) {
        if (!TextUtils.isEmpty(phoneNumber)) {
            return !Patterns.PHONE.matcher(phoneNumber).matches();
        }
        return true;
    }
}
