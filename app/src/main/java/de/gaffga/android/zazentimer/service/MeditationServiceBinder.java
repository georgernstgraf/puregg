package de.gaffga.android.zazentimer.service;

import android.os.Binder;

/* loaded from: classes.dex */
public class MeditationServiceBinder extends Binder {
    private MeditationService service;

    public MeditationServiceBinder(MeditationService meditationService) {
        this.service = meditationService;
    }

    public MeditationService getService() {
        return this.service;
    }
}
