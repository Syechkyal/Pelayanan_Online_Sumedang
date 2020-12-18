package com.example.pelayananonlinesumedang.Model;

import com.google.gson.annotations.SerializedName;

public class PostBookingPelayanan {
    @SerializedName("status")
    String status;
    @SerializedName("message")
    String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
