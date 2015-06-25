package com.leapmotion.leap;

/**
 * The {@code Bone} class represents a tracked bone.<p>
 * 
 * All fingers contain 4 bones that make up the anatomy of the finger.
 * Get valid {@code Bone} objects from a {@link Finger} object.<p>
 * 
 * Bones are ordered from base to tip, indexed from 0 to 3.
 * Additionally, the bone’s {@link Type} enum may be used to index a specific bone anatomically.<p>
 * 
 * <blockquote><pre>
 * for (Finger finger : hand.fingers()) {
 *     for(Bone.Type boneType : Bone.Type.values()) {
 *         Bone bone = finger.bone(boneType);
 *         // ... Use the bone
 *     }
 * } 
 * </pre></blockquote>
 * 
 * The thumb does not have a base metacarpal bone and therefore contains a valid, zero length bone at that location.<p>
 * 
 * Note that {@code Bone} objects can be invalid, which means that they do not contain valid tracking 
 * data and do not correspond to a physical bone. 
 * Invalid {@code Bone} objects can be the result of asking for a {@code Bone} object from an invalid finger, 
 * indexing a bone out of range, or constructing a new bone. Test for validity with the {@link Bone#isValid()} function.<p>
 * 
 * @Since 2.0
 * @author Leap Motion Inc
 * 
 */
public class Bone extends Interface {
	private long swigCPtr;

	/**
	 * Constructs an invalid {@link Bone} object.<p>
	 * 
	 * <blockquote><pre>
	 * Bone bone = Bone.invalid();
	 * </pre></blockquote>
	 * 
	 * Get valid {@link Bone} objects from a {@link Finger} object.
	 */
	public Bone() {
		this(LeapJNI.new_Bone(), true);
	}
	
	public Bone(long paramLong, boolean paramBoolean)
	{
		super(LeapJNI.Bone_SWIGUpcast(paramLong), paramBoolean);
		this.swigCPtr = paramLong;
	}

	/**
	 * The base of the bone, closest to the wrist.<p>
	 * 
	 * In anatomical terms, this is the proximal end of the bone.
	 * 
	 * <blockquote><pre>
	 * Vector boneStart = bone.prevJoint();
	 * </pre></blockquote>
	 * 
	 * @return The {@link Vector} containing the coordinates of the previous joint position.
	 */
	public Vector prevJoint() {
		return new Vector(LeapJNI.Bone_prevJoint(this.swigCPtr, this), true);
	}

	/**
	 * The end of the bone, closest to the finger tip.<p>
	 * 
	 * In anatomical terms, this is the distal end of the bone.
	 * 
	 * <blockquote><pre>
	 * Vector boneEnd = bone.nextJoint();
	 * </pre></blockquote>
	 * 
	 * @return The {@link Vector} containing the coordinates of the next joint position.
	 */
	public Vector nextJoint() {
		return new Vector(LeapJNI.Bone_nextJoint(this.swigCPtr, this), true);
	}

	/**
	 * The midpoint of the bone.
	 * 
	 * <blockquote><pre>
	 * Vector middle = bone.center();
	 * </pre></blockquote>
	 * 
	 * @return The midpoint in the center of the bone.
	 */
	public Vector center() {
		return new Vector(LeapJNI.Bone_center(this.swigCPtr, this), true);
	}

	/**
	 * The normalized direction of the bone from base to tip.
	 * 
	 * <blockquote><pre>
	 * Vector direction = bone.direction();
	 * </pre></blockquote>
	 * 
	 * @return The normalized direction of the bone from base to tip.
	 */
	public Vector direction() {
		return new Vector(LeapJNI.Bone_direction(this.swigCPtr, this), true);
	}

	/**
	 * The estimated length of the bone in millimeters.
	 * 
	 * <blockquote><pre>
	 * float length = bone.length();
	 * </pre></blockquote>
	 * 
	 * @return The length of the bone in millimeters.
	 */
	public float length() {
		return LeapJNI.Bone_length(this.swigCPtr, this);
	}

	/**
	 * The average width of the flesh around the bone in millimeters.
	 * 
	 * <blockquote><pre>
	 * float width = bone.width();
	 * </pre></blockquote>
	 * 
	 * @return The width of the flesh around the bone in millimeters.
	 */
	public float width() {
		return LeapJNI.Bone_width(this.swigCPtr, this);
	}

	/**
	 * The name of this bone.
	 * 
	 * <blockquote><pre>
	 * Bone.Type type = bone.type();
	 * </pre></blockquote>
	 * 
	 * @return The anatomical type of this bone as a member of the {@link Type} enumeration.
	 */
	public Type type() {
		return Type.swigToEnum(LeapJNI.Bone_type(this.swigCPtr, this));
	}

	/**
	 * The orthonormal basis vectors for this {@link Bone} as a {@link Matrix}.<p>
	 * 
	 * Basis vectors specify the orientation of a bone.<p>
	 * 
	 * <b>xBasis</b> Perpendicular to the longitudinal axis of the bone; exits the sides of the finger.<p>
	 * 
	 * <b>yBasis</b> or up vector Perpendicular to the longitudinal axis of the bone; 
	 * exits the top and bottom of the finger. More positive in the upward direction.<p>
	 * 
	 * <b>zBasis</b> Aligned with the longitudinal axis of the bone. More positive toward the base of the finger.<p>
	 * 
	 * The bases provided for the right hand use the right-hand rule; those for the left hand use the left-hand rule. 
	 * Thus, the positive direction of the x-basis is to the right for the right hand and to the left for the left hand.
	 *  You can change from right-hand to left-hand rule by multiplying the z basis vector by -1.<p>
	 *  
	 *  You can use the basis vectors for such purposes as measuring complex finger poses and skeletal animation.<p>
	 *  
	 *  Note that converting the basis vectors directly into a quaternion representation is not mathematically valid. 
	 *  If you use quaternions, create them from the derived rotation matrix not directly from the bases.<p>
	 * 
	 * <blockquote><pre>
	 * Matrix basis = bone.basis();
	 * Vector xBasis = basis.getXBasis();
	 * Vector yBasis = basis.getYBasis();
	 * Vector zBasis = basis.getZBasis();
	 * Vector origin = basis.getOrigin();
	 * </pre></blockquote>
	 * 
	 * @return The basis of the bone as a matrix.
	 */
	public Matrix basis() {
		return new Matrix(LeapJNI.Bone_basis(this.swigCPtr, this), true);
	}

	/**
	 * Reports whether this is a valid {@link Bone} object.
	 * 
	 * <blockquote><pre>
	 * Bone bone = finger.bone(Bone.Type.TYPE_PROXIMAL);
	 * if(bone.isValid()) {
	 *     // ... Use the bone data
	 * }
	 * </pre></blockquote>
	 * 
	 * @return True, if this {@link Bone} object contains valid tracking data.
	 */
	public boolean isValid() {
		return LeapJNI.Bone_isValid(this.swigCPtr, this);
	}

	/**
	 * Returns an invalid {@link Bone} object.<p>
	 * You can use the instance returned by this function in comparisons testing whether a given 
	 * {@link Bone} instance is valid or invalid. (You can also use the {@link Bone#isValid()} function.)
	 * 
	 * <blockquote><pre>
	 * Bone bone = Bone.invalid();
	 * </pre></blockquote>
	 * 
	 * @return The invalid {@link Bone} instance.
	 */
	public static Bone invalid() {
		return new Bone(LeapJNI.Bone_invalid(), false);
	}

	/**
	 * Compare {@link Bone} object equality.<p>
	 * 
	 * Two {@link Bone} objects are equal if and only if both {@link Bone} objects represent the exact same physical bone
	 * in the same frame and both {@link Bone} objects are valid.
	 * 
	 * @param bone - {@link Bone} object to compare
	 * 
	 * @return true if the {@link Bone} objects are equal.
	 */
	public boolean equals(Bone bone) {
		return LeapJNI.Bone_equals(this.swigCPtr, this, getCPtr(bone), bone);
	}

	/**
	 * A string containing a brief, human readable description of the {@link Bone} object.
	 * 
	 * <blockquote><pre>
	 * String description = bone.toString();
	 * </pre></blockquote>
	 * 
	 * @return A description of the {@link Bone} object as a string.
	 */
	public String toString() {
		return LeapJNI.Bone_toString(this.swigCPtr, this);
	}
	
	public static long getCPtr(Bone paramBone) {
		return paramBone == null ? 0L : paramBone.swigCPtr;
	}

	protected void finalize() {
		delete();
	}

	public synchronized void delete() {
		if (this.swigCPtr != 0L) {
			if (this.swigCMemOwn) {
				this.swigCMemOwn = false;
				LeapJNI.delete_Bone(this.swigCPtr);
			}
			this.swigCPtr = 0L;
		}
		super.delete();
	}

	/**
	 * Enumerates the names of the bones.<p>
	 * 
	 * Members of this enumeration are returned by {@link Bone#type()} to identify a {@link Bone} object.
	 * 
	 * @Since 2.0
	 * @author Leap Motion Inc
	 *
	 */
	public static enum Type {
		TYPE_METACARPAL(0), 
		TYPE_PROXIMAL(1), 
		TYPE_INTERMEDIATE(2), 
		TYPE_DISTAL(3);

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
