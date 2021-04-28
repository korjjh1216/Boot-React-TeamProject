package cho.example.api.stream;

import java.util.HashMap;

public class Box<T>{
    private HashMap<String,T> map;
    public Box(){ map= new HashMap<String,T>();}
    public void clear(){ map.clear();}
    public boolean containsKey(String key){ return map.containsKey(key);}
    public T get(String key){ return map.get(key);}
    public boolean isEmpty(){ return map.isEmpty();}
    public T put(String  key,T value){return map.put(key,value);}
    public T remove(String key){return map.remove(key); }
}