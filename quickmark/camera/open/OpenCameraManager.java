
package com.lingtuan.firefly.quickmark.camera.open;


import com.lingtuan.firefly.quickmark.common.PlatformSupportManager;

/**
 * Selects an appropriate implementation of {@link OpenCameraInterface} based on the device's
 * API level.
 */
public final class OpenCameraManager extends PlatformSupportManager<OpenCameraInterface> {

  public OpenCameraManager() {
    super(OpenCameraInterface.class, new DefaultOpenCameraInterface());
    addImplementationClass(9, "com.google.zxing.client.android.camera.open.GingerbreadOpenCameraInterface");
  }

}
