package com.alelk.pws.pwapp.di;

import com.alelk.pws.pwapp.activity.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * MainActivityModule
 *
 * Created by Alex Elkin on 12.10.2017.
 */

@Module
public abstract class MainActivityModule {

    @ContributesAndroidInjector
    abstract MainActivity contributeMainActivity();
}
