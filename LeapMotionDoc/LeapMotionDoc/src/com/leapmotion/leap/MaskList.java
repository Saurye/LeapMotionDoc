package com.leapmotion.leap;

import java.util.Iterator;

public class MaskList extends Interface implements Iterable<Mask> {
	private long swigCPtr;

	public MaskList(long paramLong, boolean paramBoolean)
	{
		super(LeapJNI.MaskList_SWIGUpcast(paramLong), paramBoolean);
		this.swigCPtr = paramLong;
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
		super.delete(); }

	public class MaskListIterator implements Iterator<Mask> { public MaskListIterator() {}

	int index = 0;

	public boolean hasNext() { return this.index < MaskList.this.count(); }

	public Mask next() {
		return MaskList.this.get(this.index++);
	}

	public void remove() {}
	}

	public Iterator<Mask> iterator() { return new MaskListIterator(); }

	public MaskList()
	{
		this(LeapJNI.new_MaskList(), true);
	}

	public int count() {
		return LeapJNI.MaskList_count(this.swigCPtr, this);
	}

	public boolean isEmpty() {
		return LeapJNI.MaskList_isEmpty(this.swigCPtr, this);
	}

	public Mask get(int paramInt) {
		return new Mask(LeapJNI.MaskList_get(this.swigCPtr, this, paramInt), true);
	}

	public MaskList append(MaskList paramMaskList) {
		return new MaskList(LeapJNI.MaskList_append(this.swigCPtr, this, getCPtr(paramMaskList), paramMaskList), false);
	}
}
