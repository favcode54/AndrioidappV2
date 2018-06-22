package org.favcode54.core.dagger.modules.network;

import android.content.Context;

import org.favcode54.core.dagger.modules.external.ContextModule;
import org.favcode54.core.dagger.scopes.MainAppScope;

import java.io.File;
import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Module for providing dependencies relating to OkhttpClient
 */

@Module(includes = {ContextModule.class, InterceptorModule.class})
public class OkhttpClientModule {

    /**
     * Provides the OkhttpClient for injection into Retrofit
     * @param loggingInterceptor
     * @return
     */
    @MainAppScope
    @Provides
    public OkHttpClient provideOkhttpClient(HttpLoggingInterceptor loggingInterceptor){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        //Set connection timeouts
        builder.readTimeout(1, TimeUnit.MINUTES);
        builder.writeTimeout(1, TimeUnit.MINUTES);
        builder.connectTimeout(1, TimeUnit.MINUTES);
        builder.retryOnConnectionFailure(true);
        //Add interceptors
        builder.addNetworkInterceptor(loggingInterceptor);

        return builder.build();
    }

    /**
     * Provides the cache for injection into OkhttpClient
     * @param file the location of the cached response
     * @return
     */
    @MainAppScope
    @Provides
    public Cache provideCache(File file){
        //10 MiB for cache size
        int cacheFileSize = 10 * 1024 * 1024;
        return new Cache(file, cacheFileSize);
    }

    /**
     * Provide the file for caching response
     * @param context Application context for accessing cacheDir
     * @return
     */
    @MainAppScope
    @Provides
    public File provideFile(Context context){
        return new File(context.getCacheDir(), "FavCode54_cache");
    }

}
