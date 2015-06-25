package com.leapmotion.leap;

/**
 * The {@code KeyTapGesture} class represents a tapping gesture by a finger or tool.<p>
 * 
 * A key tap gesture is recognized when the tip of a finger rotates down toward the palm 
 * and then springs back to approximately the original position, as if tapping. 
 * The tapping finger must pause briefly before beginning the tap.<p>
 * 
 * <img src="\images\Leap_Gesture_Tap.png"/><p>
 * 
 * <b>Important:</b> To use key tap gestures in your application, 
 * you must enable recognition of the key tap gesture. You can enable recognition with:
 * 
 * <blockquote><pre>
 * controller.enableGesture(Gesture.Type.TYPE_KEY_TAP); 
 * </pre></blockquote>
 * 
 * Key tap gestures are discrete. The {@code KeyTapGesture} object representing a tap always has the state, 
 * STATE_STOP. Only one {@code KeyTapGesture} object is created for each key tap gesture recognized.<p>
 * 
 * You can set the minimum finger movement and velocity required for a movement to be recognized 
 * as a key tap as well as adjust the detection window for evaluating the movement using the {@link Config} 
 * attribute of a connected {@link Controller} object. 
 * Use the following configuration keys to configure key tap recognition:<p>
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
 * 		<td>Gesture.KeyTap.MinDownVelocity</td><td>float</td><td>50</td><td>mm/s</td>
 * 	</tr>
 * 	<tr>
 * 		<td>Gesture.KeyTap.HistorySeconds</td><td>float</td><td>0.1</td><td>s</td>
 * 	</tr>
 *  <tr>
 *  	<td>Gesture.KeyTap.MinDistance</td><td>float</td><td>3.0</td><td>mm</td>
 *  </tr>
 * </tbody>
 * </table><p>
 * 
 * The following example demonstrates how to set the key tap configuration parameters:
 * <blockquote><pre>
 * controller.config().setFloat("Gesture.KeyTap.MinDownVelocity", 40.0f);
 * controller.config().setFloat("Gesture.KeyTap.HistorySeconds", .2f);
 * controller.config().setFloat("Gesture.KeyTap.MinDistance", 1.0f);
 * controller.config().save(); 
 * </pre></blockquote>
 * 
 * The {@link Controller} object must be connected to the Leap Motion service/daemon 
 * before setting the configuration parameters.
 * 
 * @since 1.0
 * @author Leap Motion Inc
 */
public class KeyTapGesture extends Gesture {
	private long swigCPtr;

	/**
	 * Constructs a new {@link KeyTapGesture} object.<p>
	 * 
	 * An uninitialized {@link KeyTapGesture} object is considered invalid. 
	 * Get valid instances of the {@link KeyTapGesture} class from a Frame object.
	 */
	public KeyTapGesture() {
		this(LeapJNI.new_KeyTapGesture__SWIG_0(), true);
	}
	
	/**
	 * Constructs a {@link KeyTapGesture} object from an instance of the {@link Gesture} class.
	 * 
	 * <blockquote><pre>
	 * if(gesture.type() == KeyTapGesture.classType()) {
	 *     KeyTapGesture keytapGesture = new KeyTapGesture(gesture);
	 * }
	 * </pre></blockquote>
	 * 
	 * @param rhs - The {@link Gesture} instance to specialize. 
	 * This {@link Gesture} instance must be a {@link KeyTapGesture} object.
	 */
	public KeyTapGesture(Gesture rhs) {
		this(LeapJNI.new_KeyTapGesture__SWIG_1(Gesture.getCPtr(rhs), rhs), true);
	}

	public KeyTapGesture(long paramLong, boolean paramBoolean)
	{
		super(LeapJNI.KeyTapGesture_SWIGUpcast(paramLong), paramBoolean);
		this.swigCPtr = paramLong;
	}

	/**
	 * The key tap gesture type.
	 * 
	 * <blockquote><pre>
	 * if(gesture.type() == KeyTapGesture.classType()) {
	 *     KeyTapGesture keytapGesture = new KeyTapGesture(gesture);
	 * }
	 * </pre></blockquote>
	 * 
	 * @return The type value designating a key tap gesture.
	 */
	public static Gesture.Type classType() {
		return Gesture.Type.swigToEnum(LeapJNI.KeyTapGesture_classType());
	}

	/**
	 * The position where the key tap is registered.
	 * 
	 * <blockquote><pre>
	 * Vector tapPosition = keytap.position();
	 * </pre></blockquote>
	 * 
	 * @return A {@link Vector} containing the coordinates of tap location.
	 */
	public Vector position() {
		return new Vector(LeapJNI.KeyTapGesture_position(this.swigCPtr, this), true);
	}

	/**
	 * The direction of finger tip motion.
	 * 
	 * <blockquote><pre>
	 * Vector tapDirection = keytap.direction();
	 * </pre></blockquote>
	 * 
	 * @return {@link Vector} A unit direction vector if the finger tip is moving; otherwise, a zero-vector.
	 */
	public Vector direction() {
		return new Vector(LeapJNI.KeyTapGesture_direction(this.swigCPtr, this), true);
	}

	/**
	 * The progress value is always 1.0 for a key tap gesture.
	 * 
	 * @return The value 1.0.
	 */
	public float progress() {
		return LeapJNI.KeyTapGesture_progress(this.swigCPtr, this);
	}

	/**
	 * The finger performing the key tap gesture.
	 * 
	 * <blockquote><pre>
	 * Pointable tappingPointable = keytap.pointable();
	 * </pre></blockquote>
	 * 
	 * @return A {@link Pointable} object representing the tapping finger.
	 */
	public Pointable pointable() {
		return new Pointable(LeapJNI.KeyTapGesture_pointable(this.swigCPtr, this), true);
	}

	public static long getCPtr(KeyTapGesture paramKeyTapGesture) {
		return paramKeyTapGesture == null ? 0L : paramKeyTapGesture.swigCPtr;
	}

	protected void finalize() {
		delete();
	}

	public synchronized void delete() {
		if (this.swigCPtr != 0L) {
			if (this.swigCMemOwn) {
				this.swigCMemOwn = false;
				LeapJNI.delete_KeyTapGesture(this.swigCPtr);
			}
			this.swigCPtr = 0L;
		}
		super.delete();
	}
}
