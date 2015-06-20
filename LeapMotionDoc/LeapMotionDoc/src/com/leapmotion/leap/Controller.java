package com.leapmotion.leap;

import com.leapmotion.leap.Gesture.Type;

/**
 * The {@code Controller} class is your main interface to the Leap Motion {@code Controller}.<p>
 * 
 * Create an instance of this {@code Controller} class to access frames of tracking data and configuration information. 
 * {@link Frame} data can be polled at any time using the {@link Controller#frame()} function. 
 * Call {@code frame()} or {@code frame(0)} to get the most recent frame. Set the history parameter to a positive integer 
 * to access previous frames. A controller stores up to 60 frames in its frame history.<p>
 * 
 * Polling is an appropriate strategy for applications which already have an intrinsic update loop, 
 * such as a game. You can also add an instance of a subclass of {@link Listener} to the controller to 
 * handle events as they occur. The {@code Controller} dispatches events to the listener upon initialization and exiting, 
 * on connection changes, when the application gains and loses the OS input focus, 
 * and when a new frame of tracking data is available. When these events occur, 
 * the controller object invokes the appropriate callback function defined in your subclass of {@link Listener}.<p>
 * 
 * To access frames of tracking data as they become available:<p>
 * 
 * When an instance of a {@link Listener} subclass is added to a {@code Controller} object, 
 * it calls the {@link Listener#onInit(Controller)} function when the listener is ready for use. 
 * When a connection is established between the controller and the Leap Motion software, 
 * the controller calls the {@link Listener#onConnect(Controller)} function. 
 * At this point, your application will start receiving frames of data. The controller calls the 
 * {@link Listener#onFrame(Controller)} function each time a new frame is available. 
 * If the controller loses its connection with the Leap Motion software or device for any reason, 
 * it calls the {@link Listener#onDisconnect(Controller)} function. 
 * If the listener is removed from the controller or the controller is destroyed, 
 * it calls the {@link Listener#onExit(Controller)} function. 
 * At that point, unless the listener is added to another controller again, 
 * it will no longer receive frames of tracking data.<p>
 * 
 * The {@code Controller} object is multithreaded and calls the {@link Listener} functions on its own thread, 
 * not on an application thread.
 * 
 * @since 1.0
 * @author Leap Motion Inc
 *
 */
public class Controller extends Interface {
	private long swigCPtr;

	/**
	 * Constructs a {@code Controller} object.<p>
	 * 
	 * When creating a {@code Controller} object, you may optionally pass in a reference to 
	 * an instance of a subclass of {@link Listener}. 
	 * Alternatively, you may add a listener using the {@link Controller#addListener(Listener)} function.
	 */
	public Controller() {
		this(LeapJNI.new_Controller__SWIG_0(), true);
	}

	/**
	 * Constructs a {@code Controller} object.<p>
	 * 
	 * When creating a {@code Controller} object, you may optionally pass in a reference to 
	 * an instance of a subclass of {@link Listener}. 
	 * Alternatively, you may add a listener using the {@link Controller#addListener(Listener)} function.
	 * 
	 * <blockquote><pre>
	 * SampleListener listenerSubclass = new SampleListener();
	 * Controller leapController = new Controller(listenerSubclass);
	 * </pre></blockquote>
	 * 
	 * @param listener - An instance of {@link Listener} implementing the callback functions for 
	 * the Leap Motion events you want to handle in your application.
	 */
	public Controller(Listener listener) {
		this(LeapJNI.new_Controller__SWIG_1(Listener.getCPtr(listener), listener), true);
	}
	
	public Controller(long paramLong, boolean paramBoolean)
	{
		super(LeapJNI.Controller_SWIGUpcast(paramLong), paramBoolean);
		this.swigCPtr = paramLong;
	}

	/**
	 * Reports whether this {@code Controller} is connected to the Leap Motion service and the 
	 * Leap Motion hardware is plugged in.<p>
	 * 
	 * When you first create a {@code Controller} object, {@code isConnected()} returns false. 
	 * After the controller finishes initializing and connects to the Leap Motion software and if the 
	 * Leap Motion hardware is plugged in, {@code isConnected()} returns true.<p>
	 * 
	 * You can either handle the onConnect event using a {@link Listener} instance or poll the {@code isConnected()} 
	 * function if you need to wait for your application to be connected to the Leap Motion software 
	 * before performing some other operation.
	 * 
	 * <blockquote><pre>
	 * if(controller.isConnected()){
	 *     //perform action that requires a connected controller
	 * }
	 * </pre></blockquote>
	 * 
	 * @return True, if connected; false otherwise.
	 */
	public boolean isConnected() {
		return LeapJNI.Controller_isConnected(this.swigCPtr, this);
	}

	/**
	 * Reports whether your application has a connection to the Leap Motion daemon/service.<p>
	 * 
	 * Can be true even if the Leap Motion hardware is not available.
	 * 
	 * @return whether your application has a connection to the Leap Motion daemon/service
	 */
	public boolean isServiceConnected() {
		return LeapJNI.Controller_isServiceConnected(this.swigCPtr, this);
	}

	/**
	 * Reports whether this application is the focused, foreground application.<p>
	 * 
	 * By default, your application only receives tracking information from the Leap Motion controller 
	 * when it has the operating system input focus. 
	 * To receive tracking data when your application is in the background, 
	 * the background frames policy flag must be set.
	 * 
	 * <blockquote><pre>
	 * if(controller.hasFocus()){
	 *     //perform action that requires application to be focused
	 * }
	 * </pre></blockquote>
	 * 
	 * @see Controller#setPolicyFlags(PolicyFlag)
	 * 
	 * @return True, if application has focus; false otherwise.
	 */
	public boolean hasFocus() {
		return LeapJNI.Controller_hasFocus(this.swigCPtr, this);
	}

	/**
	 * This function has been deprecated.<p>
	 * 
	 * Use {@link Controller#isPolicySet(PolicyFlag)} instead. 
	 */
	@Deprecated
	public PolicyFlag policyFlags() {
		return PolicyFlag.swigToEnum(LeapJNI.Controller_policyFlags(this.swigCPtr, this));
	}

	/**
	 * This function has been deprecated.<p>
	 * 
	 * Use {@link Controller#setPolicy(PolicyFlag)} and {@link Controller#clearPolicy(PolicyFlag)} instead. 
	 */
	@Deprecated
	public void setPolicyFlags(PolicyFlag paramPolicyFlag) {
		LeapJNI.Controller_setPolicyFlags(this.swigCPtr, this, paramPolicyFlag.swigValue());
	}
	
	/**
	 * Requests setting a policy.<p>
	 * 
	 * A request to change a policy is subject to user approval and a policy can be changed 
	 * by the user at any time (using the Leap Motion settings dialog). 
	 * The desired policy flags must be set every time an application runs.<p>
	 * 
	 * Policy changes are completed asynchronously and, because they are subject to user approval 
	 * or system compatibility checks, may not complete successfully. Call {@link Controller#isPolicySet(PolicyFlag)} 
	 * after a suitable interval to test whether the change was accepted.
	 * 
	 * <blockquote><pre>
	 * controller.setPolicy(Controller.PolicyFlag.POLICY_BACKGROUND_FRAMES);
	 * controller.setPolicy(Controller.PolicyFlag.POLICY_IMAGES);
	 * controller.setPolicy(Controller.PolicyFlag.POLICY_OPTIMIZE_HMD);
	 * </pre></blockquote>
	 * 
	 * @param policy - A PolicyFlag value indicating the policy to request.
	 */
	public void setPolicy(PolicyFlag policy) {
		LeapJNI.Controller_setPolicy(this.swigCPtr, this, policy.swigValue());
	}

	/**
	 * Requests clearing a policy.<p>
	 * 
	 * Policy changes are completed asynchronously and, because they are subject to user approval 
	 * or system compatibility checks, may not complete successfully. 
	 * Call {@link Controller#isPolicySet(PolicyFlag)} after a suitable interval to test whether the change was accepted.
	 * 
	 * <blockquote><pre>
	 * controller.clearPolicy(Controller.PolicyFlag.POLICY_OPTIMIZE_HMD);
	 * </pre></blockquote>
	 * 
	 * @param flags - A {@link PolicyFlag} value indicating the policy to request.
	 */
	public void clearPolicy(PolicyFlag flags) {
		LeapJNI.Controller_clearPolicy(this.swigCPtr, this, flags.swigValue());
	}

	/**
	 * Gets the active setting for a specific policy.<p>
	 * 
	 * Keep in mind that setting a policy flag is asynchronous, 
	 * so changes are not effective immediately after calling {@code setPolicyFlag()}. 
	 * In addition, a policy request can be declined by the user. 
	 * You should always set the policy flags required by your application at startup and check 
	 * that the policy change request was successful after an appropriate interval.<p>
	 * 
	 * If the controller object is not connected to the Leap Motion software, 
	 * then the default state for the selected policy is returned.
	 * 
	 * <blockquote><pre>
	 * Boolean isImagePolicySet = controller.isPolicySet(Controller.PolicyFlag.POLICY_IMAGES);
	 * </pre></blockquote>
	 * 
	 * @param flags - A PolicyFlag value indicating the policy to query.
	 * 
	 * @return A boolean indicating whether the specified policy has been set.
	 */
	public boolean isPolicySet(PolicyFlag flags) {
		return LeapJNI.Controller_isPolicySet(this.swigCPtr, this, flags.swigValue());
	}

	/**
	 * Adds a listener to this {@code Controller}.<p>
	 * 
	 * The {@code Controller} dispatches Leap Motion events to each associated listener. 
	 * The order in which listener callback functions are invoked is arbitrary. 
	 * If you pass a listener to the {@code Controller}‘s constructor function, 
	 * it is automatically added to the list and can be removed with the {@link Controller#removeListener(Listener)} function.
	 * 
	 * <blockquote><pre>
	 * SampleListener listener = new SampleListener();
	 * controller.addListener(listener);
	 * </pre></blockquote>
	 * 
	 * The {@code Controller} does not keep a strong reference to the {@link Listener} instance. 
	 * Ensure that you maintain a reference until the listener is removed from the controller.
	 * 
	 * @param listener - A subclass of {@link Listener} implementing the callback functions for 
	 * the Leap Motion events you want to handle in your application.
	 * 
	 * @return Whether or not the listener was successfully added to the list of listeners.
	 */
	public boolean addListener(Listener listener) {
		return LeapJNI.Controller_addListener(this.swigCPtr, this, Listener.getCPtr(listener), listener);
	}

	/**
	 * Remove a listener from the list of listeners that will receive Leap Motion events.<p>
	 * 
	 * A listener must be removed if its lifetime is shorter than the controller to which it is listening.
	 * 
	 * <blockquote><pre>
	 * SampleListener listenerObject = new SampleListener();
	 * controller.addListener(listenerObject);
	 * 
	 * // ... much later
	 * controller.removeListener(listenerObject);
	 * </pre></blockquote>
	 * 
	 * @param listener - The listener to remove.
	 * 
	 * @return Whether or not the listener was successfully removed from the list of listeners.
	 */
	public boolean removeListener(Listener listener) {
		return LeapJNI.Controller_removeListener(this.swigCPtr, this, Listener.getCPtr(listener), listener);
	}

	/**
	 * Returns a frame of tracking data from the Leap Motion software.<p>
	 * 
	 * Use the optional history parameter to specify which frame to retrieve. 
	 * Call {@link Controller#frame()} or {@code frame(0)} to access the most recent frame; 
	 * call {@code frame(1)} to access the previous frame, and so on. 
	 * If you use a history value greater than the number of stored frames, 
	 * then the controller returns an invalid frame.
	 * 
	 * <blockquote><pre>
	 * if(controller.isConnected()) { //controller is a Controller object
	 *     Frame frame = controller.frame(); //The latest frame
	 *     Frame previous = controller.frame(1); //The previous frame
	 * }
	 * </pre></blockquote>
	 * 
	 * You can call this function in your Listener implementation to get frames at the Leap Motion frame rate:
	 * 
	 * <blockquote><pre>
	 * class FrameListener extends Listener {
	 *     public void onFrame(Controller controller) {
	 *        Frame frame = controller.frame(); //The latest frame
	 *        Frame previous = controller.frame(1); //The previous frame
	 *        //...
	 *     }
	 * }
	 * </pre></blockquote>
	 * 
	 * @param history - The age of the frame to return, counting backwards from the most recent frame (0) 
	 * into the past and up to the maximum age (59).
	 * 
	 * @return The specified frame; or, if no history parameter is specified, the newest frame. 
	 * If a frame is not available at the specified history position, an invalid {@link Frame} is returned.
	 */
	public Frame frame(int history) {
		return new Frame(LeapJNI.Controller_frame__SWIG_0(this.swigCPtr, this, history), true);
	}

	/**
	 * Returns a frame of tracking data from the Leap Motion software.<p>
	 * 
	 * Use the optional history parameter to specify which frame to retrieve. 
	 * Call {@link Controller#frame()} or {@code frame(0)} to access the most recent frame; 
	 * call {@code frame(1)} to access the previous frame, and so on. 
	 * If you use a history value greater than the number of stored frames, 
	 * then the controller returns an invalid frame.
	 * 
	 * <blockquote><pre>
	 * if(controller.isConnected()) { //controller is a Controller object
	 *     Frame frame = controller.frame(); //The latest frame
	 *     Frame previous = controller.frame(1); //The previous frame
	 * }
	 * </pre></blockquote>
	 * 
	 * You can call this function in your Listener implementation to get frames at the Leap Motion frame rate:
	 * 
	 * <blockquote><pre>
	 * class FrameListener extends Listener {
	 *     public void onFrame(Controller controller) {
	 *        Frame frame = controller.frame(); //The latest frame
	 *        Frame previous = controller.frame(1); //The previous frame
	 *        //...
	 *     }
	 * }
	 * </pre></blockquote>
	 * 
	 * @return The specified frame; or, if no history parameter is specified, the newest frame. 
	 * If a frame is not available at the specified history position, an invalid {@link Frame} is returned.
	 */
	public Frame frame() {
		return new Frame(LeapJNI.Controller_frame__SWIG_1(this.swigCPtr, this), true);
	}

	/**
	 * The most recent set of images from the Leap Motion cameras.
	 * 
	 * <blockquote><pre>
	 * ImageList images = controller.images();
	 * </pre></blockquote>
	 * 
	 * Depending on timing and the current processing frame rate, 
	 * the images obtained with this function can be newer than images obtained from the current frame of tracking data.
	 * 
	 * @return An {@link ImageList} object containing the most recent camera images.
	 */
	public ImageList images() {
		return new ImageList(LeapJNI.Controller_images(this.swigCPtr, this), true);
	}

	/**
	 * Returns a {@link Config} object, which you can use to query the Leap Motion system for configuration information.
	 * 
	 * <blockquote><pre>
	 * controller.config().setFloat("Gesture.Circle.MinRadius", 15f);
	 * controller.config().setFloat("Gesture.Circle.MinArc", 2f);
	 * boolean saved = controller.config().save();
	 * </pre></blockquote>
	 * 
	 * @return The {@code Controller}‘s {@link Config} object.
	 */
	public Config config() {
		return new Config(LeapJNI.Controller_config(this.swigCPtr, this), true);
	}

	/**
	 * The list of currently attached and recognized Leap Motion controller devices.<p>
	 * 
	 * The {@link Device} objects in the list describe information such as the range and tracking volume.
	 * 
	 * <blockquote><pre>
	 * DeviceList connectedLeaps = controller.devices();
	 * </pre></blockquote>
	 * 
	 * Currently, the Leap Motion {@code Controller} only allows a single active device at a time, 
	 * however there may be multiple devices physically attached and listed here. 
	 * Any active device(s) are guaranteed to be listed first, however order is not determined beyond that.
	 * 
	 * @return The list of Leap Motion controllers.
	 */
	public DeviceList devices() {
		return new DeviceList(LeapJNI.Controller_devices(this.swigCPtr, this), true);
	}

	public ScreenList locatedScreens() {
		return new ScreenList(LeapJNI.Controller_locatedScreens(this.swigCPtr, this), true);
	}

	public BugReport bugReport() {
		return new BugReport(LeapJNI.Controller_bugReport(this.swigCPtr, this), true);
	}

	/**
	 * Enables or disables reporting of a specified gesture type.<p>
	 * 
	 * By default, all gesture types are disabled. 
	 * When disabled, gestures of the disabled type are never reported and will not appear in the frame gesture list.
	 * 
	 * <blockquote><pre>
	 * controller.enableGesture(Gesture.Type.TYPE_CIRCLE, true);
	 * </pre></blockquote>
	 * 
	 * As a performance optimization, only enable recognition for the types of movements that you use in your application.<p>
	 * 
	 * @see Controller#isGestureEnabled(Type)
	 * 
	 * @param type - The type of gesture to enable or disable. Must be a member of the {@link Type} enumeration.
	 * @param enable - True, to enable the specified gesture type; False, to disable.
	 */
	public void enableGesture(Gesture.Type type, boolean enable) {
		LeapJNI.Controller_enableGesture__SWIG_0(this.swigCPtr, this, type.swigValue(), enable);
	}

	/**
	 * Enables or disables reporting of a specified gesture type.<p>
	 * 
	 * By default, all gesture types are disabled. 
	 * When disabled, gestures of the disabled type are never reported and will not appear in the frame gesture list.
	 * 
	 * <blockquote><pre>
	 * controller.enableGesture(Gesture.Type.TYPE_CIRCLE);
	 * </pre></blockquote>
	 * 
	 * As a performance optimization, only enable recognition for the types of movements that you use in your application.<p>
	 * 
	 * @see Controller#isGestureEnabled(Type)
	 * 
	 * @param type - The type of gesture to enable or disable. Must be a member of the {@link Type} enumeration.
	 */
	public void enableGesture(Gesture.Type type) {
		LeapJNI.Controller_enableGesture__SWIG_1(this.swigCPtr, this, type.swigValue());
	}

	/**
	 * Reports whether the specified gesture type is enabled.
	 * 
	 * <blockquote><pre>
	 * if(!controller.isGestureEnabled(Gesture.Type.TYPE_SWIPE)){
	 *     controller.enableGesture(Gesture.Type.TYPE_SWIPE);
	 * }
	 * </pre></blockquote>
	 * 
	 * @see Controller#enableGesture(Type)
	 * 
	 * @param type - The type of gesture to check; a member of the Gesture::Type enumeration.
	 * 
	 * @return True, if the specified type is enabled; false, otherwise.
	 */
	public boolean isGestureEnabled(Gesture.Type type) {
		return LeapJNI.Controller_isGestureEnabled(this.swigCPtr, this, type.swigValue());
	}

	/**
	 * <b>Note:</b> This class is an experimental API for internal use only.<p>
	 * 
	 * It may be removed without warning.<p>
	 * 
	 * @return information about the currently detected quad in the scene.
	 * If no quad is being tracked, then an invalid {@link TrackedQuad} is returned.
	 */
	public TrackedQuad trackedQuad() {
		return new TrackedQuad(LeapJNI.Controller_trackedQuad(this.swigCPtr, this), true);
	}

	public static long getCPtr(Controller paramController) {
		return paramController == null ? 0L : paramController.swigCPtr;
	}

	protected void finalize() {
		delete();
	}

	public synchronized void delete() {
		if (this.swigCPtr != 0L) {
			if (this.swigCMemOwn) {
				this.swigCMemOwn = false;
				LeapJNI.delete_Controller(this.swigCPtr);
			}
			this.swigCPtr = 0L;
		}
		super.delete();
	}
	
	/**
	 * The supported controller policies.<p>
	 * 
	 * The supported policy flags are:<p>
	 * 
	 * <b>POLICY_BACKGROUND_FRAMES</b> requests that your application receives frames when it is not 
	 * the foreground application for user input.<p>
	 * 
	 * The background frames policy determines whether an application receives frames of tracking data 
	 * while in the background. By default, the Leap Motion software only sends tracking data to 
	 * the foreground application. Only applications that need this ability should request 
	 * the background frames policy. The “Allow Background Apps” checkbox must be enabled 
	 * in the Leap Motion Control Panel or this policy will be denied.<p>
	 * 
	 * <b>POLICY_IMAGES</b> request that your application receives images from the device cameras. 
	 * The “Allow Images” checkbox must be enabled in the Leap Motion Control Panel or this policy will be denied.<p>
	 * 
	 * The images policy determines whether an application receives image data from the Leap Motion sensors 
	 * which each frame of data. By default, this data is not sent. 
	 * Only applications that use the image data should request this policy.<p>
	 * 
	 * <b>POLICY_OPTIMIZE_HMD</b> request that the tracking be optimized for head-mounted tracking.<p>
	 * 
	 * The optimize HMD policy improves tracking in situations where the Leap Motion hardware 
	 * is attached to a head-mounted display. This policy is not granted for devices that 
	 * cannot be mounted to an HMD, such as Leap Motion controllers embedded in a laptop or keyboard.<p>
	 * 
	 * Some policies can be denied if the user has disabled the feature on their Leap Motion control panel.
	 * 
	 * @Since 1.0
	 * @author Leap Motion Inc
	 */
	public static enum PolicyFlag {
		POLICY_DEFAULT(0), 
		POLICY_BACKGROUND_FRAMES(1), 
		POLICY_IMAGES(2), 
		POLICY_OPTIMIZE_HMD(4);

		public final int swigValue() {
			return this.swigValue;
		}

		public static PolicyFlag swigToEnum(int paramInt) {
			PolicyFlag[] arrayOfPolicyFlag1 = (PolicyFlag[])PolicyFlag.class.getEnumConstants();
			if ((paramInt < arrayOfPolicyFlag1.length) && (paramInt >= 0) && (arrayOfPolicyFlag1[paramInt].swigValue == paramInt))
				return arrayOfPolicyFlag1[paramInt];
			for (PolicyFlag localPolicyFlag : arrayOfPolicyFlag1)
				if (localPolicyFlag.swigValue == paramInt)
					return localPolicyFlag;
			throw new IllegalArgumentException("No enum " + PolicyFlag.class + " with value " + paramInt);
		}

		private PolicyFlag()
		{
			this.swigValue = SwigNext.access$008();
		}

		private PolicyFlag(int paramInt)
		{
			this.swigValue = paramInt;
			SwigNext.access$002(paramInt + 1);
		}

		private PolicyFlag(PolicyFlag paramPolicyFlag)
		{
			this.swigValue = paramPolicyFlag.swigValue;
			SwigNext.access$002(this.swigValue + 1);
		}

		private final int swigValue;
		private static class SwigNext
		{
			private static int next = 0;
		}
	}
}
