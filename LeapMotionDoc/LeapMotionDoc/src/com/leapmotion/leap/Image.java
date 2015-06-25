package com.leapmotion.leap;

/**
 * The Image class represents a single image from one of the Leap Motion cameras.<p>
 * 
 * In addition to image data, the {@code Image} object provides a distortion map for correcting lens distortion.
 * 
 * <blockquote><pre>
 * Frame frame = controller.frame();
 *  if(frame.isValid()){
 *     ImageList images = frame.images();
 *     for(Image image : images) {
 *         //Processing PImage class
 *         PImage camera = cameras[image.id()];
 *         camera = createImage(image.width(), image.height(), RGB);
 *         camera.loadPixels();
 *         
 *         //Get byte array containing the image data from Image object
 *         byte[] imageData = image.data();
 *        
 *         //Copy image data into display object, in this case PImage defined in Processing
 *         for(int i = 0; i < image.width() * image.height(); i++){
 *             r = (imageData[i] & 0xFF) << 16; //convert to unsigned and shift into place
 *             g = (imageData[i] & 0xFF) << 8;
 *             b = imageData[i] & 0xFF;
 *             camera.pixels[i] =  r | g | b;
 *         }
 *         
 *         //Show the image
 *         camera.updatePixels();
 *         image(camera, 640 * image.id(), 0);
 *     }
 * } 
 * </pre></blockquote>
 *
 * Note that {@code Image} objects can be invalid, which means that they do not contain valid image data. 
 * Get valid {@code Image} objects from {@link Frame#images()}. Test for validity with the {@link Image#isValid()} function.
 *
 * @since 2.1.0
 * @author Leap Motion Inc
 */
public class Image extends Interface {
	private long swigCPtr;

	/**
	 * Constructs a {@link Image} object.<p>
	 * 
	 * An uninitialized image is considered invalid. 
	 * Get valid {@link Image} objects from a {@link ImageList} object obtained from the {@link Frame#images()} method.
	 */
	public Image() {
		this(LeapJNI.new_Image(), true);
	}
	
	public Image(long paramLong, boolean paramBoolean)
	{
		super(LeapJNI.Image_SWIGUpcast(paramLong), paramBoolean);
		this.swigCPtr = paramLong;
	}

	/**
	 * The image data.<p>
	 * 
	 * The image data is a set of 8-bit intensity values. 
	 * The buffer is {@link Image#width()} * {@link Image#height()} * {@link Image#bytesPerPixel()} bytes long.
	 * 
	 * <blockquote><pre>
	 * byte[] image_buffer = image.data();
	 * </pre></blockquote>
	 * 
	 * @return The image data in bytes.
	 */
	public byte[] data()
	{
		byte[] arrayOfByte = new byte[width() * height() * bytesPerPixel()];
		LeapJNI.Image_data(this.swigCPtr, this, arrayOfByte);
		return arrayOfByte;
	}
	
	/**
	 * The distortion calibration map for this image.<p>
	 * 
	 * The calibration map is a 64x64 grid of points. Each point is defined by a pair of 32-bit floating point values. 
	 * Each point in the map represents a ray projected into the camera. 
	 * The value of a grid point defines the pixel in the image data containing the brightness value 
	 * produced by the light entering along the corresponding ray. 
	 * By interpolating between grid data points, you can find the brightness value for any projected ray. 
	 * Grid values that fall outside the range [0..1] do not correspond to a value in the image data 
	 * and those points should be ignored.
	 * 
	 * <blockquote><pre>
	 * float[] distortion_buffer = image.distortion();
	 * </pre></blockquote>
	 * 
	 * The calibration map can be used to render an undistorted image as well as to find the true angle 
	 * from the camera to a feature in the raw image. The distortion map itself is designed to be used 
	 * with GLSL shader programs. In other contexts, it may be more convenient to use the {@link Image#rectify(Vector)} 
	 * and {@link Image#warp(Vector)} functions.<p>
	 * 
	 * Distortion is caused by the lens geometry as well as imperfections in the lens and sensor window. 
	 * The calibration map is created by the calibration process run for each device at the factory 
	 * (and which can be rerun by the user).
	 * 
	 * @return The float array containing the camera lens calibration map.
	 */
	public float[] distortion()
	{
		float[] arrayOfFloat = new float[distortionWidth() * distortionHeight()];
		LeapJNI.Image_distortion(this.swigCPtr, this, arrayOfFloat);
		return arrayOfFloat;
	}

	/**
	 * The image sequence ID.
	 * 
	 * <blockquote><pre>
	 * long imageSequence = image.sequenceId();
	 * </pre></blockquote>
	 * 
	 * @return The image sequence ID.
	 */
	public long sequenceId() {
		return LeapJNI.Image_sequenceId(this.swigCPtr, this);
	}

	/**
	 * The image ID.<p>
	 * 
	 * Images with ID of 0 are from the left camera; 
	 * those with an ID of 1 are from the right camera 
	 * (with the device in its standard operating position with the green LED facing the operator).
	 * 
	 * @return The image ID.
	 */
	public int id() {
		return LeapJNI.Image_id(this.swigCPtr, this);
	}

	public void data(byte[] paramArrayOfByte) {
		LeapJNI.Image_data(this.swigCPtr, this, paramArrayOfByte);
	}

	public void distortion(float[] paramArrayOfFloat) {
		LeapJNI.Image_distortion(this.swigCPtr, this, paramArrayOfFloat);
	}

	/**
	 * The image width.
	 * 
	 * <blockquote><pre>
	 * int width = image.width();
	 * </pre></blockquote>
	 * 
	 * @return The image width.
	 */
	public int width() {
		return LeapJNI.Image_width(this.swigCPtr, this);
	}

	/**
	 * The image height.
	 * 
	 * <blockquote><pre>
	 * int height = image.height();
	 * </pre></blockquote>
	 * 
	 * @return The image height.
	 */
	public int height() {
		return LeapJNI.Image_height(this.swigCPtr, this);
	}

	/**
	 * The number of bytes per pixel.<p>
	 * 
	 * Use this value along with {@link Image#width()} and {@link Image#height()} to calculate the size of the data buffer.
	 * 
	 * <blockquote><pre>
	 * int bufferSize = image.bytesPerPixel() * image.width() * image.height();
	 * </pre></blockquote>
	 * 
	 * @return The number of bytes per pixel.
	 */
	public int bytesPerPixel() {
		return LeapJNI.Image_bytesPerPixel(this.swigCPtr, this);
	}

	/**
	 * The image format.
	 * 
	 * <blockquote><pre>
	 * if(image.format() == Image.FormatType.INFRARED){
	 *     String openGL_format = "GL_RED";
	 *     String openGL_type = "GL_UNSIGNED_BYTE";
	 * }
	 * </pre></blockquote>
	 * 
	 * @return The image {@link FormatType}.
	 */
	public FormatType format() {
		return FormatType.swigToEnum(LeapJNI.Image_format(this.swigCPtr, this));
	}

	/**
	 * The stride of the distortion map.<p>
	 * 
	 * Since each point on the 64x64 element distortion map has two values in the buffer, 
	 * the stride is 2 times the size of the grid. (Stride is currently fixed at 2 * 64 = 128).
	 * 
	 * <blockquote><pre>
	 * int correctionGridWidth = image.distortionWidth();
	 * </pre></blockquote>
	 * 
	 * @return The stride of the distortion map.
	 */
	public int distortionWidth() {
		return LeapJNI.Image_distortionWidth(this.swigCPtr, this);
	}

	/**
	 * The distortion map height.<p>
	 * 
	 * Currently fixed at 64.
	 * 
	 * <blockquote><pre>
	 * int correctionGridHeight = image.distortionHeight();
	 * </pre></blockquote>
	 * 
	 * @return The distortion map height.
	 */
	public int distortionHeight() {
		return LeapJNI.Image_distortionHeight(this.swigCPtr, this);
	}

	/**
	 * The horizontal ray offset.<p>
	 * 
	 * Used to convert between normalized coordinates in the range [0..1] and the ray slope range [-4..4].
	 * 
	 * <blockquote><pre>
	 * Vector raySlopes = new Vector(-3.28f, 1.76f, 0.0f);
	 * Vector normRay =
	 *       new Vector(raySlopes.getX() * image.rayScaleX() + image.rayOffsetX(),
	         raySlopes.getY() * image.rayScaleY() + image.rayOffsetY(), 0);
	 * </pre></blockquote>
	 * 
	 * @return The horizontal ray offset.
	 */
	public float rayOffsetX() {
		return LeapJNI.Image_rayOffsetX(this.swigCPtr, this);
	}

	/**
	 * The vertical ray offset.<p>
	 * 
	 * Used to convert between normalized coordinates in the range [0..1] and the ray slope range [-4..4].
	 * 
	 * <blockquote><pre>
	 * Vector normSlopes = new Vector(.09f, .72f, 0.0f);
	 * Vector slope = new Vector((normSlopes.getX() - image.rayOffsetX())/image.rayScaleX(),
	 *                           (normSlopes.getY() - image.rayOffsetY())/image.rayScaleY(), 0);
	 * </pre></blockquote>
	 * 
	 * @return The vertical ray offset.
	 */
	public float rayOffsetY() {
		return LeapJNI.Image_rayOffsetY(this.swigCPtr, this);
	}

	/**
	 * The horizontal ray scale offset.<p>
	 * 
	 * Used to convert between normalized coordinates in the range [0..1] and the ray slope range [-4..4].
	 * 
	 * <blockquote><pre>
	 * Vector raySlopes = new Vector(-3.28f, 1.76f, 0.0f);
	 * Vector normRay =
	 *       new Vector(raySlopes.getX() * image.rayScaleX() + image.rayOffsetX(),
	 *                  raySlopes.getY() * image.rayScaleY() + image.rayOffsetY(), 0);
	 * </pre></blockquote>
	 * 
	 * @return The horizontal ray scale offset.
	 */
	public float rayScaleX() {
		return LeapJNI.Image_rayScaleX(this.swigCPtr, this);
	}

	/**
	 * The vertical ray scale offset.<p>
	 * 
	 * Used to convert between normalized coordinates in the range [0..1] and the ray slope range [-4..4].
	 * 
	 * <blockquote><pre>
	 * Vector raySlopes = new Vector(-3.28f, 1.76f, 0.0f);
	 * Vector normRay =
	 *       new Vector(raySlopes.getX() * image.rayScaleX() + image.rayOffsetX(),
	 *                  raySlopes.getY() * image.rayScaleY() + image.rayOffsetY(), 0);
	 * </pre></blockquote>
	 * 
	 * @return The vertical ray scale offset.
	 */
	public float rayScaleY() {
		return LeapJNI.Image_rayScaleY(this.swigCPtr, this);
	}

	/**
	 * Provides the corrected camera ray intercepting the specified point on the image.<p>
	 * 
	 * Given a point on the image, {@code rectify()} corrects for camera distortion 
	 * and returns the true direction from the camera to the source of that image point 
	 * within the Leap Motion field of view.<p>
	 * 
	 * This direction vector has an x and y component [x, y, 0], with the third element always zero. 
	 * Note that this vector uses the 2D camera coordinate system where the x-axis parallels the longer 
	 * (typically horizontal) dimension and the y-axis parallels the shorter (vertical) dimension. 
	 * The camera coordinate system does not correlate to the 3D Leap Motion coordinate system.
	 * 
	 * <blockquote><pre>
	 * Vector feature = new Vector(127, 68, 0);
	 * Vector slopes = image.rectify(feature);
	 * </pre></blockquote>
	 * 
	 * @param uv - A {@link Vector} containing the position of a pixel in the image. 
	 * 
	 * @return A {@link Vector} containing the ray direction (the z-component of the vector is always 0).
	 */
	public Vector rectify(Vector uv) {
		return new Vector(LeapJNI.Image_rectify(this.swigCPtr, this, Vector.getCPtr(uv), uv), true);
	}

	/**
	 * Provides the point in the image corresponding to a ray projecting from the camera.<p>
	 * 
	 * Given a ray projected from the camera in the specified direction, {@code warp()} 
	 * corrects for camera distortion and returns the corresponding pixel coordinates in the image.<p>
	 * 
	 * The ray direction is specified in relationship to the camera. 
	 * The first vector element corresponds to the “horizontal” view angle; 
	 * the second corresponds to the “vertical” view angle.
	 * 
	 * <blockquote><pre>
	 * float horizontal_slope = (float)Math.tan(65 * Math.PI/180);
	 * float vertical_slope = (float)Math.tan(15 * Math.PI/180);
	 * Vector pixel = image.warp(new Vector(horizontal_slope, vertical_slope, 0));
	 * if(pixel.getX() >= 0 && pixel.getY() >= 0 && pixel.getX() <= image.width() && pixel.getY() <= image.height()){
	 *     int data_index = (int)pixel.getY() * image.width() + (int)pixel.getX();
	 *     byte brightness = image.data()[data_index];
	 * }
	 * </pre></blockquote>
	 * 
	 * The {@code warp()} function returns pixel coordinates outside of the image bounds 
	 * if you project a ray toward a point for which there is no recorded data.<p>
	 * 
	 * {@code warp()} is typically not fast enough for realtime distortion correction. 
	 * For better performance, use a shader program executed on a GPU.
	 * 
	 * @param xy - A {@link Vector} containing the ray direction.
	 * 
	 * @return A {@link Vector} containing the pixel coordinates [x, y, 0] (with z always zero).
	 */
	public Vector warp(Vector xy) {
		return new Vector(LeapJNI.Image_warp(this.swigCPtr, this, Vector.getCPtr(xy), xy), true);
	}

	/**
	 * Reports whether this {@link Image} instance contains valid data.
	 * 
	 * @return true, if and only if the image is valid.
	 */
	public boolean isValid() {
		return LeapJNI.Image_isValid(this.swigCPtr, this);
	}

	/**
	 * Returns an invalid {@link Image} object.<p>
	 * 
	 * You can use the instance returned by this function in comparisons testing 
	 * whether a given {@link Image} instance is valid or invalid. (You can also use the {@link Image#isValid()} function.)
	 * 
	 * @return The invalid {@link Image} instance.
	 */
	public static Image invalid() {
		return new Image(LeapJNI.Image_invalid(), false);
	}

	/**
	 * Compare {@link Image} object equality.<p>
	 * 
	 * Two {@link Image} objects are equal if and only if both {@link Image} objects represent 
	 * the exact same {@link Image} and both Images are valid.
	 * 
	 * @param image - {@link Image} object to compare
	 * 
	 * @return true if the {@link Image} objects are equal.
	 */
	public boolean equals(Image image) {
		return LeapJNI.Image_equals(this.swigCPtr, this, getCPtr(image), image);
	}

	/**
	 * A string containing a brief, human readable description of the {@link Image} object.
	 * 
	 * @return A description of the {@link Image} as a string.
	 */
	public String toString() {
		return LeapJNI.Image_toString(this.swigCPtr, this);
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

	/**
	 * Enumerates the possible image formats.<p>
	 * 
	 * The {@link Image#format()} function returns an item from the {@code FormatType} enumeration.
	 *
	 * @since 2.2.0
	 * @author Leap Motion Inc
	 */
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
