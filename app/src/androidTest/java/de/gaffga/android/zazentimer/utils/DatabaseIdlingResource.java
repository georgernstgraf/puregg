package de.gaffga.android.zazentimer.utils;

import androidx.test.espresso.IdlingResource;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * An IdlingResource implementation for database operations.
 * This helps ensure Espresso waits for database operations to complete before proceeding with tests.
 */
public class DatabaseIdlingResource implements IdlingResource {
    private volatile ResourceCallback callback;
    private AtomicBoolean isIdle = new AtomicBoolean(true);

    @Override
    public String getName() {
        return DatabaseIdlingResource.class.getSimpleName();
    }

    @Override
    public boolean isIdleNow() {
        return isIdle.get();
    }

    @Override
    public void registerIdleTransitionCallback(ResourceCallback callback) {
        this.callback = callback;
    }

    /**
     * Sets the idle state and notifies the callback if transitioning to idle.
     * @param isIdle The new idle state
     */
    public void setIdleState(boolean isIdle) {
        this.isIdle.set(isIdle);
        if (isIdle && callback != null) {
            callback.onTransitionToIdle();
        }
    }
}