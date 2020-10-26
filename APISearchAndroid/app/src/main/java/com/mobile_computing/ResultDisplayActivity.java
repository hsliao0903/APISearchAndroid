package com.mobile_computing;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.ArrayList;

public class ResultDisplayActivity extends AppCompatActivity {

    private static String LOG_TAG = "Result Display";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_display);

        //for back button
        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ImageLoader imgLoad;
        //get intent from clicking datum
        Intent intent = getIntent();
        ArrayList<String> result_list = intent.getStringArrayListExtra(API_Search.RESULT_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView titleView = (TextView) findViewById(R.id.result_title);
        titleView.setText(result_list.get(0));
        TextView dateView = (TextView) findViewById(R.id.result_date);
        dateView.setText(result_list.get(1));
        TextView textView = (TextView) findViewById(R.id.result_text);
        textView.setText(result_list.get(3));
        imgLoad = VolleySingleton.getInstance(this).getImageLoader();
        NetworkImageView imgView = (NetworkImageView) findViewById(R.id.result_img);
        String imageUrl = result_list.get(2);
        //Change http: to https:
        if(result_list.get(2).regionMatches(0, "http:", 0,5))
            imageUrl = result_list.get(2).replaceFirst("http:","https:");
        //Log.i(LOG_TAG, "imageUrl= " + imageUrl);
        imgView.setImageUrl(imageUrl, imgLoad);

    }

    //for back arrow button
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}