package com.sihua.rxjava.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;


import java.security.MessageDigest;

public class DeviceUtil {

    private static final String TAG = DeviceUtil.class.getSimpleName();

    public static String getDeviceUUID(Context context) {
        String androidId = "";
        try {
            androidId = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return androidId;
    }
    public static int getOrientation(Context context) {
        if (context != null) {
            WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            Configuration config = context.getResources().getConfiguration();
            int rotation = windowManager.getDefaultDisplay().getRotation();

            if (((rotation == Surface.ROTATION_0 || rotation == Surface.ROTATION_180) && config.orientation == Configuration.ORIENTATION_LANDSCAPE)//
                    || ((rotation == Surface.ROTATION_90 || rotation == Surface.ROTATION_270) && config.orientation == Configuration.ORIENTATION_PORTRAIT)) {
                return Configuration.ORIENTATION_LANDSCAPE;
            } else {
                return Configuration.ORIENTATION_PORTRAIT;
            }
        }

        return Configuration.ORIENTATION_PORTRAIT;
    }

    private static String encrypt(String str) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            result = toHexString(md.digest());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private static String toHexString(byte[] in) {
        StringBuilder hexString = new StringBuilder();
        for (int i = 0; i < in.length; i++) {
            String hex = Integer.toHexString(0xFF & in[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public static int getDeviceWidth(Context context) {
        if (context != null) {
            WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            Display display = wm.getDefaultDisplay();

            return display.getWidth();
        }

        //Use 1 as a default value, 1 is more safety compare with use zero as a default
        return 1;
    }

    public static int getDeviceHeight(Context context) {
        if (context != null) {
            WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            Display display = wm.getDefaultDisplay();

            return display.getHeight();
        }

        //Use 1 as a default value, 1 is more safety compare with use zero as a default
        return 1;
    }

    public static float getDeviceDensity(Context context) {
        if (context != null) {
            DisplayMetrics metrics = context.getResources().getDisplayMetrics();
            return metrics.density;
        }

        return DisplayMetrics.DENSITY_DEFAULT;
    }

    public static float getDeviceDensityDpi(Context context) {
        if (context != null) {
            DisplayMetrics metrics = context.getResources().getDisplayMetrics();
            return metrics.densityDpi;
        }

        return DisplayMetrics.DENSITY_DEFAULT;
    }

    /**
     * Check if this device has a camera
     */
    public static boolean checkCameraHardware(Context context) {
        if (context != null) {
            // this device has a camera
// no camera on this device
            return context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA);
        }

        return false;
    }

    public static String getWiFiMacAddress(Context context) {
        if (context != null) {
            WifiManager wifiMan = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
            WifiInfo wifiInf = wifiMan.getConnectionInfo();
            String wiFiMacAddress = wifiInf.getMacAddress();

            return wiFiMacAddress;
        }

        return null;
    }

    public static int getDeviceOSVersion() {
        return Build.VERSION.SDK_INT;
    }

    public static String getDeviceModel() {
        String manufacturer = Build.MANUFACTURER;
        String model = Build.MODEL;
        if (model.startsWith(manufacturer)) {
            return capitalize(model);
        } else {
            return capitalize(manufacturer) + " " + model;
        }
    }

    private static String capitalize(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char first = s.charAt(0);
        if (Character.isUpperCase(first)) {
            return s;
        } else {
            return Character.toUpperCase(first) + s.substring(1);
        }
    }

    public static boolean isLocationServiceAllowed(Context context) {
        if (context != null) {
            LocationManager locationManager = (LocationManager) context.getApplicationContext().getSystemService(Context.LOCATION_SERVICE);
            try {
                if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
                    return true;
                }
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    // Changes for OpenRice SR2
    public static String getVersionName(Context context) {
        if (context != null) {
            PackageManager manager = context.getPackageManager();
            try {
                PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
                if (info != null)
                    return info.versionName;
            } catch (NameNotFoundException e) {
                e.printStackTrace();
            }
        }

        return null;
    }


    public static NetworkInfo getNetworkInfo(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm == null ? null : cm.getActiveNetworkInfo();
    }

    public static NetworkType getConnectionType(Context context) {
        NetworkInfo info = getNetworkInfo(context);
        if (info != null) {
            final int type = info.getType();
            final int subType = info.getSubtype();
            if (type == ConnectivityManager.TYPE_ETHERNET) {
                return NetworkType.NetworkTypeLan;
            } else if (type == ConnectivityManager.TYPE_WIFI) {
                return NetworkType.NetworkTypeWifi;
            } else if (type == ConnectivityManager.TYPE_MOBILE) {
                switch (subType) {
                    case TelephonyManager.NETWORK_TYPE_GPRS:
                    case TelephonyManager.NETWORK_TYPE_EDGE:
                    case TelephonyManager.NETWORK_TYPE_CDMA:
                    case TelephonyManager.NETWORK_TYPE_1xRTT:
                    case TelephonyManager.NETWORK_TYPE_IDEN:
                        return NetworkType.NetworkType2G;
                    case TelephonyManager.NETWORK_TYPE_UMTS:
                    case TelephonyManager.NETWORK_TYPE_EVDO_0:
                    case TelephonyManager.NETWORK_TYPE_EVDO_A:
                    case TelephonyManager.NETWORK_TYPE_HSDPA:
                    case TelephonyManager.NETWORK_TYPE_HSUPA:
                    case TelephonyManager.NETWORK_TYPE_HSPA:
                    case TelephonyManager.NETWORK_TYPE_EVDO_B:
                    case TelephonyManager.NETWORK_TYPE_EHRPD:
                    case TelephonyManager.NETWORK_TYPE_HSPAP:
                        return NetworkType.NetworkType3G;
                    case TelephonyManager.NETWORK_TYPE_LTE:
                        return NetworkType.NetworkType4G;
                    default:
                        return NetworkType.NetworkTypeMobileData;
                }
            } else {
                return NetworkType.NetworkTypeUnknown;
            }
        } else {
            return NetworkType.NetworkTypeNoNetwork;
        }
    }


    public enum NetworkType {
        NetworkTypeLan,
        NetworkTypeWifi,
        NetworkType2G,
        NetworkType3G,
        NetworkType4G,
        NetworkTypeMobileData,
        NetworkTypeUnknown,
        NetworkTypeNoNetwork
    }
}
