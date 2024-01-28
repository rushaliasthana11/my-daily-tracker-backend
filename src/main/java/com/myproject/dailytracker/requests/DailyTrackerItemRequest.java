package com.myproject.dailytracker.requests;

import com.myproject.dailytracker.enums.Category;
import com.myproject.dailytracker.enums.TimeOfDay;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DailyTrackerItemRequest implements Serializable {
    private String itemName;
    private List<TimeOfDay> timeOfDay;
    private Integer priority;
    private Category category;
}
