package com.iondew.slingshot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.paytm.pgsdk.PaytmOrder;
import com.paytm.pgsdk.PaytmPGService;
import com.paytm.pgsdk.PaytmPaymentTransactionCallback;

import java.util.HashMap;
import java.util.Map;

public class PayTMActivity extends AppCompatActivity {

    PaytmPGService Service = null;
    private static final String TAG = "PayTMActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_tm);

        Service = PaytmPGService.getStagingService();

        Map<String, String> paramMap = new HashMap<String,String>();
        paramMap.put( "MID" , "Slings87067986122680");
        paramMap.put( "ORDER_ID" , "ORDER0000000001");
        paramMap.put( "CUST_ID" , "10000988111");
        paramMap.put( "INDUSTRY_TYPE_ID" , "Retail");
        paramMap.put( "CHANNEL_ID" , "WAP");
        paramMap.put( "TXN_AMOUNT" , "1");
        paramMap.put( "WEBSITE" , "http://www.slingshot.iondew.com/");
        paramMap.put( "CALLBACK_URL" , "https://securegw.paytm.in/theia/paytmCallback?ORDER_ID=ORDER0000000001");
        paramMap.put( "EMAIL" , "abc@gmail.com");
        paramMap.put( "MOBILE_NO" , "9999999999");
        paramMap.put( "CHECKSUMHASH" , "w2QDRMgp1/BNdEnJEAPCIOmNgQvsi+BhpqijfM9KvFfRiPmGSt3Ddzw+oTaGCLneJwxFFq5mqTMwJXdQE2EzK4px2xruDqKZjHupz9yXev4=");

        PaytmOrder Order = new PaytmOrder(paramMap);

        Service.initialize(Order, null);

        Service.startPaymentTransaction(this, true, true,
                new PaytmPaymentTransactionCallback() {
                    @Override
                    public void onTransactionResponse(Bundle inResponse) {
                        Log.d("LOG", "Payment Transaction is successful " + inResponse);
                        Toast.makeText(getApplicationContext(), "Payment Transaction response " + inResponse.toString(), Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void networkNotAvailable() {
                        Log.d(TAG, "networkNotAvailable: ");
                    }

                    @Override
                    public void clientAuthenticationFailed(String inErrorMessage) {
                        Log.d(TAG, "clientAuthenticationFailed: ");
                    }

                    @Override
                    public void someUIErrorOccurred(String inErrorMessage) {
                        Log.d(TAG, "someUIErrorOccurred: ");
                    }

                    @Override
                    public void onErrorLoadingWebPage(int iniErrorCode, String inErrorMessage, String inFailingUrl) {
                        Log.d(TAG, "onErrorLoadingWebPage: ");
                    }

                    @Override
                    public void onBackPressedCancelTransaction() {
                        Log.d(TAG, "onBackPressedCancelTransaction: ");
                    }

                    @Override
                    public void onTransactionCancel(String inErrorMessage, Bundle inResponse) {
                        Log.d(TAG, "onTransactionCancel: ");
                    }
                });
    }


}
