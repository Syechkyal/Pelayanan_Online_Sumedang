package com.example.pelayananonlinesumedang.ui.History;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.pelayananonlinesumedang.Adapter.ListViewAdapterHistory;
import com.example.pelayananonlinesumedang.R;

public class HistoryFragment extends Fragment {
    EditText edt_cari_nama, edt_cari_nik;
    Button btn_cari_data;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_history, container, false);
        edt_cari_nama = root.findViewById(R.id.edt_cari_nama);
        edt_cari_nik = root.findViewById(R.id.edt_cari_nik);
        btn_cari_data = root.findViewById(R.id.button_cari);



        btn_cari_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edt_cari_nama.getText().toString().length() == 0){
                    edt_cari_nama.setError("Masukan Nama Dengan Benar");
                }if (edt_cari_nik.getText().toString().length() == 0){
                    edt_cari_nik.setError("Masukan Nik Dengan Benar");
                }else{
                    Toast.makeText(getActivity(), "Masuk Ke Pencarian", Toast.LENGTH_SHORT).show();
                }
            }
        });
        getActivity().setTitle("History Pendaftaran");
        return root;
    }
}