package id.mzennis.epoxyexample.domain.interactor.param;

import java.util.HashMap;

/**
 * Created by meyta on 03/01/18.
 */

public class TKPDMapParam<K, V> extends HashMap<K, V> {
    /**
     * @param key   key parameter
     * @param value value nya, valuenya ga boleh null, kalo null terpaksa dibuat error
     * @return @override super
     */
    @Override
    public V put(K key, V value) {
        if (value == null) throw new RuntimeException("Value ga boleh null coy!! |KEY = " + key);
        return super.put(key, value);
    }
}
