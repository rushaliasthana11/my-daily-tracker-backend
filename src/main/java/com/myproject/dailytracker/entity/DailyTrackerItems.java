package com.myproject.dailytracker.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.myproject.dailytracker.enums.Category;
import com.myproject.dailytracker.enums.TimeOfDay;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@Document("daily-tracker-items")
public class DailyTrackerItems {

    @Id
    private String id;

    @Field("item_name")
    private String itemName;

    @Field("priority")
    private Integer priority;

    @Field("time_of_day")
    private List<TimeOfDay> timeOfTheDay;

    @Field("category")
    private Category category;

    @Field("created_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdAt;

    @Field("updated_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatedAt;


}
