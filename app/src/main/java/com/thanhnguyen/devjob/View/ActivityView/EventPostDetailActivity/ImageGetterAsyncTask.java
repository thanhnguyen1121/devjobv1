package com.thanhnguyen.devjob.View.ActivityView.EventPostDetailActivity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LevelListDrawable;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ImageGetterAsyncTask extends AsyncTask<TextView, Void, Bitmap> {


    private LevelListDrawable levelListDrawable;
    private Context context;
    private String source;
    private TextView t;

    public ImageGetterAsyncTask(Context context, String source, LevelListDrawable levelListDrawable) {
        this.context = context;
        this.source = source;
        this.levelListDrawable = levelListDrawable;
    }

    @Override
    protected Bitmap doInBackground(TextView... params) {
        t = params[0];
        try {
            Point size = new Point();
            ((Activity) context).getWindowManager().getDefaultDisplay().getSize(size);
            return Picasso.get().load(source).resize(1000, 600).get();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    protected void onPostExecute(final Bitmap bitmap) {
        try {
            Drawable d = new BitmapDrawable(context.getResources(), bitmap);
            Point size = new Point();
            ((Activity) context).getWindowManager().getDefaultDisplay().getSize(size);
            int multiplier = (size.x / (bitmap.getWidth()));
            levelListDrawable.addLevel(1, 1, d);
            levelListDrawable.setBounds(0, 0, bitmap.getWidth() * multiplier,
                    bitmap.getHeight() * multiplier );
            levelListDrawable.setLevel(1);
            t.setText(t.getText()); // invalidate() doesn't work correctly...
    } catch (Exception e) { /* Like a null bitmap, etc. */ }
    }
}