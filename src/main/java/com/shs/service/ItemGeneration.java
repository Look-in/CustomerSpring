package com.shs.service;

import com.shs.entity.Bicycle;
import com.shs.entity.Clothes;
import com.shs.entity.Item;

public interface ItemGeneration {

    Clothes getNewClothes();

    Bicycle getNewBicycle();

}
