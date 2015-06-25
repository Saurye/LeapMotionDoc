package com.leapmotion.leap;

import java.util.Iterator;

/**
 * The {@code ToolList} class represents a list of {@link Tool} objects.<p>
 * 
 * Get a {@code ToolList} object by calling {@link Frame#tools()}.
 * 
 * <blockquote><pre>
 * ToolList allToolsInFrame = frame.tools();
 * </pre></blockquote>
 * 
 * @since 1.0
 * @author Leap Motion Inc
 */
public class ToolList extends Interface implements Iterable<Tool> {
	private long swigCPtr;
	
	/**
	 * Constructs an empty list of tools.
	 */
	public ToolList() {
		this(LeapJNI.new_ToolList(), true);
	}

	public ToolList(long paramLong, boolean paramBoolean) {
		super(LeapJNI.ToolList_SWIGUpcast(paramLong), paramBoolean);
		this.swigCPtr = paramLong;
	}

	public Iterator<Tool> iterator() { 
		return new ToolListIterator(); 
	}

	/**
	 * Returns the number of tools in this list.
	 * 
	 * <blockquote><pre>
	 * if (frame.tools().count() > 0) {
	 *     //Process tools
	 * }
	 * </pre></blockquote>
	 * 
	 * @return The number of tools in this list.
	 */
	public int count() {
		return LeapJNI.ToolList_count(this.swigCPtr, this);
	}

	/**
	 * Reports whether the list is empty.
	 * 
	 * <blockquote><pre>
	 * if(!frame.tools().isEmpty()){
	 *     //Process this frame's tools
	 * }
	 * </pre></blockquote>
	 * 
	 * @return True, if the list has no members.
	 */
	public boolean isEmpty() {
		return LeapJNI.ToolList_isEmpty(this.swigCPtr, this);
	}

	/**
	 * Access a list member by its position in the list.
	 * 
	 * <blockquote><pre>
	 * ToolList allToolsinFrame = frame.tools();
	 * for (int index = 0; index < allToolsinFrame.count(); index++) {
	 *     System.out.println(allToolsinFrame.get(index));
	 * }
	 * </pre></blockquote>
	 * 
	 * @param index - The zero-based list position index.
	 * 
	 * @return The {@link Tool} object at the specified index.
	 */
	public Tool get(int index) {
		return new Tool(LeapJNI.ToolList_get(this.swigCPtr, this, index), true);
	}

	/**
	 * Appends the members of the specified {@link ToolList} to this {@link ToolList}.
	 * 
	 * @param other - A {@link ToolList} object containing {@link Tool} objects 
	 * to append to the end of this {@link ToolList}.
	 * 
	 * @return the {@link ToolList}, containing the members of {@code other}. 
	 */
	public ToolList append(ToolList other) {
		return new ToolList(LeapJNI.ToolList_append(this.swigCPtr, this, getCPtr(other), other), false);
	}

	/**
	 * The member of the list that is farthest to the left within the standard 
	 * Leap Motion frame of reference (i.e has the smallest X coordinate).
	 * 
	 * <blockquote><pre>
	 * Tool leftmostTool = frame.tools().leftmost();
	 * </pre></blockquote>
	 * 
	 * @return The leftmost tool, or invalid if list is empty.
	 */
	public Tool leftmost() {
		return new Tool(LeapJNI.ToolList_leftmost(this.swigCPtr, this), true);
	}

	/**
	 * The member of the list that is farthest to the right within the standard 
	 * Leap Motion frame of reference (i.e has the largest X coordinate).
	 * 
	 * <blockquote><pre>
	 * Tool rightmostTool = frame.tools().rightmost();
	 * </pre></blockquote>
	 * 
	 * @return The rightmost tool, or invalid if list is empty.
	 */
	public Tool rightmost() {
		return new Tool(LeapJNI.ToolList_rightmost(this.swigCPtr, this), true);
	}

	/**
	 * The member of the list that is farthest to the front within the standard 
	 * Leap Motion frame of reference (i.e has the smallest Z coordinate).
	 * 
	 * <blockquote><pre>
	 * Tool frontmostTool = frame.tools().frontmost();
	 * </pre></blockquote>
	 * 
	 * @return The frontmost tool, or invalid if list is empty.
	 */
	public Tool frontmost() {
		return new Tool(LeapJNI.ToolList_frontmost(this.swigCPtr, this), true);
	}

	public static long getCPtr(ToolList paramToolList) {
		return paramToolList == null ? 0L : paramToolList.swigCPtr;
	}

	protected void finalize() {
		delete();
	}

	public synchronized void delete() {
		if (this.swigCPtr != 0L) {
			if (this.swigCMemOwn) {
				this.swigCMemOwn = false;
				LeapJNI.delete_ToolList(this.swigCPtr);
			}
			this.swigCPtr = 0L;
		}
		super.delete(); 
	}

	public class ToolListIterator implements Iterator<Tool> { 
		public ToolListIterator() {}

		int index = 0;

		public boolean hasNext() { 
			return this.index < ToolList.this.count(); 
		}

		public Tool next() {
			return ToolList.this.get(this.index++);
		}

		public void remove() {}
	}
}
