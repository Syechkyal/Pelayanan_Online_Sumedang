package com.example.pelayananonlinesumedang.ui.Pendaftaran;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.example.pelayananonlinesumedang.Model.GetJenisPelayanan;
import com.example.pelayananonlinesumedang.Model.ItemJenisLayanan;
import com.example.pelayananonlinesumedang.R;
import com.example.pelayananonlinesumedang.Rest.ApiClient;
import com.example.pelayananonlinesumedang.Rest.ApiInterface;
import com.example.pelayananonlinesumedang.Rest.UtilsApi;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PendaftaranFragment extends Fragment {
    Spinner spinner;
    Context context;
    ApiInterface apiInterface;
    EditText edt_nama;
    EditText edt_nik;
    Button btn_daftar;
    EditText Tx_tanggal_booking;
    DatePickerDialog datePickerDialog;
    SimpleDateFormat dateFormatter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_pendaftaran, container, false);



        edt_nama = root.findViewById(R.id.edt_nama);
        edt_nik = root.findViewById(R.id.edt_nik);

        Tx_tanggal_booking = root.findViewById(R.id.txTanggal);
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
        Tx_tanggal_booking.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                showDateDialog();
            }
        });
        btn_daftar = root.findViewById(R.id.button_submit);
        spinner = root.findViewById(R.id.list_form_pelayanan);
        ButterKnife.bind(getActivity());
        context = getActivity();
        apiInterface = UtilsApi.getAPIService();
        apiInterface = ApiClient.getClient(UtilsApi.BASE_URL_API).create(ApiInterface.class);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedName = adapterView.getItemAtPosition(i).toString();
//                requestDetailDosen(selectedName);
                Toast.makeText(getActivity(), "Kamu memilih Pelayanan " + selectedName, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        initSpinnerJenisLayanan();
        btn_daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edt_nama.getText().toString().length() == 0) {
                    edt_nama.setError("Masukan Nama Dengan Benar");
                }if(edt_nik.getText().toString().length() == 0){
                    edt_nik.setError("Masukan NIK Dengan Benar");
                }if (Tx_tanggal_booking.getText().toString().length() == 0){
                    Tx_tanggal_booking.setError("Masukan Tanggal Dengan Benar");
                }else{

                    Toast.makeText(getActivity(), "Registrasi Berhasil!", Toast.LENGTH_SHORT).show();
                }
            }
        });


        getActivity().setTitle("Pendaftaran Layanan");
        return root;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    void showDateDialog(){
        Calendar calendar = Calendar.getInstance();

        datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, month, dayOfMonth);
                Tx_tanggal_booking.setText(dateFormatter.format (newDate.getTime()));
            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
        }

    void initSpinnerJenisLayanan(){
        apiInterface.getJenisPelayanan("Basic bW9iaWxlOjFudDNuNS4yMDIw").enqueue(new Callback<GetJenisPelayanan>() {
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
                Log.e("Fail",t.getLocalizedMessage());
            }
        });
    }
}