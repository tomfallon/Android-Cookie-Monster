package com.example.cookiemonster;


import android.hardware.Camera;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.widget.FrameLayout;
import android.widget.Toast;

public class CameraActivity extends Activity {

    private Camera mCamera;
    private CameraPreview mPreview;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        // Create an instance of Camera
        mCamera = getCameraInstance();

        // Create our Preview view and set it as the content of our activity.
        mPreview = new CameraPreview(this, mCamera);
        FrameLayout preview = (FrameLayout) findViewById(R.id.camera_preview);
        preview.addView(mPreview);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_camera, menu);
        return true;
    }
    
    public static Camera getCameraInstance(){
        Camera c = null;
        try {
            c = Camera.open(); // attempt to get a Camera instance
        }
        catch (Exception e){
        	// Camera is not available (in use or does not exist)
        }
        return c; // returns null if camera is unavailable
    }

    @Override
    public void onRestart() {
        super.onRestart();
        Context context = getApplicationContext();
    	CharSequence text = "On Restart";
    	int duration = Toast.LENGTH_SHORT;

    	Toast toast = Toast.makeText(context, text, duration);
    	toast.show();
    	
        setContentView(R.layout.activity_camera);
//camera_preview
        // Create an instance of Camera
        mCamera = getCameraInstance();

        // Create our Preview view and set it as the content of our activity.
        FrameLayout preview;
        mPreview = new CameraPreview(this, mCamera);
        preview = (FrameLayout) findViewById(R.id.camera_preview);
        preview.addView(mPreview);
    	
        /*
    	try {
			mCamera.reconnect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
    	
    	
    	
    }
    
    
    @Override
    public void onStop() {	
    	super.onStop();
    	//mCamera.release();
        Context context = getApplicationContext();
    	CharSequence text = "On Stop";
    	int duration = Toast.LENGTH_SHORT;

    	Toast toast = Toast.makeText(context, text, duration);
    	toast.show();
    	mPreview.stopPreviewAndFreeCamera();
   	//mPreview.stopPreviewAndFreeCamera();
    	
    }
    public void onDestroy() {	
    	super.onDestroy();
    //	mPreview.stopPreviewAndFreeCamera();
        Context context = getApplicationContext();
    	CharSequence text = "On Destroy x_x";
    	int duration = Toast.LENGTH_SHORT;

    	Toast toast = Toast.makeText(context, text, duration);
    	toast.show();
    	
    }
    
}
