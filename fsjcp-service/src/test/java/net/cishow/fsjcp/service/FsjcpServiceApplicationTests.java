package net.cishow.fsjcp.service;

import net.cishow.fsjcp.common.entity.fsconf.Sofia;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FsjcpServiceApplicationTests {

    @Test
    void contextLoads() {
        Sofia sofia = new Sofia("test");
        sofia.getGlobal_settings().put("a","x");
        sofia.getGlobal_settings().put("b","y");
        System.out.println(sofia);
    }

}
