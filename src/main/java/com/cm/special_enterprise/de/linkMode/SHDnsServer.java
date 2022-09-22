package com.cm.special_enterprise.de.linkMode;

public class SHDnsServer extends DnsServer{

    @Override
    protected void sign(Recorder recorder) {
        recorder.setOwner("上海服务器");
    }
    @Override
    protected boolean isLocal(Recorder recorder) {
        return recorder.getDomain().endsWith(".sh.cn");
    }


}
