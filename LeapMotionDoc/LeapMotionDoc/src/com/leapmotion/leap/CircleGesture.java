package com.leapmotion.leap;

/**
 * 
 * The CircleGesture classes represents a circular finger movement.<p>
 * A circle movement is recognized when the tip of a finger draws a circle within the 
 * Leap Motion {@link Controller} field of view.<p>
 * 
 * <img src="D:\Programming\eclipse\workspace\LeapMotionDoc\images\Leap_Gesture_Circle.png"/>
 * 
 * <b>Important:</b> To use circle gestures in your application, you must enable recognition of the circle gesture. 
 * You can enable recognition with:
 * <blockquote><pre>
 * controller.enableGesture(Gesture.Type.TYPE_CIRCLE);
 * </pre></blockquote>
 * 
 * Circle gestures are continuous. The {@code CircleGesture} objects for the gesture have three possible states:<p>
 * 
 * {@link State#STATE_START} The circle gesture has just started. 
 * The movement has progressed far enough for the recognizer to classify it as a circle.<p>
 * 
 * {@link State#STATE_UPDATE} The circle gesture is continuing.<p>
 * 
 * {@link State#STATE_STOP} The circle gesture is finished.<p>
 * 
 * You can set the minimum radius and minimum arc length required for a movement to be recognized 
 * as a circle using the config attribute of a connected {@link Controller} object. 
 * Use the following keys to configure circle recognition:
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
 * 		<td>Gesture.Circle.MinRadius</td><td>float</td><td>5.0</td><td>mm</td>
 * 	</tr>
 * 	<tr>
 * 		<td>Gesture.Circle.MinArc</td><td>float</td><td>1.5 * pi</td><td>radians</td>
 * 	</tr>
 * 	</tbody>
 * </table>
 * <p>
 * The following example demonstrates how to set the circle configuration parameters:
 * 
 * <blockquote><pre>
 * controller.config().setFloat("Gesture.Circle.MinRadius", 10.0f);
 * controller.config().setFloat("Gesture.Circle.MinArc", .5f);
 * controller.config().save(); 
 * </pre></blockquote>
 * 
 * The {@link Controller} object must be connected to the Leap Motion service/daemon before 
 * setting the configuration parameters.<p>
 * 
 * @since 1.0 
 * @author Leap Motion Inc
 */
public class CircleGesture extends Gesture {
	private long swigCPtr;

	/**
	 * Constructs a new {@code CircleGesture} object.<p>
	 * 
	 * An uninitialized {@code CircleGesture} object is considered invalid. 
	 * Get valid instances of the {@code CircleGesture} class from a {@link Frame} object.
	 */
	public CircleGesture() {
		this(LeapJNI.new_CircleGesture__SWIG_0(), true);
	}

	/**
	 * Constructs a {@code CircleGesture} object from an instance of the {@link Gesture} class.
	 * 
	 * <blockquote><pre>
	 * if(gesture.type() == Gesture.Type.TYPE_CIRCLE) {
	 *     CircleGesture circleGesture = new CircleGesture(gesture);
	 * }
	 * </pre></blockquote>
	 * 
	 * @param rhs - The {@link Gesture} instance to specialize. 
	 * This {@link Gesture} instance must be a {@code CircleGesture} object.
	 */
	public CircleGesture(Gesture rhs) {
		this(LeapJNI.new_CircleGesture__SWIG_1(Gesture.getCPtr(rhs), rhs), true);
	}
	
	public CircleGesture(long paramLong, boolean paramBoolean)
	{
		super(LeapJNI.CircleGesture_SWIGUpcast(paramLong), paramBoolean);
		this.swigCPtr = paramLong;
	}

	/**
	 * The center point of the circle within the Leap Motion frame of reference.
	 * 
	 * <blockquote><pre>
	 * Vector centerPoint = circle.center();
	 * </pre></blockquote>
	 * 
	 * @return {@link Vector} The center of the circle in mm from the Leap Motion origin.
	 */
	public Vector center() {
		return new Vector(LeapJNI.CircleGesture_center(this.swigCPtr, this), true);
	}

	/**
	 * Returns the normal vector for the circle being traced.<p>
	 * 
	 * If you draw the circle clockwise, the normal vector points in the same general direction 
	 * as the pointable object drawing the circle. 
	 * If you draw the circle counterclockwise, the normal points back toward the pointable. 
	 * If the angle between the normal and the pointable object drawing the circle is less than 90 degrees, 
	 * then the circle is clockwise.
	 * 
	 * <blockquote><pre>
	 * String clockwiseness;
	 * if (circle.pointable().direction().angleTo(circle.normal()) <= Math.PI/2) {
	 *     clockwiseness = "clockwise";
	 * } else {
	 *     clockwiseness = "counterclockwise";
	 * }
	 * </pre></blockquote>
	 * 
	 * @return {@link Vector} the normal vector for the circle being traced
	 */
	public Vector normal() {
		return new Vector(LeapJNI.CircleGesture_normal(this.swigCPtr, this), true);
	}

	/**
	 * The number of times the finger tip has traversed the circle.<p>
	 * 
	 * Progress is reported as a positive number of the number. 
	 * For example, a progress value of .5 indicates that the finger has gone halfway around, 
	 * while a value of 3 indicates that the finger has gone around the the circle three times.
	 * 
	 * <blockquote><pre>
	 * float turns = circle.progress();
	 * </pre></blockquote>
	 * 
	 * Progress starts where the circle gesture began. 
	 * Since the circle must be partially formed before the Leap Motion software can recognize it, 
	 * progress will be greater than zero when a circle gesture first appears in the frame.<p>
	 * 
	 * @return A positive number indicating the gesture progress.
	 */
	public float progress() {
		return LeapJNI.CircleGesture_progress(this.swigCPtr, this);
	}

	/**
	 * The radius of the circle.
	 * 
	 * <blockquote><pre>
	 * float diameter = 2 * circle.radius();
	 * </pre></blockquote>
	 * 
	 * @return The circle radius in mm.
	 */
	public float radius() {
		return LeapJNI.CircleGesture_radius(this.swigCPtr, this);
	}

	/**
	 * The finger performing the circle gesture.
	 * 
	 * <blockquote><pre>
	 * Pointable circlePointable = circle.pointable();
	 * </pre></blockquote>
	 * 
	 * @return A {@link Pointable} object representing the circling finger.
	 */
	public Pointable pointable() {
		return new Pointable(LeapJNI.CircleGesture_pointable(this.swigCPtr, this), true);
	}
	
	public static Gesture.Type classType() {
		return Gesture.Type.swigToEnum(LeapJNI.CircleGesture_classType());
	}

	public static long getCPtr(CircleGesture paramCircleGesture) {
		return paramCircleGesture == null ? 0L : paramCircleGesture.swigCPtr;
	}

	protected void finalize() {
		delete();
	}

	public synchronized void delete() {
		if (this.swigCPtr != 0L) {
			if (this.swigCMemOwn) {
				this.swigCMemOwn = false;
				LeapJNI.delete_CircleGesture(this.swigCPtr);
			}
			this.swigCPtr = 0L;
		}
		super.delete();
	}
}
