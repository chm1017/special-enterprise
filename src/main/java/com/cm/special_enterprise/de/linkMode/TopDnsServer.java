package com.cm.special_enterprise.de.linkMode;

public class TopDnsServer extends DnsServer {

    @Override
    protected void sign(Recorder recorder) {
        recorder.setOwner("世界顶级服务器");
    }
    @Override
    protected boolean isLocal(Recorder recorder) {
        return true;
    }


}
