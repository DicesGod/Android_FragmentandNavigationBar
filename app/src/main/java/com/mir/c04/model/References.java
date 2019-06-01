package com.mir.c04.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.mir.c04.MainActivity;
import com.mir.c04.R;

public class References {
    static String email = "";
    static String name = "";
    static int count = 0;

    public References(String email, String name,int count) {
        this.email = email;
        this.name = name;
        this.count = count;
    }

    static public void savedReferences(View v) {
        View view = v.findViewById(R.id.)
        EditText emailEditText = v.findViewById(R.id.emailEditText);
        EditText nameEditText = v.findViewById(R.id.nameEditText);
        email = emailEditText.toString().toString();
        name = nameEditText.getText().toString();

        /// Saving to shared preferences
        Context context = v.getContext();
        SharedPreferences preferences = ((MainActivity) context).getPreferences(Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(email, name);
        editor.putInt(email,count);
        editor.apply();
    }

    static public int loadReferences(View v){
        Context context = v.getContext();
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getString(R.string.preference_file_key), Context.MODE_PRIVATE);
//        this.email = sharedPreferences.getString(email, "Not found!");
        name = sharedPreferences.getString(email, "Not found!");
        count = sharedPreferences.getInt(email,0);
        Toast.makeText(context,name+" "+count,Toast.LENGTH_LONG).show();
        if (name == "Not found!"){
            return 0;
        }
        else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return "Email: "+email+" Name: "+name+" count: "+count;
    }
}
