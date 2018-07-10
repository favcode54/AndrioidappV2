package org.favcode54.core.store;

import javax.inject.Inject;

public class DataStore {

    private OnlineStore onlineStore;
    private OfflineStore offlineStore;

    @Inject
    public DataStore(OnlineStore onlineStore, OfflineStore offlineStore){
        this.onlineStore = onlineStore;
        this.offlineStore = offlineStore;
    }

}
