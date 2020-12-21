package com.example.pelayananonlinesumedang.Rest;

import com.example.pelayananonlinesumedang.Model.GetJenisPelayanan;
import com.example.pelayananonlinesumedang.Model.PostBookingPelayanan;
import com.example.pelayananonlinesumedang.Model.PostRiwayatBooking;

import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiInterface {
    @GET("jenis_pelayanan")
    Call<GetJenisPelayanan> getJenisPelayanan(@Header("Authorization") String Auth);
    @FormUrlEncoded
    @POST("booking_pelayanan")
    Call<PostBookingPelayanan> postData(@Field("nama") String nama,
                                        @Field("nik") String nik,
                                        @Field("id_pelayanan") int id_pelayanan,
                                        @Field("tgl_booking") Date tgl_booking);
    @POST("riwayat_booking")
    Call<PostRiwayatBooking> postRiwayatBooking(@Field("nama") String nama,
                                                @Field("nik") String nik);

}
