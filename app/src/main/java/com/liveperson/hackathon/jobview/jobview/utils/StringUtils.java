package com.liveperson.hackathon.jobview.jobview.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by dudu on 1/4/17.
 */

public class StringUtils {

    public static final String EMAIL_PATTERN = "[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}";

    static Pattern emailPattern = Pattern.compile(EMAIL_PATTERN);


    public static boolean validateEmailAddress(String email){
        Matcher matcher = emailPattern.matcher(email);
        if (matcher.find()) {
            return true;
        }
        return false;
    }

}
