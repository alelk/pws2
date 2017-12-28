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

package com.alelk.pws.database.repository;

import android.arch.lifecycle.LiveData;

import com.alelk.pws.database.dao.PsalmDao;
import com.alelk.pws.database.model.Psalm;

import java.util.concurrent.Executor;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Psalm Repository
 *
 * Created by Alex Elkin on 03.10.2017.
 */

@Singleton
public class PsalmRepository {

    private PsalmDao psalmDao;
    private Executor executor;

    @Inject
    public PsalmRepository(PsalmDao psalmDao, Executor executor) {
        this.psalmDao = psalmDao;
        this.executor = executor;
    }

    public LiveData<Psalm> getPsalm(int id) {
        return psalmDao.load(id);
    }

    public void savePsalm(Psalm psalm) {
        psalmDao.save(psalm);
    }
}
