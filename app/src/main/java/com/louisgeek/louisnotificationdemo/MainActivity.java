package com.louisgeek.louisnotificationdemo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * 基于4.x以上的Notification。  折叠式Notification，和同时5.0以上的Notification新增了悬挂式通知见 http://blog.csdn.net/itachi85/article/details/50096609
 */
public class MainActivity extends AppCompatActivity {

    private NotificationManager notificationManager;
    private Notification notification;

    private static final int NOTIFYID_1 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button idbtn2 = (Button) findViewById(R.id.id_btn2);
        Button idbtn = (Button) findViewById(R.id.id_btn);
        idbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNotification();
            }
        });

        idbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notificationManager.cancel(NOTIFYID_1);
            }
        });


    }

    private void showNotification() {
        //定义一个PendingIntent点击Notification后启动一个Activity
        Intent intent = new Intent(this, NextActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        //创建大图标的Bitmap
        Bitmap largeBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);

        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        Notification.Builder mBuilder = new Notification.Builder(this);
        mBuilder.setAutoCancel(false);
        mBuilder.setContentTitle("BIAO TI");
        mBuilder.setContentText("NEI RONG");
        mBuilder.setTicker("收到通知时在顶部显示的文字信息");//设置收到通知时在顶部显示的文字信息
        mBuilder.setSmallIcon(R.mipmap.ic_launcher);

        // mBuilder.setSubText("——记住我叫叶良辰")                    //内容下面的一小段文字
        mBuilder.setWhen(System.currentTimeMillis())           //设置通知时间
                .setLargeIcon(largeBitmap)                     //设置大图标
                .setDefaults(Notification.DEFAULT_LIGHTS | Notification.DEFAULT_VIBRATE)    //设置默认的三色灯与振动器
                        //.setSound(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.biaobiao))  //设置自定义的提示音
                .setAutoCancel(true)                           //设置点击后取消Notification
                .setContentIntent(pendingIntent);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            notification = mBuilder.build();
        }else{
            Toast.makeText(MainActivity.this, "Build.VERSION.SDK_INT <=Build.VERSION_CODES.JELLY_BEAN", Toast.LENGTH_SHORT).show();
        }
        notificationManager.notify(NOTIFYID_1, notification);
    }


}
