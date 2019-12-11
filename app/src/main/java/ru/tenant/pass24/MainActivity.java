package ru.tenant.pass24;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import ru.tenant.pass24.Helpers.Retrofit.ApiService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registry_confirm_fragment);
    }
}
