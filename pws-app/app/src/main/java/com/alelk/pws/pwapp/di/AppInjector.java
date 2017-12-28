/*
 * Copyright (C) 2017 The P&W Songs Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.alelk.pws.pwapp.di;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.alelk.pws.pwapp.PwsApp;
import com.alelk.pws.pwapp.activity.MainActivity;

import dagger.android.AndroidInjection;
import dagger.android.HasActivityInjector;
import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * App Injector automatically injects {@link Injectable} activities or fragments
 *
 * Created by Alex Elkin on 10.10.2017.
 */
public class AppInjector {

    private AppInjector(){}

    public static void init(PwsApp pwsApp) {
        DaggerAppComponent.builder().application(pwsApp).build().inject(pwsApp);
        pwsApp.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                if (activity.getClass().isAnnotationPresent(Injectable.class))
                    AndroidInjection.inject(activity);
                if (activity instanceof FragmentActivity)
                    ((FragmentActivity) activity).getSupportFragmentManager()
                            .registerFragmentLifecycleCallbacks(
                                    new FragmentManager.FragmentLifecycleCallbacks() {
                                        @Override
                                        public void onFragmentCreated(FragmentManager fm, Fragment f, Bundle savedInstanceState) {
                                            if (f.getClass().isAnnotationPresent(Injectable.class))
                                                AndroidSupportInjection.inject(f);
                                            super.onFragmentCreated(fm, f, savedInstanceState);
                                        }
                                    },
                                    true
                            );
            }
            @Override public void onActivityStarted(Activity activity) {}
            @Override public void onActivityResumed(Activity activity) {}
            @Override public void onActivityPaused(Activity activity) {}
            @Override public void onActivityStopped(Activity activity) {}
            @Override public void onActivitySaveInstanceState(Activity activity, Bundle outState) {}
            @Override public void onActivityDestroyed(Activity activity) {}
        });
    }
}
