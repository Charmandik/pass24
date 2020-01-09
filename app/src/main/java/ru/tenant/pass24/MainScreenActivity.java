package ru.tenant.pass24;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import ru.tenant.pass24.helpers.Constants;


public class MainScreenActivity extends AppCompatActivity {
    private AppBarConfiguration mAppBarConfiguration;
    private ImageButton ibProfileSettings;
    private NavController navController;
    private Context mContext;
    private TextView tvUserName, tvUserPhone, btnLogout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main_screen);
        final DrawerLayout drawer = findViewById(R.id.drawer_layout);
        final NavigationView navigationView = findViewById(R.id.nav_view);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
        NavigationUI.setupWithNavController(navigationView, navController);
        drawer.openDrawer(GravityCompat.START);

        ibProfileSettings = navigationView.getHeaderView(0).findViewById(R.id.ibProfileSettings);
        tvUserName = navigationView.getHeaderView(0).findViewById(R.id.tvUserName);
        tvUserPhone = navigationView.getHeaderView(0).findViewById(R.id.tvUserPhone);
        tvUserName.setText(Constants.userFullName);
        tvUserPhone.setText("+" + Constants.userPhone);
        ibProfileSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.profileFragment);
                drawer.closeDrawer(Gravity.LEFT, true);
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_balance:
                        drawer.closeDrawers();
                        Log.d("tag", "balance");
                        menuItem.setChecked(true);
                        break;
                    case R.id.navigation_menu:
                        drawer.openDrawer(GravityCompat.START);
                        menuItem.setChecked(true);
                        break;
                    case R.id.nav_passes:
                        navController.navigate(R.id.nav_passes);
                        menuItem.setChecked(true);
                        break;
                    case R.id.nav_templates:
                        navController.navigate(R.id.nav_templates);
                        menuItem.setChecked(true);
                        break;
                    case R.id.nav_requests:
                        navController.navigate(R.id.nav_requests);
                        menuItem.setChecked(true);
                        break;
                    case R.id.nav_events_feed:
                        navController.navigate(R.id.nav_events_feed);
                        menuItem.setChecked(true);
                        break;
                    case R.id.nav_create_pass:
                        navController.navigate((R.id.nav_passes));
                        drawer.closeDrawer(GravityCompat.START);
                        menuItem.setChecked(true);
                        break;
                }
                drawer.closeDrawers();
                return false;
            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case (R.id.navigation_menu):
                        drawer.openDrawer(GravityCompat.START);
                        menuItem.setChecked(true);
                        break;
                    case (R.id.nav_passes):
                        navController.navigate(R.id.nav_passes);
                        drawer.closeDrawers();
                        menuItem.setChecked(true);
                        break;
                    case (R.id.nav_create_pass):
                        Bundle bundle = new Bundle();
                        bundle.putString("action", "toCreate");
                        navController.navigate(R.id.nav_passes, bundle);
                        menuItem.setChecked(true);
                        drawer.closeDrawers();
                        break;
                    case (R.id.nav_requests):
                        navController.navigate(R.id.nav_requests);
                        menuItem.setChecked(true);
                        drawer.closeDrawers();
                        break;
                    case (R.id.nav_events_feed):
                        navController.navigate(R.id.nav_events_feed);
                        menuItem.setChecked(true);
                        drawer.closeDrawers();
                        break;
                }
                return false;
            }
        });

        btnLogout = findViewById(R.id.tvLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearToken();
                Intent intent = new Intent(mContext, MainActivity.class);
                intent.putExtra("toLogin", true);
                startActivity(intent);
            }
        });
    }

    public void clearToken() {
        SharedPreferences sharedPreferences = this.getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("AUTH_TOKEN");
        editor.apply();
    }
}
