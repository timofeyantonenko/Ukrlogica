package com.ukrlogic.android.ukrlogica;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gc.materialdesign.views.ButtonRectangle;

/**
 * Created by root on 04.08.15.
 */
public class PresentationFragment extends Fragment implements View.OnClickListener {

    ButtonRectangle mobile, design, marketing;
    //для работы с фрагментами
    FragmentTransaction fTrans;
    SliderFragment sliderFragment;
    Bundle args;
    String[] ar = new String[] {"go","go"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_presentation_menu, null);

        mobile = (ButtonRectangle)v.findViewById(R.id.mobile);
        design = (ButtonRectangle)v.findViewById(R.id.design);
        marketing = (ButtonRectangle)v.findViewById(R.id.marketing);
        mobile.setOnClickListener(this);
        design.setOnClickListener(this);
        marketing.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.mobile:
                startSlider(ar);
                break;
            case R.id.design:
                startSlider(ar);
                break;
            case R.id.marketing:
                startSlider(ar);
                break;
        }
    }

    private void startSlider(String[] links){
        sliderFragment = new SliderFragment();
        args = new Bundle();
        args.putStringArray("key", links);
        args.putString("slide", "nauka/acecor/");
        sliderFragment.setArguments(args);
        fTrans = getActivity().getSupportFragmentManager().beginTransaction();
        fTrans.replace(R.id.content_frame, sliderFragment);
        fTrans.addToBackStack(null);
        fTrans.commit();
    }
}
