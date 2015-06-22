package com.leapmotion.leap;

/**
 * 
 * The {@code Listener} class defines a set of callback functions that you can override in a subclass 
 * to respond to events dispatched by the {@link Controller} object.<p>
 * 
 * To handle Leap Motion events, create an instance of a {@code Listener} subclass and assign it to 
 * the {@link Controller} instance. The {@link Controller} calls the relevant Listener callback function 
 * when an event occurs, passing in a reference to itself. 
 * You do not have to implement callbacks for events you do not want to handle.<p>
 * 
 * The {@link Controller} object calls these {@code Listener} functions from a thread 
 * created by the Leap Motion library, not the thread used to create or set the {@code Listener} instance.
 * 
 * @since 1.0 
 * @author Leap Motion Inc
 */
public class Listener {
	private long swigCPtr;
	protected boolean swigCMemOwn;

	/**
	 * Constructs a {@code Listener} object.
	 */
	public Listener() {
		this(LeapJNI.new_Listener(), true);
		LeapJNI.Listener_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
	}
	
	public Listener(long paramLong, boolean paramBoolean) {
		this.swigCMemOwn = paramBoolean;
		this.swigCPtr = paramLong;
	}

	protected void swigDirectorDisconnect() {
		this.swigCMemOwn = false;
		delete();
	}

	public void swigReleaseOwnership() {
		this.swigCMemOwn = false;
		LeapJNI.Listener_change_ownership(this, this.swigCPtr, false);
	}

	public void swigTakeOwnership() {
		this.swigCMemOwn = true;
		LeapJNI.Listener_change_ownership(this, this.swigCPtr, true);
	}

	/**
	 * Called once, when this {@code Listener} object is newly added to a {@link Controller}.
	 * 
	 * <blockquote><pre>
	 * public void onInit (Controller controller){
	 *     System.out.println("Initialized");
	 * }
	 * </pre></blockquote>
	 * 
	 * @param controller - The {@link Controller} object invoking this callback function.
	 */
	public void onInit(Controller controller) {
		if (getClass() == Listener.class) LeapJNI.Listener_onInit(this.swigCPtr, this, Controller.getCPtr(controller), controller); else LeapJNI.Listener_onInitSwigExplicitListener(this.swigCPtr, this, Controller.getCPtr(controller), controller);
	}

	/**
	 * Called when the {@link Controller} object connects to the Leap Motion software 
	 * and the Leap Motion hardware device is plugged in, or when this {@code Listener} object is added 
	 * to a {@link Controller} that is already connected.<p>
	 * 
	 * When this callback is invoked, {@link Controller#isServiceConnected()} is true, 
	 * {@link Controller#addListener(Listener)} is not empty, and, for at least one of the {@link Device} 
	 * objects in the list, {@link Device#baseline()} is true.
	 * 
	 * <blockquote><pre>
	 * public void onConnect (Controller controller){
	 *     System.out.println("Connected");
	 * }
	 * </pre></blockquote>
	 * 
	 * @param controller - The {@link Controller} object invoking this callback function.
	 */
	public void onConnect(Controller controller) {
		if (getClass() == Listener.class) LeapJNI.Listener_onConnect(this.swigCPtr, this, Controller.getCPtr(controller), controller); else LeapJNI.Listener_onConnectSwigExplicitListener(this.swigCPtr, this, Controller.getCPtr(controller), controller);
	}

	/**
	 * Called when the {@link Controller} object disconnects from the Leap Motion software 
	 * or the Leap Motion hardware is unplugged.<p>
	 * 
	 * The controller can disconnect when the Leap Motion device is unplugged, 
	 * the user shuts the Leap Motion software down, or the Leap Motion software encounters an unrecoverable error.
	 * 
	 * <blockquote><pre>
	 * public void onDisconnect (Controller controller){
	 *     System.out.println("Disconnected");
	 * }
	 * </pre></blockquote>
	 * 
	 * Note: When you launch a Leap-enabled application in a debugger, 
	 * the Leap Motion library does not disconnect from the application. 
	 * This is to allow you to step through code without losing the connection because of time outs.<p>
	 * 
	 * @param controller - The {@link Controller} object invoking this callback function.
	 */
	public void onDisconnect(Controller controller) {
		if (getClass() == Listener.class) LeapJNI.Listener_onDisconnect(this.swigCPtr, this, Controller.getCPtr(controller), controller); else LeapJNI.Listener_onDisconnectSwigExplicitListener(this.swigCPtr, this, Controller.getCPtr(controller), controller);
	}

	/**
	 * Called when this {@code Listener} object is removed from the {@link Controller} 
	 * or the {@link Controller} instance is destroyed.
	 * 
	 * <blockquote><pre>
	 * public void onExit (Controller controller){
	 *     System.out.println("Exited");
	 * }
	 * </pre></blockquote>
	 * 
	 * @param controller - The {@link Controller} object invoking this callback function.
	 */
	public void onExit(Controller controller) {
		if (getClass() == Listener.class) LeapJNI.Listener_onExit(this.swigCPtr, this, Controller.getCPtr(controller), controller); else LeapJNI.Listener_onExitSwigExplicitListener(this.swigCPtr, this, Controller.getCPtr(controller), controller);
	}

	/**
	 * Called when a new frame of hand and finger tracking data is available.<p>
	 * 
	 * Access the new frame data using the {@link Controller#frame()} function.
	 * 
	 * <blockquote><pre>
	 * public void onFrame (Controller controller){
	 *     System.out.println("New Frame");
	 * }
	 * </pre></blockquote>
	 * 
	 * Note, the {@link Controller} skips any pending {@code onFrame()} events while 
	 * your {@code onFrame()} handler executes. 
	 * If your implementation takes too long to return, one or more frames can be skipped. 
	 * The {@link Controller} still inserts the skipped frames into the frame history. 
	 * You can access recent frames by setting the history parameter when calling the {@link Controller#frame()} function. 
	 * You can determine if any pending onFrame events were skipped by comparing the ID 
	 * of the most recent frame with the ID of the last received frame.
	 * 
	 * @param controller - The {@link Controller} object invoking this callback function.
	 */
	public void onFrame(Controller controller) {
		if (getClass() == Listener.class) LeapJNI.Listener_onFrame(this.swigCPtr, this, Controller.getCPtr(controller), controller); else LeapJNI.Listener_onFrameSwigExplicitListener(this.swigCPtr, this, Controller.getCPtr(controller), controller);
	}

	/**
	 * Called when this application becomes the foreground application.<p>
	 * 
	 * Only the foreground application receives tracking data from the Leap Motion {@link Controller}. 
	 * This function is only called when the controller object is in a connected state.
	 * 
	 * <blockquote><pre>
	 * public void onFocusGained (Controller controller){
	 *     System.out.println("Focus gained");
	 * }
	 * </pre></blockquote>
	 * 
	 * @param controller - The {@link Controller} object invoking this callback function.
	 */
	public void onFocusGained(Controller controller) {
		if (getClass() == Listener.class) LeapJNI.Listener_onFocusGained(this.swigCPtr, this, Controller.getCPtr(controller), controller); else LeapJNI.Listener_onFocusGainedSwigExplicitListener(this.swigCPtr, this, Controller.getCPtr(controller), controller);
	}

	/**
	 * Called when this application loses the foreground focus.<p>
	 * 
	 * Only the foreground application receives tracking data from the Leap Motion {@link Controller}. 
	 * This function is only called when the controller object is in a connected state.
	 * 
	 * <blockquote><pre>
	 * public void onFocusLost (Controller controller){
	 *     System.out.println("Focus lost");
	 * }
	 * </pre></blockquote>
	 * 
	 * @param controller - The {@link Controller} object invoking this callback function.
	 */
	public void onFocusLost(Controller controller) {
		if (getClass() == Listener.class) LeapJNI.Listener_onFocusLost(this.swigCPtr, this, Controller.getCPtr(controller), controller); else LeapJNI.Listener_onFocusLostSwigExplicitListener(this.swigCPtr, this, Controller.getCPtr(controller), controller);
	}

	/**
	 * Called when the Leap Motion daemon/service connects to your application {@link Controller}.
	 * 
	 * <blockquote><pre>
	 * public void  onServiceConnect (Controller controller){
	 *     System.out.println("Service connected");
	 * }
	 * </pre></blockquote>
	 * 
	 * @param controller - The {@link Controller} object invoking this callback function.
	 */
	public void onServiceConnect(Controller controller) {
		if (getClass() == Listener.class) LeapJNI.Listener_onServiceConnect(this.swigCPtr, this, Controller.getCPtr(controller), controller); else LeapJNI.Listener_onServiceConnectSwigExplicitListener(this.swigCPtr, this, Controller.getCPtr(controller), controller);
	}

	/**
	 * Called if the Leap Motion daemon/service disconnects from your application {@link Controller}.<p>
	 * 
	 * Normally, this callback is not invoked. It is only called if some external event or problem 
	 * shuts down the service or otherwise interrupts the connection.
	 * 
	 * <blockquote><pre>
	 * public void  onServiceDisconnect (Controller controller){
	 *     System.out.println("Service connection lost");
	 * }
	 * </pre></blockquote>
	 * 
	 * @param controller - The {@link Controller} object invoking this callback function.
	 */
	public void onServiceDisconnect(Controller controller) {
		if (getClass() == Listener.class) LeapJNI.Listener_onServiceDisconnect(this.swigCPtr, this, Controller.getCPtr(controller), controller); else LeapJNI.Listener_onServiceDisconnectSwigExplicitListener(this.swigCPtr, this, Controller.getCPtr(controller), controller);
	}

	/**
	 * Called when a Leap Motion controller plugged in, unplugged, or the device changes state.<p>
	 * 
	 * State changes include changes in frame rate and entering or leaving “robust” mode. 
	 * Note that there is currently no way to query whether a device is in robust mode. 
	 * You can use {@link Frame#currentFramesPerSecond()} to get the framerate.
	 * 
	 * <blockquote><pre>
	 * public void  onDeviceChange (Controller controller){
	 *     System.out.println("Device changed");
	 * }
	 * </pre></blockquote>
	 * 
	 * @param controller - The {@link Controller} object invoking this callback function.
	 */
	public void onDeviceChange(Controller controller) {
		if (getClass() == Listener.class) LeapJNI.Listener_onDeviceChange(this.swigCPtr, this, Controller.getCPtr(controller), controller); else LeapJNI.Listener_onDeviceChangeSwigExplicitListener(this.swigCPtr, this, Controller.getCPtr(controller), controller);
	}

	/**
	 * Called when new images are available.<p>
	 * 
	 * Access the new frame data using the {@link Controller#images()} function.
	 * 
	 * <blockquote><pre>
	 * public void  onImages (Controller controller){
	 *     System.out.println("New images available");
	 * }
	 * </pre></blockquote>
	 * 
	 * @param controller - The {@link Controller} object invoking this callback function.
	 */
	public void onImages(Controller controller) {
		if (getClass() == Listener.class) LeapJNI.Listener_onImages(this.swigCPtr, this, Controller.getCPtr(controller), controller); else LeapJNI.Listener_onImagesSwigExplicitListener(this.swigCPtr, this, Controller.getCPtr(controller), controller);
	}

	public static long getCPtr(Listener paramListener) {
		return paramListener == null ? 0L : paramListener.swigCPtr;
	}

	protected void finalize() {
		delete();
	}

	public synchronized void delete() {
		if (this.swigCPtr != 0L) {
			if (this.swigCMemOwn) {
				this.swigCMemOwn = false;
				LeapJNI.delete_Listener(this.swigCPtr);
			}
			this.swigCPtr = 0L;
		}
	}
}
