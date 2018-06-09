package com.kulina.test.ui.main.step;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;

import com.kulina.test.R;
import com.kulina.test.ui.main.step.MainFragment;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.adapter.AbstractFragmentStepAdapter;
import com.stepstone.stepper.viewmodel.StepViewModel;

public class MainAdapter extends AbstractFragmentStepAdapter {

    public MainAdapter(FragmentManager fm, Context context) {
        super(fm, context);
    }

    @Override
    public Step createStep(int position) {
        MainFragment mainFragment = new MainFragment();
        Bundle b = new Bundle();
        b.putInt("0", position);
        mainFragment.setArguments(b);
        return mainFragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @NonNull
    @Override
    public StepViewModel getViewModel(@IntRange(from = 0) int position) {

        StepViewModel.Builder builder = new StepViewModel.Builder(context);

        switch(position){
            case 0:
                builder
                        .setTitle(R.string.tab_title_1);
                break;
            case 1:
                builder
                        .setTitle(R.string.tab_title_2);
                break;
            case 2:
                builder
                        .setTitle(R.string.tab_title_3);
                break;
            default:
                throw new IllegalArgumentException("Unsupported position: " + position);
        }

        return builder.create();
    }
}
