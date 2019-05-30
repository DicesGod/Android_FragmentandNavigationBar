package com.mir.c04.fragment;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

import com.mir.c04.R;
import com.mir.c04.connector.FragmentEventListener;
import com.mir.c04.dao.UserDao;
import com.mir.c04.dao.UserFactory;
import com.mir.c04.model.User;


public class ListUserFragment extends ListFragment {

    private FragmentEventListener fragmentEventListener;
    private UserDao userDao;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        fragmentEventListener = (FragmentEventListener) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userDao = UserFactory.getUserDao();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_user, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Context context = getContext();
        assert context != null;
        ArrayAdapter<User> userArrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1);
        userArrayAdapter.addAll(userDao.getAll());
        setListAdapter(userArrayAdapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        fragmentEventListener.onUserListClicked(userDao.getUserById(position));
    }
}
