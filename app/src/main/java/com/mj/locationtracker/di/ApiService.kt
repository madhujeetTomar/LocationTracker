package com.mj.locationtracker.di

import retrofit2.Call
import retrofit2.http.*

interface ApiService {


    @GET("add_user.php")
    fun signUp(
        @Query("name")name: String,
        @Query("email") email: String,
        @Query("mobile")mobileNumber: String,
        @Query("password") password: String
    ): Call<String>


/*
    @GET("rest/default/V1/customers/alert")
    fun getNotifyCity(
        @Header("Authorization") autorizedToken: String?, @Query(
            "device_token"
        ) deviceToken: String?
    ): Call<List<NotifyCityModel>>*/

   /* @POST("rest/default/V1/customers/alert")
    fun updateCity(@Header("Authorization") autorizedToken: String?,
                   @Body alertDataBean: CityUpdateModel?): Call<SharedResponse?>?
*/

/*
    @GET("rest/default/V1/listproducts")
    fun getAllDealData(
        @Query("category_id") allDealCategoryid: String, @Query(
            "searchCriteria[sort_key]"
        ) sortKey: String, @Query("deal_category") dealCategory: String, @Query(
            "price"
        ) price: String, @Query("searchCriteria[currentPage]") currentPage: String, @Query(
            "searchCriteria[pageSize]"
        ) pageSize: String, @Query("app_city_id") cityId: String?, @Query(
            "searchCriteria[deal_type]"
        ) s: String, @Query("versionNumber") versionCode: Int
    ): Call<ProductList>
*/

}