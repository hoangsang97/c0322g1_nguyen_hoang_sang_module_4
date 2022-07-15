package com.example.repository.impl;

import com.example.model.BoxLetter;
import com.example.repository.IBoxLetterRepository;

import java.util.ArrayList;
import java.util.List;

public class BoxLetterRepositoryImpl implements IBoxLetterRepository {
    private static List<BoxLetter> boxLetterList = new ArrayList<>();

    static {
        boxLetterList.add(new BoxLetter(1,"English", 25, "", new String[]{"King", "Asgard"}));
        boxLetterList.add(new BoxLetter(2, "Vietnamese", 5, "filter", new String[]{"King", "Asgard"}));
        boxLetterList.add(new BoxLetter(3, "Japanese", 15, "filter", new String[]{"King", "Asgard"}));
    }

    @Override
    public List<BoxLetter> FindAll() {
        return boxLetterList;
    }

    @Override
    public BoxLetter FindById(int id) {
        for (BoxLetter item: boxLetterList) {
            if (item.getId() == id){
                return item;
            }
        }
        return null;
    }

    @Override
    public void UpdateBox(int id, BoxLetter boxLetter) {
        for (BoxLetter item: boxLetterList) {
            String boxLetterFilter = boxLetter.getFilter();
            if (item.getId() == id) {
                item.setLanguages(boxLetter.getLanguages());
                item.setSize(boxLetter.getSize());
                if (boxLetterFilter != null) {
                    item.setFilter(boxLetter.getFilter());
                } else {
                    item.setFilter("");
                }
                item.setSignature(boxLetter.getSignature());
            }
        }
    }
}
