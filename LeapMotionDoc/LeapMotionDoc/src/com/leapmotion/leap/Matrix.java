package com.leapmotion.leap;

/**
 * The {@code Matrix} struct represents a transformation matrix.<p>
 * 
 * To use this struct to transform a {@link Vector}, construct a matrix containing 
 * the desired transformation and then use the {@link Matrix#transformPoint(Vector)} 
 * or {@link Matrix#transformDirection(Vector)} functions to apply the transform.<p>
 * 
 * Transforms can be combined by multiplying two or more transform matrices using the * operator.
 * 
 * @since 1.0 
 * @author Leap Motion Inc
 */
public class Matrix {
	private long swigCPtr;
	protected boolean swigCMemOwn;

	/**
	 * Constructs an identity transformation matrix.
	 * 
	 * <blockquote><pre>
	 * Matrix identity = new Matrix();
	 * </pre></blockquote>
	 */
	public Matrix()	{
		this(LeapJNI.new_Matrix__SWIG_0(), true);
	}

	/**
	 * Constructs a copy of the specified {@code Matrix} object.
	 * 
	 * <blockquote><pre>
	 * Matrix thisMatrix = new Matrix(thatMatrix);
	 * </pre></blockquote>
	 * 
	 * @param other - the specified {@code Matrix} object.
	 */
	public Matrix(Matrix other) {
		this(LeapJNI.new_Matrix__SWIG_1(getCPtr(other), other), true);
	}

	/**
	 * Constructs a transformation matrix from the specified basis vectors.
	 * 
	 * <blockquote><pre>
	 * Vector xBasis = new Vector(23, 0, 0);
	 * Vector yBasis = new Vector(0, 12, 0);
	 * Vector zBasis = new Vector(0, 0, 45);
	 * Matrix transformMatrix = new Matrix(xBasis, yBasis, zBasis);
	 * </pre></blockquote>
	 * 
	 * @param xBasis - A {@link Vector} specifying rotation and scale factors for the x-axis.
	 * @param yBasis - A {@link Vector} specifying rotation and scale factors for the y-axis.
	 * @param zBasis - A {@link Vector} specifying rotation and scale factors for the z-axis.
	 */
	public Matrix(Vector xBasis, Vector yBasis, Vector zBasis) {
		this(LeapJNI.new_Matrix__SWIG_2(Vector.getCPtr(xBasis), xBasis, Vector.getCPtr(yBasis), yBasis, Vector.getCPtr(zBasis), zBasis), true);
	}

	/**
	 * Constructs a transformation matrix from the specified basis and translation vectors.
	 *
	 * <blockquote><pre>
	 * Hand leapHand = frame.hand(handID);
	 * Vector handXBasis =  leapHand.palmNormal().cross(leapHand.direction()).normalized();
	 * Vector handYBasis = leapHand.palmNormal().opposite();
	 * Vector handZBasis = leapHand.direction().opposite();
	 * Vector handOrigin =  leapHand.palmPosition();
	 * Matrix handTransform = new Matrix(handXBasis, handYBasis, handZBasis, handOrigin);
	 * </pre></blockquote>
	 * 
	 * @param xBasis - A {@link Vector} specifying rotation and scale factors for the x-axis.
	 * @param yBasis - A {@link Vector} specifying rotation and scale factors for the y-axis.
	 * @param zBasis - A {@link Vector} specifying rotation and scale factors for the z-axis.
	 * @param origin - A {@link Vector} specifying translation factors on all three axes.
	 */
	public Matrix(Vector xBasis, Vector yBasis, Vector zBasis, Vector origin) {
		this(LeapJNI.new_Matrix__SWIG_3(Vector.getCPtr(xBasis), xBasis, Vector.getCPtr(yBasis), yBasis, Vector.getCPtr(zBasis), zBasis, Vector.getCPtr(origin), origin), true);
	}

	/**
	 * Constructs a transformation matrix specifying a rotation around the specified vector.
	 * 
	 * <blockquote><pre>
	 * Vector axisOfRotation = leapHand.direction();
	 * float angleOfRotation = 1.27f;
	 * Matrix rotator = new Matrix(axisOfRotation, angleOfRotation);
	 * </pre></blockquote>
	 * 
	 * @param axis - A {@link Vector} specifying the axis of rotation.
	 * @param angleRadians - The amount of rotation in radians.
	 */
	public Matrix(Vector axis, float angleRadians) {
		this(LeapJNI.new_Matrix__SWIG_4(Vector.getCPtr(axis), axis, angleRadians), true);
	}

	/**
	 * Constructs a transformation matrix specifying a rotation around the specified vector 
	 * and a translation by the specified vector.
	 * 
	 * <blockquote><pre>
	 * Vector rotationAxis = Vector.yAxis();
	 * float angle = .733f;
	 * Vector translation = new Vector(10,220,103);
	 * Matrix transform = new Matrix(rotationAxis, angle, translation);
	 * </pre></blockquote>
	 * 
	 * @param axis - A {@link Vector} specifying the axis of rotation.
	 * @param angleRadians - The angle of rotation in radians.
	 * @param A {@link Vector} representing the translation part of the transform.
	 */
	public Matrix(Vector axis, float angleRadians, Vector translation) {
		this(LeapJNI.new_Matrix__SWIG_5(Vector.getCPtr(axis), axis, angleRadians, Vector.getCPtr(translation), translation), true);
	}

	public Matrix(long paramLong, boolean paramBoolean) {
		this.swigCMemOwn = paramBoolean;
		this.swigCPtr = paramLong;
	}

	public float[] toArray3x3(float[] paramArrayOfFloat) {
		paramArrayOfFloat[0] = getXBasis().getX();paramArrayOfFloat[1] = getXBasis().getY();paramArrayOfFloat[2] = getXBasis().getZ();
		paramArrayOfFloat[3] = getYBasis().getX();paramArrayOfFloat[4] = getYBasis().getY();paramArrayOfFloat[5] = getYBasis().getZ();
		paramArrayOfFloat[6] = getZBasis().getX();paramArrayOfFloat[7] = getZBasis().getY();paramArrayOfFloat[8] = getZBasis().getZ();
		return paramArrayOfFloat;
	}

	public double[] toArray3x3(double[] paramArrayOfDouble) { 
		paramArrayOfDouble[0] = getXBasis().getX();paramArrayOfDouble[1] = getXBasis().getY();paramArrayOfDouble[2] = getXBasis().getZ();
		paramArrayOfDouble[3] = getYBasis().getX();paramArrayOfDouble[4] = getYBasis().getY();paramArrayOfDouble[5] = getYBasis().getZ();
		paramArrayOfDouble[6] = getZBasis().getX();paramArrayOfDouble[7] = getZBasis().getY();paramArrayOfDouble[8] = getZBasis().getZ();
		return paramArrayOfDouble;
	}

	public float[] toArray3x3() { 
		return toArray3x3(new float[9]); 
	}

	public float[] toArray4x4(float[] paramArrayOfFloat) {
		paramArrayOfFloat[0] = getXBasis().getX();paramArrayOfFloat[1] = getXBasis().getY();paramArrayOfFloat[2] = getXBasis().getZ();paramArrayOfFloat[3] = 0.0F;
		paramArrayOfFloat[4] = getYBasis().getX();paramArrayOfFloat[5] = getYBasis().getY();paramArrayOfFloat[6] = getYBasis().getZ();paramArrayOfFloat[7] = 0.0F;
		paramArrayOfFloat[8] = getZBasis().getX();paramArrayOfFloat[9] = getZBasis().getY();paramArrayOfFloat[10] = getZBasis().getZ();paramArrayOfFloat[11] = 0.0F;
		paramArrayOfFloat[12] = getOrigin().getX();paramArrayOfFloat[13] = getOrigin().getY();paramArrayOfFloat[14] = getOrigin().getZ();paramArrayOfFloat[15] = 1.0F;
		return paramArrayOfFloat;
	}

	public double[] toArray4x4(double[] paramArrayOfDouble) { 
		paramArrayOfDouble[0] = getXBasis().getX();paramArrayOfDouble[1] = getXBasis().getY();paramArrayOfDouble[2] = getXBasis().getZ();paramArrayOfDouble[3] = 0.0D;
		paramArrayOfDouble[4] = getYBasis().getX();paramArrayOfDouble[5] = getYBasis().getY();paramArrayOfDouble[6] = getYBasis().getZ();paramArrayOfDouble[7] = 0.0D;
		paramArrayOfDouble[8] = getZBasis().getX();paramArrayOfDouble[9] = getZBasis().getY();paramArrayOfDouble[10] = getZBasis().getZ();paramArrayOfDouble[11] = 0.0D;
		paramArrayOfDouble[12] = getOrigin().getX();paramArrayOfDouble[13] = getOrigin().getY();paramArrayOfDouble[14] = getOrigin().getZ();paramArrayOfDouble[15] = 1.0D;
		return paramArrayOfDouble;
	}

	public float[] toArray4x4() { 
		return toArray4x4(new float[16]); 
	}


	/**
	 * Returns the identity matrix specifying no translation, rotation, and scale.
	 * 
	 * <blockquote><pre>
	 * Matrix identity = Matrix.identity();
	 * </pre></blockquote>
	 * 
	 * @return The identity matrix.
	 */
	public static Matrix identity() {
		return new Matrix(LeapJNI.Matrix_identity(), false);
	}

	/**
	 * Sets this transformation matrix to represent a rotation around the specified vector.
	 * 
	 * <blockquote><pre>
	 * thisMatrix.setRotation(Vector.zAxis(), 1.46f);
	 * </pre></blockquote>
	 * 
	 * This function erases any previous rotation and scale transforms applied to this matrix, 
	 * but does not affect translation.
	 * 
	 * @param axis - A {@link Vector} specifying the axis of rotation.
	 * @param angleRadians - The amount of rotation in radians.
	 */
	public void setRotation(Vector axis, float angleRadians) {
		LeapJNI.Matrix_setRotation(this.swigCPtr, this, Vector.getCPtr(axis), axis, angleRadians);
	}

	/**
	 * Transforms a vector with this matrix by transforming its rotation, scale, and translation.
	 * 
	 * <blockquote><pre>
	 * Vector newPosition = thisMatrix.transformPoint(oldPosition);
	 * </pre></blockquote>
	 * 
	 * Translation is applied after rotation and scale.<p>
	 * 
	 * @param in - The {@link Vector} to transform.
	 * 
	 * @return A new {@link Vector} representing the transformed original.
	 */
	public Vector transformPoint(Vector in) {
		return new Vector(LeapJNI.Matrix_transformPoint(this.swigCPtr, this, Vector.getCPtr(in), in), true);
	}

	/**
	 * Transforms a vector with this matrix by transforming its rotation and scale only.
	 * 
	 * <blockquote><pre>
	 * Vector newDirection = thisMatrix.transformDirection(oldDirection);
	 * </pre></blockquote>
	 * 
	 * @param in - The {@link Vector} to transform.
	 * 
	 * @return A new {@link Vector} representing the transformed original.
	 */
	public Vector transformDirection(Vector in) {
		return new Vector(LeapJNI.Matrix_transformDirection(this.swigCPtr, this, Vector.getCPtr(in), in), true);
	}

	/**
	 * Performs a matrix inverse if the matrix consists entirely of rigid transformations (translations and rotations).<p>
	 * 
	 * If the matrix is not rigid, this operation will not represent an inverse.
	 * 
	 * <blockquote><pre>
	 * thisMatrix = thatMatrix.rigidInverse();
	 * </pre></blockquote>
	 * 
	 * Note that all matrices that are directly returned by the API are rigid.
	 * 
	 * @return The rigid inverse of the matrix.
	 */
	public Matrix rigidInverse() {
		return new Matrix(LeapJNI.Matrix_rigidInverse(this.swigCPtr, this), true);
	}

	/**
	 * Multiply transform matrices.<p>
	 * 
	 * Combines two transformations into a single equivalent transformation.
	 * 
	 * <blockquote><pre>
	 * thisMatrix.times(thatMatrix);
	 * </pre></blockquote>
	 * 
	 * @param other - A {@code Matrix} to multiply on the right hand side.
	 * 
	 * @return A new {@code Matrix} representing the transformation equivalent 
	 * to applying the other transformation followed by this transformation.
	 */
	public Matrix times(Matrix other) {
		return new Matrix(LeapJNI.Matrix_times(this.swigCPtr, this, getCPtr(other), other), true);
	}

	/**
	 * Compare {@code Matrix} equality component-wise.
	 * 
	 * <blockquote><pre>
	 * thisMatrix.equals(thatMatrix);
	 * </pre></blockquote>
	 * 
	 * @param matrix - {@code Matrix} object to compare
	 * 
	 * @return true if the {@code Matrix} objects are equal.
	 */
	public boolean equals(Matrix matrix) {
		return LeapJNI.Matrix_equals(this.swigCPtr, this, getCPtr(matrix), matrix);
	}

	/**
	 * Write the matrix to a string in a human readable format.
	 * 
	 * @return A description of the {@code Matrix} object as a string.
	 */
	public String toString() {
		return LeapJNI.Matrix_toString(this.swigCPtr, this);
	}

	/**
	 * The basis vector for the x-axis.
	 * 
	 * <blockquote><pre>
	 * Vector xTransform = thisMatrix.getXBasis();
	 * </pre></blockquote>
	 * 
	 * @param value - The basis vector for the x-axis.
	 */
	public void setXBasis(Vector value) {
		LeapJNI.Matrix_xBasis_set(this.swigCPtr, this, Vector.getCPtr(value), value);
	}

	/**
	 * The basis vector for the x-axis.
	 * 
	 * <blockquote><pre>
	 * Vector xTransform = thisMatrix.getXBasis();
	 * </pre></blockquote>
	 * 
	 * @return The basis vector for the x-axis.
	 */
	public Vector getXBasis() {
		long l = LeapJNI.Matrix_xBasis_get(this.swigCPtr, this);
		return l == 0L ? null : new Vector(l, false);
	}

	/**
	 * The basis vector for the y-axis.
	 * 
	 * <blockquote><pre>
	 * Vector yTransform = thisMatrix.getYBasis();
	 * </pre></blockquote>
	 * 
	 * @param value - The basis vector for the y-axis.
	 */
	public void setYBasis(Vector value) {
		LeapJNI.Matrix_yBasis_set(this.swigCPtr, this, Vector.getCPtr(value), value);
	}

	/**
	 * The basis vector for the y-axis.
	 * 
	 * <blockquote><pre>
	 * Vector yTransform = thisMatrix.getYBasis();
	 * </pre></blockquote>
	 * 
	 * @return The basis vector for the y-axis.
	 */
	public Vector getYBasis() {
		long l = LeapJNI.Matrix_yBasis_get(this.swigCPtr, this);
		return l == 0L ? null : new Vector(l, false);
	}

	/**
	 * The basis vector for the z-axis.
	 * 
	 * <blockquote><pre>
	 * Vector zTransform = thisMatrix.getZBasis();
	 * </pre></blockquote>
	 * 
	 * @param value - The basis vector for the z-axis.
	 */
	public void setZBasis(Vector value) {
		LeapJNI.Matrix_zBasis_set(this.swigCPtr, this, Vector.getCPtr(value), value);
	}

	/**
	 * The basis vector for the z-axis.
	 * 
	 * <blockquote><pre>
	 * Vector zTransform = thisMatrix.getZBasis();
	 * </pre></blockquote>
	 * 
	 * @return The basis vector for the z-axis.
	 */
	public Vector getZBasis() {
		long l = LeapJNI.Matrix_zBasis_get(this.swigCPtr, this);
		return l == 0L ? null : new Vector(l, false);
	}

	/**
	 * The translation factors for all three axes.
	 * 
	 * <blockquote><pre>
	 * Vector thisTranslation = thisMatrix.getOrigin();
	 * </pre></blockquote>
	 * 
	 * @param value - The translation factors for all three axes.
	 */
	public void setOrigin(Vector value) {
		LeapJNI.Matrix_origin_set(this.swigCPtr, this, Vector.getCPtr(value), value);
	}

	/**
	 * The translation factors for all three axes.
	 * 
	 * <blockquote><pre>
	 * Vector thisTranslation = thisMatrix.getOrigin();
	 * </pre></blockquote>
	 * 
	 * @return The translation factors for all three axes.
	 */
	public Vector getOrigin() {
		long l = LeapJNI.Matrix_origin_get(this.swigCPtr, this);
		return l == 0L ? null : new Vector(l, false);
	}

	public static long getCPtr(Matrix paramMatrix) {
		return paramMatrix == null ? 0L : paramMatrix.swigCPtr;
	}

	protected void finalize() {
		delete();
	}

	public synchronized void delete() {
		if (this.swigCPtr != 0L) {
			if (this.swigCMemOwn) {
				this.swigCMemOwn = false;
				LeapJNI.delete_Matrix(this.swigCPtr);
			}
			this.swigCPtr = 0L;
		}
	}

}
