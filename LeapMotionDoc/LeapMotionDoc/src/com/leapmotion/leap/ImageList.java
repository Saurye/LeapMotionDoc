package com.leapmotion.leap;

import java.util.Iterator;

public class ImageList extends Interface implements Iterable<Image> {
	private long swigCPtr;

	public ImageList(long paramLong, boolean paramBoolean)
	{
		super(LeapJNI.ImageList_SWIGUpcast(paramLong), paramBoolean);
		this.swigCPtr = paramLong;
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
		super.delete(); }

	public class ImageListIterator implements Iterator<Image> { public ImageListIterator() {}

	int index = 0;

	public boolean hasNext() { return this.index < ImageList.this.count(); }

	public Image next() {
		return ImageList.this.get(this.index++);
	}

	public void remove() {}
	}

	public Iterator<Image> iterator() { return new ImageListIterator(); }

	public ImageList()
	{
		this(LeapJNI.new_ImageList(), true);
	}

	public int count() {
		return LeapJNI.ImageList_count(this.swigCPtr, this);
	}

	public boolean isEmpty() {
		return LeapJNI.ImageList_isEmpty(this.swigCPtr, this);
	}

	public Image get(int paramInt) {
		return new Image(LeapJNI.ImageList_get(this.swigCPtr, this, paramInt), true);
	}

	public ImageList append(ImageList paramImageList) {
		return new ImageList(LeapJNI.ImageList_append(this.swigCPtr, this, getCPtr(paramImageList), paramImageList), false);
	}
}
