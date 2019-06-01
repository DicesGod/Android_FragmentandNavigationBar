package com.mir.c04.pager;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.mir.c04.fragment.AddUserFragment;
import com.mir.c04.fragment.ListUserFragment;
import com.mir.c04.fragment.UpdateUserFragment;
import com.mir.c04.model.References;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                AddUserFragment addUserFragment = new AddUserFragment();
                return addUserFragment;
            case 1:
                ListUserFragment listUserFragment = new ListUserFragment();
                return listUserFragment;
            case 2:
                UpdateUserFragment updateUserFragment = new UpdateUserFragment();
                return updateUserFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Add User";
            case 1:
                return "List Users";
            case 2:
                return "Update User";
            default:
                return "NA";
        }
    }
}
