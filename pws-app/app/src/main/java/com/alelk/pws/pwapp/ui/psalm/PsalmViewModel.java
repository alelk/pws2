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

package com.alelk.pws.pwapp.ui.psalm;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;

import com.alelk.pws.database.model.Psalm;
import com.alelk.pws.database.repository.PsalmRepository;
import com.alelk.pws.pwapp.util.NullLiveData;

import javax.inject.Inject;

/**
 * Psalm View Model
 *
 * Created by Alex Elkin on 03.10.2017.
 */

public class PsalmViewModel extends ViewModel {

    private final MutableLiveData<Integer> psalmId = new MutableLiveData<>();
    private LiveData<Psalm> psalm;
    private PsalmRepository psalmRepository;

    @Inject
    public PsalmViewModel(PsalmRepository psalmRepository) {
        psalm = Transformations.switchMap(psalmId, input -> {
            if (input == null) return NullLiveData.create();
            return psalmRepository.getPsalm(input);
        });
        this.psalmRepository = psalmRepository;
    }

    public void setPsalmId(Integer psalmId) {
        if (this.psalmId.getValue() == null || !this.psalmId.getValue().equals(psalmId))
            this.psalmId.setValue(psalmId);
    }

    public void savePsalm(Psalm psalm) {
        psalmRepository.savePsalm(psalm);
    }

    public LiveData<Psalm> getPsalm() {
        return psalm;
    }
}
