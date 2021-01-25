package com.example.newpizzaapp.services;

import com.example.newpizzaapp.model.Food;
import com.example.newpizzaapp.model.FoodCategory;
import com.example.newpizzaapp.repository.FoodCategoryRepository;
import com.example.newpizzaapp.repository.FoodRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DefaultFoodServiceImpl implements FoodService {

    Logger log = LoggerFactory.getLogger(DefaultFoodServiceImpl.class);

    private final FoodRepository foodRepository;

    public DefaultFoodServiceImpl(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @Override
    public void addFood(Food food) {
        foodRepository.save(food);
    }

    @Override
    public List<Food> getAllFood() {
        return foodRepository.findAll();
    }

    @Override
    public List<Food> getAllFromCategory(String categoryName) {
        return foodRepository.findAllByFoodCategoryCategoryName(categoryName);
    }

    @Override
    public Food getFoodById(Long id) {
        return foodRepository.findById(id).get();
    }

    @Override
    @Transactional
    public void updateFoodName(long id, String name) {
        Food tmpFood = foodRepository.findById(id).get();
        if (!(tmpFood.getFoodName().equals(name))) {
            foodRepository.updateFoodNameById(id, name);
            log.info("Zaktualizowano nazwe: " + name + " dla id: " + id);
        }

    }

    @Override
    @Transactional
    public void updateFoodPrice(long id, Float price) {
        Food tmpFood = foodRepository.findById(id).get();
        if (!(price.equals(tmpFood.getPrice()))) {
            foodRepository.updateFoodPriceById(id, price);
            log.info("Zaktualizowano cene: " + price + " dla id: " + id);
        }

    }

    @Override
    public void removeFoodById(Long id) {
        foodRepository.deleteById(id);
    }
}
