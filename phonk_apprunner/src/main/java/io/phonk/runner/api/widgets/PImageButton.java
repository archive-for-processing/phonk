/*
 * Part of Phonk http://www.phonk.io
 * A prototyping platform for Android devices
 *
 * Copyright (C) 2013 - 2017 Victor Diaz Barrales @victordiaz (Protocoder)
 * Copyright (C) 2017 - Victor Diaz Barrales @victordiaz (Phonk)
 *
 * Phonk is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Phonk is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Phonk. If not, see <http://www.gnu.org/licenses/>.
 *
 */

package io.phonk.runner.api.widgets;

import android.graphics.Bitmap;
import android.view.MotionEvent;

import io.phonk.runner.api.common.ReturnInterface;
import io.phonk.runner.api.common.ReturnObject;
import io.phonk.runner.apprunner.AppRunner;
import io.phonk.runner.base.utils.MLog;

public class PImageButton extends PImage {

    private String TAG = PImageButton.class.getSimpleName();

    private boolean hideBackground = true;
    private Bitmap mBitmap;
    private Bitmap mBitmapPressed;
    private ReturnInterface callbackfn;

    public PImageButton(AppRunner appRunner) {
        super(appRunner);
    }

    // Set on click behavior
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        MLog.d(TAG, "" + event.getAction());
        ReturnObject r = new ReturnObject();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                r.put("action", "down");
                this.setPressed(true);
                on();

                break;

            case MotionEvent.ACTION_UP:
                r.put("action", "up");
                this.setPressed(false);
                off();
                break;

            case MotionEvent.ACTION_CANCEL:
                this.setPressed(false);
                r.put("action", "cancel");
                off();
                break;
        }

        if (callbackfn != null && !r.isEmpty()) callbackfn.event(r);

        return true;
    }

    /**
     * Adds an image with the option to hide the default background
     */
    public PImageButton onClick(final ReturnInterface callbackfn) {
        this.callbackfn = callbackfn;

        return this;
    }

    private void on() {
        // if (hideBackground) PImageButton.this.getDrawable().setColorFilter(styler.srcTintPressed, PorterDuff.Mode.MULTIPLY);
        if (mBitmapPressed != null) setImageBitmap(mBitmapPressed);
    }

    private void off() {
        // if (hideBackground) PImageButton.this.getDrawable().setColorFilter(0xFFFFFFFF, PorterDuff.Mode.MULTIPLY);
        if (mBitmap != null) setImageBitmap(mBitmap);
    }
}
