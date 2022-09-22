package com.cm.special_enterprise.de.linkMode;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;

public abstract class DnsServer extends Observable implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        Recorder recorder = (Recorder) arg;
        if (isLocal(recorder)) {
            recorder.setIp(genIpAddress());

        } else {
            responsFromUpperServer(recorder);
        }
        sign(recorder);
    }

    public void setUpperServer(DnsServer dnsServer) {
        super.deleteObservers();
        super.addObserver(dnsServer);
    }

    private void responsFromUpperServer(Recorder recorder) {
        super.setChanged();
        super.notifyObservers(recorder);

    }

    protected abstract boolean isLocal(Recorder recorder);

    protected abstract void sign(Recorder recorder);

    private String genIpAddress() {
        Random random = new Random();
        String address = random.nextInt(255) + "." + random.nextInt(255) + "." + random.nextInt(255) + "." + random.nextInt(255);
        return address;
    }

}
