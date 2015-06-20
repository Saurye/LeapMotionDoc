package com.leapmotion.leap;

/**
 * The Arm class represents the forearm.
 * 
 * @Since 2.0.3
 * @author Leap Motion Inc
 */
public class Arm extends Interface {
	private long swigCPtr;

	/**
	 * Constructs an invalid {@code Arm} object.
	 * Get valid {@code Arm} objects from a {@link Hand} object.
	 * <blockquote><pre>
	 * Hand hand = frame.hands().frontmost();
	 * Arm arm = hand.arm();
	 * </pre></blockquote>
	 */
	public Arm() {
		this(LeapJNI.new_Arm(), true);
	}

	public Arm(long paramLong, boolean paramBoolean)
	{
		super(LeapJNI.Arm_SWIGUpcast(paramLong), paramBoolean);
		this.swigCPtr = paramLong;
	}
	
	/**
	 * The average width of the arm.
	 * 
	 * <blockquote><pre>
	 * float width = arm.width();
	 * 
	 * //length
	 * Vector displacement = arm.elbowPosition().minus(arm.wristPosition());
	 * float length = displacement.magnitude();
	 * </pre></blockquote>
	 * 
	 * @return The average width of the arm.
	 */
	public float width() {
		return LeapJNI.Arm_width(this.swigCPtr, this);
	}

	/**
	 * The normalized direction in which the arm is pointing (from elbow to wrist).
	 * 
	 * <blockquote><pre>
	 * Vector direction = arm.direction();
	 * </pre></blockquote>
	 * 
	 * @return The arm direction.
	 */
	public Vector direction() {
		return new Vector(LeapJNI.Arm_direction(this.swigCPtr, this), true);
	}

	/**
	 * The orthonormal basis vectors for the {@code Arm} bone as a {@link Matrix}.<br>
	 * Basis vectors specify the orientation of a bone.<p>
	 * 
	 * <b>xBasis</b> Perpendicular to the longitudinal axis of the bone; 
	 * exits the arm laterally through the sides of the wrist.<p>
	 * <b>yBasis</b> or up vector Perpendicular to the longitudinal axis of the bone; exits the top and bottom of the arm. 
	 * More positive in the upward direction.<p>
	 * <b>zBasis</b> Aligned with the longitudinal axis of the arm bone. More positive toward the wrist.<p>
	 * 
	 * <blockquote><pre>
	 * Matrix basis = arm.basis();
	 * Vector xBasis = basis.getXBasis();
	 * Vector yBasis = basis.getYBasis();
	 * Vector zBasis = basis.getZBasis();
	 *
	 * Vector armCenter = arm.elbowPosition().plus(arm.wristPosition().minus(arm.elbowPosition()).times(0.5f));
	 * Matrix transform = new Matrix(xBasis, yBasis, zBasis, armCenter);
	 * </pre></blockquote>
	 * 
	 * The bases provided for the right arm use the right-hand rule; those for the left arm use the left-hand rule. 
	 * Thus, the positive direction of the x-basis is to the right for the right arm and to the left for the left arm. 
	 * You can change from right-hand to left-hand rule by multiplying the z basis vector by -1.<p>
	 * Note that converting the basis vectors directly into a quaternion representation is not mathematically valid. 
	 * If you use quaternions, create them from the derived rotation matrix not directly from the bases.
	 * 
	 * @return The basis of the arm bone as a matrix.
	 */
	public Matrix basis() {
		return new Matrix(LeapJNI.Arm_basis(this.swigCPtr, this), true);
	}

	/**
	 * The position of the elbow.<p>
	 * 
	 * <blockquote><pre>
	 * Vector elbow = arm.elbowPosition();
	 * </pre></blockquote>
	 * 
	 * If not in view, the elbow position is estimated based on typical human anatomical proportions.<p>
	 * @return The position of the elbow
	 */
	public Vector elbowPosition() {
		return new Vector(LeapJNI.Arm_elbowPosition(this.swigCPtr, this), true);
	}

	/**
	 * The position of the wrist.<p>
	 * 
	 * <blockquote><pre>
	 * Vector wrist = arm.wristPosition();
	 * </pre></blockquote>
	 * 
	 * Note that the wrist position is not collocated with the end of any bone in the hand. 
	 * There is a gap of a few centimeters since the carpal bones are not included in the skeleton model.<p>
	 * 
	 * @return The position of the wrist.
	 */
	public Vector wristPosition() {
		return new Vector(LeapJNI.Arm_wristPosition(this.swigCPtr, this), true);
	}

	/**
	 * The center of the forearm.
	 * This location represents the midpoint of the arm between the wrist position and the elbow position.
	 * 
	 * @return The center of the forearm.
	 */
	public Vector center() {
		return new Vector(LeapJNI.Arm_center(this.swigCPtr, this), true);
	}

	/**
	 * Reports whether this is a valid {@code Arm} object.<p>
	 * 
	 * <blockquote><pre>
	 * Arm arm = frame.hand(handID).arm();
	 * if(arm.isValid()) {
	 *     // ... Use the arm data
	 * }
	 * </pre></blockquote>
	 * 
	 * @return True, if this {@code Arm} object contains valid tracking data.
	 */
	public boolean isValid() {
		return LeapJNI.Arm_isValid(this.swigCPtr, this);
	}

	/**
	 * Returns an invalid {@code Arm} object.<p>
	 * 
	 * <blockquote><pre>
	 * Arm arm = Arm.invalid();
	 * </pre></blockquote>
	 * 
	 * @return The invalid {@code Arm} instance.
	 */
	public static Arm invalid() {
		return new Arm(LeapJNI.Arm_invalid(), false);
	}

	/**
	 * Compare {@code Arm} object equality.<p>
	 * 
	 * <blockquote><pre>
	 * thisArm.equals(thatArm);
	 * </pre></blockquote>
	 * 
	 * Two {@code Arm} objects are equal if and only if both {@code Arm} objects represent the exact same physical 
	 * arm in the same frame and both {@code Arm} objects are valid.<p>
	 * 
	 * @param {@code Arm} object to compare
	 * 
	 * @return true if the {@code Arm} objects are equal.
	 */
	public boolean equals(Arm paramArm) {
		return LeapJNI.Arm_equals(this.swigCPtr, this, getCPtr(paramArm), paramArm);
	}

	/**
	 * A string containing a brief, human readable description of the {@code Arm} object.<p>
	 * 
	 * <blockquote><pre>
	 * String description = arm.toString();
	 * </pre></blockquote>
	 * 
	 * @return A description of the {@code Arm} object as a string. 
	 */
	public String toString() {
		return LeapJNI.Arm_toString(this.swigCPtr, this);
	}
	
	public static long getCPtr(Arm paramArm) {
		return paramArm == null ? 0L : paramArm.swigCPtr;
	}

	protected void finalize() {
		delete();
	}

	public synchronized void delete() {
		if (this.swigCPtr != 0L) {
			if (this.swigCMemOwn) {
				this.swigCMemOwn = false;
				LeapJNI.delete_Arm(this.swigCPtr);
			}
			this.swigCPtr = 0L;
		}
		super.delete();
	}
}
