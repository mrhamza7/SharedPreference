package com.mrhamza.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.mrhamza.sharedpreference.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnSaveNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message=binding.etNotes.getEditableText().toString();
                SharedPreferences shrd=getSharedPreferences("demo",MODE_PRIVATE);
                SharedPreferences.Editor editor=shrd.edit();
                editor.putString("str",message);
                editor.apply();
                binding.tvNotes.setText(message);
            }
        });
        // Get the value of SharedPreference back
        SharedPreferences getShared=getSharedPreferences("demo",MODE_PRIVATE);
        String value=getShared.getString("str","Save a note and it will show up here ");
        binding.tvNotes.setText(value);
    }
}