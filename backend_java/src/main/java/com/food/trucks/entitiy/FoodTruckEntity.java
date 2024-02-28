package com.food.trucks.entitiy;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.qdrant.client.grpc.JsonWithInt;
import lombok.Data;
import lombok.SneakyThrows;
import lombok.extern.jackson.Jacksonized;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

import java.util.HashMap;
import java.util.Map;

import static io.qdrant.client.ValueFactory.value;


//和easy excel 不能一起加 不然会出现数据遗漏的问题
//@NoArgsConstructor
//@AllArgsConstructor
@Data
@Document(indexName = "foodTrucks", createIndex = true)
@Setting(shards = 1, replicas = 1, refreshInterval = "1ms")
@Jacksonized
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FoodTruckEntity {

    public final static String IK_MAX_WORD = "ik_max_word";
    // redis计算出的距离 暂存变量
    @ExcelIgnore()
    @Field(type = FieldType.Text, analyzer = IK_MAX_WORD)

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private Double distanceRedis;

    // 位置编号
    @Id
    @ExcelProperty(value = "locationid")
    private String locationid;

    // 申请人
    @ExcelProperty(value = "Applicant")
//    @Field(type = FieldType.Keyword,index = false) Applicant 不被分词,不创建索引
//    @Field(type = FieldType.Text, analyzer = IK_MAX_WORD) Applicant 被分词,创建索引,分词为ik
//    @Field(type = FieldType.Long, index = false ) Applicant 不被分词,不创建索引
    //  FieldType.Keyword 表示不被分词 text类型才能被分词
    @Field(type = FieldType.Text, analyzer = IK_MAX_WORD)
    private String Applicant;

    // 设施类型
    @ExcelProperty(value = "FacilityType")
    @Field(type = FieldType.Text, analyzer = IK_MAX_WORD)

    private String FacilityType;

    // CNN编号
    @ExcelProperty(value = "cnn")
    @Field(type = FieldType.Text, analyzer = IK_MAX_WORD)
    private String cnn;

    // 位置描述
    @Field(type = FieldType.Text, analyzer = IK_MAX_WORD)
    @ExcelProperty(value = "LocationDescription")
    private String LocationDescription;


    // 地址
    @ExcelProperty(value = "Address")
    @Field(type = FieldType.Text, analyzer = IK_MAX_WORD)

    private String Address;


    // 地块编号
    @Field(type = FieldType.Text, analyzer = IK_MAX_WORD)

    @ExcelProperty(value = "blocklot")
    private String blocklot;
    // 街区
    @Field(type = FieldType.Text, analyzer = IK_MAX_WORD)

    @ExcelProperty(value = "block")
    private String block;
    // 地块
    @Field(type = FieldType.Text, analyzer = IK_MAX_WORD)

    @ExcelProperty(value = "lot")
    private String lot;
    // 许可证
    @Field(type = FieldType.Text, analyzer = IK_MAX_WORD)

    @ExcelProperty(value = "permit")
    private String permit;
    // 状态
    @ExcelProperty(value = "Status")
    @Field(type = FieldType.Text, analyzer = IK_MAX_WORD)

    private String Status;
    // 食品项目
    @ExcelProperty(value = "FoodItems")
    @Field(type = FieldType.Text, analyzer = IK_MAX_WORD)

    private String FoodItems;
    // X坐标
    @ExcelProperty(value = "x", index = 12)
    @Field(type = FieldType.Text, analyzer = IK_MAX_WORD)
    private String x;
    // Y坐标
    @ExcelProperty(value = "y", index = 13)
    @Field(type = FieldType.Text, analyzer = IK_MAX_WORD)
    private String y;
    // 纬度
    @ExcelProperty(value = "Latitude")
    @Field(type = FieldType.Text, analyzer = IK_MAX_WORD)
    private Double Latitude;
    // 经度
    @ExcelProperty(value = "Longitude")
    @Field(type = FieldType.Text, analyzer = IK_MAX_WORD)
    private Double Longitude;

    // 时间表
    @ExcelProperty(value = "Schedule")
    @Field(type = FieldType.Text, analyzer = IK_MAX_WORD)

    private String Schedule;
    // 天小时
    @ExcelProperty(value = "dayshours")
    @Field(type = FieldType.Text, analyzer = IK_MAX_WORD)

    private String dayshours;
    // 发送噪音通知
    @ExcelProperty(value = "NOISent")
    @Field(type = FieldType.Text, analyzer = IK_MAX_WORD)

    private String NOISent;
    // 已批准
    @ExcelProperty(value = "Approved")
    @Field(type = FieldType.Text, analyzer = IK_MAX_WORD)

    private String Approved;
    // 已接收
    @ExcelProperty(value = "Received")
    @Field(type = FieldType.Text, analyzer = IK_MAX_WORD)

    private Integer Received;
    // 原许可证
    @ExcelProperty(value = "PriorPermit")
    @Field(type = FieldType.Text, analyzer = IK_MAX_WORD)

    private Integer PriorPermit;
    // 许可证到期日
    @ExcelProperty(value = "ExpirationDate")
    @Field(type = FieldType.Text, analyzer = IK_MAX_WORD)

    private String ExpirationDate;

    // 消防预防区域
    @ExcelProperty(value = "Fire Prevention Districts")
    @Field(type = FieldType.Text, analyzer = IK_MAX_WORD)

    private String FirePreventionDistricts;
    // 警察区域
    @ExcelProperty(value = "Police Districts")
    @Field(type = FieldType.Text, analyzer = IK_MAX_WORD)

    private String PoliceDistricts;
    // 监督区域
    @ExcelProperty(value = "Supervisor Districts")
    @Field(type = FieldType.Text, analyzer = IK_MAX_WORD)

    private String SupervisorDistricts;
    // 邮政编码
    @ExcelProperty(value = "Zip Codes")
    @Field(type = FieldType.Text, analyzer = IK_MAX_WORD)

    private String ZipCodes;
    // 旧邻里 (已过时)
    @ExcelProperty(value = "Neighborhoods (old)")
    @Field(type = FieldType.Text, analyzer = IK_MAX_WORD)

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    private String NeighborhoodsOld;







    public Map<String, JsonWithInt.Value> getMap(){
        var m = convertToMap(this);
        Map<String, JsonWithInt.Value> locationMap = new HashMap<>();
        locationMap.put("lat",value(this.getLatitude()));
        locationMap.put("lon",value(this.getLongitude()));
//        m.put("location",Map.of("lat", value(1), "lon",value(2)));
        return locationMap;
    }


    @SneakyThrows
    public static Map<String, JsonWithInt.Value> convertToMap(Object object) {
        Class<?> clazz = object.getClass();
        java.lang.reflect.Field[] fields = clazz.getDeclaredFields();

        Map<String, JsonWithInt.Value> valueMap = new HashMap<>();
        try {
            for (java.lang.reflect.Field field : fields) {
                field.setAccessible(true);
                valueMap.put(field.getName(),
                        value((String) field.get(object))
                );
            }
            return valueMap;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

}


