package org.favcode54.core.dagger.modules.network;

import org.favcode54.BuildConfig;
import org.favcode54.core.dagger.scopes.MainAppScope;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.schedulers.Schedulers;

@Module(includes = {OkhttpClientModule.class})
public class RetrofitModule {

    /**
     * Provides Retrofit, a high level abstraction, for making network calls
     * @param client
     * @param converterFactory
     * @param callAdapterFactory
     * @return
     */
    @MainAppScope
    @Provides
    public Retrofit provideRetrofit(OkHttpClient client,
                                    GsonConverterFactory converterFactory, RxJavaCallAdapterFactory callAdapterFactory){
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.client(client);
        builder.addCallAdapterFactory(callAdapterFactory);
        builder.addConverterFactory(converterFactory);
        builder.baseUrl(BuildConfig.BASE_URL);

        return builder.build();
    }

    /**
     * Provides GsonConverterFactory for mapping JSON response(s)
     * to POJO
     * @return
     */
    @MainAppScope
    @Provides
    public GsonConverterFactory provideGsonConverterFactory(){
        return GsonConverterFactory.create();
    }

    /**
     * Provides RxJavaCallAdapterFactory that makes network calls directly on
     * the Schedulers.io thread
     * @return
     */
    @MainAppScope
    @Provides
    public RxJavaCallAdapterFactory provideRxJavaCallAdapterFactory(){
        return RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io());
    }

}
