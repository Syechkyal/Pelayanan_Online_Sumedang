package com.example.pelayananonlinesumedang.ui.Pendaftaran;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.pelayananonlinesumedang.Model.GetJenisPelayanan;
import com.example.pelayananonlinesumedang.Model.ItemJenisLayanan;
import com.example.pelayananonlinesumedang.R;
import com.example.pelayananonlinesumedang.Rest.ApiInterface;
import com.example.pelayananonlinesumedang.Rest.UtilsApi;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PendaftaranFragment extends Fragment {
    @BindView(R.id.list_form_pelayanan)
    Spinner spinner;
    Context context;
    ApiInterface apiInterface;
    EditText edt_nama;
    EditText edt_nik;
    EditText tgl_booking;
    Button btn_daftar;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_pendaftaran, container, false);
        ButterKnife.bind(getActivity());
        context = getActivity();
        apiInterface = UtilsApi.getAPIService();
        edt_nama = root.findViewById(R.id.edt_nama);
        edt_nik = root.findViewById(R.id.edt_nik);
        tgl_booking = root.findViewById(R.id.edt_tanggal);

        btn_daftar = root.findViewById(R.id.button_submit);

        btn_daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edt_nama.getText().toString().length() == 0) {
                    edt_nama.setError("Masukan Nama Dengan Benar");
                }if(edt_nik.getText().toString().length() == 0){
                    edt_nik.setError("Masukan NIK Dengan Benar");
                }if (tgl_booking.getText().toString().length() == 0){
                    tgl_booking.setError("Masukan Tanggal Dengan Benar");
                }else{
                    Toast.makeText(getActivity(), "Registrasi Berhasil!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        initSpinnerJenisLayanan();
        getActivity().setTitle("Pendaftaran Layanan");
        return root;
    }
    void initSpinnerJenisLayanan(){
        apiInterface.getJenisPelayanan().enqueue(new Callback<GetJenisPelayanan>() {
            @Override
            public void onResponse(Call<GetJenisPelayanan> call, Response<GetJenisPelayanan> response) {
                if (response.isSuccessful()) {
                    List<ItemJenisLayanan> itemJenisLayanans = response.body().getListJenisPelayanan();
                    List<String> listSpinner = new ArrayList<String>();
                    for (int i = 0; i < itemJenisLayanans.size(); i++){
                        listSpinner.add(itemJenisLayanans.get(i).getNm_pelayanan());
                    }
                    // Set hasil result json ke dalam adapter spinner
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(context,
                            android.R.layout.simple_spinner_item, listSpinner);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);
                } else {
                    Toast.makeText(context, "Gagal mengambil data dosen", Toast.LENGTH_SHORT).show();
                }
            }

            public void onFailure(Call<GetJenisPelayanan> call, Throwable t) {

            }
        });
    }
}