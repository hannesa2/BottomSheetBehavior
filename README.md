[![](https://jitpack.io/v/hannesa2/BottomSheetBehavior.svg)](https://jitpack.io/#hannesa2/BottomSheetBehavior)

# BottomSheetBehavior like Google Maps for Android

Android Studio Project using Support Library focused on get Google Maps 3 states behavior including background image parallax and toolbars animations.

## Installation
In you main `build.gradle`

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
   
In your `module/build.gradle` file add<br>
```
dependencies {
   implementation 'com.github.hannesa2:BottomSheetBehavior:$latestVersion'
}
```

## Usage
[![CustomBottomSheetBehavior](https://raw.githubusercontent.com/akan44/CustomBottomSheetBehavior/master/CustomBottomSheetBehaviorLikeGoogleMaps3states.gif)]<br><br>


### Check the following files
* [activity_main.xml](https://github.com/hannesa2/BottomSheetBehavior/blob/master/app/src/main/res/layout/activity_main.xml) (is like a template)
* [activity_main.java](https://github.com/hannesa2/BottomSheetBehavior/blob/master/app/src/main/java/com/mahc/custombottomsheet/MainActivity.java) (you can see how to listen for states)
* [styles.xml](https://github.com/hannesa2/BottomSheetBehavior/blob/master/app/src/main/res/values/styles.xml) (just the line <style name="AppTheme.NoActionBar">)
* [AndroidManifest.xml](https://github.com/hannesa2/BottomSheetBehavior/blob/master/app/src/main/AndroidManifest.xml) (just the line android:theme="@style/AppTheme.NoActionBar")

## What I did?
1. I took the code from BottomSheetBehavior.java from Support Library 23.4.0 and added one state for anchor mode, so now you have:<br>
STATE_HIDDEN<br>
STATE_COLLAPSED<br>
STATE_DRAGGING<br>
STATE_ANCHOR_POINT<br>
STATE_EXPANDED.<br><br>

2. Created Behaviors for FAB, ToolBars and ImageView.

## License
Licensed under the Apache License, Version 2.0
