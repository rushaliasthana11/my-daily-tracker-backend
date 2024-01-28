package com.myproject.dailytracker.service;

import com.myproject.dailytracker.enums.Category;
import com.myproject.dailytracker.enums.TimeOfDay;
import com.myproject.dailytracker.requests.DailyTrackerItemRequest;
import com.myproject.dailytracker.response.AddItemInitialLoadResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DailyTrackerService {
    ResponseEntity addOrUpdateDailyTrackerItem(DailyTrackerItemRequest dailyTrackerItemRequest);
    void deleteDailyTrackerItem(DailyTrackerItemRequest dailyTrackerItemRequest);
    AddItemInitialLoadResponse getAddItemOnLoadData();
}
