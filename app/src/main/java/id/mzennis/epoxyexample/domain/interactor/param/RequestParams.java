package id.mzennis.epoxyexample.domain.interactor.param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by meyta on 03/01/18.
 */

public class RequestParams {

    public static final RequestParams EMPTY = RequestParams.create();

    private final TKPDMapParam<String, Object> parameters = new TKPDMapParam<>();

    private RequestParams() {
    }

    public static RequestParams create() {
        return new RequestParams();
    }

    public void putInt(String key, int value) {
        parameters.put(key, value);
    }

    public void putString(String key, String value) {
        parameters.put(key, value);
    }

    public void putBoolean(String key, boolean value) {
        parameters.put(key, value);
    }

    public void putLong(String key, long value) {
        parameters.put(key, value);
    }

    public void putObject(String key, Object object) {
        parameters.put(key, object);
    }

    public void putListLong(String key, List<Long> longList){
        parameters.put(key, longList);
    }

    public int getInt(String key, int defaultValue) {
        final Object object = parameters.get(key);
        if (object == null) {
            return defaultValue;
        }
        try {
            return (int) object;
        } catch (ClassCastException e) {
            return defaultValue;
        }
    }

    public String getString(String key, String defaultValue) {
        final Object object = parameters.get(key);
        if (object == null) {
            return defaultValue;
        }
        try {
            return (String) object;
        } catch (ClassCastException e) {
            return defaultValue;
        }
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        final Object object = parameters.get(key);
        if (object == null) {
            return defaultValue;
        }
        try {
            return (Boolean) object;
        } catch (ClassCastException e) {
            return defaultValue;
        }
    }

    public long getLong(String key, long defaultValue){
        final Object object = parameters.get(key);
        if (object == null) {
            return defaultValue;
        }
        try {
            return (Long) object;
        } catch (ClassCastException e) {
            return defaultValue;
        }
    }

    public List<Long> getListLong(String key, List<Long> defaultValue){
        final Object object = parameters.get(key);
        if (object == null) {
            return defaultValue;
        }
        try {
            return (List<Long>) object;
        } catch (ClassCastException e) {
            return defaultValue;
        }
    }

    public Object getObject(String key) {
        return parameters.get(key);
    }

    public void clearValue(String key) {
        parameters.remove(key);
    }

    public TKPDMapParam<String, Object> getParameters() {
        return parameters;
    }

    public TKPDMapParam<String, String> getParamsAllValueInString() {
        return convertMapObjectToString(parameters);
    }

    private TKPDMapParam<String, String> convertMapObjectToString(TKPDMapParam<String,Object> map) {
        TKPDMapParam<String,String> newMap =new TKPDMapParam<>();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if(entry.getValue() instanceof String){
                newMap.put(entry.getKey(), String.valueOf(entry.getValue()));
            }
        }
        return newMap;
    }

    public void putAll(Map<String, Object> params){
        parameters.putAll(params);
    }

    public void putAll(HashMap<String, String> params){
        parameters.putAll(params);
    }
}

