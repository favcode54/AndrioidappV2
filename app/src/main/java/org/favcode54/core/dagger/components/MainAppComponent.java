package org.favcode54.core.dagger.components;

import org.favcode54.core.dagger.modules.network.RetrofitModule;
import org.favcode54.core.dagger.modules.store.DatabaseModule;
import org.favcode54.core.dagger.scopes.MainAppScope;

import dagger.Component;

@MainAppScope
@Component(modules = {RetrofitModule.class, DatabaseModule.class})
public interface MainAppComponent {
}
