package com.google.firebase.codelab.friendlychat.mvvm.ui.chat;

import android.app.Activity;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.preference.PreferenceManager;

import com.google.firebase.codelab.friendlychat.databinding.ActivityMainBinding;
import com.google.firebase.codelab.friendlychat.mvvm.config.CodelabPreferences;
import com.google.firebase.codelab.friendlychat.mvvm.model.FriendlyMessage;
import com.google.firebase.codelab.friendlychat.mvvm.ui.base.BaseViewModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by henrytao on 6/19/16.
 */
public class ChatViewModel  extends BaseViewModel implements ChatViewHolder {

    private SharedPreferences mSharedPreferences;

    public ChatViewModel(Activity activity, int layoutId) {
        ActivityMainBinding mBinding = DataBindingUtil.setContentView(activity, layoutId);
        mBinding.setViewModel(this);
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity);
    }

    @Override
    public void send(FriendlyMessage message) {
        DatabaseReference mFirebaseDatabaseReference = FirebaseDatabase.getInstance().getReference();
        mFirebaseDatabaseReference.child(CodelabPreferences.MESSAGES_CHILD).push().setValue(message);
    }

    @Override
    public boolean isSendButtonEnabled(CharSequence charSequence) {
        return charSequence.toString().trim().length() > 0;
    }

    @Override
    public int getLengthFilter(String key, int defValue) {
        return mSharedPreferences.getInt(key, defValue);
    }
}

