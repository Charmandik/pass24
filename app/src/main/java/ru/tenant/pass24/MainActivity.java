package ru.tenant.pass24;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import ru.tenant.pass24.helpers.Constants;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startActivity(new Intent(this, MainScreenActivity.class));
        Constants.authToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczpcL1wvbW9iaWxlLWFwaS5wYXNzMjRvbmxpbmUucnVcL3YxXC9hdXRoXC9sb2dpbiIsImlhdCI6MTU3NzYxNTUyMCwiZXhwIjoxNTc3NzAxOTIwLCJuYmYiOjE1Nzc2MTU1MjAsImp0aSI6IkpCRjFHVWt5QlZ2N3lqaDAiLCJzdWIiOjEwMDAwMDIsInBydiI6IjQzMjYzMzc1ZjdmZmQ2YTJjZTVmMzhiZTkzOGZkMTJlM2YwNzlmYWUiLCJ1aWQiOiI3OTYzNjk5MzYzMDVlMDg4MGEwYTFkNGQ0LjUzMjkwMTYzIn0.bcH8mjVUXy7TuWPXvOp_rEefc0EJ5flzfkaPs2fUnLc";
//        FragmentManager fragmentManager = this.getSupportFragmentManager();
//        fragmentManager.beginTransaction().add(R.id.flMainContainer, new WelcomeMainFragment()).commit();
    }
}
