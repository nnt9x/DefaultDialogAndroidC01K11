package com.bkacad.nnt.defaultdialogandroidc01k11;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnShow, btnShowCustomDialog;
    private AlertDialog alertDialog;
    private MyDialog myDialog;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnShow = findViewById(R.id.btnShow);
        btnShowCustomDialog = findViewById(R.id.btnShowCustomDialog);
        tvResult = findViewById(R.id.tvResult);

        // Để tạo ra AlertDialog -> lớp Builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("Tiêu đề")
                .setMessage("Bạn có muốn thoát khỏi ứng dụng ?")
                .setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"Thoát ứng dụng",Toast.LENGTH_SHORT).show();
                        finish();
                    }
                })
                .setNeutralButton("Test", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton("Huỷ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"Huỷ",Toast.LENGTH_SHORT).show();
                    }
                });

        alertDialog = builder.create();
        // Sự kiện khi click vào button
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.show();
            }
        });


        // Code tiếp ở đây

        myDialog = new MyDialog(this) {
            @Override
            public void sendData(String data) {
                tvResult.setText(data);
                Toast.makeText(MainActivity.this,"Lấy dữ liệu thành công",Toast.LENGTH_SHORT).show();
            }
        };
        btnShowCustomDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.show();
            }
        });

    }
}