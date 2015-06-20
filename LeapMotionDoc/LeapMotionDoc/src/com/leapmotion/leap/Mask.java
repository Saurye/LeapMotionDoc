package com.leapmotion.leap;

public class Mask extends Interface {
	private long swigCPtr;

	public Mask(long paramLong, boolean paramBoolean)
	{
		super(LeapJNI.Mask_SWIGUpcast(paramLong), paramBoolean);
		this.swigCPtr = paramLong;
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











	public byte[] data()
	{
		byte[] arrayOfByte = new byte[width() * height()];
		LeapJNI.Mask_data(this.swigCPtr, this, arrayOfByte);
		return arrayOfByte;
	}

	public Mask() {
		this(LeapJNI.new_Mask(), true);
	}

	public long sequenceId() {
		return LeapJNI.Mask_sequenceId(this.swigCPtr, this);
	}

	public int id() {
		return LeapJNI.Mask_id(this.swigCPtr, this);
	}

	public void data(byte[] paramArrayOfByte) {
		LeapJNI.Mask_data(this.swigCPtr, this, paramArrayOfByte);
	}

	public int width() {
		return LeapJNI.Mask_width(this.swigCPtr, this);
	}

	public int height() {
		return LeapJNI.Mask_height(this.swigCPtr, this);
	}

	public int offsetX() {
		return LeapJNI.Mask_offsetX(this.swigCPtr, this);
	}

	public int offsetY() {
		return LeapJNI.Mask_offsetY(this.swigCPtr, this);
	}

	public boolean isValid() {
		return LeapJNI.Mask_isValid(this.swigCPtr, this);
	}

	public static Mask invalid() {
		return new Mask(LeapJNI.Mask_invalid(), false);
	}

	public boolean equals(Mask paramMask) {
		return LeapJNI.Mask_equals(this.swigCPtr, this, getCPtr(paramMask), paramMask);
	}

	public String toString() {
		return LeapJNI.Mask_toString(this.swigCPtr, this);
	}
}
