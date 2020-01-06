package ru.tenant.pass24.helpers.WelcomeView.pageindicatorview.home;

import android.util.SparseArray;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class WelcomeFragmentAdapter extends FragmentPagerAdapter {
    SparseArray<Fragment> registeredFragments = new SparseArray<>();
    private List<Fragment> fragmentList;

    public WelcomeFragmentAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }


    public void setData(List<Fragment> fragmentList) {
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}