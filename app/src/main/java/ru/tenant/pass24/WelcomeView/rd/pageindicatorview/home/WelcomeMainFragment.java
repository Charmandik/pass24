package ru.tenant.pass24.WelcomeView.rd.pageindicatorview.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

import ru.tenant.pass24.R;
import ru.tenant.pass24.WelcomeView.rd.PageIndicatorView;
import ru.tenant.pass24.WelcomeView.rd.animation.type.AnimationType;
import ru.tenant.pass24.WelcomeView.rd.pageindicatorview.base.WelcomeFragments;
import ru.tenant.pass24.WelcomeView.rd.pageindicatorview.data.Customization;

public class WelcomeMainFragment extends AppCompatActivity {

    private PageIndicatorView pageIndicatorView;
    private Customization customization;
    private ViewPager viewPager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_fragment);
        customization = new Customization();
        customization.setAnimationType(AnimationType.THIN_WORM);
        initViews();
//        updateIndicators();
    }

    private void initViews() {
        viewPager = findViewById(R.id.vpWelcome);
        WelcomeFragmentAdapter WelcomeFragmentAdapter = new WelcomeFragmentAdapter(getSupportFragmentManager());
        WelcomeFragmentAdapter.setData(createPageList());
        viewPager.setAdapter(WelcomeFragmentAdapter);
        pageIndicatorView = findViewById(R.id.pageIndicatorView);
    }

    @NonNull
    private List<Fragment> createPageList() {
        List<Fragment> pageList = new ArrayList<>();

        WelcomeFragments fragmentWelcomeDescription = new WelcomeFragments();
        Bundle bundle1 = new Bundle();
        bundle1.putString("type", "description");
        bundle1.putBoolean("last_page", false);
        fragmentWelcomeDescription.setArguments(bundle1);

        WelcomeFragments fragmentWelcomeInvite = new WelcomeFragments();
        Bundle bundle2 = new Bundle();
        bundle2.putString("type", "invite");
        bundle2.putBoolean("last_page", false);
        fragmentWelcomeInvite.setArguments(bundle2);

        WelcomeFragments fragmentWelcomeAuthority = new WelcomeFragments();
        Bundle bundle3 = new Bundle();
        bundle3.putString("type", "authority");
        bundle3.putBoolean("last_page", false);
        fragmentWelcomeAuthority.setArguments(bundle3);

        WelcomeFragments fragmentWelcomeGo = new WelcomeFragments();
        Bundle bundle4 = new Bundle();
        bundle4.putString("type", "go");
        bundle4.putBoolean("last_page", true);
        fragmentWelcomeGo.setArguments(bundle4);

        pageList.add(fragmentWelcomeDescription);
        pageList.add(fragmentWelcomeInvite);
        pageList.add(fragmentWelcomeAuthority);
        pageList.add(fragmentWelcomeGo);


        return pageList;
    }

//    private void updateIndicators() {
//        if (customization == null) {
//            return;
//        }
//        pageIndicatorView.setAnimationType(customization.getAnimationType());
//        pageIndicatorView.setOrientation(customization.getOrientation());
//        pageIndicatorView.setRtlMode(customization.getRtlMode());
//        pageIndicatorView.setInteractiveAnimation(customization.isInteractiveAnimation());
//        pageIndicatorView.setAutoVisibility(customization.isAutoVisibility());
//    }
}
