package ru.tenant.pass24;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import ru.tenant.pass24.authorizationFragments.login.LoginFragment;
import ru.tenant.pass24.authorizationFragments.welcome.WelcomeMainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = this.getSupportFragmentManager();
        if (getIntent().getBooleanExtra("toLogin", false))
            fragmentManager.beginTransaction().add(R.id.flMainContainer, new LoginFragment()).commit();
        else
            fragmentManager.beginTransaction().add(R.id.flMainContainer, new WelcomeMainFragment()).commit();
    }
}