package com.leapmotion.leap;

/**
 * The {@code InteractionBox} class represents a box-shaped region completely within the field of view 
 * of the Leap Motion controller.<p>
 * 
 * The interaction box is an axis-aligned rectangular prism and provides normalized coordinates for hands, 
 * fingers, and tools within this box. The {@code InteractionBox} class can make it easier to map positions 
 * in the Leap Motion coordinate system to 2D or 3D coordinate systems used for application drawing.<p>
 * 
 * <img src="\images\Leap_InteractionBox.png"/><p>
 * 
 * The {@code InteractionBox} region is defined by a center and dimensions along the x, y, and z axes.<p>
 * 
 * Get an {@code InteractionBox} object from a {@link Frame} object.
 * 
 * @since 1.0
 * @author Leap Motion Inc
 */
public class InteractionBox extends Interface {
	private long swigCPtr;

	public InteractionBox() {
		this(LeapJNI.new_InteractionBox(), true);
	}
	
	public InteractionBox(long paramLong, boolean paramBoolean)	{
		super(LeapJNI.InteractionBox_SWIGUpcast(paramLong), paramBoolean);
		this.swigCPtr = paramLong;
	}

	/**
	 * Normalizes the coordinates of a point using the interaction box.
	 * 
	 * <blockquote><pre>
	 * Vector normalizedHandPosition = interactionBox.normalizePoint(hand.palmPosition(),true);
	 * </pre></blockquote>
	 * 
	 * Coordinates from the Leap Motion frame of reference (millimeters) are converted 
	 * to a range of [0..1] such that the minimum value of the {@link InteractionBox} maps 
	 * to 0 and the maximum value of the {@link InteractionBox} maps to 1.
	 * 
	 * @param position - The input position in device coordinates.
	 * 
	 * @param clamp - Whether or not to limit the output value to the range [0,1] 
	 * when the input position is outside the {@link InteractionBox}. Defaults to true.
	 * 
	 * @return The normalized position.
	 */
	public Vector normalizePoint(Vector position, boolean clamp) {
		return new Vector(LeapJNI.InteractionBox_normalizePoint__SWIG_0(this.swigCPtr, this, Vector.getCPtr(position), position, clamp), true);
	}

	/**
	 * Normalizes the coordinates of a point using the interaction box.
	 * 
	 * <blockquote><pre>
	 * Vector normalizedHandPosition = interactionBox.normalizePoint(hand.palmPosition());
	 * </pre></blockquote>
	 * 
	 * Coordinates from the Leap Motion frame of reference (millimeters) are converted 
	 * to a range of [0..1] such that the minimum value of the {@link InteractionBox} maps 
	 * to 0 and the maximum value of the {@link InteractionBox} maps to 1.
	 * 
	 * @param position - The input position in device coordinates.
	 * 
	 * @return The normalized position.
	 */
	public Vector normalizePoint(Vector position) {
		return new Vector(LeapJNI.InteractionBox_normalizePoint__SWIG_1(this.swigCPtr, this, Vector.getCPtr(position), position), true);
	}

	/**
	 * Converts a position defined by normalized {@link InteractionBox} coordinates into device coordinates in millimeters.
	 * 
	 * <blockquote><pre>
	 * InteractionBox interactionBox = frame.interactionBox();
	 * Vector point = new Vector(100, 75, -125);
	 * Vector normalizedCoordinates = interactionBox.normalizePoint(point);
	 * Vector denormalizedCoordinates = interactionBox.denormalizePoint(normalizedCoordinates);
	 * // denormalizedCoordinates == point
	 * </pre></blockquote>
	 * 
	 * This function performs the inverse of normalizePoint().<p>
	 * 
	 * @param normalizedPosition - The input position in InteractionBox coordinates.
	 * @return The corresponding denormalized position in device coordinates.
	 */
	public Vector denormalizePoint(Vector normalizedPosition) {
		return new Vector(LeapJNI.InteractionBox_denormalizePoint(this.swigCPtr, this, Vector.getCPtr(normalizedPosition), normalizedPosition), true);
	}

	/**
	 * The center of the {@link InteractionBox} in device coordinates (millimeters).<p>
	 * 
	 * This point is equidistant from all sides of the box.
	 * 
	 * <blockquote><pre>
	 * Vector boxCenter = interactionBox.center();
	 * </pre></blockquote>
	 * 
	 * @return The {@link InteractionBox} center in device coordinates.
	 */
	public Vector center() {
		return new Vector(LeapJNI.InteractionBox_center(this.swigCPtr, this), true);
	}

	/**
	 * The width of the {@link InteractionBox} in millimeters, measured along the x-axis.
	 * 
	 * <blockquote><pre>
	 * float boxDimensionAlongXAxis = interactionBox.width();
	 * </pre></blockquote>
	 * 
	 * @return The {@link InteractionBox} width in millimeters.
	 */
	public float width() {
		return LeapJNI.InteractionBox_width(this.swigCPtr, this);
	}

	/**
	 * The height of the {@link InteractionBox} in millimeters, measured along the y-axis.
	 * 
	 * <blockquote><pre>
	 * float boxDimensionAlongYAxis = interactionBox.height();
	 * </pre></blockquote>
	 * 
	 * @return The {@link InteractionBox} height in millimeters.
	 */
	public float height() {
		return LeapJNI.InteractionBox_height(this.swigCPtr, this);
	}

	/**
	 * The depth of the {@link InteractionBox} in millimeters, measured along the z-axis.
	 * 
	 * <blockquote><pre>
	 * float boxDimensionAlongZAxis = interactionBox.depth();
	 * </pre></blockquote>
	 * 
	 * @return The {@link InteractionBox} depth in millimeters.
	 */
	public float depth() {
		return LeapJNI.InteractionBox_depth(this.swigCPtr, this);
	}

	/**
	 * Reports whether this is a valid {@link InteractionBox} object.
	 * 
	 * <blockquote><pre>
	 * if (interactionBox.isValid()) {
	 *     //Use the box...
	 * }
	 * </pre></blockquote>
	 * 
	 * @return True, if this {@link InteractionBox} object contains valid data.
	 */
	public boolean isValid() {
		return LeapJNI.InteractionBox_isValid(this.swigCPtr, this);
	}

	public static InteractionBox invalid() {
		return new InteractionBox(LeapJNI.InteractionBox_invalid(), false);
	}

	/**
	 * Compare {@link InteractionBox} object equality.
	 * 
	 * <blockquote><pre>
	 * Boolean isBoxEqual = thisBox.equals(thatBox);
	 * </pre></blockquote>
	 * 
	 * Two {@link InteractionBox} objects are equal if and only if both {@link InteractionBox} objects 
	 * represent the exact same {@link InteractionBox} and both {@link InteractionBox} are valid.
	 * 
	 * @param interactionBox - {@link InteractionBox} object to compare
	 * 
	 * @return true if the {@link InteractionBox} objects are equal.
	 */
	public boolean equals(InteractionBox interactionBox) {
		return LeapJNI.InteractionBox_equals(this.swigCPtr, this, getCPtr(interactionBox), interactionBox);
	}

	/**
	 * A string containing a brief, human readable description of the {@link InteractionBox} object.
	 * 
	 * @return A description of the {@link InteractionBox} as a string.
	 */
	public String toString() {
		return LeapJNI.InteractionBox_toString(this.swigCPtr, this);
	}
	
	public static long getCPtr(InteractionBox paramInteractionBox) {
		return paramInteractionBox == null ? 0L : paramInteractionBox.swigCPtr;
	}

	protected void finalize() {
		delete();
	}

	public synchronized void delete() {
		if (this.swigCPtr != 0L) {
			if (this.swigCMemOwn) {
				this.swigCMemOwn = false;
				LeapJNI.delete_InteractionBox(this.swigCPtr);
			}
			this.swigCPtr = 0L;
		}
		super.delete();
	}

}
