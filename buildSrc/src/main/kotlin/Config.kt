object Versions {
    const val kotlin = "1.3.70"
    internal const val androidPlugin = "4.0.0"

    internal const val androidxCore = "1.1.0"
    internal const val archCore = "2.1.0"
    internal const val room = "2.1.0-alpha03"
    internal const val lifecycle = "2.2.0-alpha04"
    internal const val lifecycleCommonJava8 = "2.1.0"
    internal const val lifecycleSaved = "1.0.0-alpha04"
    internal const val support = "1.1.0"
    internal const val supportRecyclerView = "1.1.0-beta04"
    internal const val supportRecyclerViewSelection = "1.1.0-alpha06"
    internal const val supportCardView = "1.0.0"
    internal const val supportLegacy = "1.0.0"
    internal const val supportDesign = "1.1.0-alpha10"

    internal const val glide = "4.9.0"

    internal const val retrofit = "2.2.0"
    internal const val okLogging = "3.9.0"

    internal const val constraintLaout = "2.0.0-beta4"

    internal const val rxJava = "2.2.9"
    internal const val rxAndroid = "2.1.0"

    internal const val timber = "4.7.1"

    internal const val easyPermission = "3.0.0"
    internal const val navigation = "2.2.0-alpha02"
    internal const val navigationSafe = "2.1.0-alpha05"

    internal const val exo = "2.8.2"
    internal const val coroutines = "1.3.0"

    internal const val dagger = "2.28.1"
    internal const val fragmentKtx = "1.3.0-alpha01"

    internal const val viewPager2 = "1.0.0"

}

object Url {
    const val jitpack = "https://jitpack.io"
}

object BuildPlugins {
    const val androidPlugin = "com.android.tools.build:gradle:${Versions.androidPlugin}"
    const val navigationSafe = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigationSafe}"
    const val realm = "io.realm:realm-gradle-plugin:10.7.0-SNAPSHOT"
}

object Android {
    const val minSdk = 21
    const val targetSdk = 29
    const val applicationId = "com.example.cleanarchitecture"
    const val versionCode = 1
    const val versionName = "1.0.1"
}

object GradlePlugins {
    const val android = "com.android.application"
    const val kotlin = "kotlin"
    const val kotlinAndroid = "android"
    const val kotlinExt = "android.extensions"
    const val kotlinApt = "kapt"
    const val javaLib = "java-library"
    const val androidLib = "com.android.library"
    const val navigationSafe = "androidx.navigation.safeargs"
    const val navigationSafeKotlin = "androidx.navigation.safeargs.kotlin"
    const val realm = "realm-android"
    const val kotlinKapt = "kotlin-kapt"
}

object Modules {
    const val domain = ":domain"
    const val data = ":data"
}

object AndroidJUnit {
    const val runner = "androidx.test.runner.AndroidJUnitRunner"
}

object BuildType {
    const val debug = "debug"
    const val release = "release"

    const val minifyRelease = false
    const val proguardRelease = "proguard-rules.pro"

    const val minifyDebug = false
    const val proguardDebug = "proguard-rules.pro"
}

object Libs {
    //KTX
    const val ktx = "androidx.core:core-ktx:${Versions.androidxCore}"
    const val stdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
    // Support libs
    const val supportAnnotations = "androidx.annotation:annotation:${Versions.support}"
    const val supportAppCompat = "androidx.appcompat:appcompat:${Versions.support}"
    const val supportRecyclerview = "androidx.recyclerview:recyclerview:${Versions.supportRecyclerView}"
    const val supportRecyclerviewSelection = "androidx.recyclerview:recyclerview-selection:${Versions.supportRecyclerViewSelection}"
    const val supportCardview = "androidx.cardview:cardview:${Versions.supportCardView}"
    const val supportDesign = "com.google.android.material:material:${Versions.supportDesign}"
    const val supportLegacyV4 = "androidx.legacy:legacy-support-v4:${Versions.supportLegacy}"

    // Constraint Layout
    const val constraintlayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLaout}"

    // databinding compiler
    const val bindingCompiler = "androidx.databinding:databinding-compiler:${Versions.androidPlugin}"

    // room database
    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val roomRxjava2 = "androidx.room:room-rxjava2:${Versions.room}"

    // lifecycle
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime:${Versions.lifecycle}"
    const val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata:${Versions.lifecycle}"
    const val lifecycleLiveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel:${Versions.lifecycle}"
    const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    const val lifecycleJava8 = "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycle}"
    const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle}"
    const val lifecycleSavedState = "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Versions.lifecycleSaved}"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragmentKtx}"

    // RxKotlin & RxJava
    const val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroid}"
    const val rxJava = "io.reactivex.rxjava2:rxjava:${Versions.rxJava}"

    // retrofit
    const val retrofitRuntime = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val retrofitAdapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
    const val okLogging = "com.squareup.okhttp3:logging-interceptor:${Versions.okLogging}"

    // Navigation
    const val navigationRuntime = "androidx.navigation:navigation-runtime:${Versions.navigation}"
    const val navigationRuntimeKtx = "androidx.navigation:navigation-runtime-ktx:${Versions.navigation}"
    const val navigationFragment = "androidx.navigation:navigation-fragment:${Versions.navigation}"
    const val navigationFragmentKtx = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val navigationUi = "androidx.navigation:navigation-ui:${Versions.navigation}"

    // Glide for image loader
    const val glideRuntime = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"

    // Permission for AndroidX
    const val permission = "pub.devrel:easypermissions:${Versions.easyPermission}"

    //
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"

    // Dagger 2
    const val daggerCore = "com.google.dagger:dagger:${Versions.dagger}"
    const val daggerAndroid = "com.google.dagger:dagger-android:${Versions.dagger}"
    const val daggerSupport = "com.google.dagger:dagger-android-support:${Versions.dagger}"

    const val daggerProcessor = "com.google.dagger:dagger-android-processor:${Versions.dagger}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"

    const val viewpager2 = "androidx.viewpager2:viewpager2:${Versions.viewPager2}"

}