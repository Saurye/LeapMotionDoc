package com.leapmotion.leap;

public class Interface {
	private long swigCPtr;
	protected boolean swigCMemOwn;

	public Interface(long paramLong, boolean paramBoolean)
	{
		this.swigCMemOwn = paramBoolean;
		this.swigCPtr = paramLong;
	}

	public static long getCPtr(Interface paramInterface) {
		return paramInterface == null ? 0L : paramInterface.swigCPtr;
	}

	public synchronized void delete() {
		if (this.swigCPtr != 0L) {
			if (this.swigCMemOwn) {
				this.swigCMemOwn = false;
				throw new UnsupportedOperationException("C++ destructor does not have public access");
			}
			this.swigCPtr = 0L;
		}
	}

	public static class Implementation {
		private long swigCPtr;
		protected boolean swigCMemOwn;

		public Implementation(long paramLong, boolean paramBoolean) {
			this.swigCMemOwn = paramBoolean;
			this.swigCPtr = paramLong;
		}

		public static long getCPtr(Implementation paramImplementation) {
			return paramImplementation == null ? 0L : paramImplementation.swigCPtr;
		}

		protected void finalize() {
			delete();
		}

		public synchronized void delete() {
			if (this.swigCPtr != 0L) {
				if (this.swigCMemOwn) {
					this.swigCMemOwn = false;
					LeapJNI.delete_Interface_Implementation(this.swigCPtr);
				}
				this.swigCPtr = 0L;
			}
		}

		public Implementation() {
			this(LeapJNI.new_Interface_Implementation(), true);
		}
	}
}
