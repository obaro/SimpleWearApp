package com.sample.foo.secondwear;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.DelayedConfirmationView;
import android.support.wearable.view.WatchViewStub;
import android.view.View;
import android.widget.Button;

public class WearActivity extends Activity {

    private Button button;
    private DelayedConfirmationView delayedView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wear);
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                button = (Button) stub.findViewById(R.id.button);
                delayedView = (DelayedConfirmationView) stub.findViewById(R.id.delayedView);
                delayedView.setTotalTimeMs(3000);
                showOnlyButton();
            }
        });
    }

    public void beginCountdown(View view) {
        button.setVisibility(View.GONE);
        delayedView.setVisibility(View.VISIBLE);
        delayedView.setListener(new DelayedConfirmationView.DelayedConfirmationListener() {
            @Override
            public void onTimerFinished(View view) {
                showOnlyButton();
            }

            @Override
            public void onTimerSelected(View view) {
            }
        });
        delayedView.start();
    }

    public void showOnlyButton() {
        button.setVisibility(View.VISIBLE);
        delayedView.setVisibility(View.GONE);
    }
}
