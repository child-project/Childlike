package com.example.childlike.retrofit;

import com.example.childlike.retrofit.retrofitdata.RequestAppuserPost;
import com.example.childlike.retrofit.retrofitdata.RequestChildrenGet;
import com.example.childlike.retrofit.retrofitdata.RequestChildrenPost;
import com.example.childlike.retrofit.retrofitdata.RequestCommentsGet;
import com.example.childlike.retrofit.retrofitdata.RequestResultGet;
import com.example.childlike.retrofit.retrofitdata.RequestResultPost;


import java.util.ArrayList;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface IRetrofitApi {

    @POST("api/appuser/")
    Call<RequestAppuserPost> postAppuser(
            @Body RequestAppuserPost appuser
    );

    @DELETE("api/appuser/{uid}")
    Call<ResponseBody> deleteAppuser(
            @Path("uid") String uid
    );

    @Multipart
    @POST("image/userimage/")
    Call<RequestBody> uploadFile(
            @Part MultipartBody.Part file
    );

    @Multipart
    @POST("image/userprofile/")
    Call<RequestBody> uploadProfile(
            @Part MultipartBody.Part file
    );

    @POST("api/children/")
    Call<RequestChildrenPost> postChildren(
            @Body RequestChildrenPost children
    );

    @GET("api/children/{uid}")
    Call<ArrayList<RequestChildrenGet>> getChildren(
            @Path("uid") String userId
    );

    @GET("api/result/{uid}/{name}")
    Call<ArrayList<RequestResultGet>> getResult(
            @Path("uid") String uid,
            @Path("name") String name
    );

    @POST("api/result/")
    Call<RequestResultPost> postResult(
            @Body RequestResultPost result
    );

    @GET("api/comments/{itype}")
    Call<RequestCommentsGet> getComment(
            @Path("itype") String itype
    );
}
