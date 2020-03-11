package plugin.android.ss.com.performancedetectorblock;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import master.com.performancedetect.R;

public class MainActivity extends AppCompatActivity {
    private int TEST_MESSAGE = 0;
    private Handler mainHandler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if(msg.what == TEST_MESSAGE){
                mainHandler.sendEmptyMessageDelayed(TEST_MESSAGE, 100);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView btn  = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainHandler.sendEmptyMessageDelayed(TEST_MESSAGE, 100);


//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

//                mainHandler.post(new Runnable() {
//                    @Override
//                    public void run() {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
//                    }
//                });
            }
        });
    }
}
