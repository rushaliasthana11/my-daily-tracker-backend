package com.myproject.dailytracker.response;

import com.myproject.dailytracker.enums.Category;
import com.myproject.dailytracker.enums.TimeOfDay;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AddItemInitialLoadResponse {
    List<Category> categories;
    List<TimeOfDay> timeOfDays;
}
