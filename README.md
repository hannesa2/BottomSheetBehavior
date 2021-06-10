# BottomSheetBehavior like Google Maps for Android

Android Studio Project using Support Library focused on get Google Maps 3 states behavior including background image parallax and toolbars animations.

## Installation
In your module/project build.gradle file add<br>
```
dependencies {
   ...
   implementation 'com.mahc.custombottomsheetbehavior:googlemaps-like:0.9.1'
}
```

## Usage
[![CustomBottomSheetBehavior](https://raw.githubusercontent.com/akan44/CustomBottomSheetBehavior/master/CustomBottomSheetBehaviorLikeGoogleMaps3states.gif)]<br><br>

[Wiki under construction](https://github.com/miguelhincapie/CustomBottomSheetBehavior/wiki) but still with some info already, until I complete it you can take a look at the example (app module).<br><br>

### Check the following files
* [activity_main.xml](https://github.com/miguelhincapie/CustomBottomSheetBehavior/blob/master/app/src/main/res/layout/activity_main.xml) (is like a template)
* [activity_main.java](https://github.com/miguelhincapie/CustomBottomSheetBehavior/blob/master/app/src/main/java/com/mahc/custombottomsheet/MainActivity.java) (you can see how to listen for states)
* [styles.xml](https://github.com/miguelhincapie/CustomBottomSheetBehavior/blob/master/app/src/main/res/values/styles.xml) (just the line <style name="AppTheme.NoActionBar">)
* [AndroidManifest.xml](https://github.com/miguelhincapie/CustomBottomSheetBehavior/blob/master/app/src/main/AndroidManifest.xml) (just the line android:theme="@style/AppTheme.NoActionBar")

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
