package ru.tenant.pass24.helpers.WelcomeView.draw.drawer.type;

import android.graphics.Paint;

import androidx.annotation.NonNull;

import ru.tenant.pass24.helpers.WelcomeView.draw.data.Indicator;

class BaseDrawer {

    Paint paint;
    Indicator indicator;

    BaseDrawer(@NonNull Paint paint, @NonNull Indicator indicator) {
        this.paint = paint;
        this.indicator = indicator;
    }
}
