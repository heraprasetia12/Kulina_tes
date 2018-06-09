package com.kulina.test.injection.component;

import android.app.Application;
import android.content.Context;

import com.kulina.test.data.DataManager;
import com.kulina.test.data.SyncService;
import com.kulina.test.data.local.DatabaseHelper;
import com.kulina.test.data.local.PreferencesHelper;
import com.kulina.test.data.remote.RibotsService;
import com.kulina.test.injection.ApplicationContext;
import com.kulina.test.injection.module.ApplicationModule;
import com.kulina.test.util.RxEventBus;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(SyncService syncService);

    @ApplicationContext
    Context context();
    Application application();
    RibotsService ribotsService();
    PreferencesHelper preferencesHelper();
    DatabaseHelper databaseHelper();
    DataManager dataManager();
    RxEventBus eventBus();

}
