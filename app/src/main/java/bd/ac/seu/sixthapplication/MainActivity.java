package bd.ac.seu.sixthapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import bd.ac.seu.sixthapplication.listcontent.StudentListActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //ImageView image;
    //TextView text;
    Button clickMe, startService, stopService,camera,googleLocation;
    EditText username, password, mobileno;
    private Intent myServiceIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("abc", "on create callback");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("abc", "on start callback");
        clickMe = findViewById(R.id.next_page_button);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        mobileno = findViewById(R.id.mobileNo);
        camera = findViewById(R.id.camera);
        googleLocation = findViewById(R.id.googleLocation);


        //button on click
        clickMe.setOnClickListener(this);
        camera.setOnClickListener(this);
        googleLocation.setOnClickListener(this);

//--call Fragment here in 4 line
        //Fragment fragment =new ProductListFragment();
        //FragmentTransaction fragmentTransaction= getSupportFragmentManager().beginTransaction();
        //fragmentTransaction.replace(R.id.mainFrame,fragment); //main.xml er fram layout replace
        //fragmentTransaction.commit();


    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.camera) {
            startActivity(new Intent(this,CameraActivity.class));
        }else if (v.getId() == R.id.googleLocation) {
            startActivity(new Intent(this,MapActivity.class));
        }else {

            //call edit text table's values(string idName=variable.getxt,string value niye kaj korar jnno to.string)
            /*String username = this.username.getText().toString();
            String password = this.password.getText().toString();
            String mobileNo = this.mobileno.getText().toString();*/
            //call to another funtion
            Intent intent = new Intent(MainActivity.this, StudentListActivity.class);
               /* intent.putExtra("user_name",username);
                intent.putExtra("password",password);
                intent.putExtra("mobile_no",mobileNo); //key variable suppose :use_name
                */
            startActivity(intent);
        }
    }
}



