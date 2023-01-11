package com.first.machinetestvoyager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {
ImageView profileImage;
TextView pname,pemail;
String path;
Uri uri;
FloatingActionButton addvideo;
//Uri imageUri;
//private FirebaseStorage storage;
//private StorageReference storageReference;

    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        preferences = getSharedPreferences("userdata",0);
//
//        storage =FirebaseStorage.getInstance();
//        storageReference = storage.getReference();

        profileImage = (ImageView) findViewById(R.id.imgprofile);
        pname = (TextView) findViewById(R.id.profname);
        pemail = (TextView) findViewById(R.id.profmail);
        addvideo = (FloatingActionButton)findViewById(R.id.addvideo);

        String registeredusername = preferences.getString("username","");
        String registeredemail = preferences.getString("useremail","");
        pname.setText("Username : "+registeredusername);
        pemail.setText("Email : "+registeredemail);

        profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               //choosepicture();
            }
        });

        addvideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             startActivity(new Intent(getApplicationContext(),AddVideo.class));
            }
        });
    }

//    private void choosepicture() {
//        Intent intent = new Intent();
//        intent.setType("image/*");
//        intent.setAction(Intent.ACTION_GET_CONTENT);
//        startActivityForResult(intent,1);
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (resultCode == 1 && resultCode == RESULT_OK && data!=null && data.getData()!=null)
//        {
//          imageUri = data.getData();
//          profileImage.setImageURI(imageUri);
//          uploadpicture();
//        }
//    }
//
//    private void uploadpicture()
//    {
//        ProgressDialog pd = new ProgressDialog(this);
//        pd.setTitle("uploading image......");
//        pd.show();
//        final String randomKey = UUID.randomUUID().toString();
//        StorageReference mountainsRef = storageReference.child("images/"+randomKey);
//
//        mountainsRef.putFile(imageUri)
//                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                    @Override
//                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                        pd.dismiss();
//                        Snackbar.make(findViewById(android.R.id.content),"Image Uploaded",Snackbar.LENGTH_LONG).show();
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        pd.dismiss();
//                        Toast.makeText(getApplicationContext(),"Failed to upload",Toast.LENGTH_LONG).show();
//                    }
//                })
//                .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
//                    @Override
//                    public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
//                    double progresspercent = (100.00 * snapshot.getBytesTransferred()/snapshot.getTotalByteCount());
//                    pd.setMessage("Progress: " + (int) progresspercent + "%");
//                    }
//                });

  //  }
}