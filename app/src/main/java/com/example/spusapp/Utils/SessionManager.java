package com.example.spusapp.Utils;

import com.example.spusapp.OtpActivity;

import java.util.HashMap;

public class SessionManager {
//    private SharedPreferences sharedPreferences;
//    private SharedPreferences.Editor editor;
//    public static final String KEY_NOMOR_HP = "nomor_hape";
//    public static final String KEY_PENGGUNA_NAMA = "nama";
//    public static final String KEY_PENGGUNA_EMAIL = "email";
//    public static final String KEY_PENGGUNA_SALDO = "saldo";
//    public static final String KEY_PENGGUNA_HAK_AKSES = "akses";
//    public static final String KEY_PENGGUNA_VALIDASI = "validasi";
//    public static final String LOGGIN_STATUS = "sudahlogin";
//    public static final String SHARE_NAME = "logginsession";
//    private Context context;
//    private final int MODE_PRIVATE = 0;

//    public SessionManager(Context context) {
//        this.context = context;
//        sharedPreferences = context.getSharedPreferences(SHARE_NAME, MODE_PRIVATE);
//        editor = sharedPreferences.edit();
//    }

//    public void saveLogin(String nomor_hape,
//                          String nama,
//                          String email,
//                          String saldo,
//                          String akses,
//                          String nomor) {
//        editor.putBoolean(LOGGIN_STATUS, true);
//        editor.putString(KEY_NOMOR_HP, nomor_hape);
//        editor.putString(KEY_PENGGUNA_NAMA, nama);
//        editor.putString(KEY_PENGGUNA_EMAIL, email);
//        editor.putString(KEY_PENGGUNA_SALDO, saldo);
//        editor.putString(KEY_PENGGUNA_HAK_AKSES, akses);
//        editor.commit();
//    }
//    public void saveValidasi(String validasi){
//        editor.putString(KEY_PENGGUNA_VALIDASI,validasi);
//        editor.commit();
//    }
//
//    public HashMap getDetailsLoggin() {
//        HashMap<String, String> map = new HashMap<>();
//        map.put(KEY_NOMOR_HP, sharedPreferences.getString(KEY_NOMOR_HP_SALDO, null));
//        map.put(KEY_PENGGUNA_NAMA, sharedPreferences.getString(KEY_PENGGUNA_NAMA, null));
//        map.put(KEY_PENGGUNA_EMAIL, sharedPreferences.getString(KEY_PENGGUNA_EMAIL, null));
//        map.put(KEY_PENGGUNA_SALDO, sharedPreferences.getString(KEY_PENGGUNA_SALDO, null));
//        map.put(KEY_PENGGUNA_HAK_AKSES, sharedPreferences.getString(KEY_PENGGUNA_HAK_AKSES, null));
//        map.put(KEY_PENGGUNA_VALIDASI, sharedPreferences.getString(KEY_PENGGUNA_VALIDASI, null));
//        return map;
//    }
//
//    public void checkLogin() {
//        if (!this.isLogin()) {
//            Intent i = new Intent(context, OtpActivity.class);
//            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            context.startActivity(i);
//        }
//    }
//
//    public void logout() {
//        editor.clear();
//        editor.commit();
//    }
//
//    public Boolean isLogin() {
//        return sharedPreferences.getBoolean(LOGGIN_STATUS, false);
//    }
}
