package org.favcode54;

import android.app.Activity;
import android.app.Application;

import org.favcode54.core.dagger.components.DaggerMainAppComponent;
import org.favcode54.core.dagger.components.MainAppComponent;
import org.favcode54.core.dagger.modules.external.ContextModule;

public class MainApplication extends Application {

    private MainAppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerMainAppComponent.builder()
                .contextModule(new ContextModule(this))
                .build();
    }

    public MainApplication get(Activity activity){
        return (MainApplication) activity.getApplication();
    }

    public MainAppComponent getComponent(){
        return component;
    }

    /**
     * This method will come in handy later on
     */
    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }


}
