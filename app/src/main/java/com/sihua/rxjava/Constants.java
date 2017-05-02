package com.sihua.rxjava;

import android.content.Context;
import android.os.Environment;

import java.io.File;

public class Constants {

    public static final String TAG = "OpenRice";
    public static final String APP_PACKAGE = "com.openrice.android";
    public static final String BROADCAST_SPLASH_SCREEN = "broadcast_splash_screen";
    public static final String BROADCAST_HOMEITEMS_STATUS = "broadcast_homeitems_status";

    public static final String API_CONSTANTS_PICKS = "Hop Picks";
    public static final String CALLBACK = "callback";
    public static final String STATUS = "status";
    public static final String STATUSCODE = "statuscode";
    public static final String CALLBACK_UPDATE_ALL_COUNTRIES = "callback_update_all_countries";
    public static final String CALLBACK_UPDATE_COUNTRIES = "callback_update_countries";
    public static final String CALLBACK_UPDATE_APPLICATION_INFO = "callback_update_application_info";
    public static final String CALLBACK_UPDATE_APPLICATION_TOKEN_FROM_V4 = "callback_update_token_from_v4";
    public static final String CALLBACK_UPDATE_META_DATA = "callback_update_meta_data";
    public static final String API_RESPONSE_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
    public static final String API_RESPONSE_LOCAL_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
    public static final String API_RESPONSE_DATE_FORMAT_OLD = "yyyy-MM-dd'T'HH:mm:ssZ";
    public static final String DATE_DEFAULT_DISPLAY_FORMAT = "yyyy-MM-dd";
    public static final String DATE_DISPLAY_FORMAT_MM = "dd-MM-yyyy";
    public static final String DATE_MONTH_DISPLAY_FORMAT = "MMMM";
    public static final String DATE_DEF_MONTH_DISPLAY_FORMAT = "MM";
    public static final String DATE_WEEK_DISPLAY_FORMAT = "EEEE";
    public static final String DATE_3E_DISPLAY_FORMAT = "EEE";
    public static final String DATE_DATE_DISPLAY_FORMAT = "dd";
    public static final String DATE_YEAR_DISPLAY_FORMAT = "yyyy";
    public static final String DATE_HOUR_APM_DISPLAY_FORMAT = "h:mm a";
    public static final String DATE_AHOUR_PM_DISPLAY_FORMAT = "a h:mm";
    public static final String DATE_MIN_DISPLAY_FORMAT = "mm";
    public static final String DATE_ONLY_HOUR_DISPLAY_FORMAT = "HH";
    public static final String DATE_HOUR_DISPLAY_FORMAT = "HH:mm";
    public static final String DATE_HOUR_AM_PM_DISPLAY_FORMAT = "hh:mm a, yyyy-MM-dd";
    public static final String DATE_TM_DISPLAY_FORMAT = "EEE, MMM dd";
    public static final String HK_DATE_TM_DISPLAY_FORMAT = "MMMdd EEE";
    public static final String TH_DATE_TM_DISPLAY_FORMAT = "EEE dd MMM";
    public static final String DATE_HOUR_24_DISPLAY_FORMAT = "HH:mm, yyyy-MM-dd";

    public static final int NUM_LIMIT_TEN = 20;
    public static final String DATE_DISPLAY_FORMAT = "yyyy-MM-dd HH:mm";
    // Gps Manager
    public static final String LOCATION_RECEIVER = "openrice.location.receiver";
    public static final long LOCATION_TRUST_THRESHOLD_MS = 1000 * 180;
    public static final String SDCARD_FOLDER_NAME = "OpenRice";
    protected static final String STICKER_FOLDER = "/Stickers/";
    //AD Handing
    public static String DOUBLE_CLICK_ACCOUNT_ID = "1012872"; //default OpenRice HK
    public static String DOUBLE_CLICK_ACCOUNT_ID_HK = "1012872";
    public static String DOUBLE_CLICK_ACCOUNT_ID_CN = "330196870";
    public static String DOUBLE_CLICK_ACCOUNT_ID_ID = "55756893";
    public static String DOUBLE_CLICK_ACCOUNT_ID_IN = "32775800";
    public static String DOUBLE_CLICK_ACCOUNT_ID_MY = "95546378";
    public static String DOUBLE_CLICK_ACCOUNT_ID_PH = "60794331";
    public static String DOUBLE_CLICK_ACCOUNT_ID_SG = "58904836";
    public static String DOUBLE_CLICK_ACCOUNT_ID_TH = "77484429";
    public static String DOUBLE_CLICK_ACCOUNT_ID_TW = "30217667";
    public static String DOUBLE_CLICK_ACCOUNT_ID_JP = "106057418";

    // For Google Doubleclick Ad
    public static String DOUBLE_CLICK_ID_NATIVE = "orhk_an_SR1_nativeAd";
    public static String DOUBLE_CLICK_ID_SR1_1 = "orhk_an_SR1_banner_1";
    public static String DOUBLE_CLICK_ID_SR1_2 = "orhk_an_SR1_banner_2";
    public static String DOUBLE_CLICK_ID_SR1_3 = "orhk_an_SR1_banner_3";
    public static String DOUBLE_CLICK_ID_DPROMOTION_ID_SR1_1 = "orhk_an_promotion_banner_1";
    public static String DOUBLE_CLICK_ID_DPROMOTION_ID_SR1_2 = "orhk_an_promotion_banner_2";
    public static String DOUBLE_CLICK_ID_DPROMOTION_ID_SR1_3 = "orhk_an_promotion_banner_3";
    public static String DOUBLE_CLICK_ID_DPROMOTION_ID_SR1_4 = "orhk_an_promotion_banner_4";
    public static String DOUBLE_CLICK_ID_SR2_1 = "orhk_an_SR2_banner_1";
    public static String DOUBLE_CLICK_ID_RMS_SR2_1 = "orhk_an_SR2_rms_banner_1";
    public static String DOUBLE_CLICK_ID_TM_SR2_1 = "orhk_an_SR2_tm_banner_1";
    public static String DOUBLE_CLICK_ID_SR2_2 = "orhk_an_SR2_banner_2";
    public static String DOUBLE_CLICK_ID_SR2_REVIEW_1 = "orhk_an_SR2_review_banner_1";
    public static String DOUBLE_CLICK_ID_SR2_REVIEW_2 = "orhk_an_SR2_review_banner_2";
    public static String DOUBLE_CLICK_ID_SR2_REVIEW_3 = "orhk_an_SR2_review_banner_3";
    public static String DOUBLE_CLICK_ID_SR2_PHOTO_1 = "orhk_an_SR2_photo_banner_1";
    public static String DOUBLE_CLICK_ID_SR2_MENU_1 = "orhk_an_SR2_menu_banner_1";
    public static String DOUBLE_CLICK_ID_LATEST_REVIEW_1 = "orhk_an_review_banner_1";
    public static String DOUBLE_CLICK_ID_LATEST_REVIEW_2 = "orhk_an_review_banner_2";
    public static String DOUBLE_CLICK_ID_LATEST_REVIEW_3 = "orhk_an_review_banner_3";
    public static String DOUBLE_CLICK_ID_COUPON_1 = "orhk_an_CouponSR1_banner_1";
    public static String DOUBLE_CLICK_ID_COUPON_2 = "orhk_an_CouponSR1_banner_2";
    public static String DOUBLE_CLICK_ID_COUPON_3 = "orhk_an_CouponSR1_banner_3";
    public static String DOUBLE_CLICK_INTERSTITIAL_ID = "orhk_an_interstitial";
    public static String DOUBLE_CLICK_INTERSTITIAL_START_APP_ID = "orhk_an_interstitial_startapp";
    public static String DOUBLE_CLICK_INTERSTITIAL_CHART_TRANSITION_ID = "orhk_an_interstitial_transition";
    public static String DOUBLE_CLICK_INTERSTITIAL_REVIEW_TRANSITION_ID = "orhk_an_interstitial_transition";
    public static String DOUBLE_CLICK_INTERSTITIAL_PHOTO_TRANSITION_ID = "orhk_an_interstitial_transition";
    public static String DOUBLE_CLICK_BEA_SR2_ID_1 = "orhk_an_BEA_SR2_banner_1";
    public static String DOUBLE_CLICK_BEA_SR2_ID_2 = "orhk_an_BEA_SR2_banner_2";
    public static String DOUBLE_CLICK_BUFFET_SR1_1 = "orhk_an_buffet_SR1_banner_1";
    public static String DOUBLE_CLICK_BUFFET_SR1_2 = "orhk_an_buffet_SR1_banner_2";
    public static String DOUBLE_CLICK_BUFFET_SR1_3 = "orhk_an_buffet_SR1_banner_3";
    public static String DOUBLE_CLICK_HOTPOT_SR1_1 = "orhk_an_hotpot_SR1_banner_1";
    public static String DOUBLE_CLICK_HOTPOT_SR1_2 = "orhk_an_hotpot_SR1_banner_2";
    public static String DOUBLE_CLICK_HOTPOT_SR1_3 = "orhk_an_hotpot_SR1_banner_3";
    public static String DOUBLE_CLICK_RESERVATION_SR1_HEADER = "orhk_an_tm_SR1_banner_1";
    public static String DOUBLE_CLICK_ADV_DISTRICT = "orhk_an_AdvSearch_banner_district";
    public static String DOUBLE_CLICK_ADV_LANDMARK_HKISLAND = "orhk_an_AdvSearch_banner_landmark_hkisland";
    public static String DOUBLE_CLICK_ADV_LANDMARK_KLN = "orhk_an_AdvSearch_banner_landmark_kln";
    public static String DOUBLE_CLICK_ADV_LANDMARK_NT = "orhk_an_AdvSearch_banner_landmark_nt";
    public static String DOUBLE_CLICK_ADV_LANDMARK_OUTLYING = "orhk_an_AdvSearch_banner_landmark_outlying";
    public static String DOUBLE_CLICK_ADV_CUISINE = "orhk_an_AdvSearch_banner_cuisine";
    public static String DOUBLE_CLICK_ADV_DISH = "orhk_an_AdvSearch_banner_dish";


    public static String DOUBLE_CLICK_ID_NATIVE_IMPL = "/" + DOUBLE_CLICK_ACCOUNT_ID + "/" + DOUBLE_CLICK_ID_NATIVE;
    public static String DOUBLE_CLICK_ID_SR1_1_IMPL = "/" + DOUBLE_CLICK_ACCOUNT_ID + "/" + DOUBLE_CLICK_ID_SR1_1;
    public static String DOUBLE_CLICK_ID_SR1_2_IMPL = "/" + DOUBLE_CLICK_ACCOUNT_ID + "/" + DOUBLE_CLICK_ID_SR1_2;
    public static String DOUBLE_CLICK_ID_SR1_3_IMPL = "/" + DOUBLE_CLICK_ACCOUNT_ID + "/" + DOUBLE_CLICK_ID_SR1_3;
    public static String DOUBLE_CLICK_ID_DPROMOTION_ID_SR1_1_IMPL = "/" + DOUBLE_CLICK_ACCOUNT_ID + "/" + DOUBLE_CLICK_ID_DPROMOTION_ID_SR1_1;
    public static String DOUBLE_CLICK_ID_DPROMOTION_ID_SR1_2_IMPL = "/" + DOUBLE_CLICK_ACCOUNT_ID + "/" + DOUBLE_CLICK_ID_DPROMOTION_ID_SR1_2;
    public static String DOUBLE_CLICK_ID_DPROMOTION_ID_SR1_3_IMPL = "/" + DOUBLE_CLICK_ACCOUNT_ID + "/" + DOUBLE_CLICK_ID_DPROMOTION_ID_SR1_3;
    public static String DOUBLE_CLICK_ID_DPROMOTION_ID_SR1_4_IMPL = "/" + DOUBLE_CLICK_ACCOUNT_ID + "/" + DOUBLE_CLICK_ID_DPROMOTION_ID_SR1_4;
    public static String DOUBLE_CLICK_ID_SR2_1_IMPL = "/" + DOUBLE_CLICK_ACCOUNT_ID + "/" + DOUBLE_CLICK_ID_SR2_1;
    public static String DOUBLE_CLICK_ID_RMS_SR2_1_IMPL = "/" + DOUBLE_CLICK_ACCOUNT_ID + "/" + DOUBLE_CLICK_ID_RMS_SR2_1;
    public static String DOUBLE_CLICK_ID_TM_SR2_1_IMPL = "/" + DOUBLE_CLICK_ACCOUNT_ID + "/" + DOUBLE_CLICK_ID_TM_SR2_1;
    public static String DOUBLE_CLICK_ID_SR2_2_IMPL = "/" + DOUBLE_CLICK_ACCOUNT_ID + "/" + DOUBLE_CLICK_ID_SR2_2;
    public static String DOUBLE_CLICK_ID_SR2_REVIEW_1_IMPL = "/" + DOUBLE_CLICK_ACCOUNT_ID + "/" + DOUBLE_CLICK_ID_SR2_REVIEW_1;
    public static String DOUBLE_CLICK_ID_SR2_REVIEW_2_IMPL = "/" + DOUBLE_CLICK_ACCOUNT_ID + "/" + DOUBLE_CLICK_ID_SR2_REVIEW_2;
    public static String DOUBLE_CLICK_ID_SR2_REVIEW_3_IMPL = "/" + DOUBLE_CLICK_ACCOUNT_ID + "/" + DOUBLE_CLICK_ID_SR2_REVIEW_3;
    public static String DOUBLE_CLICK_ID_SR2_PHOTO_1_IMPL = "/" + DOUBLE_CLICK_ACCOUNT_ID + "/" + DOUBLE_CLICK_ID_SR2_PHOTO_1;
    public static String DOUBLE_CLICK_ID_SR2_MENU_1_IMPL = "/" + DOUBLE_CLICK_ACCOUNT_ID + "/" + DOUBLE_CLICK_ID_SR2_MENU_1;
    public static String DOUBLE_CLICK_ID_LATEST_REVIEW_1_IMPL = "/" + DOUBLE_CLICK_ACCOUNT_ID + "/" + DOUBLE_CLICK_ID_LATEST_REVIEW_1;
    public static String DOUBLE_CLICK_ID_LATEST_REVIEW_2_IMPL = "/" + DOUBLE_CLICK_ACCOUNT_ID + "/" + DOUBLE_CLICK_ID_LATEST_REVIEW_2;
    public static String DOUBLE_CLICK_ID_LATEST_REVIEW_3_IMPL = "/" + DOUBLE_CLICK_ACCOUNT_ID + "/" + DOUBLE_CLICK_ID_LATEST_REVIEW_3;
    public static String DOUBLE_CLICK_ID_COUPON_1_IMPL = "/" + DOUBLE_CLICK_ACCOUNT_ID + "/" + DOUBLE_CLICK_ID_COUPON_1;
    public static String DOUBLE_CLICK_ID_COUPON_2_IMPL = "/" + DOUBLE_CLICK_ACCOUNT_ID + "/" + DOUBLE_CLICK_ID_COUPON_2;
    public static String DOUBLE_CLICK_ID_COUPON_3_IMPL = "/" + DOUBLE_CLICK_ACCOUNT_ID + "/" + DOUBLE_CLICK_ID_COUPON_3;
    public static String DOUBLE_CLICK_INTERSTITIAL_ID_IMPL = "/" + DOUBLE_CLICK_ACCOUNT_ID + "/" + DOUBLE_CLICK_INTERSTITIAL_ID;
    public static String DOUBLE_CLICK_INTERSTITIAL_START_APP_ID_IMPL = "/" + DOUBLE_CLICK_ACCOUNT_ID + "/" + DOUBLE_CLICK_INTERSTITIAL_START_APP_ID;
    public static String DOUBLE_CLICK_INTERSTITIAL_CHART_TRANSITION_ID_IMPL = "/" + DOUBLE_CLICK_ACCOUNT_ID + "/" + DOUBLE_CLICK_INTERSTITIAL_CHART_TRANSITION_ID;
    public static String DOUBLE_CLICK_INTERSTITIAL_REVIEW_TRANSITION_ID_IMPL = "/" + DOUBLE_CLICK_ACCOUNT_ID + "/" + DOUBLE_CLICK_INTERSTITIAL_REVIEW_TRANSITION_ID;
    public static String DOUBLE_CLICK_INTERSTITIAL_PHOTO_TRANSITION_ID_IMPL = "/" + DOUBLE_CLICK_ACCOUNT_ID + "/" + DOUBLE_CLICK_INTERSTITIAL_PHOTO_TRANSITION_ID;
    public static String DOUBLE_CLICK_BEA_SR2_ID_1_IMPL = "/" + DOUBLE_CLICK_ACCOUNT_ID + "/" + DOUBLE_CLICK_BEA_SR2_ID_1;
    public static String DOUBLE_CLICK_BEA_SR2_ID_2_IMPL = "/" + DOUBLE_CLICK_ACCOUNT_ID + "/" + DOUBLE_CLICK_BEA_SR2_ID_2;
    public static String DOUBLE_CLICK_BUFFET_SR1_1_IMPL = "/" + DOUBLE_CLICK_ACCOUNT_ID + "/" + DOUBLE_CLICK_BUFFET_SR1_1;
    public static String DOUBLE_CLICK_BUFFET_SR1_2_IMPL = "/" + DOUBLE_CLICK_ACCOUNT_ID + "/" + DOUBLE_CLICK_BUFFET_SR1_2;
    public static String DOUBLE_CLICK_BUFFET_SR1_3_IMPL = "/" + DOUBLE_CLICK_ACCOUNT_ID + "/" + DOUBLE_CLICK_BUFFET_SR1_3;
    public static String DOUBLE_CLICK_HOTPOT_SR1_1_IMPL = "/" + DOUBLE_CLICK_ACCOUNT_ID + "/" + DOUBLE_CLICK_HOTPOT_SR1_1;
    public static String DOUBLE_CLICK_HOTPOT_SR1_2_IMPL = "/" + DOUBLE_CLICK_ACCOUNT_ID + "/" + DOUBLE_CLICK_HOTPOT_SR1_2;
    public static String DOUBLE_CLICK_HOTPOT_SR1_3_IMPL = "/" + DOUBLE_CLICK_ACCOUNT_ID + "/" + DOUBLE_CLICK_HOTPOT_SR1_3;
    public static String DOUBLE_CLICK_RESERVATION_SR1_HEADER_IMPL = "/" + DOUBLE_CLICK_ACCOUNT_ID + "/" + DOUBLE_CLICK_RESERVATION_SR1_HEADER;
    public static String DOUBLE_CLICK_ADV_DISTRICT_IMPL = "/" + DOUBLE_CLICK_ACCOUNT_ID + "/" + DOUBLE_CLICK_ADV_DISTRICT;
    public static String DOUBLE_CLICK_ADV_LANDMARK_HKISLAND_IMPL = "/" + DOUBLE_CLICK_ACCOUNT_ID + "/" + DOUBLE_CLICK_ADV_LANDMARK_HKISLAND;
    public static String DOUBLE_CLICK_ADV_LANDMARK_KLN_IMPL = "/" + DOUBLE_CLICK_ACCOUNT_ID + "/" + DOUBLE_CLICK_ADV_LANDMARK_KLN;
    public static String DOUBLE_CLICK_ADV_LANDMARK_NT_IMPL = "/" + DOUBLE_CLICK_ACCOUNT_ID + "/" + DOUBLE_CLICK_ADV_LANDMARK_NT;
    public static String DOUBLE_CLICK_ADV_LANDMARK_OUTLYING_IMPL = "/" + DOUBLE_CLICK_ACCOUNT_ID + "/" + DOUBLE_CLICK_ADV_LANDMARK_OUTLYING;
    public static String DOUBLE_CLICK_ADV_CUISINE_IMPL = "/" + DOUBLE_CLICK_ACCOUNT_ID + "/" + DOUBLE_CLICK_ADV_CUISINE;
    public static String DOUBLE_CLICK_ADV_DISH_IMPL = "/" + DOUBLE_CLICK_ACCOUNT_ID + "/" + DOUBLE_CLICK_ADV_DISH;

    static File rootsd = Environment.getExternalStorageDirectory();
    public static String dirPath = rootsd.getAbsolutePath();
    public static final String SDCARD_FOLDER = dirPath + "/" + SDCARD_FOLDER_NAME + "/";

    // booking flow bundle params
    public static final String SELECT_TMBOOKINGWIDGET_TIMESLOT_POSITION = "select_tmBookingWidget_timeSlot_position";
    public static final String POI_ID = "poi_id";
    public static final String OFFER_ID = "offerId";
    public static final String TIME_SLOT_LIST = "time_slot_list";
    public static final String SEAT_NUM = "seat_num";
    public static final String TIME_SLOT = "time_slot";
    public static final String TIME_SLOT_ID = "timeSlotId";
    public static final String BOOKING_DATE = "booking_date";
    public static final String YEAR = "year";
    public static final String MONTH = "month";
    public static final String DAY = "day";
    public static final String HOUR = "hour";
    public static final String MINUTE = "minute";
    public static final String POI_MODEL = "poi_model";

    //edit booking
    public static final String IS_EDIT_BOOKING = "is_edit_booking";
    public static final String EDIT_BOKING_POSITION = "edit_boking_position";
    public static final String BOOKING_MODEL = "booking_model";
    public static final String PARAMS_BOOKING_ID = "bookingId";
    public static final String PARAMS_COUNTRY_ID = "countryId";
    public static final String CUSTOM_SPECIAL_REQUEST_REMARK = "remark";
    public static final String BOOKING_USER_NAME = "dinerName";
    public static final String BOOKING_USER_SEX = "dinerTitle";
    public static final String BOOKING_USER_PHONE = "dinerPhone";
    public static final String BOOKING_USER_PHONE_CODE = "dinerPhoneAreaCode";
    public static final String BOOKINGG_TYPE = "bookingg_type";
    public static final String BOOKING_RESULT_TITLE = "booking_result_title";
    public static final String CUSTOM_SPECIAL_REQUEST_ = "special_request";
    public static final String BOOKING_USER_INFO = "booking_user_info";
    public static final String CONFIRM_BOOKING_RESULT = "confirm_booking_result";
    public static final String CONFIRM_SUPPRESS_MESSAGE = "isSuppressMessage";
    public static final String TIME_SLOT_OFFER = "time_slot_offer";
    public static final String BOOKING_PAYMENT_URL = "booking_payment_url";
    public static final String IS_BOOKMARK = "isBookmark";
    public static final String IS_SHOW_LOGIN = "isShowLogin";

    public static final String BOOKING_TNC_URL = "http://www.openrice.com/info/tnc/or-terms.html";
    public static final String BOOKING_PP_URL = "http://www.openrice.com/info/tnc/or-pp.html";
    public static String getStickerFolder(Context context) {
        return context.getFilesDir() + STICKER_FOLDER;
    }
    public static String APP_TYPE = "orapp2015androidv5";
    public static String CLIENT_SECRET = "OpenriceAuthTokenInAPICommon";
    public static String GRANT_TYPE_PASSWORD = "password";
    public static String GRANT_TYPE_REFRESH = "refresh_token";
    public static String GRANT_TYPE_FB = "facebook_token";
    public static String GRANT_TYPE_GOOGLE = "google_token";
    public static String GRANT_TYPE_GUEST = "guest";
    public static String API_VERSION = "500";
}
