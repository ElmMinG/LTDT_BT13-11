    package vn.iotstar.loginactivity;

    import android.content.Intent;
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

            // Đoạn code mặc định cho Edge-to-Edge
            // Bạn cần đặt ID "main" cho ConstraintLayout gốc trong XML để code này hoạt động
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
        }

        // Hàm để gom việc ánh xạ View cho gọn
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
                    // Lấy dữ liệu người dùng nhập
                    String name = edtName.getText().toString().trim();
                    String email = edtEmail.getText().toString().trim();
                    String password = edtPassword.getText().toString().trim();

                    // Kiểm tra dữ liệu (ví dụ đơn giản)
                    if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                        Toast.makeText(SignUpActivity.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                        return; // Dừng lại nếu thông tin chưa đủ
                    }

                    // Logic đăng ký (ở đây chỉ hiển thị thông báo)
                    // Trong thực tế, bạn sẽ gửi dữ liệu này lên server
                    Toast.makeText(SignUpActivity.this, "Đăng ký thành công!", Toast.LENGTH_SHORT).show();

                    // Sau khi đăng ký thành công, quay trở lại màn hình đăng nhập
                    // Cách 1: Đơn giản là đóng màn hình hiện tại
                    finish();

                    // Cách 2: Tạo Intent mới để quay lại (để chắc chắn)
                    // Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                    // startActivity(intent);
                    // finish(); // Đóng màn hình SignUp
                }
            });
        }
    }