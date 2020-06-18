package org.activites.uberclonjava;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.activites.uberclonjava.includes.MyToolbar;
import org.activites.uberclonjava.models.User;

import dmax.dialog.SpotsDialog;

public class RegisterActivity extends AppCompatActivity {

    SharedPreferences mPref;
    FirebaseAuth mAuth;

    DatabaseReference mDatabase;
    Button mButtonRegister;
    TextInputEditText mTextInputEmail;
    TextInputEditText mTextInputPassword;
    TextInputEditText mTextInputUsername;
    AlertDialog mAlertDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mPref = getApplicationContext().getSharedPreferences("typeUser", MODE_PRIVATE);

        mDatabase = FirebaseDatabase.getInstance().getReference();

       MyToolbar.show(this, "Registro de usuario", true);

        mButtonRegister = findViewById(R.id.btnRegister);
        mTextInputEmail = findViewById(R.id.textInputEmail);
        mTextInputPassword = findViewById(R.id.textInputPassword);
        mTextInputUsername = findViewById(R.id.textInputUsername);
        mAuth = FirebaseAuth.getInstance();
        mAlertDialog = new SpotsDialog.Builder().setContext(RegisterActivity.this)
                .setMessage("Espere un momento").build();
        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });

        String selectedUser = mPref.getString("user", "");
    }

    private void registerUser() {
        final String name = mTextInputUsername.getText().toString();
        final String password = mTextInputPassword.getText().toString();
        final String email = mTextInputEmail.getText().toString();

        if(!name.isEmpty() && !password.isEmpty() && !email.isEmpty()){
            if(password.length() >= 6){
                mAlertDialog.show();
                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        mAlertDialog.hide();
                        if(task.isSuccessful()){
                            String id = mAuth.getCurrentUser().getUid();
                            saveUser(id, name, email);
                        } else {
                            Toast.makeText(RegisterActivity.this, "No se pudo realizar el registro", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            } else {
                Toast.makeText(this, "La contraseña debe de tener al menos seis caracteres.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

    private void saveUser(String id, String name, String email) {
        String selectedUser = mPref.getString("user", "");
        User user = new User();
        user.setEmail(email);
        user.setName(name);
        if(selectedUser.equals("driver")){
            mDatabase.child("Users").child("Drivers").child(id).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(RegisterActivity.this, "Registro exitoso.", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(RegisterActivity.this, "Fallo en el registro.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        } else {
            mDatabase.child("Users").child("Clients").child("Drivers").setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(RegisterActivity.this, "Registro exitoso.", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(RegisterActivity.this, "Fallo en el registro.", Toast.LENGTH_SHORT).show();
                    }
                }
            });;
        }

    }


}