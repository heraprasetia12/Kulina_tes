package com.kulina.test.injection.component;

import com.kulina.test.injection.PerFragment;
import com.kulina.test.injection.module.FragmentModule;
import com.kulina.test.ui.main.step.MainFragment;

import dagger.Subcomponent;

@PerFragment
@Subcomponent(modules = FragmentModule.class)
public interface FragmentComponent extends ActivityComponent {

    void inject(MainFragment mainFragment);

}