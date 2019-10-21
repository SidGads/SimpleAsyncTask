package com.example.simpleasynctask;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.view.View;
import android.widget.TextView;

import com.android.volley.toolbox.Volley;

import java.lang.ref.WeakReference;
import java.util.Random;

public class SimpleAsyncTask extends AsyncTask<Void, Void, String> {
    private WeakReference<TextView> mTextView;


    SimpleAsyncTask(TextView tv) {
        mTextView = new WeakReference<>(tv);
    }

    public void startTask(View view) {
    }



    @SuppressLint("WrongThread")
    @Override
    protected String doInBackground(Void... voids) {
        Random r = new Random();
        int n = r.nextInt(11);

        int s = n * 200;




        try {
            Thread.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }




        return "Awake at last after sleeping for " + s + " milliseconds!";
    }



        protected void onPostExecute(String result) {
            mTextView.get().setText(result);
        }
    }

