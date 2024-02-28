package com.food.trucks.service;

import com.food.trucks.config.MyConfigProperties;
import io.qdrant.client.QdrantClient;
import io.qdrant.client.QdrantGrpcClient;
import io.qdrant.client.grpc.Collections;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.food.trucks.constrants.DatabaseName.COLL_NAME_FOOD_TRUCKS;

@Getter
@Component
@Slf4j
public class QdrantConnectionService {

    private QdrantClient client = null;

    @Autowired
    MyConfigProperties myConfigProperties;
    public QdrantConnectionService() {
        try {
            this.client = new QdrantClient(
                    QdrantGrpcClient.newBuilder(myConfigProperties.getAddress(), myConfigProperties.getPort_qdrant(),
                            false).build());
            this.client.createCollectionAsync(COLL_NAME_FOOD_TRUCKS,
                    Collections.VectorParams.newBuilder()
                            .setDistance(Collections.Distance.Dot).setSize(4).build()).get();

        } catch (Exception ignored) {
            log.error("connect qdrant is error");
        }
    }


}
