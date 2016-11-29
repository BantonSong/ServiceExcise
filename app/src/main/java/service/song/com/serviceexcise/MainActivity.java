package service.song.com.serviceexcise;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Id(R.id.startService)
    private Button startService;
    @Id(R.id.stopService)
    private Button stopService;
    @Id(R.id.bindService)
    private Button bindService;
    @Id(R.id.unBindService)
    private Button unBindService;

    private ServiceConnection connection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View root = getLayoutInflater().inflate(R.layout.activity_main, null);
        setContentView(root);
        FindViewsUtils.findAllViews(this, root);
        startService.setOnClickListener(this);
        stopService.setOnClickListener(this);
        bindService.setOnClickListener(this);
        unBindService.setOnClickListener(this);
        connection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                Utils.log("ServiceConnection", "onServiceConnected");
                ((MyBinder) iBinder).startDownload();
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {
                Utils.log("ServiceConnection", "onServiceDisconnected");
            }
        };
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            // 启动服务
            case R.id.startService:
                Intent intentStart = new Intent(this, MyService.class);
                startService(intentStart);
                break;
            // 停止服务
            case R.id.stopService:
                Intent intentStop = new Intent(this, MyService.class);
                stopService(intentStop);
                break;
            case R.id.bindService:
                Intent intentBind = new Intent(this, MyService.class);
                bindService(intentBind, connection, BIND_AUTO_CREATE);
                break;
            case R.id.unBindService:
                unbindService(connection);
                break;
        }
    }
}
