package service.song.com.serviceexcise;

import android.os.Binder;

public class MyBinder extends Binder {
    public void startDownload() {
        Utils.log("MyBinder", "startDownload");
        new Thread() {
            @Override
            public void run() {
                // 执行具体耗时任务
                super.run();
            }
        }.start();
    }
}
