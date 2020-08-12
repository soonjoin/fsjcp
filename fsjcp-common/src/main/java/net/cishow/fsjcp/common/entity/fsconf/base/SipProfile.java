package net.cishow.fsjcp.common.entity.fsconf.base;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SipProfile extends ContainerItem {

    private MapItem<String> aliases;
    private MapItem<Gateway> gateways;
    private MapItem<Domain> domains;
    private MapItem<String> settings;

    public SipProfile(String name) {
        super("profile", "name=\"" + name + "\"");
        aliases = new MapItem<>("aliases");
        gateways = new MapItem<>("gateways");
        domains = new MapItem<>("domains");
        settings = new MapItem<>("settings");
    }

    public SipProfile(String name, SipProfileType type) {
        super("profile", "name=\"" + name + "\"");
        aliases = new MapItem<>("aliases");
        gateways = new MapItem<>("gateways");
        domains = new MapItem<>("domains");
        settings = new MapItem<>("settings");

        switch (type) {
            case EXTERNAL:
                domains.put("all", new Domain("all", "false", "true"));
                settings.put("debug", "0");
                settings.put("sip-trace", "no");
                settings.put("sip-capture", "no");
                settings.put("rfc2833-pt", "101");
                settings.put("sip-port", "$${external_sip_port}");
                settings.put("dialplan", "XML");
                settings.put("context", "public");
                settings.put("dtmf-duration", "2000");
                settings.put("inbound-codec-prefs", "$${global_codec_prefs}");
                settings.put("outbound-codec-prefs", "$${outbound_codec_prefs}");
                settings.put("hold-music", "$${hold_music}");
                settings.put("rtp-timer-name", "soft");
                settings.put("local-network-acl", "localnet.auto");
                settings.put("manage-presence", "false");
                settings.put("inbound-codec-negotiation", "generous");
                settings.put("nonce-ttl", "60");
                settings.put("auth-calls", "false");
                settings.put("inbound-late-negotiation", "true");
                settings.put("inbound-zrtp-passthru", "true");
                settings.put("rtp-ip", "$${local_ip_v4}");
                settings.put("sip-ip", "$${local_ip_v4}");
                settings.put("ext-rtp-ip", "$${external_rtp_ip}");
                settings.put("ext-sip-ip", "$${external_rtp_ip}");
                settings.put("rtp-timeout-sec", "300");
                settings.put("rtp-hold-timeout-sec", "1800");
                settings.put("tls", "$${external_ssl_enable}");
                settings.put("tls-only", "false");
                settings.put("tls-bind-params", "transport=tls");
                settings.put("tls-sip-port", "$${external_tls_port}");
                settings.put("tls-passphrase", "");
                settings.put("tls-verify-date", "true");
                settings.put("tls-verify-policy", "none");
                settings.put("tls-verify-depth", "2");
                settings.put("tls-verify-in-subjects", "");
                settings.put("tls-version", "$${sip_tls_version}");
                break;
            case INTERNAL:
                domains.put("all", new Domain("", "", ""));
                settings.put("debug", "0");
                settings.put("sip-trace", "no");
                settings.put("sip-capture", "no");
                settings.put("watchdog-enabled", "no");
                settings.put("watchdog-step-timeout", "30000");
                settings.put("watchdog-event-timeout", "30000");
                settings.put("log-auth-failures", "false");
                settings.put("forward-unsolicited-mwi-notify", "false");
                settings.put("context", "public");
                settings.put("rfc2833-pt", "101");
                settings.put("sip-port", "$${internal_sip_port}");
                settings.put("dialplan", "XML");
                settings.put("dtmf-duration", "2000");
                settings.put("inbound-codec-prefs", "$${global_codec_prefs}");
                settings.put("outbound-codec-prefs", "$${global_codec_prefs}");
                settings.put("rtp-timer-name", "soft");
                settings.put("rtp-ip", "$${local_ip_v4}");
                settings.put("sip-ip", "$${local_ip_v4}");
                settings.put("hold-music", "$${hold_music}");
                settings.put("apply-nat-acl", "nat.auto");
                settings.put("apply-inbound-acl", "domains");
                settings.put("local-network-acl", "localnet.auto");
                settings.put("record-path", "$${recordings_dir}");
                settings.put("record-template", "${caller_id_number}.${target_domain}.${strftime(%Y-%m-%d-%H-%M-%S)}.wav");
                settings.put("manage-presence", "true");
                settings.put("presence-hosts", "$${domain},$${local_ip_v4}");
                settings.put("presence-privacy", "$${presence_privacy}");
                settings.put("inbound-codec-negotiation", "generous");
                settings.put("tls", "$${internal_ssl_enable}");
                settings.put("tls-only", "false");
                settings.put("tls-bind-params", "transport=tls");
                settings.put("tls-sip-port", "$${internal_tls_port}");
                settings.put("tls-passphrase", "");
                settings.put("tls-verify-date", "true");
                settings.put("tls-verify-policy", "none");
                settings.put("tls-verify-depth", "2");
                settings.put("tls-verify-in-subjects", "");
                settings.put("tls-version", "$${sip_tls_version}");
                settings.put("tls-ciphers", "$${sip_tls_ciphers}");
                settings.put("inbound-late-negotiation", "true");
                settings.put("inbound-zrtp-passthru", "true");
                settings.put("nonce-ttl", "60");
                settings.put("auth-calls", "$${internal_auth_calls}");
                settings.put("inbound-reg-force-matching-username", "true");
                settings.put("auth-all-packets", "false");
                settings.put("ext-rtp-ip", "$${external_rtp_ip}");
                settings.put("ext-sip-ip", "$${external_rtp_ip}");
                settings.put("rtp-timeout-sec", "300");
                settings.put("rtp-hold-timeout-sec", "1800");
                settings.put("force-register-domain", "$${domain}");
                settings.put("force-subscription-domain", "$${domain}");
                settings.put("force-register-db-domain", "$${domain}");
                settings.put("ws-binding", ":5066");
                settings.put("wss-binding", ":7443");
                settings.put("challenge-realm", "auto_from");
                break;
            case OTHER:
            default:
                break;
        }
    }

}
