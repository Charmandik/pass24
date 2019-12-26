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
        Constants.authToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczpcL1wvdGVuYW50LWFwaS5hbHBoYS5wYXNzMjQub25saW5lXC9hdXRoXC9sb2dpbiIsImlhdCI6MTU3NzM3OTMxNCwiZXhwIjoxNTc3NDY1NzE0LCJuYmYiOjE1NzczNzkzMTQsImp0aSI6Ilk1ZmI1U25zRUJQNlJwUWEiLCJzdWIiOjEwMDAwMDIsInBydiI6IjQzMjYzMzc1ZjdmZmQ2YTJjZTVmMzhiZTkzOGZkMTJlM2YwNzlmYWUiLCJ1aWQiOiI3OTYzNjk5MzYzMDVlMDRlNWYyYWRjNDM2Ljc3MDgyOTYwIn0.WYWDp_gN0wfEjCm_eUWqwL7Q8ElcoJMQcEoQU1QpZFk";
//        FragmentManager fragmentManager = this.getSupportFragmentManager();
//        fragmentManager.beginTransaction().add(R.id.flMainContainer, new WelcomeMainFragment()).commit();
    }
}
