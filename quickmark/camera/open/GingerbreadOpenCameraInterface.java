
package com.lingtuan.firefly.quickmark.camera.open;

import android.annotation.TargetApi;
import android.hardware.Camera;
import android.util.Log;

/**
 * Implementation for Android API 9 (Gingerbread) and later. This opens up the possibility of accessing
 * front cameras, and rotated cameras.
 */
@TargetApi(9)
public final class GingerbreadOpenCameraInterface implements OpenCameraInterface {

  private static final String TAG = "GingerbreadOpenCamera";

  /**
   * Opens a rear-facing camera with {@link Camera#open(int)}, if one exists, or opens camera 0.
   */
  @Override
  public Camera open() {
    
    int numCameras = Camera.getNumberOfCameras();
    if (numCameras == 0) {
      Log.w(TAG, "No cameras!");
      return null;
    }

    int index = 0;
    while (index < numCameras) {
      Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
      Camera.getCameraInfo(index, cameraInfo);
      if (cameraInfo.facing == Camera.CameraInfo.CAMERA_FACING_BACK) {
        break;
      }
      index++;
    }
    
    Camera camera;
    if (index < numCameras) {
      Log.i(TAG, "Opening camera #" + index);
      camera = Camera.open(index);
    } else {
      Log.i(TAG, "No camera facing back; returning camera #0");
      camera = Camera.open(0);
    }

    return camera;
  }

}
