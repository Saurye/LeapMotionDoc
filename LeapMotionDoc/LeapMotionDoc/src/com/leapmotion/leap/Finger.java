package com.leapmotion.leap;

/**
 * The {@code Finger} class represents a tracked finger.<p>
 * 
 * Fingers are {@link Pointable} objects that the Leap Motion software has classified as a finger. 
 * Get valid {@code Finger} objects from a {@link Frame} or a {@link Hand} object.<p>
 * 
 * Fingers may be permanently associated to a hand. 
 * In this case the angular order of the finger IDs will be invariant. 
 * As fingers move in and out of view it is possible for the guessed ID of a finger to be incorrect. 
 * Consequently, it may be necessary for finger IDs to be exchanged. 
 * All tracked properties, such as velocity, will remain continuous in the API. 
 * However, quantities that are derived from the API output (such as a history of positions) 
 * will be discontinuous unless they have a corresponding ID exchange.<p>
 * 
 * Note that {@code Finger} objects can be invalid, which means that they do not contain 
 * valid tracking data and do not correspond to a physical finger. 
 * Invalid {@code Finger} objects can be the result of asking for a {@code Finger} object using an ID 
 * from an earlier frame when no Finger objects with that ID exist in the current frame. 
 * A {@code Finger} object created from the {@code Finger} constructor is also invalid. 
 * Test for validity with the {@link Finger#isValid()} function.
 * 
 * @Since 1.0
 * @author Leap Motion Inc
 */
public class Finger extends Pointable {
	private long swigCPtr;

	/**
	 * Constructs a {@code Finger} object.<p>
	 * 
	 * An uninitialized finger is considered invalid. 
	 * Get valid {@code Finger} objects from a {@link Frame} or a {@link Hand} object.
	 */
	public Finger() {
		this(LeapJNI.new_Finger__SWIG_0(), true);
	}
	
	/**
	 * If the specified {@link Pointable} object represents a finger, 
	 * creates a copy of it as a {@code Finger} object; otherwise, creates an invalid {@code Finger} object.
	 * 
	 * <blockquote><pre>
	 * Finger finger = new Finger(pointableObject);
	 * </pre></blockquote>
	 * 
	 * @param pointable - A given {@link Pointable} object.
	 */
	public Finger(Pointable pointable) {
		this(LeapJNI.new_Finger__SWIG_1(Pointable.getCPtr(pointable), pointable), true);
	}

	public Finger(long paramLong, boolean paramBoolean)
	{
		super(LeapJNI.Finger_SWIGUpcast(paramLong), paramBoolean);
		this.swigCPtr = paramLong;
	}
	
	/**
	 * Deprecated as of version 2.0.<p>
	 * 
	 * Use {@link Finger#bone(com.leapmotion.leap.Bone.Type)} method instead.
	 */
	@Deprecated
	public Vector jointPosition(Joint paramJoint) {
		return new Vector(LeapJNI.Finger_jointPosition(this.swigCPtr, this, paramJoint.swigValue()), true);
	}

	/**
	 * The bone at a given bone index on this finger.
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
	 * @param boneIx - An index value from the Bone::Type enumeration identifying the bone of interest.
	 * @return The {@link Bone} that has the specified bone type.
	 */
	public Bone bone(Bone.Type boneIx) {
		return new Bone(LeapJNI.Finger_bone(this.swigCPtr, this, boneIx.swigValue()), true);
	}

	/**
	 * The name of this finger.
	 * 
	 * <blockquote><pre>
	 * Finger.Type fingerType = finger.type();
	 * </pre></blockquote>
	 * 
	 * @return The anatomical type of this finger as a member of the {@link Type} enumeration.
	 */
	public Type type() {
		return Type.swigToEnum(LeapJNI.Finger_type(this.swigCPtr, this));
	}

	/**
	 * Returns an invalid {@code Finger} object.<p>
	 * 
	 * You can use the instance returned by this function in comparisons testing whether 
	 * a given {@code Finger} instance is valid or invalid. (You can also use the {@link Finger#isValid()} function.)
	 * 
	 * <blockquote><pre>
	 * Finger invalidFinger = Finger.invalid();
	 * </pre></blockquote>
	 * 
	 * @return The invalid {@code Finger} instance.
	 */
	public static Finger invalid() {
		return new Finger(LeapJNI.Finger_invalid(), false);
	}

	/**
	 * A string containing a brief, human readable description of the {@code Finger} object.
	 * 
	 * <blockquote><pre>
	 * String description = finger.toString();
	 * </pre></blockquote>
	 * 
	 * @return A description of the {@code Finger} object as a string.
	 */
	public String toString() {
		return LeapJNI.Finger_toString(this.swigCPtr, this);
	}

	/**
	 * Deprecated as of version 2.0.
	 * 
	 * @author Leap Motion Inc
	 */
	@Deprecated
	public static enum Joint {
		JOINT_MCP(0), 
		JOINT_PIP(1), 
		JOINT_DIP(2), 
		JOINT_TIP(3);

		public final int swigValue() {
			return this.swigValue;
		}

		public static Joint swigToEnum(int paramInt) {
			Joint[] arrayOfJoint1 = (Joint[])Joint.class.getEnumConstants();
			if ((paramInt < arrayOfJoint1.length) && (paramInt >= 0) && (arrayOfJoint1[paramInt].swigValue == paramInt))
				return arrayOfJoint1[paramInt];
			for (Joint localJoint : arrayOfJoint1)
				if (localJoint.swigValue == paramInt)
					return localJoint;
			throw new IllegalArgumentException("No enum " + Joint.class + " with value " + paramInt);
		}

		private Joint()
		{
			this.swigValue = SwigNext.access$008();
		}

		private Joint(int paramInt)
		{
			this.swigValue = paramInt;
			SwigNext.access$002(paramInt + 1);
		}

		private Joint(Joint paramJoint)
		{
			this.swigValue = paramJoint.swigValue;
			SwigNext.access$002(this.swigValue + 1);
		}

		private final int swigValue;
		private static class SwigNext
		{
			private static int next = 0;
		}
	}

	public static long getCPtr(Finger paramFinger) {
		return paramFinger == null ? 0L : paramFinger.swigCPtr;
	}

	protected void finalize() {
		delete();
	}

	public synchronized void delete() {
		if (this.swigCPtr != 0L) {
			if (this.swigCMemOwn) {
				this.swigCMemOwn = false;
				LeapJNI.delete_Finger(this.swigCPtr);
			}
			this.swigCPtr = 0L;
		}
		super.delete();
	}
	
	/**
	 * Enumerates the names of the fingers.<p>
	 * 
	 * Members of this enumeration are returned by {@link Finger#type()} to identify a {@link Finger} object.
	 * 
	 * @since 2.0
	 * @author Leap Motion Inc
	 */
	public static enum Type {
		TYPE_THUMB(0), 
		TYPE_INDEX(1), 
		TYPE_MIDDLE(2), 
		TYPE_RING(3), 
		TYPE_PINKY(4);

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
			this.swigValue = SwigNext.access$108();
		}

		private Type(int paramInt)
		{
			this.swigValue = paramInt;
			SwigNext.access$102(paramInt + 1);
		}

		private Type(Type paramType)
		{
			this.swigValue = paramType.swigValue;
			SwigNext.access$102(this.swigValue + 1);
		}

		private final int swigValue;
		private static class SwigNext
		{
			private static int next = 0;
		}
	}
}
