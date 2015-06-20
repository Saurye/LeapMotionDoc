package com.leapmotion.leap;

public class BugReport extends Interface {
	private long swigCPtr;

	public BugReport(long paramLong, boolean paramBoolean)
	{
		super(LeapJNI.BugReport_SWIGUpcast(paramLong), paramBoolean);
		this.swigCPtr = paramLong;
	}

	public static long getCPtr(BugReport paramBugReport) {
		return paramBugReport == null ? 0L : paramBugReport.swigCPtr;
	}

	protected void finalize() {
		delete();
	}

	public synchronized void delete() {
		if (this.swigCPtr != 0L) {
			if (this.swigCMemOwn) {
				this.swigCMemOwn = false;
				LeapJNI.delete_BugReport(this.swigCPtr);
			}
			this.swigCPtr = 0L;
		}
		super.delete();
	}

	public BugReport() {
		this(LeapJNI.new_BugReport(), true);
	}

	public boolean beginRecording() {
		return LeapJNI.BugReport_beginRecording(this.swigCPtr, this);
	}

	public void endRecording() {
		LeapJNI.BugReport_endRecording(this.swigCPtr, this);
	}

	public boolean isActive() {
		return LeapJNI.BugReport_isActive(this.swigCPtr, this);
	}

	public float progress() {
		return LeapJNI.BugReport_progress(this.swigCPtr, this);
	}

	public float duration() {
		return LeapJNI.BugReport_duration(this.swigCPtr, this);
	}
}
