package com.google.firebase.codelab.friendlychat.mvvm.ui.chat;

import android.app.Activity;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.preference.PreferenceManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.firebase.codelab.friendlychat.R;
import com.google.firebase.codelab.friendlychat.databinding.ActivityMainBinding;
import com.google.firebase.codelab.friendlychat.mvvm.config.CodelabPreferences;
import com.google.firebase.codelab.friendlychat.mvvm.model.FriendlyMessage;

/**
 * Created by haith on 26/06/2016.
 */
public interface ChatViewHolder {

     void send(FriendlyMessage message);

     boolean isSendButtonEnabled(CharSequence charSequence);

     int getLengthFilter(String key, int defValue);
}
