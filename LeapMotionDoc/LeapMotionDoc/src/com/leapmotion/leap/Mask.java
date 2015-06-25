package com.leapmotion.leap;

/**
 * Note: This class is an experimental API for internal use only.<p>
 * 
 * It may be removed without warning.<p>
 * 
 * A bitmap mask defining areas of an image in which a finger or part of a hand 
 * is in front of the tracked quad. The mask is a subset of the camera image 
 * containing a the region including the quad. Pixels in the mask representing the hand 
 * have the value 255. Pixels in the rest of the mask have the value 0.<p>
 * 
 * Two masks are provided for every Leap Motion frame. 
 * The mask with the id of 0 is for the left image. The right image has id 1.<p>
 * 
 * The mask corresponds to the uncorrected image from the camera sensor. 
 * If you correct the image for distortion before displaying it, you should also correct the mask.
 * 
 * @since 2.2.6 
 * @author Leap Motion Inc
 */
public class Mask extends Interface {
	private long swigCPtr;

	/**
	 * Constructs a new {@code Mask} object.<p>
	 * 
	 * Do not use. Get {@code Mask} objects from {@link TrackedQuad}.
	 * 
	 * <blockquote><pre>
	 * Controller controller = new Controller();
	 * TrackedQuad quad = controller.trackedQuad();
	 * Mask leftMask = quad.masks().get(0);
	 * Mask rightMask = quad.masks().get(1);
	 * 
	 * Controller controller = new Controller();
	 * Frame frame = controller.frame();
	 * TrackedQuad quad = frame.trackedQuad();
	 * Mask leftMask = quad.masks().get(0);
	 * Mask rightMask = quad.masks().get(1);
	 * </pre></blockquote>
	 */
	public Mask() {
		this(LeapJNI.new_Mask(), true);
	}
	
	public Mask(long paramLong, boolean paramBoolean)
	{
		super(LeapJNI.Mask_SWIGUpcast(paramLong), paramBoolean);
		this.swigCPtr = paramLong;
	}

	/**
	 * The mask data.<p>
	 * 
	 * The mask data is a set of 8-bit intensity values. 
	 * The buffer is image.width() * image.height() bytes long. 
	 * Areas of the mask which contain part of a hand or finger covering the quad 
	 * are assigned the value 255. The rest of the mask is assigned the value 0.
	 * 
	 * <blockquote><pre>
	 * Mask leftMask = quad.masks().get(0);
	 * byte[] maskPixels = leftMask.data();
	 * </pre></blockquote> 
	 * 
	 * @return The mask data.
	 */
	public byte[] data() {
		byte[] arrayOfByte = new byte[width() * height()];
		LeapJNI.Mask_data(this.swigCPtr, this, arrayOfByte);
		return arrayOfByte;
	}

	/**
	 * An id value based on the sequence in which the mask is produced.<p>
	 * 
	 * Corresponds to the {@link Image} sequence id.
	 * 
	 * <blockquote><pre>
	 * Mask leftMask = quad.masks().get(0);
	 * long sequenceID = leftMask.sequenceId();
	 * </pre></blockquote>
	 * 
	 * @return The sequence id.
	 */
	public long sequenceId() {
		return LeapJNI.Mask_sequenceId(this.swigCPtr, this);
	}

	/**
	 * An id indicating whether the mask goes with the left (0) or right (1) image.
	 * 
	 * <blockquote><pre>
	 * Mask leftMask = quad.masks().get(0);
	 * int id = leftMask.id();
	 * </pre></blockquote>
	 * 
	 * @return The image id.
	 */
	public int id() {
		return LeapJNI.Mask_id(this.swigCPtr, this);
	}

	public void data(byte[] paramArrayOfByte) {
		LeapJNI.Mask_data(this.swigCPtr, this, paramArrayOfByte);
	}

	/**
	 * The width of the mask in {@link Image} pixels.
	 * 
	 * <blockquote><pre>
	 * Mask leftMask = quad.masks().get(0);
	 * int width = leftMask.width();
	 * </pre></blockquote>
	 * 
	 * @return The width of the mask in {@link Image} pixels.
	 */
	public int width() {
		return LeapJNI.Mask_width(this.swigCPtr, this);
	}

	/**
	 * The height of the mask in {@link Image} pixels.
	 * 
	 * <blockquote><pre>
	 * Mask leftMask = quad.masks().get(0);
	 * int height = leftMask.height();
	 * </pre></blockquote>
	 * 
	 * @return The height of the mask in {@link Image} pixels.
	 */
	public int height() {
		return LeapJNI.Mask_height(this.swigCPtr, this);
	}

	/**
	 * The offset of the mask from the left edge of the {@link Image} in pixels.
	 * 
	 * <blockquote><pre>
	 * Mask leftMask = quad.masks().get(0);
	 * int x = leftMask.offsetX();
	 * </pre></blockquote>
	 * 
	 * @return The offset of the mask.
	 */
	public int offsetX() {
		return LeapJNI.Mask_offsetX(this.swigCPtr, this);
	}

	/**
	 * The offset of the mask from the top edge of the {@link Image} in pixels.
	 * 
	 * <blockquote><pre>
	 * Mask leftMask = quad.masks().get(0);
	 * int y = leftMask.offsetY();
	 * </pre></blockquote>
	 * 
	 * @return The y offset of the mask.
	 */
	public int offsetY() {
		return LeapJNI.Mask_offsetY(this.swigCPtr, this);
	}

	/**
	 * Reports whether this is a valid {@code Mask} object.
	 * 
	 * @return True, if this {@code Mask} object is valid.
	 */
	public boolean isValid() {
		return LeapJNI.Mask_isValid(this.swigCPtr, this);
	}

	/**
	 * An invalid {@code Mask} object.
	 * 
	 * @return An invalid {@code Mask} object.
	 */
	public static Mask invalid() {
		return new Mask(LeapJNI.Mask_invalid(), false);
	}

	/**
	 * Compares two Mask objects for equality.
	 * 
	 * @param mask - {@code Mask} object to compare
	 * 
	 * @return true if the {@code Mask} objects are equal.
	 */
	public boolean equals(Mask mask) {
		return LeapJNI.Mask_equals(this.swigCPtr, this, getCPtr(mask), mask);
	}

	/**
	 * A string containing a brief, human readable description of the {@code Mask} object.
	 * 
	 * @return A description of the {@code Mask} as a string.
	 */
	public String toString() {
		return LeapJNI.Mask_toString(this.swigCPtr, this);
	}

	public static long getCPtr(Mask paramMask) {
		return paramMask == null ? 0L : paramMask.swigCPtr;
	}

	protected void finalize() {
		delete();
	}

	public synchronized void delete() {
		if (this.swigCPtr != 0L) {
			if (this.swigCMemOwn) {
				this.swigCMemOwn = false;
				LeapJNI.delete_Mask(this.swigCPtr);
			}
			this.swigCPtr = 0L;
		}
		super.delete();
	}

}
