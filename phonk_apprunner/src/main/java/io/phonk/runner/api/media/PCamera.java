/*
 * Part of Phonk http://www.phonk.io
 * A prototyping platform for Android devices
 *
 * Copyright (C) 2013 - 2017 Victor Diaz Barrales @victordiaz (Protocoder)
 * Copyright (C) 2017 - Victor Diaz Barrales @victordiaz (Phonk)
 *
 * Phonk is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Phonk is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Phonk. If not, see <http://www.gnu.org/licenses/>.
 *
 */

package io.phonk.runner.api.media;

import io.phonk.runner.api.common.ReturnInterface;
import io.phonk.runner.apprunner.AppRunner;
import io.phonk.runner.base.gui.Camera;
import io.phonk.runner.base.gui.CameraNew;

public class PCamera extends Camera implements PCameraInterface {

    private final PCamera cam;
    protected AppRunner mAppRunner;

    public PCamera(AppRunner appRunner) {
        super(appRunner);
        this.mAppRunner = appRunner;
        cam = this;

        mAppRunner.whatIsRunning.add(this);
    }

    @Override
    public void takePicture(String file, ReturnInterface callbackfn) {

    }

    @Override
    public void recordVideo(String file) {

    }

    @Override
    public void stopRecordingVideo() {

    }

    @Override
    public void focus(ReturnInterface callback) {

    }

    @Override
    public void setPreviewSize(int w, int h) {

    }

    @Override
    public void setPictureResolution(int w, int h) {

    }

    @Override
    public boolean isFlashAvailable() {
        return false;
    }

    @Override
    public void turnOnFlash(boolean b) {

    }

    @Override
    public void setColorEffect(String effect) {

    }

    @Override
    public void onNewBitmap(CameraNew.CallbackBmp callbackfn) {

    }

    @Override
    public void onNewStreamFrame(CameraNew.CallbackStream callbackfn) {
    }

    public void __close() {
    //    cam.closeCamera();
    }



}
