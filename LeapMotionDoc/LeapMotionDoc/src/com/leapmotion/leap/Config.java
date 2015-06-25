package com.leapmotion.leap;

/**
 * The {@code Config} class provides access to Leap Motion system configuration information.<p>
 * 
 * You can get and set gesture configuration parameters using the {@code Config} object obtained from 
 * a connected {@link Controller} object. The key strings required to identify a configuration parameter include:
 * <p>
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
 * After setting a configuration value, you must call the {@link Config#save()} method to commit the changes. 
 * You can save after the {@link Controller} has connected to the Leap Motion service/daemon. 
 * In other words, after the {@link Controller} has dispatched the serviceConnected or connected events 
 * or {@link Controller#isConnected()} is true. 
 * The configuration value changes are not persistent; your application needs to set the values every time it runs.
 * 
 * @see CircleGesture
 * @see KeyTapGesture
 * @see ScreenTapGesture
 * @see SwipeGesture
 * 
 * @since 1.0
 * @author Leap Motion Inc
 *
 */
public class Config extends Interface {
	private long swigCPtr;

	/**
	 * Constructs a {@link Config} object.<p>
	 * 
	 * Do not create your own {@link Config} objects. Get a {@link Config} object using the 
	 * {@link Controller#config()} function.
	 * 
	 * <blockquote><pre>
	 * Config config = controller.config();
	 * </pre></blockquote>
	 * 
	 */
	public Config() {
		this(LeapJNI.new_Config(), true);
	}

	public Config(long paramLong, boolean paramBoolean)
	{
		super(LeapJNI.Config_SWIGUpcast(paramLong), paramBoolean);
		this.swigCPtr = paramLong;
	}

	/**
	 * Reports the natural data type for the value related to the specified key.
	 * 
	 * <blockquote><pre>
	 * Config.ValueType dataType = controller.config().type("Gesture.KeyTap.MinDistance");
	 * </pre></blockquote>
	 * 
	 * @param key - The key for the looking up the value in the configuration dictionary.
	 * @return The native data type of the value, that is, the type that does not require a data conversion.
	 */
	public ValueType type(String key) {
		return ValueType.swigToEnum(LeapJNI.Config_type(this.swigCPtr, this, key));
	}

	/**
	 * Gets the boolean representation for the specified key.<p>
	 * 
	 * <blockquote><pre>
	 * Boolean booleanValue = controller.config().getBool("Key.For.Bool.Setting");
	 * </pre></blockquote>
	 * 
	 * @param key - specified key
	 * @return boolean representation for the specified key
	 */
	public boolean getBool(String key) {
		return LeapJNI.Config_getBool(this.swigCPtr, this, key);
	}

	/**
	 * Sets the boolean representation for the specified key.<p>
	 * 
	 * <blockquote><pre>
	 * controller.config().setBool("Key.For.Bool.Setting", true);
	 * </pre></blockquote>
	 * 
	 * @param key - specified key
	 * @param value - given value
	 * 
	 * @return true on success, false on failure.
	 */
	public boolean setBool(String key, boolean value) {
		return LeapJNI.Config_setBool(this.swigCPtr, this, key, value);
	}

	/**
	 * Gets the 32-bit integer representation for the specified key.<p>
	 * 
	 * <blockquote><pre>
	 * int intValue = controller.config().getInt32("Key.For.Integer.Setting");
	 * </pre></blockquote>
	 * 
	 * @param key - specified key
	 * @return 32-bit integer representation for the specified key
	 */
	public int getInt32(String key) {
		return LeapJNI.Config_getInt32(this.swigCPtr, this, key);
	}

	/**
	 * Sets the 32-bit integer representation for the specified key.<p>
	 * 
	 * <blockquote><pre>
	 * controller.config().setInt32("Key.For.Integer.Setting", 12);
	 * </pre></blockquote>
	 * 
	 * @param key - specified key
	 * @param value - given value
	 * 
	 * @return true on success, false on failure.
	 */
	public boolean setInt32(String key, int value) {
		return LeapJNI.Config_setInt32(this.swigCPtr, this, key, value);
	}

	/**
	 * Gets the floating point representation for the specified key.<p>
	 * 
	 * <blockquote><pre>
	 * float floatValue = controller.config().getFloat("Gesture.Circle.MinRadius");
	 * </pre></blockquote>
	 * 
	 * @param key - specified key
	 * @return floating point representation for the specified key
	 */
	public float getFloat(String key) {
		return LeapJNI.Config_getFloat(this.swigCPtr, this, key);
	}

	/**
	 * Sets the floating point representation for the specified key.<p>
	 * 
	 * <blockquote><pre>
	 * controller.config().setFloat("Gesture.Circle.MinRadius", 25);
	 * </pre></blockquote>
	 * 
	 * @param key - specified key
	 * @param value - given value
	 * 
	 * @return true on success, false on failure.
	 */
	public boolean setFloat(String key, float value) {
		return LeapJNI.Config_setFloat(this.swigCPtr, this, key, value);
	}

	/**
	 * Gets the string representation for the specified key.<p>
	 * 
	 * <blockquote><pre>
	 * String stringValue = controller.config().getString("Key.For.String.Setting");
	 * </pre></blockquote>
	 * 
	 * @param key - specified key
	 * @return string representation for the specified key
	 */
	public String getString(String key) {
		return LeapJNI.Config_getString(this.swigCPtr, this, key);
	}

	/**
	 * Sets the string representation for the specified key.<p>
	 * 
	 * <blockquote><pre>
	 * controller.config().setString("Key.For.String.Setting", "A String");
	 * </pre></blockquote>
	 * 
	 * @param key - specified key
	 * @param value - given value
	 * 
	 * @return true on success, false on failure.
	 */
	public boolean setString(String key, String value) {
		return LeapJNI.Config_setString(this.swigCPtr, this, key, value);
	}

	/**
	 * Saves the current state of the config.<p>
	 * 
	 * Call {@code save()} after making a set of configuration changes. 
	 * The {@code save()} function transfers the configuration changes to the Leap Motion service. 
	 * You can save after the {@link Controller} has connected to the Leap Motion service/daemon. 
	 * In other words, after the {@link Controller} has dispatched the serviceConnected or connected events or 
	 * {@link Controller#isConnected()} is true. The configuration value changes are not persistent; 
	 * your application must set the values every time it runs.
	 * 
	 * <blockquote><pre>
	 * controller.config().setFloat("Gesture.Circle.MinRadius", 15);
	 * controller.config().setFloat("Gesture.Circle.MinArc", 1.7f);
	 * Boolean success = controller.config().save();
	 * </pre></blockquote>
	 * 
	 * @return true on success, false on failure.
	 */
	public boolean save() {
		return LeapJNI.Config_save(this.swigCPtr, this);
	}

	public static long getCPtr(Config paramConfig) {
		return paramConfig == null ? 0L : paramConfig.swigCPtr;
	}

	protected void finalize() {
		delete();
	}

	public synchronized void delete() {
		if (this.swigCPtr != 0L) {
			if (this.swigCMemOwn) {
				this.swigCMemOwn = false;
				LeapJNI.delete_Config(this.swigCPtr);
			}
			this.swigCPtr = 0L;
		}
		super.delete();
	}

	/**
	 * Enumerates the possible data types for configuration values.<p>
	 * The {@link Config#type(String)} function returns an item from the {@code ValueType} enumeration.
	 * @author Leap Motion Inc
	 *
	 */
	public static enum ValueType {
		TYPE_UNKNOWN(0), 
		TYPE_BOOLEAN(1), 
		TYPE_INT32(2), 
		TYPE_FLOAT(6), 
		TYPE_STRING(8);

		public final int swigValue() {
			return this.swigValue;
		}

		public static ValueType swigToEnum(int paramInt) {
			ValueType[] arrayOfValueType1 = (ValueType[])ValueType.class.getEnumConstants();
			if ((paramInt < arrayOfValueType1.length) && (paramInt >= 0) && (arrayOfValueType1[paramInt].swigValue == paramInt))
				return arrayOfValueType1[paramInt];
			for (ValueType localValueType : arrayOfValueType1)
				if (localValueType.swigValue == paramInt)
					return localValueType;
			throw new IllegalArgumentException("No enum " + ValueType.class + " with value " + paramInt);
		}

		private ValueType()
		{
			this.swigValue = SwigNext.access$008();
		}

		private ValueType(int paramInt)
		{
			this.swigValue = paramInt;
			SwigNext.access$002(paramInt + 1);
		}

		private ValueType(ValueType paramValueType)
		{
			this.swigValue = paramValueType.swigValue;
			SwigNext.access$002(this.swigValue + 1);
		}

		private final int swigValue;
		private static class SwigNext
		{
			private static int next = 0;
		}
	}
}
