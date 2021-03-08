package com.example.clever;

import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationManager;
import android.os.Bundle;

import com.clevertap.android.sdk.CleverTapAPI;

import java.util.Date;
import java.util.HashMap;

public class MainActivity extends android.app.Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CleverTapAPI clevertapDefaultInstance = CleverTapAPI.getDefaultInstance(getApplicationContext());

        HashMap<String, Object> profileUpdate = new HashMap<String, Object>();
        profileUpdate.put("Name", "ShreANdroid");    // String
        profileUpdate.put("Identity", 61026031);      // String or number
        profileUpdate.put("Email", "harry@gmail.com"); // Email address of the user
        profileUpdate.put("Phone", "+14155551234");   // Phone (with the country code, starting with +)
        profileUpdate.put("Gender", "M");             // Can be either M or F
        profileUpdate.put("DOB", new Date());         // Date of Birth. Set the Date object to the appropriate value first
// optional fields. controls whether the user will be sent email, push etc.
        profileUpdate.put("MSG-email", false);        // Disable email notifications
        profileUpdate.put("MSG-push", true);          // Enable push notifications
        profileUpdate.put("MSG-sms", false);          // Disable SMS notifications
        profileUpdate.put("MSG-whatsapp", true);

        clevertapDefaultInstance.onUserLogin(profileUpdate);

        HashMap<String, Object> prodViewedAction = new HashMap<String, Object>();
        prodViewedAction.put("Product Name", "Casio Chronograph Watch");
        prodViewedAction.put("Category", "Mens Accessories");
        prodViewedAction.put("Price", 59.99);
        prodViewedAction.put("Date", new java.util.Date());

        clevertapDefaultInstance.pushEvent("Product viewed", prodViewedAction);

        CleverTapAPI.createNotificationChannel(getApplicationContext(),"hi","Shrestha","push notification done.",NotificationManager.IMPORTANCE_MAX,true);

    }


}