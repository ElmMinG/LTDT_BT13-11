package vn.iotstar.loginactivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    EditText edtEmail, edtPassword;
    ImageButton btnLogin;
    TextView tvRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        anhXaViews();
        xuLySuKienLogin();
        xuLyChuyenSangManHinhDangKy();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void anhXaViews() {
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvRegister = findViewById(R.id.tvRegister);
    }

    private void xuLySuKienLogin() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailInput = edtEmail.getText().toString().trim();
                String passwordInput = edtPassword.getText().toString().trim();

                if (emailInput.isEmpty() || passwordInput.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                    return;
                }

                // --- KIỂM TRA TÀI KHOẢN TỪ DỮ LIỆU ĐÃ LƯU ---
                // 1. Mở file SharedPreferences (phải cùng tên với file đã lưu: "USER_ACCOUNT")
                SharedPreferences sharedPreferences = getSharedPreferences("USER_ACCOUNT", MODE_PRIVATE);
                // 2. Đọc email và password đã lưu. Nếu không có thì giá trị mặc định là chuỗi rỗng ""
                String savedEmail = sharedPreferences.getString("EMAIL", "");
                String savedPassword = sharedPreferences.getString("PASSWORD", "");

                // 3. So sánh
                if (emailInput.equals(savedEmail) && passwordInput.equals(savedPassword)) {
                    // Đăng nhập thành công
                    Toast.makeText(LoginActivity.this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish(); // Đóng màn hình Login
                } else {
                    // Đăng nhập thất bại
                    Toast.makeText(LoginActivity.this, "Email hoặc mật khẩu không đúng", Toast.LENGTH_SHORT).show();
                }
                // ---------------------------------------------
            }
        });
    }

    private void xuLyChuyenSangManHinhDangKy() {
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}