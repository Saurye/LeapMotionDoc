package com.leapmotion.leap;

/**
 * The {@code Frame} class represents a set of hand and finger tracking data detected in a single frame.<p>
 * 
 * The Leap Motion software detects hands, fingers and tools within the tracking area, 
 * reporting their positions, orientations, gestures, and motions in frames at the Leap Motion frame rate.<p>
 * 
 * Access {@code Frame} objects through an instance of the {@link Controller} class:
 * 
 * <blockquote><pre>
 * if(controller.isConnected()) //controller is a Controller object {
 *     Frame frame = controller.frame(); //The latest frame
 *     Frame previous = controller.frame(1); //The previous frame
 * } 
 * </pre></blockquote>
 *
 * Implement a {@link Listener} subclass to receive a callback event when a new {@code Frame} is available.
 * 
 * @since 1.0
 * @author Leap Motion Inc
 */
public class Frame extends Interface {
	private long swigCPtr;

	/**
	 * Constructs a {@code Frame} object.<p>
	 * 
	 * {@code Frame} instances created with this constructor are invalid. 
	 * Get valid {@code Frame} objects by calling the {@link Controller#frame()} function.
	 * 
	 * <blockquote><pre>
	 * Frame current = controller.frame();
	 * Frame previous = controller.frame(1);
	 * </pre></blockquote>
	 * 
	 * The only time you should use this constructor is before deserializing serialized frame data. 
	 * Call {@link Frame#deserialize(byte[])} to recreate a saved {@code Frame}.
	 */
	public Frame() {
		this(LeapJNI.new_Frame(), true);
	}
	
	public Frame(long paramLong, boolean paramBoolean)
	{
		super(LeapJNI.Frame_SWIGUpcast(paramLong), paramBoolean);
		this.swigCPtr = paramLong;
	}

	/**
	 * Encodes this {@code Frame} object as a byte string.
	 * 
	 * <blockquote><pre>
	 * byte[] serializedFrame = frame.serialize();
	 * Files.write(Paths.get("frame.data"), serializedFrame);
	 * </pre></blockquote>
	 * 
	 * @return The byte array encoding the data for this frame.
	 */
	public byte[] serialize()
	{
		byte[] arrayOfByte = new byte[serializeLength()];
		LeapJNI.Frame_serialize(this.swigCPtr, this, arrayOfByte);
		return arrayOfByte;
	}

	/**
	 * Decodes a byte string to replace the properties of this {@code Frame}.<p>
	 * 
	 * A {@link Controller} object must be instantiated for this function to succeed, but it does not need to be connected. 
	 * To extract gestures from the deserialized frame, you must enable the appropriate gestures first.<p>
	 * 
	 * Any existing data in the frame is destroyed. If you have references to child objects (hands, fingers, etc.), 
	 * these are preserved as long as the references remain in scope.
	 * 
	 * <blockquote><pre>
	 * Controller controller = new Controller(); //An instance must exist
	 * byte[] frameBytes = Files.readAllBytes(Paths.get("frame.data"));
	 * 
	 * Frame reconstructedFrame = new Frame();
	 * reconstructedFrame.deserialize(frameBytes);
	 * </pre></blockquote>
	 * 
	 * <b>Note:</b> The behavior when calling functions which take another {@code Frame} object as a parameter 
	 * is undefined when either frame has been deserialized. For example,
	 * calling {@link Frame#gestures(sinceFrame)} on a deserialized frame or with a deserialized frame as parameter (or both) 
	 * does not necessarily return all gestures that occurred between the two frames. 
	 * Motion functions, like {@link Frame#scaleFactor(startFrame)}, are more likely to return reasonable results, 
	 * but could return anomalous values in some cases.
	 * 
	 * @param str - A byte array containing the bytes of a serialized frame.
	 */
	public void deserialize(byte[] str)
	{
		LeapJNI.Frame_deserialize(this.swigCPtr, this, str, str.length);
	}

	/**
	 * A unique ID for this {@code Frame}.<p>
	 * 
	 * Consecutive frames processed by the Leap Motion software have consecutive increasing values. 
	 * You can use the frame ID to avoid processing the same {@code Frame} object twice:
	 * 
	 * <blockquote><pre>
	 * long lastFrameID = 0;
	 * 
	 * void processFrame(Frame frame) {
	 *     if (frame.id() == lastFrameID) return;
	 *     //...
	 *     lastFrameID = frame.id();
	 * }
	 * </pre></blockquote>
	 * 
	 * As well as to make sure that your application processes every frame:
	 * 
	 * <blockquote><pre>
	 * int lastProcessedFrameID = 0;
	 * 
	 * void nextFrame (Controller controller){
	 *     long currentID = controller.frame().id();
	 *     for (int history = 0; history < currentID - lastFrameID; history++) {
	 *         processNextFrame(controller.frame(history));
	 *     }
	 *     lastFrameID = currentID;
	 * }
	 * 
	 * void processNextFrame(Frame frame) {
	 *     if(frame.isValid()) {
	 *         //...
	 *     }
	 * }
	 * </pre></blockquote>
	 * 
	 * @return The frame ID.
	 */
	public long id() {
		return LeapJNI.Frame_id(this.swigCPtr, this);
	}

	/**
	 * The frame capture time in microseconds elapsed since the Leap started.
	 * 
	 * <blockquote><pre>
	 * float framePeriod = frame.timestamp() - controller.frame(1).timestamp();
	 * </pre></blockquote>
	 * 
	 * @return The timestamp in microseconds.
	 */
	public long timestamp() {
		return LeapJNI.Frame_timestamp(this.swigCPtr, this);
	}

	/**
	 * The list of {@link Hand} objects detected in this frame, given in arbitrary order.<p>
	 * 
	 * The list can be empty if no hands are detected.
	 * 
	 * <blockquote><pre>
	 * HandList handsInFrame = frame.hands();
	 * </pre></blockquote>
	 * 
	 * @return The {@link HandList} containing all {@link Hand} objects detected in this frame.
	 */
	public HandList hands() {
		return new HandList(LeapJNI.Frame_hands(this.swigCPtr, this), true);
	}

	/**
	 * The {@link Hand} object with the specified ID in this frame.<p>
	 * 
	 * Use the {@code Frame.hand()} function to retrieve the {@link Hand} object from this frame using 
	 * an ID value obtained from a previous frame. 
	 * This function always returns a {@link Hand} object, but if no hand with the specified ID is present, 
	 * an invalid {@link Hand} object is returned.
	 * 
	 * <blockquote><pre>
	 * Hand handOfInterest = frame.hand(handID);
	 * </pre></blockquote>
	 * 
	 * Note that ID values persist across frames, but only until tracking of a particular object is lost. 
	 * If tracking of a hand is lost and subsequently regained, the new {@link Hand} object representing 
	 * that physical hand may have a different ID than that representing the physical hand in an earlier frame.
	 * 
	 * @param id - The ID value of a {@link Hand} object from a previous frame.
	 * 
	 * @return The {@link Hand} object with the matching ID if one exists in this frame; 
	 * otherwise, an invalid {@link Hand} object is returned.
	 */
	public Hand hand(int id) {
		return new Hand(LeapJNI.Frame_hand(this.swigCPtr, this, id), true);
	}

	/**
	 * The list of {@link Pointable} objects (fingers and tools) detected in this frame, given in arbitrary order.<p>
	 * 
	 * The list can be empty if no fingers or tools are detected.<p>
	 * 
	 * Use {@link PointableList#extended()} to remove non-extended fingers from the list.
	 * 
	 * <blockquote><pre>
	 * PointableList pointablesInFrame = frame.pointables();
	 * </pre></blockquote>
	 * 
	 * @return The {@link PointableList} containing all {@link Pointable} objects detected in this frame.
	 */
	public PointableList pointables() {
		return new PointableList(LeapJNI.Frame_pointables(this.swigCPtr, this), true);
	}

	/**
	 * The {@link Pointable} object with the specified ID in this frame.<p>
	 * 
	 * Use the {@code Frame.pointable()} function to retrieve the {@link Pointable} object from 
	 * this frame using an ID value obtained from a previous frame. 
	 * This function always returns a {@link Pointable} object, but if no finger or tool with 
	 * the specified ID is present, an invalid {@link Pointable} object is returned.
	 * 
	 * <blockquote><pre>
	 * Pointable pointableOfInterest = frame.pointable(pointableID);
	 * </pre></blockquote>
	 * 
	 * Note that ID values persist across frames, but only until tracking of a particular object is lost. 
	 * If tracking of a finger or tool is lost and subsequently regained, 
	 * the new {@link Pointable} object representing that finger or tool may have a different ID 
	 * than that representing the finger or tool in an earlier frame.
	 * 
	 * @param id - The ID value of a {@link Pointable} object from a previous frame.
	 * 
	 * @return The {@link Pointable} object with the matching ID if one exists in this frame; 
	 * otherwise, an invalid {@link Pointable} object is returned.
	 */
	public Pointable pointable(int id) {
		return new Pointable(LeapJNI.Frame_pointable(this.swigCPtr, this, id), true);
	}

	/**
	 * The list of {@link Finger} objects detected in this frame, given in arbitrary order.<p>
	 * 
	 * The list can be empty if no fingers are detected.<p>
	 * 
	 * Use {@link PointableList#extended()} to remove non-extended fingers from the list.
	 * 
	 * <blockquote><pre>
	 * FingerList fingersInFrame = frame.fingers();
	 * </pre></blockquote>
	 * 
	 * @return The {@link FingerList} containing all {@link Finger} objects detected in this frame.
	 */
	public FingerList fingers() {
		return new FingerList(LeapJNI.Frame_fingers(this.swigCPtr, this), true);
	}

	/**
	 * The Finger object with the specified ID in this frame.<p>
	 * 
	 * Use the {@code Frame.finger()} function to retrieve the {@link Finger} object 
	 * from this frame using an ID value obtained from a previous frame. 
	 * This function always returns a {@link Finger} object, 
	 * but if no finger with the specified ID is present, an invalid {@link Finger} object is returned.
	 * 
	 * <blockquote><pre>
	 * Finger fingerOfInterest = frame.finger(fingerID);
	 * </pre></blockquote>
	 * 
	 * Note that ID values persist across frames, but only until tracking of a particular object is lost. 
	 * If tracking of a finger is lost and subsequently regained, 
	 * the new {@link Finger} object representing that physical finger may have a different ID than that representing 
	 * the finger in an earlier frame.
	 * 
	 * @param id - The ID value of a {@link Finger} object from a previous frame.
	 * 
	 * @return The {@link Finger} object with the matching ID if one exists in this frame; 
	 * otherwise, an invalid {@link Finger} object is returned.
	 */
	public Finger finger(int id) {
		return new Finger(LeapJNI.Frame_finger(this.swigCPtr, this, id), true);
	}

	/**
	 * The list of {@link Tool} objects detected in this frame, given in arbitrary order.<p>
	 * 
	 * The list can be empty if no tools are detected.
	 * 
	 * <blockquote><pre>
	 * ToolList toolsInFrame = frame.tools();
	 * </pre></blockquote>
	 * 
	 * @return The {@link ToolList} containing all {@link Tool} objects detected in this frame.
	 */
	public ToolList tools() {
		return new ToolList(LeapJNI.Frame_tools(this.swigCPtr, this), true);
	}

	/**
	 * The {@link Tool} object with the specified ID in this frame.<p>
	 * 
	 * Use the {@code Frame.tool()} function to retrieve the {@link Tool} object from this frame 
	 * using an ID value obtained from a previous frame. 
	 * This function always returns a {@link Tool} object, but if no tool with the specified ID is present, 
	 * an invalid {@link Tool} object is returned.
	 * 
	 * <blockquote><pre>
	 * Tool toolOfInterest = frame.tool(toolID);
	 * </pre></blockquote>
	 * 
	 * Note that ID values persist across frames, but only until tracking of a particular object is lost. 
	 * If tracking of a tool is lost and subsequently regained, the new {@link Tool} object representing 
	 * that tool may have a different ID than that representing the tool in an earlier frame.
	 * 
	 * @param id - The ID value of a Tool object from a previous frame.
	 * 
	 * @return The {@link Tool} object with the matching ID if one exists in this frame; 
	 * otherwise, an invalid {@link Tool} object is returned.
	 */
	public Tool tool(int id) {
		return new Tool(LeapJNI.Frame_tool(this.swigCPtr, this, id), true);
	}

	/**
	 * The {@link Gesture} object with the specified ID in this frame.<p>
	 * 
	 * Use the {@code Frame.gesture()} function to return a {@link Gesture} object in this frame using 
	 * an ID obtained in an earlier frame. 
	 * The function always returns a {@link Gesture} object, but if there was no update for the gesture in this frame, 
	 * then an invalid {@link Gesture} object is returned.
	 * 
	 * <blockquote><pre>
	 * Gesture gestureOfInterest = frame.gesture(gestureID);
	 * </pre></blockquote>
	 * 
	 * All {@link Gesture} objects representing the same recognized movement share the same ID.
	 * 
	 * @param id - The ID of an {@link Gesture} object from a previous frame.
	 * 
	 * @return The {@link Gesture} object in the frame with the specified ID if one exists; 
	 * Otherwise, an Invalid {@link Gesture} object.
	 */
	public Gesture gesture(int id) {
		return new Gesture(LeapJNI.Frame_gesture(this.swigCPtr, this, id), true);
	}

	/**
	 * The gestures recognized or continuing in this frame.
	 * 
	 * <blockquote><pre>
	 * GestureList gesturesInFrame = frame.gestures();
	 * </pre></blockquote>
	 * 
	 * Circle and swipe gestures are updated every frame. Tap gestures only appear in the list for a single frame.
	 * 
	 * @return {@link GestureList} the list of gestures.
	 */
	public GestureList gestures() {
		return new GestureList(LeapJNI.Frame_gestures__SWIG_0(this.swigCPtr, this), true);
	}

	/**
	 * Returns a {@link GestureList} containing all gestures that have occurred since the specified frame.
	 * 
	 * <blockquote><pre>
	 * GestureList gesturesSinceFrame = frame.gestures(lastProcessedFrame);
	 * </pre></blockquote>
	 * 
	 * @param sinceFrame - An earlier {@codew Frame} object. 
	 * The starting frame must still be in the frame history cache, which has a default length of 60 frames.
	 * 
	 * @return {@link GestureList}The list of the {@link Gesture} objects that have occurred since the specified frame.
	 */
	public GestureList gestures(Frame sinceFrame) {
		return new GestureList(LeapJNI.Frame_gestures__SWIG_1(this.swigCPtr, this, getCPtr(sinceFrame), sinceFrame), true);
	}

	/**
	 * The list of images from the Leap Motion cameras.
	 * 
	 * @return An {@link ImageList} object containing the camera images analyzed to create this {@code Frame}.
	 */
	public ImageList images() {
		return new ImageList(LeapJNI.Frame_images(this.swigCPtr, this), true);
	}

	/**
	 * The change of position derived from the overall linear motion between the current frame and the specified frame.<p>
	 * 
	 * The returned translation vector provides the magnitude and direction of the movement in millimeters.
	 * 
	 * <blockquote><pre>
	 * Vector linearMovement = frame.translation(startFrame);
	 * </pre></blockquote>
	 * 
	 * The Leap Motion software derives frame translation from the linear motion 
	 * of all objects detected in the field of view.<p>
	 * 
	 * If either this frame or sinceFrame is an invalid {@code Frame} object, then this method returns a zero vector.
	 * 
	 * @param sinceFrame - The starting frame for computing the relative translation.
	 * @return A {@link Vector} representing the heuristically determined change 
	 * in position of all objects between the current frame and that specified in the sinceFrame parameter.
	 */
	public Vector translation(Frame sinceFrame) {
		return new Vector(LeapJNI.Frame_translation(this.swigCPtr, this, getCPtr(sinceFrame), sinceFrame), true);
	}

	/**
	 * The estimated probability that the overall motion between the current frame and the specified frame 
	 * is intended to be a translating motion.
	 * 
	 * <blockquote><pre>
	 * float translationDominance = frame.translationProbability(startFrame);
	 * </pre></blockquote>
	 * 
	 * If either this frame or sinceFrame is an invalid {@code Frame} object, then this method returns zero.
	 * 
	 * @param sinceFrame - The starting frame for computing the translation.
	 * 
	 * @return A value between 0 and 1 representing the estimated probability that the overall motion 
	 * between the current frame and the specified frame is intended to be a translating motion.
	 */
	public float translationProbability(Frame sinceFrame) {
		return LeapJNI.Frame_translationProbability(this.swigCPtr, this, getCPtr(sinceFrame), sinceFrame);
	}

	/**
	 * The axis of rotation derived from the overall rotational motion between the current frame and the specified frame.<p>
	 * 
	 * The returned direction vector is normalized.
	 * 
	 * <blockquote><pre>
	 * Vector axisOfRotation = frame.rotationAxis(startFrame);
	 * </pre></blockquote>
	 * 
	 * The Leap Motion software derives frame rotation from the relative change in position 
	 * and orientation of all objects detected in the field of view.<p>
	 * 
	 * If either this frame or sinceFrame is an invalid {@code Frame} object, 
	 * or if no rotation is detected between the two frames, a zero vector is returned.
	 * 
	 * @param sinceFrame - The starting frame for computing the relative rotation.
	 * 
	 * @return A normalized direction Vector representing the axis of the heuristically determined rotational change 
	 * between the current frame and that specified in the sinceFrame parameter.
	 */
	public Vector rotationAxis(Frame sinceFrame) {
		return new Vector(LeapJNI.Frame_rotationAxis(this.swigCPtr, this, getCPtr(sinceFrame), sinceFrame), true);
	}

	/**
	 * The angle of rotation around the rotation axis derived from the overall rotational motion between 
	 * the current frame and the specified frame.<p>
	 * 
	 * The returned angle is expressed in radians measured clockwise around the rotation axis 
	 * (using the right-hand rule) between the start and end frames. 
	 * The value is always between 0 and pi radians (0 and 180 degrees).
	 * 
	 * <blockquote><pre>
	 * float rotationInFrame = frame.rotationAngle(startFrame);
	 * </pre></blockquote>
	 * 
	 * The Leap Motion software derives frame rotation from the relative change in position 
	 * and orientation of all objects detected in the field of view.<p>
	 * 
	 * If either this frame or sinceFrame is an invalid {@code Frame} object, then the angle of rotation is zero.
	 * 
	 * @param sinceFrame - The starting frame for computing the relative rotation.
	 * 
	 * @return A positive value containing the heuristically determined rotational change 
	 * between the current frame and that specified in the sinceFrame parameter.
	 */
	public float rotationAngle(Frame sinceFrame) {
		return LeapJNI.Frame_rotationAngle__SWIG_0(this.swigCPtr, this, getCPtr(sinceFrame), sinceFrame);
	}

	/**
	 * The angle of rotation around the specified axis derived from the overall rotational motion between 
	 * the current frame and the specified frame.<p>
	 * 
	 * The returned angle is expressed in radians measured clockwise around the rotation axis 
	 * (using the right-hand rule) between the start and end frames. 
	 * The value is always between -pi and pi radians (-180 and 180 degrees).
	 * 
	 * <blockquote><pre>
	 * float rotationAroundXAxis = frame.rotationAngle(startFrame, Vector.xAxis());
	 * </pre></blockquote>
	 * 
	 * The Leap Motion software derives frame rotation from the relative change in position 
	 * and orientation of all objects detected in the field of view.<p>
	 * 
	 * If either this frame or sinceFrame is an invalid {@code Frame} object, then the angle of rotation is zero.
	 * 
	 * @param sinceFrame - The starting frame for computing the relative rotation.
	 * @param axis - The axis to measure rotation around.
	 * 
	 * @return A value containing the heuristically determined rotational change 
	 * between the current frame and that specified in the sinceFrame parameter around the given axis.
	 */
	public float rotationAngle(Frame sinceFrame, Vector axis) {
		return LeapJNI.Frame_rotationAngle__SWIG_1(this.swigCPtr, this, getCPtr(sinceFrame), sinceFrame, Vector.getCPtr(axis), axis);
	}

	/**
	 * The transform matrix expressing the rotation derived from the overall rotational motion 
	 * between the current frame and the specified frame.
	 * 
	 * <blockquote><pre>
	 * Matrix rotationTransform = frame.rotationMatrix(startFrame);
	 * </pre></blockquote>
	 * 
	 * The Leap Motion software derives frame rotation from the relative change in position 
	 * and orientation of all objects detected in the field of view.<p>
	 * 
	 * If either this frame or sinceFrame is an invalid {@code Frame} object, then this method returns an identity matrix.
	 * 
	 * @param sinceFrame - The starting frame for computing the relative rotation.
	 * 
	 * @return A transformation Matrix containing the heuristically determined rotational change 
	 * between the current frame and that specified in the sinceFrame parameter.
	 */
	public Matrix rotationMatrix(Frame sinceFrame) {
		return new Matrix(LeapJNI.Frame_rotationMatrix(this.swigCPtr, this, getCPtr(sinceFrame), sinceFrame), true);
	}

	/**
	 * The estimated probability that the overall motion between the current frame and the specified frame 
	 * is intended to be a rotating motion.
	 * 
	 * <blockquote><pre>
	 * float rotationDominance = frame.rotationProbability(startFrame);
	 * </pre></blockquote>
	 * 
	 * If either this frame or sinceFrame is an invalid {@code Frame} object, then this method returns zero.
	 * 
	 * @param sinceFrame - The starting frame for computing the relative rotation.
	 * 
	 * @return A value between 0 and 1 representing the estimated probability that the overall motion 
	 * between the current frame and the specified frame is intended to be a rotating motion.
	 */
	public float rotationProbability(Frame sinceFrame) {
		return LeapJNI.Frame_rotationProbability(this.swigCPtr, this, getCPtr(sinceFrame), sinceFrame);
	}

	/**
	 * The scale factor derived from the overall motion between the current frame and the specified frame.<p>
	 * 
	 * The scale factor is always positive. A value of 1.0 indicates no scaling took place. 
	 * Values between 0.0 and 1.0 indicate contraction and values greater than 1.0 indicate expansion.
	 * 
	 * <blockquote><pre>
	 * float zoomFactor = frame.scaleFactor(startFrame);
	 * </pre></blockquote>
	 * 
	 * The Leap Motion software derives scaling from the relative inward or outward motion 
	 * of all objects detected in the field of view (independent of translation and rotation).<p>
	 * 
	 * If either this frame or sinceFrame is an invalid {@code Frame} object, then this method returns 1.0.
	 * 
	 * @param sinceFrame - The starting frame for computing the relative scaling.
	 * 
	 * @return A positive value representing the heuristically determined scaling change ratio between 
	 * the current frame and that specified in the sinceFrame parameter.
	 */
	public float scaleFactor(Frame sinceFrame) {
		return LeapJNI.Frame_scaleFactor(this.swigCPtr, this, getCPtr(sinceFrame), sinceFrame);
	}

	/**
	 * The estimated probability that the overall motion between the current frame and the specified frame 
	 * is intended to be a scaling motion.
	 * 
	 * <blockquote><pre>
	 * float scaleDominance = frame.scaleProbability(startFrame);
	 * </pre></blockquote>
	 * 
	 * If either this frame or sinceFrame is an invalid {@code Frame} object, then this method returns zero.
	 * 
	 * @param sinceFrame - The starting frame for computing the relative scaling.
	 * 
	 * @return A value between 0 and 1 representing the estimated probability that the overall motion 
	 * between the current frame and the specified frame is intended to be a scaling motion.
	 */
	public float scaleProbability(Frame sinceFrame) {
		return LeapJNI.Frame_scaleProbability(this.swigCPtr, this, getCPtr(sinceFrame), sinceFrame);
	}

	/**
	 * The current {@link InteractionBox} for the frame.<p>
	 * 
	 * See the {@link InteractionBox} class documentation for more details on how this class should be used.
	 * 
	 * <blockquote><pre>
	 * InteractionBox box = frame.interactionBox();
	 * </pre></blockquote>
	 * 
	 * @return The current {@link InteractionBox} object.
	 */
	public InteractionBox interactionBox() {
		return new InteractionBox(LeapJNI.Frame_interactionBox(this.swigCPtr, this), true);
	}

	/**
	 * The instantaneous framerate.<p>
	 * 
	 * The rate at which the Leap Motion software is providing frames of data (in frames per second). 
	 * The framerate can fluctuate depending on available computing resources, 
	 * activity within the device field of view, software tracking settings, and other factors.
	 * 
	 * <blockquote><pre>
	 * float instantaneousFrameRate = frame.currentFramesPerSecond();
	 * </pre></blockquote>
	 * 
	 * @return An estimate of frames per second of the Leap Motion {@link Controller}.
	 */
	public float currentFramesPerSecond() {
		return LeapJNI.Frame_currentFramesPerSecond(this.swigCPtr, this);
	}

	/**
	 * Reports whether this {@code Frame} instance is valid.<p>
	 * 
	 * A valid {@code Frame} is one generated by the {@link Controller} object that contains 
	 * tracking data for all detected entities. 
	 * An invalid {@code Frame} contains no actual tracking data, 
	 * but you can call its functions without risk of a null pointer exception. 
	 * The invalid {@code Frame} mechanism makes it more convenient to track individual data across 
	 * the frame history. 
	 * For example, you can invoke:
	 * 
	 * <blockquote><pre>
	 * Finger finger = controller.frame(n).finger(fingerID);
	 * </pre></blockquote>
	 * 
	 * for an arbitrary {@code Frame} history value, “n”, without first checking whether frame(n) returned a null object. 
	 * (You should still check that the returned {@link Finger} instance is valid.)
	 * 
	 * @return True, if this is a valid {@code Frame} object; false otherwise.
	 */
	public boolean isValid() {
		return LeapJNI.Frame_isValid(this.swigCPtr, this);
	}

	/**
	 * Returns an invalid {@code Frame} object.<p>
	 * 
	 * You can use the instance returned by this function in comparisons testing whether 
	 * a given {@code Frame} instance is valid or invalid. (You can also use the {@link Frame#isValid()} function.)
	 * 
	 * <blockquote><pre>
	 * //Average a finger position for the last 10 frames
	 * int count = 0;
	 * Vector average = new Vector();
	 * Finger fingerToAverage = frame.fingers().get(0);
	 * for (int i = 0; i < 10; i++) {
	 *     Finger fingerFromFrame = controller.frame(i).finger(fingerToAverage.id());
	 *     if(fingerFromFrame.isValid()) {
	 *         average = average.plus(fingerFromFrame.tipPosition());
	 *         count++;
	 *     }
	 *     average = average.divide(count);
	 * }
	 * </pre></blockquote>
	 * 
	 * @return The invalid {@code Frame} instance.
	 */
	public static Frame invalid() {
		return new Frame(LeapJNI.Frame_invalid(), false);
	}

	/**
	 * Compare {@code Frame} object equality.
	 * 
	 * <blockquote><pre>
	 * Boolean isFrameEqual = thisFrame.equals(thatFrame);
	 * </pre></blockquote>
	 * 
	 * Two {@code Frame} objects are equal if and only if both {@code Frame} objects 
	 * represent the exact same frame of tracking data and both {@code Frame} objects are valid.
	 * 
	 * @param frame - {@code Frame} object to compare
	 * 
	 * @return true if the {@code Frame} objects are equal.
	 */
	public boolean equals(Frame frame) {
		return LeapJNI.Frame_equals(this.swigCPtr, this, getCPtr(frame), frame);
	}

	/**
	 * <b>Note:</b> This class is an experimental API for internal use only.<p>
	 * 
	 * It may be removed without warning.<p>
	 * 
	 * @return information about the currently detected quad in the scene.
	 * If no quad is being tracked, then an invalid {@link TrackedQuad} is returned.
	 */
	public TrackedQuad trackedQuad() {
		return new TrackedQuad(LeapJNI.Frame_trackedQuad(this.swigCPtr, this), true);
	}

	public void serialize(byte[] paramArrayOfByte) {
		LeapJNI.Frame_serialize(this.swigCPtr, this, paramArrayOfByte);
	}

	public int serializeLength() {
		return LeapJNI.Frame_serializeLength(this.swigCPtr, this);
	}

	public void deserialize(byte[] paramArrayOfByte, int paramInt) {
		LeapJNI.Frame_deserialize(this.swigCPtr, this, paramArrayOfByte, paramInt);
	}

	/**
	 * A string containing a brief, human readable description of the {@code Frame} object.
	 * 
	 * @return A description of the {@code Frame} as a string.
	 */
	public String toString() {
		return LeapJNI.Frame_toString(this.swigCPtr, this);
	}

	public static long getCPtr(Frame paramFrame) {
		return paramFrame == null ? 0L : paramFrame.swigCPtr;
	}

	protected void finalize() {
		delete();
	}

	public synchronized void delete() {
		if (this.swigCPtr != 0L) {
			if (this.swigCMemOwn) {
				this.swigCMemOwn = false;
				LeapJNI.delete_Frame(this.swigCPtr);
			}
			this.swigCPtr = 0L;
		}
		super.delete();
	}

}
