package com.leapmotion.leap;

/**
 * The {@code Vector} struct represents a three-component mathematical vector or point 
 * such as a direction or position in three-dimensional space.<p>
 * 
 * The Leap Motion software employs a right-handed Cartesian coordinate system. 
 * Values given are in units of real-world millimeters. 
 * The origin is centered at the center of the Leap Motion {@link Controller}. 
 * The x- and z-axes lie in the horizontal plane, with the x-axis running parallel to 
 * the long edge of the device. The y-axis is vertical, with positive values increasing upwards 
 * (in contrast to the downward orientation of most computer graphics coordinate systems). 
 * The z-axis has positive values increasing away from the computer screen.<p>
 * 
 * <img src="\images\Leap_Axes.png"/>
 * 
 * @since 1.0 
 * @author Leap Motion Inc
 */
public class Vector {
	private long swigCPtr;
	protected boolean swigCMemOwn;

	/**
	 * Creates a new {@code Vector} with all components set to zero.
	 */
	public Vector() {
		this(LeapJNI.new_Vector__SWIG_0(), true);
	}
	
	/**
	 * Creates a new {@code Vector} with the specified component values.
	 * 
	 * <blockquote><pre>
	 * Vector newVector = new Vector(0.5f, 200.3f, 67f);
	 * </pre></blockquote>
	 * 
	 * @param x - The horizontal component.
	 * @param y - The vertical component.
	 * @param z - The depth component.
	 */
	public Vector(float x, float y, float z) {
		this(LeapJNI.new_Vector__SWIG_1(x, y, z), true);
	}
	
	/**
	 * Copies the specified {@code Vector}.
	 * 
	 * <blockquote><pre>
	 * Vector copiedVector = new Vector(otherVector);
	 * </pre></blockquote>
	 * 
	 * @param other - A {@code Vector} object to copy.
	 */
	public Vector(Vector other) {
		this(LeapJNI.new_Vector__SWIG_2(getCPtr(other), other), true);
	}
	
	public Vector(long paramLong, boolean paramBoolean)	{
		this.swigCMemOwn = paramBoolean;
		this.swigCPtr = paramLong;
	}

	/**
	 * The {@code Vector} in a float array representation.<p>
	 * 
	 * Index 0 is x, index 1 is y, and index 2 is z.
	 * 
	 * @return The {@code Vector} in a float array representation.
	 */
	public float[] toFloatArray() {
		return new float[] { getX(), getY(), getZ() };
	}

	/**
	 * The zero vector: (0, 0, 0)
	 * 
	 * <blockquote><pre>
	 * Vector zeroVector = Vector.zero();
	 * </pre></blockquote>
	 * 
	 * @return The zero vector.
	 */
	public static Vector zero() {
		return new Vector(LeapJNI.Vector_zero(), false);
	}

	/**
	 * The x-axis unit vector: (1, 0, 0)
	 * 
	 * <blockquote><pre>
	 * Vector xAxisVector = Vector.xAxis();
	 * </pre></blockquote>
	 * 
	 * @return The x-axis unit vector.
	 */
	public static Vector xAxis() {
		return new Vector(LeapJNI.Vector_xAxis(), false);
	}

	/**
	 * The y-axis unit vector: (0, 1, 0)
	 * 
	 * <blockquote><pre>
	 * Vector yAxisVector = Vector.yAxis();
	 * </pre></blockquote>
	 * 
	 * @return The y-axis unit vector.
	 */
	public static Vector yAxis() {
		return new Vector(LeapJNI.Vector_yAxis(), false);
	}

	/**
	 * The z-axis unit vector: (0, 0, 1)
	 * 
	 * <blockquote><pre>
	 * Vector zAxisVector = Vector.zAxis();
	 * </pre></blockquote>
	 * 
	 * @return The z-axis unit vector.
	 */
	public static Vector zAxis() {
		return new Vector(LeapJNI.Vector_zAxis(), false);
	}

	/**
	 * The unit vector pointing left along the negative x-axis: (-1, 0, 0)
	 * 
	 * <blockquote><pre>
	 * Vector leftVector = Vector.left();
	 * </pre></blockquote>
	 * 
	 * @return The unit vector pointing left.
	 */
	public static Vector left() {
		return new Vector(LeapJNI.Vector_left(), false);
	}

	/**
	 * The unit vector pointing right along the positive x-axis: (1, 0, 0)
	 * 
	 * <blockquote><pre>
	 * Vector rightVector = Vector.right();
	 * </pre></blockquote>
	 * 
	 * @return The unit vector pointing right.
	 */
	public static Vector right() {
		return new Vector(LeapJNI.Vector_right(), false);
	}

	/**
	 * The unit vector pointing down along the negative y-axis: (0, -1, 0)
	 * 
	 * <blockquote><pre>
	 * Vector downVector = Vector.down();
	 * </pre></blockquote>
	 * 
	 * @return The unit vector pointing down.
	 */
	public static Vector down() {
		return new Vector(LeapJNI.Vector_down(), false);
	}

	/**
	 * The unit vector pointing up along the positive y-axis: (0, 1, 0)
	 * 
	 * <blockquote><pre>
	 * Vector upVector = Vector.up();
	 * </pre></blockquote>
	 * 
	 * @return The unit vector pointing up.
	 */
	public static Vector up() {
		return new Vector(LeapJNI.Vector_up(), false);
	}

	/**
	 * The unit vector pointing forward along the negative z-axis: (0, 0, -1)
	 * 
	 * <blockquote><pre>
	 * Vector forwardVector = Vector.forward();
	 * </pre></blockquote>
	 * 
	 * @return The unit vector pointing forward.
	 */
	public static Vector forward() {
		return new Vector(LeapJNI.Vector_forward(), false);
	}

	/**
	 * The unit vector pointing backward along the positive z-axis: (0, 0, 1)
	 * 
	 * <blockquote><pre>
	 * Vector backwardVector = Vector.backward();
	 * </pre></blockquote>
	 * 
	 * @return The unit vector pointing backward.
	 */
	public static Vector backward() {
		return new Vector(LeapJNI.Vector_backward(), false);
	}

	/**
	 * The magnitude, or length, of this vector.<p>
	 * 
	 * The magnitude is the L2 norm, or Euclidean distance between the origin and the point 
	 * represented by the (x, y, z) components of this {@code Vector} object.
	 * 
	 * <blockquote><pre>
	 * float length = thisVector.magnitude();
	 * </pre></blockquote>
	 * 
	 * @return The length of this vector. 
	 */
	public float magnitude() {
		return LeapJNI.Vector_magnitude(this.swigCPtr, this);
	}

	/**
	 * The square of the magnitude, or length, of this vector.
	 * 
	 * <blockquote><pre>
	 * float lengthSquared = thisVector.magnitudeSquared();
	 * </pre></blockquote>
	 * 
	 * @return The square of the length of this vector.
	 */
	public float magnitudeSquared() {
		return LeapJNI.Vector_magnitudeSquared(this.swigCPtr, this);
	}

	/**
	 * The distance between the point represented by this {@code Vector} object 
	 * and a point represented by the specified {@code Vector} object.
	 * 
	 * <blockquote><pre>
	 * Vector aPoint = new Vector(10f, 0f, 0f);
	 * Vector origin = Vector.zero();
	 * float distance = origin.distanceTo(aPoint); // distance = 10
	 * </pre></blockquote>
	 * 
	 * @param other - A {@code Vector} object.
	 * 
	 * @return The distance from this point to the specified point.
	 */
	public float distanceTo(Vector other) {
		return LeapJNI.Vector_distanceTo(this.swigCPtr, this, getCPtr(other), other);
	}

	/**
	 * The angle between this vector and the specified vector in radians.<p>
	 * 
	 * The angle is measured in the plane formed by the two vectors. 
	 * The angle returned is always the smaller of the two conjugate angles. 
	 * Thus {@code A.angleTo(B) == B.angleTo(A)} and is always a positive value 
	 * less than or equal to pi radians (180 degrees).<p>
	 * 
	 * If either vector has zero length, then this function returns zero.
	 * 
	 * <img src="\images\Math_AngleTo.png"/><p>
	 * 
	 * <blockquote><pre>
	 * float angleInRadians = Vector.xAxis().angleTo(Vector.yAxis());
	 * // angleInRadians = PI/2 (90 degrees)
	 * </pre></blockquote>
	 * 
	 * @param other - A {@code Vector} object.
	 * 
	 * @return The angle between this vector and the specified vector in radians.
	 */
	public float angleTo(Vector other) {
		return LeapJNI.Vector_angleTo(this.swigCPtr, this, getCPtr(other), other);
	}

	/**
	 * The pitch angle in radians.<p>
	 * 
	 * Pitch is the angle between the negative z-axis and the projection of the vector onto the y-z plane. 
	 * In other words, pitch represents rotation around the x-axis. 
	 * If the vector points upward, the returned angle is between 0 and pi radians (180 degrees); 
	 * if it points downward, the angle is between 0 and -pi radians.<p>
	 * 
	 * <img src="\images\Math_Pitch_Angle.png"/><p>
	 * 
	 * <blockquote><pre>
	 * float pitchInRadians = thisVector.pitch();
	 * </pre></blockquote>
	 * 
	 * @return The angle of this vector above or below the horizon (x-z plane).
	 */
	public float pitch() {
		return LeapJNI.Vector_pitch(this.swigCPtr, this);
	}

	/**
	 * The yaw angle in radians.<p>
	 * 
	 * Yaw is the angle between the negative z-axis and the projection of the vector onto the x-z plane. 
	 * In other words, yaw represents rotation around the y-axis. 
	 * If the vector points to the right of the negative z-axis, 
	 * then the returned angle is between 0 and pi radians (180 degrees); 
	 * if it points to the left, the angle is between 0 and -pi radians.<p>
	 * 
	 * <img src="\images\Math_Yaw_Angle.png"/><p>
	 * 
	 * <blockquote><pre>
	 * float yawInRadians = thisVector.yaw();
	 * </pre></blockquote>
	 * 
	 * @return The angle of this vector to the right or left of the negative z-axis.
	 */
	public float yaw() {
		return LeapJNI.Vector_yaw(this.swigCPtr, this);
	}

	/**
	 * The roll angle in radians.<p>
	 * 
	 * Roll is the angle between the y-axis and the projection of the vector onto the x-y plane. 
	 * In other words, roll represents rotation around the z-axis. 
	 * If the vector points to the left of the y-axis, then the returned angle is between 0 and pi radians (180 degrees); 
	 * if it points to the right, the angle is between 0 and -pi radians.<p>
	 * 
	 * <img src="\images\Math_Roll_Angle.png"/><p>
	 * 
	 * Use this function to get roll angle of the plane to which this vector is a normal. 
	 * For example, if this vector represents the normal to the palm, 
	 * then this function returns the tilt or roll of the palm plane compared to the horizontal (x-z) plane.
	 * 
	 * <blockquote><pre>
	 * float rollInRadians = thatVector.roll();
	 * </pre></blockquote>
	 * 
	 * @return The angle of this vector to the right or left of the y-axis.
	 */
	public float roll() {
		return LeapJNI.Vector_roll(this.swigCPtr, this);
	}

	/**
	 * The dot product of this vector with another vector.<p>
	 * 
	 * The dot product is the magnitude of the projection of this vector onto the specified vector.<p>
	 * 
	 * <img src="\images\Math_Dot.png"/><p>
	 * 
	 * <blockquote><pre>
	 * float dotProduct = thisVector.dot(thatVector);
	 * </pre></blockquote>
	 * 
	 * @param other - A {@code Vector} object.
	 * @return The dot product of this vector and the specified vector.
	 */
	public float dot(Vector other) {
		return LeapJNI.Vector_dot(this.swigCPtr, this, getCPtr(other), other);
	}

	/**
	 * The cross product of this vector and the specified vector.<p>
	 * 
	 * The cross product is a vector orthogonal to both original vectors. 
	 * It has a magnitude equal to the area of a parallelogram having the two vectors as sides. 
	 * The direction of the returned vector is determined by the right-hand rule. 
	 * Thus {@code A.cross(B) == -B.cross(A)}.<p>
	 * 
	 * <img src="\images\Math_Cross.png"/><p>
	 * 
	 * <blockquote><pre>
	 * Vector crossProduct = thisVector.cross(thatVector);
	 * </pre></blockquote>
	 * 
	 * @param other - A {@code Vector} object.
	 * 
	 * @return The cross product of this vector and the specified vector.
	 */
	public Vector cross(Vector other) {
		return new Vector(LeapJNI.Vector_cross(this.swigCPtr, this, getCPtr(other), other), true);
	}

	/**
	 * A normalized copy of this vector.<p>
	 * 
	 * A normalized vector has the same direction as the original vector, but with a length of one.
	 * 
	 * <blockquote><pre>
	 * Vector normalizedVector = otherVector.normalized();
	 * </pre></blockquote>
	 * 
	 * @return A {@code Vector} object with a length of one, 
	 * pointing in the same direction as this {@code Vector} object.
	 */
	public Vector normalized() {
		return new Vector(LeapJNI.Vector_normalized(this.swigCPtr, this), true);
	}

	/**
	 * A copy of this vector pointing in the opposite direction.
	 * 
	 * <blockquote><pre>
	 * Vector negation = thisVector.opposite();
	 * </pre></blockquote>
	 * 
	 * @return A {@code Vector} object with all components negated.
	 */
	public Vector opposite() {
		return new Vector(LeapJNI.Vector_opposite(this.swigCPtr, this), true);
	}

	/**
	 * Add vectors component-wise.
	 * 
	 * <blockquote><pre>
	 * Vector sum = thisVector.plus(thatVector);
	 * </pre></blockquote>
	 * 
	 * @param other - A {@code Vector} object.
	 * 
	 * @return The component-wise addition of this vector and the specified vector.
	 */
	public Vector plus(Vector other) {
		return new Vector(LeapJNI.Vector_plus(this.swigCPtr, this, getCPtr(other), other), true);
	}

	/**
	 * Subtract vectors component-wise.
	 * 
	 * <blockquote><pre>
	 * Vector difference = thisVector.minus(thatVector);
	 * </pre></blockquote>
	 * 
	 * @param other - A {@code Vector} object.
	 * 
	 * @return The component-wise subtraction of this vector and the specified vector.
	 */
	public Vector minus(Vector other) {
		return new Vector(LeapJNI.Vector_minus(this.swigCPtr, this, getCPtr(other), other), true);
	}

	/**
	 * Multiply vector by a scalar.
	 * 
	 * <blockquote><pre>
	 * Vector product = thisVector.times(5.0f);
	 * </pre></blockquote>
	 * 
	 * @param scalar - a given scalar.
	 * 
	 * @return The given vector, multiplied by the given scalar.
	 */
	public Vector times(float scalar) {
		return new Vector(LeapJNI.Vector_times(this.swigCPtr, this, scalar), true);
	}

	/**
	 * Divide vector by a scalar.
	 * 
	 * <blockquote><pre>
	 * Vector quotient = thisVector.divide(2.5f);
	 * </pre></blockquote>
	 * 
	 * @param scalar - a given scalar.
	 * 
	 * @return The given vector, divided by the given scalar.
	 */
	public Vector divide(float scalar) {
		return new Vector(LeapJNI.Vector_divide(this.swigCPtr, this, scalar), true);
	}

	/**
	 * Returns a string containing this vector in a human readable format: (x, y, z).
	 * 
	 * @return A description of the {@code Vector} object as a string.
	 */
	public String toString() {
		return LeapJNI.Vector_toString(this.swigCPtr, this);
	}

	/**
	 * Compare {@code Vector} equality component-wise.
	 * 
	 * <blockquote><pre>
	 * boolean vectorsAreEqual = thisVector == thatVector;
	 * </pre></blockquote>
	 * 
	 * @param other - {@code Vector} object to compare
	 * 
	 * @return true if the {@code Vector} objects are equal.
	 */
	public boolean equals(Vector other) {
		return LeapJNI.Vector_equals(this.swigCPtr, this, getCPtr(other), other);
	}

	/**
	 * Returns true if all of the vector’s components are finite.<p>
	 * 
	 * If any component is {@code NaN} or infinite, then this returns false.
	 * 
	 * <blockquote><pre>
	 * boolean vectorsIsValid = thisVector.isValid();
	 * </pre></blockquote>
	 * 
	 * @return true if all of the vector’s components are finite.
	 */
	public boolean isValid() {
		return LeapJNI.Vector_isValid(this.swigCPtr, this);
	}

	/**
	 * Index vector components numerically.<p>
	 * 
	 * Index 0 is x, index 1 is y, and index 2 is z.
	 * 
	 * <blockquote><pre>
	 * float x = thisVector.get(0);
	 * float y = thisVector.get(1);
	 * float z = thisVector.get(2);
	 * </pre></blockquote>
	 * 
	 * @param index - the requested index.
	 * 
	 * @return The x, y, or z component of this {@code Vector}, 
	 * if the specified index value is at least 0 and at most 2; otherwise, returns zero.
	 */
	public float get(long index) {
		return LeapJNI.Vector_get(this.swigCPtr, this, index);
	}

	/**
	 * Set the horizontal component.
	 * 
	 * @param value - The horizontal component.
	 */
	public void setX(float value) {
		LeapJNI.Vector_x_set(this.swigCPtr, this, value);
	}

	/**
	 * Get the horizontal component.
	 * 
	 * @return The horizontal component.
	 */
	public float getX() {
		return LeapJNI.Vector_x_get(this.swigCPtr, this);
	}

	/**
	 * Set the vertical component.
	 * 
	 * @param value - The vertical component.
	 */
	public void setY(float value) {
		LeapJNI.Vector_y_set(this.swigCPtr, this, value);
	}

	/**
	 * Get the vertical component.
	 * 
	 * @return The vertical component.
	 */
	public float getY() {
		return LeapJNI.Vector_y_get(this.swigCPtr, this);
	}

	/**
	 * Set the depth component.
	 * 
	 * @param value - The depth component.
	 */
	public void setZ(float value) {
		LeapJNI.Vector_z_set(this.swigCPtr, this, value);
	}

	/**
	 * Get the depth component.
	 * 
	 * @return The depth component.
	 */
	public float getZ() {
		return LeapJNI.Vector_z_get(this.swigCPtr, this);
	}

	public static long getCPtr(Vector other) {
		return other == null ? 0L : other.swigCPtr;
	}

	protected void finalize() {
		delete();
	}

	public synchronized void delete() {
		if (this.swigCPtr != 0L) {
			if (this.swigCMemOwn) {
				this.swigCMemOwn = false;
				LeapJNI.delete_Vector(this.swigCPtr);
			}
			this.swigCPtr = 0L;
		}
	}

}
