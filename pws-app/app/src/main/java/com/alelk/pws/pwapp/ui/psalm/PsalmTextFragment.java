package com.alelk.pws.pwapp.ui.psalm;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alelk.pws.R;
import com.alelk.pws.database.model.Psalm;
import com.alelk.pws.databinding.FragmentPsalmTextBinding;

/**
 * Psalm Text Fragment
 *
 * Created by Alex Elkin on 12.10.2017.
 */

public class PsalmTextFragment extends Fragment {


    FragmentPsalmTextBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_psalm_text, container, false);
        Psalm psalm = new Psalm(123, null, null, null, null, null, null, null, null, "Psalm1\nExample", null);
        binding.setPsalm(psalm);
        return binding.getRoot();
    }
}
