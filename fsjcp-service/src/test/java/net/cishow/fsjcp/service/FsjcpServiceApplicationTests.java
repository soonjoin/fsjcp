package net.cishow.fsjcp.service;

import net.cishow.fsjcp.common.entity.fsconf.Sofia;
import net.cishow.fsjcp.common.entity.fsconf.base.MapItemNew;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FsjcpServiceApplicationTests {

    @Test
    void contextLoads() {
        MapItemNew<String> test = new MapItemNew<>("params", "desc=\"ss\"");
        test.put("name", "sujin");
        test.put("value", "sss");
        String x =  test.toString();
        Sofia sofia = new Sofia("test");

        sofia.getGlobal_settings().put("a",null);
        sofia.getGlobal_settings().put("b","y");

        sofia.getProfiles().put("1", "a");
        sofia.getProfiles().put("2", "b");

        System.out.println(sofia);
    }

}
