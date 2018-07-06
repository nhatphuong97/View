 package com.example.nhatphuong.threadandhandler;

 import android.os.Bundle;
 import android.os.Handler;
 import android.os.Message;
 import android.support.v7.app.AppCompatActivity;
 import android.view.View;
 import android.widget.Button;
 import android.widget.TextView;

 public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView mText;
    public static final int MESSAGE_COUNT = 10001;
    Button mButton;
    Handler mHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitView();
        Handlermessage();
    }

     private void Handlermessage() {
        mHandler=  new Handler(){
            @Override
            public void handleMessage(Message msg) {
           switch (msg.what){
               case MESSAGE_COUNT:
                   mText.setText(String.valueOf(msg.arg1));
                   break;

           }
            }
        };
     }

     public void InitView(){
        mText = findViewById(R.id.text_count);
        mButton = findViewById(R.id.button_count);
        mButton.setOnClickListener(this);
    }

     @Override
     public void onClick(View v) {
         switch (v.getId()){
             case R.id.button_count:
              doCountdown();

                 break;
             default:
                 break;
         }
     }

     private void doCountdown() {
         Thread  thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int Time;
                for(Time=10;Time>0;Time--){


                Message message = new Message();
                message.what = MESSAGE_COUNT;
                message.arg1= Time;
                mHandler.sendMessage(message);
                    try {
                        Thread.sleep(1000);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }


        });
        thread.start();
     }
 }
