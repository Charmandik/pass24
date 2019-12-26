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
        Constants.authToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczpcL1wvdGVuYW50LWFwaS5hbHBoYS5wYXNzMjQub25saW5lXC9hdXRoXC9sb2dpbiIsImlhdCI6MTU3NzM2Njg3NCwiZXhwIjoxNTc3NDUzMjc0LCJuYmYiOjE1NzczNjY4NzQsImp0aSI6IlNqWWtBZDNpSWdKZzJWYW4iLCJzdWIiOjEwMDAwMDIsInBydiI6IjQzMjYzMzc1ZjdmZmQ2YTJjZTVmMzhiZTkzOGZkMTJlM2YwNzlmYWUiLCJ1aWQiOiI3OTYzNjk5MzYzMDVlMDRiNTU5ZTVjNzE3Ljk3OTUwNTk1In0.q9bSgmZVcQhf00-VJphwO_G5iU4t2kz3QOJsgO3bhEI";
//        FragmentManager fragmentManager = this.getSupportFragmentManager();
//        fragmentManager.beginTransaction().add(R.id.flMainContainer, new WelcomeMainFragment()).commit();
    }
}
