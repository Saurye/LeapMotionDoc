package com.leapmotion.leap;

import java.util.Iterator;

/**
 * Note: This class is an experimental API for internal use only.<p>
 * 
 * It may be removed without warning.<p>
 * 
 * A list containing {@link Mask} objects.
 * 
 * @since 2.2.6 
 * @author Leap Motion Inc
 */
public class MaskList extends Interface implements Iterable<Mask> {
	private long swigCPtr;

	/**
	 * Constructs an empty list for {@link Mask} objects.
	 */
	public MaskList() {
		this(LeapJNI.new_MaskList(), true);
	}

	public MaskList(long paramLong, boolean paramBoolean)
	{
		super(LeapJNI.MaskList_SWIGUpcast(paramLong), paramBoolean);
		this.swigCPtr = paramLong;
	}

	public Iterator<Mask> iterator() { 
		return new MaskListIterator(); 
	}

	/**
	 * The length of this list.
	 * 
	 * @return The number of masks in this list.
	 */
	public int count() {
		return LeapJNI.MaskList_count(this.swigCPtr, this);
	}

	/**
	 * Reports whether the list is empty.
	 * 
	 * @return True, if the list has no members.
	 */
	public boolean isEmpty() {
		return LeapJNI.MaskList_isEmpty(this.swigCPtr, this);
	}

	/**
	 * Access a list member by its position in the list.
	 * 
	 * @param index - The zero-based list position index.
	 * 
	 * @return The {@link Mask} object at the specified index.
	 */
	public Mask get(int index) {
		return new Mask(LeapJNI.MaskList_get(this.swigCPtr, this, index), true);
	}

	/**
	 * Appends the contents of another list of masks to this one.
	 * 
	 * @param other - A {@code MaskList} object containing {@link Mask} objects 
	 * to append to the end of this {@code MaskList}.
	 * 
	 * @return the {@code GestureList}, containing the members of {@code other}.
	 */
	public MaskList append(MaskList other) {
		return new MaskList(LeapJNI.MaskList_append(this.swigCPtr, this, getCPtr(other), other), false);
	}

	public static long getCPtr(MaskList paramMaskList) {
		return paramMaskList == null ? 0L : paramMaskList.swigCPtr;
	}

	protected void finalize() {
		delete();
	}

	public synchronized void delete() {
		if (this.swigCPtr != 0L) {
			if (this.swigCMemOwn) {
				this.swigCMemOwn = false;
				LeapJNI.delete_MaskList(this.swigCPtr);
			}
			this.swigCPtr = 0L;
		}
		super.delete(); 
	}
	
	public class MaskListIterator implements Iterator<Mask> {
		public MaskListIterator() {}
		
		int index = 0;
		
		public boolean hasNext() { 
			return this.index < MaskList.this.count(); 
		}
		
		public Mask next() {
			return MaskList.this.get(this.index++);
		}
		
		public void remove() {}
	}
}
