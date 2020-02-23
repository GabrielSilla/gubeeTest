package com.gubee.gubee.util;

import java.util.List;

public class FunctionUtils {

    public static boolean isNullOrEmpty(String value) {
        if(value == null || value.isEmpty()) return true;
        return false;
    }

    public static boolean isNullOrEmpty(List list) {
        if(list == null || list.isEmpty()) return true;
        return false;
    }
}
