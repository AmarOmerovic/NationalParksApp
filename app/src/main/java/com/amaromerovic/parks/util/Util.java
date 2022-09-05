package com.amaromerovic.parks.util;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class Util {
    public static String PARKS_URL = "https://developer.nps.gov/api/v1/parks?stateCode=NY&api_key=sptqFvukvLzopBhlCAWusyNUI5wPgv28a3Gip6xp";

    public static void setStateCode(String stateCode) {
        if (stateCode.isEmpty()) {
            stateCode = "NY";
        }
        PARKS_URL = "https://developer.nps.gov/api/v1/parks?stateCode=" + stateCode + "&api_key=sptqFvukvLzopBhlCAWusyNUI5wPgv28a3Gip6xp";
        Log.d("PARKS_URL", "setStateCode: " + PARKS_URL);

    }

    public static void hideSoftKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }


}
