package com.example.workmanagerbug;

import android.support.annotation.NonNull;
import android.util.Log;

import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.Worker;

public class Reporter extends Worker {
    private final String TAG = "WORKMANAGER_BUG";

    public static void schedule(){
        OneTimeWorkRequest request = new OneTimeWorkRequest.Builder(Reporter.class)
                .build();

        WorkManager.getInstance().synchronous().enqueueSync(request);
    }

    @NonNull
    @Override
    public Result doWork() {
        Log.i(TAG, "doWork: start");

        // long running task
        try{
            Thread.sleep(20000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        Log.i(TAG, "doWork: end");
        return Result.SUCCESS;
    }
}
