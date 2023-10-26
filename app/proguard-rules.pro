# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
-ignorewarnings
-keepattributes *Annotation*
#-keepclassmembers,allowobfuscation class * {
#    @com.google.gson.annotations.SerializedName <fields>;
#}

#-keepclassmembers class * implements android.os.Parcelable {
#      public static final android.os.Parcelable$Creator *;
#   }
-keepnames class * implements android.os.Parcelable {
    public static final ** CREATOR;
}
-keepattributes SourceFile,LineNumberTable
-keep public class * extends java.lang.Exception
-keep class com.crashlytics.*.* { *; }
-keepattributes Signature
#-keep class com.appsflyer.** { *; }
-keep public class com.android.installreferrer.** { *; }
-keep class retrofit2.** { *; }
-keep interface retrofit2.** { *; }
#-keep class * extends com.google.protobuf.GeneratedMessageLite { *; }
-keep,allowobfuscation,allowshrinking class kotlin.coroutines.Continuation
-keepclassmembers class com.arash.coffeecraftapp.models.** { *; }

# POJOs used with GSON
# The variable names are JSON key values and should not be obfuscated
#-keepclassmembers class com.taskpin.android.models.** { *; }
#-keepclassmembers class com.taskpin.android.network.model.** { *; }