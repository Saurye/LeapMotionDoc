package com.leapmotion.leap;

public class TrackedQuad extends Interface {
	private long swigCPtr;

	public TrackedQuad(long paramLong, boolean paramBoolean)
	{
		super(LeapJNI.TrackedQuad_SWIGUpcast(paramLong), paramBoolean);
		this.swigCPtr = paramLong;
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

	public TrackedQuad() {
		this(LeapJNI.new_TrackedQuad(), true);
	}

	public float width() {
		return LeapJNI.TrackedQuad_width(this.swigCPtr, this);
	}

	public float height() {
		return LeapJNI.TrackedQuad_height(this.swigCPtr, this);
	}

	public int resolutionX() {
		return LeapJNI.TrackedQuad_resolutionX(this.swigCPtr, this);
	}

	public int resolutionY() {
		return LeapJNI.TrackedQuad_resolutionY(this.swigCPtr, this);
	}

	public boolean visible() {
		return LeapJNI.TrackedQuad_visible(this.swigCPtr, this);
	}

	public Matrix orientation() {
		return new Matrix(LeapJNI.TrackedQuad_orientation(this.swigCPtr, this), true);
	}

	public Vector position() {
		return new Vector(LeapJNI.TrackedQuad_position(this.swigCPtr, this), true);
	}

	public MaskList masks() {
		return new MaskList(LeapJNI.TrackedQuad_masks(this.swigCPtr, this), true);
	}

	public ImageList images() {
		return new ImageList(LeapJNI.TrackedQuad_images(this.swigCPtr, this), true);
	}

	public boolean isValid() {
		return LeapJNI.TrackedQuad_isValid(this.swigCPtr, this);
	}

	public static TrackedQuad invalid() {
		return new TrackedQuad(LeapJNI.TrackedQuad_invalid(), false);
	}

	public boolean equals(TrackedQuad paramTrackedQuad) {
		return LeapJNI.TrackedQuad_equals(this.swigCPtr, this, getCPtr(paramTrackedQuad), paramTrackedQuad);
	}

	public String toString() {
		return LeapJNI.TrackedQuad_toString(this.swigCPtr, this);
	}
}
