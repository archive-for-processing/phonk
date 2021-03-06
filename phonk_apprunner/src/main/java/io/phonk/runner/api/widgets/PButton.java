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

import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Html;
import android.view.View;

import java.util.Map;

import io.phonk.runner.api.common.ReturnInterface;
import io.phonk.runner.api.common.ReturnObject;
import io.phonk.runner.apidoc.annotation.ProtoMethod;
import io.phonk.runner.apidoc.annotation.ProtoMethodParam;
import io.phonk.runner.apprunner.AppRunner;
import io.phonk.runner.apprunner.StyleProperties;
import io.phonk.runner.base.utils.MLog;

public class PButton extends androidx.appcompat.widget.AppCompatButton implements PViewMethodsInterface, PTextInterface {
    private static final String TAG = PButton.class.getSimpleName();
    private final AppRunner mAppRunner;

    public StyleProperties props = new StyleProperties();
    public Styler styler;

    public PButton(AppRunner appRunner) {
        super(appRunner.getAppContext());
        mAppRunner = appRunner;

        // StyleProperties styleProperties = new StyleProperties();
        // styleProperties.put("backgroundPressed", styleProperties, "#FF008800");
        // appRunner.pUi.registerStyle("button", styleProperties);

        styler = new Styler(appRunner, this, props);
        styler.apply();
    }

    @ProtoMethod(description = "Triggers the function when the button is clicked", example = "")
    @ProtoMethodParam(params = {"function"})
    public PButton onClick(final ReturnInterface callbackfn) {
        // Set on click behavior
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callbackfn != null) {

                    ReturnObject r = new ReturnObject(PButton.this);
                    r.put("action", "clicked");
                    callbackfn.event(r);
                }
            }
        });

        return this;
    }


    @ProtoMethod(description = "Changes the font type to the button", example = "")
    @ProtoMethodParam(params = {"Typeface"})
    public PButton font(Typeface f) {
        this.setTypeface(f);

        return this;
    }

    @Override
    public View textStyle(int style) {
        this.setTypeface(null, style);
        return this;
    }

    @Override
    public View textAlign(int alignment) {
        MLog.d("qq", "button align " + alignment);

        this.setGravity(alignment);

        return this;
    }

    @Override
    public View textSize(int size) {
        this.textSize(size);
        return this;
    }


    @Override
    @ProtoMethod(description = "Changes the font text color", example = "")
    @ProtoMethodParam(params = {"colorHex"})
    public PButton textColor(String c) {
        this.setTextColor(Color.parseColor(c));
        return this;
    }

    @Override
    @ProtoMethod(description = "Changes the font text color", example = "")
    @ProtoMethodParam(params = {"colorHex"})
    public PButton textColor(int c) {
        this.setTextColor(c);
        return this;
    }

    @ProtoMethod(description = "Changes the background color", example = "")
    @ProtoMethodParam(params = {"colorHex"})
    public PButton background(String c) {
        this.setBackgroundColor(Color.parseColor(c));
        return this;
    }


    @ProtoMethod(description = "Sets html text", example = "")
    @ProtoMethodParam(params = {"htmlText"})
    public PButton html(String htmlText) {
        this.setText(Html.fromHtml(htmlText));

        return this;
    }


    @ProtoMethod(description = "Changes the button size", example = "")
    @ProtoMethodParam(params = {"w", "h"})
    public PButton boxsize(int w, int h) {
        this.setWidth(w);
        this.setHeight(h);

        return this;
    }

    @Override
    @ProtoMethod(description = "Changes the text size", example = "")
    @ProtoMethodParam(params = {"size"})
    public View textSize(float size) {
        this.setTextSize(size);

        return this;
    }

    @ProtoMethod(description = "Button position", example = "")
    @ProtoMethodParam(params = {"x", "y"})
    public PButton pos(int x, int y) {
        this.setX(x);
        this.setY(y);
        return this;
    }

    @Override
    public void set(float x, float y, float w, float h) {
        styler.setLayoutProps(x, y, w, h);
    }

    @Override
    public void setStyle(Map style) {
        styler.setStyle(style);
    }

    @Override
    public Map getStyle() {
        return props;
    }

    public PAnimation anim() {
        return new PAnimation(this);
    }

    public void styleq(Map style) {
        styler.setStyle(style);
    }

}
