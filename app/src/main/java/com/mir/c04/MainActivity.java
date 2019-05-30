package com.mir.c04;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.mir.c04.connector.FragmentEventListener;
import com.mir.c04.dao.UserDao;
import com.mir.c04.dao.UserFactory;
import com.mir.c04.model.User;
import com.mir.c04.pager.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity implements FragmentEventListener {

    private ViewPagerAdapter viewPagerAdapter;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    private UserDao userDao;

    public static void hideKeyboard(@Nullable Context context, @Nullable View view) {
        assert context != null;
        assert view != null;
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getRootView().getWindowToken(), 0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        viewPager = findViewById(R.id.mainViewPager);
        viewPager.setAdapter(viewPagerAdapter);

        tabLayout = findViewById(R.id.mainTabLayout);
        tabLayout.setupWithViewPager(viewPager);

        userDao = UserFactory.getUserDao();
        userDao.addUser(new User("admin@mir.com", "Mir", "Saadati"));
    }

    @Override
    public void onUserAdded(User user) {
        userDao.addUser(user);
        viewPagerAdapter.notifyDataSetChanged();
        Toast.makeText(this, "User Added!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUserUpdated(String oldEmail, User newUser) {
        userDao.updateUser(userDao.getUserByEmail(oldEmail), newUser);
        viewPagerAdapter.notifyDataSetChanged();
        Toast.makeText(this, "User Updated!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUserListClicked(User user) {
    }
}
