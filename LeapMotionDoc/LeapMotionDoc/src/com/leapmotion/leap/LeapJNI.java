package com.leapmotion.leap;

import java.io.PrintStream;

public class LeapJNI {

	public static final native float EPSILON_get();

	public static final native long new_Vector__SWIG_0();

	public static final native long new_Vector__SWIG_1(float paramFloat1, float paramFloat2, float paramFloat3);

	public static final native long new_Vector__SWIG_2(long paramLong, Vector paramVector);

	public static final native long Vector_zero();

	public static final native long Vector_xAxis();

	public static final native long Vector_yAxis();

	public static final native long Vector_zAxis();

	public static final native long Vector_left();

	public static final native long Vector_right();

	public static final native long Vector_down();

	public static final native long Vector_up();

	public static final native long Vector_forward();

	public static final native long Vector_backward();

	public static final native float Vector_magnitude(long paramLong, Vector paramVector);

	public static final native float Vector_magnitudeSquared(long paramLong, Vector paramVector);

	public static final native float Vector_distanceTo(long paramLong1, Vector paramVector1, long paramLong2, Vector paramVector2);

	public static final native float Vector_angleTo(long paramLong1, Vector paramVector1, long paramLong2, Vector paramVector2);

	public static final native float Vector_pitch(long paramLong, Vector paramVector);

	public static final native float Vector_yaw(long paramLong, Vector paramVector);
	public static final native float Vector_roll(long paramLong, Vector paramVector);
	public static final native float Vector_dot(long paramLong1, Vector paramVector1, long paramLong2, Vector paramVector2);
	public static final native long Vector_cross(long paramLong1, Vector paramVector1, long paramLong2, Vector paramVector2);
	public static final native long Vector_normalized(long paramLong, Vector paramVector);
	public static final native long Vector_opposite(long paramLong, Vector paramVector);
	public static final native long Vector_plus(long paramLong1, Vector paramVector1, long paramLong2, Vector paramVector2);
	public static final native long Vector_minus(long paramLong1, Vector paramVector1, long paramLong2, Vector paramVector2);
	public static final native long Vector_times(long paramLong, Vector paramVector, float paramFloat);
	public static final native long Vector_divide(long paramLong, Vector paramVector, float paramFloat);
	public static final native String Vector_toString(long paramLong, Vector paramVector);
	public static final native boolean Vector_equals(long paramLong1, Vector paramVector1, long paramLong2, Vector paramVector2);
	public static final native boolean Vector_isValid(long paramLong, Vector paramVector);
	public static final native float Vector_get(long paramLong1, Vector paramVector, long paramLong2);
	public static final native void Vector_x_set(long paramLong, Vector paramVector, float paramFloat);
	public static final native float Vector_x_get(long paramLong, Vector paramVector);
	public static final native void Vector_y_set(long paramLong, Vector paramVector, float paramFloat);
	public static final native float Vector_y_get(long paramLong, Vector paramVector);
	public static final native void Vector_z_set(long paramLong, Vector paramVector, float paramFloat);
	public static final native float Vector_z_get(long paramLong, Vector paramVector);
	public static final native void delete_Vector(long paramLong);
	public static final native long new_Matrix__SWIG_0();
	public static final native long new_Matrix__SWIG_1(long paramLong, Matrix paramMatrix);
	public static final native long new_Matrix__SWIG_2(long paramLong1, Vector paramVector1, long paramLong2, Vector paramVector2, long paramLong3, Vector paramVector3);
	public static final native long new_Matrix__SWIG_3(long paramLong1, Vector paramVector1, long paramLong2, Vector paramVector2, long paramLong3, Vector paramVector3, long paramLong4, Vector paramVector4);
	public static final native long new_Matrix__SWIG_4(long paramLong, Vector paramVector, float paramFloat);
	public static final native long new_Matrix__SWIG_5(long paramLong1, Vector paramVector1, float paramFloat, long paramLong2, Vector paramVector2);
	public static final native long Matrix_identity();
	public static final native void Matrix_setRotation(long paramLong1, Matrix paramMatrix, long paramLong2, Vector paramVector, float paramFloat);
	public static final native long Matrix_transformPoint(long paramLong1, Matrix paramMatrix, long paramLong2, Vector paramVector);
	public static final native long Matrix_transformDirection(long paramLong1, Matrix paramMatrix, long paramLong2, Vector paramVector);
	public static final native long Matrix_rigidInverse(long paramLong, Matrix paramMatrix);
	public static final native long Matrix_times(long paramLong1, Matrix paramMatrix1, long paramLong2, Matrix paramMatrix2);
	public static final native boolean Matrix_equals(long paramLong1, Matrix paramMatrix1, long paramLong2, Matrix paramMatrix2);
	public static final native String Matrix_toString(long paramLong, Matrix paramMatrix);
	public static final native void Matrix_xBasis_set(long paramLong1, Matrix paramMatrix, long paramLong2, Vector paramVector);
	public static final native long Matrix_xBasis_get(long paramLong, Matrix paramMatrix);
	public static final native void Matrix_yBasis_set(long paramLong1, Matrix paramMatrix, long paramLong2, Vector paramVector);
	public static final native long Matrix_yBasis_get(long paramLong, Matrix paramMatrix);
	public static final native void Matrix_zBasis_set(long paramLong1, Matrix paramMatrix, long paramLong2, Vector paramVector);
	public static final native long Matrix_zBasis_get(long paramLong, Matrix paramMatrix);
	public static final native void Matrix_origin_set(long paramLong1, Matrix paramMatrix, long paramLong2, Vector paramVector);
	public static final native long Matrix_origin_get(long paramLong, Matrix paramMatrix);
	public static final native void delete_Matrix(long paramLong);
	public static final native void delete_Interface_Implementation(long paramLong);
	public static final native long new_Interface_Implementation();
	public static final native long new_Pointable();
	public static final native int Pointable_id(long paramLong, Pointable paramPointable);
	public static final native long Pointable_frame(long paramLong, Pointable paramPointable);
	public static final native long Pointable_hand(long paramLong, Pointable paramPointable);
	public static final native long Pointable_tipPosition(long paramLong, Pointable paramPointable);
	public static final native long Pointable_tipVelocity(long paramLong, Pointable paramPointable);
	public static final native long Pointable_direction(long paramLong, Pointable paramPointable);
	public static final native float Pointable_width(long paramLong, Pointable paramPointable);
	public static final native float Pointable_length(long paramLong, Pointable paramPointable);
	public static final native boolean Pointable_isFinger(long paramLong, Pointable paramPointable);
	public static final native boolean Pointable_isTool(long paramLong, Pointable paramPointable);
	public static final native boolean Pointable_isExtended(long paramLong, Pointable paramPointable);
	public static final native boolean Pointable_isValid(long paramLong, Pointable paramPointable);
	public static final native int Pointable_touchZone(long paramLong, Pointable paramPointable);
	public static final native float Pointable_touchDistance(long paramLong, Pointable paramPointable);
	public static final native long Pointable_stabilizedTipPosition(long paramLong, Pointable paramPointable);
	public static final native float Pointable_timeVisible(long paramLong, Pointable paramPointable);
	public static final native long Pointable_invalid();
	public static final native boolean Pointable_equals(long paramLong1, Pointable paramPointable1, long paramLong2, Pointable paramPointable2);
	public static final native String Pointable_toString(long paramLong, Pointable paramPointable);
	public static final native void delete_Pointable(long paramLong);
	public static final native long new_Arm();
	public static final native float Arm_width(long paramLong, Arm paramArm);
	public static final native long Arm_direction(long paramLong, Arm paramArm);
	public static final native long Arm_basis(long paramLong, Arm paramArm);
	public static final native long Arm_elbowPosition(long paramLong, Arm paramArm);
	public static final native long Arm_wristPosition(long paramLong, Arm paramArm);
	public static final native long Arm_center(long paramLong, Arm paramArm);
	public static final native boolean Arm_isValid(long paramLong, Arm paramArm);
	public static final native long Arm_invalid();
	public static final native boolean Arm_equals(long paramLong1, Arm paramArm1, long paramLong2, Arm paramArm2);
	public static final native String Arm_toString(long paramLong, Arm paramArm);
	public static final native void delete_Arm(long paramLong);
	public static final native long new_Bone();
	public static final native long Bone_prevJoint(long paramLong, Bone paramBone);
	public static final native long Bone_nextJoint(long paramLong, Bone paramBone);
	public static final native long Bone_center(long paramLong, Bone paramBone);
	public static final native long Bone_direction(long paramLong, Bone paramBone);
	public static final native float Bone_length(long paramLong, Bone paramBone);
	public static final native float Bone_width(long paramLong, Bone paramBone);
	public static final native int Bone_type(long paramLong, Bone paramBone);
	public static final native long Bone_basis(long paramLong, Bone paramBone);
	public static final native boolean Bone_isValid(long paramLong, Bone paramBone);
	public static final native long Bone_invalid();
	public static final native boolean Bone_equals(long paramLong1, Bone paramBone1, long paramLong2, Bone paramBone2);
	public static final native String Bone_toString(long paramLong, Bone paramBone);
	public static final native void delete_Bone(long paramLong);
	public static final native long new_Finger__SWIG_0();
	public static final native long new_Finger__SWIG_1(long paramLong, Pointable paramPointable);
	public static final native long Finger_jointPosition(long paramLong, Finger paramFinger, int paramInt);
	public static final native long Finger_bone(long paramLong, Finger paramFinger, int paramInt);
	public static final native int Finger_type(long paramLong, Finger paramFinger);
	public static final native long Finger_invalid();
	public static final native String Finger_toString(long paramLong, Finger paramFinger);
	public static final native void delete_Finger(long paramLong);
	public static final native long new_Tool__SWIG_0();
	public static final native long new_Tool__SWIG_1(long paramLong, Pointable paramPointable);
	public static final native long Tool_invalid();
	public static final native String Tool_toString(long paramLong, Tool paramTool);
	public static final native void delete_Tool(long paramLong);
	public static final native long new_Hand();
	public static final native int Hand_id(long paramLong, Hand paramHand);
	public static final native long Hand_frame(long paramLong, Hand paramHand);
	public static final native long Hand_pointables(long paramLong, Hand paramHand);
	public static final native long Hand_pointable(long paramLong, Hand paramHand, int paramInt);
	public static final native long Hand_fingers(long paramLong, Hand paramHand);
	public static final native long Hand_finger(long paramLong, Hand paramHand, int paramInt);
	public static final native long Hand_tools(long paramLong, Hand paramHand);
	public static final native long Hand_tool(long paramLong, Hand paramHand, int paramInt);
	public static final native long Hand_palmPosition(long paramLong, Hand paramHand);
	public static final native long Hand_stabilizedPalmPosition(long paramLong, Hand paramHand);
	public static final native long Hand_palmVelocity(long paramLong, Hand paramHand);
	public static final native long Hand_palmNormal(long paramLong, Hand paramHand);
	public static final native float Hand_palmWidth(long paramLong, Hand paramHand);
	public static final native long Hand_direction(long paramLong, Hand paramHand);
	public static final native long Hand_basis(long paramLong, Hand paramHand);
	public static final native long Hand_arm(long paramLong, Hand paramHand);
	public static final native long Hand_wristPosition(long paramLong, Hand paramHand);
	public static final native long Hand_sphereCenter(long paramLong, Hand paramHand);
	public static final native float Hand_sphereRadius(long paramLong, Hand paramHand);
	public static final native float Hand_pinchStrength(long paramLong, Hand paramHand);
	public static final native float Hand_grabStrength(long paramLong, Hand paramHand);
	public static final native long Hand_translation(long paramLong1, Hand paramHand, long paramLong2, Frame paramFrame);
	public static final native float Hand_translationProbability(long paramLong1, Hand paramHand, long paramLong2, Frame paramFrame);
	public static final native long Hand_rotationAxis(long paramLong1, Hand paramHand, long paramLong2, Frame paramFrame);
	public static final native float Hand_rotationAngle__SWIG_0(long paramLong1, Hand paramHand, long paramLong2, Frame paramFrame);
	public static final native float Hand_rotationAngle__SWIG_1(long paramLong1, Hand paramHand, long paramLong2, Frame paramFrame, long paramLong3, Vector paramVector);
	public static final native long Hand_rotationMatrix(long paramLong1, Hand paramHand, long paramLong2, Frame paramFrame);
	public static final native float Hand_rotationProbability(long paramLong1, Hand paramHand, long paramLong2, Frame paramFrame);
	public static final native float Hand_scaleFactor(long paramLong1, Hand paramHand, long paramLong2, Frame paramFrame);
	public static final native float Hand_scaleProbability(long paramLong1, Hand paramHand, long paramLong2, Frame paramFrame);
	public static final native float Hand_timeVisible(long paramLong, Hand paramHand);
	public static final native float Hand_confidence(long paramLong, Hand paramHand);
	public static final native boolean Hand_isLeft(long paramLong, Hand paramHand);
	public static final native boolean Hand_isRight(long paramLong, Hand paramHand);
	public static final native boolean Hand_isValid(long paramLong, Hand paramHand);
	public static final native long Hand_invalid();
	public static final native boolean Hand_equals(long paramLong1, Hand paramHand1, long paramLong2, Hand paramHand2);
	public static final native String Hand_toString(long paramLong, Hand paramHand);
	public static final native void delete_Hand(long paramLong);
	public static final native long new_Gesture__SWIG_0();
	public static final native long new_Gesture__SWIG_1(long paramLong, Gesture paramGesture);
	public static final native int Gesture_type(long paramLong, Gesture paramGesture);
	public static final native int Gesture_state(long paramLong, Gesture paramGesture);
	public static final native int Gesture_id(long paramLong, Gesture paramGesture);
	public static final native long Gesture_duration(long paramLong, Gesture paramGesture);
	public static final native float Gesture_durationSeconds(long paramLong, Gesture paramGesture);
	public static final native long Gesture_frame(long paramLong, Gesture paramGesture);
	public static final native long Gesture_hands(long paramLong, Gesture paramGesture);
	public static final native long Gesture_pointables(long paramLong, Gesture paramGesture);
	public static final native boolean Gesture_isValid(long paramLong, Gesture paramGesture);
	public static final native boolean Gesture_equals(long paramLong1, Gesture paramGesture1, long paramLong2, Gesture paramGesture2);
	public static final native String Gesture_toString(long paramLong, Gesture paramGesture);
	public static final native long Gesture_invalid();
	public static final native void delete_Gesture(long paramLong);
	public static final native int SwipeGesture_classType();
	public static final native long new_SwipeGesture__SWIG_0();
	public static final native long new_SwipeGesture__SWIG_1(long paramLong, Gesture paramGesture);
	public static final native long SwipeGesture_startPosition(long paramLong, SwipeGesture paramSwipeGesture);
	public static final native long SwipeGesture_position(long paramLong, SwipeGesture paramSwipeGesture);
	public static final native long SwipeGesture_direction(long paramLong, SwipeGesture paramSwipeGesture);
	public static final native float SwipeGesture_speed(long paramLong, SwipeGesture paramSwipeGesture);
	public static final native long SwipeGesture_pointable(long paramLong, SwipeGesture paramSwipeGesture);
	public static final native void delete_SwipeGesture(long paramLong);
	public static final native int CircleGesture_classType();
	public static final native long new_CircleGesture__SWIG_0();
	public static final native long new_CircleGesture__SWIG_1(long paramLong, Gesture paramGesture);
	public static final native long CircleGesture_center(long paramLong, CircleGesture paramCircleGesture);
	public static final native long CircleGesture_normal(long paramLong, CircleGesture paramCircleGesture);
	public static final native float CircleGesture_progress(long paramLong, CircleGesture paramCircleGesture);
	public static final native float CircleGesture_radius(long paramLong, CircleGesture paramCircleGesture);
	public static final native long CircleGesture_pointable(long paramLong, CircleGesture paramCircleGesture);
	public static final native void delete_CircleGesture(long paramLong);
	public static final native int ScreenTapGesture_classType();
	public static final native long new_ScreenTapGesture__SWIG_0();
	public static final native long new_ScreenTapGesture__SWIG_1(long paramLong, Gesture paramGesture);
	public static final native long ScreenTapGesture_position(long paramLong, ScreenTapGesture paramScreenTapGesture);
	public static final native long ScreenTapGesture_direction(long paramLong, ScreenTapGesture paramScreenTapGesture);
	public static final native float ScreenTapGesture_progress(long paramLong, ScreenTapGesture paramScreenTapGesture);
	public static final native long ScreenTapGesture_pointable(long paramLong, ScreenTapGesture paramScreenTapGesture);
	public static final native void delete_ScreenTapGesture(long paramLong);
	public static final native int KeyTapGesture_classType();
	public static final native long new_KeyTapGesture__SWIG_0();
	public static final native long new_KeyTapGesture__SWIG_1(long paramLong, Gesture paramGesture);
	public static final native long KeyTapGesture_position(long paramLong, KeyTapGesture paramKeyTapGesture);
	public static final native long KeyTapGesture_direction(long paramLong, KeyTapGesture paramKeyTapGesture);
	public static final native float KeyTapGesture_progress(long paramLong, KeyTapGesture paramKeyTapGesture);
	public static final native long KeyTapGesture_pointable(long paramLong, KeyTapGesture paramKeyTapGesture);
	public static final native void delete_KeyTapGesture(long paramLong);
	public static final native long new_Screen();
	public static final native int Screen_id(long paramLong, Screen paramScreen);
	public static final native long Screen_intersect__SWIG_0(long paramLong1, Screen paramScreen, long paramLong2, Pointable paramPointable, boolean paramBoolean, float paramFloat);
	public static final native long Screen_intersect__SWIG_1(long paramLong1, Screen paramScreen, long paramLong2, Pointable paramPointable, boolean paramBoolean);
	public static final native long Screen_intersect__SWIG_2(long paramLong1, Screen paramScreen, long paramLong2, Vector paramVector1, long paramLong3, Vector paramVector2, boolean paramBoolean, float paramFloat);
	public static final native long Screen_intersect__SWIG_3(long paramLong1, Screen paramScreen, long paramLong2, Vector paramVector1, long paramLong3, Vector paramVector2, boolean paramBoolean);
	public static final native long Screen_project__SWIG_0(long paramLong1, Screen paramScreen, long paramLong2, Vector paramVector, boolean paramBoolean, float paramFloat);
	public static final native long Screen_project__SWIG_1(long paramLong1, Screen paramScreen, long paramLong2, Vector paramVector, boolean paramBoolean);
	public static final native long Screen_horizontalAxis(long paramLong, Screen paramScreen);
	public static final native long Screen_verticalAxis(long paramLong, Screen paramScreen);
	public static final native long Screen_bottomLeftCorner(long paramLong, Screen paramScreen);
	public static final native long Screen_normal(long paramLong, Screen paramScreen);
	public static final native int Screen_widthPixels(long paramLong, Screen paramScreen);
	public static final native int Screen_heightPixels(long paramLong, Screen paramScreen);
	public static final native float Screen_distanceToPoint(long paramLong1, Screen paramScreen, long paramLong2, Vector paramVector);
	public static final native boolean Screen_isValid(long paramLong, Screen paramScreen);
	public static final native long Screen_invalid();
	public static final native boolean Screen_equals(long paramLong1, Screen paramScreen1, long paramLong2, Screen paramScreen2);
	public static final native String Screen_toString(long paramLong, Screen paramScreen);
	public static final native void delete_Screen(long paramLong);
	public static final native long new_Device();
	public static final native float Device_horizontalViewAngle(long paramLong, Device paramDevice);
	public static final native float Device_verticalViewAngle(long paramLong, Device paramDevice);
	public static final native float Device_range(long paramLong, Device paramDevice);
	public static final native float Device_baseline(long paramLong, Device paramDevice);
	public static final native float Device_distanceToBoundary(long paramLong1, Device paramDevice, long paramLong2, Vector paramVector);
	public static final native boolean Device_isEmbedded(long paramLong, Device paramDevice);
	public static final native boolean Device_isStreaming(long paramLong, Device paramDevice);
	public static final native boolean Device_isFlipped(long paramLong, Device paramDevice);
	public static final native int Device_type(long paramLong, Device paramDevice);
	public static final native String Device_serialNumber(long paramLong, Device paramDevice);
	public static final native long Device_position(long paramLong, Device paramDevice);
	public static final native long Device_orientation(long paramLong, Device paramDevice);
	public static final native boolean Device_isValid(long paramLong, Device paramDevice);
	public static final native long Device_invalid();
	public static final native boolean Device_equals(long paramLong1, Device paramDevice1, long paramLong2, Device paramDevice2);
	public static final native String Device_toString(long paramLong, Device paramDevice);
	public static final native void delete_Device(long paramLong);
	public static final native long new_Image();
	public static final native long Image_sequenceId(long paramLong, Image paramImage);
	public static final native int Image_id(long paramLong, Image paramImage);
	public static final native void Image_data(long paramLong, Image paramImage, byte[] paramArrayOfByte);
	public static final native void Image_distortion(long paramLong, Image paramImage, float[] paramArrayOfFloat);
	public static final native int Image_width(long paramLong, Image paramImage);
	public static final native int Image_height(long paramLong, Image paramImage);
	public static final native int Image_bytesPerPixel(long paramLong, Image paramImage);
	public static final native int Image_format(long paramLong, Image paramImage);
	public static final native int Image_distortionWidth(long paramLong, Image paramImage);
	public static final native int Image_distortionHeight(long paramLong, Image paramImage);
	public static final native float Image_rayOffsetX(long paramLong, Image paramImage);
	public static final native float Image_rayOffsetY(long paramLong, Image paramImage);
	public static final native float Image_rayScaleX(long paramLong, Image paramImage);
	public static final native float Image_rayScaleY(long paramLong, Image paramImage);
	public static final native long Image_rectify(long paramLong1, Image paramImage, long paramLong2, Vector paramVector);
	public static final native long Image_warp(long paramLong1, Image paramImage, long paramLong2, Vector paramVector);
	public static final native boolean Image_isValid(long paramLong, Image paramImage);
	public static final native long Image_invalid();
	public static final native boolean Image_equals(long paramLong1, Image paramImage1, long paramLong2, Image paramImage2);
	public static final native String Image_toString(long paramLong, Image paramImage);
	public static final native void delete_Image(long paramLong);
	public static final native long new_Mask();
	public static final native long Mask_sequenceId(long paramLong, Mask paramMask);
	public static final native int Mask_id(long paramLong, Mask paramMask);
	public static final native void Mask_data(long paramLong, Mask paramMask, byte[] paramArrayOfByte);
	public static final native int Mask_width(long paramLong, Mask paramMask);
	public static final native int Mask_height(long paramLong, Mask paramMask);
	public static final native int Mask_offsetX(long paramLong, Mask paramMask);
	public static final native int Mask_offsetY(long paramLong, Mask paramMask);
	public static final native boolean Mask_isValid(long paramLong, Mask paramMask);
	public static final native long Mask_invalid();
	public static final native boolean Mask_equals(long paramLong1, Mask paramMask1, long paramLong2, Mask paramMask2);
	public static final native String Mask_toString(long paramLong, Mask paramMask);
	public static final native void delete_Mask(long paramLong);
	public static final native long new_PointableList();
	public static final native int PointableList_count(long paramLong, PointableList paramPointableList);
	public static final native boolean PointableList_isEmpty(long paramLong, PointableList paramPointableList);
	public static final native long PointableList_get(long paramLong, PointableList paramPointableList, int paramInt);
	public static final native long PointableList_append__SWIG_0(long paramLong1, PointableList paramPointableList1, long paramLong2, PointableList paramPointableList2);
	public static final native long PointableList_append__SWIG_1(long paramLong1, PointableList paramPointableList, long paramLong2, FingerList paramFingerList);
	public static final native long PointableList_append__SWIG_2(long paramLong1, PointableList paramPointableList, long paramLong2, ToolList paramToolList);
	public static final native long PointableList_leftmost(long paramLong, PointableList paramPointableList);
	public static final native long PointableList_rightmost(long paramLong, PointableList paramPointableList);
	public static final native long PointableList_frontmost(long paramLong, PointableList paramPointableList);
	public static final native long PointableList_extended(long paramLong, PointableList paramPointableList);
	public static final native void delete_PointableList(long paramLong);
	public static final native long new_FingerList();
	public static final native int FingerList_count(long paramLong, FingerList paramFingerList);
	public static final native boolean FingerList_isEmpty(long paramLong, FingerList paramFingerList);
	public static final native long FingerList_get(long paramLong, FingerList paramFingerList, int paramInt);
	public static final native long FingerList_append(long paramLong1, FingerList paramFingerList1, long paramLong2, FingerList paramFingerList2);
	public static final native long FingerList_leftmost(long paramLong, FingerList paramFingerList);
	public static final native long FingerList_rightmost(long paramLong, FingerList paramFingerList);
	public static final native long FingerList_frontmost(long paramLong, FingerList paramFingerList);
	public static final native long FingerList_extended(long paramLong, FingerList paramFingerList);
	public static final native long FingerList_fingerType(long paramLong, FingerList paramFingerList, int paramInt);
	public static final native void delete_FingerList(long paramLong);
	public static final native long new_ToolList();
	public static final native int ToolList_count(long paramLong, ToolList paramToolList);
	public static final native boolean ToolList_isEmpty(long paramLong, ToolList paramToolList);
	public static final native long ToolList_get(long paramLong, ToolList paramToolList, int paramInt);
	public static final native long ToolList_append(long paramLong1, ToolList paramToolList1, long paramLong2, ToolList paramToolList2);
	public static final native long ToolList_leftmost(long paramLong, ToolList paramToolList);
	public static final native long ToolList_rightmost(long paramLong, ToolList paramToolList);
	public static final native long ToolList_frontmost(long paramLong, ToolList paramToolList);
	public static final native void delete_ToolList(long paramLong);
	public static final native long new_HandList();
	public static final native int HandList_count(long paramLong, HandList paramHandList);
	public static final native boolean HandList_isEmpty(long paramLong, HandList paramHandList);
	public static final native long HandList_get(long paramLong, HandList paramHandList, int paramInt);
	public static final native long HandList_append(long paramLong1, HandList paramHandList1, long paramLong2, HandList paramHandList2);
	public static final native long HandList_leftmost(long paramLong, HandList paramHandList);
	public static final native long HandList_rightmost(long paramLong, HandList paramHandList);
	public static final native long HandList_frontmost(long paramLong, HandList paramHandList);
	public static final native void delete_HandList(long paramLong);
	public static final native long new_GestureList();
	public static final native int GestureList_count(long paramLong, GestureList paramGestureList);
	public static final native boolean GestureList_isEmpty(long paramLong, GestureList paramGestureList);
	public static final native long GestureList_get(long paramLong, GestureList paramGestureList, int paramInt);
	public static final native long GestureList_append(long paramLong1, GestureList paramGestureList1, long paramLong2, GestureList paramGestureList2);
	public static final native void delete_GestureList(long paramLong);
	public static final native long new_ScreenList();
	public static final native int ScreenList_count(long paramLong, ScreenList paramScreenList);
	public static final native boolean ScreenList_isEmpty(long paramLong, ScreenList paramScreenList);
	public static final native long ScreenList_get(long paramLong, ScreenList paramScreenList, int paramInt);
	public static final native long ScreenList_closestScreenHit__SWIG_0(long paramLong1, ScreenList paramScreenList, long paramLong2, Pointable paramPointable);
	public static final native long ScreenList_closestScreenHit__SWIG_1(long paramLong1, ScreenList paramScreenList, long paramLong2, Vector paramVector1, long paramLong3, Vector paramVector2);
	public static final native long ScreenList_closestScreen(long paramLong1, ScreenList paramScreenList, long paramLong2, Vector paramVector);
	public static final native void delete_ScreenList(long paramLong);
	public static final native long new_DeviceList();
	public static final native int DeviceList_count(long paramLong, DeviceList paramDeviceList);
	public static final native boolean DeviceList_isEmpty(long paramLong, DeviceList paramDeviceList);
	public static final native long DeviceList_get(long paramLong, DeviceList paramDeviceList, int paramInt);
	public static final native long DeviceList_append(long paramLong1, DeviceList paramDeviceList1, long paramLong2, DeviceList paramDeviceList2);
	public static final native void delete_DeviceList(long paramLong);
	public static final native long new_ImageList();
	public static final native int ImageList_count(long paramLong, ImageList paramImageList);
	public static final native boolean ImageList_isEmpty(long paramLong, ImageList paramImageList);
	public static final native long ImageList_get(long paramLong, ImageList paramImageList, int paramInt);
	public static final native long ImageList_append(long paramLong1, ImageList paramImageList1, long paramLong2, ImageList paramImageList2);
	public static final native void delete_ImageList(long paramLong);
	public static final native long new_TrackedQuad();
	public static final native float TrackedQuad_width(long paramLong, TrackedQuad paramTrackedQuad);
	public static final native float TrackedQuad_height(long paramLong, TrackedQuad paramTrackedQuad);
	public static final native int TrackedQuad_resolutionX(long paramLong, TrackedQuad paramTrackedQuad);
	public static final native int TrackedQuad_resolutionY(long paramLong, TrackedQuad paramTrackedQuad);
	public static final native boolean TrackedQuad_visible(long paramLong, TrackedQuad paramTrackedQuad);
	public static final native long TrackedQuad_orientation(long paramLong, TrackedQuad paramTrackedQuad);
	public static final native long TrackedQuad_position(long paramLong, TrackedQuad paramTrackedQuad);
	public static final native long TrackedQuad_masks(long paramLong, TrackedQuad paramTrackedQuad);
	public static final native long TrackedQuad_images(long paramLong, TrackedQuad paramTrackedQuad);
	public static final native boolean TrackedQuad_isValid(long paramLong, TrackedQuad paramTrackedQuad);
	public static final native long TrackedQuad_invalid();
	public static final native boolean TrackedQuad_equals(long paramLong1, TrackedQuad paramTrackedQuad1, long paramLong2, TrackedQuad paramTrackedQuad2);
	public static final native String TrackedQuad_toString(long paramLong, TrackedQuad paramTrackedQuad);
	public static final native void delete_TrackedQuad(long paramLong);
	public static final native long new_MaskList();
	public static final native int MaskList_count(long paramLong, MaskList paramMaskList);
	public static final native boolean MaskList_isEmpty(long paramLong, MaskList paramMaskList);
	public static final native long MaskList_get(long paramLong, MaskList paramMaskList, int paramInt);
	public static final native long MaskList_append(long paramLong1, MaskList paramMaskList1, long paramLong2, MaskList paramMaskList2);
	public static final native void delete_MaskList(long paramLong);
	public static final native long new_InteractionBox();
	public static final native long InteractionBox_normalizePoint__SWIG_0(long paramLong1, InteractionBox paramInteractionBox, long paramLong2, Vector paramVector, boolean paramBoolean);
	public static final native long InteractionBox_normalizePoint__SWIG_1(long paramLong1, InteractionBox paramInteractionBox, long paramLong2, Vector paramVector);
	public static final native long InteractionBox_denormalizePoint(long paramLong1, InteractionBox paramInteractionBox, long paramLong2, Vector paramVector);
	public static final native long InteractionBox_center(long paramLong, InteractionBox paramInteractionBox);
	public static final native float InteractionBox_width(long paramLong, InteractionBox paramInteractionBox);
	public static final native float InteractionBox_height(long paramLong, InteractionBox paramInteractionBox);
	public static final native float InteractionBox_depth(long paramLong, InteractionBox paramInteractionBox);
	public static final native boolean InteractionBox_isValid(long paramLong, InteractionBox paramInteractionBox);
	public static final native long InteractionBox_invalid();
	public static final native boolean InteractionBox_equals(long paramLong1, InteractionBox paramInteractionBox1, long paramLong2, InteractionBox paramInteractionBox2);
	public static final native String InteractionBox_toString(long paramLong, InteractionBox paramInteractionBox);
	public static final native void delete_InteractionBox(long paramLong);
	public static final native long new_Frame();
	public static final native long Frame_id(long paramLong, Frame paramFrame);
	public static final native long Frame_timestamp(long paramLong, Frame paramFrame);
	public static final native long Frame_hands(long paramLong, Frame paramFrame);
	public static final native long Frame_hand(long paramLong, Frame paramFrame, int paramInt);
	public static final native long Frame_pointables(long paramLong, Frame paramFrame);
	public static final native long Frame_pointable(long paramLong, Frame paramFrame, int paramInt);
	public static final native long Frame_fingers(long paramLong, Frame paramFrame);
	public static final native long Frame_finger(long paramLong, Frame paramFrame, int paramInt);
	public static final native long Frame_tools(long paramLong, Frame paramFrame);
	public static final native long Frame_tool(long paramLong, Frame paramFrame, int paramInt);
	public static final native long Frame_gesture(long paramLong, Frame paramFrame, int paramInt);
	public static final native long Frame_gestures__SWIG_0(long paramLong, Frame paramFrame);
	public static final native long Frame_gestures__SWIG_1(long paramLong1, Frame paramFrame1, long paramLong2, Frame paramFrame2);
	public static final native long Frame_images(long paramLong, Frame paramFrame);
	public static final native long Frame_translation(long paramLong1, Frame paramFrame1, long paramLong2, Frame paramFrame2);
	public static final native float Frame_translationProbability(long paramLong1, Frame paramFrame1, long paramLong2, Frame paramFrame2);
	public static final native long Frame_rotationAxis(long paramLong1, Frame paramFrame1, long paramLong2, Frame paramFrame2);
	public static final native float Frame_rotationAngle__SWIG_0(long paramLong1, Frame paramFrame1, long paramLong2, Frame paramFrame2);
	public static final native float Frame_rotationAngle__SWIG_1(long paramLong1, Frame paramFrame1, long paramLong2, Frame paramFrame2, long paramLong3, Vector paramVector);
	public static final native long Frame_rotationMatrix(long paramLong1, Frame paramFrame1, long paramLong2, Frame paramFrame2);
	public static final native float Frame_rotationProbability(long paramLong1, Frame paramFrame1, long paramLong2, Frame paramFrame2);
	public static final native float Frame_scaleFactor(long paramLong1, Frame paramFrame1, long paramLong2, Frame paramFrame2);
	public static final native float Frame_scaleProbability(long paramLong1, Frame paramFrame1, long paramLong2, Frame paramFrame2);
	public static final native long Frame_interactionBox(long paramLong, Frame paramFrame);
	public static final native float Frame_currentFramesPerSecond(long paramLong, Frame paramFrame);
	public static final native boolean Frame_isValid(long paramLong, Frame paramFrame);
	public static final native long Frame_invalid();
	public static final native boolean Frame_equals(long paramLong1, Frame paramFrame1, long paramLong2, Frame paramFrame2);
	public static final native long Frame_trackedQuad(long paramLong, Frame paramFrame);
	public static final native void Frame_serialize(long paramLong, Frame paramFrame, byte[] paramArrayOfByte);
	public static final native int Frame_serializeLength(long paramLong, Frame paramFrame);
	public static final native void Frame_deserialize(long paramLong, Frame paramFrame, byte[] paramArrayOfByte, int paramInt);
	public static final native String Frame_toString(long paramLong, Frame paramFrame);
	public static final native void delete_Frame(long paramLong);
	public static final native long new_BugReport();
	public static final native boolean BugReport_beginRecording(long paramLong, BugReport paramBugReport);
	public static final native void BugReport_endRecording(long paramLong, BugReport paramBugReport);
	public static final native boolean BugReport_isActive(long paramLong, BugReport paramBugReport);
	public static final native float BugReport_progress(long paramLong, BugReport paramBugReport);
	public static final native float BugReport_duration(long paramLong, BugReport paramBugReport);
	public static final native void delete_BugReport(long paramLong);
	public static final native long new_Config();
	public static final native int Config_type(long paramLong, Config paramConfig, String paramString);
	public static final native boolean Config_getBool(long paramLong, Config paramConfig, String paramString);
	public static final native boolean Config_setBool(long paramLong, Config paramConfig, String paramString, boolean paramBoolean);
	public static final native int Config_getInt32(long paramLong, Config paramConfig, String paramString);
	public static final native boolean Config_setInt32(long paramLong, Config paramConfig, String paramString, int paramInt);
	public static final native float Config_getFloat(long paramLong, Config paramConfig, String paramString);
	public static final native boolean Config_setFloat(long paramLong, Config paramConfig, String paramString, float paramFloat);
	public static final native String Config_getString(long paramLong, Config paramConfig, String paramString);
	public static final native boolean Config_setString(long paramLong, Config paramConfig, String paramString1, String paramString2);
	public static final native boolean Config_save(long paramLong, Config paramConfig);
	public static final native void delete_Config(long paramLong);
	public static final native long new_Controller__SWIG_0();
	public static final native void delete_Controller(long paramLong);
	public static final native long new_Controller__SWIG_1(long paramLong, Listener paramListener);
	public static final native boolean Controller_isConnected(long paramLong, Controller paramController);
	public static final native boolean Controller_isServiceConnected(long paramLong, Controller paramController);
	public static final native boolean Controller_hasFocus(long paramLong, Controller paramController);
	public static final native int Controller_policyFlags(long paramLong, Controller paramController);
	public static final native void Controller_setPolicyFlags(long paramLong, Controller paramController, int paramInt);
	public static final native void Controller_setPolicy(long paramLong, Controller paramController, int paramInt);
	public static final native void Controller_clearPolicy(long paramLong, Controller paramController, int paramInt);
	public static final native boolean Controller_isPolicySet(long paramLong, Controller paramController, int paramInt);
	public static final native boolean Controller_addListener(long paramLong1, Controller paramController, long paramLong2, Listener paramListener);
	public static final native boolean Controller_removeListener(long paramLong1, Controller paramController, long paramLong2, Listener paramListener);
	public static final native long Controller_frame__SWIG_0(long paramLong, Controller paramController, int paramInt);
	public static final native long Controller_frame__SWIG_1(long paramLong, Controller paramController);
	public static final native long Controller_images(long paramLong, Controller paramController);
	public static final native long Controller_config(long paramLong, Controller paramController);
	public static final native long Controller_devices(long paramLong, Controller paramController);
	public static final native long Controller_locatedScreens(long paramLong, Controller paramController);
	public static final native long Controller_bugReport(long paramLong, Controller paramController);
	public static final native void Controller_enableGesture__SWIG_0(long paramLong, Controller paramController, int paramInt, boolean paramBoolean);
	public static final native void Controller_enableGesture__SWIG_1(long paramLong, Controller paramController, int paramInt);
	public static final native boolean Controller_isGestureEnabled(long paramLong, Controller paramController, int paramInt);
	public static final native long Controller_trackedQuad(long paramLong, Controller paramController);
	public static final native long new_Listener();
	public static final native void delete_Listener(long paramLong);
	public static final native void Listener_onInit(long paramLong1, Listener paramListener, long paramLong2, Controller paramController);
	public static final native void Listener_onInitSwigExplicitListener(long paramLong1, Listener paramListener, long paramLong2, Controller paramController);
	public static final native void Listener_onConnect(long paramLong1, Listener paramListener, long paramLong2, Controller paramController);
	public static final native void Listener_onConnectSwigExplicitListener(long paramLong1, Listener paramListener, long paramLong2, Controller paramController);
	public static final native void Listener_onDisconnect(long paramLong1, Listener paramListener, long paramLong2, Controller paramController);
	public static final native void Listener_onDisconnectSwigExplicitListener(long paramLong1, Listener paramListener, long paramLong2, Controller paramController);
	public static final native void Listener_onExit(long paramLong1, Listener paramListener, long paramLong2, Controller paramController);
	public static final native void Listener_onExitSwigExplicitListener(long paramLong1, Listener paramListener, long paramLong2, Controller paramController);
	public static final native void Listener_onFrame(long paramLong1, Listener paramListener, long paramLong2, Controller paramController);
	public static final native void Listener_onFrameSwigExplicitListener(long paramLong1, Listener paramListener, long paramLong2, Controller paramController);
	public static final native void Listener_onFocusGained(long paramLong1, Listener paramListener, long paramLong2, Controller paramController);
	public static final native void Listener_onFocusGainedSwigExplicitListener(long paramLong1, Listener paramListener, long paramLong2, Controller paramController);
	public static final native void Listener_onFocusLost(long paramLong1, Listener paramListener, long paramLong2, Controller paramController);
	public static final native void Listener_onFocusLostSwigExplicitListener(long paramLong1, Listener paramListener, long paramLong2, Controller paramController);
	public static final native void Listener_onServiceConnect(long paramLong1, Listener paramListener, long paramLong2, Controller paramController);
	public static final native void Listener_onServiceConnectSwigExplicitListener(long paramLong1, Listener paramListener, long paramLong2, Controller paramController);
	public static final native void Listener_onServiceDisconnect(long paramLong1, Listener paramListener, long paramLong2, Controller paramController);
	public static final native void Listener_onServiceDisconnectSwigExplicitListener(long paramLong1, Listener paramListener, long paramLong2, Controller paramController);
	public static final native void Listener_onDeviceChange(long paramLong1, Listener paramListener, long paramLong2, Controller paramController);
	public static final native void Listener_onDeviceChangeSwigExplicitListener(long paramLong1, Listener paramListener, long paramLong2, Controller paramController);
	public static final native void Listener_onImages(long paramLong1, Listener paramListener, long paramLong2, Controller paramController);
	public static final native void Listener_onImagesSwigExplicitListener(long paramLong1, Listener paramListener, long paramLong2, Controller paramController);
	public static final native void Listener_director_connect(Listener paramListener, long paramLong, boolean paramBoolean1, boolean paramBoolean2);
	public static final native void Listener_change_ownership(Listener paramListener, long paramLong, boolean paramBoolean);
	public static final native long Pointable_SWIGUpcast(long paramLong);
	public static final native long Arm_SWIGUpcast(long paramLong);
	public static final native long Bone_SWIGUpcast(long paramLong);
	public static final native long Finger_SWIGUpcast(long paramLong);
	public static final native long Tool_SWIGUpcast(long paramLong);
	public static final native long Hand_SWIGUpcast(long paramLong);
	public static final native long Gesture_SWIGUpcast(long paramLong);
	public static final native long SwipeGesture_SWIGUpcast(long paramLong);
	public static final native long CircleGesture_SWIGUpcast(long paramLong);
	public static final native long ScreenTapGesture_SWIGUpcast(long paramLong);
	public static final native long KeyTapGesture_SWIGUpcast(long paramLong);
	public static final native long Screen_SWIGUpcast(long paramLong);
	public static final native long Device_SWIGUpcast(long paramLong);
	public static final native long Image_SWIGUpcast(long paramLong);
	public static final native long Mask_SWIGUpcast(long paramLong);
	public static final native long PointableList_SWIGUpcast(long paramLong);
	public static final native long FingerList_SWIGUpcast(long paramLong);
	public static final native long ToolList_SWIGUpcast(long paramLong);
	public static final native long HandList_SWIGUpcast(long paramLong);
	public static final native long GestureList_SWIGUpcast(long paramLong);
	public static final native long ScreenList_SWIGUpcast(long paramLong);
	public static final native long DeviceList_SWIGUpcast(long paramLong);
	public static final native long ImageList_SWIGUpcast(long paramLong);
	public static final native long TrackedQuad_SWIGUpcast(long paramLong);
	public static final native long MaskList_SWIGUpcast(long paramLong);
	public static final native long InteractionBox_SWIGUpcast(long paramLong);
	public static final native long Frame_SWIGUpcast(long paramLong);
	public static final native long BugReport_SWIGUpcast(long paramLong);
	public static final native long Config_SWIGUpcast(long paramLong);
	public static final native long Controller_SWIGUpcast(long paramLong);
	
	public static void SwigDirector_Listener_onInit(Listener paramListener, long paramLong) {
		paramListener.onInit(new Controller(paramLong, false)); 
	}

	public static void SwigDirector_Listener_onConnect(Listener paramListener, long paramLong) {
		paramListener.onConnect(new Controller(paramLong, false));
	}

	public static void SwigDirector_Listener_onDisconnect(Listener paramListener, long paramLong) { 
		paramListener.onDisconnect(new Controller(paramLong, false)); 
	}

	public static void SwigDirector_Listener_onExit(Listener paramListener, long paramLong) {
		paramListener.onExit(new Controller(paramLong, false));
	}

	public static void SwigDirector_Listener_onFrame(Listener paramListener, long paramLong) { 
		paramListener.onFrame(new Controller(paramLong, false)); 
	}

	public static void SwigDirector_Listener_onFocusGained(Listener paramListener, long paramLong) {
		paramListener.onFocusGained(new Controller(paramLong, false));
	}

	public static void SwigDirector_Listener_onFocusLost(Listener paramListener, long paramLong) { 
		paramListener.onFocusLost(new Controller(paramLong, false)); 
	}

	public static void SwigDirector_Listener_onServiceConnect(Listener paramListener, long paramLong) {
		paramListener.onServiceConnect(new Controller(paramLong, false));
	}

	public static void SwigDirector_Listener_onServiceDisconnect(Listener paramListener, long paramLong) {
		paramListener.onServiceDisconnect(new Controller(paramLong, false)); 
	}

	public static void SwigDirector_Listener_onDeviceChange(Listener paramListener, long paramLong) {
		paramListener.onDeviceChange(new Controller(paramLong, false));
	}

	public static void SwigDirector_Listener_onImages(Listener paramListener, long paramLong) {
		paramListener.onImages(new Controller(paramLong, false)); 
	}

	private static final native void swig_module_init();

	static
	{
		try
		{
			System.loadLibrary("LeapJava");
		} catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {
			System.err.println("Native code library failed to load. \n" + localUnsatisfiedLinkError);
			System.exit(1);
		}

		swig_module_init();
	}
}
