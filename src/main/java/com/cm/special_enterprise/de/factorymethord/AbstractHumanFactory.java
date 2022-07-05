package com.cm.special_enterprise.de.factorymethord;

public abstract class AbstractHumanFactory {
    public abstract <T extends Human> T creatHuman(Class<T> c);
}
