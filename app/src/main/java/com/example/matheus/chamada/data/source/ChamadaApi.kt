package com.example.matheus.chamada.data.source

import com.example.matheus.chamada.data.model.service.login.LoginRequest
import com.example.matheus.chamada.data.model.service.login.LoginResponse
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface ChamadaApi {

    @POST("5b9d5a283200006000db93a8")
    fun login(@Body loginRequest: LoginRequest): Single<LoginResponse>
//
//    @POST("5b9daccc3200006c00db93e0")
//    abstract fun findLesson(@Body lessonRequest: LessonRequest): Call<LessonResponse>
//
//    @POST("asd")
//    abstract fun call(@Body callRequest: CallRequest): Call<Void>
}