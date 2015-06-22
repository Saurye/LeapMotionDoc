package com.leapmotion.leap;

/**
 * The {@code Tool} class represents a tracked tool.<p>
 * 
 * Tools are {@link Pointable} objects that the Leap Motion software has classified as a tool.<p>
 * 
 * Get valid {@code Tool} objects from a {@link Frame} object.<p>
 * 
 * <img src="\images\Leap_Tool.png"/><p>
 * 
 * Note that {@code Tool} objects can be invalid, 
 * which means that they do not contain valid tracking data and do not correspond to a physical tool. 
 * Invalid {@code Tool} objects can be the result of asking for a {@code Tool} object using an ID 
 * from an earlier frame when no {@code Tool} objects with that ID exist in the current frame. 
 * A {@code Tool} object created from the {@code Tool} constructor is also invalid. 
 * Test for validity with the {@link Tool#isValid()} function.
 * 
 * @since 1.0
 * @author Leap Motion Inc
 */
public class Tool extends Pointable {
	private long swigCPtr;
	
	/**
	 * Constructs a {@code Tool} object.<p>
	 * 
	 * An uninitialized tool is considered invalid. Get valid {@code Tool} objects from a {@link Frame} object.
	 * 
	 * <blockquote><pre>
	 * Tool frontTool = frame.tools().frontmost();
	 * Tool firstToolInList = frame.tools().get(0);
	 * </pre></blockquote>
	 */
	public Tool() {
		this(LeapJNI.new_Tool__SWIG_0(), true);
	}
	
	/**
	 * If the specified {@link Pointable} object represents a tool, 
	 * creates a copy of it as a {@code Tool} object; 
	 * otherwise, creates an invalid {@code Tool} object.
	 * 
	 * <blockquote><pre>
	 * if (pointable.isTool()) {
	 *     Tool toolFromPointable = new Tool(pointable);
	 * }
	 * </pre></blockquote>
	 * 
	 * @param @param pointable - A given {@link Pointable} object.
	 */
	public Tool(Pointable pointable) {
		this(LeapJNI.new_Tool__SWIG_1(Pointable.getCPtr(pointable), pointable), true);
	}
	
	public Tool(long paramLong, boolean paramBoolean){
		super(LeapJNI.Tool_SWIGUpcast(paramLong), paramBoolean);
		this.swigCPtr = paramLong;
	}

	/**
	 * Returns an invalid {@code Tool} object.<p>
	 * 
	 * You can use the instance returned by this function in comparisons testing 
	 * whether a given {@code Tool} instance is valid or invalid. 
	 * (You can also use the {@link Tool#isValid()} function.)
	 * 
	 * <blockquote><pre>
	 * if (!tool.equals(Tool.invalid())) {
	 *     //Handle valid tool data
	 * }
	 * </pre></blockquote>
	 * 
	 * @return The invalid {@code Tool} instance.
	 */
	public static Tool invalid() {
		return new Tool(LeapJNI.Tool_invalid(), false);
	}

	/**
	 * A string containing a brief, human readable description of the {@code Tool} object.
	 * 
	 * @return A description of the {@code Tool} object as a string.
	 */
	public String toString() {
		return LeapJNI.Tool_toString(this.swigCPtr, this);
	}

	public static long getCPtr(Tool paramTool) {
		return paramTool == null ? 0L : paramTool.swigCPtr;
	}

	protected void finalize() {
		delete();
	}

	public synchronized void delete() {
		if (this.swigCPtr != 0L) {
			if (this.swigCMemOwn) {
				this.swigCMemOwn = false;
				LeapJNI.delete_Tool(this.swigCPtr);
			}
			this.swigCPtr = 0L;
		}
		super.delete();
	}

}
