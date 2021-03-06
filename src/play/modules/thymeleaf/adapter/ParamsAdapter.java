/*
 * Copyright 2012 Satoshi Takata
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package play.modules.thymeleaf.adapter;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import play.mvc.Scope.Params;

/**
 * This class adapts Params instance as a Map.
 * 
 */

public class ParamsAdapter implements Map<String, String> {
    private Params params = Params.current();
    
    @Override
    public void clear() {
        params.data.clear();
    }

    @Override
    public boolean containsKey(Object key) {
        return params._contains((String) key);
    }

    @Override
    public boolean containsValue(Object value) {
        return params.all().containsValue(value);
    }

    @Override
    public Set<java.util.Map.Entry<String, String>> entrySet() {
        return params.allSimple().entrySet();
    }

    @Override
    public String get(Object key) {
        return params.get((String) key);
    }

    @Override
    public boolean isEmpty() {
        return params.all().isEmpty();
    }

    @Override
    public Set<String> keySet() {
        return params.all().keySet();
    }

    @Override
    public String put(String key, String value) {
        String prev = params.get(key);
        params.put(key, value);
        return prev;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void putAll(Map<? extends String, ? extends String> m) {
        Set<?> set = m.entrySet();
        for (Object object : set) {
            Entry<String, String> entry = (Entry<String, String>) object;
            this.put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public String remove(Object key) {
        String prev = params.get((String) key);
        params.remove((String) key);
        return prev;
    }

    @Override
    public int size() {
        return params.all().size();
    }

    @Override
    public Collection<String> values() {
        return params.allSimple().values();
    }

}
