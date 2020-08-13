package net.cishow.fsjcp.service.controller;

import net.cishow.fsjcp.common.entity.fsconf.Sofia;
import net.cishow.fsjcp.common.entity.fsconf.base.SipProfile;
import net.cishow.fsjcp.common.entity.fsconf.base.SipProfileType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/fsconf",
        params = {"section=configuration", "tag_name=configuration"},
        produces = "application/xml;charset=UTF-8")
public class FsConfController {

    @RequestMapping(params = {"key_name=name", "key_value=sofia.conf"})
    public String sofia() {
        Sofia sofia = new Sofia();

        SipProfile external = new SipProfile("external", SipProfileType.EXTERNAL);
        sofia.getProfiles().put("external", external);

        return sofia.toString();
    }
}
