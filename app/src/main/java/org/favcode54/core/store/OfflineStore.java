package org.favcode54.core.store;

import org.favcode54.core.database.databases.MainAppDatabase;

import javax.inject.Inject;

public class OfflineStore {

    private MainAppDatabase database;

    @Inject
    public OfflineStore(MainAppDatabase database){
        this.database = database;
    }

}
