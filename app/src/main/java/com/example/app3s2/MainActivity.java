package com.example.app3s2;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {
    private EditText etUsername,etPassword;
    private String username,password;
    private LayoutInflater inflater;
    private View dialogView;
    private Intent intent;
    private Button btnLogin;
    private AlertDialog.Builder builder;
    private AlertDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showLoginDialog();
            }
        });
    }
    private void showLoginDialog() {
        builder = new AlertDialog.Builder(this);
        inflater = getLayoutInflater();
        dialogView = inflater.inflate(R.layout.dialog_login, null);
        builder.setView(dialogView);

        etUsername = dialogView.findViewById(R.id.etUsername);
        etPassword = dialogView.findViewById(R.id.etPassword);

        builder.setTitle("تسجيل الدخول")
                .setPositiveButton("Login", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {

                        username = etUsername.getText().toString().trim();
                        password = etPassword.getText().toString().trim();

                        if (username.equals("admin") && password.equals("admin")) {
                            // إذا كانت المعطيات صحيحة
                            Toast.makeText(MainActivity.this, "تم تسجيل الدخول بنجاح!", Toast.LENGTH_SHORT).show();
                            dialog.dismiss(); // إغلاق مربع الحوار
                            intent = new Intent(MainActivity.this, Activity2.class);
                            intent.putExtra("username", username); // إرسال اسم المستخدم
                            startActivity(intent); // الانتقال إلى الصفحة الثانية
                        } else {
                            // إذا كانت المعطيات غير صحيحة
                            Toast.makeText(MainActivity.this, "خطأ في اسم المستخدم أو كلمة المرور", Toast.LENGTH_SHORT).show();
                            etUsername.setText(""); // مسح اسم المستخدم
                            etPassword.setText(""); // مسح كلمة المرور
                        }
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        dialog = builder.create();
        dialog.show();
    }
}


