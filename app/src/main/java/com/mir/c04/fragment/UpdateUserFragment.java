package com.mir.c04.fragment;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.mir.c04.MainActivity;
import com.mir.c04.R;
import com.mir.c04.connector.FragmentEventListener;
import com.mir.c04.model.User;

import java.util.Arrays;


public class UpdateUserFragment extends Fragment {

    private FragmentEventListener fragmentEventListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        fragmentEventListener = (FragmentEventListener) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_update_user, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button updateButton = view.findViewById(R.id.updateButton);
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = getView();
                assert view != null;
                MainActivity.hideKeyboard(getContext(), getView());
                EditText oldEmailEditText = view.findViewById(R.id.oldEmailEditTextUpdate);
                EditText emailEditText = view.findViewById(R.id.emailEditTextUpdate);
                EditText nameEditText = getView().findViewById(R.id.nameEditTextUpdate);
                String email = emailEditText.getText().toString();
                String name = nameEditText.getText().toString();
                name += " NA";
                String firstName = Arrays.asList(name.split(" ")).get(0);
                String lastName = Arrays.asList(name.split(" ")).get(1);
                clearFields(view);
                fragmentEventListener.onUserUpdated(oldEmailEditText.getText().toString(), new User(email, firstName, lastName));
            }
        });
    }

    private void clearFields(View view) {
        ((EditText) view.findViewById(R.id.oldEmailEditTextUpdate)).setText("");
        ((EditText) view.findViewById(R.id.emailEditTextUpdate)).setText("");
        ((EditText) view.findViewById(R.id.nameEditTextUpdate)).setText("");
    }
}
