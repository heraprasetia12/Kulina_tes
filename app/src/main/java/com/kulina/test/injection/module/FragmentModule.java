package com.kulina.test.injection.module;

import android.support.v4.app.Fragment;

import dagger.Module;
import dagger.Provides;

@Module
public class FragmentModule {

    private Fragment fragment;

    public FragmentModule(Fragment fragment) {
        fragment = fragment;
    }

    @Provides
    Fragment provideFragment() {
        return fragment;
    }
}
