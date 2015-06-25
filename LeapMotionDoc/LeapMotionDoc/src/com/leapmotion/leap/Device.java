package com.leapmotion.leap;

/**
 * The {@code Device} class represents a physically connected device.<p>
 * 
 * The {@code Device} class contains information related to a particular connected device 
 * such as device id, field of view relative to the device, and the position 
 * and orientation of the device in relative coordinates.<p>
 * 
 * The position and orientation describe the alignment of the device relative to the user. 
 * The alignment relative to the user is only descriptive. Aligning devices to users provides 
 * consistency in the parameters that describe user interactions.<p>
 * 
 * Note that {@code Device} objects can be invalid, which means that they do not contain valid device information 
 * and do not correspond to a physical device. Test for validity with the {@link Device#isValid()} function.
 * 
 * @since 1.0
 * @author Leap Motion Inc
 */
public class Device extends Interface {
	private long swigCPtr;

	/**
	 * Constructs a {@link Device} object.<p>
	 * 
	 * <blockquote><pre>
	 * Device device = controller.devices().get(0);
	 * </pre></blockquote>
	 * 
	 * An uninitialized device is considered invalid. 
	 * Get valid {@link Device} objects from a {@link DeviceList} object obtained using 
	 * the {@link Controller#devices()} method.
	 */
	public Device() {
		this(LeapJNI.new_Device(), true);
	}
	
	public Device(long paramLong, boolean paramBoolean)
	{
		super(LeapJNI.Device_SWIGUpcast(paramLong), paramBoolean);
		this.swigCPtr = paramLong;
	}

	/**
	 * The angle of view along the x axis of this device.<p>
	 * 
	 * <img src="\images\Leap_horizontalViewAngle.png"/><p>
	 * 
	 * The Leap Motion controller scans a region in the shape of an inverted pyramid centered at 
	 * the device’s center and extending upwards. 
	 * The horizontalViewAngle reports the view angle along the long dimension of the device.
	 * 
	 * <blockquote><pre>
	 * float angleOnLongDimension = device.horizontalViewAngle();
	 * </pre></blockquote>
	 * 
	 * @return The horizontal angle of view in radians.
	 */
	public float horizontalViewAngle() {
		return LeapJNI.Device_horizontalViewAngle(this.swigCPtr, this);
	}

	/**
	 * The angle of view along the z axis of this device.<p>
	 * 
	 * <img src="\images\Leap_verticalViewAngle.png"/><p>
	 * 
	 * The Leap Motion controller scans a region in the shape of an inverted pyramid centered at 
	 * the device’s center and extending upwards. 
	 * The verticalViewAngle reports the view angle along the short dimension of the device.
	 * 
	 * <blockquote><pre>
	 * float angleOnShortDimension = device.verticalViewAngle();
	 * </pre></blockquote>
	 * 
	 * @return The vertical angle of view in radians.
	 */
	public float verticalViewAngle() {
		return LeapJNI.Device_verticalViewAngle(this.swigCPtr, this);
	}

	/**
	 * The maximum reliable tracking range from the center of this device.<p>
	 * 
	 * The range reports the maximum recommended distance from the device center for which tracking 
	 * is expected to be reliable. This distance is not a hard limit. 
	 * Tracking may be still be functional above this distance or begin to degrade slightly 
	 * before this distance depending on calibration and extreme environmental conditions.
	 * 
	 * <blockquote><pre>
	 * float range = device.range();
	 * </pre></blockquote>
	 * 
	 * @return The recommended maximum range of the device in mm.
	 */
	public float range() {
		return LeapJNI.Device_range(this.swigCPtr, this);
	}

	/**
	 * The device baseline refers to the separation distance between stereo sensors on the device.<p>
	 * 
	 * The baseline value, together with the maximum resolution, influence the maximum range.
	 * 
	 * @return The separation distance between the center of each sensor, in mm
	 */
	public float baseline() {
		return LeapJNI.Device_baseline(this.swigCPtr, this);
	}

	/**
	 * The distance to the nearest edge of the Leap Motion controller’s view volume.<p>
	 * 
	 * The view volume is an axis-aligned, inverted pyramid centered on the device origin 
	 * and extending upward to the range limit. 
	 * The walls of the pyramid are described by the 
	 * {@link Device#horizontalViewAngle()} and {@link Device#verticalViewAngle()} 
	 * and the roof by the range. This function estimates the distance between the specified input position 
	 * and the nearest wall or roof of the view volume.
	 * 
	 * <blockquote><pre>
	 * Pointable frontFinger = controller.frame().fingers().frontmost();
	 * float distanceToBoxWall = device.distanceToBoundary(frontFinger.tipPosition());
	 * </pre></blockquote>
	 * 
	 * @param position - The point to use for the distance calculation.
	 * 
	 * @return The distance in millimeters from the input position to the nearest boundary.
	 */
	public float distanceToBoundary(Vector position) {
		return LeapJNI.Device_distanceToBoundary(this.swigCPtr, this, Vector.getCPtr(position), position);
	}

	/**
	 * Reports whether this device is embedded in another computer or computer peripheral.
	 * 
	 * @return True, if this device is embedded in a laptop, keyboard, or other computer component; 
	 * false, if this device is a standalone controller.
	 */
	public boolean isEmbedded() {
		return LeapJNI.Device_isEmbedded(this.swigCPtr, this);
	}

	/**
	 * Reports whether this device is streaming data to your application.<p>
	 * 
	 * Currently only one controller can provide data at a time.
	 * 
	 * @return true if this device is streaming data
	 */
	public boolean isStreaming() {
		return LeapJNI.Device_isStreaming(this.swigCPtr, this);
	}

	/**
	 * Deprecated.
	 * 
	 * Always reports false.
	 */
	@Deprecated
	public boolean isFlipped() {
		return LeapJNI.Device_isFlipped(this.swigCPtr, this);
	}

	/**
	 * The device type.<p>
	 * 
	 * Use the device type value in the (rare) circumstances that you have an application feature 
	 * which relies on a particular type of device. 
	 * Current types of device include the original Leap Motion peripheral, 
	 * keyboard-embedded controllers, and laptop-embedded controllers.
	 * 
	 * @return The physical device type as a member of the {@link Type} enumeration.
	 */
	public Type type() {
		return Type.swigToEnum(LeapJNI.Device_type(this.swigCPtr, this));
	}

	/**
	 * An alphanumeric serial number unique to each device. <p>
	 * 
	 * Consumer device serial numbers consist of 2 letters followed by 11 digits.<p>
	 * 
	 * When using multiple devices, the serial number provides an unambiguous identifier for each device.
	 * 
	 * @return the device's serical number.
	 */
	public String serialNumber() {
		return LeapJNI.Device_serialNumber(this.swigCPtr, this);
	}

	public Vector position() {
		return new Vector(LeapJNI.Device_position(this.swigCPtr, this), true);
	}

	public Matrix orientation() {
		return new Matrix(LeapJNI.Device_orientation(this.swigCPtr, this), true);
	}

	/**
	 * Reports whether this is a valid {@link Device} object.
	 * 
	 * <blockquote><pre>
	 * if (!device.isValid()) {
	 *     float maxRange = device.range();
	 * }
	 * </pre></blockquote>
	 * 
	 * @return True, if this {@link Device} object contains valid data.
	 */
	public boolean isValid() {
		return LeapJNI.Device_isValid(this.swigCPtr, this);
	}

	/**
	 * Returns an invalid {@link Device} object.<p>
	 * 
	 * You can use the instance returned by this function in comparisons testing whether a given 
	 * {@link Device} instance is valid or invalid. (You can also use the {@link Device#isValid()} function.)
	 * 
	 * <blockquote><pre>
	 * if (device != Device.invalid()) {
	 *     float trackingRange = device.range();
	 * }
	 * </pre></blockquote>
	 * 
	 * @return The invalid {@link Device} instance.
	 */
	public static Device invalid() {
		return new Device(LeapJNI.Device_invalid(), false);
	}

	/**
	 * Compare {@link Device} object equality.
	 * 
	 * <blockquote><pre>
	 * Boolean isEqual = thisDevice.equals(thatDevice);
	 * </pre></blockquote>
	 * 
	 * Two {@link Device} objects are equal if and only if both {@link Device} objects 
	 * represent the exact same {@link Device} and both Devices are valid.
	 * 
	 * @param device - {@link Device} object to compare
	 * 
	 * @return true if the {@link Device} objects are equal.
	 */
	public boolean equals(Device device) {
		return LeapJNI.Device_equals(this.swigCPtr, this, getCPtr(device), device);
	}

	/**
	 * A string containing a brief, human readable description of the {@link Device} object.
	 * 
	 * @return A description of the Device as a string.
	 */
	public String toString() {
		return LeapJNI.Device_toString(this.swigCPtr, this);
	}

	public static long getCPtr(Device paramDevice) {
		return paramDevice == null ? 0L : paramDevice.swigCPtr;
	}

	protected void finalize() {
		delete();
	}

	public synchronized void delete() {
		if (this.swigCPtr != 0L) {
			if (this.swigCMemOwn) {
				this.swigCMemOwn = false;
				LeapJNI.delete_Device(this.swigCPtr);
			}
			this.swigCPtr = 0L;
		}
		super.delete();
	}
	
	/**
	 * The available types of Leap Motion controllers.
	 * 
	 * @since 1.2
	 * @author Leap Motion Inc
	 */
	public static enum Type {
		TYPE_PERIPHERAL(1), 
		TYPE_LAPTOP, 
		TYPE_KEYBOARD;

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
}
