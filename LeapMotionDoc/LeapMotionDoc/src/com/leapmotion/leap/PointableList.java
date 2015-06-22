package com.leapmotion.leap;

import java.util.Iterator;

/**
 * The {@code PointableList} class represents a list of {@link Pointable} objects.<p>
 * 
 * {@link Pointable} objects include entities that can be pointed, such as fingers and tools.<p>
 * 
 * Get a {@code PointableList} object by calling {@link Frame#pointables()} or {@link Hand#pointables()}.
 * 
 * <blockquote><pre>
 * PointableList inFrame = frame.pointables();
 * PointableList onHand = hand.pointables(); 
 * </pre></blockquote>
 * 
 * @since 1.0
 * @author Leap Motion Inc
 */
public class PointableList extends Interface implements Iterable<Pointable> {
	private long swigCPtr;
	
	/**
	 * Constructs an empty list of pointable entities.
	 */
	public PointableList() {
		this(LeapJNI.new_PointableList(), true);
	}

	public PointableList(long paramLong, boolean paramBoolean)
	{
		super(LeapJNI.PointableList_SWIGUpcast(paramLong), paramBoolean);
		this.swigCPtr = paramLong;
	}

	public Iterator<Pointable> iterator() { 
		return new PointableListIterator(); 
	}

	/**
	 * Returns the number of pointable entities in this list.
	 * 
	 * <blockquote><pre>
	 * for (int p = 0; p < frame.pointables().count(); p++) {
	 *     System.out.println(frame.pointables().get(p));
	 * }
	 * </pre></blockquote>
	 * 
	 * @return The number of pointable entities in this list.
	 */
	public int count() {
		return LeapJNI.PointableList_count(this.swigCPtr, this);
	}

	/**
	 * Reports whether the list is empty.
	 * 
	 * <blockquote><pre>
	 * if(!hand.pointables().isEmpty()){
	 *     //Process this hand's pointables
	 * }
	 * </pre></blockquote>
	 * 
	 * @return True, if the list has no members.
	 */
	public boolean isEmpty() {
		return LeapJNI.PointableList_isEmpty(this.swigCPtr, this);
	}

	/**
	 * Access a list member by its position in the list.
	 * 
	 * <blockquote><pre>
	 * PointableList pointablesOfHand = hand.pointables();
	 * for (int index = 0; index < pointablesOfHand.count(); index++) {
	 *     System.out.println(pointablesOfHand.get(index));
	 * }
	 * </pre></blockquote>
	 * 
	 * @param index - The zero-based list position index.
	 * 
	 * @return The {@link Pointable} object at the specified index.
	 */
	public Pointable get(int index) {
		return new Pointable(LeapJNI.PointableList_get(this.swigCPtr, this, index), true);
	}

	/**
	 * Appends the members of the specified {@code PointableList} to this {@code PointableList}.
	 * 
	 * @param other - A {@code PointableList} object containing {@link Pointable} objects 
	 * to append to the end of this {@code PointableList}.
	 * 
	 * @return the {@code PointableList}, containing the members of {@code other}. 
	 */
	public PointableList append(PointableList other) {
		return new PointableList(LeapJNI.PointableList_append__SWIG_0(this.swigCPtr, this, getCPtr(other), other), false);
	}

	/**
	 * Appends the members of the specified {@link FingerList} to this {@code PointableList}.
	 * 
	 * @param other - A {@link FingerList} object containing {@link Finger} objects 
	 * to append to the end of this {@code PointableList}.
	 * 
	 * @return the {@link FingerList}, containing the members of {@code other}. 
	 */
	public PointableList append(FingerList other) {
		return new PointableList(LeapJNI.PointableList_append__SWIG_1(this.swigCPtr, this, FingerList.getCPtr(other), other), false);
	}

	/**
	 * Appends the members of the specified {@link ToolList} to this {@code PointableList}.
	 * 
	 * @param other - A {@link ToolList} object containing {@link Tool} objects 
	 * to append to the end of this {@code PointableList}.
	 * 
	 * @return the {@link ToolList}, containing the members of {@code other}. 
	 */
	public PointableList append(ToolList other) {
		return new PointableList(LeapJNI.PointableList_append__SWIG_2(this.swigCPtr, this, ToolList.getCPtr(other), other), false);
	}

	/**
	 * The member of the list that is farthest to the left 
	 * within the standard Leap Motion frame of reference (i.e has the smallest X coordinate).
	 * 
	 * <blockquote><pre>
	 * Pointable leftmostInFrame = frame.pointables().leftmost();
	 * </pre></blockquote>
	 *  
	 * @return The leftmost pointable, or invalid if list is empty.
	 */
	public Pointable leftmost() {
		return new Pointable(LeapJNI.PointableList_leftmost(this.swigCPtr, this), true);
	}

	/**
	 * The member of the list that is farthest to the right 
	 * within the standard Leap Motion frame of reference (i.e has the largest X coordinate).
	 * 
	 * <blockquote><pre>
	 * Pointable rightmostInFrame = frame.pointables().rightmost();
	 * </pre></blockquote>
	 *  
	 * @return The rightmost pointable, or invalid if list is empty.
	 */
	public Pointable rightmost() {
		return new Pointable(LeapJNI.PointableList_rightmost(this.swigCPtr, this), true);
	}

	/**
	 * The member of the list that is farthest to the front 
	 * within the standard Leap Motion frame of reference (i.e has the smallest Z coordinate).
	 * 
	 * <blockquote><pre>
	 * Pointable furthestFront = frame.pointables().frontmost();
	 * </pre></blockquote>
	 * 
	 * @return The frontmost pointable, or invalid if list is empty.
	 */
	public Pointable frontmost() {
		return new Pointable(LeapJNI.PointableList_frontmost(this.swigCPtr, this), true);
	}

	/**
	 * Returns a new list containing those members of the current list that are extended.<p>
	 * 
	 * This includes all tools and any fingers whose {@link Finger#isExtended()} function is true.
	 * 
	 * @return The list of tools and extended fingers from the current list.
	 */
	public PointableList extended() {
		return new PointableList(LeapJNI.PointableList_extended(this.swigCPtr, this), true);
	}

	public static long getCPtr(PointableList paramPointableList) {
		return paramPointableList == null ? 0L : paramPointableList.swigCPtr;
	}

	protected void finalize() {
		delete();
	}

	public synchronized void delete() {
		if (this.swigCPtr != 0L) {
			if (this.swigCMemOwn) {
				this.swigCMemOwn = false;
				LeapJNI.delete_PointableList(this.swigCPtr);
			}
			this.swigCPtr = 0L;
		}
		super.delete(); 
	}
	
	public class PointableListIterator implements Iterator<Pointable> { 
		public PointableListIterator() {}

		int index = 0;

		public boolean hasNext() { 
			return this.index < PointableList.this.count(); 
		}

		public Pointable next() {
			return PointableList.this.get(this.index++);
		}

		public void remove() {}
	}

}
