package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import java.util.Arrays;

public class JsonUtils {
    
    private static final String MAIN_NAME_KEY = "\"mainName\":\"";
    private static final String AKA_KEY = "\"alsoKnownAs\":[";
    private static final String ORIGIN_KEY = "\"placeOfOrigin\":\"";
    private static final String DESCRIPTION_KEY = "\"description\":\"";
    private static final String IMAGE_KEY = "\"image\":\"";
    private static final String INGREDIENTS_KEY = "\"ingredients\":[";

    public static Sandwich parseSandwichJson(String json) {
        int mainNameIndex = json.indexOf(MAIN_NAME_KEY) + MAIN_NAME_KEY.length();
        int akaIndex = json.indexOf(AKA_KEY) + AKA_KEY.length();
        int originIndex = json.indexOf(ORIGIN_KEY) + ORIGIN_KEY.length();
        int descriptionIndex = json.indexOf(DESCRIPTION_KEY) + DESCRIPTION_KEY.length();
        int imageIndex = json.indexOf(IMAGE_KEY) + IMAGE_KEY.length();
        int ingredientsIndex = json.indexOf(INGREDIENTS_KEY) + INGREDIENTS_KEY.length();

        String mainName = json.substring(mainNameIndex, json.indexOf("\",\"", mainNameIndex));
        String[] alsoKnownAs = json.substring(akaIndex, json.indexOf(']', akaIndex)).replace("\"", "").split(",");
        String placeOfOrigin = json.substring(originIndex, json.indexOf("\",\"", originIndex));
        String description = json.substring(descriptionIndex, json.indexOf("\",\"", descriptionIndex));
        String image = json.substring(imageIndex, json.indexOf("\",\"", imageIndex));
        String[] ingredients = json.substring(ingredientsIndex, json.indexOf(']', ingredientsIndex)).replace("\"", "").split(",");

        return new Sandwich(mainName, Arrays.asList(alsoKnownAs), placeOfOrigin, description, image, Arrays.asList(ingredients));
    }
}