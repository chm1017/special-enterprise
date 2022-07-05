package com.cm.special_enterprise.de.SRP.lishitihuanPrinciple;

public class Snipper {
    private AUG aug;
    private AK47 ak47;

    public void setAug(AK47 ak47) {
        this.ak47 = ak47;
    }
    public void setAug(AUG aug) {
        this.aug = aug;
    }
    public void killEnemy(Rifle rifle) {
        rifle.shoot();
    }
}
