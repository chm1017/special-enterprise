package com.cm.special_enterprise.de.linkMode;

public class ChinaTopDnsServer extends DnsServer{
    @Override
    protected void sign(Recorder recorder) {
        recorder.setOwner("中国顶级服务器");
    }
    @Override
    protected boolean isLocal(Recorder recorder) {
        return recorder.getDomain().endsWith(".cn");
    }


}
