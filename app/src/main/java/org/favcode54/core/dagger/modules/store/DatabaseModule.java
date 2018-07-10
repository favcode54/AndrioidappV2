package org.favcode54.core.dagger.modules.store;

import android.arch.persistence.room.Room;
import android.content.Context;

import org.favcode54.core.dagger.modules.external.ContextModule;
import org.favcode54.core.dagger.scopes.MainAppScope;
import org.favcode54.core.database.databases.MainAppDatabase;

import dagger.Module;
import dagger.Provides;

@Module(includes = {ContextModule.class})
public class DatabaseModule {

    @MainAppScope
    @Provides
    public MainAppDatabase provideMainAppDatabase(Context context){
        return Room.databaseBuilder(context, MainAppDatabase.class, "FavCode54_db")
                .allowMainThreadQueries()
                .build();
    }

}
