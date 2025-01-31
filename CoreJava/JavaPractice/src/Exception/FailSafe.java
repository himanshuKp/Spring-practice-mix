package Exception;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FailSafe {
    public static void main(String[] args){
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
        map.put(1, "a");
        map.put(2, "b");

        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, String> entry = iterator.next();
            if(entry.getKey()==1) {
                map.remove(1);
            }
        }
    }
}
