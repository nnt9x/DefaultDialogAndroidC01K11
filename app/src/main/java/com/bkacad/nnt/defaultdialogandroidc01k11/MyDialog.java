package com.bkacad.nnt.defaultdialogandroidc01k11;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;

public abstract class MyDialog extends Dialog {

    public MyDialog(@NonNull Context context) {
        super(context);
    }

    // Alt + Ins

    private Button btnSend, btnCancel;
    private EditText edtAnswer;


    private void initUI(){
        edtAnswer = findViewById(R.id.edtAnswer);
        btnSend = findViewById(R.id.btnSend);
        btnCancel = findViewById(R.id.btnCancel);
    }

    @Override
    public void show() {
        super.show();
        edtAnswer.setText("");
    }

    public abstract void sendData(String data);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_dialog);
        initUI();

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy dữ liệu từ EditText -> gửi về MainActivity để xử lý
                String rs = edtAnswer.getText().toString();
                if(rs.isEmpty()) {
                    edtAnswer.setError("Nhập dữ liệu!");
                    return;
                }
                sendData(rs);
                dismiss();
            }
        });
    }
}
