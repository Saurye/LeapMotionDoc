package com.leapmotion.leap;

public class Image extends Interface {
	private long swigCPtr;

	public Image(long paramLong, boolean paramBoolean)
	{
		super(LeapJNI.Image_SWIGUpcast(paramLong), paramBoolean);
		this.swigCPtr = paramLong;
	}

	public static long getCPtr(Image paramImage) {
		return paramImage == null ? 0L : paramImage.swigCPtr;
	}

	protected void finalize() {
		delete();
	}

	public synchronized void delete() {
		if (this.swigCPtr != 0L) {
			if (this.swigCMemOwn) {
				this.swigCMemOwn = false;
				LeapJNI.delete_Image(this.swigCPtr);
			}
			this.swigCPtr = 0L;
		}
		super.delete();
	}










	public byte[] data()
	{
		byte[] arrayOfByte = new byte[width() * height() * bytesPerPixel()];
		LeapJNI.Image_data(this.swigCPtr, this, arrayOfByte);
		return arrayOfByte;
	}



























	public float[] distortion()
	{
		float[] arrayOfFloat = new float[distortionWidth() * distortionHeight()];
		LeapJNI.Image_distortion(this.swigCPtr, this, arrayOfFloat);
		return arrayOfFloat;
	}

	public Image() {
		this(LeapJNI.new_Image(), true);
	}

	public long sequenceId() {
		return LeapJNI.Image_sequenceId(this.swigCPtr, this);
	}

	public int id() {
		return LeapJNI.Image_id(this.swigCPtr, this);
	}

	public void data(byte[] paramArrayOfByte) {
		LeapJNI.Image_data(this.swigCPtr, this, paramArrayOfByte);
	}

	public void distortion(float[] paramArrayOfFloat) {
		LeapJNI.Image_distortion(this.swigCPtr, this, paramArrayOfFloat);
	}

	public int width() {
		return LeapJNI.Image_width(this.swigCPtr, this);
	}

	public int height() {
		return LeapJNI.Image_height(this.swigCPtr, this);
	}

	public int bytesPerPixel() {
		return LeapJNI.Image_bytesPerPixel(this.swigCPtr, this);
	}

	public FormatType format() {
		return FormatType.swigToEnum(LeapJNI.Image_format(this.swigCPtr, this));
	}

	public int distortionWidth() {
		return LeapJNI.Image_distortionWidth(this.swigCPtr, this);
	}

	public int distortionHeight() {
		return LeapJNI.Image_distortionHeight(this.swigCPtr, this);
	}

	public float rayOffsetX() {
		return LeapJNI.Image_rayOffsetX(this.swigCPtr, this);
	}

	public float rayOffsetY() {
		return LeapJNI.Image_rayOffsetY(this.swigCPtr, this);
	}

	public float rayScaleX() {
		return LeapJNI.Image_rayScaleX(this.swigCPtr, this);
	}

	public float rayScaleY() {
		return LeapJNI.Image_rayScaleY(this.swigCPtr, this);
	}

	public Vector rectify(Vector paramVector) {
		return new Vector(LeapJNI.Image_rectify(this.swigCPtr, this, Vector.getCPtr(paramVector), paramVector), true);
	}

	public Vector warp(Vector paramVector) {
		return new Vector(LeapJNI.Image_warp(this.swigCPtr, this, Vector.getCPtr(paramVector), paramVector), true);
	}

	public boolean isValid() {
		return LeapJNI.Image_isValid(this.swigCPtr, this);
	}

	public static Image invalid() {
		return new Image(LeapJNI.Image_invalid(), false);
	}

	public boolean equals(Image paramImage) {
		return LeapJNI.Image_equals(this.swigCPtr, this, getCPtr(paramImage), paramImage);
	}

	public String toString() {
		return LeapJNI.Image_toString(this.swigCPtr, this);
	}

	public static enum FormatType {
		INFRARED(0);

		public final int swigValue() {
			return this.swigValue;
		}

		public static FormatType swigToEnum(int paramInt) {
			FormatType[] arrayOfFormatType1 = (FormatType[])FormatType.class.getEnumConstants();
			if ((paramInt < arrayOfFormatType1.length) && (paramInt >= 0) && (arrayOfFormatType1[paramInt].swigValue == paramInt))
				return arrayOfFormatType1[paramInt];
			for (FormatType localFormatType : arrayOfFormatType1)
				if (localFormatType.swigValue == paramInt)
					return localFormatType;
			throw new IllegalArgumentException("No enum " + FormatType.class + " with value " + paramInt);
		}

		private FormatType()
		{
			this.swigValue = SwigNext.access$008();
		}

		private FormatType(int paramInt)
		{
			this.swigValue = paramInt;
			SwigNext.access$002(paramInt + 1);
		}

		private FormatType(FormatType paramFormatType)
		{
			this.swigValue = paramFormatType.swigValue;
			SwigNext.access$002(this.swigValue + 1);
		}

		private final int swigValue;
		private static class SwigNext
		{
			private static int next = 0;
		}
	}
}
