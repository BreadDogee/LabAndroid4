package com.example.labandroid4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.labandroid4.databinding.ActivityFirstBinding;

public class FirstActivity extends AppCompatActivity {

    private ActivityFirstBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFirstBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = binding.editText.getText().toString();
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                intent.putExtra("user_text", text);
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            String systemTime = data.getStringExtra("system_time");
            binding.systemTimeTextview.setText("Системное время: " + systemTime);
        }
    }
}
