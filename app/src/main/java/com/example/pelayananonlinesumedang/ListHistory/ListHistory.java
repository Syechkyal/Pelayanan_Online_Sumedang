package com.example.pelayananonlinesumedang.ListHistory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.pelayananonlinesumedang.Adapter.ListViewAdapterHistory;
import com.example.pelayananonlinesumedang.R;

public class ListHistory extends AppCompatActivity {
    ListViewAdapterHistory listViewAdapterHistory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_history);

        listViewAdapterHistory = new ListViewAdapterHistory();
        RecyclerView recyclerView = findViewById(R.id.rvDataHistory);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getBaseContext()));


    }
}