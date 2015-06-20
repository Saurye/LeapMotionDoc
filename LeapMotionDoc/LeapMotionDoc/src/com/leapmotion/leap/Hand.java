package com.leapmotion.leap;

/**
 * The {@code Hand} class reports the physical characteristics of a detected hand.<p>
 * 
 * {@code Hand} tracking data includes a palm position and velocity; 
 * vectors for the palm normal and direction to the fingers; 
 * properties of a sphere fit to the hand; and lists of the attached fingers.<p>
 * 
 * Get {@code Hand} objects from a {@link Frame} object:
 * 
 * <blockquote><pre>
 * Frame frame = controller.frame(); // controller is a Controller object
 * HandList hands = frame.hands();
 * Hand firstHand = hands.get(0); 
 * </pre></blockquote>
 * 
 * Note that Hand objects can be invalid, which means that they do not contain valid tracking data 
 * and do not correspond to a physical entity. 
 * Invalid {@code Hand} objects can be the result of asking for a {@code Hand} object using an ID from an earlier frame 
 * when no {@code Hand} objects with that ID exist in the current frame. 
 * A {@code Hand} object created from the {@code Hand} constructor is also invalid. 
 * Test for validity with the {@link Hand#isValid()} function.
 * 
 * @since 1.0
 * @author Leap Motion Inc
 */
public class Hand extends Interface {
	private long swigCPtr;

	/**
	 * Constructs a {@code Hand} object.<p>
	 * 
	 * An uninitialized hand is considered invalid. Get valid {@code Hand} objects from a {@link Frame} object.
	 * 
	 * <blockquote><pre>
	 * Hand leftmostHand = frame.hands().leftmost();
	 * </pre></blockquote>
	 */
	public Hand() {
		this(LeapJNI.new_Hand(), true);
	}
	
	public Hand(long paramLong, boolean paramBoolean)
	{
		super(LeapJNI.Hand_SWIGUpcast(paramLong), paramBoolean);
		this.swigCPtr = paramLong;
	}

	/**
	 * A unique ID assigned to this {@code Hand} object, whose value remains the same across consecutive frames 
	 * while the tracked hand remains visible.<p>
	 * 
	 * If tracking is lost (for example, when a hand is occluded by another hand 
	 * or when it is withdrawn from or reaches the edge of the Leap Motion Controller field of view), 
	 * the Leap Motion software may assign a new ID when it detects the hand in a future frame.<p>
	 * 
	 * Use the ID value with the {@link Frame#hand(int)} function to find this {@code Hand} object in future frames:
	 * 
	 * <blockquote><pre>
	 * Hand knownHand = frame.hand(handID);
	 * </pre></blockquote>
	 * 
	 * @return The ID of this hand.
	 */
	public int id() {
		return LeapJNI.Hand_id(this.swigCPtr, this);
	}

	/**
	 * The {@link Frame} associated with this {@code Hand}.
	 * 
	 * <blockquote><pre>
	 * Frame frameForHand = hand.frame();
	 * </pre></blockquote>
	 * 
	 * @return The associated {@link Frame} object, if available; 
	 * otherwise, an invalid {@link Frame} object is returned.
	 */
	public Frame frame() {
		return new Frame(LeapJNI.Hand_frame(this.swigCPtr, this), true);
	}

	/**
	 * The list of {@link Pointable} objects detected in this frame that are associated with this hand, 
	 * given in arbitrary order.<p>
	 * 
	 * The list will always contain 5 fingers.<p>
	 * 
	 * Use {@link PointableList#extended()} to remove non-extended fingers from the list.
	 * 
	 * <blockquote><pre>
	 * // hand is a Hand object
	 * PointableList pointables = hand.pointables();
	 * FingerList fingers = hand.fingers();
	 * </pre></blockquote>
	 * 
	 * @return The {@link PointableList} containing all {@link Pointable} objects associated with this hand.
	 */
	public PointableList pointables() {
		return new PointableList(LeapJNI.Hand_pointables(this.swigCPtr, this), true);
	}

	/**
	 * The {@link Pointable} object with the specified ID associated with this hand.<p>
	 * 
	 * Use the {@code Hand.pointable()} function to retrieve a {@link Pointable} object associated with 
	 * this hand using an ID value obtained from a previous frame. 
	 * This function always returns a {@link Pointable} object, but if no finger with the specified ID is present, 
	 * an invalid {@link Pointable} object is returned.
	 * 
	 * <blockquote><pre>
	 * Pointable knownPointable = hand.pointable(pointableID);
	 * </pre></blockquote>
	 * 
	 * Note that the ID values assigned to fingers are based on the hand ID. Hand IDs persist across frames, 
	 * but only until tracking of that hand is lost. 
	 * If tracking of the hand is lost and subsequently regained, the new {@code Hand} object 
	 * and its child {@link Finger} objects will have a different ID than in an earlier frame.
	 * 
	 * @param id - The ID value of a {@link Pointable} object from a previous frame.
	 * 
	 * @return The {@link Pointable} object with the matching ID if one exists for this hand in this frame; 
	 * otherwise, an invalid {@link Pointable} object is returned.
	 */
	public Pointable pointable(int id) {
		return new Pointable(LeapJNI.Hand_pointable(this.swigCPtr, this, id), true);
	}

	/**
	 * The list of {@link Finger} objects detected in this frame that are attached to this hand, 
	 * given in order from thumb to pinky.<p>
	 * 
	 * The list cannot be empty.<p>
	 * 
	 * Use {@link PointableList#extended()} to remove non-extended fingers from the list.
	 * 
	 * <blockquote><pre>
	 * // hand is a Hand object
	 * PointableList pointables = hand.pointables();
	 * FingerList fingers = hand.fingers();
	 * </pre></blockquote>
	 * 
	 * @return The {@link FingerList} containing all {@link Finger} objects attached to this hand.
	 */
	public FingerList fingers() {
		return new FingerList(LeapJNI.Hand_fingers(this.swigCPtr, this), true);
	}

	/**
	 * The {@link Finger} object with the specified ID attached to this hand.<p>
	 * 
	 * Use the (@code Hand.finger()} function to retrieve a {@link Finger} object attached to 
	 * this hand using an ID value obtained from a previous frame. 
	 * This function always returns a {@link Finger} object, but if no finger with the specified ID is present, 
	 * an invalid {@link Finger} object is returned.
	 * 
	 * <blockquote><pre>
	 * Finger fingerOnHandByID = hand.finger(fingerID);
	 * </pre></blockquote>
	 * 
	 * Note that ID values persist across frames, but only until tracking of a particular object is lost. 
	 * If tracking of a finger is lost and subsequently regained, the new {@link Finger} object representing 
	 * that finger may have a different ID than that representing the finger in an earlier frame.
	 * 
	 * @param id - The ID value of a {@link Finger} object from a previous frame.
	 * 
	 * @return The {@link Finger} object with the matching ID if one exists for this hand in this frame; 
	 * otherwise, an invalid {@link Finger} object is returned.
	 */
	public Finger finger(int id) {
		return new Finger(LeapJNI.Hand_finger(this.swigCPtr, this, id), true);
	}

	/**
	 * Tools are not associated with hands in version 2+.<p>
	 * 
	 * This list is always empty. 
	 */
	public ToolList tools() {
		return new ToolList(LeapJNI.Hand_tools(this.swigCPtr, this), true);
	}

	/**
	 * Tools are not associated with hands in version 2+.<p>
	 * 
	 * This function always returns an invalid Tool object.
	 */
	public Tool tool(int paramInt) {
		return new Tool(LeapJNI.Hand_tool(this.swigCPtr, this, paramInt), true);
	}

	/**
	 * The center position of the palm in millimeters from the Leap Motion {@link Controller} origin.
	 * 
	 * <blockquote><pre>
	 * Vector handCenter = hand.palmPosition();
	 * </pre></blockquote>
	 * 
	 * @return The {@link Vector} representing the coordinates of the palm position.
	 */
	public Vector palmPosition() {
		return new Vector(LeapJNI.Hand_palmPosition(this.swigCPtr, this), true);
	}

	/**
	 * The stabilized palm position of this {@code Hand}.<p>
	 * 
	 * Smoothing and stabilization is performed in order to make this value more suitable 
	 * for interaction with 2D content. 
	 * The stabilized position lags behind the palm position by a variable amount, 
	 * depending primarily on the speed of movement.
	 * 
	 * <blockquote><pre>
	 * Vector filteredHandPosition = hand.stabilizedPalmPosition();
	 * </pre></blockquote>
	 * 
	 * @return A modified palm position of this {@code Hand} object with some additional 
	 * smoothing and stabilization applied.
	 */
	public Vector stabilizedPalmPosition() {
		return new Vector(LeapJNI.Hand_stabilizedPalmPosition(this.swigCPtr, this), true);
	}

	/**
	 * The rate of change of the palm position in millimeters/second.
	 * 
	 * <blockquote><pre>
	 * Vector handSpeed = hand.palmVelocity();
	 * </pre></blockquote>
	 * 
	 * @return The {@link Vector} representing the coordinates of the palm velocity.
	 */
	public Vector palmVelocity() {
		return new Vector(LeapJNI.Hand_palmVelocity(this.swigCPtr, this), true);
	}

	/**
	 * The normal vector to the palm.<p>
	 * 
	 * If your hand is flat, this vector will point downward, or “out” of the front surface of your palm.<p>
	 * 
	 * <img src="\images\Leap_Palm_Vectors.png"/><p>
	 *  
	 * The direction is expressed as a unit vector pointing in the same direction as the palm normal 
	 * (that is, a vector orthogonal to the palm).
	 *  
	 * You can use the palm normal vector to compute the roll angle of the palm with respect to the horizontal plane:
	 * 
	 * <blockquote><pre>
	 * float pitch = hand.direction().pitch();
	 * float yaw = hand.direction().yaw();
	 * float roll = hand.palmNormal().roll();
	 * </pre></blockquote>
	 *  
	 * @return The {@link Vector} normal to the plane formed by the palm. 
	 */
	public Vector palmNormal() {
		return new Vector(LeapJNI.Hand_palmNormal(this.swigCPtr, this), true);
	}

	/**
	 * The estimated width of the palm when the hand is in a flat position.
	 * 
	 * <blockquote><pre>
	 * float handWidth = hand.palmWidth();
	 * </pre></blockquote>
	 * 
	 * @return The width of the palm in millimeters
	 */
	public float palmWidth() {
		return LeapJNI.Hand_palmWidth(this.swigCPtr, this);
	}

	/**
	 * The direction from the palm position toward the fingers.<p>
	 * 
	 * The direction is expressed as a unit vector pointing in the same direction as 
	 * the directed line from the palm position to the fingers.<p>
	 * 
	 * You can use the palm direction vector to compute the pitch and yaw angles of the palm 
	 * with respect to the horizontal plane:
	 * 
	 * <blockquote><pre>
	 * float pitch = hand.direction().pitch();
	 * float yaw = hand.direction().yaw();
	 * float roll = hand.palmNormal().roll();
	 * </pre></blockquote>
	 * 
	 * @return The {@link Vector} pointing from the palm position toward the fingers.
	 */
	public Vector direction() {
		return new Vector(LeapJNI.Hand_direction(this.swigCPtr, this), true);
	}

	/**
	 * The orientation of the hand as a basis matrix.<p>
	 * 
	 * The basis is defined as follows:<p>
	 * 
	 * <b>xAxis</b> Positive in the direction of the pinky<p>
	 * 
	 * <b>yAxis</b> Positive above the hand<p>
	 * 
	 * <b>zAxis</b> Positive in the direction of the wrist<p>
	 * 
	 * Note: Since the left hand is a mirror of the right hand, the basis matrix will be left-handed for left hands.
	 * 
	 * <blockquote><pre>
	 * Matrix basis = hand.basis();
	 * Vector xBasis = basis.getXBasis();
	 * Vector yBasis = basis.getYBasis();
	 * Vector zBasis = basis.getZBasis();
	 * </pre></blockquote>
	 * 
	 * @return The basis of the hand as a matrix.
	 */
	public Matrix basis() {
		return new Matrix(LeapJNI.Hand_basis(this.swigCPtr, this), true);
	}

	/**
	 * The arm to which this hand is attached.<p>
	 * 
	 * If the arm is not completely in view, {@link Arm} attributes are estimated based on the attributes 
	 * of entities that are in view combined with typical human anatomy.
	 * 
	 * <blockquote><pre>
	 * Hand hand = frame.hands().frontmost();
	 * Arm arm = hand.arm();
	 * </pre></blockquote>
	 * 
	 * @return The {@link Arm} object for this hand.
	 */
	public Arm arm() {
		return new Arm(LeapJNI.Hand_arm(this.swigCPtr, this), true);
	}

	/**
	 * The position of the wrist of this hand.
	 * 
	 * @return A vector containing the coordinates of the wrist position in millimeters.
	 */
	public Vector wristPosition() {
		return new Vector(LeapJNI.Hand_wristPosition(this.swigCPtr, this), true);
	}

	/**
	 * The center of a sphere fit to the curvature of this hand.
	 * 
	 * <blockquote><pre>
	 * Vector sphereCenter = hand.sphereCenter();
	 * </pre></blockquote>
	 * 
	 * This sphere is placed roughly as if the hand were holding a ball.<p>
	 * 
	 * <img src="\images\Leap_Hand_Ball.png"/><p>
	 * 
	 * @return The {@link Vector} representing the center position of the sphere.
	 */
	public Vector sphereCenter() {
		return new Vector(LeapJNI.Hand_sphereCenter(this.swigCPtr, this), true);
	}

	/**
	 * The radius of a sphere fit to the curvature of this hand.<p>
	 * 
	 * This sphere is placed roughly as if the hand were holding a ball. 
	 * Thus the size of the sphere decreases as the fingers are curled into a fist.
	 * 
	 * <blockquote><pre>
	 * float sphereDiameter = 2 * hand.sphereRadius();
	 * </pre></blockquote>
	 * 
	 * @return The radius of the sphere in millimeters.
	 */
	public float sphereRadius() {
		return LeapJNI.Hand_sphereRadius(this.swigCPtr, this);
	}

	/**
	 * The holding strength of a pinch hand pose.<p>
	 * 
	 * The strength is zero for an open hand, and blends to 1.0 when a pinching hand pose is recognized. 
	 * Pinching can be done between the thumb and any other finger of the same hand.
	 * 
	 * <blockquote><pre>
	 * float pinch = hand.pinchStrength();
	 * </pre></blockquote>
	 * 
	 * @return A float value in the [0..1] range representing the holding strength of the pinch pose.
	 */
	public float pinchStrength() {
		return LeapJNI.Hand_pinchStrength(this.swigCPtr, this);
	}

	/**
	 * The strength of a grab hand pose.<p>
	 * 
	 * The strength is zero for an open hand, and blends to 1.0 when a grabbing hand pose is recognized.
	 * 
	 * <blockquote><pre>
	 * float strength = hand.grabStrength();
	 * </pre></blockquote>
	 * 
	 * @return A float value in the [0..1] range representing the holding strength of the pose.
	 */
	public float grabStrength() {
		return LeapJNI.Hand_grabStrength(this.swigCPtr, this);
	}

	/**
	 * The change of position of this hand between the current frame and the specified frame.<p>
	 * 
	 * The returned translation vector provides the magnitude and direction of the movement in millimeters.
	 * 
	 * <blockquote><pre>
	 * Vector linearHandMovement = hand.translation(startFrame);
	 * </pre></blockquote>
	 * 
	 * If a corresponding {@code Hand} object is not found in sinceFrame, 
	 * or if either this frame or sinceFrame are invalid {@link Frame} objects, then this method returns a zero vector.
	 * 
	 * @param sinceFrame - The starting frame for computing the translation.
	 * 
	 * @return A {@link Vector} representing the heuristically determined change in hand position 
	 * between the current frame and that specified in the sinceFrame parameter.
	 */
	public Vector translation(Frame sinceFrame) {
		return new Vector(LeapJNI.Hand_translation(this.swigCPtr, this, Frame.getCPtr(sinceFrame), sinceFrame), true);
	}

	/**
	 * The estimated probability that the hand motion between the current frame and the specified frame 
	 * is intended to be a translating motion.
	 * 
	 * <blockquote><pre>
	 * float translationIntentFactor = hand.translationProbability(startFrame);
	 * </pre></blockquote>
	 * 
	 * If a corresponding Hand object is not found in sinceFrame, or if either this frame or sinceFrame are invalid Frame objects, then this method returns zero.
	 * 
	 * @param sinceFrame - The starting frame for computing the translation.
	 * 
	 * @return A value between 0 and 1 representing the estimated probability that the hand motion 
	 * between the current frame and the specified frame is intended to be a translating motion.
	 */
	public float translationProbability(Frame sinceFrame) {
		return LeapJNI.Hand_translationProbability(this.swigCPtr, this, Frame.getCPtr(sinceFrame), sinceFrame);
	}

	/**
	 * The axis of rotation derived from the change in orientation of this hand, 
	 * and any associated fingers, between the current frame and the specified frame.
	 * 
	 * <blockquote><pre>
	 * Vector axisOfHandRotation = hand.rotationAxis(startFrame); 
	 * </pre></blockquote>
	 * 
	 * The returned direction vector is normalized.<p>
	 * 
	 * If a corresponding {@code Hand} object is not found in sinceFrame, 
	 * or if either this frame or sinceFrame are invalid {@link Frame} objects, then this method returns a zero vector.
	 * 
	 * @param sinceFrame - The starting frame for computing the relative rotation.
	 * 
	 * @return A normalized direction Vector representing the heuristically determined axis of rotational change 
	 * of the hand between the current frame and that specified in the sinceFrame parameter.
	 */
	public Vector rotationAxis(Frame sinceFrame) {
		return new Vector(LeapJNI.Hand_rotationAxis(this.swigCPtr, this, Frame.getCPtr(sinceFrame), sinceFrame), true);
	}

	/**
	 * The angle of rotation around the rotation axis derived from the change in orientation of this hand, 
	 * and any associated fingers, between the current frame and the specified frame.
	 * 
	 * <blockquote><pre>
	 * float rotationOfHand = hand.rotationAngle(startFrame);
	 * </pre></blockquote>
	 * 
	 * The returned angle is expressed in radians measured clockwise around the rotation axis 
	 * (using the right-hand rule) between the start and end frames. 
	 * The value is always between 0 and pi radians (0 and 180 degrees).<p>
	 * 
	 * If a corresponding {@code Hand} object is not found in sinceFrame, 
	 * or if either this frame or sinceFrame are invalid {@link Frame} objects, then the angle of rotation is zero.
	 * 
	 * @param sinceFrame - The starting frame for computing the relative rotation.
	 * 
	 * @return A positive value representing the heuristically determined rotational change of the hand 
	 * between the current frame and that specified in the sinceFrame parameter.
	 */
	public float rotationAngle(Frame sinceFrame) {
		return LeapJNI.Hand_rotationAngle__SWIG_0(this.swigCPtr, this, Frame.getCPtr(sinceFrame), sinceFrame);
	}

	/**
	 * The angle of rotation around the rotation axis derived from the change in orientation of this hand, 
	 * and any associated fingers, between the current frame and the specified frame.
	 * 
	 * <blockquote><pre>
	 * float rotationAroundYAxis = hand.rotationAngle(startFrame, Vector.yAxis());
	 * </pre></blockquote>
	 * 
	 * The returned angle is expressed in radians measured clockwise around the rotation axis 
	 * (using the right-hand rule) between the start and end frames. 
	 * The value is always between -pi and pi radians (-180 and 180 degrees).<p>
	 * 
	 * If a corresponding {@code Hand} object is not found in sinceFrame, 
	 * or if either this frame or sinceFrame are invalid {@link Frame} objects, then the angle of rotation is zero.
	 * 
	 * @param sinceFrame - The starting frame for computing the relative rotation.
	 * @param axis - The axis to measure rotation around.
	 * 
	 * @return A value representing the heuristically determined rotational change of the hand 
	 * between the current frame and that specified in the sinceFrame parameter around the specified axis.
	 */
	public float rotationAngle(Frame sinceFrame, Vector axis) {
		return LeapJNI.Hand_rotationAngle__SWIG_1(this.swigCPtr, this, Frame.getCPtr(sinceFrame), sinceFrame, Vector.getCPtr(axis), axis);
	}

	/**
	 * The transform matrix expressing the rotation derived from the change in orientation of this hand, 
	 * and any associated fingers, between the current frame and the specified frame.
	 * 
	 * <blockquote><pre>
	 * Matrix handRotationTransform = hand.rotationMatrix(startFrame);
	 * </pre></blockquote>
	 * 
	 * If a corresponding {@code Hand} object is not found in sinceFrame, 
	 * or if either this frame or sinceFrame are invalid {@link Frame} objects, then this method returns an identity matrix.
	 * 
	 * @param sinceFrame - The starting frame for computing the relative rotation.
	 * 
	 * @return A transformation Matrix representing the heuristically determined rotational change 
	 * of the hand between the current frame and that specified in the sinceFrame parameter.
	 */
	public Matrix rotationMatrix(Frame sinceFrame) {
		return new Matrix(LeapJNI.Hand_rotationMatrix(this.swigCPtr, this, Frame.getCPtr(sinceFrame), sinceFrame), true);
	}

	/**
	 * The estimated probability that the hand motion between the current frame 
	 * and the specified frame is intended to be a rotating motion.
	 * 
	 * <blockquote><pre>
	 * float rotationIntentFactor = hand.rotationProbability(startFrame);
	 * </pre></blockquote>
	 * 
	 * If a corresponding {@code Hand} object is not found in sinceFrame, 
	 * or if either this frame or sinceFrame are invalid {@link Frame} objects, then this method returns zero.
	 * 
	 * @param sinceFrame - The starting frame for computing the relative rotation.
	 * 
	 * @return A value between 0 and 1 representing the estimated probability 
	 * that the hand motion between the current frame and the specified frame is intended to be a rotating motion.
	 */
	public float rotationProbability(Frame sinceFrame) {
		return LeapJNI.Hand_rotationProbability(this.swigCPtr, this, Frame.getCPtr(sinceFrame), sinceFrame);
	}

	/**
	 * The scale factor derived from this hand’s motion between the current frame and the specified frame.<p>
	 * 
	 * The scale factor is always positive. A value of 1.0 indicates no scaling took place. 
	 * Values between 0.0 and 1.0 indicate contraction and values greater than 1.0 indicate expansion.
	 * 
	 * <blockquote><pre>
	 * float handScaleMotion = hand.scaleFactor(startFrame);
	 * </pre></blockquote>
	 * 
	 * The Leap Motion software derives scaling from the relative inward or outward motion of a hand 
	 * and its associated fingers (independent of translation and rotation).<p>
	 * 
	 * If a corresponding {@code Hand} object is not found in sinceFrame, 
	 * or if either this frame or sinceFrame are invalid {@link Frame} objects, then this method returns 1.0.
	 * 
	 * @param sinceFrame - The starting frame for computing the relative scaling.
	 * 
	 * @return A positive value representing the heuristically determined scaling change ratio 
	 * of the hand between the current frame and that specified in the sinceFrame parameter.
	 */
	public float scaleFactor(Frame sinceFrame) {
		return LeapJNI.Hand_scaleFactor(this.swigCPtr, this, Frame.getCPtr(sinceFrame), sinceFrame);
	}

	/**
	 * The estimated probability that the hand motion between the current frame and the specified frame 
	 * is intended to be a scaling motion.
	 * 
	 * <blockquote><pre>
	 * float scaleIntentFactor = hand.scaleProbability(startFrame);
	 * </pre></blockquote>
	 * 
	 * If a corresponding {@code Hand} object is not found in sinceFrame, 
	 * or if either this frame or sinceFrame are invalid {@link Frame} objects, then this method returns zero.
	 * 
	 * @param sinceFrame - The starting frame for computing the relative scaling.
	 * 
	 * @return A value between 0 and 1 representing the estimated probability that the hand motion between 
	 * the current frame and the specified frame is intended to be a scaling motion.
	 */
	public float scaleProbability(Frame sinceFrame) {
		return LeapJNI.Hand_scaleProbability(this.swigCPtr, this, Frame.getCPtr(sinceFrame), sinceFrame);
	}

	/**
	 * The duration of time this Hand has been visible to the Leap Motion {@link Controller}.
	 * 
	 * <blockquote><pre>
	 * float lifetimeOfThisHandObject = hand.timeVisible();
	 * </pre></blockquote>
	 * 
	 * @return The duration (in seconds) that this {@code Hand} has been tracked.
	 */
	public float timeVisible() {
		return LeapJNI.Hand_timeVisible(this.swigCPtr, this);
	}

	/**
	 * How confident we are with a given hand pose.<p>
	 * 
	 * The confidence level ranges between 0.0 and 1.0 inclusive.
	 * 
	 * <blockquote><pre>
	 * float confidence = hand.confidence();
	 * </pre></blockquote>
	 * 
	 * @return confidence level between 0.0 and 1.0 inclusive.
	 */
	public float confidence() {
		return LeapJNI.Hand_confidence(this.swigCPtr, this);
	}

	/**
	 * Identifies whether this {@code Hand} is a left hand.
	 * 
	 * <blockquote><pre>
	 * String handName = hand.isLeft() ? "Left hand" : "Right hand";
	 * </pre></blockquote>
	 * 
	 * @return True if the hand is identified as a left hand.
	 */
	public boolean isLeft() {
		return LeapJNI.Hand_isLeft(this.swigCPtr, this);
	}

	/**
	 * Identifies whether this {@code Hand} is a right hand.
	 * 
	 * <blockquote><pre>
	 * if(hand.isRight()) {
	 *     // .. Do right handed stuff
	 * }
	 * </pre></blockquote>
	 * 
	 * @return True if the hand is identified as a right hand.
	 */
	public boolean isRight() {
		return LeapJNI.Hand_isRight(this.swigCPtr, this);
	}

	/**
	 * Reports whether this is a valid {@code Hand} object.
	 * 
	 * <blockquote><pre>
	 * if (hand.isValid()) {
	 *     //Process hand data...
	 * }
	 * </pre></blockquote>
	 * 
	 * @return True, if this {@code Hand} object contains valid tracking data.
	 */
	public boolean isValid() {
		return LeapJNI.Hand_isValid(this.swigCPtr, this);
	}

	/**
	 * Returns an invalid {@code Hand} object.
	 * 
	 * <blockquote><pre>
	 * if (!hand.equals(Hand.invalid())) {
	 *     //Process hand data...
	 * }
	 * </pre></blockquote>
	 * 
	 * You can use the instance returned by this function in comparisons testing 
	 * whether a given {@code Hand} instance is valid or invalid. (You can also use the {@link Hand#isValid()} function.)
	 * 
	 * @return The invalid {@code Hand} instance.
	 */
	public static Hand invalid() {
		return new Hand(LeapJNI.Hand_invalid(), false);
	}

	/**
	 * Compare {@code Hand} object equality.
	 * 
	 * <blockquote><pre>
	 * Boolean handIsEqual = thisHand.equals(thatHand);
	 * </pre></blockquote>
	 * 
	 * Two {@code Hand} objects are equal if and only if both {@code Hand} objects 
	 * represent the exact same physical hand in the same frame and both {@code Hand} objects are valid.
	 * 
	 * @param hand - {@code Hand} object to compare
	 * 
	 * @return true if the {@code Hand} objects are equal.
	 */
	public boolean equals(Hand hand) {
		return LeapJNI.Hand_equals(this.swigCPtr, this, getCPtr(hand), hand);
	}

	/**
	 * A string containing a brief, human readable description of the {@code Hand} object.
	 * 
	 * @return A description of the {@code Hand} as a string.
	 */
	public String toString() {
		return LeapJNI.Hand_toString(this.swigCPtr, this);
	}
	
	public static long getCPtr(Hand paramHand) {
		return paramHand == null ? 0L : paramHand.swigCPtr;
	}

	protected void finalize() {
		delete();
	}

	public synchronized void delete() {
		if (this.swigCPtr != 0L) {
			if (this.swigCMemOwn) {
				this.swigCMemOwn = false;
				LeapJNI.delete_Hand(this.swigCPtr);
			}
			this.swigCPtr = 0L;
		}
		super.delete();
	}
}
