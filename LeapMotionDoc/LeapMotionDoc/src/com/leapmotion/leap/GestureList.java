package com.leapmotion.leap;

import java.util.Iterator;

/**
 * The {@code GestureList} class represents a list of {@link Gesture} objects.
 * 
 * Get a {@code GestureList} object from a {@link Frame} object.
 * 
 * @since 1.0
 * @author Leap Motion Inc
 */
public class GestureList extends Interface implements Iterable<Gesture> {
	private long swigCPtr;
	
	/**
	 * Constructs an empty gesture list.
	 */
	public GestureList()
	{
		this(LeapJNI.new_GestureList(), true);
	}

	public GestureList(long paramLong, boolean paramBoolean)
	{
		super(LeapJNI.GestureList_SWIGUpcast(paramLong), paramBoolean);
		this.swigCPtr = paramLong;
	}

	public Iterator<Gesture> iterator() { 
		return new GestureListIterator(); 
	}

	/**
	 * The length of this list.
	 * 
	 * <blockquote><pre>
	 * if (frame.gestures().count() > 0) {
	 *     //Process gestures...
	 * }
	 * </pre></blockquote>
	 * 
	 * @return The number of gestures in this list.
	 */
	public int count() {
		return LeapJNI.GestureList_count(this.swigCPtr, this);
	}

	/**
	 * Reports whether the list is empty.
	 * 
	 * <blockquote><pre>
	 * if (!frame.gestures().isEmpty()) {
	 *     //Handle this frame's gesture objects
	 * }
	 * </pre></blockquote>
	 * 
	 * @return True, if the list has no members.
	 */
	public boolean isEmpty() {
		return LeapJNI.GestureList_isEmpty(this.swigCPtr, this);
	}

	/**
	 * Access a list member by its position in the list.
	 * 
	 * <blockquote><pre>
	 * GestureList allGesturesSince = frame.gestures(startFrame);
	 * for (int index = 0; index < allGesturesSince.count(); index++) {
	 *     System.out.println(allGesturesSince.get(index));
	 * }
	 * </pre></blockquote>
	 * 
	 * @param index - The zero-based list position index.
	 * 
	 * @return The {@link Gesture} object at the specified index.
	 */
	public Gesture get(int index) {
		return new Gesture(LeapJNI.GestureList_get(this.swigCPtr, this, index), true);
	}

	/**
	 * Appends the members of the specified {@link GestureList} to this {@link GestureList}.
	 * 
	 * @param other - A {@link GestureList} object containing {@link Gesture} objects 
	 * to append to the end of this {@link GestureList}.
	 * 
	 * @return the {@link GestureList}, containing the members of {@code other}.
	 */
	public GestureList append(GestureList other) {
		return new GestureList(LeapJNI.GestureList_append(this.swigCPtr, this, getCPtr(other), other), false);
	}

	public static long getCPtr(GestureList paramGestureList) {
		return paramGestureList == null ? 0L : paramGestureList.swigCPtr;
	}

	protected void finalize() {
		delete();
	}

	public synchronized void delete() {
		if (this.swigCPtr != 0L) {
			if (this.swigCMemOwn) {
				this.swigCMemOwn = false;
				LeapJNI.delete_GestureList(this.swigCPtr);
			}
			this.swigCPtr = 0L;
		}
		super.delete(); 
	}

	public class GestureListIterator implements Iterator<Gesture> { 
		public GestureListIterator() {}

		int index = 0;

		public boolean hasNext() { 
			return this.index < GestureList.this.count(); 
		}

		public Gesture next() {
			return GestureList.this.get(this.index++);
		}

		public void remove() {}
	}
}
