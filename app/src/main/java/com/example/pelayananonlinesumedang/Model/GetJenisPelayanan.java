package com.example.pelayananonlinesumedang.Model;

import android.widget.ListView;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;

public class GetJenisPelayanan {
    @SerializedName("code")
    String code;
    @SerializedName("response")
    List<ItemJenisLayanan> listJenisPelayanan;
    @SerializedName("message")
    String message;

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public List<ItemJenisLayanan> getListJenisPelayanan(){
        return listJenisPelayanan;
    }
    public void setListJenisPelayanan(List<ItemJenisLayanan> listJenisPelayanan){
        this.listJenisPelayanan = listJenisPelayanan;
    }

    @Override
    public String toString() {
        return "GetJenisPelayanan{" +
                "code='" + code + '\'' +
                ", listJenisPelayanan=" + listJenisPelayanan +
                ", message='" + message + '\'' +
                '}';
    }
}
