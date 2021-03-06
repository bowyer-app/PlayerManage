package com.bowyer.app.playermanage;

import android.app.Application;
import android.content.Context;

import com.bowyer.app.playermanage.logic.GrowthbeatLogic;

public class PlayerApplication extends Application {
    private PlayerAppComponent playerAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        playerAppComponent = DaggerPlayerAppComponent.builder()
                .playerModule(new PlayerModule(this)).build();
        GrowthbeatLogic.init(this);
    }

    public static PlayerAppComponent getComponent(Context context) {
        return ((PlayerApplication) context.getApplicationContext()).playerAppComponent;
    }
}
