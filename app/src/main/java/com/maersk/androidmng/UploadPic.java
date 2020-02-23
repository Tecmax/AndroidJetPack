package com.maersk.androidmng;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class UploadPic  extends Worker {

    
    public UploadPic(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    /*WorkManager is intended for tasks that are deferrable—that is, not required to
    run immediately—and required to run reliably even if the app exits or the device restarts. For example:

    Sending logs or analytics to backend services
    Periodically syncing application data with a server*/

    @NonNull
    @Override
    public Result doWork() {
        uploadImages();
        return Result.failure();
    }

    private void uploadImages() {


    }
}
