package com.leapmotion.leap;

/**
 * The {@code SwipeGesture} class represents a swiping motion a finger or tool.<p>
 * 
 * <img src="\images\Leap_Gesture_Swipe.png"/><p>
 * 
 * {@code SwipeGesture} objects are generated for each visible finger or tool. 
 * Swipe gestures are continuous; a gesture object with the same ID value will appear in each frame 
 * while the gesture continues.
 * 
 * <b>Important:</b> To use swipe gestures in your application, 
 * you must enable recognition of the swipe gesture. You can enable recognition with:
 * 
 * <blockquote><pre>
 * controller.enableGesture(Gesture.Type.TYPE_SWIPE);
 * </pre></blockquote>
 * 
 * You can set the minimum length and velocity required for a movement 
 * to be recognized as a swipe using the {@link Config} attribute of a connected {@link Controller} object. 
 * Use the following keys to configure swipe recognition:
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
 * 		<td>Gesture.Swipe.MinLength</td><td>float</td><td>150</td><td>mm</td>
 * 	</tr>
 *  <tr>
 *  	<td>Gesture.Swipe.MinVelocity</td><td>float</td><td>1000</td><td>mm/s</td>
 *  </tr>
 * </tbody><p>
 * 
 * The following example demonstrates how to set the swipe configuration parameters:
 * 
 * <blockquote><pre>
 * controller.config().setFloat("Gesture.Swipe.MinLength", 200.0f);
 * controller.config().setFloat("Gesture.Swipe.MinVelocity", 750f);
 * controller.config().save();
 * </pre></blockquote>
 * 
 * The {@link Controller} object must be connected to the Leap Motion service/daemon 
 * before setting the configuration parameters.
 * 
 * @since 1.0
 * @author Leap Motion Inc
 */
public class SwipeGesture extends Gesture {
	private long swigCPtr;

	/**
	 * Constructs a new {@link SwipeGesture} object.<p>
	 * 
	 * An uninitialized {@link SwipeGesture} object is considered invalid. 
	 * Get valid instances of the {@link SwipeGesture} class from a {@link Frame} object.
	 */
	public SwipeGesture() {
		this(LeapJNI.new_SwipeGesture__SWIG_0(), true);
	}

	/**
	 * Constructs a {@link SwipeGesture} object from an instance of the {@link Gesture} class.
	 * 
	 * <blockquote><pre>
	 * if(gesture.type() == Gesture.Type.TYPE_SWIPE) {
	 *     SwipeGesture swipeGesture = new SwipeGesture(gesture);
	 * }
	 * </pre></blockquote>
	 * 
	 * @param rhs - The {@link Gesture} instance to specialize. 
	 * This {@link Gesture} instance must be a {@link SwipeGesture} object.
	 */
	public SwipeGesture(Gesture rhs) {
		this(LeapJNI.new_SwipeGesture__SWIG_1(Gesture.getCPtr(rhs), rhs), true);
	}
	
	public SwipeGesture(long paramLong, boolean paramBoolean) {
		super(LeapJNI.SwipeGesture_SWIGUpcast(paramLong), paramBoolean);
		this.swigCPtr = paramLong;
	}

	/**
	 * The swipe gesture type.
	 * 
	 * <blockquote><pre>
	 * if(gesture.type() == SwipeGesture.classType()) {
	 *     SwipeGesture swipeGesture = new SwipeGesture(gesture);
	 * }
	 * </pre></blockquote>
	 * 
	 * @return The type value designating a swipe gesture.
	 */
	public static Gesture.Type classType() {
		return Gesture.Type.swigToEnum(LeapJNI.SwipeGesture_classType());
	}

	/**
	 * The position where the swipe began.
	 * 
	 * <blockquote><pre>
	 * Vector swipeStart = swipe.startPosition();
	 * </pre></blockquote>
	 * 
	 * @return The starting position within the Leap Motion frame of reference, in mm.
	 */
	public Vector startPosition() {
		return new Vector(LeapJNI.SwipeGesture_startPosition(this.swigCPtr, this), true);
	}

	/**
	 * The current position of the swipe.
	 * 
	 * <blockquote><pre>
	 * Vector currentSwipePosition = swipe.position();
	 * </pre></blockquote>
	 * 
	 * @return The current swipe position within the Leap Motion frame of reference, in mm.
	 */
	public Vector position() {
		return new Vector(LeapJNI.SwipeGesture_position(this.swigCPtr, this), true);
	}

	/**
	 * The unit direction vector parallel to the swipe motion.
	 * 
	 * <blockquote><pre>
	 * Vector swipeDirection = swipe.direction();
	 * </pre></blockquote>
	 * 
	 * You can compare the components of the vector to classify the swipe 
	 * as appropriate for your application. For example, if you are using swipes 
	 * for two dimensional scrolling, you can compare the x and y values to determine 
	 * if the swipe is primarily horizontal or vertical.
	 * 
	 * @return The unit direction vector representing the swipe motion.
	 */
	public Vector direction() {
		return new Vector(LeapJNI.SwipeGesture_direction(this.swigCPtr, this), true);
	}

	/**
	 * The swipe speed in mm/second.
	 * 
	 * <blockquote><pre>
	 * float currentSwipeSpeed = swipe.speed();
	 * </pre></blockquote>
	 * 
	 * @return The speed of the finger performing the swipe gesture in millimeters per second.
	 */
	public float speed() {
		return LeapJNI.SwipeGesture_speed(this.swigCPtr, this);
	}

	/**
	 * The finger performing the swipe gesture.
	 * 
	 * <blockquote><pre>
	 * Pointable swiper = swipe.pointable();
	 * </pre></blockquote>
	 * 
	 * @return A {@link Pointable} object representing the swiping finger.
	 */
	public Pointable pointable() {
		return new Pointable(LeapJNI.SwipeGesture_pointable(this.swigCPtr, this), true);
	}
	
	public static long getCPtr(SwipeGesture paramSwipeGesture) {
		return paramSwipeGesture == null ? 0L : paramSwipeGesture.swigCPtr;
	}

	protected void finalize() {
		delete();
	}

	public synchronized void delete() {
		if (this.swigCPtr != 0L) {
			if (this.swigCMemOwn) {
				this.swigCMemOwn = false;
				LeapJNI.delete_SwipeGesture(this.swigCPtr);
			}
			this.swigCPtr = 0L;
		}
		super.delete();
	}

}
