package com.example.spusapp.Transaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.spusapp.BuildConfig;
import com.example.spusapp.Model.ResponseUpdate;
import com.example.spusapp.Network.ApiService;
import com.example.spusapp.Network.CombineApi;
import com.example.spusapp.R;
import com.example.spusapp.SelesaiTransaksiActivity;
import com.example.spusapp.Utils.SessionManager;
import com.midtrans.sdk.corekit.callback.TransactionFinishedCallback;
import com.midtrans.sdk.corekit.core.MidtransSDK;
import com.midtrans.sdk.corekit.core.TransactionRequest;
import com.midtrans.sdk.corekit.core.themes.CustomColorTheme;
import com.midtrans.sdk.corekit.models.BankType;
import com.midtrans.sdk.corekit.models.CustomerDetails;
import com.midtrans.sdk.corekit.models.ItemDetails;
import com.midtrans.sdk.corekit.models.ShippingAddress;
import com.midtrans.sdk.corekit.models.snap.CreditCard;
import com.midtrans.sdk.corekit.models.snap.TransactionResult;
import com.midtrans.sdk.uikit.SdkUIFlowBuilder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductOrderActivity extends AppCompatActivity implements TransactionFinishedCallback {
    static SessionManager sessionManager;
    ApiService apiService;
    static HashMap<String,String> map;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_review);
        sessionManager = new SessionManager(this);
        apiService = CombineApi.getApiService();

        map = sessionManager.getDetailsLogin();

        initMidtransSdk();
        init();
    }

    private void initMidtransSdk() {
        SdkUIFlowBuilder.init()
                .setContext(this)
                .setMerchantBaseUrl(BuildConfig.MERCHANT_BASE_URL)
                .setClientKey(BuildConfig.MERCHANT_CLIENT_KEY)
                .setTransactionFinishedCallback(this)
                .enableLog(true)
                .setColorTheme(new CustomColorTheme("#29B6F6", "#B3E5FC", "#0288D1"))
                .buildSDK();
       
    }

    @SuppressLint("SetTextI18n")
    private void init() {
        ((TextView)findViewById(R.id.text_amount)).setText("Rp "+(getIntent().getIntExtra("qty",0)*getIntent().getIntExtra("price",0)));

        ((TextView)findViewById(R.id.product_name)).setText(getIntent().getStringExtra("name"));
        ((TextView)findViewById(R.id.product_qty)).setText(String.valueOf(getIntent().getIntExtra("qty",0)));
        ((TextView)findViewById(R.id.product_price_amount)).setText("Rp "+getIntent().getIntExtra("price",0));

        ((EditText)findViewById(R.id.edit_customer_name)).setText(map.get(sessionManager.KEY_PENGGUNA_NAMA));
        ((EditText)findViewById(R.id.edit_customer_email)).setText(map.get(sessionManager.KEY_PENGGUNA_EMAIL));
        ((EditText)findViewById(R.id.edit_customer_phone)).setText(map.get(sessionManager.KEY_NOMOR_HP));
        ((TextView)findViewById(R.id.delivery_address)).setText(map.get(sessionManager.KEY_PENGGUNA_ALAMAT));

        findViewById(R.id.button_primary).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actionButton();
            }
        });
    }

    private void actionButton() {
        MidtransSDK.getInstance().setTransactionRequest(transactionRequest(
                "1",
                getIntent().getIntExtra("price",0),
                getIntent().getIntExtra("qty",0),
                getIntent().getStringExtra("name"),
                getIntent().getIntExtra("position",0)

        ));
       
        MidtransSDK.getInstance().startPaymentUiFlow(this);
    }

    @Override
    public void onTransactionFinished(TransactionResult result) {
    if(result.getResponse() != null){
        switch (result.getStatus()){
            case TransactionResult.STATUS_SUCCESS:
                updateTagih(getIntent().getStringExtra("id_tagihan"),"Sukses",result.getResponse().getTransactionTime(),result.getResponse().getOrderId());
                Toast.makeText(this, "Transaction Finish ID:"+result.getResponse().getTransactionId(), Toast.LENGTH_SHORT).show();
                break;
            case TransactionResult.STATUS_PENDING:
                updateTagih(getIntent().getStringExtra("id_tagihan"),"Pending",result.getResponse().getTransactionTime(),result.getResponse().getOrderId());
                Toast.makeText(this,"Transaction Pending ID:"+result.getResponse().getTransactionId(), Toast.LENGTH_SHORT).show();
                break;
            case TransactionResult.STATUS_FAILED:
                updateTagih(getIntent().getStringExtra("id_tagihan"),"Gagal",result.getResponse().getTransactionTime(),result.getResponse().getOrderId());
                Toast.makeText(this,"Transaction Failed ID:"+result.getResponse().getTransactionId(), Toast.LENGTH_SHORT).show();
                break;
        }
        result.getResponse().getValidationMessages();
    } else if(result.isTransactionCanceled()){
        Toast.makeText(this,"Transaction Cenceled", Toast.LENGTH_SHORT).show();
    } else {
        if(result.getStatus().equalsIgnoreCase(TransactionResult.STATUS_INVALID)){
            Toast.makeText( this, "Transaction Invalid", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Transaction Finish with failure", Toast.LENGTH_SHORT).show();
        }
    }

    }

    private void updateTagih(String idTagihan, String statusBayar, String tanggalBayar, String orderId) {
        apiService.updateTagihan(idTagihan,statusBayar,tanggalBayar,orderId).enqueue(new Callback<ResponseUpdate>() {
            @Override
            public void onResponse(Call<ResponseUpdate> call, Response<ResponseUpdate> response) {
                if (response.isSuccessful()){
                    ResponseUpdate responseUpdate = response.body();
                    if (responseUpdate.getCode() == 200){
                        Intent intent = new Intent(ProductOrderActivity.this, SelesaiTransaksiActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(ProductOrderActivity.this, "Periksa Jaringan Anda", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseUpdate> call, Throwable t) {
                Log.d("Error",t.toString());
            }
        });
    }

    public static CustomerDetails customerDetails(){

        CustomerDetails customerDetails = new CustomerDetails();
        customerDetails.setFirstName(map.get(sessionManager.KEY_PENGGUNA_NAMA));
        customerDetails.setPhone(map.get(sessionManager.KEY_NOMOR_HP));
        customerDetails.setEmail(map.get(sessionManager.KEY_PENGGUNA_EMAIL));

        ShippingAddress shippingAddress = new ShippingAddress();
        shippingAddress.setAddress(map.get(sessionManager.KEY_PENGGUNA_ALAMAT));
        customerDetails.setShippingAddress(shippingAddress);

        return customerDetails;

    }

    public static TransactionRequest transactionRequest(String id, int price, int qty, String name, int position){

        int harga = price;
        int kuantiti = qty;
        int total = harga*kuantiti;
        TransactionRequest transactionRequest = new TransactionRequest(System.currentTimeMillis()+" ", total);

        transactionRequest.setCustomerDetails(customerDetails());

        ItemDetails details = new ItemDetails(id, price, qty, name);

        ArrayList<ItemDetails> itemDetails = new ArrayList<>();
        itemDetails.add(details);
        transactionRequest.setItemDetails(itemDetails);

        CreditCard creditCard = new CreditCard();
        creditCard.setSaveCard(false);
        creditCard.setAuthentication(CreditCard.AUTHENTICATION_TYPE_RBA);
        creditCard.setBank(BankType.BCA);
        transactionRequest.setCreditCard(creditCard);
        return transactionRequest;
    }

}
