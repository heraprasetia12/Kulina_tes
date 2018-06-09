package com.kulina.test.injection.component;

import com.kulina.test.injection.PerActivity;
import com.kulina.test.injection.module.ActivityModule;
import com.kulina.test.ui.main.MainActivity;

import dagger.Subcomponent;

/**
 * This component inject dependencies to all Activities across the application
 */
@PerActivity
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {
    void inject (MainActivity mainActivity);
}
