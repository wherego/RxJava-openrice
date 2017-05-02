package com.sihua.rxjava.utils;

import android.annotation.SuppressLint;
import android.text.Html;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by ewingchiu on 11/11/14.
 */
public class StringUtil {
    public final static Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile(
            "^[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"
    );

    public static boolean isStringEmpty(String string) {
        if (string != null) {
            if (string.trim().length() > 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean isStringNullOrNoLength(String string) {
        if (string != null) {
            if (string.length() > 0) {
                return false;
            }
        }

        return true;
    }

    public static List<String> formattedPhoneArray(List<String> unformatted) {
        try {
            List<String> phones = new ArrayList<String>();
            for (String phone : unformatted) {
                if (phone.length() >= 8) {
                    phone = phone.replace("-", "");
                    phone = phone.replace(" ", "");
                    phone = String.format("%s %s", phone.substring(0, 4), phone.substring(4));
//	            if ([SETTING_MANAGER getCountryCode].length != 0) {
//	                phone =[NSString stringWithFormat:@"(%@) %@",[SETTING_MANAGER getCountryCode] , phone];
//	            }
                    phones.add(phone);
                }
            }
            return phones;
        } catch (Exception e) {
            return unformatted;
        }
    }

    public static boolean isValidEmail(String email) {
        return EMAIL_ADDRESS_PATTERN.matcher(email).matches();
    }

    public final static boolean containNumberOnly(String inputString) {

        boolean isNumeric = false;

        try {
            long value = Long.parseLong(inputString);
            isNumeric = true;

        } catch (NumberFormatException e) {

        }

        return isNumeric;
    }

    public static String joinList(List<String> list, String joinString) {
        if (list == null || list.size() == 0) return null;
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            if (sb.length() > 0) sb.append(joinString);
            sb.append(s);
        }
        return sb.toString();
    }

    public static String extractDigits(String str) {
        return str.replaceAll("[^0-9]", "");
    }

    public static double tryParseDouble(String value, double defaultValue) {
        try {
            double tempValue = Double.parseDouble(value);
            return tempValue;
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public static int tryParseInt(String value, int defaultValue) {
        try {
            int tempValue = Integer.parseInt(value);
            return tempValue;
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public static float tryParseFloat(String value, float defaultValue) {
        try {
            float tempValue = Float.parseFloat(value);
            return tempValue;
        } catch (Exception e) {
            return defaultValue;
        }
    }

//    public static Date tryParseDate(String value, String dateFormat,
//                                    Date defaultValue) {
//        try {
//            SimpleDateFormat format = new SimpleDateFormat(dateFormat);
//            Date tempValue = format.parse(value);
//            return tempValue;
//        } catch (Exception e) {
//            return defaultValue;
//        }
//    }

    public static long tryParseLong(String value, long defaultValue) {
        try {
            long tempValue = Long.parseLong(value);
            return tempValue;
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public static byte[] tryParseByte(String value) {
        return value.getBytes();
    }


    public static boolean isChinese(String value) {
        String chineseRegPattern = "^([\\u4e00-\\u9fff]|\\s)+$";
        return value.matches(chineseRegPattern);
    }

    @SuppressLint("NewApi")
    public static String escapeHtml(CharSequence text) {
        //For escape the text for HTML format
        //Use Android SDK native Html.escapeHtml format if the SDK is equal/more than API level 16 (JELLY BEAN)
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
            return Html.escapeHtml(text);
        } else {
            //Below code and "withinStyle" method is copy from Android SDK source code base on API Level 4.4 KitKat
            //Assume the coding is same as above Android native method Html.escapeHtml(text)
            StringBuilder out = new StringBuilder();
            withinStyle(out, text, 0, text.length());
            return out.toString();
        }
    }

    //Coding copy from Android SDK source code API Level 4.4 KitKat
    private static void withinStyle(StringBuilder out, CharSequence text, int start, int end) {
        for (int i = start; i < end; i++) {
            char c = text.charAt(i);
            if (c == '<') {
                out.append("&lt;");
            } else if (c == '>') {
                out.append("&gt;");
            } else if (c == '&') {
                out.append("&amp;");
            } else if (c >= 0xD800 && c <= 0xDFFF) {
                if (c < 0xDC00 && i + 1 < end) {
                    char d = text.charAt(i + 1);
                    if (d >= 0xDC00 && d <= 0xDFFF) {
                        i++;
                        int codepoint = 0x010000 | (int) c - 0xD800 << 10 | (int) d - 0xDC00;
                        out.append("&#").append(codepoint).append(";");
                    }
                }
            } else if (c > 0x7E || c < ' ') {
                out.append("&#").append((int) c).append(";");
            } else if (c == ' ') {
                while (i + 1 < end && text.charAt(i + 1) == ' ') {
                    out.append("&nbsp;");
                    i++;
                }
                out.append(' ');
            } else {
                out.append(c);
            }
        }
    }

    public static boolean containsIgnoreCase(final CharSequence str, final CharSequence searchStr) {
        if (isStringEmpty(str.toString()) || isStringEmpty(searchStr.toString())) {
            return false;
        }
        return str.toString().toLowerCase().contains(searchStr.toString().toLowerCase());
    }

    public static String listToString(List<String> list, char separator) {
        StringBuilder sb = new StringBuilder();
        for (String str : list)
            sb.append(str).append(separator);
        return sb.toString().length() > 0 ? sb.toString().substring(0, sb.toString().length() - 1) : "";
    }

    public static boolean compareLatestDate(String DATE1, String DATE2, String dateFormat) {
        if (StringUtil.isStringNullOrNoLength(dateFormat))
            return false;

        DateFormat df = new SimpleDateFormat(dateFormat);
        try {
            Date dt1 = df.parse(DATE1);
            Date dt2 = df.parse(DATE2);
            if (dt1.getTime() > dt2.getTime()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return false;
    }
}
