package ru.tenant.pass24.Fragments.Welcome;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

import ru.tenant.pass24.Fragments.Login.LoginFragment;
import ru.tenant.pass24.Helpers.WelcomeView.PageIndicatorView;
import ru.tenant.pass24.Helpers.WelcomeView.animation.type.AnimationType;
import ru.tenant.pass24.Helpers.WelcomeView.pageindicatorview.base.WelcomeChangeFragment;
import ru.tenant.pass24.Helpers.WelcomeView.pageindicatorview.data.Customization;
import ru.tenant.pass24.Helpers.WelcomeView.pageindicatorview.home.WelcomeFragmentAdapter;
import ru.tenant.pass24.R;

public class WelcomeMainFragment extends Fragment {

    private Customization customization;
    private ViewPager viewPager;
    private Button goButton;
    private TextView welcomeSkip;
    private PageIndicatorView pageIndicatorView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.welcome_fragment, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        customization = new Customization();
        customization.setAnimationType(AnimationType.THIN_WORM);
        initViews(view);
    }


    private void initViews(View view) {
        viewPager = view.findViewById(R.id.vpWelcome);
        goButton = view.findViewById(R.id.btnWelcomeGo);
        welcomeSkip = view.findViewById(R.id.tvWelcomeSkip);
        welcomeSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(3);
            }
        });

        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toLogin();
            }
        });

        final WelcomeFragmentAdapter WelcomeFragmentAdapter = new WelcomeFragmentAdapter(this.getFragmentManager());
        WelcomeFragmentAdapter.setData(createPageList());
        viewPager.setAdapter(WelcomeFragmentAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                if (position == 3) {
                    welcomeSkip.setVisibility(View.INVISIBLE);
                    goButton.setVisibility(View.VISIBLE);
                } else {
                    goButton.setVisibility(View.INVISIBLE);
                    welcomeSkip.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }


    public void toLogin() {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.flMainContainer, new LoginFragment())
                .addToBackStack(null)
                .commit();

    }

    @NonNull
    private List<Fragment> createPageList() {
        List<Fragment> pageList = new ArrayList<>();

        WelcomeChangeFragment fragmentWelcomeDescription = new WelcomeChangeFragment();
        Bundle bundle = new Bundle();
        bundle.putString("type", "description");
        bundle.putBoolean("last_page", false);
        fragmentWelcomeDescription.setArguments(bundle);

        WelcomeChangeFragment fragmentWelcomeInvite = new WelcomeChangeFragment();
        Bundle bundle1 = new Bundle();
        bundle1.putString("type", "invite");
        bundle1.putBoolean("last_page", false);
        fragmentWelcomeInvite.setArguments(bundle1);

        WelcomeChangeFragment fragmentWelcomeAuthority = new WelcomeChangeFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putString("type", "authority");
        bundle2.putBoolean("last_page", false);
        fragmentWelcomeAuthority.setArguments(bundle2);

        WelcomeChangeFragment fragmentWelcomeGo = new WelcomeChangeFragment();
        Bundle bundle3 = new Bundle();
        bundle3.putString("type", "go");
        bundle3.putBoolean("last_page", true);
        fragmentWelcomeGo.setArguments(bundle3);

        pageList.add(fragmentWelcomeDescription);
        pageList.add(fragmentWelcomeInvite);
        pageList.add(fragmentWelcomeAuthority);
        pageList.add(fragmentWelcomeGo);

        return pageList;
    }
}
