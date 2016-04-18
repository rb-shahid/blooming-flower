package com.byteshaft.bloomingflowers.model.parser;

import com.byteshaft.bloomingflowers.model.Flower;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class FlowerJsonParser {

    public static List<Flower> parserFeed(String content) {

        try {
            JSONArray ar = new JSONArray(content);
            List<Flower> flowerList = new ArrayList<>();

            for (int i = 0; i < ar.length(); i++) {
                JSONObject object = ar.getJSONObject(i);
                Flower flower = new Flower();
                flower.setProductId(object.getInt("productId"));
                flower.setName(object.getString("name"));
                flower.setCategory(object.getString("category"));
                flower.setInstructions(object.getString("instructions"));
                flower.setPhoto(object.getString("photo"));
                flower.setPrice(object.getDouble("price"));

                flowerList.add(flower);
            }

            return flowerList;

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
