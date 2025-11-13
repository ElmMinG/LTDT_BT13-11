    package vn.iotstar.loginactivity;

    import android.content.SharedPreferences;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.EditText;
    import android.widget.ImageButton;
    import android.widget.Toast;

    import androidx.appcompat.app.AppCompatActivity;
    import androidx.core.graphics.Insets;
    import androidx.core.view.ViewCompat;
    import androidx.core.view.WindowInsetsCompat;

    public class SignUpActivity extends AppCompatActivity {

        // 1. Khai báo các View cần tương tác
        EditText edtName, edtEmail, edtPassword;
        ImageButton btnSignUp;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_sign_up); // Đảm bảo tên file layout đúng

            // 2. Ánh xạ các View từ layout XML
            anhXaViews();

            // 3. Xử lý sự kiện click cho nút Đăng ký
            xuLySuKienSignUp();

            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
        }

        private void anhXaViews() {
            edtName = findViewById(R.id.edtName);
            edtEmail = findViewById(R.id.edtEmail);
            edtPassword = findViewById(R.id.edtPassword);
            btnSignUp = findViewById(R.id.btnSignUp);
        }

        // Hàm xử lý logic khi nhấn nút Đăng ký
        private void xuLySuKienSignUp() {
            btnSignUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String name = edtName.getText().toString().trim();
                    String email = edtEmail.getText().toString().trim();
                    String password = edtPassword.getText().toString().trim();

                    if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                        Toast.makeText(SignUpActivity.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    // --- LƯU TÀI KHOẢN VỪA ĐĂNG KÝ ---
                    // 1. Mở file SharedPreferences (tên file là "USER_ACCOUNT")
                    SharedPreferences sharedPreferences = getSharedPreferences("USER_ACCOUNT", MODE_PRIVATE);
                    // 2. Tạo đối tượng để chỉnh sửa file
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    // 3. Lưu email và password vào file
                    editor.putString("EMAIL", email);
                    editor.putString("PASSWORD", password);
                    // 4. Hoàn tất việc lưu trữ
                    editor.apply();
                    // ------------------------------------

                    Toast.makeText(SignUpActivity.this, "Đăng ký thành công!", Toast.LENGTH_SHORT).show();

                    // Đóng màn hình đăng ký để quay lại màn hình đăng nhập
                    finish();
                }
            });
        }
    }