package com.project.hi_trash.SessionManager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.project.hi_trash.HomeActivity;
import com.project.hi_trash.LoginActivity;

    public class SessionManager {
        SharedPreferences pref;
        public SharedPreferences.Editor editor;
        public Context context;

        public static final String PREF_NAME = "LOGIN";
        public static final String LOGIN_STATUS = "false";
        public static final String NAMA_PENGGUNA = "EMAIL";
        public static final String STATUS = "NAMA";

        public SessionManager(Context context) {
            this.context = context;
            pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
            editor = pref.edit();
        }

        public void createSession(String nama_pengguna, String status) {
            editor.putBoolean(LOGIN_STATUS, true);
            editor.putString(NAMA_PENGGUNA, nama_pengguna);
            editor.putString(STATUS, status);
            editor.apply();
        }

        public boolean isLogin(){
            return pref.getBoolean(LOGIN_STATUS, false);
        }

        public void logout(){
            editor.clear();
            editor.commit();

            Intent login = new Intent(context, LoginActivity.class);
            context.startActivity(login);
            ((HomeActivity)context).finish();
        }

        public String getNamaPengguna() {
            return pref.getString(NAMA_PENGGUNA, null);
        }

        public String getStatus() {
            return pref.getString(STATUS, null);
        }

    }
