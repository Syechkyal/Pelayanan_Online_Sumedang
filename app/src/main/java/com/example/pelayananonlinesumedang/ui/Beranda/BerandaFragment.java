package com.example.pelayananonlinesumedang.ui.Beranda;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.pelayananonlinesumedang.R;
import com.example.pelayananonlinesumedang.ui.History.HistoryFragment;
import com.example.pelayananonlinesumedang.ui.Pendaftaran.PendaftaranFragment;

public class BerandaFragment extends Fragment {

    CardView cardView_pendaftaran,cardView_history;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_beranda, container, false);
        cardView_pendaftaran = root.findViewById(R.id.card_view_pendaftaran_pelayanan);
        cardView_history = root.findViewById(R.id.card_view_histori_pelayanan);

        cardView_pendaftaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PendaftaranFragment pendaftaranFragment = new PendaftaranFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.mainFrame,pendaftaranFragment,"findthisFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });
        cardView_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getActivity()
                        .getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.mainFrame, new HistoryFragment());
                fragmentTransaction.commit();
            }
        });
        getActivity().setTitle("Beranda");
        return root;
    }
}