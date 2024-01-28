package com.myproject.dailytracker.repositories;

import com.myproject.dailytracker.entity.DailyTrackerItems;
import com.myproject.dailytracker.enums.Category;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DailyTrackerItemsRepository extends MongoRepository<DailyTrackerItems, String> {
     DailyTrackerItems findByItemNameAndCategory(String itemName, Category category);

     @DeleteQuery
     Long deleteByItemNameAndCategory(String itemName, Category category);
}
