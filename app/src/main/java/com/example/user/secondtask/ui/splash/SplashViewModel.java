package com.example.user.secondtask.ui.splash;

import android.annotation.SuppressLint;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.example.user.secondtask.entity.Technology;
import com.example.user.secondtask.network.JSONService;
import com.example.user.secondtask.network.NetModule;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

//Класс отвечающий за загрузку данных в фоновом режиме, элемент архитектуры мввм
public class SplashViewModel extends ViewModel {

    public MutableLiveData<ArrayList<Technology>> technologies = new MutableLiveData<>();

    //getTechnologies - метод интерфейса жесон сервис, реализация посредством объекта ретрофит. добавила интерфейс в create - могу использовать запросы
    @SuppressLint("CheckResult")
    public void getData(){
        NetModule.getRetrofit().create(JSONService.class)
                .getTechnologies()
                .subscribeOn(Schedulers.io()) // подписываем Schedulers на происходящее при загрузке
                .observeOn(AndroidSchedulers.mainThread()) // устанавливаем объект, который будет наблюдать за происходящим - главный поток
                .subscribe(technologies -> {
                    this.technologies.postValue(technologies); // отправка ответа от сервера в MutableLiveData
                }, error -> {
                    Log.e("Network", error.getMessage());
                });
    }
}
