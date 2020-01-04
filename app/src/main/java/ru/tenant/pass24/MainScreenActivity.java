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

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import ru.tenant.pass24.authorizationFragments.Login.LoginFragment;
import ru.tenant.pass24.profileFragments.passes.Navigation_clicks;

public class MainScreenActivity extends AppCompatActivity implements Navigation_clicks {

    FragmentManager fragmentManager;
    private AppBarConfiguration mAppBarConfiguration;
    private ImageButton ibProfileSettings;
    private NavController navController;
    private Navigation_clicks navigation_clicks;
    private Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main_screen);
        fragmentManager = this.getSupportFragmentManager();

        final DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
        NavigationUI.setupWithNavController(navigationView, navController);
        drawer.openDrawer(GravityCompat.START);
//        navController.navigate(R.id.action_nav_passes_to_passOrderFragment);
        ibProfileSettings = navigationView.getHeaderView(0).findViewById(R.id.ibProfileSettings);
        ibProfileSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("tag", "gallery");
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_passes:
                        Bundle bundle = new Bundle();
                        navController.navigate(R.id.nav_passes, bundle);
                        drawer.closeDrawer(Gravity.LEFT, true);
                        break;
                    case R.id.nav_templates:
                        navController.navigate(R.id.nav_templates);
                        drawer.closeDrawer(Gravity.LEFT, true);
                        break;
                    case R.id.nav_requests:
                        navController.navigate(R.id.nav_requests);
                        drawer.closeDrawer(Gravity.LEFT, true);
                        break;
                    case R.id.nav_events_feed:
                        navController.navigate(R.id.nav_events_feed);
                        drawer.closeDrawer(Gravity.LEFT, true);
                        break;
                    case R.id.nav_trusted_people:
                        navController.navigate(R.id.nav_trusted_people);
                        drawer.closeDrawer(Gravity.LEFT, true);
                        break;
                    case R.id.btnLogout:
                        clearToken();
                        //add movement to MainActivity then to Login Fragment

                        Intent intent = new Intent(mContext, MainActivity.class);
                        intent.putExtra("toLogin", true);
                        startActivity(intent);
                        fragmentManager.beginTransaction().replace(R.id.flRequestsContainer, new LoginFragment()).commit();
                        break;
                }

//                fragmentManager.beginTransaction().replace(R.id.flMainContainer, fragment).commit();
                menuItem.setChecked(true);
                setTitle(menuItem.getTitle());
                drawer.closeDrawers();
                return false;
            }
        });
    }

    public void clearToken() {
        SharedPreferences sharedPreferences = this.getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("AUTH_TOKEN");
        editor.apply();
    }

    @Override
    public void toPassOrder() {
        navController.navigate(R.id.nav_passes);
    }
}
