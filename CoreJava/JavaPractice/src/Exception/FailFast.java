package Exception;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FailFast {
    public static void main(String[] args){
        HashMap<Integer, String> map = new HashMap<>();
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
