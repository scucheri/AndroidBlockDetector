package plugin.android.ss.com.performancedetectorblock;

import android.os.Looper;
import android.util.Log;
import android.util.Printer;


public class PerformanceManager {
    private static final String TAG = "PerformanceManager Main Looper Message : ";
    private static final String FLAG_METHOD_START = ">>>>> Dispatching to";
    private static final String FLAG_METHOD_END = "<<<<< Finished to";


    public static void startMonitor(boolean open) {
        if (!open) {
            return;
        }
        Looper.getMainLooper().setMessageLogging(new Printer() {
            @Override
            public void println(String x) {
                Log.i(TAG, x);
                try {
                    if (x.contains(FLAG_METHOD_START)) {
                        PerformanceMonitor.getInstance().onMethodStart();
                    } else if (x.contains(FLAG_METHOD_END)) {
                        PerformanceMonitor.getInstance().onMethodEnd();
                    }
                }catch (Exception e){

                }
            }
        });
    }
}
