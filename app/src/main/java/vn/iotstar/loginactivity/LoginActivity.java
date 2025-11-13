package vn.iotstar.loginactivity;

import android.annotation.SuppressLint;
import android.content.Intent;
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

    // 1. Khai báo các View cần tương tác
    EditText edtEmail, edtPassword;
    ImageButton btnLogin;
    TextView tvRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Dòng này không cần thiết nếu bạn đã ẩn Action Bar bằng theme
        // EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login); // Đảm bảo tên file layout của bạn là activity_login.xml

        // 2. Ánh xạ các View từ layout XML
        anhXaViews();

        // 3. Xử lý sự kiện click cho nút Login
        xuLySuKienLogin();

        // 4. Xử lý sự kiện click cho chữ Register
        xuLyChuyenSangManHinhDangKy();

        // Đoạn code mặc định cho Edge-to-Edge
        // Bạn cần đặt ID "main" cho ConstraintLayout gốc trong XML để code này hoạt động
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // Hàm để gom việc ánh xạ View cho gọn
    @SuppressLint("WrongViewCast")
    private void anhXaViews() {
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvRegister = findViewById(R.id.tvRegister);
    }

    // Hàm xử lý logic khi nhấn nút Login
    private void xuLySuKienLogin() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy dữ liệu người dùng nhập
                String email = edtEmail.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();

                // Kiểm tra dữ liệu
                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                } else if (email.equals("admin") && password.equals("admin")) {
                    // Đăng nhập thành công (đây chỉ là ví dụ)
                    Toast.makeText(LoginActivity.this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
                    // Chuyển sang màn hình chính (MainActivity)
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish(); // Đóng màn hình Login để người dùng không quay lại được bằng nút back
                } else {
                    // Đăng nhập thất bại
                    Toast.makeText(LoginActivity.this, "Email hoặc mật khẩu không đúng", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Hàm xử lý logic khi nhấn vào chữ Register
    private void xuLyChuyenSangManHinhDangKy() {
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tạo một Intent để mở SignUpActivity
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}