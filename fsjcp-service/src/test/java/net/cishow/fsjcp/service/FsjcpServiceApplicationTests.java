package net.cishow.fsjcp.service;

import net.cishow.fsjcp.common.entity.fsconf.Sofia;
import net.cishow.fsjcp.common.entity.fsconf.base.Gateway;
import net.cishow.fsjcp.common.entity.fsconf.base.SipProfile;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FsjcpServiceApplicationTests {

    @Test
    void contextLoads() {

        Sofia sofia = new Sofia();

        sofia.getGlobal_settings().put("a",null);
        sofia.getGlobal_settings().put("b","y");

        SipProfile sipProfile1 = new SipProfile("internal");
        //SipProfile sipProfile2 = new SipProfile("external");
        Gateway gateway = new Gateway("test");
        gateway.put("expire-seconds", "60");
        sipProfile1.getGateways().put("test", gateway);
        sofia.getProfiles().put("internal", sipProfile1);
        //sofia.getProfiles().put("external", sipProfile2);

        System.out.println(sofia);
    }

}
