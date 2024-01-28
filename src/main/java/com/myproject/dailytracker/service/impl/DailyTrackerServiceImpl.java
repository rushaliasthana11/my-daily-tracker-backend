package com.myproject.dailytracker.service.impl;

import com.myproject.dailytracker.entity.DailyTrackerItems;
import com.myproject.dailytracker.enums.Category;
import com.myproject.dailytracker.enums.TimeOfDay;
import com.myproject.dailytracker.repositories.DailyTrackerItemsRepository;
import com.myproject.dailytracker.requests.DailyTrackerItemRequest;
import com.myproject.dailytracker.response.AddItemInitialLoadResponse;
import com.myproject.dailytracker.response.ErrorResponse;
import com.myproject.dailytracker.response.SuccessResponse;
import com.myproject.dailytracker.service.DailyTrackerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class DailyTrackerServiceImpl implements DailyTrackerService {

    @Autowired
    private DailyTrackerItemsRepository dailyTrackerItemsRepository;

    public ResponseEntity addOrUpdateDailyTrackerItem(DailyTrackerItemRequest dailyTrackerItemRequest) {
        try {
        DailyTrackerItems dailyTrackerItems = dailyTrackerItemsRepository.findByItemNameAndCategory(dailyTrackerItemRequest.getItemName(), dailyTrackerItemRequest.getCategory());
        if(Objects.isNull(dailyTrackerItems)) {
            dailyTrackerItems = new DailyTrackerItems();
            dailyTrackerItems.setCreatedAt(new Date());
        }
        dailyTrackerItems.setItemName(dailyTrackerItemRequest.getItemName());
        dailyTrackerItems.setPriority(dailyTrackerItemRequest.getPriority());
        dailyTrackerItems.setTimeOfTheDay(dailyTrackerItemRequest.getTimeOfDay());
        dailyTrackerItems.setCategory(dailyTrackerItemRequest.getCategory());
        dailyTrackerItems.setUpdatedAt(new Date());
        dailyTrackerItemsRepository.save(dailyTrackerItems);
            SuccessResponse successResponse = new SuccessResponse(true, HttpStatus.CREATED.name(), "Successfully Created the item!");
            return new ResponseEntity(successResponse, HttpStatus.OK);
        } catch (Exception e) {
            ErrorResponse errorResponse = new ErrorResponse(false, HttpStatus.INTERNAL_SERVER_ERROR.name(), e.getMessage());
            return new ResponseEntity(errorResponse, HttpStatus.OK);
        }
    }

    public void deleteDailyTrackerItem(DailyTrackerItemRequest dailyTrackerItemRequest) {
        dailyTrackerItemsRepository.deleteByItemNameAndCategory(dailyTrackerItemRequest.getItemName(), dailyTrackerItemRequest.getCategory());
    }

    public AddItemInitialLoadResponse getAddItemOnLoadData() {
      List<Category> categories = Arrays.asList(Category.values());
      List<TimeOfDay> timeOfDays = Arrays.asList(TimeOfDay.values());
      return new AddItemInitialLoadResponse(categories, timeOfDays);
    }

}
