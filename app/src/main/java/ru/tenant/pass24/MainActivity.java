package ru.tenant.pass24;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import ru.tenant.pass24.Helpers.Constants;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startActivity(new Intent(this, MainScreenActivity.class));
        Constants.authToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczpcL1wvbW9iaWxlLWFwaS5wYXNzMjRvbmxpbmUucnVcL3YxXC9hdXRoXC9sb2dpbiIsImlhdCI6MTU3NzUxNTAzMSwiZXhwIjoxNTc3NjAxNDMxLCJuYmYiOjE1Nzc1MTUwMzEsImp0aSI6IlA1NzVHZEIwMHZ4ZWxudmgiLCJzdWIiOjEwMDAwMDIsInBydiI6IjQzMjYzMzc1ZjdmZmQ2YTJjZTVmMzhiZTkzOGZkMTJlM2YwNzlmYWUiLCJ1aWQiOiI3OTYzNjk5MzYzMDVlMDZmODE3Y2Y0ZDkwLjA1MzcxNjc2In0.lOOaAvLEBo4XasS4blz-3Js42bBExKpn25aiJcJVhRM";
//        FragmentManager fragmentManager = this.getSupportFragmentManager();
//        fragmentManager.beginTransaction().add(R.id.flMainContainer, new WelcomeMainFragment()).commit();
    }
}
