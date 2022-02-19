import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class MapTest {
    @Test
    public void test() {
        HashMap<String, String> map = new HashMap<>();
        map.put("shuobin", "123");
        String value = map.get("jjj");
        System.out.println(value);
        System.out.println("ddd".equals(null));
    }
}
