package com.myproject.dailytracker.controller;


import com.myproject.dailytracker.enums.Category;
import com.myproject.dailytracker.enums.TimeOfDay;
import com.myproject.dailytracker.requests.DailyTrackerItemRequest;
import com.myproject.dailytracker.response.AddItemInitialLoadResponse;
import com.myproject.dailytracker.service.DailyTrackerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/daily-tracker")
@Slf4j
public class DailyTrackerController {

    @Autowired
    private DailyTrackerService dailyTrackerService;

    @PostMapping("/addUpdateItem")
    public ResponseEntity addDailyTrackerItem(@RequestBody DailyTrackerItemRequest dailyTrackerItemRequest) {
        log.info("[addDailyTrackerItem] dailyTrackerItemRequest:" +  dailyTrackerItemRequest);
        return dailyTrackerService.addOrUpdateDailyTrackerItem(dailyTrackerItemRequest);
    }

    @PostMapping("/deleteItem")
    public void deleteDailyTrackerItem(@RequestBody DailyTrackerItemRequest dailyTrackerItemRequest) {
        log.info("[deleteDailyTrackerItem] dailyTrackerItemRequest:" + dailyTrackerItemRequest);
        dailyTrackerService.deleteDailyTrackerItem(dailyTrackerItemRequest);
    }

    @GetMapping("/getAddItemOnLoadData")
    public AddItemInitialLoadResponse getAllItemCategories() {
        return dailyTrackerService.getAddItemOnLoadData();
    }

}
