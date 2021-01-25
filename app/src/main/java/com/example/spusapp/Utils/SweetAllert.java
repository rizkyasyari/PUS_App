package com.example.spusapp.Utils;

import android.content.Context;
import android.graphics.Color;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class SweetAllert {
    Context context;
    SweetAlertDialog pDialog;
    boolean confirm;
    public SweetAllert(Context context){
        this.context = context;
    }
    public void successAllert(String message){
        new SweetAlertDialog(context)
                .setTitleText(message)
                .show();
    }
    public void errorAllert(String message){
        new SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE)
                .setTitleText("Oops...")
                .setContentText(message)
                .show();
    }
    public void loadingAllert(String message){
        pDialog = new SweetAlertDialog(context, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        pDialog.setTitleText(message);
        pDialog.setCancelable(true);
        pDialog.show();
    }
    public void dismissloadingAllert(){
        pDialog.hide();
    }
    public void confirmSuccessAllert(){
        new SweetAlertDialog(context, SweetAlertDialog.WARNING_TYPE)
                .setTitleText("Apakah kamu yakin?")

                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        sDialog
                                .setTitleText("Deleted!")
                                .setContentText("Your imaginary file has been deleted!")
                                .setConfirmText("OK")
                                .setConfirmClickListener(null)
                                .changeAlertType(SweetAlertDialog.SUCCESS_TYPE);
                    }
                })
                .show();
    }
    public void confirmAllert(){
        new SweetAlertDialog(context, SweetAlertDialog.WARNING_TYPE)
                .setTitleText("Apakah kamu yakin?")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        setConfirm(true);
                        sDialog.dismissWithAnimation();
                    }
                })
                .setCancelButton("Cancel", new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        setConfirm(false);
                        sDialog.dismissWithAnimation();

                    }
                })
                .show();
    }
    public Boolean setConfirm(boolean a) {
        this.confirm = a;
        return confirm;
    }
    public Boolean getConfirm(){
        return confirm;
    }

}
