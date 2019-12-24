package com.mahmoud.dahdouh.eduapp.Fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.mahmoud.dahdouh.eduapp.R;

public class DialogAddNew extends DialogFragment {


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.layout_add_new, null);
        AlertDialog alertDialog = new AlertDialog.Builder(getContext())
                .setView(v)
                .create();
        alertDialog.show();
        return alertDialog;
    }
}
