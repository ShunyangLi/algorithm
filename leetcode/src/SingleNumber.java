import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
    public int singleNumber (int[] A) {
        // write code here
        Map<Integer, Integer> map = new HashMap<>();
        for (int value : A) {
            if (map.containsKey(value)) {
                map.remove(value);
            } else {
                map.put(value, value);
            }
        }

        return map.get(map.keySet().toArray()[0]);
    }

    public static void main(String[] args) {
        SingleNumber sn = new SingleNumber();
        System.out.println(sn.singleNumber(new int[] {1,1, 0}));
    }

}
