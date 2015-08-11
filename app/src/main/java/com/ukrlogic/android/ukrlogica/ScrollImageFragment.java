package com.ukrlogic.android.ukrlogica;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ScrollView;

import com.squareup.picasso.Picasso;

/**
 * Created by root on 08.08.15.
 */
public class ScrollImageFragment extends Fragment {
    ScrollView scrollView;
    ImageView imageView;
    int nHeight, nWidth, scrHeight, scrWidth;
    String resImage;
    Context context;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_scroll_image, null);
        context = this.getActivity();
        WindowManager wm = (WindowManager)this.getActivity().getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        resImage = getArguments().getString("scrollImage");
        scrWidth = display.getWidth();
        scrHeight = display.getHeight();
        scrollView = (ScrollView)v.findViewById(R.id.scroll);
        imageView = (ImageView)v.findViewById(R.id.image_long);
        readImage();

        return v;
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                         int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }

    public static int calculateInSampleSize(BitmapFactory.Options options,
                                            int reqWidth, int reqHeight) {
        // Реальные размеры изображения
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Вычисляем наибольший inSampleSize, который будет кратным двум
            // и оставит полученные размеры больше, чем требуемые
            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
    private void readImage() {
        int px = getResources().getDimensionPixelSize(R.dimen.image_size);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.drawable.longer, options);

        int height = options.outHeight;
        int width = options.outWidth;
        nWidth = scrWidth;
        nHeight = (nWidth/ width) * height;
        Picasso.with(this.getActivity()).load(getResourceId(resImage, "drawable", context.getPackageName())).resize(width, nHeight).into(imageView);
    }
    public int getResourceId(String pVariableName, String pResourcename, String pPackageName)
    {
        try {
            return getResources().getIdentifier(pVariableName, pResourcename, pPackageName);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
