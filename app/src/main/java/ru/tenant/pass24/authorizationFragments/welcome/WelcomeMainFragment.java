package ru.tenant.pass24.authorizationFragments.welcome;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ru.tenant.pass24.MainScreenActivity;
import ru.tenant.pass24.R;
import ru.tenant.pass24.apiModelsNonUsed.ProfileResponse;
import ru.tenant.pass24.authorizationFragments.login.LoginFragment;
import ru.tenant.pass24.authorizationFragments.login.apiModels.LoginResponse;
import ru.tenant.pass24.helpers.Constants;
import ru.tenant.pass24.helpers.WelcomeView.PageIndicatorView;
import ru.tenant.pass24.helpers.WelcomeView.animation.type.AnimationType;
import ru.tenant.pass24.helpers.WelcomeView.pageindicatorview.base.WelcomeChangeFragment;
import ru.tenant.pass24.helpers.WelcomeView.pageindicatorview.data.Customization;
import ru.tenant.pass24.helpers.WelcomeView.pageindicatorview.home.WelcomeFragmentAdapter;
import ru.tenant.pass24.helpers.retrofit.ApiService;

import static android.content.Context.MODE_PRIVATE;

public class WelcomeMainFragment extends Fragment {

    private Customization customization;
    private ViewPager viewPager;
    private Button goButton;
    private TextView welcomeSkip;
    private PageIndicatorView pageIndicatorView;
    private SharedPreferences sharedPreferences;
    private Context mContext;
    private WelcomeMainFragment mInstance;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_welcome, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mInstance = this;
        mContext = this.getContext();
        super.onViewCreated(view, savedInstanceState);
        sharedPreferences = this.getActivity().getPreferences(MODE_PRIVATE);
        String savedText = sharedPreferences.getString("AUTH_TOKEN", "");
        if (savedText.length() > 0) {
            Constants.authToken = savedText;
            getProfileInfo();
//            refreshToken();
        }

        mContext = this.getContext();
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


    public void refreshToken() {
        ApiService.getInstance().getAuthApi().refreshToken("Bearer " + sharedPreferences.getString("AUTH_TOKEN", ""))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginResponse loginResponse) {

                    }

                    @Override
                    public void onError(Throwable e) {
                        //todo add dialog
                    }

                    @Override
                    public void onComplete() {
                        Intent intent = new Intent(mContext, MainScreenActivity.class);
                        mContext.startActivity(intent);
                    }
                });
    }

    private void getProfileInfo() {
        ApiService.getInstance().getProfileApi().getProfile(Constants.getAuthToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ProfileResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ProfileResponse profileResponse) {
                        if (profileResponse != null) {
                            if (profileResponse.getBody() != null) {
                                if (profileResponse.getBody().getEmail() != null)
                                    Constants.userEmail = profileResponse.getBody().getEmail();

                                if (profileResponse.getBody().getFirstName() != null)
                                    Constants.userFirstName = profileResponse.getBody().getFirstName();

                                if (profileResponse.getBody().getLastName() != null)
                                    Constants.userLastName = profileResponse.getBody().getLastName();

                                if (profileResponse.getBody().getName() != null)
                                    Constants.userFullName = profileResponse.getBody().getName();

                                if (profileResponse.getBody().getPhone() != null)
                                    Constants.userPhone = profileResponse.getBody().getPhone();

                                Intent intent = new Intent(mContext, MainScreenActivity.class);
                                mContext.startActivity(intent);
                                if (mInstance.getActivity() != null)
                                    mInstance.getActivity().finish();
                            }
                            if (profileResponse.getError() != null) {
                                if (profileResponse.getError().getCode().equals("UNAUTHENTICATED")) {
                                    toLogin();
                                }
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }
}
