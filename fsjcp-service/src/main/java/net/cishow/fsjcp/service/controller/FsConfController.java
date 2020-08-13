package net.cishow.fsjcp.service.controller;

import net.cishow.fsjcp.common.entity.fsconf.Sofia;
import net.cishow.fsjcp.common.entity.fsconf.base.SipProfile;
import net.cishow.fsjcp.common.entity.fsconf.base.SipProfileType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/fsconf",
        params = {"section=configuration", "tag_name=configuration"},
        produces = "application/xml;charset=UTF-8")
public class FsConfController {

    @RequestMapping(params = {"key_name=name", "key_value=sofia.conf"})
    @ResponseBody
    public String sofia() {
        Sofia sofia = new Sofia();

        SipProfile external = new SipProfile("external", SipProfileType.EXTERNAL);
        sofia.getProfiles().put("external", external);

        SipProfile internal = new SipProfile("internal", SipProfileType.INTERNAL);
        sofia.getProfiles().put("internal", internal);

        return sofia.toString();
    }

    @RequestMapping(params = {"key_name=name"})
    public String timezone(@RequestParam("key_value") String key_value) {
        return "/fsconf/" + key_value;
    }
}
