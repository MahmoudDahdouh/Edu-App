package com.mahmoud.dahdouh.eduapp.Fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.mahmoud.dahdouh.eduapp.Model.Notification;
import com.mahmoud.dahdouh.eduapp.R;

import static com.mahmoud.dahdouh.eduapp.R.layout.dialog_notification;

public class DialogNotification extends DialogFragment {
    // on mask as read click
    OnMaskAsReadClickListener mListerner;
    private View layout;
    private TextView name, title, content, time;
    private Notification tempNotification;
    private Button btn_mask_as_read;
    private int position;
    private AlertDialog dialog;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        tempNotification = new Notification(getArguments().getString("name"),
                getArguments().getString("title"),
                getArguments().getString("time"),
                getArguments().getString("content")
        );
        position = getArguments().getInt("position");
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        setLayout();


        dialog = new AlertDialog
                .Builder(getContext())
                .setView(layout)
                .create();
        return dialog;
    }

    public void setOnMaskAsRead(OnMaskAsReadClickListener mListerner) {
        this.mListerner = mListerner;
    }

    // inflate the layout in dialog
    private void setLayout() {

        inflate();

        btn_mask_as_read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListerner != null) {
                    mListerner.maskAsReadClick(position);
                }
                dialog.dismiss();
            }
        });


    }

    private void inflate() {
        layout = getActivity().getLayoutInflater().inflate(dialog_notification, null);


        name = layout.findViewById(R.id.dialog_notification_name);
        title = layout.findViewById(R.id.dialog_notification_title);
        content = layout.findViewById(R.id.dialog_notification_content);
        time = layout.findViewById(R.id.dialog_notification_time);
        btn_mask_as_read = layout.findViewById(R.id.dialog_notification_mask_as_read);

        name.setText(tempNotification.getSchoolName());
        title.setText(tempNotification.getNotificationTitle());
        content.setText(tempNotification.getNotificationDescription());
        time.setText(tempNotification.getNotificationTime());
    }


    interface OnMaskAsReadClickListener {
        void maskAsReadClick(int position);
    }
}
