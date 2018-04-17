package com.ysk.addressbook.util;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by lsj on 20/03/2018.
 */
public class JsonBuilder {

    private JSONObject jsonObject;

    private JsonBuilder() {
        jsonObject = new JSONObject();
    }

    public static JsonBuilder builder() {
        return new JsonBuilder();
    }

    public static JsonBuilder builder(String key, Object obj) {
        return builder().put(key,obj);
    }

    public JsonBuilder put(String key, Object obj) {
        this.jsonObject.put(key, obj);
        return this;
    }

    public JSONObject build() {
        return jsonObject;
    }
}
