package bd.ac.seu.sixthapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CartActivity extends AppCompatActivity implements View.OnClickListener {
    Button backButton;
    TextView downloadedData;
    Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
    }

    @Override
    protected void onStart() {
        super.onStart();
        backButton=findViewById(R.id.back_button);
        downloadedData=findViewById(R.id.downloaded_data);
        bundle=getIntent().getExtras();
        if (bundle !=null){
            String username=bundle.getString("user_name");
            String password=bundle.getString("password");
            String mobileNo=bundle.getString("mobile_no");
            downloadedData.setText("UserNmae is : "+username+"\npassword is: "+password+"\nmobileNo is :"+mobileNo);
        }
        backButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        //back to main activity
        onBackPressed();
    }
}
