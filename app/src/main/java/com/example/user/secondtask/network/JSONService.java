package com.example.user.secondtask.network;

import com.example.user.secondtask.entity.Technology;

import java.util.ArrayList;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface JSONService {
    @GET("src/data/techs.ruleset.json")
    Single<ArrayList<Technology>> getTechnologies();
}
