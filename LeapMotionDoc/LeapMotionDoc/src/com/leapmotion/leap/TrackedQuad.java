package com.leapmotion.leap;

/**
 * Note: This class is an experimental API for internal use only.<p>
 * 
 * It may be removed without warning.<p>
 * 
 * Represents a quad-like object tracked by the Leap Motion sensors.<p>
 * 
 * Only one quad can be tracked. Once a supported quad is tracked, 
 * the state of that quad will be updated for each frame of Leap Motion tracking data.<p>
 * 
 * A {@code TrackedQuad} object represents the state of the quad at one moment in time. 
 * Get a new object from subsequent frames to get the latest state information.
 * 
 * @since 2.2.6 
 * @author Leap Motion Inc
 */
public class TrackedQuad extends Interface {
	private long swigCPtr;
	
	/**
	 * Constructs a new {@link TrackedQuad} object.<p>
	 * 
	 * Do not use. Get valid TrackedQuads from a {@link Controller} or {@link Frame} object.
	 * 
	 * <blockquote><pre>
	 * Controller controller = new Controller();
	 * TrackedQuad quad = controller.trackedQuad();
	 * 
	 * Controller controller = new Controller();
	 * Frame frame = controller.frame();
	 * TrackedQuad quad = frame.trackedQuad();
	 * </pre></blockquote>
	 * 
	 */
	public TrackedQuad() {
		this(LeapJNI.new_TrackedQuad(), true);
	}

	public TrackedQuad(long paramLong, boolean paramBoolean) {
		super(LeapJNI.TrackedQuad_SWIGUpcast(paramLong), paramBoolean);
		this.swigCPtr = paramLong;
	}

	/**
	 * The physical width of the quad display area in millimeters.
	 * 
	 * <blockquote><pre>
	 * TrackedQuad quad = frame.trackedQuad();
	 * float displayWidth = quad.width();
	 * </pre></blockquote>
	 * 
	 * @return The width of the quad.
	 */
	public float width() {
		return LeapJNI.TrackedQuad_width(this.swigCPtr, this);
	}

	/**
	 * The physical height of the quad display area in millimeters.
	 * 
	 * <blockquote><pre>
	 * TrackedQuad quad = frame.trackedQuad();
	 * float displayHeight = quad.height();
	 * </pre></blockquote>
	 * 
	 * @return The height of the quad.
	 */
	public float height() {
		return LeapJNI.TrackedQuad_height(this.swigCPtr, this);
	}

	/**
	 * The horizontal resolution of the quad display area in pixels.<p>
	 * 
	 * This value is set in a configuration file. It is not determined dynamically.
	 * 
	 * <blockquote><pre>
	 * TrackedQuad quad = frame.trackedQuad();
	 * int horizontalResolution = quad.resolutionX();
	 * </pre></blockquote>
	 * 
	 * @return The horizontal resolution of the quad.
	 */
	public int resolutionX() {
		return LeapJNI.TrackedQuad_resolutionX(this.swigCPtr, this);
	}

	/**
	 * The vertical resolution of the quad display area in pixels.<p>
	 * 
	 * This value is set in a configuration file. It is not determined dynamically.
	 * 
	 * <blockquote><pre>
	 * TrackedQuad quad = frame.trackedQuad();
	 * int verticalResolution = quad.resolutionY();
	 * </pre></blockquote>
	 * 
	 * @return The vertical resolution of the quad.
	 */
	public int resolutionY() {
		return LeapJNI.TrackedQuad_resolutionY(this.swigCPtr, this);
	}

	/**
	 * Reports whether the quad is currently detected within the Leap Motion field of view.
	 * 
	 * <blockquote><pre>
	 * TrackedQuad quad = frame.trackedQuad();
	 * if (quad.visible()) {
	 *     Vector position = quad.position();
	 *     Matrix orientation = quad.orientation();
	 * } else {
	 *     //Get position and orientation from quad, if available
	 * }
	 * </pre></blockquote>
	 * 
	 * @return True if the quad is currently detected.
	 */
	public boolean visible() {
		return LeapJNI.TrackedQuad_visible(this.swigCPtr, this);
	}

	/**
	 * The orientation of the quad within the Leap Motion frame of reference.
	 * 
	 * <blockquote><pre>
	 * TrackedQuad quad = frame.trackedQuad();
	 * Matrix quadOrientation = quad.orientation();
	 * </pre></blockquote>
	 * 
	 * @return The orientation of the quad.
	 */
	public Matrix orientation() {
		return new Matrix(LeapJNI.TrackedQuad_orientation(this.swigCPtr, this), true);
	}

	/**
	 * The position of the center of the quad display area within the Leap Motion frame of reference.<p>
	 * 
	 * In millimeters.
	 * 
	 * <blockquote><pre>
	 * TrackedQuad quad = frame.trackedQuad();
	 * Vector quadPosition = quad.position();
	 * </pre></blockquote>
	 * 
	 * @return The position of the center of the quad.
	 */
	public Vector position() {
		return new Vector(LeapJNI.TrackedQuad_position(this.swigCPtr, this), true);
	}

	/**
	 * The list of masks for the current set of images.<p>
	 * 
	 * A mask is a bitmap indicating which pixels in the image contain fingers 
	 * or part of the hand in front of the quad.<p>
	 * 
	 * The mask at index 0 corresponds to the left image; that with index 1, to the right image.
	 * 
	 * <blockquote><pre>
	 * TrackedQuad quad = frame.trackedQuad();
	 * Mask leftMask = quad.masks().get(0);
	 * Mask rightMask = quad.masks().get(1);
	 * </pre></blockquote>
	 * 
	 * @return The list of masks for the current set of images.
	 */
	public MaskList masks() {
		return new MaskList(LeapJNI.TrackedQuad_masks(this.swigCPtr, this), true);
	}

	/**
	 * The images from which the state of this {@link TrackedQuad} was derived.<p>
	 * 
	 * These are the same image objects that you can get from the {@link Controller} or {@link Frame} object 
	 * from which you got this {@link TrackedQuad}.
	 * 
	 * <blockquote><pre>
	 * TrackedQuad quad = frame.trackedQuad();
	 * Image leftImage = quad.images().get(0);
	 * Image rightImage = quad.images().get(1);
	 * </pre></blockquote>
	 * 
	 * @return The images from which the state of this {@link TrackedQuad} was derived.
	 */
	public ImageList images() {
		return new ImageList(LeapJNI.TrackedQuad_images(this.swigCPtr, this), true);
	}

	/**
	 * Reports whether this is a valid object.
	 * 
	 * <blockquote><pre>
	 * TrackedQuad quad = frame.trackedQuad();
	 * if(quad.isValid()){
	 *     // Use the quad data...
	 * }
	 * </pre></blockquote>
	 * 
	 * @return True, if this {@link TrackedQuad} object is valid.
	 */
	public boolean isValid() {
		return LeapJNI.TrackedQuad_isValid(this.swigCPtr, this);
	}

	/**
	 * An invalid object.
	 * 
	 * @return An invalid object.
	 */
	public static TrackedQuad invalid() {
		return new TrackedQuad(LeapJNI.TrackedQuad_invalid(), false);
	}

	/**
	 * Compares quad objects for equality.
	 * 
	 * @param trackedQuad - {@link TrackedQuad} object to compare
	 * 
	 * @return true if the {@link TrackedQuad} objects are equal.
	 */
	public boolean equals(TrackedQuad trackedQuad) {
		return LeapJNI.TrackedQuad_equals(this.swigCPtr, this, getCPtr(trackedQuad), trackedQuad);
	}

	/**
	 * A string containing a brief, human readable description of the {@link TrackedQuad} object.
	 * 
	 * @return A description of the {@link TrackedQuad} as a string.
	 */
	public String toString() {
		return LeapJNI.TrackedQuad_toString(this.swigCPtr, this);
	}

	public static long getCPtr(TrackedQuad paramTrackedQuad) {
		return paramTrackedQuad == null ? 0L : paramTrackedQuad.swigCPtr;
	}

	protected void finalize() {
		delete();
	}

	public synchronized void delete() {
		if (this.swigCPtr != 0L) {
			if (this.swigCMemOwn) {
				this.swigCMemOwn = false;
				LeapJNI.delete_TrackedQuad(this.swigCPtr);
			}
			this.swigCPtr = 0L;
		}
		super.delete();
	}

}
