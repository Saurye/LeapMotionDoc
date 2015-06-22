package com.leapmotion.leap;

/**
 * The {@code Pointable} class reports the physical characteristics of a detected finger or tool.<p>
 * 
 * Both fingers and tools are classified as {@code Pointable} objects. 
 * Use the {@link Pointable#isFinger()} function to determine whether a {@code Pointable} object represents a finger. 
 * Use the {@link Pointable#isTool()} function to determine whether a {@code Pointable} object represents a tool. 
 * The Leap Motion software classifies a detected entity as a tool when it is thinner, 
 * straighter, and longer than a typical finger.
 * 
 * <blockquote><pre>
 * Pointable pointable = frame.pointables().frontmost();
 * Vector direction = pointable.direction();
 * float length = pointable.length();
 * float width = pointable.width();
 * Vector stabilizedPosition = pointable.stabilizedTipPosition();
 * Vector position = pointable.tipPosition();
 * Vector speed = pointable.tipVelocity();
 * float touchDistance = pointable.touchDistance();
 * Pointable.Zone zone = pointable.touchZone();
 * </pre></blockquote>
 * 
 * To provide touch emulation, the Leap Motion software associates a floating touch plane 
 * that adapts to the user’s finger movement and hand posture. 
 * The Leap Motion interprets purposeful movements toward this plane as potential touch points. 
 * The {@code Pointable} class reports touch state with the touchZone and touchDistance values.<p>
 * 
 * Note that {@code Pointable} objects can be invalid, which means that they do not contain valid tracking data 
 * and do not correspond to a physical entity. 
 * Invalid {@code Pointable} objects can be the result of asking for a {@code Pointable} object 
 * using an ID from an earlier frame when no {@code Pointable} objects with that ID exist in the current frame. 
 * A {@code Pointable} object created from the {@code Pointable} constructor is also invalid. 
 * Test for validity with the {@link Pointable#isValid()} function.
 * 
 * @since 1.0
 * @author Leap Motion Inc
 */
public class Pointable extends Interface {
	private long swigCPtr;
	
	/**
	 * Constructs a {@code Pointable} object.<p>
	 * 
	 * An uninitialized pointable is considered invalid. 
	 * Get valid {@code Pointable} objects from a {@link Frame} or a {@link Hand} object.
	 * 
	 * <blockquote><pre>
	 * Pointable pointable = frame.pointables().frontmost(); 
	 * </pre></blockquote>
	 */
	public Pointable() {
		this(LeapJNI.new_Pointable(), true);
	}

	public Pointable(long paramLong, boolean paramBoolean)
	{
		super(LeapJNI.Pointable_SWIGUpcast(paramLong), paramBoolean);
		this.swigCPtr = paramLong;
	}

	/**
	 * A unique ID assigned to this {@code Pointable} object, 
	 * whose value remains the same across consecutive frames while the tracked finger or tool remains visible.<p>
	 * 
	 * If tracking is lost (for example, when a finger is occluded by another finger 
	 * or when it is withdrawn from the Leap Motion {@link Controller} field of view), 
	 * the Leap Motion software may assign a new ID when it detects the entity in a future frame.
	 * 
	 * <blockquote><pre>
	 * int theID = pointable.id();
	 * </pre></blockquote>
	 * 
	 * Use the ID value with the {@link Frame#pointable(int)} function to find 
	 * this {@code Pointable} object in future frames.<p>
	 * 
	 * IDs should be from 1 to 100 (inclusive). 
	 * If more than 100 objects are tracked an IDs of -1 will be used until an ID in the defined range is available.
	 * 
	 * @return The ID assigned to this Pointable object.
	 */
	public int id() {
		return LeapJNI.Pointable_id(this.swigCPtr, this);
	}

	/**
	 * The {@link Frame} associated with this {@code Pointable} object.
	 * 
	 * <blockquote><pre>
	 * Frame frameOfThisPointableObject = pointable.frame();
	 * </pre></blockquote>
	 * 
	 * @return The associated {@link Frame} object, if available; 
	 * otherwise, an invalid {@link Frame} object is returned.
	 */
	public Frame frame() {
		return new Frame(LeapJNI.Pointable_frame(this.swigCPtr, this), true);
	}

	/**
	 * The {@link Hand} associated with a finger.
	 * 
	 * <blockquote><pre>
	 * Hand attachedHand = pointable.hand();
	 * </pre></blockquote>
	 * 
	 * Not that in version 2+, tools are not associated with hands. 
	 * For tools, this function always returns an invalid {@link Hand} object.
	 * 
	 * @return The associated {@link Hand} object, if available; 
	 * otherwise, an invalid {@link Hand} object is returned.
	 */
	public Hand hand() {
		return new Hand(LeapJNI.Pointable_hand(this.swigCPtr, this), true);
	}

	/**
	 * The tip position in millimeters from the Leap Motion origin.
	 * 
	 * <blockquote><pre>
	 * Vector currentPosition = pointable.tipPosition();
	 * </pre></blockquote>
	 * 
	 * @return The {@link Vector} containing the coordinates of the tip position.
	 */
	public Vector tipPosition() {
		return new Vector(LeapJNI.Pointable_tipPosition(this.swigCPtr, this), true);
	}

	/**
	 * The rate of change of the tip position in millimeters/second.
	 * 
	 * <blockquote><pre>
	 * Vector currentSpeed = pointable.tipVelocity();
	 * </pre></blockquote>
	 * 
	 * @return The {@link Vector} containing the coordinates of the tip velocity.
	 */
	public Vector tipVelocity() {
		return new Vector(LeapJNI.Pointable_tipVelocity(this.swigCPtr, this), true);
	}

	/**
	 * The direction in which this finger or tool is pointing.
	 * 
	 * <blockquote><pre>
	 * Vector pointingToward = pointable.direction();
	 * </pre></blockquote>
	 * 
	 * The direction is expressed as a unit vector pointing in the same direction as the tip.<p>
	 * 
	 * <img src="\images\Leap_Finger_Model.png"/><p>
	 * 
	 * @return The {@link Vector} pointing in the same direction as the tip of this {@code Pointable} object.
	 */
	public Vector direction() {
		return new Vector(LeapJNI.Pointable_direction(this.swigCPtr, this), true);
	}

	/**
	 * The estimated width of the finger or tool in millimeters.
	 * 
	 * <blockquote><pre>
	 * float averageThickness = pointable.width();
	 * </pre></blockquote>
	 * 
	 * @return The estimated width of this {@code Pointable} object.
	 */
	public float width() {
		return LeapJNI.Pointable_width(this.swigCPtr, this);
	}

	/**
	 * The estimated length of the finger or tool in millimeters.
	 * 
	 * <blockquote><pre>
	 * float apparentlength = pointable.length();
	 * </pre></blockquote>
	 * 
	 * @return The estimated length of this {@code Pointable} object.
	 */
	public float length() {
		return LeapJNI.Pointable_length(this.swigCPtr, this);
	}

	/**
	 * Whether or not this {@code Pointable} is classified as a finger.
	 * 
	 * <blockquote><pre>
	 * if (pointable.isTool()) {
	 *     Tool tool = new Tool(pointable);
	 * } else {
	 *     Finger finger = new Finger(pointable);
	 * }
	 * </pre></blockquote>
	 * 
	 * @return True, if this {@code Pointable} is classified as a finger.
	 */
	public boolean isFinger() {
		return LeapJNI.Pointable_isFinger(this.swigCPtr, this);
	}

	/**
	 * Whether or not this {@code Pointable} is classified as a tool.
	 * 
	 * <blockquote><pre>
	 * if (pointable.isTool()) {
	 *     Tool tool = new Tool(pointable);
	 * } else {
	 *     Finger finger = new Finger(pointable);
	 * }
	 * </pre></blockquote>
	 * 
	 * @return True, if this {@code Pointable} is classified as a tool.
	 */
	public boolean isTool() {
		return LeapJNI.Pointable_isTool(this.swigCPtr, this);
	}

	/**
	 * Whether or not this {@code Pointable} is in an extended posture.<p>
	 * 
	 * A finger is considered extended if it is extended straight from the hand as if pointing. 
	 * A finger is not extended when it is bent down and curled towards the palm. Tools are always extended.
	 * 
	 * <blockquote><pre>
	 * int extendedFingers = 0;
	 * for (Finger finger : hand.fingers()) {
	 *     if(finger.isExtended()) extendedFingers++;
	 * }
	 * </pre></blockquote>
	 * 
	 * @return True, if the pointable is extended.
	 */
	public boolean isExtended() {
		return LeapJNI.Pointable_isExtended(this.swigCPtr, this);
	}

	/**
	 * Reports whether this is a valid {@code Pointable} object.
	 * 
	 * <blockquote><pre>
	 * if( pointable.isValid()) {
	 *     //Use it...
	 * }
	 * </pre></blockquote>
	 * 
	 * @return True, if this {@code Pointable} object contains valid tracking data.
	 */
	public boolean isValid() {
		return LeapJNI.Pointable_isValid(this.swigCPtr, this);
	}

	/**
	 * The current touch zone of this {@code Pointable} object.<p>
	 * 
	 * The Leap Motion software computes the touch zone based on a floating touch plane 
	 * that adapts to the user’s finger movement and hand posture. 
	 * The Leap Motion software interprets purposeful movements toward this plane 
	 * as potential touch points. When a {@code Pointable} moves close to the adaptive touch plane, 
	 * it enters the “hovering” zone. When a {@code Pointable} reaches or passes through the plane, 
	 * it enters the “touching” zone.<p>
	 * 
	 * The possible states are present in the {@link Zone} enum of this class:<p>
	 * 
	 * <b>Zone.NONE</b> The {@code Pointable} is outside the hovering zone.<p>
	 * 
	 * <b>Zone.HOVERING</b> The {@code Pointable} is close to, but not touching the touch plane.<p>
	 * 
	 * <b>Zone.TOUCHING</b> The {@code Pointable} has penetrated the touch plane.<p>
	 * 
	 * The touchDistance value provides a normalized indication of the distance to the touch plane 
	 * when the {@code Pointable} is in the hovering or touching zones.
	 * 
	 * <blockquote><pre>
	 * switch (pointable.touchZone()) {
	 *     case ZONE_NONE:
	 *         //Handle distant pointable
	 *         break;
	 *     case ZONE_HOVERING:
	 *         //Handle pointable near touch plane
	 *         break;
	 *     case ZONE_TOUCHING:
	 *         //Handle pointable penetrating touch plane
	 *         break;
	 *     default:
	 *         //Handle error cases...
	 *         break;
	 * }
	 * </pre></blockquote>
	 * 
	 * @return The touch zone of this {@code Pointable}.
	 */
	public Zone touchZone() {
		return Zone.swigToEnum(LeapJNI.Pointable_touchZone(this.swigCPtr, this));
	}

	/**
	 * A value proportional to the distance between this {@code Pointable} object and the adaptive touch plane.<p>
	 * 
	 * <img src="\images\Leap_Touch_Plane.png"/><p>
	 * 
	 * The touch distance is a value in the range [-1, 1]. 
	 * The value 1.0 indicates the {@code Pointable} is at the far edge of the hovering zone. 
	 * The value 0 indicates the {@code Pointable} is just entering the touching zone. 
	 * A value of -1.0 indicates the {@code Pointable} is firmly within the touching zone. 
	 * Values in between are proportional to the distance from the plane. 
	 * Thus, the touchDistance of 0.5 indicates that the {@code Pointable} is halfway into the hovering zone.
	 * 
	 * <blockquote><pre>
	 * float distance = pointable.touchDistance();
	 * if (distance > 0) {
	 *     //Handle hovering ...
	 * } else {
	 *     //Handle touching ...
	 * }
	 * </pre></blockquote>
	 * 
	 * You can use the {@code touchDistance()} value to modulate visual feedback 
	 * given to the user as their fingers close in on a touch target, such as a button.<p> 
	 * 
	 * @return The normalized touch distance of this {@code Pointable} object.
	 */
	public float touchDistance() {
		return LeapJNI.Pointable_touchDistance(this.swigCPtr, this);
	}

	/**
	 * The stabilized tip position of this {@code Pointable}.<p>
	 * 
	 * Smoothing and stabilization is performed in order to make this value 
	 * more suitable for interaction with 2D content. 
	 * The stabilized position lags behind the tip position by a variable amount, 
	 * depending primarily on the speed of movement.
	 * 
	 * <blockquote><pre>
	 * Vector stabilizedPosition = pointable.stabilizedTipPosition();
	 * </pre></blockquote>
	 * 
	 * @return A modified tip position of this {@code Pointable} object 
	 * with some additional smoothing and stabilization applied.
	 */
	public Vector stabilizedTipPosition() {
		return new Vector(LeapJNI.Pointable_stabilizedTipPosition(this.swigCPtr, this), true);
	}

	/**
	 * The duration of time this {@code Pointable} has been visible to the Leap Motion {@link Controller}.
	 * 
	 * <blockquote><pre>
	 * float lifetime = pointable.timeVisible();
	 * </pre></blockquote>
	 * 
	 * @return The duration (in seconds) that this {@code Pointable} has been tracked.
	 */
	public float timeVisible() {
		return LeapJNI.Pointable_timeVisible(this.swigCPtr, this);
	}

	/**
	 * Returns an invalid {@code Pointable} object.<p>
	 * 
	 * You can use the instance returned by this function in comparisons testing 
	 * whether a given {@code Pointable} instance is valid or invalid. 
	 * (You can also use the {@link Pointable#isValid()} function.)
	 * 
	 * <blockquote><pre>
	 * if(!pointable.equals(Pointable.invalid())) {
	 *     //Use it...
	 * }
	 * </pre></blockquote>
	 * 
	 * @return The invalid {@code Pointable} instance.
	 */
	public static Pointable invalid() {
		return new Pointable(LeapJNI.Pointable_invalid(), false);
	}

	/**
	 * Compare {@code Pointable} object equality.
	 * 
	 * <blockquote><pre>
	 * Boolean pointableIsEqual = thisPointable.equals(thatPointable);
	 * </pre></blockquote>
	 * 
	 * Two {@code Pointable} objects are equal if and only if both {@code Pointable} objects 
	 * represent the exact same physical entities in the same frame and both {@code Pointable} objects are valid.
	 * 
	 * @param mask - {@code Pointable} object to compare
	 * 
	 * @return true if the {@code Pointable} objects are equal.
	 */
	public boolean equals(Pointable pointable) {
		return LeapJNI.Pointable_equals(this.swigCPtr, this, getCPtr(pointable), pointable);
	}

	/**
	 * A string containing a brief, human readable description of the {@code Pointable} object.
	 * 
	 * @return A description of the {@code Pointable} object as a string.
	 */
	public String toString() {
		return LeapJNI.Pointable_toString(this.swigCPtr, this);
	}

	public static long getCPtr(Pointable paramPointable) {
		return paramPointable == null ? 0L : paramPointable.swigCPtr;
	}

	protected void finalize() {
		delete();
	}

	public synchronized void delete() {
		if (this.swigCPtr != 0L) {
			if (this.swigCMemOwn) {
				this.swigCMemOwn = false;
				LeapJNI.delete_Pointable(this.swigCPtr);
			}
			this.swigCPtr = 0L;
		}
		super.delete();
	}
	
	/**
	 * Defines the values for reporting the state of a {@link Pointable} object in relation to an adaptive touch plane.
	 * 
	 * @since 1.0
	 * @author Leap Motion Inc
	 */
	public static enum Zone {
		ZONE_NONE(0), 
		ZONE_HOVERING(1), 
		ZONE_TOUCHING(2);

		public final int swigValue() {
			return this.swigValue;
		}

		public static Zone swigToEnum(int paramInt) {
			Zone[] arrayOfZone1 = (Zone[])Zone.class.getEnumConstants();
			if ((paramInt < arrayOfZone1.length) && (paramInt >= 0) && (arrayOfZone1[paramInt].swigValue == paramInt))
				return arrayOfZone1[paramInt];
			for (Zone localZone : arrayOfZone1)
				if (localZone.swigValue == paramInt)
					return localZone;
			throw new IllegalArgumentException("No enum " + Zone.class + " with value " + paramInt);
		}

		private Zone()
		{
			this.swigValue = SwigNext.access$008();
		}

		private Zone(int paramInt)
		{
			this.swigValue = paramInt;
			SwigNext.access$002(paramInt + 1);
		}

		private Zone(Zone paramZone)
		{
			this.swigValue = paramZone.swigValue;
			SwigNext.access$002(this.swigValue + 1);
		}

		private final int swigValue;
		private static class SwigNext
		{
			private static int next = 0;
		}
	}
}
