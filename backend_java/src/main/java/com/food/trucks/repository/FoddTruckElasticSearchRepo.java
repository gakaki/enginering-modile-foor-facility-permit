package com.food.trucks.repository;

import com.food.trucks.config.MyConfigProperties;
import com.food.trucks.constrants.DatabaseName;
import com.food.trucks.entitiy.FoodTruckEntity;
import com.food.trucks.service.QdrantConnectionService;
import io.qdrant.client.grpc.Points;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static com.food.trucks.entitiy.FoodTruckEntity.convertToMap;
import static io.qdrant.client.PointIdFactory.id;
import static io.qdrant.client.ValueFactory.value;
import static io.qdrant.client.VectorsFactory.vectors;

import io.qdrant.client.grpc.Points.PointStruct;

import java.util.List;
import java.util.stream.Collectors;

import static io.qdrant.client.ConditionFactory.geoRadius;

@Repository
public class FoddTruckElasticSearchRepo {

    @Autowired
    private QdrantConnectionService qdrantConnectionService;
    @Autowired
    private MyConfigProperties myConfigProperties;

    @SneakyThrows
    public void addAll(List<FoodTruckEntity> items) {

        List<PointStruct> points = items.stream().map(item -> {

            return PointStruct.newBuilder()
                    .setId(id(Long.parseLong(item.getLocationid())))
                    .setVectors(vectors(0.19f, 0.81f, 0.75f, 0.11f))
                    .putAllPayload(item.getMap())
                    .build();
        }).collect(Collectors.toList());

        qdrantConnectionService.getClient()
                .upsertAsync(DatabaseName.COLL_NAME_FOOD_TRUCKS, points)
                .get();
    }

    public void getRadius() {
        Points.Condition condition = geoRadius("location",
                52.520711, 13.403683, 1000.0f);


    }
}