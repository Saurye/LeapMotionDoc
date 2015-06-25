package com.leapmotion.leap;

import java.util.Iterator;

/**
 * The {@code HandList} class represents a list of Hand objects.<p>
 * 
 * Get a {@code HandList} object by calling {@link Frame#hands()}.
 * 
 * <blockquote><pre>
 * HandList allHands = frame.hands(); 
 * </pre></blockquote>
 *
 * @since 1.0 
 * @author Leap Motion Inc
 */
public class HandList extends Interface implements Iterable<Hand> {
	private long swigCPtr;

	/**
	 * Constructs an empty list of hands.
	 */
	public HandList()
	{
		this(LeapJNI.new_HandList(), true);
	}
	
	public HandList(long paramLong, boolean paramBoolean)
	{
		super(LeapJNI.HandList_SWIGUpcast(paramLong), paramBoolean);
		this.swigCPtr = paramLong;
	}

	public Iterator<Hand> iterator() { 
		return new HandListIterator(); 
	}

	/**
	 * Returns the number of hands in this list.
	 * 
	 * <blockquote><pre>
	 * if (frame.hands().count() > 0) {
	 *     //Process hand data...
	 * }
	 * </pre></blockquote>
	 * 
	 * @return The number of hands in this list.
	 */
	public int count() {
		return LeapJNI.HandList_count(this.swigCPtr, this);
	}

	/**
	 * Reports whether the list is empty.
	 * 
	 * <blockquote><pre>
	 * if (!frame.hands().isEmpty()) {
	 *     //Process hands...
	 * }
	 * </pre></blockquote>
	 * 
	 * @return True, if the list has no members.
	 */
	public boolean isEmpty() {
		return LeapJNI.HandList_isEmpty(this.swigCPtr, this);
	}

	/**
	 * Access a list member by its position in the list.
	 * 
	 * <blockquote><pre>
	 * HandList allHandsinFrame = frame.hands();
	 * for (int index = 0; index < allHandsinFrame.count(); index++) {
	 *     System.out.println(allHandsinFrame.get(index));
	 * }
	 * </pre></blockquote>
	 * 
	 * @param index - The zero-based list position index.
	 * 
	 * @return The {@link Hand} object at the specified index.
	 */
	public Hand get(int index) {
		return new Hand(LeapJNI.HandList_get(this.swigCPtr, this, index), true);
	}

	/**
	 * Appends the members of the specified {@link HandList} to this {@link HandList}.
	 * 
	 * @param other - A {@link HandList} object containing {@link Hand} objects 
	 * to append to the end of this {@link HandList}.
	 * 
	 * @return the {@link HandList}, containing the members of {@code other}.
	 */
	public HandList append(HandList other) {
		return new HandList(LeapJNI.HandList_append(this.swigCPtr, this, getCPtr(other), other), false);
	}

	/**
	 * The member of the list that is farthest to the left within the standard Leap Motion frame of reference 
	 * (i.e has the smallest X coordinate).<p>
	 * 
	 * Note: to determine whether a hand is the left hand, use the {@link Hand#isLeft()} function.
	 * 
	 * <blockquote><pre>
	 * Hand furthestLeft = frame.hands().leftmost();
	 * </pre></blockquote>
	 * 
	 * @return The leftmost hand, or invalid if list is empty.
	 */
	public Hand leftmost() {
		return new Hand(LeapJNI.HandList_leftmost(this.swigCPtr, this), true);
	}

	/**
	 * The member of the list that is farthest to the right within the standard Leap Motion frame of reference 
	 * (i.e has the largest X coordinate).<p>
	 * 
	 * Note: to determine whether a hand is the right hand, use the {@link Hand#isRight()} function.
	 * 
	 * <blockquote><pre>
	 * Hand furthestRight = frame.hands().rightmost();
	 * </pre></blockquote>
	 * 
	 * @return The rightmost hand, or invalid if list is empty.
	 */
	public Hand rightmost() {
		return new Hand(LeapJNI.HandList_rightmost(this.swigCPtr, this), true);
	}

	/**
	 * The member of the list that is farthest to the front within the standard Leap Motion frame of reference 
	 * (i.e has the smallest Z coordinate).
	 * 
	 * <blockquote><pre>
	 * Hand frontHand = frame.hands().frontmost();
	 * </pre></blockquote>
	 * 
	 * @return The frontmost hand, or invalid if list is empty.
	 */
	public Hand frontmost() {
		return new Hand(LeapJNI.HandList_frontmost(this.swigCPtr, this), true);
	}

	public static long getCPtr(HandList paramHandList) {
		return paramHandList == null ? 0L : paramHandList.swigCPtr;
	}

	protected void finalize() {
		delete();
	}

	public synchronized void delete() {
		if (this.swigCPtr != 0L) {
			if (this.swigCMemOwn) {
				this.swigCMemOwn = false;
				LeapJNI.delete_HandList(this.swigCPtr);
			}
			this.swigCPtr = 0L;
		}
		super.delete(); 
	}

	public class HandListIterator implements Iterator<Hand> { 

		public HandListIterator() {}

		int index = 0;

		public boolean hasNext() { 
			return this.index < HandList.this.count(); 
		}

		public Hand next() {
			return HandList.this.get(this.index++);
		}

		public void remove() {}
	}
}
