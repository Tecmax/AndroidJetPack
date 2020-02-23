package com.maersk.androidmng.ui;

import android.os.AsyncTask;

public class PicAsyncTask extends AsyncTask<String, Void, String> {
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected String doInBackground(String... strings) {
        return null;
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }
}
