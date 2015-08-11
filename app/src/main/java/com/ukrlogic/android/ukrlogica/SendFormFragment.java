package com.ukrlogic.android.ukrlogica;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.gc.materialdesign.views.ButtonRectangle;

/**
 * Created by root on 10.08.15.
 */
public class SendFormFragment extends Fragment {
    private EditText comment, name, mail, phoneNumber;
    private ButtonRectangle sendButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.send_form_fragment, null);

        comment = (EditText)v.findViewById(R.id.feedback);
        name = (EditText)v.findViewById(R.id.inputname);
        mail = (EditText)v.findViewById(R.id.inputemail);
        phoneNumber = (EditText)v.findViewById(R.id.inputphone);
        sendButton = (ButtonRectangle)v.findViewById(R.id.sendbtn);

        return v;
    }
}
