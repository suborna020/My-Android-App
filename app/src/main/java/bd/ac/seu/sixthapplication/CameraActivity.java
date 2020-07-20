package bd.ac.seu.sixthapplication;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class CameraActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView imageView;
    private Button cameraButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
    }

    @Override
    protected void onStart() {
        super.onStart();
        imageView =findViewById(R.id.myImage);
        cameraButton=findViewById(R.id.camera);
        cameraButton.setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onClick(View v) {
        if (v.getId() ==R.id.camera){
            checkPermissions(); //camera runtime permission
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    //runtime permission for camera
    private void checkPermissions() {
        if(checkSelfPermission(Manifest.permission.CAMERA)== PackageManager.PERMISSION_GRANTED) {
            invokeCamera();
        }else {
            String[] permissions={Manifest.permission.CAMERA}; //permission popup
            requestPermissions(permissions,1000);//1000 my suppose
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode==1000) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                invokeCamera(); //camena call funtion
            } else {
                Toast.makeText(this, "Unable to open camera", Toast.LENGTH_SHORT).show();
                //Toast.LENGTH_SHORT  :sort time toast made korlm
            }
        }
    }
    private void invokeCamera(){ //camena call funtion works
        Intent cameraIntent =new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        startActivityForResult(cameraIntent,1001);
    }
}









