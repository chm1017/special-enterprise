package com.cm.special_enterprise.de.interfaceGeLi;

public abstract class AbstractSearcher {
    protected IBGirl ibGirl;

    public AbstractSearcher(IBGirl ibGirl) {
        this.ibGirl = ibGirl;
    }

    public abstract void show();

}
