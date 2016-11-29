package service.song.com.serviceexcise;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class MyService extends Service {
    @Override
    public void onCreate() {
        super.onCreate();
        Utils.log("MyService", "onCreate");
        Notification notification = new Notification(R.mipmap.ic_launcher, getText(R.string.app_name),
                System.currentTimeMillis());
        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);
//        notification.setLatestEventInfo(this, "这是通知的标题", "这是通知的内容", pendingIntent);
        startForeground(1001, notification);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        Utils.log("MyService", "onStart");
        super.onStart(intent, startId);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread() {
            @Override
            public void run() {
                // 执行具体耗时任务
                super.run();
            }
        }.start();
        Utils.log("MyService", "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Utils.log("MyService", "onBind");
        MyBinder binder = new MyBinder();
        return binder;
    }

    @Override
    public void onRebind(Intent intent) {
        Utils.log("MyService", "onRebind");
        super.onRebind(intent);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Utils.log("MyService", "onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onTaskRemoved(Intent rootIntent) {
        Utils.log("MyService", "onTaskRemoved");
        super.onTaskRemoved(rootIntent);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Utils.log("MyService", "onConfigurationChanged");
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onLowMemory() {
        Utils.log("MyService", "onLowMemory");
        super.onLowMemory();
    }

    @Override
    public void onTrimMemory(int level) {
        Utils.log("MyService", "onTrimMemory");
        super.onTrimMemory(level);
    }

    @Override
    public void onDestroy() {
        Utils.log("MyService", "onDestroy");
        super.onDestroy();
    }
}
