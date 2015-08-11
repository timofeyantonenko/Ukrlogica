package com.ukrlogic.android.ukrlogica;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageButton;

/**
 * Created by root on 06.08.15.
 */
public class SliderFragment extends Fragment implements View.OnClickListener {
    Context context;
    // счетчик для отображения текущего слайда
    int current_slide = 0;

    //кнопки для навигации
    ImageButton back, forward, home;

    // массив строк - ссылок на нужные слайды
    String[] slides;
    // webview в котором будут отображаться слайды
    WebView webview;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        context = this.getActivity();
        //определим лайаут для фрагмента
        View v = inflater.inflate(R.layout.fragment_slider,null);

        //определим какие слайды будем показывать
        slides = getArguments().getStringArray("key");

        //настроим кнопки
        back = (ImageButton)v.findViewById(R.id.back);
        back.setOnClickListener(this);
        forward = (ImageButton)v.findViewById(R.id.forward);
        forward.setOnClickListener(this);
        home = (ImageButton)v.findViewById(R.id.home);
        home.setOnClickListener(this);


        //настроим webview
        webview=(WebView)v.findViewById(R.id.web);
        webview.setPadding(0, 0, 0, 0);
        webview.setInitialScale(100);
        webview.getSettings().setLoadWithOverviewMode(true);
        webview.getSettings().setUseWideViewPort(true);
        webview.setOnTouchListener(new OnSwipeTouchListener(this.getActivity()) {
            public void onSwipeTop() {
                //up();
            }

            public void onSwipeRight() {
                right();
            }

            public void onSwipeLeft() {
                left();
            }

            public void onSwipeBottom() {
            }
        });
        // чтобы webview поддерживала js
        webview.getSettings().setJavaScriptEnabled(true);
        //сначала поставим главный слайд
        webview.loadUrl(slides[current_slide]);
        return v;
    }
    //свайп влево
    public void left(){
        //смещаем указатель на слеудющий элемент
        current_slide++;
        //проверяем, не вышли ли мы за границы, и делаем соответствующие действия
        if(current_slide>=slides.length)
            home();
        else {
            webview.getSettings().setJavaScriptEnabled(true);
            webview.loadUrl(slides[current_slide]);
        }
    }
    //свайп вправо
    public void right(){
        //смещаем указатель на предыдущий элемент
        current_slide--;
        //проверяем, не вышли ли мы за границы, и делаем соответствующие действи
        if(current_slide<0)
            home();
        else {
            webview.getSettings().setJavaScriptEnabled(true);
            webview.loadUrl(slides[current_slide]);
        }
    }
    public void home(){
        Log.d("home", "go home");
        getActivity().getSupportFragmentManager().popBackStack();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.home:
                home();
                break;
            case R.id.forward:
                left();
                break;
            case R.id.back:
                right();
                break;
        }
    }


}
