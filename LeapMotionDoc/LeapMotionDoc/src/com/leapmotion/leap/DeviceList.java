package com.leapmotion.leap;

import java.util.Iterator;

/**
 * The {@code DeviceList} class represents a list of {@link Device} objects.<p>
 * 
 * Get a DeviceList object by calling {@link Controller#devices()}.
 * 
 * @Since 1.0
 * @author Leap Motion Inc
 */
public class DeviceList extends Interface implements Iterable<Device> {
	private long swigCPtr;

	/**
	 * Constructs an empty list of devices.
	 */
	public DeviceList()
	{
		this(LeapJNI.new_DeviceList(), true);
	}

	public DeviceList(long paramLong, boolean paramBoolean)
	{
		super(LeapJNI.DeviceList_SWIGUpcast(paramLong), paramBoolean);
		this.swigCPtr = paramLong;
	}

	public Iterator<Device> iterator() { return new DeviceListIterator(); }

	/**
	 * Returns the number of devices in this list.
	 * 
	 * @return The number of devices in this list.
	 */
	public int count() {
		return LeapJNI.DeviceList_count(this.swigCPtr, this);
	}

	/**
	 * Reports whether the list is empty.
	 * 
	 * <blockquote><pre>
	 * if(!controller.devices().isEmpty()) {
	 *     Device leapDevice = controller.devices().get(0);
	 * }
	 * </pre></blockquote>
	 * 
	 * @return True, if the list has no members.
	 */
	public boolean isEmpty() {
		return LeapJNI.DeviceList_isEmpty(this.swigCPtr, this);
	}

	/**
	 * Access a list member by its position in the list.
	 * 
	 * @param index - The zero-based list position index.
	 * 
	 * @return The {@link Device} object at the specified index.
	 */
	public Device get(int index) {
		return new Device(LeapJNI.DeviceList_get(this.swigCPtr, this, index), true);
	}

	/**
	 * Appends the members of the specified {@link DeviceList} to this {@link DeviceList}.
	 * 
	 * @param other - A {@link DeviceList} object containing {@link Device} objects to append to 
	 * the end of this {@link DeviceList}.
	 * 
	 * @return the {@link DeviceList}, containing the members of {@code other}.
	 */
	public DeviceList append(DeviceList other) {
		return new DeviceList(LeapJNI.DeviceList_append(this.swigCPtr, this, getCPtr(other), other), false);
	}

	public static long getCPtr(DeviceList paramDeviceList) {
		return paramDeviceList == null ? 0L : paramDeviceList.swigCPtr;
	}

	protected void finalize() {
		delete();
	}

	public synchronized void delete() {
		if (this.swigCPtr != 0L) {
			if (this.swigCMemOwn) {
				this.swigCMemOwn = false;
				LeapJNI.delete_DeviceList(this.swigCPtr);
			}
			this.swigCPtr = 0L;
		}
		super.delete(); 
	}

	public class DeviceListIterator implements Iterator<Device> { 

		int index = 0;

		public DeviceListIterator() {}

		public boolean hasNext() { 
			return this.index < DeviceList.this.count(); 
		}

		public Device next() {
			return DeviceList.this.get(this.index++);
		}

		public void remove() {}
	}
}
