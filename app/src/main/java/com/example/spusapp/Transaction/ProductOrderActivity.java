package com.example.spusapp.Transaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.spusapp.BuildConfig;
import com.example.spusapp.R;
import com.midtrans.sdk.corekit.callback.TransactionFinishedCallback;
import com.midtrans.sdk.corekit.core.MidtransSDK;
import com.midtrans.sdk.corekit.core.themes.CustomColorTheme;
import com.midtrans.sdk.corekit.models.snap.TransactionResult;
import com.midtrans.sdk.uikit.SdkUIFlowBuilder;
import com.squareup.picasso.Picasso;

public class ProductOrderActivity extends AppCompatActivity implements TransactionFinishedCallback {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_review);

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

        Picasso.with(this)
                .load(getIntent().getStringExtra("image"))
                .resize(100,100)
                .into((ImageView)findViewById(R.id.product_image));

        ((TextView)findViewById(R.id.product_name)).setText(getIntent().getStringExtra("name"));
        ((TextView)findViewById(R.id.product_qty)).setText(String.valueOf(getIntent().getIntExtra("qty",0)));
        ((TextView)findViewById(R.id.product_price_amount)).setText("Rp "+getIntent().getIntExtra("price",0));

        ((EditText)findViewById(R.id.edit_customer_name)).setText(DataCostumer.NAME);
        ((EditText)findViewById(R.id.edit_customer_email)).setText(DataCostumer.EMAIL);
        ((EditText)findViewById(R.id.edit_customer_phone)).setText(DataCostumer.PHONE);
        ((TextView)findViewById(R.id.delivery_address)).setText(DataCostumer.ADDRESS);

        findViewById(R.id.button_primary).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actionButton();
            }
        });
    }

    private void actionButton() {
        MidtransSDK.getInstance().setTransactionRequest(DataCostumer.transactionRequest(
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
                Toast.makeText(this, "Transaction Finish ID:"+result.getResponse().getTransactionId(), Toast.LENGTH_SHORT).show();
                break;
            case TransactionResult.STATUS_PENDING:
                Toast.makeText(this,"Transaction Pending ID:"+result.getResponse().getTransactionId(), Toast.LENGTH_SHORT).show();
                break;
            case TransactionResult.STATUS_FAILED:
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
}
