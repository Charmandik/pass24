package ru.tenant.pass24.Helpers.WelcomeView;


import androidx.annotation.Nullable;

import ru.tenant.pass24.Helpers.WelcomeView.animation.AnimationManager;
import ru.tenant.pass24.Helpers.WelcomeView.animation.controller.ValueController;
import ru.tenant.pass24.Helpers.WelcomeView.animation.data.Value;
import ru.tenant.pass24.Helpers.WelcomeView.draw.DrawManager;
import ru.tenant.pass24.Helpers.WelcomeView.draw.data.Indicator;

public class IndicatorManager implements ValueController.UpdateListener {

    private DrawManager drawManager;
    private AnimationManager animationManager;
    private Listener listener;

    IndicatorManager(@Nullable Listener listener) {
        this.listener = listener;
        this.drawManager = new DrawManager();
        this.animationManager = new AnimationManager(drawManager.indicator(), this);
    }

    public AnimationManager animate() {
        return animationManager;
    }

    public Indicator indicator() {
        return drawManager.indicator();
    }

    public DrawManager drawer() {
        return drawManager;
    }

    @Override
    public void onValueUpdated(@Nullable Value value) {
        drawManager.updateValue(value);
        if (listener != null) {
            listener.onIndicatorUpdated();
        }
    }

    interface Listener {
        void onIndicatorUpdated();
    }
}
