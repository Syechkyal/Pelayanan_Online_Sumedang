package com.example.pelayananonlinesumedang.Model;

import com.google.gson.annotations.SerializedName;

public class ItemJenisLayanan {
    @SerializedName("nm_pelayanan")
    private String nm_pelayanan;

    @SerializedName("id")
    private String id;
    @SerializedName("ektp")
    private String ektp;

    public String getNm_pelayanan() {
        return nm_pelayanan;
    }

    public void setNm_pelayanan(String nm_pelayanan) {
        this.nm_pelayanan = nm_pelayanan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEktp() {
        return ektp;
    }

    public void setEktp(String ektp) {
        this.ektp = ektp;
    }

    public String toString(){
        return
                "SemuadosenItem{" +
                        "id = '" + id + '\'' +
                        ",nm_pelayanan = '" + nm_pelayanan + '\'' +
                        ",matkul = '" + ektp + '\'' +
                        "}";
    }
}
