package com.example.pelayananonlinesumedang.ui.Pendaftaran;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.pelayananonlinesumedang.R;

public class PendaftaranFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_pendaftaran, container, false);
        getActivity().setTitle("Pendaftaran Layanan");
        return root;
    }
}