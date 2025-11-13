package vn.iotstar.loginactivity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Dòng này sẽ kết nối code Java với giao diện dashboard bạn đã thiết kế
        setContentView(R.layout.activity_main);
    }
}