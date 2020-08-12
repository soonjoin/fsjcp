package net.cishow.fsjcp.service;

import net.cishow.fsjcp.common.entity.fsconf.Sofia;
import net.cishow.fsjcp.common.entity.fsconf.base.SipProfile;
import net.cishow.fsjcp.common.entity.fsconf.base.SipProfileType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FsjcpServiceApplicationTests {

    @Test
    void contextLoads() {

        Sofia sofia = new Sofia();

        SipProfile external = new SipProfile("external", SipProfileType.EXTERNAL);
        sofia.getProfiles().put("external", external);

        System.out.println(sofia);
    }

}
