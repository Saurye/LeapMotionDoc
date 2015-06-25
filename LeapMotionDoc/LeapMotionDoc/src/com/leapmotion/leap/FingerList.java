package com.leapmotion.leap;

import java.util.Iterator;

/**
 * The {@code FingerList} class represents a list of {@link Finger} objects.<p>
 * 
 * Get a {@code FingerList} object by calling {@link Frame#fingers()}.
 * 
 * <blockquote><pre>
 * FingerList allFingers = frame.fingers();
 * </pre></blockquote>
 * 
 * @since 1.0
 * @author Leap Motion Inc
 */
public class FingerList extends Interface implements Iterable<Finger> {
	private long swigCPtr;

	/**
	 * Constructs an empty list of fingers.
	 */
	public FingerList()	{
		this(LeapJNI.new_FingerList(), true);
	}
	
	public FingerList(long paramLong, boolean paramBoolean)
	{
		super(LeapJNI.FingerList_SWIGUpcast(paramLong), paramBoolean);
		this.swigCPtr = paramLong;
	}

	public class FingerListIterator implements Iterator<Finger> { 

		int index = 0;

		public FingerListIterator() {}

		public boolean hasNext() { 
			return this.index < FingerList.this.count(); 
		}

		public Finger next() {
			return FingerList.this.get(this.index++);
		}

		public void remove() {}

	}

	public Iterator<Finger> iterator() { 
		return new FingerListIterator(); 
	}

	/**
	 * Returns the number of fingers in this list.
	 * 
	 * <blockquote><pre>
	 * for (Finger finger : frame.fingers()) {
	 *     System.out.println(finger);
	 * }
	 * </pre></blockquote>
	 * 
	 * @return The number of fingers in this list.
	 */
	public int count() {
		return LeapJNI.FingerList_count(this.swigCPtr, this);
	}

	/**
	 * Reports whether the list is empty.
	 * 
	 * <blockquote><pre>
	 * if (!frame.fingers().isEmpty()) {
	 *     //Use the fingers
	 * }
	 * </pre></blockquote>
	 * 
	 * @return True, if the list has no members.
	 */
	public boolean isEmpty() {
		return LeapJNI.FingerList_isEmpty(this.swigCPtr, this);
	}

	/**
	 * Access a list member by its position in the list.
	 * 
	 * <blockquote><pre>
	 * Finger firstFingerInList = frame.fingers().get(0);
	 * </pre></blockquote>
	 * 
	 * @param index - The zero-based list position index.
	 * 
	 * @return The Finger object at the specified index.
	 */
	public Finger get(int index) {
		return new Finger(LeapJNI.FingerList_get(this.swigCPtr, this, index), true);
	}

	/**
	 * Appends the members of the specified {@link FingerList} to this {@link FingerList}.
	 * 
	 * @param other - A {@link FingerList} object containing {@link Finger} objects to append 
	 * to the end of this {@link FingerList}.
	 * 
	 * @return the {@link FingerList}, containing the members of {@code other}.
	 */
	public FingerList append(FingerList other) {
		return new FingerList(LeapJNI.FingerList_append(this.swigCPtr, this, getCPtr(other), other), false);
	}

	/**
	 * The member of the list that is farthest to the left within the standard Leap Motion frame 
	 * of reference (i.e has the smallest X coordinate).
	 * 
	 * <blockquote><pre>
	 * Finger fingerWithSmallestX = frame.fingers().leftmost();
	 * </pre></blockquote>
	 * 
	 * @return The leftmost finger, or invalid if list is empty.
	 */
	public Finger leftmost() {
		return new Finger(LeapJNI.FingerList_leftmost(this.swigCPtr, this), true);
	}

	/**
	 * The member of the list that is farthest to the right within the standard Leap Motion frame 
	 * of reference (i.e has the smallest X coordinate).
	 * 
	 * <blockquote><pre>
	 * Finger fingerWithLargestX = frame.fingers().rightmost();
	 * </pre></blockquote>
	 * 
	 * @return The rightmost finger, or invalid if list is empty.
	 */
	public Finger rightmost() {
		return new Finger(LeapJNI.FingerList_rightmost(this.swigCPtr, this), true);
	}

	/**
	 * The member of the list that is farthest to the front within 
	 * the standard Leap Motion frame of reference (i.e has the smallest Z coordinate).
	 * 
	 * <blockquote><pre>
	 * Finger mostForwardFinger = frame.fingers().frontmost();
	 * </pre></blockquote>
	 * 
	 * @return The frontmost finger, or invalid if list is empty.
	 */
	public Finger frontmost() {
		return new Finger(LeapJNI.FingerList_frontmost(this.swigCPtr, this), true);
	}

	/**
	 * Returns a new list containing those fingers in the current list that are extended.
	 * 
	 * <blockquote><pre>
	 * FingerList extendedFingerList = hand.fingers().extended();
	 * </pre></blockquote>
	 * 
	 * @return The list of extended fingers from the current list.
	 */
	public FingerList extended() {
		return new FingerList(LeapJNI.FingerList_extended(this.swigCPtr, this), true);
	}

	/**
	 * Returns a list containing fingers from the current list of a given finger type by modifying the existing list.
	 * 
	 * <blockquote><pre>
	 * FingerList indexFingerList = hand.fingers().fingerType(Finger.Type.TYPE_INDEX);
	 * Finger indexFinger = indexFingerList.get(0); //since there is only one per hand
	 * </pre></blockquote>
	 * 
	 * @param type - the given type to filter the {@link FingerList} with.
	 * 
	 * @return The list of matching fingers from the current list.
	 */
	public FingerList fingerType(Finger.Type type) {
		return new FingerList(LeapJNI.FingerList_fingerType(this.swigCPtr, this, type.swigValue()), true);
	}
	
	public static long getCPtr(FingerList paramFingerList) {
		return paramFingerList == null ? 0L : paramFingerList.swigCPtr;
	}

	protected void finalize() {
		delete();
	}

	public synchronized void delete() {
		if (this.swigCPtr != 0L) {
			if (this.swigCMemOwn) {
				this.swigCMemOwn = false;
				LeapJNI.delete_FingerList(this.swigCPtr);
			}
			this.swigCPtr = 0L;
		}
		super.delete(); 
	}
}
