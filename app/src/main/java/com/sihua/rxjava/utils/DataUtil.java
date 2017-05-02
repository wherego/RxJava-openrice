package com.sihua.rxjava.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.text.format.DateUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.sihua.rxjava.Constants;
import com.sihua.rxjava.R;

import java.math.BigDecimal;
import java.net.URL;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataUtil {

    private final static float SCREEN_WIDTH_STANDARD = 320F;

    public static String formatPrice(Context context, BigDecimal amount, int regionId) {
        return formatPrice(context, amount, regionId, false);
    }

    public static String formatPrice(Context context, float amount, int regionId) {
        return formatPrice(context, amount, regionId, false);
    }

    public static String formatPrice(Context context, BigDecimal amount, int regionId, boolean isSubtract) {
        final String dollarSign = "$";
        final NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
        numberFormat.setMinimumFractionDigits(0);
        numberFormat.setMaximumFractionDigits(2);
        final String priceStr = numberFormat.format(amount);
        return String.format("%s%s%s", isSubtract ? "-" : "", dollarSign, priceStr);
    }

    public static String formatPrice(Context context, float amount, int regionId, boolean isSubtract) {
        final String dollarSign = "$";
        final NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
        numberFormat.setMinimumFractionDigits(0);
        numberFormat.setMaximumFractionDigits(2);
        final String priceStr = numberFormat.format(amount);
        return String.format("%s%s%s", isSubtract ? "-" : "", dollarSign, priceStr);
    }

    public static boolean isEmailValid(String email) {
        boolean isValid = false;
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }

    public static boolean validEmail(String email) {

        boolean result = false;

        String expression = "\\b[_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.((aero|coop|info|museum|name)|([0-9]{1,3})|([a-zA-Z]{2,3}))\\b";
        CharSequence inputStr = email;
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            result = true;
        }
        return result;
    }


    public static String extractYoutubePreviewUrl(String url) {
        String imageUrl = "";
        try {
            String query = new URL(url).getQuery();
            String id = null;
            String[] param = query.split("&");
            for (String row : param) {
                String[] param1 = row.split("=");
                if (param1[0].equals("v")) {
                    id = param1[1];
                }
            }
            if (id != null) {
                imageUrl = "http://img.youtube.com/vi/" + id + "/0.jpg";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return imageUrl;
    }

    public static String ChopLike(int likeCount, boolean hasPlus) {
        String choppedLike = likeCount + "";

        int huc = likeCount / 100;

        if (huc > 0) {
            if (huc >= 10) {
                float th = (float) huc / 10;
                //choppedLike = new java.text.DecimalFormat("#").format(th)+"K+";
                int floating = huc % 10;
                if (floating == 0) {
                    choppedLike = (int) th + "K";
                } else {
                    choppedLike = th + "K";
                }

            } else {
                choppedLike = huc + "00";
            }
        } else {
            choppedLike = "" + (likeCount);
        }
        if (hasPlus) {
            return "+" + choppedLike;
        } else {
            return choppedLike;
        }
    }

    public static float px2dip(Context context, int px) {
        if (context != null) {
            final float scale = context.getResources().getDisplayMetrics().density;
            return (px - 0.5f) / scale;
        }

        //Use 1.0f as a default value, 1.0f is more safety compare with use 0.0f as a default
        return 1.0f;
    }

    public static float dip2px(Context context, int dip) {
        if (context != null) {
            final float scale = context.getResources().getDisplayMetrics().density;
            return (dip * scale + 0.5f);
        }

        //Use 1.0f as a default value, 1.0f is more safety compare with use 0.0f as a default
        return 1.0f;
    }

    public static int dip2pxInt(Context context, int dip) {
        if (context != null) {
            return Math.round(dip2px(context, dip));
        }

        //Use 1 as a default value, 1 is more safety compare with use zero as a default
        return 1;
    }

    public static int getTargetWidth(int standardWidth, int standardHeight,
                                     int targetHeight) {
        float targetWidth = (float) standardWidth / ((float) standardHeight / (float) targetHeight);
        return Math.round(targetWidth);
    }

    public static int getTargetHeight(int standardWidth, int standardHeight,
                                      int targetWidth) {
        float targetHeight = (float) standardHeight / ((float) standardWidth / (float) targetWidth);
        return Math.round(targetHeight);
    }

    public static int getDimenInt(Context context, int dimenId) {
        if (context != null) {
            return Math.round(context.getResources().getDimension(dimenId));
        }

        //Use 1 as a default value, 1 is more safety compare with use zero as a default
        return 1;
    }

    public static int spToPixel(Context context, Float sp) {
        if (context != null) {
            final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
            return (int) (sp * fontScale + 0.5f);
        }

        //Use 1 as a default value, 1 is more safety compare with use zero as a default
        return 1;
    }

    public static float pixelsToSp(Context context, Float px) {
        if (context != null) {
            float scaledDensity = context.getResources().getDisplayMetrics().scaledDensity;
            return px / scaledDensity;
        }

        //Use 1.0f as a default value, 1.0f is more safety compare with use 0.0f as a default
        return 1.0f;
    }

    /**
     * @ying testing
     */

    public static int getNotificationBarHeight(Activity activity) {
        if (activity != null) {
            Rect rectgle = new Rect();
            Window window = activity.getWindow();
            window.getDecorView().getWindowVisibleDisplayFrame(rectgle);
            return rectgle.top;
        }

        //Use 1 as a default value, 1 is more safety compare with use zero as a default
        return 1;
    }

    public static void resetViewSize(View view, int width, int height) {
        if (view != null) {
            view.getLayoutParams().width = width;
            view.getLayoutParams().height = height;
        }
    }

    public static void resetViewSize(View view, Point sizePoint) {
        if (view != null) {
            view.getLayoutParams().width = sizePoint.x;
            view.getLayoutParams().height = sizePoint.y;
        }
    }

    public static Point scaleWithScreenWidth(Context context, int width,
                                             int height) {
        if (context != null) {
            Point scaledDip = new Point();
            scaledDip.x = Math.round((float) width / SCREEN_WIDTH_STANDARD * (float) DeviceUtil.getDeviceWidth(context));
            scaledDip.y = Math.round((float) scaledDip.x / (float) width * (float) height);
            return scaledDip;
        }

        //Use 1 as a default value, 1 is more safety compare with use zero as a default
        return new Point(1, 1);
    }

    public static Point scaleWithScreenWidth(Context context, Point sizePoint) {
        return scaleWithScreenWidth(context, sizePoint.x, sizePoint.y);
    }

    public static Point scaleByWidthMargin(Context context, //
                                           float picWidth, float picHeight, //
                                           float leftMargin, float rightMargin) {
        if (context != null) {
            Point scaledDip = new Point();
            scaledDip.x = DeviceUtil.getDeviceWidth(context) - Math.round((leftMargin + rightMargin) / SCREEN_WIDTH_STANDARD * DeviceUtil.getDeviceWidth(context));
            scaledDip.y = Math.round((float) scaledDip.x / picWidth * picHeight);
            return scaledDip;
        }

        //Use 1 as a default value, 1 is more safety compare with use zero as a default
        return new Point(1, 1);
    }

    public static int dip2pxByScreenWidthInt(Context context, float dip) {
        return Math.round(dip2pxByScreenWidth(context, dip));
    }

    public static float dip2pxByScreenWidth(Context context, float dip) {
        return (dip / 320F * (float) DeviceUtil.getDeviceWidth(context));
    }

    public static boolean isEmpty(List<?> list) {
        if (list != null) {
            return list.isEmpty();
        }
        return true;
    }

    public static int getScreenWidth(Context context) {
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);

        return wm.getDefaultDisplay().getWidth();
    }

    public static int getScreenHeight(Context context) {
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);

        return wm.getDefaultDisplay().getHeight();
    }

    public static String formatDate(String dateString, String outputFormat, String inputFormat, Locale locale) {
        String formattedDate = dateString;
        if (StringUtil.isStringEmpty(outputFormat)) {
            outputFormat = Constants.DATE_DEFAULT_DISPLAY_FORMAT;
        }
        if (inputFormat == null)
            inputFormat = Constants.API_RESPONSE_DATE_FORMAT;
        try {
            SimpleDateFormat inputFormatter = new SimpleDateFormat(inputFormat);
            SimpleDateFormat outputFormatter;
            if (locale == null) {
                outputFormatter = new SimpleDateFormat(outputFormat);
            } else {
                outputFormatter = new SimpleDateFormat(outputFormat, locale);
            }
            Date date = inputFormatter.parse(dateString);
            formattedDate = outputFormatter.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            SimpleDateFormat inputFormatter = new SimpleDateFormat(Constants.API_RESPONSE_DATE_FORMAT_OLD);
            SimpleDateFormat outputFormatter;
            if (locale == null) {
                outputFormatter = new SimpleDateFormat(outputFormat);
            } else {
                outputFormatter = new SimpleDateFormat(outputFormat, locale);
            }
            Date date = inputFormatter.parse(dateString);
            formattedDate = outputFormatter.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return formattedDate;
    }

    public static String formatDate(String dateStr, String format, Locale locale) {
//        String formattedDate = dateStr;
//        if (StringUtil.isStringEmpty(format)) {
//            format = Constants.DATE_DEFAULT_DISPLAY_FORMAT;
//        }
//        try {
//            SimpleDateFormat inputFormatter = new SimpleDateFormat(Constants.API_RESPONSE_DATE_FORMAT);
//            SimpleDateFormat outputFormatter;
//            if (locale == null) {
//                outputFormatter = new SimpleDateFormat(format);
//            }else{
//                outputFormatter = new SimpleDateFormat(format, locale);
//            }
//            Date date = inputFormatter.parse(dateStr);
//            formattedDate = outputFormatter.format(date);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            SimpleDateFormat inputFormatter = new SimpleDateFormat(Constants.API_RESPONSE_DATE_FORMAT_OLD);
//            SimpleDateFormat outputFormatter;
//            if (locale == null) {
//                outputFormatter = new SimpleDateFormat(format);
//            }else{
//                outputFormatter = new SimpleDateFormat(format, locale);
//            }
//            Date date = inputFormatter.parse(dateStr);
//            formattedDate = outputFormatter.format(date);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return formatDate(dateStr, format, null, locale);
    }

    public static String formatDate(String dateStr, String format) {
        return formatDate(dateStr, format, null);
    }

    public static String formatDate(String dateStr) {
        return formatDate(dateStr, null);
    }

    public static String formatZoneTime(String dateString, String format) {
        String formatTime = null;
        String tzId = TimeZone.getDefault().getID();
        TimeZone tz = TimeZone.getTimeZone(tzId);
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        formatter.setTimeZone(tz);
        try {
            Date date = formatter.parse(dateString);
            formatter = new SimpleDateFormat(Constants.API_RESPONSE_DATE_FORMAT);
            formatTime = formatter.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formatTime;
    }

    public static Date getDate(String dateStr) {
        try {
            SimpleDateFormat inputFormatter = new SimpleDateFormat(Constants.API_RESPONSE_DATE_FORMAT);
            return inputFormatter.parse(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            SimpleDateFormat inputFormatter = new SimpleDateFormat(Constants.API_RESPONSE_DATE_FORMAT_OLD);
            return inputFormatter.parse(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date getDate(String dateStr, String inputFormat) {
        try {
            SimpleDateFormat inputFormatter = new SimpleDateFormat(inputFormat);
            return inputFormatter.parse(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getRelativeTimeSpanString(String dateStr) {
        try {
            final long inputTime = getDate(dateStr).getTime();
            final long currentTime = new Date().getTime();
            if (Math.abs(currentTime - inputTime) > DateUtils.WEEK_IN_MILLIS) {
                return formatDate(dateStr);
            } else {
                return DateUtils.getRelativeTimeSpanString(inputTime, currentTime, DateUtils.FORMAT_ABBREV_RELATIVE).toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return formatDate(dateStr);
    }

    public static String conventToDateTextOnlyDate(Context context, String dataString) {
        String pattern = "yyyy-MM-dd";
        String displayPattern = "yyyy-MM-dd";
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);

            Date date = sdf.parse(dataString);
            long time = date.getTime();
            Date currentDate = new Date();
            long currentTime = currentDate.getTime();

            long apartTime = currentTime - time;
            long apartSecond = apartTime / 1000;
            if (apartSecond > 60) {
                long apartMin = apartSecond / 60;
                if (apartMin > 60) {
                    long apartHour = apartMin / 60;
                    if (apartHour >= 24) {
                        long apartDay = apartHour / 24;
                        if (apartDay > 7) {
                            SimpleDateFormat displaySDF = new SimpleDateFormat(displayPattern);
                            return displaySDF.format(date);
                        } else {
                            if (apartDay == 1)
                                return String.format(context.getString(R.string.time_day_ago), apartDay);
                            return String.format(context.getString(R.string.time_days_ago), apartDay);
                        }
                    } else {
                        if (apartHour == 1)
                            return String.format(context.getString(R.string.time_hour_ago), apartHour);
                        return String.format(context.getString(R.string.time_hours_ago), apartHour);
                    }
                } else {
                    if (apartMin == 1)
                        return String.format(context.getString(R.string.time_minute_ago), apartMin);
                    return String.format(context.getString(R.string.time_minutes_ago), apartMin);
                }
            } else {
                return context.getString(R.string.time_now);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String conventToDateText(Context context, String dataString) {
        String pattern = "yyyy-MM-dd'T'HH:mm:ss+SSS";
        String displayPattern = "yyyy-MM-dd";
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);

            Date date = sdf.parse(dataString);
            long time = date.getTime();
            Date currentDate = new Date();
            long currentTime = currentDate.getTime();

            long apartTime = currentTime - time;
            long apartSecond = apartTime / 1000;
            if (apartSecond > 60) {
                long apartMin = apartSecond / 60;
                if (apartMin > 60) {
                    long apartHour = apartMin / 60;
                    if (apartHour >= 24) {
                        long apartDay = apartHour / 24;
                        if (apartDay > 7) {
                            SimpleDateFormat displaySDF = new SimpleDateFormat(displayPattern);
                            return displaySDF.format(date);
                        } else {
                            if (apartDay == 1)
                                return String.format(context.getString(R.string.time_day_ago), apartDay);
                            return String.format(context.getString(R.string.time_days_ago), apartDay);
                        }
                    } else {
                        if (apartHour == 1)
                            return String.format(context.getString(R.string.time_hour_ago), apartHour);
                        return String.format(context.getString(R.string.time_hours_ago), apartHour);
                    }
                } else {
                    if (apartMin == 1)
                        return String.format(context.getString(R.string.time_minute_ago), apartMin);
                    return String.format(context.getString(R.string.time_minutes_ago), apartMin);
                }
            } else {
                return context.getString(R.string.time_now);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String getRelativeDate(Context context, String dataString, Locale locale, DateFormat df) {
        String ret = dataString;

        try {
            Date d = df.parse(dataString);
            final long inputTime = d.getTime();

            d = df.parse(df.format(new Date()));
            final long currentTime = d.getTime();

            final long diff = inputTime - currentTime;
            if (diff >= 0 && diff < 24 * 60 * 60 * 1000) {
                ret = context.getString(R.string.today);
            } else if (diff >= 24 * 60 * 60 * 1000 && diff < 2 * 24 * 60 * 60 * 1000) {
                ret = context.getString(R.string.tomorrow);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return ret;
    }

    public static String getRelativeDate(Context context, String dataString, Locale locale) {
        String ret = null;
        final SimpleDateFormat sdf = new SimpleDateFormat(Constants.DATE_DEFAULT_DISPLAY_FORMAT);

        try {
            Date d = sdf.parse(dataString);
            final long inputTime = d.getTime();

            d = sdf.parse(sdf.format(new Date()));
            final long currentTime = d.getTime();

            final long diff = inputTime - currentTime;
            if (diff >= 0 && diff < 24 * 60 * 60 * 1000) {
                ret = context.getString(R.string.today);
            } else if (diff >= 24 * 60 * 60 * 1000 && diff < 2 * 24 * 60 * 60 * 1000) {
                ret = context.getString(R.string.tomorrow);
            } else {
                ret = DataUtil.formatDate(dataString,
                        Constants.DATE_WEEK_DISPLAY_FORMAT,
                        Constants.DATE_DEFAULT_DISPLAY_FORMAT, null);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return ret;
    }

    public static String conventToDateText(Context context, String dataString, Locale locale) {
        String pattern = "yyyy-MM-dd'T'HH:mm:ss+SSS";
        String displayPattern = "yyyy-MM-dd";
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern, locale);

            Date date = sdf.parse(dataString);
            long time = date.getTime();
            Date currentDate = new Date();
            long currentTime = currentDate.getTime();

            long apartTime = currentTime - time;
            long apartSecond = apartTime / 1000;
            if (apartSecond > 60) {
                long apartMin = apartSecond / 60;
                if (apartMin > 60) {
                    long apartHour = apartMin / 60;
                    if (apartHour >= 24) {
                        long apartDay = apartHour / 24;
                        if (apartDay > 7) {
                            SimpleDateFormat displaySDF = new SimpleDateFormat(displayPattern, locale);
                            return displaySDF.format(date);
                        } else {
                            if (apartDay == 1)
                                return String.format(context.getString(R.string.time_day_ago), apartDay);
                            return String.format(context.getString(R.string.time_days_ago), apartDay);
                        }
                    } else {
                        if (apartHour == 1)
                            return String.format(context.getString(R.string.time_hour_ago), apartHour);
                        return String.format(context.getString(R.string.time_hours_ago), apartHour);
                    }
                } else {
                    if (apartMin == 1)
                        return String.format(context.getString(R.string.time_minute_ago), apartMin);
                    return String.format(context.getString(R.string.time_minutes_ago), apartMin);
                }
            } else {
                return context.getString(R.string.time_now);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static Calendar getCalendar(String dateString, String inputFormat) {

        Calendar calendar = Calendar.getInstance();
        if (!StringUtil.isStringEmpty(dateString)) {
            SimpleDateFormat format = new SimpleDateFormat(inputFormat);
            try {
                Date date = format.parse(dateString);
                calendar = Calendar.getInstance();
                calendar.setTime(date);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                return calendar;
            }
        }

        return calendar;
    }

    public static String getCurrentFormatDate(String outFormat) {
        final DateFormat df = new SimpleDateFormat(outFormat);
        return df.format(new Date());
    }

    public static String formatDate(Date date, String outFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(outFormat);
        return sdf.format(date);
    }

    public static String replaceBlank(String str) {
        String dest = "";
        if (str != null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }

    public static int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    public static int getTooBarHeight(Context context) {
        if (context == null)
            return 0;

        int actionBarHeight = 0;
        TypedValue tv = new TypedValue();
        if (context.getTheme().resolveAttribute(R.attr.actionBarSize, tv, true)) {
            actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data, context.getResources().getDisplayMetrics());
        }

        return actionBarHeight;
    }

    public static boolean checkNumber(String value) {
        String regex = "^(-?[1-9]\\d*\\.?\\d*)|(-?0\\.\\d*[1-9])|(-?[0])|(-?[0]\\.\\d*)$";
        return value.matches(regex);
    }

    public static String getSpecifiedDayAfter(String specifiedDay, int days) {
        Calendar c = Calendar.getInstance();
        String dayAfter = null;
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(specifiedDay);
            c.setTime(date);
            int day = c.get(Calendar.DATE);
            c.set(Calendar.DATE, day + days);

            dayAfter = new SimpleDateFormat("yyyy-MM-dd")
                    .format(c.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return dayAfter;
    }


    public static BitmapDrawable getBitmapDrawable(Context context, int drawableResId, int witdh, int height) {
        BitmapDrawable drawable = (BitmapDrawable) context.getResources().getDrawable(drawableResId);
        Bitmap bitmap = Bitmap.createScaledBitmap(drawable.getBitmap(),
                (int) (witdh * 0.4),
                (int) (height * 0.4),
                false);
        return new BitmapDrawable(context.getResources(), bitmap);
    }


    public static int getNavigationBarHeight(Context context) {
        Resources resources = context.getResources();
        int resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        int height = resources.getDimensionPixelSize(resourceId);
        return height;
    }

    public static int getContentViewHeight(Context context) {
        return getScreenHeight(context) - getStatusBarHeight(context) - getTooBarHeight(context);
    }

    public static Point getViewCenterPosition(View view) {
        int[] location = new int[2];
        view.getLocationOnScreen(location);
        return new Point(location[0] + (view.getWidth() >> 1), location[1] + (view.getHeight() >> 1));
    }

}

