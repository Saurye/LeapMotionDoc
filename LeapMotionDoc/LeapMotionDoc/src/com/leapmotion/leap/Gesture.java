package com.leapmotion.leap;

/**
 * The {@code Gesture} class represents a recognized movement by the user.<p>
 * 
 * The Leap Motion {@link Controller} watches the activity within its field of view for certain movement patterns 
 * typical of a user gesture or command. 
 * For example, a movement from side to side with the hand can indicate a swipe gesture, 
 * while a finger poking forward can indicate a screen tap gesture.<p>
 * 
 * When the Leap Motion software recognizes a gesture, 
 * it assigns an ID and adds a {@code Gesture} object to the frame gesture list. 
 * For continuous gestures, which occur over many frames, 
 * the Leap Motion software updates the gesture by adding a {@code Gesture} object having 
 * the same ID and updated properties in each subsequent frame.<p>
 * 
 * <b>Important:</b> Recognition for each type of gesture must be enabled using the {@link Controller#enableGesture(Type)} 
 * function; otherwise <b>no gestures are recognized or reported</b>.
 * 
 * <blockquote><pre>
 * controller.enableGesture(Gesture.Type.TYPE_CIRCLE);
 * controller.enableGesture(Gesture.Type.TYPE_KEY_TAP);
 * controller.enableGesture(Gesture.Type.TYPE_SCREEN_TAP);
 * controller.enableGesture(Gesture.Type.TYPE_SWIPE);
 * </pre></blockquote>
 * 
 * Subclasses of Gesture define the properties for the specific movement patterns recognized by the Leap Motion software.<p>
 * 
 * The Gesture subclasses include:<p>
 * 
 * <b>CircleGesture</b> A circular movement by a finger.<p>
 * 
 * <b>SwipeGesture</b> A straight line movement by the hand with fingers extended.<p>
 * 
 * <b>ScreenTapGesture</b> A forward tapping movement by a finger.<p>
 * 
 * <b>KeyTapGesture</b> A downward tapping movement by a finger.<p>
 * 
 * Circle and swipe gestures are continuous and these objects can have a state of start, update, and stop.
 * 
 * The screen tap gesture is a discrete gesture. The Leap Motion software only creates a single 
 * {@link ScreenTapGesture} object for each tap and it always has a stop state.<p>
 * 
 * Get valid {@code Gesture} instances from a Frame object. 
 * You can get a list of gestures with the {@link Frame#gestures()} method. 
 * You can get a list of gestures since a specified frame with the {@link Frame#gestures(Frame)} method. 
 * You can also use the {@link Frame#gesture(int)} method to find a gesture in the current frame 
 * using an ID value obtained in a previous frame.<p>
 * 
 * {@code Gesture} objects can be invalid. For example, when you get a gesture by ID using {@link Frame#gesture(int)} 
 * and there is no gesture with that ID in the current frame, {@link Frame#gesture(int)} returns 
 * an Invalid {@code Gesture} object (rather than a null value). 
 * Always check object validity in situations where a gesture might be invalid.<p>
 * 
 * The following keys can be used with the {@link Config} class to configure the gesture recognizer:
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
 * 	<tr>
 * 		<td>Gesture.Swipe.MinLength</td><td>float</td><td>150</td><td>mm</td>
 * 	</tr>
 * 	<tr>
 * 		<td>Gesture.Swipe.MinVelocity</td><td>float</td><td>1000</td><td>mm/s</td>
 * 	</tr>
 * 	<tr>
 * 		<td>Gesture.KeyTap.MinDownVelocity</td><td>float</td><td>50</td><td>mm/s</td>
 * 	</tr>
 * 	<tr>
 * 		<td>Gesture.KeyTap.HistorySeconds</td><td>float</td><td>0.1</td><td>s</td>
 * 	</tr>
 * 	<tr>
 * 		<td>Gesture.KeyTap.MinDistance</td><td>float</td><td>3.0</td><td>mm</td>
 * 	</tr>
 * 	<tr>
 * 		<td>Gesture.ScreenTap.MinForwardVelocity</td><td>float</td><td>50</td><td>mm/s</td>
 * 	</tr>
 * 	<tr>
 * 		<td>Gesture.ScreenTap.HistorySeconds</td><td>float</td><td>0.1</td><td>s</td>
 * 	</tr>
 * 	<tr>
 * 		<td>Gesture.ScreenTap.MinDistance</td><td>float</td><td>5.0</td><td>mm</td>
 * 	</tr>
 * </tbody>
 * </table>
 * <p>
 * 
 * @since 1.0
 * @author Leap Motion Inc
 *
 */
public class Gesture extends Interface {
	private long swigCPtr;

	/**
	 * Constructs a new {@code Gesture} object.<p>
	 * 
	 * An uninitialized {@code Gesture} object is considered invalid. 
	 * Get valid instances of the {@code Gesture} class, which will be one of the {@code Gesture} subclasses, 
	 * from a {@link Frame} object.
	 */
	public Gesture() {
		this(LeapJNI.new_Gesture__SWIG_0(), true);
	}

	/**
	 * Constructs a new copy of an {@code Gesture} object.
	 * 
	 * <blockquote><pre>
	 * Gesture copy = new Gesture(gesture);
	 * </pre></blockquote>
	 * 
	 * @param rhs - {@code Gesture} object to copy.
	 */
	public Gesture(Gesture rhs) {
		this(LeapJNI.new_Gesture__SWIG_1(getCPtr(rhs), rhs), true);
	}
	
	public Gesture(long paramLong, boolean paramBoolean)
	{
		super(LeapJNI.Gesture_SWIGUpcast(paramLong), paramBoolean);
		this.swigCPtr = paramLong;
	}

	/**
	 * The gesture type.<p>
	 * 
	 * <blockquote><pre>
	 * for(Gesture gestureObj : frame.gestures()) {
	 *     switch (gesture.type()) {
	 *        case TYPE_CIRCLE:
	 *            //Handle circle gestures
	 *     		  break;
     *        case TYPE_KEY_TAP:
     *            //Handle key tap gestures
     *            break;
     *        case TYPE_SCREEN_TAP:
     *           //Handle screen tap gestures
     *           break;
     *        case TYPE_SWIPE:
     *           //Handle swipe gestures
     *           break;
     *        default:
     *           //Handle unrecognized gestures
     *           break;
     *     }
     * } 
	 * </pre></blockquote>
	 * 
	 * @return A value from the {@link Type} enumeration.
	 */
	public Type type() {
		return Type.swigToEnum(LeapJNI.Gesture_type(this.swigCPtr, this));
	}

	/**
	 * The gesture state.<p>
	 * 
	 * Recognized movements occur over time and have a beginning, a middle, and an end. 
	 * The {@code state()} attribute reports where in that sequence this {@code Gesture} object falls.
	 * 
	 * <blockquote><pre>
	 * for(Gesture gestureObj : frame.gestures()) {
	 *     switch (gesture.state()) {
	 *        case STATE_START:
	 *            //Handle starting gestures
	 *     		  break;
     *        case STATE_UPDATE:
     *            //Handle continuing gestures
     *            break;
     *        case STATE_STOP:
     *           //Handle ending gestures
     *           break;
     *        default:
     *           //Handle unrecognized states
     *           break;
     *     }
     * }
	 * </pre></blockquote>
	 * 
	 * @return A value from the {@link State} enumeration.
	 */
	public State state() {
		return State.swigToEnum(LeapJNI.Gesture_state(this.swigCPtr, this));
	}

	/**
	 * The gesture ID.<p>
	 * 
	 * All Gesture objects belonging to the same recognized movement share the same ID value. 
	 * Use the ID value with the {@link Frame#gesture(int)} method to find updates related to this 
	 * {@code Gesture} object in subsequent frames.
	 * 
	 * <blockquote><pre>
	 * int gestureToFind = gesture.id();
	 * GestureList manyGestures = frame.gestures(olderFrame);
	 * for(Gesture gestureObject : manyGestures) {
	 *     if (gestureObject.id() == gestureToFind) {
	 *         //Process it...
	 *     }
	 * }
	 * </pre></blockquote>
	 * 
	 * @return the ID of this {@code Gesture}.
	 */
	public int id() {
		return LeapJNI.Gesture_id(this.swigCPtr, this);
	}

	/**
	 * The elapsed duration of the recognized movement up to the frame containing this Gesture object, in microseconds.
	 * 
	 * <blockquote><pre>
	 * float microseconds = gesture.duration();
	 * </pre></blockquote>
	 * 
	 * The duration reported for the first {@code Gesture} in the sequence (with the STATE_START state) 
	 * will typically be a small positive number since the movement must progress far enough for 
	 * the Leap Motion software to recognize it as an intentional gesture.
	 * 
	 * @return the elapsed duration in microseconds.
	 */
	public long duration() {
		return LeapJNI.Gesture_duration(this.swigCPtr, this);
	}

	/**
	 * The elapsed duration in seconds.
	 * 
	 * <blockquote><pre>
	 * float seconds = gesture.durationSeconds();
	 * </pre></blockquote>
	 * 
	 * @see Gesture#duration()
	 * 
	 * @return the elapsed duration in seconds.
	 */
	public float durationSeconds() {
		return LeapJNI.Gesture_durationSeconds(this.swigCPtr, this);
	}

	/**
	 * The {@link Frame} containing this {@code Gesture} instance.
	 * 
	 * <blockquote><pre>
	 * Frame frameOfGesture = gesture.frame();
	 * </pre></blockquote>
	 * 
	 * @return The parent {@link Frame} object.
	 */
	public Frame frame() {
		return new Frame(LeapJNI.Gesture_frame(this.swigCPtr, this), true);
	}

	/**
	 * The list of hands associated with this {@code Gesture}, if any.
	 * 
	 * <blockquote><pre>
	 * HandList handsForGesture = gesture.hands();
	 * </pre></blockquote>
	 * 
	 * If no hands are related to this gesture, the list is empty.
	 * 
	 * @return {@link HandList} the list of related {@link Hand} objects.
	 */
	public HandList hands() {
		return new HandList(LeapJNI.Gesture_hands(this.swigCPtr, this), true);
	}

	/**
	 * The list of fingers and tools associated with this {@code Gesture}, if any.<p>
	 * 
	 * If no {@link Pointable} objects are related to this gesture, the list is empty.
	 * 
	 * <blockquote><pre>
	 * PointableList pointablesForGesture = gesture.pointables();
	 * </pre></blockquote>
	 * 
	 * @return the list of related {@link Pointable} objects.
	 */
	public PointableList pointables() {
		return new PointableList(LeapJNI.Gesture_pointables(this.swigCPtr, this), true);
	}

	/**
	 * Reports whether this {@code Gesture} instance represents a valid {@code Gesture}.<p>
	 * 
	 * An invalid {@code Gesture} object does not represent a snapshot of a recognized movement. 
	 * Invalid {@code Gesture} objects are returned when a valid object cannot be provided. 
	 * For example, when you get an gesture by ID using {@link Frame#gesture(int)}, 
	 * and there is no gesture with that ID in the current frame, 
	 * then {@link Frame#gesture(int)} returns an Invalid {@code Gesture} object (rather than a null value). 
	 * Always check object validity in situations where an gesture might be invalid.
	 * 
	 * <blockquote><pre>
	 * if (gesture.isValid()) {
	 *     // Process it...
	 * }
	 * </pre></blockquote>
	 * 
	 * @return true, if this is a valid {@code Gesture} instance; false, otherwise.
	 */
	public boolean isValid() {
		return LeapJNI.Gesture_isValid(this.swigCPtr, this);
	}

	/**
	 * Compare {@code Gesture} object equality.
	 * 
	 * <blockquote><pre>
	 * Boolean gestureIsEqual = thisGesture.equals(thatGesture);
	 * </pre></blockquote>
	 * 
	 * Two Gestures are equal if they represent the same snapshot of the same recognized movement.
	 * 
	 * @param rhs - {@code Gesture} object to compare
	 * 
	 * @return true if the {@code Gesture} objects are equal.
	 */
	public boolean equals(Gesture rhs) {
		return LeapJNI.Gesture_equals(this.swigCPtr, this, getCPtr(rhs), rhs);
	}

	/**
	 * A string containing a brief, human-readable description of this Gesture.
	 * 
	 * <blockquote><pre>
	 * for(Gesture gesture : frame.gestures()){
	 *     System.out.println(gesture.toString());
	 * }
	 * </pre></blockquote>
	 * 
	 * @return A description of the {@code Gesture} object as a string.
	 */
	public String toString() {
		return LeapJNI.Gesture_toString(this.swigCPtr, this);
	}

	/**
	 * Returns an invalid {@code Gesture} object.<p>
	 * 
	 * You can use the instance returned by this function in comparisons testing whether 
	 * a given {@code Gesture} instance is valid or invalid. 
	 * (You can also use the {@link Gesture#isValid()} function.)
	 * 
	 * <blockquote><pre>
	 * Gesture trackedGesture = frame.gesture(gestureID);
	 * if (!trackedGesture.equals(Gesture.invalid())) {
	 *     //Process it...
	 * }
	 * </pre></blockquote>
	 * 
	 * @return The invalid {@code Gesture} instance.
	 */
	public static Gesture invalid() {
		return new Gesture(LeapJNI.Gesture_invalid(), false);
	}
	
	public static long getCPtr(Gesture paramGesture) {
		return paramGesture == null ? 0L : paramGesture.swigCPtr;
	}

	protected void finalize() {
		delete();
	}

	public synchronized void delete() {
		if (this.swigCPtr != 0L) {
			if (this.swigCMemOwn) {
				this.swigCMemOwn = false;
				LeapJNI.delete_Gesture(this.swigCPtr);
			}
			this.swigCPtr = 0L;
		}
		super.delete();
	}

	/**
	 * The supported types of gestures.
	 * 
	 * @since 1.0
	 * @author Leap Motion Inc
	 */
	public static enum Type {
		TYPE_INVALID(-1), 
		TYPE_SWIPE(1), 
		TYPE_CIRCLE(4), 
		TYPE_SCREEN_TAP(5), 
		TYPE_KEY_TAP(6);

		public final int swigValue() {
			return this.swigValue;
		}

		public static Type swigToEnum(int paramInt) {
			Type[] arrayOfType1 = (Type[])Type.class.getEnumConstants();
			if ((paramInt < arrayOfType1.length) && (paramInt >= 0) && (arrayOfType1[paramInt].swigValue == paramInt))
				return arrayOfType1[paramInt];
			for (Type localType : arrayOfType1)
				if (localType.swigValue == paramInt)
					return localType;
			throw new IllegalArgumentException("No enum " + Type.class + " with value " + paramInt);
		}

		private Type()
		{
			this.swigValue = SwigNext.access$008();
		}

		private Type(int paramInt)
		{
			this.swigValue = paramInt;
			SwigNext.access$002(paramInt + 1);
		}

		private Type(Type paramType)
		{
			this.swigValue = paramType.swigValue;
			SwigNext.access$002(this.swigValue + 1);
		}

		private final int swigValue;
		private static class SwigNext
		{
			private static int next = 0;
		}
	}

	/**
	 * The possible gesture states.
	 * 
	 * @since 1.0
	 * @author Leap Motion Inc
	 */
	public static enum State {
		STATE_INVALID(-1), 
		STATE_START(1), 
		STATE_UPDATE(2), 
		STATE_STOP(3);

		public final int swigValue() {
			return this.swigValue;
		}

		public static State swigToEnum(int paramInt) {
			State[] arrayOfState1 = (State[])State.class.getEnumConstants();
			if ((paramInt < arrayOfState1.length) && (paramInt >= 0) && (arrayOfState1[paramInt].swigValue == paramInt))
				return arrayOfState1[paramInt];
			for (State localState : arrayOfState1)
				if (localState.swigValue == paramInt)
					return localState;
			throw new IllegalArgumentException("No enum " + State.class + " with value " + paramInt);
		}

		private State()
		{
			this.swigValue = SwigNext.access$108();
		}

		private State(int paramInt)
		{
			this.swigValue = paramInt;
			SwigNext.access$102(paramInt + 1);
		}

		private State(State paramState)
		{
			this.swigValue = paramState.swigValue;
			SwigNext.access$102(this.swigValue + 1);
		}

		private final int swigValue;
		private static class SwigNext
		{
			private static int next = 0;
		}
	}
}
