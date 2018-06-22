package org.favcode54.core.dagger.modules.external;

import android.content.Context;

import org.favcode54.core.dagger.scopes.MainAppScope;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {

    private Context context;

    public ContextModule(Context context){
        this.context = context;
    }

    @MainAppScope
    @Provides
    public Context provideContext(){
        return context;
    }

}
