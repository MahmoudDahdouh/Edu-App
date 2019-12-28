package com.mahmoud.dahdouh.eduapp.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.mahmoud.dahdouh.eduapp.R;
import com.squareup.picasso.Picasso;

public class AddFirstSchoolActivity extends AppCompatActivity {

    //
    private static final int PICK_IMAGE_REQUEST = 1;
    // Firebase
    private FirebaseUser user;
    private String userId;
    private FirebaseAuth auth;
    private DatabaseReference dataRef;
    private UploadTask uploadTask;
    private StorageReference storageRef;
    private Uri imageUri;

    private ImageView img_school_cover;
    private EditText ed_school_name, ed_location;
    private Button btn_select, btn_start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_first_school);


        //inflate
        ed_location = findViewById(R.id.ed_school_location);
        ed_school_name = findViewById(R.id.ed_school_name);
        btn_select = findViewById(R.id.btn_select_cover);
        btn_start = findViewById(R.id.btn_start);
        img_school_cover = findViewById(R.id.img_school_cover);

        //
        // Fire base
        auth = FirebaseAuth.getInstance();

        user = auth.getCurrentUser();
        userId = user.getUid();


        dataRef = FirebaseDatabase.getInstance().getReference().child("application").child("users");

        storageRef = FirebaseStorage.getInstance().getReference().child("images")
                .child("" + System.currentTimeMillis());

        //


        btn_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser();
            }
        });
        btn_start.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (ed_school_name.getText().toString().trim().equals("")
                        || ed_location.getText().toString().trim().equals("")) {
                    Toast.makeText(AddFirstSchoolActivity.this, "Please fill the fields !", Toast.LENGTH_SHORT).show();
                    return;
                }
                //check i
                if (imageUri == null) {
                    Toast.makeText(AddFirstSchoolActivity.this, "Please select Image !", Toast.LENGTH_SHORT).show();
                    return;
                }
                //code data

               /* storageRef.child("" + System.currentTimeMillis())
                        .putFile(imageUri);
*/
                uploadTask = storageRef.putFile(imageUri);

                Task<Uri> urlTask = uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                    @Override
                    public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                        if (!task.isSuccessful()) {
                            throw task.getException();
                        }

                        // Continue with the task to get the download URL
                        return storageRef.getDownloadUrl();
                    }
                }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                    @Override
                    public void onComplete(@NonNull Task<Uri> task) {
                        if (task.isSuccessful()) {
                            Uri downloadUri = task.getResult();
                            // get user id
                            String user_id = auth.getCurrentUser().getUid();


                            DatabaseReference userRef = dataRef.getRef();
                            userRef.child(user_id).child("school").setValue(downloadUri.toString());
                            userRef.child(user_id).child("school_name")
                                    .setValue(ed_school_name.getText().toString().trim());
                            userRef.child(user_id).child("school_location")
                                    .setValue(ed_location.getText().toString().trim());
                            startActivity(new Intent(AddFirstSchoolActivity.this, MainActivity.class));
                            finish();
                        } else {
                            // Handle failures
                            // ...
                        }
                    }
                });
                //

                //

                //


            }
        });

    }

    private void openFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK
                && data != null && data.getData() != null) {
            imageUri = data.getData();

            Picasso.get().load(imageUri).into(img_school_cover);

        }
    }


}
