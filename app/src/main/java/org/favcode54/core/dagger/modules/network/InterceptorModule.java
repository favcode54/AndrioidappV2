package org.favcode54.core.dagger.modules.network;

import org.favcode54.core.dagger.scopes.MainAppScope;

import java.io.IOException;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import timber.log.Timber;

@Module
public class InterceptorModule {

    @MainAppScope
    @Provides
    public HttpLoggingInterceptor provideHttpLoggingInterceptor(){
        return new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                // TODO: 6/22/18 Modify for custom logs
                Timber.d(message);
            }
        });
    }

    // TODO: 6/22/18 Modify to use custom interceptor
    @MainAppScope
    @Provides
    public Interceptor provideInterceptor(){
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                return null;
            }
        };
    }

}
