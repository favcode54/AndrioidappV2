package org.favcode54.core.store;

import org.favcode54.core.api.services.AuthenticationService;

import javax.inject.Inject;

import retrofit2.Retrofit;

public class OnlineStore {

    private AuthenticationService authService;

    @Inject
    public OnlineStore(Retrofit retrofit){
        authService = retrofit.create(AuthenticationService.class);
    }

}
