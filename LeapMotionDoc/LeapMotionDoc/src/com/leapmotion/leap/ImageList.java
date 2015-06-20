package com.leapmotion.leap;

import java.util.Iterator;

/**
 * The {@code ImageList} class represents a list of {@link Image} objects.<p>
 * 
 * Get the {@code ImageList} object associated with the a {@link Frame} of tracking data by calling {@link Frame#images()}. 
 * Get the most recent set of images, which can be newer than the images used to create the current frame, 
 * by calling {@link Controller#images()}.
 * 
 * @since 2.1.0
 * @author Leap Motion Inc
 *
 */
public class ImageList extends Interface implements Iterable<Image> {
	private long swigCPtr;

	/**
	 * Constructs an empty list of images.
	 */
	public ImageList() {
		this(LeapJNI.new_ImageList(), true);
	}
	
	public ImageList(long paramLong, boolean paramBoolean)
	{
		super(LeapJNI.ImageList_SWIGUpcast(paramLong), paramBoolean);
		this.swigCPtr = paramLong;
	}

	public Iterator<Image> iterator() { 
		return new ImageListIterator(); 
	}

	/**
	 * The number of images in this list.
	 * 
	 * @return The number of images in this list.
	 */
	public int count() {
		return LeapJNI.ImageList_count(this.swigCPtr, this);
	}

	/**
	 * Reports whether the list is empty.
	 * 
	 * @return True, if the list has no members.
	 */
	public boolean isEmpty() {
		return LeapJNI.ImageList_isEmpty(this.swigCPtr, this);
	}

	/**
	 * Access a list member by its position in the list.
	 * 
	 * @param index - The zero-based list position index.
	 * 
	 * @return The {@code Image} object at the specified index.
	 */
	public Image get(int index) {
		return new Image(LeapJNI.ImageList_get(this.swigCPtr, this, index), true);
	}

	/**
	 * Appends the members of the specified {@code ImageList} to this {@code ImageList}.
	 * 
	 * @param other - A {@code ImageList} object containing {@link Image} objects 
	 * to append to the end of this {@code ImageList}.
	 * 
	 * @return the {@code ImageList}, containing the members of {@code other}.
	 */
	public ImageList append(ImageList other) {
		return new ImageList(LeapJNI.ImageList_append(this.swigCPtr, this, getCPtr(other), other), false);
	}
	
	public static long getCPtr(ImageList paramImageList) {
		return paramImageList == null ? 0L : paramImageList.swigCPtr;
	}

	protected void finalize() {
		delete();
	}

	public synchronized void delete() {
		if (this.swigCPtr != 0L) {
			if (this.swigCMemOwn) {
				this.swigCMemOwn = false;
				LeapJNI.delete_ImageList(this.swigCPtr);
			}
			this.swigCPtr = 0L;
		}
		super.delete(); 
	}

	public class ImageListIterator implements Iterator<Image> { 

		public ImageListIterator() {}

		int index = 0;

		public boolean hasNext() { 
			return this.index < ImageList.this.count(); 
		}

		public Image next() {
			return ImageList.this.get(this.index++);
		}

		public void remove() {}
	}
}
