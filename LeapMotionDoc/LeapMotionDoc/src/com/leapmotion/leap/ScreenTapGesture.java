package com.leapmotion.leap;

/**
 * The {@code ScreenTapGesture} class represents a tapping gesture by a finger or tool.<p>
 * 
 * A screen tap gesture is recognized when the tip of a finger pokes forward 
 * and then springs back to approximately the original position, 
 * as if tapping a vertical screen. The tapping finger must pause briefly before beginning the tap.<p>
 * 
 * <img src="\images\Leap_Gesture_Tap2.png"/><p>
 * 
 * <b>Important:</b> To use screen tap gestures in your application, 
 * you must enable recognition of the screen tap gesture. You can enable recognition with:
 * 
 * <blockquote><pre>
 * controller.enableGesture(Gesture.Type.TYPE_SCREEN_TAP); 
 * </pre></blockquote>
 * 
 * ScreenTap gestures are discrete. The {@code ScreenTapGesture} object representing a tap always has the state, 
 * STATE_STOP. Only one {@code ScreenTapGesture} object is created for each screen tap gesture recognized.<p>
 * 
 * You can set the minimum finger movement and velocity required for a movement to be recognized 
 * as a screen tap as well as adjust the detection window 
 * for evaluating the movement using the {@link Config} attribute of a connected {@link Controller} object. 
 * Use the following keys to configure screen tap recognition:
 * 
 * <table>
 * <thead>
 * 	<tr>
 * 		<th>Key string</th>
 * 		<th>Value type</th>
 * 		<th>Default value</th>
 * 		<th>Units</th>
 * 	</tr>
 * </thead>
 * <tbody>
 * 	<tr>
 * 		<td>Gesture.ScreenTap.MinForwardVelocity</td><td>float</td><td>50</td><td>mm/s</td>
 * 	</tr>
 *  <tr>
 *  	<td>Gesture.ScreenTap.HistorySeconds</td><td>float</td><td>0.1</td><td>s</td>
 *  </tr>
 *  <tr>
 *  	<td>Gesture.ScreenTap.MinDistance</td><td>float</td><td>5.0</td><td>mm</td>
 *  </tr>
 * </tbody><p>
 * 
 * The following example demonstrates how to set the screen tap configuration parameters:
 * 
 * <blockquote><pre>
 * controller.config().setFloat("Gesture.ScreenTap.MinForwardVelocity", 30.0f);
 * controller.config().setFloat("Gesture.ScreenTap.HistorySeconds", .5f);
 * controller.config().setFloat("Gesture.ScreenTap.MinDistance", 1.0f);
 * controller.config().save(); 
 * </pre></blockquote>
 * 
 * The {@link Controller} object must be connected to the Leap Motion service/daemon 
 * before setting the configuration parameters.
 * 
 * @since 1.0
 * @author Leap Motion Inc
 */
public class ScreenTapGesture extends Gesture {
	private long swigCPtr;

	/**
	 * Constructs a new {@code ScreenTapGesture} object.<p>
	 * 
	 * An uninitialized {@code ScreenTapGesture} object is considered invalid. 
	 * Get valid instances of the {@code ScreenTapGesture} class from a {@link Frame} object.
	 */
	public ScreenTapGesture() {
		this(LeapJNI.new_ScreenTapGesture__SWIG_0(), true);
	}
	
	/**
	 * Constructs a {@code ScreenTapGesture} object from an instance of the {@link Gesture} class.
	 * 
	 * <blockquote><pre>
	 * if(gesture.type() == Gesture.Type.TYPE_SCREEN_TAP) {
	 *     ScreenTapGesture screentapGesture = new ScreenTapGesture(gesture);
	 * }
	 * </pre></blockquote>
	 * 
	 * @param rhs - The {@link Gesture} instance to specialize. 
	 * This {@link Gesture} instance must be a {@code ScreenTapGesture} object.
	 */
	public ScreenTapGesture(Gesture rhs) {
		this(LeapJNI.new_ScreenTapGesture__SWIG_1(Gesture.getCPtr(rhs), rhs), true);
	}
	
	public ScreenTapGesture(long paramLong, boolean paramBoolean)
	{
		super(LeapJNI.ScreenTapGesture_SWIGUpcast(paramLong), paramBoolean);
		this.swigCPtr = paramLong;
	}

	/**
	 * The screen tap gesture type.
	 * 
	 * <blockquote><pre>
	 * if(gesture.type() == ScreenTapGesture.classType()) {
	 *     ScreenTapGesture screentapGesture = new ScreenTapGesture(gesture);
	 * }
	 * </pre></blockquote>
	 * 
	 * @return The type value designating a screen tap gesture.
	 */
	public static Gesture.Type classType() {
		return Gesture.Type.swigToEnum(LeapJNI.ScreenTapGesture_classType());
	}

	/**
	 * The position where the screen tap is registered.
	 * 
	 * <blockquote><pre>
	 * Vector pokeLocation = screentap.position();
	 * </pre></blockquote>
	 * 
	 * @return A {@link Vector} containing the coordinates of screen tap location.
	 */
	public Vector position() {
		return new Vector(LeapJNI.ScreenTapGesture_position(this.swigCPtr, this), true);
	}

	/**
	 * The direction of finger tip motion.
	 * 
	 * <blockquote><pre>
	 * Vector pokeDirection = screentap.direction();
	 * </pre></blockquote>
	 * 
	 * @return A unit direction vector.
	 */
	public Vector direction() {
		return new Vector(LeapJNI.ScreenTapGesture_direction(this.swigCPtr, this), true);
	}

	/**
	 * The progress value is always 1.0 for a screen tap gesture.
	 * 
	 * @return The value 1.0.
	 */
	public float progress() {
		return LeapJNI.ScreenTapGesture_progress(this.swigCPtr, this);
	}

	/**
	 * The finger performing the screen tap gesture.
	 * 
	 * <blockquote><pre>
	 * Pointable poker = screentap.pointable();
	 * </pre></blockquote>
	 * 
	 * @return A {@link Pointable} object representing the tapping finger.
	 */
	public Pointable pointable() {
		return new Pointable(LeapJNI.ScreenTapGesture_pointable(this.swigCPtr, this), true);
	}
	public static long getCPtr(ScreenTapGesture paramScreenTapGesture) {
		return paramScreenTapGesture == null ? 0L : paramScreenTapGesture.swigCPtr;
	}

	protected void finalize() {
		delete();
	}

	public synchronized void delete() {
		if (this.swigCPtr != 0L) {
			if (this.swigCMemOwn) {
				this.swigCMemOwn = false;
				LeapJNI.delete_ScreenTapGesture(this.swigCPtr);
			}
			this.swigCPtr = 0L;
		}
		super.delete();
	}

}
